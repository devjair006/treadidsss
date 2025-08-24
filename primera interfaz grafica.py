from tkinter import*
import math



def calculo():
    arista = lbl1.get()
    n_lados = lbl2.get()
    entrada3.insert(0,final)
    
    
    angulo_central = 360/n_lados
    mitad_angulo = angulo_central/2

def a_radianes(mitad_angulo):
    return math.radians(mitad_angulo)

def tangente(mitad_angulo):
    return math.tan(a_radianes(mitad_angulo))
    tan_ang = tangente(mitad_angulo)

    Apotema = arista/(2*tan_ang)

    Perimetro1 = 12*(n_lados*arista)
    Perimetro = n_lados*arista

    raices_alt = (25+(11*math.sqrt(5)))/10
    raiz_alt = math.sqrt(raices_alt)*(arista/2)


    Area = 12*((Perimetro*Apotema)/2)
    Area_base = (Perimetro*Apotema)/2

    Volumen = 12*((Area_base*raiz_alt)/3)
def final():
    print(f"El perimetro del dodecaedro es de : {Perimetro1} cm , el área es de : {Area} cm² , el volumen es de {Volumen}: cm³")
#----------------------------------------------------------------------------------------------------------------------
raiz = Tk()#para crear la ventana
raiz.title("APYunikua GEO")#para el titulo de la ventana
raiz.resizable(0,0) #esta edita por bulianos si se puede o no editar el tamanio de la ventana
raiz.iconbitmap ("geo.ico")#este es el .ico de la app
raiz.geometry("850x450") #tamanio de la ventana
raiz.config(bg="beige")#color de la ventana

#------------------------------------------------------------------------------------------------------------------------------
texto1= Label(raiz,text='Bienvenido/a, esta App Yunikua GEO app es funcional para calcular datos de un dodecaedro')
texto1.config(bg="gray",)
texto1.pack()

lbl1= Label(raiz, text="Ingrese la longitud de la arista del dodecaedro:")
lbl1.config(bg="gray")
lbl1.place(x=0, y=50, width=400,height=40)

entrada1= Entry(raiz)
entrada1.config(bg="sandybrown")
entrada1.place(x=450, y=50, width=400,height=40)
#-----------------------------------------------------------------------------------------------------------------------------------------------
lbl2= Label(raiz, text="Ingrese el numero de lados de las caras de su dodecaedro:")
lbl2.config(bg="gray")
lbl2.place(x=0, y=200, width=400,height=40)

entrada2= Entry(raiz)
entrada2.config(bg="sandybrown")
entrada2.place(x=450, y=200, width=400,height=40)
#--------------------------------------------------------------------------------------------------------------------------------------------------
lbl3= Label(raiz, text="resultado:")
lbl3.config(bg="gray")
lbl3.place(x=0, y=350, width=400,height=40)

entrada3= Entry(raiz)
entrada3.config(bg="sandybrown")
entrada3.place(x=450, y=350, width=400,height=80)
#------------------------------------------------------------------------------------------------------------------------------------------------------
boton = Button(raiz, text="calcular", command=calculo)
boton.config(bg="gray", fg="black")
boton.place(x=800, y=250)
#------------------------------------------------------------------------
#btn = Button(raiz, text='presiona el botton', command=mensaje)
#btn.pack()
raiz.mainloop() #ciclo principal de la ventana+