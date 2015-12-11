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

final class do
    implements android.content.DialogInterface.OnClickListener
{

    private int a;
    private android.app.AlertDialog.Builder b;
    private MyOffersActivity c;

    do(MyOffersActivity myoffersactivity, int i, android.app.AlertDialog.Builder builder)
    {
        c = myoffersactivity;
        a = i;
        b = builder;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if (!android.support.v4.e.a.b(c)) goto _L2; else goto _L1
_L1:
        a;
        JVM INSTR tableswitch 2 4: default 87
    //                   2 63
    //                   3 48
    //                   4 71;
           goto _L3 _L4 _L5 _L6
_L5:
        MyOffersActivity.j(c);
        return;
_L4:
        try
        {
            MyOffersActivity.k(c);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            g.a(this, dialoginterface);
            return;
        }
_L6:
        MyOffersActivity.b(c);
        return;
_L2:
        n.a(b);
        return;
_L3:
    }
}
