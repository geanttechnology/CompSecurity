// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

public class Arrays
{
    private static class ArrayList extends AbstractList
        implements List, Serializable, RandomAccess
    {

        private static final long serialVersionUID = 0xd9a43cbecd8806d2L;
        private final Object a[];

        public boolean contains(Object obj)
        {
            boolean flag1 = true;
            if (obj == null) goto _L2; else goto _L1
_L1:
            Object aobj[];
            int i;
            int j;
            aobj = a;
            j = aobj.length;
            i = 0;
_L7:
            if (i < j) goto _L4; else goto _L3
_L3:
            boolean flag = false;
_L6:
            return flag;
_L4:
            flag = flag1;
            if (obj.equals(aobj[i])) goto _L6; else goto _L5
_L5:
            i++;
              goto _L7
_L2:
            obj = ((Object) (a));
            j = obj.length;
            i = 0;
_L10:
            if (i >= j) goto _L3; else goto _L8
_L8:
            flag = flag1;
            if (obj[i] == null) goto _L6; else goto _L9
_L9:
            i++;
              goto _L10
        }

        public Object get(int i)
        {
            Object obj;
            try
            {
                obj = a[i];
            }
            catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
            {
                throw arrayindexoutofboundsexception;
            }
            return obj;
        }

        public int indexOf(Object obj)
        {
            int i;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_39;
            }
            i = 0;
_L3:
            if (i < a.length) goto _L2; else goto _L1
_L1:
            return -1;
_L2:
            if (obj.equals(a[i]))
            {
                return i;
            }
            i++;
              goto _L3
            int j = 0;
            while (j < a.length) 
            {
                if (a[j] == null)
                {
                    return j;
                }
                j++;
            }
              goto _L1
        }

        public int lastIndexOf(Object obj)
        {
            int i;
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_40;
            }
            i = a.length - 1;
_L3:
            if (i >= 0) goto _L2; else goto _L1
_L1:
            return -1;
_L2:
            if (obj.equals(a[i]))
            {
                return i;
            }
            i--;
              goto _L3
            int j = a.length - 1;
            while (j >= 0) 
            {
                if (a[j] == null)
                {
                    return j;
                }
                j--;
            }
              goto _L1
        }

        public Object set(int i, Object obj)
        {
            Object obj1 = a[i];
            a[i] = obj;
            return obj1;
        }

        public int size()
        {
            return a.length;
        }

        public Object[] toArray()
        {
            return (Object[])((Object []) (a)).clone();
        }

        public Object[] toArray(Object aobj[])
        {
            int i = size();
            Object aobj1[] = aobj;
            if (i > aobj.length)
            {
                aobj1 = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i);
            }
            System.arraycopy(((Object) (a)), 0, ((Object) (aobj1)), 0, i);
            if (i < aobj1.length)
            {
                aobj1[i] = null;
            }
            return aobj1;
        }

        ArrayList(Object aobj[])
        {
            if (aobj == null)
            {
                throw new NullPointerException();
            } else
            {
                a = aobj;
                return;
            }
        }
    }


    static final boolean $assertionsDisabled;

    private Arrays()
    {
    }

    public static transient List asList(Object aobj[])
    {
        return new ArrayList(aobj);
    }

    public static int binarySearch(byte abyte0[], byte byte0)
    {
        return binarySearch(abyte0, 0, abyte0.length, byte0);
    }

    public static int binarySearch(byte abyte0[], int i, int j, byte byte0)
    {
        checkBinarySearchBounds(i, j, abyte0.length);
        j--;
_L6:
        if (i <= j) goto _L2; else goto _L1
_L1:
        j = ~i;
_L4:
        return j;
_L2:
        int k;
        byte byte1;
        k = i + j >>> 1;
        byte1 = abyte0[k];
        if (byte1 < byte0)
        {
            i = k + 1;
            continue; /* Loop/switch isn't completed */
        }
        j = k;
        if (byte1 <= byte0) goto _L4; else goto _L3
_L3:
        j = k - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(char ac[], char c)
    {
        return binarySearch(ac, 0, ac.length, c);
    }

    public static int binarySearch(char ac[], int i, int j, char c)
    {
        checkBinarySearchBounds(i, j, ac.length);
        j--;
_L6:
        if (i <= j) goto _L2; else goto _L1
_L1:
        j = ~i;
_L4:
        return j;
_L2:
        int k;
        char c1;
        k = i + j >>> 1;
        c1 = ac[k];
        if (c1 < c)
        {
            i = k + 1;
            continue; /* Loop/switch isn't completed */
        }
        j = k;
        if (c1 <= c) goto _L4; else goto _L3
_L3:
        j = k - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(double ad[], double d)
    {
        return binarySearch(ad, 0, ad.length, d);
    }

    public static int binarySearch(double ad[], int i, int j, double d)
    {
        checkBinarySearchBounds(i, j, ad.length);
        j--;
_L7:
        if (i <= j) goto _L2; else goto _L1
_L1:
        int k = ~i;
_L4:
        return k;
_L2:
        double d1;
        int l;
        l = i + j >>> 1;
        d1 = ad[l];
        if (d1 < d)
        {
            i = l + 1;
            continue; /* Loop/switch isn't completed */
        }
        if (d1 > d)
        {
            j = l - 1;
            continue; /* Loop/switch isn't completed */
        }
        if (d1 == 0.0D)
        {
            break; /* Loop/switch isn't completed */
        }
        k = l;
        if (d1 == d) goto _L4; else goto _L3
_L3:
        long l1;
        long l2;
        l1 = Double.doubleToLongBits(d1);
        l2 = Double.doubleToLongBits(d);
        if (l1 < l2)
        {
            i = l + 1;
            continue; /* Loop/switch isn't completed */
        }
        k = l;
        if (l1 <= l2) goto _L4; else goto _L5
_L5:
        j = l - 1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static int binarySearch(float af[], float f)
    {
        return binarySearch(af, 0, af.length, f);
    }

    public static int binarySearch(float af[], int i, int j, float f)
    {
        checkBinarySearchBounds(i, j, af.length);
        j--;
_L7:
        if (i <= j) goto _L2; else goto _L1
_L1:
        int k = ~i;
_L4:
        return k;
_L2:
        float f1;
        int l;
        l = i + j >>> 1;
        f1 = af[l];
        if (f1 < f)
        {
            i = l + 1;
            continue; /* Loop/switch isn't completed */
        }
        if (f1 > f)
        {
            j = l - 1;
            continue; /* Loop/switch isn't completed */
        }
        if (f1 == 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        k = l;
        if (f1 == f) goto _L4; else goto _L3
_L3:
        int i1;
        int j1;
        i1 = Float.floatToIntBits(f1);
        j1 = Float.floatToIntBits(f);
        if (i1 < j1)
        {
            i = l + 1;
            continue; /* Loop/switch isn't completed */
        }
        k = l;
        if (i1 <= j1) goto _L4; else goto _L5
_L5:
        j = l - 1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static int binarySearch(int ai[], int i)
    {
        return binarySearch(ai, 0, ai.length, i);
    }

    public static int binarySearch(int ai[], int i, int j, int k)
    {
        checkBinarySearchBounds(i, j, ai.length);
        j--;
_L6:
        if (i <= j) goto _L2; else goto _L1
_L1:
        j = ~i;
_L4:
        return j;
_L2:
        int l;
        int i1;
        l = i + j >>> 1;
        i1 = ai[l];
        if (i1 < k)
        {
            i = l + 1;
            continue; /* Loop/switch isn't completed */
        }
        j = l;
        if (i1 <= k) goto _L4; else goto _L3
_L3:
        j = l - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(long al[], int i, int j, long l)
    {
        checkBinarySearchBounds(i, j, al.length);
        j--;
_L6:
        if (i <= j) goto _L2; else goto _L1
_L1:
        j = ~i;
_L4:
        return j;
_L2:
        int k;
        long l1;
        k = i + j >>> 1;
        l1 = al[k];
        if (l1 < l)
        {
            i = k + 1;
            continue; /* Loop/switch isn't completed */
        }
        j = k;
        if (l1 <= l) goto _L4; else goto _L3
_L3:
        j = k - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(long al[], long l)
    {
        return binarySearch(al, 0, al.length, l);
    }

    public static int binarySearch(Object aobj[], int i, int j, Object obj)
    {
        checkBinarySearchBounds(i, j, aobj.length);
        j--;
_L6:
        if (i <= j) goto _L2; else goto _L1
_L1:
        j = ~i;
_L4:
        return j;
_L2:
        int k;
        int l;
        k = i + j >>> 1;
        l = ((Comparable)aobj[k]).compareTo(obj);
        if (l < 0)
        {
            i = k + 1;
            continue; /* Loop/switch isn't completed */
        }
        j = k;
        if (l <= 0) goto _L4; else goto _L3
_L3:
        j = k - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(Object aobj[], int i, int j, Object obj, Comparator comparator)
    {
        if (comparator != null) goto _L2; else goto _L1
_L1:
        j = binarySearch(aobj, i, j, obj);
_L6:
        return j;
_L2:
        checkBinarySearchBounds(i, j, aobj.length);
        j--;
_L4:
        int k;
        int l;
        do
        {
label0:
            {
                if (i > j)
                {
                    return ~i;
                }
                k = i + j >>> 1;
                l = comparator.compare(aobj[k], obj);
                if (l >= 0)
                {
                    break label0;
                }
                i = k + 1;
            }
        } while (true);
        for (j = k; l <= 0; j = k)
        {
            continue; /* Loop/switch isn't completed */
        }

        j = k - 1;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(Object aobj[], Object obj)
    {
        return binarySearch(aobj, 0, aobj.length, obj);
    }

    public static int binarySearch(Object aobj[], Object obj, Comparator comparator)
    {
        return binarySearch(aobj, 0, aobj.length, obj, comparator);
    }

    public static int binarySearch(short aword0[], int i, int j, short word0)
    {
        checkBinarySearchBounds(i, j, aword0.length);
        j--;
_L6:
        if (i <= j) goto _L2; else goto _L1
_L1:
        j = ~i;
_L4:
        return j;
_L2:
        int k;
        short word1;
        k = i + j >>> 1;
        word1 = aword0[k];
        if (word1 < word0)
        {
            i = k + 1;
            continue; /* Loop/switch isn't completed */
        }
        j = k;
        if (word1 <= word0) goto _L4; else goto _L3
_L3:
        j = k - 1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int binarySearch(short aword0[], short word0)
    {
        return binarySearch(aword0, 0, aword0.length, word0);
    }

    private static void checkBinarySearchBounds(int i, int j, int k)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0 || j > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return;
        }
    }

    public static byte[] copyOf(byte abyte0[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(abyte0, 0, i);
        }
    }

    public static char[] copyOf(char ac[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(ac, 0, i);
        }
    }

    public static double[] copyOf(double ad[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(ad, 0, i);
        }
    }

    public static float[] copyOf(float af[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(af, 0, i);
        }
    }

    public static int[] copyOf(int ai[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(ai, 0, i);
        }
    }

    public static long[] copyOf(long al[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(al, 0, i);
        }
    }

    public static Object[] copyOf(Object aobj[], int i)
    {
        if (aobj == null)
        {
            throw new NullPointerException();
        }
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(aobj, 0, i);
        }
    }

    public static Object[] copyOf(Object aobj[], int i, Class class1)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(aobj, 0, i, class1);
        }
    }

    public static short[] copyOf(short aword0[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(aword0, 0, i);
        }
    }

    public static boolean[] copyOf(boolean aflag[], int i)
    {
        if (i < 0)
        {
            throw new NegativeArraySizeException();
        } else
        {
            return copyOfRange(aflag, 0, i);
        }
    }

    public static byte[] copyOfRange(byte abyte0[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = abyte0.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, k);
            return abyte1;
        }
    }

    public static char[] copyOfRange(char ac[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = ac.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            char ac1[] = new char[j];
            System.arraycopy(ac, i, ac1, 0, k);
            return ac1;
        }
    }

    public static double[] copyOfRange(double ad[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = ad.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            double ad1[] = new double[j];
            System.arraycopy(ad, i, ad1, 0, k);
            return ad1;
        }
    }

    public static float[] copyOfRange(float af[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = af.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            float af1[] = new float[j];
            System.arraycopy(af, i, af1, 0, k);
            return af1;
        }
    }

    public static int[] copyOfRange(int ai[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = ai.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            int ai1[] = new int[j];
            System.arraycopy(ai, i, ai1, 0, k);
            return ai1;
        }
    }

    public static long[] copyOfRange(long al[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = al.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            long al1[] = new long[j];
            System.arraycopy(al, i, al1, 0, k);
            return al1;
        }
    }

    public static Object[] copyOfRange(Object aobj[], int i, int j)
    {
        int k = aobj.length;
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            Object aobj1[] = (Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), j);
            System.arraycopy(((Object) (aobj)), i, ((Object) (aobj1)), 0, k);
            return aobj1;
        }
    }

    public static Object[] copyOfRange(Object aobj[], int i, int j, Class class1)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = aobj.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            class1 = ((Class) ((Object[])Array.newInstance(class1.getComponentType(), j)));
            System.arraycopy(((Object) (aobj)), i, class1, 0, k);
            return class1;
        }
    }

    public static short[] copyOfRange(short aword0[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = aword0.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            short aword1[] = new short[j];
            System.arraycopy(aword0, i, aword1, 0, k);
            return aword1;
        }
    }

    public static boolean[] copyOfRange(boolean aflag[], int i, int j)
    {
        if (i > j)
        {
            throw new IllegalArgumentException();
        }
        int k = aflag.length;
        if (i < 0 || i > k)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            j -= i;
            k = Math.min(j, k - i);
            boolean aflag1[] = new boolean[j];
            System.arraycopy(aflag, i, aflag1, 0, k);
            return aflag1;
        }
    }

    public static boolean deepEquals(Object aobj[], Object aobj1[])
    {
        if (aobj != aobj1)
        {
            if (aobj == null || aobj1 == null || aobj.length != aobj1.length)
            {
                return false;
            }
            int i = 0;
            while (i < aobj.length) 
            {
                if (!deepEqualsElements(aobj[i], aobj1[i]))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    private static boolean deepEqualsElements(Object obj, Object obj1)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == obj1)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (obj1 != null)
                {
                    Class class1 = obj.getClass().getComponentType();
                    flag = flag1;
                    if (class1 == obj1.getClass().getComponentType())
                    {
                        if (class1 == null)
                        {
                            return obj.equals(obj1);
                        }
                        if (!class1.isPrimitive())
                        {
                            return deepEquals((Object[])obj, (Object[])obj1);
                        }
                        if (class1.equals(Integer.TYPE))
                        {
                            return equals((int[])obj, (int[])obj1);
                        }
                        if (class1.equals(Character.TYPE))
                        {
                            return equals((char[])obj, (char[])obj1);
                        }
                        if (class1.equals(Boolean.TYPE))
                        {
                            return equals((boolean[])obj, (boolean[])obj1);
                        }
                        if (class1.equals(Byte.TYPE))
                        {
                            return equals((byte[])obj, (byte[])obj1);
                        }
                        if (class1.equals(Long.TYPE))
                        {
                            return equals((long[])obj, (long[])obj1);
                        }
                        if (class1.equals(Float.TYPE))
                        {
                            return equals((float[])obj, (float[])obj1);
                        }
                        if (class1.equals(Double.TYPE))
                        {
                            return equals((double[])obj, (double[])obj1);
                        } else
                        {
                            return equals((short[])obj, (short[])obj1);
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static int deepHashCode(Object aobj[])
    {
        int j = 0;
        if (aobj != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = aobj.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i = i * 31 + deepHashCodeElement(aobj[j]);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static int deepHashCodeElement(Object obj)
    {
        if (obj == null)
        {
            return 0;
        }
        Class class1 = obj.getClass().getComponentType();
        if (class1 == null)
        {
            return obj.hashCode();
        }
        if (!class1.isPrimitive())
        {
            return deepHashCode((Object[])obj);
        }
        if (class1.equals(Integer.TYPE))
        {
            return hashCode((int[])obj);
        }
        if (class1.equals(Character.TYPE))
        {
            return hashCode((char[])obj);
        }
        if (class1.equals(Boolean.TYPE))
        {
            return hashCode((boolean[])obj);
        }
        if (class1.equals(Byte.TYPE))
        {
            return hashCode((byte[])obj);
        }
        if (class1.equals(Long.TYPE))
        {
            return hashCode((long[])obj);
        }
        if (class1.equals(Float.TYPE))
        {
            return hashCode((float[])obj);
        }
        if (class1.equals(Double.TYPE))
        {
            return hashCode((double[])obj);
        } else
        {
            return hashCode((short[])obj);
        }
    }

    public static String deepToString(Object aobj[])
    {
        if (aobj == null)
        {
            return "null";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(aobj.length * 9);
            deepToStringImpl(aobj, new Object[] {
                aobj
            }, stringbuilder);
            return stringbuilder.toString();
        }
    }

    private static void deepToStringImpl(Object aobj[], Object aobj1[], StringBuilder stringbuilder)
    {
        int i;
        if (aobj == null)
        {
            stringbuilder.append("null");
            return;
        }
        stringbuilder.append('[');
        i = 0;
_L2:
        Object obj;
        if (i >= aobj.length)
        {
            stringbuilder.append(']');
            return;
        }
        if (i != 0)
        {
            stringbuilder.append(", ");
        }
        obj = aobj[i];
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append("null");
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Class class1 = obj.getClass();
        if (class1.isArray())
        {
            class1 = class1.getComponentType();
            if (class1.isPrimitive())
            {
                if (Boolean.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((boolean[])obj));
                } else
                if (Byte.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((byte[])obj));
                } else
                if (Character.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((char[])obj));
                } else
                if (Double.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((double[])obj));
                } else
                if (Float.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((float[])obj));
                } else
                if (Integer.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((int[])obj));
                } else
                if (Long.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((long[])obj));
                } else
                if (Short.TYPE.equals(class1))
                {
                    stringbuilder.append(toString((short[])obj));
                } else
                {
                    throw new AssertionError();
                }
            } else
            {
                if (!$assertionsDisabled && !(obj instanceof Object[]))
                {
                    throw new AssertionError();
                }
                if (deepToStringImplContains(aobj1, obj))
                {
                    stringbuilder.append("[...]");
                } else
                {
                    Object aobj2[] = (Object[])obj;
                    Object aobj3[] = new Object[aobj1.length + 1];
                    System.arraycopy(((Object) (aobj1)), 0, ((Object) (aobj3)), 0, aobj1.length);
                    aobj3[aobj1.length] = ((Object) (aobj2));
                    deepToStringImpl(aobj2, aobj3, stringbuilder);
                }
            }
        } else
        {
            stringbuilder.append(aobj[i]);
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private static boolean deepToStringImplContains(Object aobj[], Object obj)
    {
        if (aobj != null && aobj.length != 0)
        {
            int j = aobj.length;
            int i = 0;
            while (i < j) 
            {
                if (aobj[i] == obj)
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static boolean equals(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != abyte1)
        {
            if (abyte0 == null || abyte1 == null || abyte0.length != abyte1.length)
            {
                return false;
            }
            int i = 0;
            while (i < abyte0.length) 
            {
                if (abyte0[i] != abyte1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(char ac[], char ac1[])
    {
        if (ac != ac1)
        {
            if (ac == null || ac1 == null || ac.length != ac1.length)
            {
                return false;
            }
            int i = 0;
            while (i < ac.length) 
            {
                if (ac[i] != ac1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(double ad[], double ad1[])
    {
        if (ad != ad1)
        {
            if (ad == null || ad1 == null || ad.length != ad1.length)
            {
                return false;
            }
            int i = 0;
            while (i < ad.length) 
            {
                if (Double.doubleToLongBits(ad[i]) != Double.doubleToLongBits(ad1[i]))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(float af[], float af1[])
    {
        if (af != af1)
        {
            if (af == null || af1 == null || af.length != af1.length)
            {
                return false;
            }
            int i = 0;
            while (i < af.length) 
            {
                if (Float.floatToIntBits(af[i]) != Float.floatToIntBits(af1[i]))
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(int ai[], int ai1[])
    {
        if (ai != ai1)
        {
            if (ai == null || ai1 == null || ai.length != ai1.length)
            {
                return false;
            }
            int i = 0;
            while (i < ai.length) 
            {
                if (ai[i] != ai1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(long al[], long al1[])
    {
        if (al != al1)
        {
            if (al == null || al1 == null || al.length != al1.length)
            {
                return false;
            }
            int i = 0;
            while (i < al.length) 
            {
                if (al[i] != al1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(Object aobj[], Object aobj1[])
    {
        if (aobj != aobj1)
        {
            if (aobj == null || aobj1 == null || aobj.length != aobj1.length)
            {
                return false;
            }
            int i = 0;
            while (i < aobj.length) 
            {
                Object obj = aobj[i];
                Object obj1 = aobj1[i];
                if (obj != null ? !obj.equals(obj1) : obj1 != null)
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(short aword0[], short aword1[])
    {
        if (aword0 != aword1)
        {
            if (aword0 == null || aword1 == null || aword0.length != aword1.length)
            {
                return false;
            }
            int i = 0;
            while (i < aword0.length) 
            {
                if (aword0[i] != aword1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static boolean equals(boolean aflag[], boolean aflag1[])
    {
        if (aflag != aflag1)
        {
            if (aflag == null || aflag1 == null || aflag.length != aflag1.length)
            {
                return false;
            }
            int i = 0;
            while (i < aflag.length) 
            {
                if (aflag[i] != aflag1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public static void fill(byte abyte0[], byte byte0)
    {
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return;
            }
            abyte0[i] = byte0;
            i++;
        } while (true);
    }

    public static void fill(int ai[], int i)
    {
        int j = 0;
        do
        {
            if (j >= ai.length)
            {
                return;
            }
            ai[j] = i;
            j++;
        } while (true);
    }

    public static void fill(Object aobj[], Object obj)
    {
        int i = 0;
        do
        {
            if (i >= aobj.length)
            {
                return;
            }
            aobj[i] = obj;
            i++;
        } while (true);
    }

    public static void fill(boolean aflag[], boolean flag)
    {
        int i = 0;
        do
        {
            if (i >= aflag.length)
            {
                return;
            }
            aflag[i] = flag;
            i++;
        } while (true);
    }

    public static int hashCode(byte abyte0[])
    {
        int j = 0;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = abyte0.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i = i * 31 + abyte0[j];
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(char ac[])
    {
        int j = 0;
        if (ac != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = ac.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i = i * 31 + ac[j];
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(double ad[])
    {
        int j = 0;
        if (ad != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = ad.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            long l1 = Double.doubleToLongBits(ad[j]);
            i = i * 31 + (int)(l1 >>> 32 ^ l1);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(float af[])
    {
        int j = 0;
        if (af != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = af.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i = i * 31 + Float.floatToIntBits(af[j]);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(int ai[])
    {
        int j = 0;
        if (ai != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = ai.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i = i * 31 + ai[j];
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(long al[])
    {
        int j = 0;
        if (al != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = al.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            long l1 = al[j];
            i = i * 31 + (int)(l1 >>> 32 ^ l1);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(Object aobj[])
    {
        int j = 0;
        if (aobj != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = aobj.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            Object obj = aobj[j];
            if (obj == null)
            {
                k = 0;
            } else
            {
                k = obj.hashCode();
            }
            i = i * 31 + k;
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(short aword0[])
    {
        int j = 0;
        if (aword0 != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = aword0.length;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            i = i * 31 + aword0[j];
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int hashCode(boolean aflag[])
    {
        if (aflag != null) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        int i = 1;
        int l = aflag.length;
        int j = 0;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            if (aflag[j])
            {
                k = 1231;
            } else
            {
                k = 1237;
            }
            i = i * 31 + k;
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String toString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return "null";
        }
        if (abyte0.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 6);
        stringbuilder.append('[');
        stringbuilder.append(abyte0[0]);
        int i = 1;
        do
        {
            if (i >= abyte0.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(abyte0[i]);
            i++;
        } while (true);
    }

    public static String toString(char ac[])
    {
        if (ac == null)
        {
            return "null";
        }
        if (ac.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(ac.length * 3);
        stringbuilder.append('[');
        stringbuilder.append(ac[0]);
        int i = 1;
        do
        {
            if (i >= ac.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(ac[i]);
            i++;
        } while (true);
    }

    public static String toString(double ad[])
    {
        if (ad == null)
        {
            return "null";
        }
        if (ad.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(ad.length * 7);
        stringbuilder.append('[');
        stringbuilder.append(ad[0]);
        int i = 1;
        do
        {
            if (i >= ad.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(ad[i]);
            i++;
        } while (true);
    }

    public static String toString(float af[])
    {
        if (af == null)
        {
            return "null";
        }
        if (af.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(af.length * 7);
        stringbuilder.append('[');
        stringbuilder.append(af[0]);
        int i = 1;
        do
        {
            if (i >= af.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(af[i]);
            i++;
        } while (true);
    }

    public static String toString(int ai[])
    {
        if (ai == null)
        {
            return "null";
        }
        if (ai.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(ai.length * 6);
        stringbuilder.append('[');
        stringbuilder.append(ai[0]);
        int i = 1;
        do
        {
            if (i >= ai.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(ai[i]);
            i++;
        } while (true);
    }

    public static String toString(long al[])
    {
        if (al == null)
        {
            return "null";
        }
        if (al.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(al.length * 6);
        stringbuilder.append('[');
        stringbuilder.append(al[0]);
        int i = 1;
        do
        {
            if (i >= al.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(al[i]);
            i++;
        } while (true);
    }

    public static String toString(Object aobj[])
    {
        if (aobj == null)
        {
            return "null";
        }
        if (aobj.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(aobj.length * 7);
        stringbuilder.append('[');
        stringbuilder.append(aobj[0]);
        int i = 1;
        do
        {
            if (i >= aobj.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(aobj[i]);
            i++;
        } while (true);
    }

    public static String toString(short aword0[])
    {
        if (aword0 == null)
        {
            return "null";
        }
        if (aword0.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(aword0.length * 6);
        stringbuilder.append('[');
        stringbuilder.append(aword0[0]);
        int i = 1;
        do
        {
            if (i >= aword0.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(aword0[i]);
            i++;
        } while (true);
    }

    public static String toString(boolean aflag[])
    {
        if (aflag == null)
        {
            return "null";
        }
        if (aflag.length == 0)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder(aflag.length * 7);
        stringbuilder.append('[');
        stringbuilder.append(aflag[0]);
        int i = 1;
        do
        {
            if (i >= aflag.length)
            {
                stringbuilder.append(']');
                return stringbuilder.toString();
            }
            stringbuilder.append(", ");
            stringbuilder.append(aflag[i]);
            i++;
        } while (true);
    }

    static 
    {
        boolean flag;
        if (!net/tsz/afinal/core/Arrays.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
