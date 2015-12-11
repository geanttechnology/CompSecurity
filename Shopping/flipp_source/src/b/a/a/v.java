// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package b.a.a:
//            m

public final class v
    implements Serializable
{

    static int a = 0;
    static int b = 1;
    static int c = 2;
    static int d = 3;
    static int e = 4;
    static int f = 5;
    static int g = 6;
    static int h = 7;
    private static final Map i = new HashMap(32);
    private static v j;
    private static v k;
    private static v l;
    private static v m;
    private final String n;
    private final m o[];
    private final int p[];

    private v(String s, m am[], int ai[])
    {
        n = s;
        o = am;
        p = ai;
    }

    public static v a()
    {
        v v2 = j;
        v v1 = v2;
        if (v2 == null)
        {
            v1 = new v("Years", new m[] {
                b.a.a.m.j()
            }, new int[] {
                0, -1, -1, -1, -1, -1, -1, -1
            });
            j = v1;
        }
        return v1;
    }

    public static v b()
    {
        v v2 = k;
        v v1 = v2;
        if (v2 == null)
        {
            v1 = new v("Months", new m[] {
                b.a.a.m.i()
            }, new int[] {
                -1, 0, -1, -1, -1, -1, -1, -1
            });
            k = v1;
        }
        return v1;
    }

    public static v c()
    {
        v v2 = l;
        v v1 = v2;
        if (v2 == null)
        {
            v1 = new v("Weeks", new m[] {
                b.a.a.m.g()
            }, new int[] {
                -1, -1, 0, -1, -1, -1, -1, -1
            });
            l = v1;
        }
        return v1;
    }

    public static v d()
    {
        v v2 = m;
        v v1 = v2;
        if (v2 == null)
        {
            v1 = new v("Days", new m[] {
                b.a.a.m.f()
            }, new int[] {
                -1, -1, -1, 0, -1, -1, -1, -1
            });
            m = v1;
        }
        return v1;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof v))
        {
            return false;
        } else
        {
            obj = (v)obj;
            return Arrays.equals(o, ((v) (obj)).o);
        }
    }

    public final int hashCode()
    {
        int i1 = 0;
        int j1 = 0;
        for (; i1 < o.length; i1++)
        {
            j1 += o[i1].hashCode();
        }

        return j1;
    }

    public final String toString()
    {
        return (new StringBuilder("PeriodType[")).append(n).append("]").toString();
    }

}
