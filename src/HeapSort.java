class HeapSort extends SortingAlgorithm {

  public HeapSort(){
    super();
  }

  @Override
  public void sort(double[] array){
    int n = array.length;
    long startTime = System.currentTimeMillis();
    double[] tree = new double[n];
    //build tree
    for(int i = 0; i < n; i++){
      tree[i] = array[i];
      checkBU(tree, i);
    }
    //OK!
    //main loop
    do {
      //"remove" root element
      double aux = tree[n-1];
      tree[n-1] = tree[0];
      tree[0] = aux;
      addCopy(3);
      n -= 1;
      //check
      checkTD(tree, n, 0);
    } while(n > 2);
    long stopTime = System.currentTimeMillis();
    addTime(stopTime - startTime);
  }

  private void checkBU(double[] tree, int i){
    int pos = i, par;
    while((par = parent(pos)) >= 0){
      addComp();
      if(tree[pos] > tree[par]){
        double aux = tree[pos];
        tree[pos] = tree[par];
        tree[par] = aux;
        pos = par;
      } else {
        break;
      }
    }
  }

  private void checkTD(double[] tree, int n, int i){
    int pos = i, chd, lc, rc;
    while(Math.floor(Math.log(pos+1)/Math.log(2)) < Math.floor(Math.log(n)/Math.log(2))){
      lc = 2*pos+1;
      rc = 2*pos+2;
      addComp();
      if((lc < n)&&(tree[lc] > tree[pos])&&(tree[lc] >= tree[rc])){
        double aux = tree[lc];
        tree[lc] = tree[pos];
        tree[pos] = aux;
        addCopy(3);
        pos = lc;
      } else if((rc < n)&&(tree[rc] > tree[pos])&&(tree[lc] <= tree[rc])){
        double aux = tree[rc];
        tree[rc] = tree[pos];
        tree[pos] = aux;
        pos = rc;
      } else {
        break;
      }
    }
  }

  private int parent(int i){
    i = i+1;
    int h = (int)Math.floor(Math.log(i)/Math.log(2));
    return (int) Math.pow(2, h-1)+(((int)(i-Math.pow(2, h)))/2)-1;
  }

  @Override
  public void sort(int[] array){
    double[] darray = new double[array.length];
    for(int i = 0; i < array.length; i++){ darray[i] = array[i]; }
    sort(darray);
  }
}
