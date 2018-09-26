import java.util.Arrays;

class QuickSortI extends SortingAlgorithm {

  public QuickSortI(){
    super();
  }

  @Override
  public void sort(int[] array){
    long startTime = System.currentTimeMillis();

    sortR(array, 0, array.length-1);

    long stopTime = System.currentTimeMillis();
    addTime(stopTime - startTime);

  }

  public void sort(int[] array, String flag){

    long startTime = System.currentTimeMillis();

    if(flag.equalsIgnoreCase("R")){
      sortR(array, 0, array.length-1);
    } else if(flag.equalsIgnoreCase("M")){
      sortM(array, 0, array.length-1);
    } else if(flag.equalsIgnoreCase("I") || flag.equalsIgnoreCase("T")){
      sortI(array, 0, array.length-1);
    }

    long stopTime = System.currentTimeMillis();
    addTime(stopTime - startTime);

  }

  public void sortR(int[] array, int start, int end){
    int lo = start, hi = end;
    //pivot selection
    int pivot = array[(lo+hi)/2];
    addCopy();
    //...
    while(lo <= hi) {
      while(array[lo] < pivot){
        addComp();
        lo++;
      }
      while(array[hi] > pivot){
        addComp();
        hi--;
      }
      if(lo <= hi){
        int aux = array[lo];
        array[lo] = array[hi];
        array[hi] = aux;
        addCopy(3);
        lo++;
        hi--;
      }
    }
    if(start < lo-1) sortR(array, start, lo-1);
    if(lo < end) sortR(array, lo, end);
  }

  public void sortM(int[] array, int start, int end){
    int lo = start, hi = end;
    int nsamples = 5;
    int[] samples = new int[nsamples];
    for(int i = 0; i < nsamples; i++){
      samples[i] = array[lo + ((int)((hi-lo)*(((float)i)/(nsamples-1))))];
    }
    InsertionSort is = new InsertionSort();
    is.sort(samples);
    addComp(is.getComp());
    addCopy(is.getCopy());
    int pivot = samples[nsamples/2];
    //...
    while(lo <= hi) {
      while(array[lo] < pivot){
        addComp();
        lo++;
      }
      while(array[hi] > pivot){
        addComp();
        hi--;
      }
      if(lo <= hi){
        int aux = array[lo];
        array[lo] = array[hi];
        array[hi] = aux;
        addCopy(3);
        lo++;
        hi--;
      }
    }
    if(start < lo-1) sortM(array, start, lo-1);
    if(lo < end) sortM(array, lo, end);
  }

  public void sortI(int[] array, int start, int end){
    int lo = start, hi = end;
    int tsh = 10;
    if(hi - lo < tsh){
      InsertionSort is = new InsertionSort();
      is.sort(array);
      addComp(is.getComp());
      addCopy(is.getCopy());
    } else {
      //pivot selection
      int pivot = array[(lo+hi)/2];
      addCopy();
      //...
      while(lo <= hi) {
        while(array[lo] < pivot){
          addComp();
          lo++;
        }
        while(array[hi] > pivot){
          addComp();
          hi--;
        }
        if(lo <= hi){
          int aux = array[lo];
          array[lo] = array[hi];
          array[hi] = aux;
          addCopy(3);
          lo++;
          hi--;
        }
      }
      if(start < lo-1) sortI(array, start, lo-1);
      if(lo < end) sortI(array, lo, end);
    }
  }
}
