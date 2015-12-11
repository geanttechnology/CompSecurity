// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.app.Activity;
import android.content.Intent;
import com.smule.android.network.core.b;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.ap;
import com.smule.android.network.models.ListingV2;
import com.smule.pianoandroid.magicpiano.PurchaseActivity_;
import com.smule.pianoandroid.magicpiano.n;
import java.util.List;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o, i

final class c
    implements Runnable
{

    final Activity a;
    final ListingV2 b;
    final n c;

    public void run()
    {
        List list = ap.a().f();
        if (r.a(a) && list != null && !list.isEmpty())
        {
            Intent intent = new Intent(a, com/smule/pianoandroid/magicpiano/PurchaseActivity_);
            intent.putExtra(i.a, b.listingId);
            intent.putExtra(com.smule.pianoandroid.utils.i.b, b.b());
            a.startActivityForResult(intent, 214);
            a.overridePendingTransition(0x7f040013, 0x7f040015);
        } else
        {
            com.smule.android.network.core.b.d().p();
        }
        c.dismiss();
    }

    n(Activity activity, ListingV2 listingv2, n n1)
    {
        a = activity;
        b = listingv2;
        c = n1;
        super();
    }
}
