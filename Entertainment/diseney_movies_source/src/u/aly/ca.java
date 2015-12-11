// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class ca
{
    private static class a
        implements Comparator
    {

        public int compare(Object obj, Object obj1)
        {
            if (obj == null && obj1 == null)
            {
                return 0;
            }
            if (obj == null)
            {
                return -1;
            }
            if (obj1 == null)
            {
                return 1;
            }
            if (obj instanceof List)
            {
                return ca.a((List)obj, (List)obj1);
            }
            if (obj instanceof Set)
            {
                return ca.a((Set)obj, (Set)obj1);
            }
            if (obj instanceof Map)
            {
                return ca.a((Map)obj, (Map)obj1);
            }
            if (obj instanceof byte[])
            {
                return ca.a((byte[])obj, (byte[])obj1);
            } else
            {
                return ca.a((Comparable)obj, (Comparable)obj1);
            }
        }

        private a()
        {
        }

        a(a a1)
        {
            this();
        }
    }


    private static final Comparator a = new a(null);

    private ca()
    {
    }

    public static int a(byte byte0, byte byte1)
    {
        if (byte0 < byte1)
        {
            return -1;
        }
        return byte1 >= byte0 ? 0 : 1;
    }

    public static int a(double d1, double d2)
    {
        if (d1 < d2)
        {
            return -1;
        }
        return d2 >= d1 ? 0 : 1;
    }

    public static int a(int i, int j)
    {
        if (i < j)
        {
            return -1;
        }
        return j >= i ? 0 : 1;
    }

    public static int a(long l, long l1)
    {
        if (l < l1)
        {
            return -1;
        }
        return l1 >= l ? 0 : 1;
    }

    public static int a(Comparable comparable, Comparable comparable1)
    {
        return comparable.compareTo(comparable1);
    }

    public static int a(Object obj, Object obj1)
    {
        if (obj instanceof Comparable)
        {
            return a((Comparable)obj, (Comparable)obj1);
        }
        if (obj instanceof List)
        {
            return a((List)obj, (List)obj1);
        }
        if (obj instanceof Set)
        {
            return a((Set)obj, (Set)obj1);
        }
        if (obj instanceof Map)
        {
            return a((Map)obj, (Map)obj1);
        }
        if (obj instanceof byte[])
        {
            return a((byte[])obj, (byte[])obj1);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot compare objects of type ")).append(obj.getClass()).toString());
        }
    }

    public static int a(String s, String s1)
    {
        return s.compareTo(s1);
    }

    public static int a(ByteBuffer bytebuffer, byte abyte0[], int i)
    {
        int j = bytebuffer.remaining();
        System.arraycopy(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), abyte0, i, j);
        return j;
    }

    public static int a(List list, List list1)
    {
        int j;
        boolean flag;
        flag = false;
        j = a(list.size(), list1.size());
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
            j = a.compare(list.get(i), list1.get(i));
            if (j != 0)
            {
                return j;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static int a(Map map, Map map1)
    {
        int i = a(map.size(), map1.size());
        if (i != 0)
        {
            return i;
        }
        TreeMap treemap = new TreeMap(a);
        treemap.putAll(map);
        map = treemap.entrySet().iterator();
        treemap = new TreeMap(a);
        treemap.putAll(map1);
        map1 = treemap.entrySet().iterator();
        do
        {
            if (!map.hasNext() || !map1.hasNext())
            {
                return 0;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            java.util.Map.Entry entry1 = (java.util.Map.Entry)map1.next();
            i = a.compare(entry.getKey(), entry1.getKey());
            if (i != 0)
            {
                return i;
            }
            i = a.compare(entry.getValue(), entry1.getValue());
        } while (i == 0);
        return i;
    }

    public static int a(Set set, Set set1)
    {
        int i = a(set.size(), set1.size());
        if (i != 0)
        {
            return i;
        }
        TreeSet treeset = new TreeSet(a);
        treeset.addAll(set);
        set = new TreeSet(a);
        set.addAll(set1);
        set1 = treeset.iterator();
        set = set.iterator();
        do
        {
            if (!set1.hasNext() || !set.hasNext())
            {
                return 0;
            }
            i = a.compare(set1.next(), set.next());
        } while (i == 0);
        return i;
    }

    public static int a(short word0, short word1)
    {
        if (word0 < word1)
        {
            return -1;
        }
        return word1 >= word0 ? 0 : 1;
    }

    public static int a(boolean flag, boolean flag1)
    {
        return Boolean.valueOf(flag).compareTo(Boolean.valueOf(flag1));
    }

    public static int a(byte abyte0[], byte abyte1[])
    {
        int j;
        boolean flag;
        flag = false;
        j = a(abyte0.length, abyte1.length);
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
            j = a(abyte0[i], abyte1[i]);
            if (j != 0)
            {
                return j;
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static String a(byte byte0)
    {
        return Integer.toHexString((byte0 | 0x100) & 0x1ff).toUpperCase().substring(1);
    }

    public static void a(ByteBuffer bytebuffer, StringBuilder stringbuilder)
    {
        byte abyte0[] = bytebuffer.array();
        int i = bytebuffer.arrayOffset();
        int k = i + bytebuffer.position();
        int l = bytebuffer.limit() + i;
        int j;
        if (l - k > 128)
        {
            i = k + 128;
        } else
        {
            i = l;
        }
        j = k;
        do
        {
            if (j >= i)
            {
                if (l != i)
                {
                    stringbuilder.append("...");
                }
                return;
            }
            if (j > k)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append(a(abyte0[j]));
            j++;
        } while (true);
    }

    public static byte[] a(ByteBuffer bytebuffer)
    {
        if (b(bytebuffer))
        {
            return bytebuffer.array();
        } else
        {
            byte abyte0[] = new byte[bytebuffer.remaining()];
            a(bytebuffer, abyte0, 0);
            return abyte0;
        }
    }

    public static byte[] a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            byte abyte1[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static boolean b(ByteBuffer bytebuffer)
    {
        return bytebuffer.hasArray() && bytebuffer.position() == 0 && bytebuffer.arrayOffset() == 0 && bytebuffer.remaining() == bytebuffer.capacity();
    }

    public static ByteBuffer c(ByteBuffer bytebuffer)
    {
        ByteBuffer bytebuffer1;
        if (bytebuffer == null)
        {
            bytebuffer1 = null;
        } else
        {
            bytebuffer1 = bytebuffer;
            if (!b(bytebuffer))
            {
                return ByteBuffer.wrap(a(bytebuffer));
            }
        }
        return bytebuffer1;
    }

    public static ByteBuffer d(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null)
        {
            return null;
        }
        ByteBuffer bytebuffer1 = ByteBuffer.wrap(new byte[bytebuffer.remaining()]);
        if (bytebuffer.hasArray())
        {
            System.arraycopy(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer1.array(), 0, bytebuffer.remaining());
            return bytebuffer1;
        } else
        {
            bytebuffer.slice().get(bytebuffer1.array());
            return bytebuffer1;
        }
    }

}
