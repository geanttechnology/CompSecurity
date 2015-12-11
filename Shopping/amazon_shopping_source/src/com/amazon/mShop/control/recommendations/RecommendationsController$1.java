// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;

import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsController, RecommendationsRatingSubscriber

class this._cls0
    implements Runnable
{

    final RecommendationsController this$0;

    public void run()
    {
        RecommendationsController.access$002(RecommendationsController.this, false);
        Object obj = com.amazon.mShop.platform.().getDataStore().getString("userRatingRequestErrorSet");
        if (obj == null)
        {
            obj = RecommendationsController.access$100(RecommendationsController.this);
        } else
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(RecommendationsController.access$100(RecommendationsController.this)).toString();
        }
        com.amazon.mShop.platform.().getDataStore().putString("userRatingRequestErrorSet", ((String) (obj)));
        for (obj = (new ArrayList(RecommendationsController.access$200(RecommendationsController.this))).iterator(); ((Iterator) (obj)).hasNext(); ((RecommendationsRatingSubscriber)((Iterator) (obj)).next()).onRecsRatingCallError()) { }
    }

    ber()
    {
        this$0 = RecommendationsController.this;
        super();
    }
}
