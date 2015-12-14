// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;

class rc
    implements android.view.View.OnClickListener
{

    final rb a;

    rc(rb rb1)
    {
        a = rb1;
        super();
    }

    public void onClick(View view)
    {
        a.a.a();
        a.dismiss();
    }
}
