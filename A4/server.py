import socket, time
from datetime import datetime

HOST, PORT = '', 9999

s = socket.socket()
s.bind((HOST, PORT))
s.listen()

num = int(input("Enter number of clients: "))
clients = [s.accept()[0] for _ in range(num)]

# THIS INFINITE LOOP IS A DAEMON (SIMPLIFIED)
while True:
    times = []

    for c in clients:
        times.append(float(c.recv(1024).decode()))

    print(times)
    server_time = time.time()
    avg = (sum(times) + server_time) / (len(times) + 1)

    for i, t in enumerate(times):
        print(f"Client {i+1} Time:", time.ctime(t))

    print("Server Time:", time.ctime(server_time))
    print("Average Time:", time.ctime(avg))
    print("\n")

    for i, c in enumerate(clients):
        c.send(str(avg - times[i]).encode())


