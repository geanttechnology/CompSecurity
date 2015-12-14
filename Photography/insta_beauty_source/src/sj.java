// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;

class sj
    implements android.view.View.OnClickListener
{

    final AlertDialog a;
    final si b;

    sj(si si, AlertDialog alertdialog)
    {
        b = si;
        a = alertdialog;
        super();
    }

    public void onClick(View view)
    {
        a.dismiss();
    }
}
