// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager

static class j
{

    boolean a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    List j;

    private View a()
    {
        j j1;
        int k;
        int l;
        int k1;
        k1 = j.size();
        k = 0x7fffffff;
        l = 0;
        j1 = null;
_L2:
        j j2;
        if (l >= k1)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        j2 = (j)j.get(l);
        if (i || !j2.i())
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        l++;
        if (true) goto _L2; else goto _L1
_L1:
        int i1 = (j2.i() - d) * e;
        if (i1 < 0 || i1 >= k) goto _L4; else goto _L3
_L3:
        if (i1 != 0) goto _L6; else goto _L5
_L5:
        if (j2 != null)
        {
            d = j2.d() + e;
            return j2.w;
        } else
        {
            return null;
        }
_L6:
        j1 = j2;
        k = i1;
          goto _L4
        j2 = j1;
          goto _L5
    }

    View a(w w)
    {
        if (j != null)
        {
            return a();
        } else
        {
            w = w.a(d);
            d = d + e;
            return w;
        }
    }

    boolean a(e e1)
    {
        return d >= 0 && d < e1.d();
    }

    ()
    {
        a = true;
        h = 0;
        i = false;
        j = null;
    }
}
