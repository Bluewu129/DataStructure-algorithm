package chap03;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * practice 3.4
 */
public class Practice4<AnyType> {


  public static <AnyType extends Comparable<? super AnyType>>
  void intersection(List<AnyType> L1, List<AnyType> L2, List<AnyType> Intersect) {
    ListIterator<AnyType> iterL1 = L1.listIterator();
    ListIterator<AnyType> iterL2 = L2.listIterator();

    AnyType itemL1 = null, itemL2 = null;

    if (iterL1.hasNext() && iterL2.hasNext()) {
      itemL1 = iterL1.next();
      itemL2 = iterL2.next();
    }

    while (itemL1 != null && itemL2 != null) {
      int compareResult = itemL1.compareTo(itemL2);

      if (compareResult == 0) {
        Intersect.add(itemL1);
        itemL1 = iterL1.hasNext() ? iterL1.next() : null;
        itemL2 = iterL2.hasNext() ? iterL2.next() : null;
      } else if (compareResult < 0) {
        itemL1 = iterL1.hasNext() ? iterL1.next() : null;
      } else {
        itemL2 = iterL2.hasNext() ? iterL2.next() : null;
      }
    }
  }

}
