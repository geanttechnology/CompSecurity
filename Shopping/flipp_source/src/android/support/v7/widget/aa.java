// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            bi, az, bf

final class aa
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

    aa()
    {
        a = true;
        h = 0;
        i = false;
        j = null;
    }

    final View a(az az1)
    {
        if (j != null)
        {
            int j1 = j.size();
            int k = 0x7fffffff;
            int l = 0;
            az1 = null;
            for (; l < j1; l++)
            {
                bi bi1 = (bi)j.get(l);
                if (!i && bi1.m())
                {
                    continue;
                }
                int i1 = (bi1.c() - d) * e;
                if (i1 < 0 || i1 >= k)
                {
                    continue;
                }
                az1 = bi1;
                if (i1 == 0)
                {
                    break;
                }
                az1 = bi1;
                k = i1;
            }

            if (az1 != null)
            {
                d = az1.c() + e;
                return ((bi) (az1)).a;
            } else
            {
                return null;
            }
        } else
        {
            az1 = az1.b(d);
            d = d + e;
            return az1;
        }
    }

    final boolean a(bf bf1)
    {
        return d >= 0 && d < bf1.a();
    }
}
