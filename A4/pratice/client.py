import socket , time ,random
HOST = input("Enter the ip address:")
PORT = 9999

c = socket.socket()
c.connect((HOST,PORT))

while True:
    
    current_time = time.time() + random.uniform(-5,5)
    c.send(str(current_time).encode())

    diff = float(c.recv(1024).decode())
    accurate_time = current_time + diff

    print(f"Client Time : {time.ctime(current_time)}")
    print(f"Accurate Time :{time.ctime(accurate_time)}")
    print("\n")    
    time.sleep(5)