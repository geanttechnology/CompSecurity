// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;

class lang.Object
    implements android.view.OnClickListener
{

    final el a;
    final em b;

    public void onClick(View view)
    {
        Log.i("FotoAlertFactory", "positiveButtonClick");
        em.a(b).onClick(a, -1);
        a.hide();
    }

    >(em em1, el el1)
    {
        b = em1;
        a = el1;
        super();
    }
}
