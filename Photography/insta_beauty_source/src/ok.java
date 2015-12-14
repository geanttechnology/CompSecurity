// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.view.View;

class ok
    implements android.view.View.OnClickListener
{

    final oj a;

    ok(oj oj1)
    {
        a = oj1;
        super();
    }

    public void onClick(View view)
    {
        a.a.dismiss();
        oj.a(a);
    }
}
