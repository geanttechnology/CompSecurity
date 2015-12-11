// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;


public class ObjectUtils
{

    public static final Null NULL = new Null();

    public ObjectUtils()
    {
    }

    public static byte CONST(byte byte0)
    {
        return byte0;
    }

    public static char CONST(char c)
    {
        return c;
    }

    public static double CONST(double d)
    {
        return d;
    }

    public static float CONST(float f)
    {
        return f;
    }

    public static int CONST(int i)
    {
        return i;
    }

    public static long CONST(long l)
    {
        return l;
    }

    public static Object CONST(Object obj)
    {
        return obj;
    }

    public static short CONST(short word0)
    {
        return word0;
    }

    public static boolean CONST(boolean flag)
    {
        return flag;
    }

    public static byte CONST_BYTE(int i)
    {
        if (i < -128 || i > 127)
        {
            throw new IllegalArgumentException((new StringBuilder("Supplied value must be a valid byte literal between -128 and 127: [")).append(i).append("]").toString());
        } else
        {
            return (byte)i;
        }
    }

    public static short CONST_SHORT(int i)
    {
        if (i < -32768 || i > 32767)
        {
            throw new IllegalArgumentException((new StringBuilder("Supplied value must be a valid byte literal between -32768 and 32767: [")).append(i).append("]").toString());
        } else
        {
            return (short)i;
        }
    }

    public static int compare(Comparable comparable, Comparable comparable1)
    {
        return compare(comparable, comparable1, false);
    }

    public static int compare(Comparable comparable, Comparable comparable1, boolean flag)
    {
        int i = 1;
        if (comparable != comparable1) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        return i;
_L2:
        if (comparable != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!flag)
        {
            return -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (comparable1 == null)
        {
            if (flag)
            {
                return -1;
            }
        } else
        {
            return comparable.compareTo(comparable1);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static Object defaultIfNull(Object obj, Object obj1)
    {
        if (obj != null)
        {
            return obj;
        } else
        {
            return obj1;
        }
    }

    public static boolean equals(Object obj, Object obj1)
    {
        if (obj == obj1)
        {
            return true;
        }
        if (obj == null || obj1 == null)
        {
            return false;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static transient Object firstNonNull(Object aobj[])
    {
        if (aobj != null)
        {
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = aobj[i];
                if (obj != null)
                {
                    return obj;
                }
            }

        }
        return null;
    }

    public static int hashCode(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return obj.hashCode();
        }
    }

    public static transient int hashCodeMulti(Object aobj[])
    {
        int k = 1;
        int i = 1;
        if (aobj != null)
        {
            int l = aobj.length;
            int j = 0;
            do
            {
                k = i;
                if (j >= l)
                {
                    break;
                }
                k = hashCode(aobj[j]);
                j++;
                i = k + i * 31;
            } while (true);
        }
        return k;
    }

    public static String identityToString(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            identityToString(stringbuilder, obj);
            return stringbuilder.toString();
        }
    }

    public static void identityToString(Appendable appendable, Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Cannot get the toString of a null identity");
        } else
        {
            appendable.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
    }

    public static void identityToString(StringBuffer stringbuffer, Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Cannot get the toString of a null identity");
        } else
        {
            stringbuffer.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
    }

    public static void identityToString(StringBuilder stringbuilder, Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException("Cannot get the toString of a null identity");
        } else
        {
            stringbuilder.append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj)));
            return;
        }
    }

    public static transient Comparable max(Comparable acomparable[])
    {
        Comparable comparable1 = null;
        Comparable comparable = null;
        if (acomparable != null)
        {
            int j = acomparable.length;
            int i = 0;
            do
            {
                comparable1 = comparable;
                if (i >= j)
                {
                    break;
                }
                comparable1 = acomparable[i];
                if (compare(comparable1, comparable, false) > 0)
                {
                    comparable = comparable1;
                }
                i++;
            } while (true);
        }
        return comparable1;
    }

    public static transient Comparable min(Comparable acomparable[])
    {
        Comparable comparable1 = null;
        Comparable comparable = null;
        if (acomparable != null)
        {
            int j = acomparable.length;
            int i = 0;
            do
            {
                comparable1 = comparable;
                if (i >= j)
                {
                    break;
                }
                comparable1 = acomparable[i];
                if (compare(comparable1, comparable, true) < 0)
                {
                    comparable = comparable1;
                }
                i++;
            } while (true);
        }
        return comparable1;
    }

    public static boolean notEqual(Object obj, Object obj1)
    {
        return !equals(obj, obj1);
    }

    public static String toString(Object obj)
    {
        if (obj == null)
        {
            return "";
        } else
        {
            return obj.toString();
        }
    }

    public static String toString(Object obj, String s)
    {
        if (obj == null)
        {
            return s;
        } else
        {
            return obj.toString();
        }
    }


    private class Null
        implements Serializable
    {

        private static final long serialVersionUID = 0x626e04ed40667ec5L;

        private Object readResolve()
        {
            return ObjectUtils.NULL;
        }

        Null()
        {
        }
    }

}
