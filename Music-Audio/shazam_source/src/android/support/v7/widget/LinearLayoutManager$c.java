// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            LinearLayoutManager

static final class k
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
    int j;
    List k;

    public final void a(k k1)
    {
        int l1 = k.size();
        k k2 = null;
        int l = 0x7fffffff;
        for (int i1 = 0; i1 < l1; i1++)
        {
            k k3 = (k)k.get(i1);
            if (k3 == k1 || k3.k())
            {
                continue;
            }
            int j1 = (k3.k() - d) * e;
            if (j1 < 0 || j1 >= l)
            {
                continue;
            }
            k2 = k3;
            if (j1 == 0)
            {
                break;
            }
            k2 = k3;
            l = j1;
        }

        if (k2 == null)
        {
            l = -1;
        } else
        {
            l = k2.e();
        }
        d = l;
    }

    ()
    {
        a = true;
        h = 0;
        i = false;
        k = null;
    }
}
