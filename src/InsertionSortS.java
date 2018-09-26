public class InsertionSortS extends SortingAlgorithm
{
  public InsertionSortS()
  {
    super();
  }

  @Override
  public void sort(String[] array)
  {
    int i;//contador e índice do vetor
    String id; //elemento que será comparado
    int j;//contador e índice do vetor
    long startTime = System.currentTimeMillis();//Contador inicial do tempo de processamento
    for (i = 1 ; i < array.length; i++)
    {
      id = array[i];

      for (j = (i - 1); (j >= 0) && (array[j].compareTo(id) > 0); j--)
      {
        array[j + 1] = array[j];
        array[j] = id;
        addCopy(3);
      }
    }
    long stopTime = System.currentTimeMillis();
    addTime(stopTime - startTime);
  }
}
