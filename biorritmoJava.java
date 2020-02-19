import java.util.*;
import java.awt.*;
import javax.swing.JFrame;

	public class biorritmoJava extends JFrame {
		
		public static void main(String [] args){
			biorritmoJava j = new biorritmoJava();
		}
		
		public biorritmoJava(){
			super("Grafico de muestra");
			setSize(900,560);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			FlowLayout en = new FlowLayout();
			setLayout(en);
		}
		
		public void paint(Graphics g) {
			
			//Valores para trabajar
			final int ancho = getWidth();
			final int alto = getHeight();
			int p = DiasVivo();
			
			//#################### EJES DEL GRAFICO ############################################
			g.drawLine(ancho/2,0,ancho/2,alto);
			g.drawLine(0,alto/2,ancho,alto/2);
			g.drawString("",ancho-15,alto/2+15);
			g.drawString("Hoy",ancho/2-15,15);
			
			// Valores de para realizar las operaciones
			double w  = 0.005; 
			double ult_y = alto*0.4*Math.sin(-ancho/2*w);
			double ult_x = -ancho/2;
			
			//#################### CICLO FISICO ################################################
			g.setColor(Color.GREEN); //Grafica de color verde
			
			for (double x = -ancho/2 ; x<ancho/2 ; x+=ancho/30 , p++) {
				double y = alto*0.4*Math.sin(2*Math.PI*p / 23);
				g.drawLine((int)(ult_x+ancho/2), (int)(alto/2-ult_y), (int)(x+ancho/2), (int)(alto/2-y));
				ult_x = x;
				ult_y = y;
			}
			
			// Resetea valores para el siguiente grafico
			ult_y = alto*0.4*Math.sin(-ancho/2*w);
			ult_x = -ancho/2;
			
			//#################### CICLO EMOCIONAL ########################################### 
			g.setColor(Color.RED); //Grafica de color rojo
			
			for (double x = -ancho/2 ; x<ancho/2 ; x+=ancho/30 , p++) {
				double y = alto*0.4*Math.sin(2*Math.PI*p / 28);
				g.drawLine((int)(ult_x+ancho/2), (int)(alto/2-ult_y), (int)(x+ancho/2), (int)(alto/2-y));
				ult_x = x;
				ult_y = y;
			}
			
			//Resetea valores para el siguiente grafico
			ult_y = alto*0.4*Math.sin(-ancho/2*w);
			ult_x = -ancho/2;
			
			//#################### CICLO INTELECTUAL #########################################
			g.setColor(Color.BLUE); //Grafica de color azul
			
			for (double x = -ancho/2 ; x<ancho/2 ; x+=ancho/30 , p++) {
				double y = alto*0.4*Math.sin(2*Math.PI*p / 33);
				g.drawLine((int)(ult_x+ancho/2), (int)(alto/2-ult_y), (int)(x+ancho/2), (int)(alto/2-y));
				ult_x = x;
				ult_y = y;
			}  
		}
		
		public static int DiasVivo(){
			
			Scanner teclado = new Scanner(System.in);
			Calendar calendar = Calendar.getInstance();
			java.util.Date hoy = new Date(); //Fecha de hoy 
			int d =0; //inicializar dias
			int m =0; //inicializar meses
			int a =0; //inicializar años
			int ac = calendar.get(Calendar.YEAR); //Año actual
			int mes = calendar.get(Calendar.MONTH)+1; //Mes actual del año
			int dia = calendar.get(Calendar.DAY_OF_MONTH); //Dia del mes actual
			final long MXD = 24 * 60 * 60 * 1000; //Milisegundos de un día
			
			
			//AÑOS
			
			while (a<ac-110|a>ac){
				System.out.print("Ingrese año de nacimiento: ");
				a= teclado.nextInt();
			}
			
			//MESES
			
			//Mes del año pasado
			if (a<ac){ //Si año es menor al año actual
				while (m<1 | m>12){
					System.out.print("Ingrese mes de nacimiento: ");
					m= teclado.nextInt();
				}
			}
			
			//Mes del año actual
			if (a==ac){ //Si año es igual a año actual
				while (m<1 | m>mes){ // Mientras mes actual sea menor que mes
					System.out.print("Ingrese mes de nacimiento: ");
					m= teclado.nextInt();
				}
			}
			
			// DIAS
			
			//Dependiendo del año y el mes los dias cambian 
			
			
			if(a<ac){ //En el año anterior "Si año es menor que año actual"
				
				//Si es Abril, Junio, Septiembre o Noviembre
				if (m==4|m==6|m==9|m==11){
					while (d<1|d>30){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			
				// Si es febrero en año bisiesto
				if (m==2 & a%4==0){
					while(d<1|d>29){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			
				// Si es febrero en un año no bisiesto
				if (m==2 & a%4!=0){
					while(d<1|d>28){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			
				// Si no es ninguna de las anteriores
				else{
					while(d<1|d>31){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			}
			
			if(a==ac){ //En el año actual "Si año es igual a año actual"
			
				if (m==4|m==6|m==9|m==11){
					while (d<1|d>30|d>=dia){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			
				// Si es febrero en año bisiesto
				if (m==2 & a%4==0){
					while(d<1|d>29|d>=dia){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			
				// Si es febrero en un año no bisiesto
				if (m==2 & a%4!=0){
					while(d<1|d>28|d>=dia){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			
				// Si no es ninguna de las anteriores
				else{
					while(d<1|d>31|d>=dia){
						System.out.print("Ingrese dia de nacimiento: ");
						d= teclado.nextInt();
					}
				}
			}
			
			Calendar nacimiento = new GregorianCalendar(a, m-1, d); //La fecha convertida em New gregorian calendar
			java.sql.Date fecha = new java.sql.Date(nacimiento.getTimeInMillis());
			long dv = ( hoy.getTime() - fecha.getTime() )/MXD;
			
			System.out.println("Usted lleva "+dv+" dias vivo ");
			
			return (int)(dv-15);
		}
	}
   
