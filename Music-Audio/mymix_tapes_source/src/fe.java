// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public class fe
    implements ey
{

    private static final bm a = d.a(fe);
    private Vector b;

    public fe()
    {
        if (a.b())
        {
            a.b("AlternativeImpl()");
        }
        b = new Vector();
    }

    public fe(Vector vector)
    {
        if (a.b())
        {
            a.b("AlternativeImpl(Vector)");
        }
        b = vector;
    }

    private fh b(int i)
    {
        return (fh)b.elementAt(i);
    }

    public static void b()
    {
    }

    public final int a()
    {
        int i;
        int k;
        int l;
        i = 0;
        k = 0;
        l = b.size();
        if (l != 0) goto _L2; else goto _L1
_L1:
        return k;
_L2:
        int j = 0;
        do
        {
            k = i;
            if (j >= l)
            {
                continue;
            }
            k = i;
            if (!b(j).f())
            {
                k = i + 1;
            }
            j++;
            i = k;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final fd a(int i)
    {
        int j;
        int k;
        k = -1;
        j = -1;
_L9:
        if (k == i) goto _L2; else goto _L1
_L1:
        int l = j + 1;
        if (l <= b.size()) goto _L4; else goto _L3
_L3:
        Object obj = null;
_L6:
        return ((fd) (obj));
_L4:
        j = l;
        if (!b(l).f())
        {
            k++;
            j = l;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        fh fh1;
        fh1 = b(j);
        if (j + 1 < b.size() && b(j + 1).f())
        {
            b(j + 1);
        }
        obj = fh1;
        if (j == 0) goto _L6; else goto _L5
_L5:
        obj = fh1;
        if (!b(j - 1).f()) goto _L6; else goto _L7
_L7:
        b(j - 1);
        return fh1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public String toString()
    {
        if (b.size() == 0)
        {
            return "";
        }
        StringBuffer stringbuffer = new StringBuffer("");
        for (int i = 0; i < b.size(); i++)
        {
            stringbuffer.append(b.elementAt(i));
        }

        return stringbuffer.toString();
    }

}
