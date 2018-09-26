class SortingAlgorithm {

  private int comp;
  private int copy;
  private long time;

  public SortingAlgorithm(){
    this.comp = 0;
    this.copy = 0;
    this.time = 0;
  }

  public void sort(Deputies[] array){}

  public void sort(double[] array){}

  public void sort(int[] array){}

  public void sort(String[] array){}

  public void addComp(){
    this.comp += 1;
  }

  public void addCopy(){
    this.copy += 1;
  }

  public void addComp(int n){
    this.comp += n;
  }

  public void addCopy(int n){
    this.copy += n;
  }

  public void addTime(long time){
    this.time += time;
  }

  public int getComp(){
    return this.comp;
  }

  public int getCopy(){
    return this.copy;
  }

  public long getTime(){
    return this.time;
  }

}
