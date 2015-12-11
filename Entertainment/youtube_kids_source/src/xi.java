// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class xi
    implements android.view.View.OnClickListener
{

    private xg a;

    xi(xg xg1)
    {
        a = xg1;
        super();
    }

    public final void onClick(View view)
    {
        xg.a(a).a(true);
        a.dismiss();
    }
}
