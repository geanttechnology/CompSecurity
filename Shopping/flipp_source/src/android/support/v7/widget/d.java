// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            e, f

final class d
{

    final f a;
    final e b = new e();
    final List c = new ArrayList();

    d(f f1)
    {
        a = f1;
    }

    final int a()
    {
        return a.a() - c.size();
    }

    final int a(int i)
    {
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        i = -1;
        return i;
        int j;
        int k;
        int l;
        k = a.a();
        j = i;
          goto _L1
        continue; /* Loop/switch isn't completed */
        j += l;
    }

    final void a(View view, int i, android.view.ViewGroup.LayoutParams layoutparams, boolean flag)
    {
        if (i < 0)
        {
            i = a.a();
        } else
        {
            i = a(i);
        }
        a.a(view, i, layoutparams);
        b.a(i, flag);
        if (flag)
        {
            c.add(view);
        }
    }

    final void a(View view, int i, boolean flag)
    {
        if (i < 0)
        {
            i = a.a();
        } else
        {
            i = a(i);
        }
        a.a(view, i);
        b.a(i, flag);
        if (flag)
        {
            c.add(view);
        }
    }

    final int b()
    {
        return a.a();
    }

    final View b(int i)
    {
        i = a(i);
        return a.b(i);
    }

    final View c(int i)
    {
        return a.b(i);
    }

    public final String toString()
    {
        return (new StringBuilder()).append(b.toString()).append(", hidden list:").append(c.size()).toString();
    }
}
