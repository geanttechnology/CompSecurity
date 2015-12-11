// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v4.e.a;
import com.b.a.a.g;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            k

final class q
    implements android.content.DialogInterface.OnClickListener
{

    private AsyncTask a;
    private Object b[];
    private android.app.AlertDialog.Builder c;
    private k d;

    q(k k1, AsyncTask asynctask, Object aobj[], android.app.AlertDialog.Builder builder)
    {
        d = k1;
        a = asynctask;
        b = aobj;
        c = builder;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (android.support.v4.e.a.b(d))
        {
            d.a(a, b);
            return;
        }
        try
        {
            n.a(c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            g.a(this, dialoginterface);
        }
        return;
    }
}
