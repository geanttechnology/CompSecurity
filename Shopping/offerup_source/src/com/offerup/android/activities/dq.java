// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import android.support.v4.e.a;
import com.b.a.a.g;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity

final class dq
    implements android.content.DialogInterface.OnClickListener
{

    private android.app.AlertDialog.Builder a;
    private MyOffersActivity b;

    dq(MyOffersActivity myoffersactivity, android.app.AlertDialog.Builder builder)
    {
        b = myoffersactivity;
        a = builder;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (android.support.v4.e.a.b(b))
        {
            com.offerup.android.activities.MyOffersActivity.a(b);
            return;
        }
        try
        {
            n.a(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            g.a(b, dialoginterface);
        }
        return;
    }
}
