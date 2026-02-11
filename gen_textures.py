import os
from PIL import Image

# Путь к папке с текстурами
path = "src/main/resources/assets/simmod/textures/block/"

# Создаем папки, если их нет
if not os.path.exists(path):
    os.makedirs(path)

def create_tex(name, pixels):
    img = Image.new('RGBA', (16, 16))
    img.putdata(pixels)
    img.save(os.path.join(path, name + ".png"))
    print(f"Создано: {name}.png")

# Цвета (R, G, B, A)
M = (40, 40, 40, 255)      # Темный металл
L = (80, 80, 80, 255)      # Светлый металл
N = (0, 240, 255, 255)     # Неон (Голубой)
G = (0, 255, 70, 255)      # Зеленый код
B = (10, 10, 10, 255)      # Черный экран
W = (255, 255, 255, 255)   # Белый блик
T = (0, 0, 0, 0)           # Прозрачность

# 1. Стекло
glass = [M if (x==0 or x==15 or y==0 or y==15) else T for y in range(16) for x in range(16)]
glass[1+1*16]=N; glass[14+1*16]=N; glass[1+14*16]=N; glass[14+14*16]=N
create_tex("sim_glass", glass)

# 2. Провод
wire = [T for _ in range(256)]
for y in range(16):
    wire[7+y*16]=M; wire[8+y*16]=N; wire[9+y*16]=M
create_tex("sim_wire", wire)

# 3. Кодовая машина
create_tex("code_machine_bottom", [M]*256)
create_tex("code_machine_side", [M if y%7==0 else L for y in range(16) for x in range(16)])

top = [M]*256
for i in range(2, 14, 3):
    for j in range(2, 14, 3):
        top[i+j*16] = G if i==5 else L
create_tex("code_machine_top", top)

front = [M]*256
for y in range(4, 11):
    for x in range(3, 13): front[x+y*16]=B
front[5+6*16]=G; front[9+5*16]=G; front[7+9*16]=G
create_tex("code_machine_front", front)

# 4. Проектор
create_tex("sim_projector_bottom", [M]*256)
create_tex("sim_projector_side", [M if x%2==0 else L for y in range(16) for x in range(16)])

p_front = [M]*256
p_front[4+8*16]=N; p_front[8+8*16]=N; p_front[12+8*16]=N
create_tex("sim_projector_front", p_front)

p_top = [M]*256
for y in range(16):
    for x in range(16):
        d = ((x-7.5)**2 + (y-7.5)**2)**0.5
        if d < 6: p_top[x+y*16]=(0, 80, 120, 255)
        if d < 4: p_top[x+y*16]=N
p_top[6+6*16]=W
create_tex("sim_projector_top", p_top)