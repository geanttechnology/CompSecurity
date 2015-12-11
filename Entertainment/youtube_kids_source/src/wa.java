// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class wa
    implements android.view.View.OnClickListener
{

    private vy a;

    wa(vy vy1)
    {
        a = vy1;
        super();
    }

    public final void onClick(View view)
    {
        if (a.b())
        {
            a.dismiss();
        }
    }
}
