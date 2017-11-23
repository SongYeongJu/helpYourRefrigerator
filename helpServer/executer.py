class Executer:
    curtemp=10
    setTemp=10
    mode=0
    
    def __init__(self, tcpServer):
        self.andRaspTCP = tcpServer
 
    def startCommand(self, command):
        clist=command.split("%")

        if clist[0]=='changeTemp':
            setTemp=int(clist[1])
            mode=0
            
        else if clist[0]=='getTemp':
            self.andRaspTCP.sendAll("returnTemp%"+curtemp)

        else if clist[0]=='getMode':
            self.andRaspTCP.sendAll("returnMode%"+mode)

        else if clist[0]=='changeMode':
            mode=int(clist[1])
