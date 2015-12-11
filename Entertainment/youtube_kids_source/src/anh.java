// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class anh
    implements anq
{

    final s a = null;
    private final aro b;
    private final List c = new ArrayList();
    private final HashMap d = new HashMap();
    private final Handler e = null;
    private final long f;
    private final long g;
    private final float h;
    private final float i;
    private int j;
    private long k;
    private int l;
    private boolean m;
    private boolean n;

    public anh(aro aro1, Handler handler, s s, int i1, int j1, float f1, float f2)
    {
        b = aro1;
        f = (long)i1 * 1000L;
        g = (long)j1 * 1000L;
        h = f1;
        i = f2;
    }

    private void a(boolean flag)
    {
        if (e != null && a != null)
        {
            e.post(new ani(this, flag));
        }
    }

    private void c()
    {
        boolean flag2;
        boolean flag3 = false;
        int j1 = l;
        int i1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        flag2 = false;
        while (i1 < c.size()) 
        {
            anj anj1 = (anj)d.get(c.get(i1));
            flag2 |= anj1.c;
            boolean flag4 = flag1 | anj1.d;
            if (anj1.e != -1L)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag |= flag1;
            j1 = Math.max(j1, anj1.b);
            i1++;
            flag1 = flag4;
        }
        Object obj;
        long l1;
        boolean flag5;
        if (!c.isEmpty() && !flag1 && (flag2 || flag) && (j1 == 2 || j1 == 1 && m))
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        m = flag5;
        if (!m || n) goto _L2; else goto _L1
_L1:
        asm.a.b(0);
        n = true;
        a(true);
_L4:
        k = -1L;
        if (m)
        {
            for (i1 = ((flag3) ? 1 : 0); i1 < c.size(); i1++)
            {
                obj = c.get(i1);
                l1 = ((anj)d.get(obj)).e;
                if (l1 != -1L && (k == -1L || l1 < k))
                {
                    k = l1;
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!m && n && !flag2)
        {
            asm.a.c(0);
            n = false;
            a(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a()
    {
        b.b(j);
    }

    public final void a(Object obj)
    {
        c.remove(obj);
        obj = (anj)d.remove(obj);
        j = j - ((anj) (obj)).a;
        c();
    }

    public final void a(Object obj, int i1)
    {
        c.add(obj);
        d.put(obj, new anj(i1));
        j = j + i1;
    }

    public final boolean a(Object obj, long l1, long l2, boolean flag, boolean flag1)
    {
        float f1;
        int i1;
        boolean flag2;
        boolean flag3;
        int j1;
        if (l2 == -1L)
        {
            i1 = 0;
        } else
        {
            l1 = l2 - l1;
            if (l1 > g)
            {
                i1 = 0;
            } else
            if (l1 < f)
            {
                i1 = 2;
            } else
            {
                i1 = 1;
            }
        }
        obj = (anj)d.get(obj);
        if (((anj) (obj)).b != i1 || ((anj) (obj)).e != l2 || ((anj) (obj)).c != flag || ((anj) (obj)).d != flag1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            obj.b = i1;
            obj.e = l2;
            obj.c = flag;
            obj.d = flag1;
        }
        j1 = b.a();
        f1 = (float)j1 / (float)j;
        if (f1 > i)
        {
            i1 = 0;
        } else
        if (f1 < h)
        {
            i1 = 2;
        } else
        {
            i1 = 1;
        }
        if (l != i1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag3)
        {
            l = i1;
        }
        if (flag2 || flag3)
        {
            c();
        }
        return j1 < j && l2 != -1L && l2 <= k;
    }

    public final aro b()
    {
        return b;
    }
}
