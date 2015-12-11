// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.support.v7.internal.view.menu.h;
import android.support.v7.internal.view.menu.k;
import android.support.v7.internal.view.menu.p;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            a

private final class ew.menu.k.e extends k
{

    final a g;
    private p h;

    public final void onDismiss()
    {
        super.onDismiss();
        g.n = null;
        g.q = 0;
    }

    public ew.menu.f(a a1, Context context, p p1)
    {
        boolean flag1 = false;
        g = a1;
        super(context, p1, null, false, android.support.v7.b.actionOverflowMenuStyle);
        h = p1;
        int i;
        if (!((h)p1.getItem()).f())
        {
            int j;
            boolean flag;
            if (a1.i == null)
            {
                context = (View)a1.g;
            } else
            {
                context = a1.i;
            }
            super.b = context;
        }
        super.d = a1.p;
        j = p1.size();
        i = 0;
        do
        {
label0:
            {
                flag = flag1;
                if (i < j)
                {
                    a1 = p1.getItem(i);
                    if (!a1.isVisible() || a1.getIcon() == null)
                    {
                        break label0;
                    }
                    flag = true;
                }
                super.e = flag;
                return;
            }
            i++;
        } while (true);
    }
}
