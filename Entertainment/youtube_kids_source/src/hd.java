// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

public final class hd
    implements fa
{

    private boolean a;
    private hc b;

    protected hd(hc hc1)
    {
        b = hc1;
        super();
        a = false;
    }

    public final void a(View view)
    {
        b.setVisibility(0);
        a = false;
    }

    public final void b(View view)
    {
        if (a)
        {
            return;
        } else
        {
            b.c = null;
            b.setVisibility(0);
            view = b;
            return;
        }
    }

    public final void c(View view)
    {
        a = true;
    }
}
