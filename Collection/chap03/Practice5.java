package chap03;

import java.util.List;
import java.util.ListIterator;

/**
 * practice 3.5
 */
public class Practice5<AnyType> {

  public static <AnyType extends Comparable<? super AnyType>>
  void union(List<AnyType> L1, List<AnyType> L2, List<AnyType> Result) {
    ListIterator<AnyType> iterL1 = L1.listIterator();
    ListIterator<AnyType> iterL2 = L2.listIterator();

    AnyType itemL1 = null, itemL2 = null;

    //获取L1,L2中的第一项
    if (iterL1.hasNext() && iterL2.hasNext()) {
      itemL1 = iterL1.next();
      itemL2 = iterL2.next();
    }
    while (itemL1 != null && itemL2 != null) {
      int compareResult = itemL1.compareTo(itemL2);

      if(compareResult == 0){
        Result.add(itemL1);
        itemL1 = iterL1.hasNext() ? iterL1.next() : null;
        itemL2 = iterL2.hasNext() ? iterL2.next() : null;
      }else if (compareResult < 0){
        Result.add(itemL1);
        itemL1 = iterL1.hasNext() ? iterL1.next() : null;
      }else{
        Result.add(itemL2);
        itemL2 = iterL2.hasNext() ? iterL2.next() : null;
      }
    }
  }
}
