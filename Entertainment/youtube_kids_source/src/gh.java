// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class gh
    implements android.view.View.OnClickListener
{

    private ge a;

    gh(ge ge1)
    {
        a = ge1;
        super();
    }

    public final void onClick(View view)
    {
        if (ge.d(a).a())
        {
            ge.e(a);
            ir.b().c();
        }
        a.dismiss();
    }
}
