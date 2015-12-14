// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

class b
    implements android.view.OnClickListener
{

    final ActionMenuItem a;
    final ck b;

    public void onClick(View view)
    {
        if (ck.c(b) != null && ck.d(b))
        {
            ck.c(b).a(0, a);
        }
    }

    >(ck ck1)
    {
        b = ck1;
        super();
        a = new ActionMenuItem(ck.a(b).getContext(), 0, 0x102002c, 0, 0, ck.b(b));
    }
}
