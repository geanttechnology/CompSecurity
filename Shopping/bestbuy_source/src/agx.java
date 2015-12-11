// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class agx
{

    private agv a;
    private Object b;
    private List c;

    agx()
    {
        c = new ArrayList();
    }

    private byte[] b()
    {
        byte abyte0[] = new byte[a()];
        a(ags.a(abyte0));
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
            i = ((ahc)iterator.next()).a() + i;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    void a(ags ags1)
    {
        if (b != null)
        {
            a.a(b, ags1);
        } else
        {
            Iterator iterator = c.iterator();
            while (iterator.hasNext()) 
            {
                ((ahc)iterator.next()).a(ags1);
            }
        }
    }

    void a(ahc ahc1)
    {
        c.add(ahc1);
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
            if (obj instanceof agx)
            {
                obj = (agx)obj;
                if (b != null && ((agx) (obj)).b != null)
                {
                    flag = flag2;
                    if (a == ((agx) (obj)).a)
                    {
                        if (!a.b.isArray())
                        {
                            return b.equals(((agx) (obj)).b);
                        }
                        if (b instanceof byte[])
                        {
                            return Arrays.equals((byte[])(byte[])b, (byte[])(byte[])((agx) (obj)).b);
                        }
                        if (b instanceof int[])
                        {
                            return Arrays.equals((int[])(int[])b, (int[])(int[])((agx) (obj)).b);
                        }
                        if (b instanceof long[])
                        {
                            return Arrays.equals((long[])(long[])b, (long[])(long[])((agx) (obj)).b);
                        }
                        if (b instanceof float[])
                        {
                            return Arrays.equals((float[])(float[])b, (float[])(float[])((agx) (obj)).b);
                        }
                        if (b instanceof double[])
                        {
                            return Arrays.equals((double[])(double[])b, (double[])(double[])((agx) (obj)).b);
                        }
                        if (b instanceof boolean[])
                        {
                            return Arrays.equals((boolean[])(boolean[])b, (boolean[])(boolean[])((agx) (obj)).b);
                        } else
                        {
                            return Arrays.deepEquals((Object[])(Object[])b, (Object[])(Object[])((agx) (obj)).b);
                        }
                    }
                } else
                {
                    if (c != null && ((agx) (obj)).c != null)
                    {
                        return c.equals(((agx) (obj)).c);
                    }
                    boolean flag1;
                    try
                    {
                        flag1 = Arrays.equals(b(), ((agx) (obj)).b());
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
            i = Arrays.hashCode(b());
        }
        catch (IOException ioexception)
        {
            throw new IllegalStateException(ioexception);
        }
        return i + 527;
    }
}
