
public class ParkingLotOpenAddressing {

    String[] spots;
    int size;

    public ParkingLotOpenAddressing(int capacity){

        size=capacity;
        spots=new String[capacity];
    }

    int hash(String plate){

        return Math.abs(plate.hashCode())%size;
    }

    public int park(String plate){

        int index=hash(plate);

        while(spots[index]!=null){

            index=(index+1)%size;
        }

        spots[index]=plate;

        return index;
    }

    public void exit(String plate){

        for(int i=0;i<size;i++){

            if(plate.equals(spots[i])){
                spots[i]=null;
            }
        }
    }

    public static void main(String[] args){

        ParkingLotOpenAddressing p=new ParkingLotOpenAddressing(10);

        System.out.println("Parked at: "+p.park("ABC123"));
    }
}