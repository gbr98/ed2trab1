public class InsertionSort extends SortingAlgorithm
{
  public InsertionSort()
  {
    super();
  }

  @Override
  public void sort(double[] array)
  {
    int i;//contador e índice do vetor
    double id; //elemento que será comparado
    int j;//contador e índice do vetor
    long startTime = System.currentTimeMillis();//Contador inicial do tempo de processamento
    for (i = 1 ; i < array.length; i++)
    {
      id = array[i];

      for (j = (i - 1); (j >= 0) && (array[j] > id); j--)
      {
        array[j + 1] = array[j];
        array[j] = id;
        addCopy(3);
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
