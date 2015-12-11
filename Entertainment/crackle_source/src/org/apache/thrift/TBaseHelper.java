// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift;

import java.util.List;

public class TBaseHelper
{

    public TBaseHelper()
    {
    }

    public static int compareTo(byte byte0, byte byte1)
    {
        if (byte0 < byte1)
        {
            return -1;
        }
        return byte1 >= byte0 ? 0 : 1;
    }

    public static int compareTo(double d, double d1)
    {
        if (d < d1)
        {
            return -1;
        }
        return d1 >= d ? 0 : 1;
    }

    public static int compareTo(int i, int j)
    {
        if (i < j)
        {
            return -1;
        }
        return j >= i ? 0 : 1;
    }

    public static int compareTo(long l, long l1)
    {
        if (l < l1)
        {
            return -1;
        }
        return l1 >= l ? 0 : 1;
    }

    public static int compareTo(Comparable comparable, Comparable comparable1)
    {
        return comparable.compareTo(comparable1);
    }

    public static int compareTo(String s, String s1)
    {
        return s.compareTo(s1);
    }

    public static int compareTo(List list, List list1)
    {
        int j;
        boolean flag;
        flag = false;
        j = compareTo(list.size(), list1.size());
        if (j == 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int i = 0;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= list.size())
            {
                continue;
            }
            Object obj = list.get(i);
            Object obj1 = list1.get(i);
            if (obj instanceof List)
            {
                j = compareTo((List)obj, (List)obj1);
            } else
            {
                j = compareTo((Comparable)obj, (Comparable)obj1);
            }
            if (j != 0)
            {
                return j;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static int compareTo(short word0, short word1)
    {
        if (word0 < word1)
        {
            return -1;
        }
        return word1 >= word0 ? 0 : 1;
    }

    public static int compareTo(boolean flag, boolean flag1)
    {
        return Boolean.valueOf(flag).compareTo(Boolean.valueOf(flag1));
    }

    public static int compareTo(byte abyte0[], byte abyte1[])
    {
        int j;
        boolean flag;
        flag = false;
        j = compareTo(abyte0.length, abyte1.length);
        if (j == 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int i = 0;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= abyte0.length)
            {
                continue;
            }
            j = compareTo(abyte0, abyte1);
            if (j != 0)
            {
                return j;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }
}
