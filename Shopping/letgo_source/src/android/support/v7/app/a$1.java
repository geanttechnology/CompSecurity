// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.view.View;

// Referenced classes of package android.support.v7.app:
//            a

class a
    implements android.view..OnClickListener
{

    final a a;

    public void onClick(View view)
    {
        if (android.support.v7.app.a.a(a))
        {
            android.support.v7.app.a.b(a);
        } else
        if (android.support.v7.app.a.c(a) != null)
        {
            android.support.v7.app.a.c(a).onClick(view);
            return;
        }
    }

    stener(a a1)
    {
        a = a1;
        super();
    }
}
