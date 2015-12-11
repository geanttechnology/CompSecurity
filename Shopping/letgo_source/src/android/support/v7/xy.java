// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            xu, xw, yc, ya

class xy
    implements Cloneable
{

    private xw a;
    private Object b;
    private List c;

    xy()
    {
        c = new ArrayList();
    }

    private byte[] c()
        throws IOException
    {
        byte abyte0[] = new byte[a()];
        a(xu.a(abyte0));
        return abyte0;
    }

    int a()
    {
        if (b == null) goto _L2; else goto _L1
_L1:
        int j = a.a(b);
_L4:
        return j;
_L2:
        Iterator iterator = c.iterator();
        int i = 0;
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            i = ((yc)iterator.next()).a() + i;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(xu xu1)
        throws IOException
    {
        if (b != null)
        {
            a.a(b, xu1);
        } else
        {
            Iterator iterator = c.iterator();
            while (iterator.hasNext()) 
            {
                ((yc)iterator.next()).a(xu1);
            }
        }
    }

    public final xy b()
    {
        Object obj;
        int i;
        i = 0;
        obj = new xy();
        obj.a = a;
        if (c != null) goto _L2; else goto _L1
_L1:
        obj.c = null;
_L4:
        if (b == null)
        {
            return ((xy) (obj));
        }
        break; /* Loop/switch isn't completed */
_L2:
        try
        {
            ((xy) (obj)).c.addAll(c);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!(b instanceof ya))
        {
            break MISSING_BLOCK_LABEL_93;
        }
        obj.b = ((ya)b).f();
        return ((xy) (obj));
        if (!(b instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj.b = ((byte[])(byte[])b).clone();
        return ((xy) (obj));
        if (!(b instanceof byte[][])) goto _L6; else goto _L5
_L5:
        Object obj1;
        Object obj2;
        obj1 = (byte[][])(byte[][])b;
        obj2 = new byte[obj1.length][];
        obj.b = obj2;
        i = 0;
_L8:
        if (i >= obj1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2[i] = (byte[])obj1[i].clone();
        i++;
        if (true) goto _L8; else goto _L7
_L6:
        if (!(b instanceof boolean[]))
        {
            break MISSING_BLOCK_LABEL_216;
        }
        obj.b = ((boolean[])(boolean[])b).clone();
        return ((xy) (obj));
        if (!(b instanceof int[]))
        {
            break MISSING_BLOCK_LABEL_245;
        }
        obj.b = ((int[])(int[])b).clone();
        return ((xy) (obj));
        if (!(b instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        obj.b = ((long[])(long[])b).clone();
        return ((xy) (obj));
        if (!(b instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_303;
        }
        obj.b = ((float[])(float[])b).clone();
        return ((xy) (obj));
        if (!(b instanceof double[]))
        {
            break MISSING_BLOCK_LABEL_332;
        }
        obj.b = ((double[])(double[])b).clone();
        return ((xy) (obj));
        if (!(b instanceof ya[])) goto _L7; else goto _L9
_L9:
        obj1 = (ya[])(ya[])b;
        obj2 = new ya[obj1.length];
        obj.b = obj2;
_L11:
        if (i >= obj1.length) goto _L7; else goto _L10
_L10:
        obj2[i] = obj1[i].f();
        i++;
          goto _L11
_L7:
        return ((xy) (obj));
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return b();
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag2;
            if (obj instanceof xy)
            {
                obj = (xy)obj;
                if (b != null && ((xy) (obj)).b != null)
                {
                    flag = flag2;
                    if (a == ((xy) (obj)).a)
                    {
                        if (!a.b.isArray())
                        {
                            return b.equals(((xy) (obj)).b);
                        }
                        if (b instanceof byte[])
                        {
                            return Arrays.equals((byte[])(byte[])b, (byte[])(byte[])((xy) (obj)).b);
                        }
                        if (b instanceof int[])
                        {
                            return Arrays.equals((int[])(int[])b, (int[])(int[])((xy) (obj)).b);
                        }
                        if (b instanceof long[])
                        {
                            return Arrays.equals((long[])(long[])b, (long[])(long[])((xy) (obj)).b);
                        }
                        if (b instanceof float[])
                        {
                            return Arrays.equals((float[])(float[])b, (float[])(float[])((xy) (obj)).b);
                        }
                        if (b instanceof double[])
                        {
                            return Arrays.equals((double[])(double[])b, (double[])(double[])((xy) (obj)).b);
                        }
                        if (b instanceof boolean[])
                        {
                            return Arrays.equals((boolean[])(boolean[])b, (boolean[])(boolean[])((xy) (obj)).b);
                        } else
                        {
                            return Arrays.deepEquals((Object[])(Object[])b, (Object[])(Object[])((xy) (obj)).b);
                        }
                    }
                } else
                {
                    if (c != null && ((xy) (obj)).c != null)
                    {
                        return c.equals(((xy) (obj)).c);
                    }
                    boolean flag1;
                    try
                    {
                        flag1 = Arrays.equals(c(), ((xy) (obj)).c());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new IllegalStateException(((Throwable) (obj)));
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int i;
        try
        {
            i = Arrays.hashCode(c());
        }
        catch (IOException ioexception)
        {
            throw new IllegalStateException(ioexception);
        }
        return i + 527;
    }
}
