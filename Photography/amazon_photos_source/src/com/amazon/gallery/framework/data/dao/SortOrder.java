// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;


// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            SortClause

public class SortOrder
{
    public static final class Order extends Enum
    {

        private static final Order $VALUES[];
        public static final Order ASC;
        public static final Order DESC;
        public static final Order NOCASE_ASC;
        public static final Order NOCASE_DESC;
        private final String SQL_STRING;

        public static Order valueOf(String s)
        {
            return (Order)Enum.valueOf(com/amazon/gallery/framework/data/dao/SortOrder$Order, s);
        }

        public static Order[] values()
        {
            return (Order[])$VALUES.clone();
        }

        public String toString()
        {
            return SQL_STRING;
        }

        static 
        {
            ASC = new Order("ASC", 0, "ASC");
            DESC = new Order("DESC", 1, "DESC");
            NOCASE_ASC = new Order("NOCASE_ASC", 2, "COLLATE NOCASE ASC");
            NOCASE_DESC = new Order("NOCASE_DESC", 3, "COLLATE NOCASE DESC");
            $VALUES = (new Order[] {
                ASC, DESC, NOCASE_ASC, NOCASE_DESC
            });
        }

        private Order(String s, int i, String s1)
        {
            super(s, i);
            SQL_STRING = s1;
        }
    }

    private static class RandomOrder extends SortOrder
    {

        public String getOrderByString()
        {
            return "Random()";
        }

        private RandomOrder()
        {
            super(null, null);
        }

    }


    public static final SortOrder RANDOM_ORDER = new RandomOrder();
    private SortClause sortClauses[];

    public SortOrder(String s)
    {
        this(s, Order.ASC);
    }

    public SortOrder(String s, Order order)
    {
        sortClauses = (new SortClause[] {
            new SortClause(s, order)
        });
    }

    public SortOrder(String s, Order order, String s1, Order order1)
    {
        sortClauses = (new SortClause[] {
            new SortClause(s, order), new SortClause(s1, order1)
        });
    }

    public transient SortOrder(SortClause asortclause[])
    {
        sortClauses = asortclause;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (SortOrder)obj;
            return getOrderByString().equals(((SortOrder) (obj)).getOrderByString());
        }
    }

    public String getOrderByString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < sortClauses.length; i++)
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(sortClauses[i]);
        }

        return stringbuilder.toString();
    }

    public int hashCode()
    {
        return getOrderByString().hashCode();
    }

    public String toString()
    {
        return getOrderByString();
    }

}
