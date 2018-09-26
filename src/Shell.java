public class Shell extends SortingAlgorithm{

    @Override
    public void sort (double [] array){
        int i, j, gap;
        long startTime = System.currentTimeMillis();
        double aux;
        for(gap =1; gap<array.length; gap=3*gap+1);
        while(gap>1){
            gap = gap/3;
            for(i=gap;i<array.length;i++){
                aux = array[i];
                addCopy();
                j = i-gap;
                addCopy();
                while(j>=0 && aux<array[j]){
                    addComp();
                    array[j+gap] = array[j];
                    addCopy();
                    j = j-gap;
                }
                array[j+gap] = aux;
                addCopy();
            }
        }
        long stopTime = System.currentTimeMillis();
        addTime(stopTime - startTime);
    }

    @Override
    public void sort(int[] array){
      double[] darray = new double[array.length];
      for(int i = 0; i < array.length; i++){ darray[i] = array[i]; }
      sort(darray);
    }
}
