public class Merge extends SortingAlgorithm {

    public Merge(){
    super();
  }

    public void auxSort (double[] array, int ini, int meio, int fim){

        int tam = fim-ini+1;
        int m = meio+1;
        int i = ini;
        int a = 0;
        double[] aux = new double[array.length];

        while (i<meio+1 || m<fim +1){
            if (i == meio+1){
                aux[a] = array [m];
                addCopy();
                m++;
                a++;
                addComp();
            }
            else if (m == fim+1){
                aux[a] = array[i];
                addCopy();
                i++;
                a++;
                addComp(2);

            }
            else if (array[i] <= array[m]){
                aux[a] = array[i];
                addCopy();
                i++;
                a++;
                addComp(3);
            }
            else{
                aux[a] = array[m];
                addCopy();
                m++;
                a++;
                addComp(3);
            }
        }
        for (int k = ini; k <= fim; k++){
            array[k] = aux[k-ini];
            addCopy();
        }
    }

    @Override
    public void sort(double[] array)
    {
      long startTime = System.currentTimeMillis();

      sortR(array, 0, array.length-1);

      long stopTime = System.currentTimeMillis();
      addTime(stopTime - startTime);
    }

    @Override
    public void sort(int[] array){
      double[] darray = new double[array.length];
      for(int i = 0; i < array.length; i++){ darray[i] = array[i]; }
      sort(darray);
    }

    public void sortR (double[] array, int ini, int fim){
        int meio;

        if (ini<fim){
            meio = (ini+fim)/2;
            sortR (array, ini, meio);
            sortR (array, meio+1, fim);

            auxSort (array, ini, meio, fim);
        }



    }
}
