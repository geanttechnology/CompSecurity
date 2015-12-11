// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import com.b.a.a.g;
import com.offerup.android.network.ItemService;
import com.offerup.android.network.o;
import java.util.concurrent.Executors;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity, dz

final class dk
    implements android.content.DialogInterface.OnClickListener
{

    private String a;
    private MyOffersActivity b;

    dk(MyOffersActivity myoffersactivity, String s)
    {
        b = myoffersactivity;
        a = s;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            b.g = ProgressDialog.show(b, "", (new StringBuilder("Deleting ")).append(a).toString());
            long l = MyOffersActivity.e(b);
            dialoginterface = new dz(b, (byte)0);
            o.l(o.a(Executors.newSingleThreadExecutor())).deleteItem(l, dialoginterface);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            g.a(this, dialoginterface);
        }
    }
}
