// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;

final class op
    implements android.view.View.OnClickListener
{

    final AlertDialog a;
    final ql b;

    op(AlertDialog alertdialog, ql ql1)
    {
        a = alertdialog;
        b = ql1;
        super();
    }

    public void onClick(View view)
    {
        a.dismiss();
        if (b != null)
        {
            b.a();
        }
    }
}
