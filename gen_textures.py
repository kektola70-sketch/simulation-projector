import os
from PIL import Image

# Путь к папке (исправь 'yourname' на свой ник)
path = "src/main/resources/assets/simmod/textures/block/"

if not os.path.exists(path):
    os.makedirs(path)

def create_tex(name, pixels):
    img = Image.new('RGBA', (16, 16))
    img.putdata(pixels)
    img.save(os.path.join(path, name + ".png"))
    print(f"Создана текстура: {name}.png")

# Цвета
METAL = (40, 40, 40, 255)
LIGHT_METAL = (70, 70, 70, 255)
NEON = (0, 242, 255, 255)
GREEN = (0, 255, 65, 255)
BLACK = (10, 10, 10, 255)
TRANS = (0, 0, 0, 0)
WHITE = (255, 255, 255, 255)

# 1. Стекло (Рамка и блик)
glass = [METAL if (x==0 or x==15 or y==0 or y==15) else TRANS for y in range(16) for x in range(16)]
glass[1+1*16] = NEON; glass[14+1*16] = NEON; glass[1+14*16] = NEON; glass[14+14*16] = NEON
create_tex("sim_glass", glass)

# 2. Провод (Центральная линия)
wire = [TRANS for _ in range(256)]
for y in range(16):
    wire[7 + y*16] = METAL; wire[8 + y*16] = NEON; wire[9 + y*16] = METAL
create_tex("sim_wire", wire)

# 3. Кодовая машина (Экран, кнопки, корпус)
side = [METAL if (y%7==0) else LIGHT_METAL for y in range(16) for x in range(16)]
create_tex("code_machine_side", side)
create_tex("code_machine_bottom", [METAL]*256)

top = [METAL]*256
for i in range(2, 14, 3):
    for j in range(2, 14, 3):
        top[i + j*16] = GREEN if i==5 else LIGHT_METAL
create_tex("code_machine_top", top)

front = [METAL]*256
for y in range(4, 11):
    for x in range(3, 13):
        front[x + y*16] = BLACK
front[5+6*16] = GREEN; front[8+8*16] = GREEN; front[4+5*16] = GREEN
create_tex("code_machine_front", front)

# 4. Проектор (Линза, радиатор)
p_side = [METAL if (x%2==0) else LIGHT_METAL for y in range(16) for x in range(16)]
create_tex("sim_projector_side", p_side)
create_tex("sim_projector_bottom", [METAL]*256)

p_front = [METAL]*256
p_front[4+8*16]=NEON; p_front[8+8*16]=NEON; p_front[12+8*16]=NEON
create_tex("sim_projector_front", p_front)

p_top = [METAL]*256
for y in range(16):
    for x in range(16):
        dist = ((x-7.5)**2 + (y-7.5)**2)**0.5
        if dist < 6: p_top[x+y*16] = (0, 100, 150, 255)
        if dist < 4: p_top[x+y*16] = NEON
p_top[6+6*16] = WHITE
create_tex("sim_projector_top", p_top)