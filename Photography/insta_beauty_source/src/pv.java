// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;

class pv
    implements android.view.View.OnClickListener
{

    final pu a;

    pv(pu pu1)
    {
        a = pu1;
        super();
    }

    public void onClick(View view)
    {
        a.c.a();
        a.d.dismiss();
    }
}
