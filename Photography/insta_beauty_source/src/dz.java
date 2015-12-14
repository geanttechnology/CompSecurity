// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

class dz
    implements android.view.View.OnClickListener
{

    final ActionMenuItem a;
    final dy b;

    dz(dy dy1)
    {
        b = dy1;
        super();
        a = new ActionMenuItem(dy.a(b).getContext(), 0, 0x102002c, 0, 0, dy.b(b));
    }

    public void onClick(View view)
    {
        if (dy.c(b) != null && dy.d(b))
        {
            dy.c(b).a(0, a);
        }
    }
}
