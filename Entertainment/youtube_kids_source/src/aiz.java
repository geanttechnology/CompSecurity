// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

final class aiz
    implements android.view.View.OnClickListener
{

    private aiy a;

    aiz(aiy aiy1)
    {
        a = aiy1;
        super();
    }

    public final void onClick(View view)
    {
        if (a.b.a())
        {
            view = a.c;
            boolean flag = ((ajb) (view)).b;
            view.c = true;
            view = a.a;
            ir.b().c();
        }
        a.dismiss();
    }
}
