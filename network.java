public class network {

    public int cost;
    public String name;

     public network (String name, int cost){

         this.cost = cost;
         this.name = name;
     }

     public int compare(network x, network y) {
         if (x.cost < y.cost) {
             return -1;
         }

         if(x.cost> y.cost){
             return 1;
         }
         else return 0;
     }

     public int compareTo( network x){
         if(this.cost < x.cost){
             return -1;
         }

         if(this.cost > x.cost){
             return 1;
         }
         else return 0;
     }

     public void setCost(int cost){
         this.cost = cost;
     }
}

