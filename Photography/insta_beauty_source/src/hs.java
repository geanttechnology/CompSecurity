// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;

class hs
    implements android.view.View.OnClickListener
{

    final hq a;
    final hr b;

    hs(hr hr1, hq hq1)
    {
        b = hr1;
        a = hq1;
        super();
    }

    public void onClick(View view)
    {
        Log.i("FotoAlertFactory", "positiveButtonClick");
        hr.a(b).onClick(a, -1);
        a.hide();
    }
}
