// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;

class on
    implements android.view.View.OnClickListener
{

    final AlertDialog a;
    final oj b;

    on(oj oj1, AlertDialog alertdialog)
    {
        b = oj1;
        a = alertdialog;
        super();
    }

    public void onClick(View view)
    {
        a.dismiss();
        oj.c(b, oj.g(b));
    }
}
