package Chapter3;

/**
 * @author Crissu 原始链表
 */

class Pratice2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 双链表
    DlistChange(2, 3);
    // 单链表
    SlistedChange(0, 1);

  }

  /**
   * 单链表换位 有头有尾链表
   *
   * @param pos1
   * @param pos2
   */
  private static void SlistedChange(int pos1, int pos2) {
    // TODO Auto-generated method stub
    Snode<Integer> Send = new Snode<>(null, null);
    Snode<Integer> S7 = new Snode<>(7, Send);
    Snode<Integer> S6 = new Snode<>(6, S7);
    Snode<Integer> S5 = new Snode<>(5, S6);
    Snode<Integer> S4 = new Snode<>(4, S5);
    Snode<Integer> S3 = new Snode<>(3, S4);
    Snode<Integer> S2 = new Snode<>(2, S3);
    Snode<Integer> S1 = new Snode<>(1, S2);
    Snode<Integer> Shead = new Snode<>(null, S1);

    // 交换前
    System.out.println("单链表交换前：");
    Snode tmp = Shead.next;
    while (tmp.next != null) {
      System.out.print(tmp.getValue());
      tmp = tmp.next;
    }
    System.out.println();
    // 交换
    Snode tmp1 = Shead;
    Snode p1_pre = null, p1 = null, p2 = null; // 交换位置的节点
    int index = 0; // 索引
    while (tmp1.next != null) {
      if (index == pos1) {
//				System.out.printf("pos1-1:%d\n", pos1-1);
        p1_pre = tmp1;
      }
      if (index == pos1 + 1) {
//				System.out.printf("pos1:%d\n", pos1);
        p1 = tmp1;
      }
      if (index == pos2 + 1) {
//				System.out.printf("pos2:%d\n", pos2);
        p2 = tmp1;
        // 交换
        p1.next = p2.next;
        p2.next = p1;
        p1_pre.next = p2;
        break;
      }
      index++;
      tmp1 = tmp1.next;
    }
    // 交换后
    System.out.println("单链表交换后：");
    Snode tmp2 = Shead.next;
    while (tmp2.next != null) {
      System.out.print(tmp2.getValue());
      tmp2 = tmp2.next;
    }
    System.out.println();
  }

  /**
   * 双链表换位 无头有尾链表
   *
   * @param pos1
   * @param pos2
   */
  private static void DlistChange(int pos1, int pos2) {
    // TODO Auto-generated method stub
    Dnode<Integer> Dlist = new Dnode<>(1, null, null);
    Dnode<Integer> D1 = new Dnode<>(2, null, null);
    Dlist.next = D1;
    D1.prev = Dlist;
    Dnode<Integer> D2 = new Dnode<>(3, null, null);
    D1.next = D2;
    D2.prev = D1;
    Dnode<Integer> D3 = new Dnode<>(4, null, null);
    D2.next = D3;
    D3.prev = D2;
    Dnode<Integer> D4 = new Dnode<>(5, null, null);
    D3.next = D4;
    D4.prev = D3;
    Dnode<Integer> D5 = new Dnode<>(6, null, null);
    D4.next = D5;
    D5.prev = D4;
    Dnode<Integer> D6 = new Dnode<>(7, null, null);
    D5.next = D6;
    D6.prev = D5;
    Dnode<Integer> end = new Dnode<>(null, null, null);
    D6.next = end;
    end.prev = D6;

    Dnode tmp = Dlist;
    Dnode tmp2 = Dlist;
    Dnode tmp3 = Dlist;
    System.out.println("双链表交换前：");
    while (tmp2.next != null) {
      System.out.print(tmp2.getValue());
      tmp2 = tmp2.next;
    }
    System.out.println();
    // 交换
    int index = 0;
    Dnode<Integer> p1 = new Dnode<>(null, null, null);
    Dnode<Integer> p2 = new Dnode<>(null, null, null);
    while (tmp.next != null) {
      if (index == pos1) {
        p1 = tmp;
      }
      if (index == pos2) {
        p2 = tmp;
        // 开始交换
        p1.prev.next = p2;
        p1.next = p2.next;
        p2.next.prev = p1;
        p2.next = p1;
        p2.prev = p1.prev;
        p1.prev = p2;
        break;
      }
      index++;
      tmp = tmp.next;
    }
//		System.out.printf("带交换的数1：%d\n", p1.getValue());
//		System.out.printf("带交换的数2：%d\n", p2.getValue());

    System.out.println("双链表交换后：");
    while (tmp3.next != null) {
      System.out.print(tmp3.getValue());
      tmp3 = tmp3.next;
    }
    System.out.println();
  }

}

/**
 * 双链表节点
 *
 * @author Administrator
 */
class Dnode<AnyType> {

  private AnyType value;
  public Dnode prev;
  public Dnode next;

  public Dnode(AnyType v, Dnode p, Dnode n) {
    value = v;
    prev = p;
    next = n;
  }

  public AnyType getValue() {
    return this.value;
  }
}

/**
 * 单链表节点
 *
 * @param <AnyType>
 * @author Administrator
 */
class Snode<AnyType> {

  private AnyType value;
  public Snode next;

  public Snode(AnyType v, Snode n) {
    value = v;
    next = n;
  }

  public AnyType getValue() {
    return this.value;
  }
}

