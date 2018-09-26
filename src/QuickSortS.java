import java.util.Arrays;

class QuickSortS extends SortingAlgorithm {

  public QuickSortS(){
    super();
  }

  @Override
  public void sort(String[] array){
    long startTime = System.currentTimeMillis();

    sortR(array, 0, array.length-1);

    long stopTime = System.currentTimeMillis();
    addTime(stopTime - startTime);

  }

  public void sort(String[] array, String flag){

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

  public void sortR(String[] array, int start, int end){
    int lo = start, hi = end;
    //pivot selection
    String pivot = array[(lo+hi)/2];
    addCopy();
    //...
    while(lo <= hi) {
      while(array[lo].compareTo(pivot) < 0){
        addComp();
        lo++;
      }
      while(array[hi].compareTo(pivot) > 0){
        addComp();
        hi--;
      }
      if(lo <= hi){
        String aux = array[lo];
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

  public void sortM(String[] array, int start, int end){
    int lo = start, hi = end;
    //pivot selection
    int nsamples = 5;
    String[] samples = new String[nsamples];
    for(int i = 0; i < nsamples; i++){
      samples[i] = array[start + ((int)((end-start)*(((float)i)/(nsamples-1))))];
    }
    sortR(samples, 0, nsamples-1);
    String pivot = samples[nsamples/2];
    //...
    while(lo <= hi) {
      while(array[lo].compareTo(pivot) < 0){
        addComp();
        lo++;
      }
      while(array[hi].compareTo(pivot) > 0){
        addComp();
        hi--;
      }
      if(lo <= hi){
        String aux = array[lo];
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

  public void sortI(String[] array, int start, int end){
    int lo = start, hi = end;
    int tsh = 10;
    if(hi - lo < tsh){
      InsertionSort is = new InsertionSort();
      is.sort(array);
      addComp(is.getComp());
      addCopy(is.getCopy());
    } else {
      //pivot selection
      String pivot = array[(lo+hi)/2];
      addCopy();
      //...
      while(lo <= hi) {
        while(array[lo].compareTo(pivot) < 0){
          addComp();
          lo++;
        }
        while(array[hi].compareTo(pivot) > 0){
          addComp();
          hi--;
        }
        if(lo <= hi){
          String aux = array[lo];
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
