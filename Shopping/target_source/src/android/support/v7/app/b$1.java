// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.view.View;

// Referenced classes of package android.support.v7.app:
//            b

class a
    implements android.view..OnClickListener
{

    final b a;

    public void onClick(View view)
    {
        if (b.a(a))
        {
            b.b(a);
        } else
        if (b.c(a) != null)
        {
            b.c(a).onClick(view);
            return;
        }
    }

    stener(b b1)
    {
        a = b1;
        super();
    }
}
