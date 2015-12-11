// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            FavoriteDealTypes, IntentFactory

class this._cls0
    implements android.view.
{

    final FavoriteDealTypes this$0;

    public void onClick(View view)
    {
        Ln.d(String.format("DEALTYPES: cat=%s, action=%s, label=%s, value=%d", new Object[] {
            "deal_types", "see_personalized_deals_click", "page", Integer.valueOf(2)
        }), new Object[0]);
        FavoriteDealTypes.access$000(FavoriteDealTypes.this).logGeneralEvent("deal_types", "see_personalized_deals_click", "page", 2, Logger.NULL_NST_FIELD);
        startActivity(FavoriteDealTypes.access$100(FavoriteDealTypes.this).newCarouselIntent());
    }

    ()
    {
        this$0 = FavoriteDealTypes.this;
        super();
    }
}
