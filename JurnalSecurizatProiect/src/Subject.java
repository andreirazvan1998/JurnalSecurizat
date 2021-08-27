
public interface Subject {
		public void notifyAllOb();
		
		/**
		  Se adauga un nou observator in lista de observatori ai subiectului. 
		  obs un obiect care implementeaza interfata Observer. 
		 */
		public void addObservator(Observator obs);
		
		/**
		  Se sterge un observator in lista de observatori ai subiectului.
		   obs un obiect care implementeaza interfata Observer. 
		 */
		public void remmoveObservator(Observator obs);
}
