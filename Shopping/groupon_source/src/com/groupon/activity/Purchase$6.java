// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.activity:
//            Purchase

class lbacks extends DealLoaderCallbacks
{

    final Purchase this$0;

    public void onDealLoaded(Deal deal)
    {
        onRequestDealSuccess(deal, isDeepLinked);
        if (Purchase.access$100(Purchase.this) != null)
        {
            Purchase.access$100(Purchase.this).execute();
            Purchase.access$102(Purchase.this, null);
        }
    }

    lbacks(Context context, String s)
    {
        this$0 = Purchase.this;
        super(context, s);
    }
}
