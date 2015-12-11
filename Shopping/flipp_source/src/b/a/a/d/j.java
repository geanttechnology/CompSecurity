// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;


// Referenced classes of package b.a.a.d:
//            t, u

final class j
    implements t
{

    private final t a[];
    private final int b;

    j(t at[])
    {
        a = at;
        int i = 0;
        int k = at.length;
        do
        {
            k--;
            if (k < 0)
            {
                break;
            }
            t t1 = at[k];
            if (t1 != null)
            {
                int l = t1.b();
                if (l > i)
                {
                    i = l;
                }
            }
        } while (true);
        b = i;
    }

    public final int a(u u1, String s, int i)
    {
        Object obj;
        t at[];
        Object obj1;
        int k;
        int l;
        int i1;
        int k1;
        at = a;
        k1 = at.length;
        obj1 = u1.a();
        obj = null;
        i1 = 0;
        l = i;
        k = i;
_L3:
        t t1;
        if (i1 >= k1)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        t1 = at[i1];
        if (t1 != null) goto _L2; else goto _L1
_L1:
        if (k <= i)
        {
            return i;
        }
        i1 = 1;
_L4:
        int j1;
        if (k > i || k == i && i1 != 0)
        {
            if (obj != null)
            {
                u1.a(obj);
            }
            return k;
        } else
        {
            return ~l;
        }
_L2:
        j1 = t1.a(u1, s, i);
        if (j1 >= i)
        {
            if (j1 > k)
            {
                if (j1 >= s.length() || i1 + 1 >= k1 || at[i1 + 1] == null)
                {
                    return j1;
                }
                obj = u1.a();
                k = j1;
            }
        } else
        if (j1 < 0)
        {
            j1 = ~j1;
            if (j1 > l)
            {
                l = j1;
            }
        }
        u1.a(obj1);
        i1++;
          goto _L3
        i1 = 0;
          goto _L4
    }

    public final int b()
    {
        return b;
    }
}
