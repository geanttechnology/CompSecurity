// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.q;

// Referenced classes of package android.support.v7.app:
//            h, ActionBar

private class <init>
    implements <init>
{

    final h a;

    public Drawable a()
    {
        q q1 = q.a(b(), null, new int[] {
            android.support.v7..homeAsUpIndicator
        });
        Drawable drawable = q1.a(0);
        q1.b();
        return drawable;
    }

    public void a(int i)
    {
        ActionBar actionbar = a.a();
        if (actionbar != null)
        {
            actionbar.a(i);
        }
    }

    public void a(Drawable drawable, int i)
    {
        ActionBar actionbar = a.a();
        if (actionbar != null)
        {
            actionbar.a(drawable);
            actionbar.a(i);
        }
    }

    public Context b()
    {
        return a.k();
    }

    public boolean c()
    {
        ActionBar actionbar = a.a();
        return actionbar != null && (actionbar.b() & 4) != 0;
    }

    private rawable(h h1)
    {
        a = h1;
        super();
    }

    a(h h1, a a1)
    {
        this(h1);
    }
}
