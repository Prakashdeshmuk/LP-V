
import socket , time

HOST , PORT = '',9999
c = socket.socket()
c.bind((HOST,PORT))
c.listen()

num = int(input("Enter number of clients:"))
clients = [c.accept()[0] for _ in range(num)]

while True :
    times = []

    for client in clients:
        times.append(float(client.recv(1024).decode()))

    server_time = time.time()
    avg_time = (sum(times) + server_time) / (len(clients) + 1)
    

    for index , client in enumerate(clients):
        print(f"client {index} time: {time.ctime(times[index])}")
        client.send(str(avg_time-times[index]).encode())

    print(f"Server current time: {time.ctime(server_time)}")
    print(f"accurate time:{time.ctime(server_time)}")   
    print("\n") 
