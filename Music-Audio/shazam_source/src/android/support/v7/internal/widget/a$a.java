// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.widget;

import android.support.v4.view.ad;
import android.support.v4.view.ah;
import android.support.v7.widget.ActionMenuView;
import android.view.View;

// Referenced classes of package android.support.v7.internal.widget:
//            a

protected final class c
    implements ah
{

    int a;
    final a b;
    private boolean c;

    public final c a(ad ad, int i)
    {
        b.i = ad;
        a = i;
        return this;
    }

    public final void a(View view)
    {
        b.setVisibility(0);
        c = false;
    }

    public final void b(View view)
    {
        if (!c)
        {
            b.i = null;
            b.setVisibility(a);
            if (b.e != null && b.c != null)
            {
                b.c.setVisibility(a);
                return;
            }
        }
    }

    public final void c(View view)
    {
        c = true;
    }

    protected w(a a1)
    {
        b = a1;
        super();
        c = false;
    }
}
