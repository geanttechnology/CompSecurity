// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.cvsd;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.cvsd:
//            CVSDStoreDetailsView

public class CVSDStoreDetailsActivity extends AmazonActivity
{

    public CVSDStoreDetailsActivity()
    {
    }

    protected void onStart()
    {
        super.onStart();
        super.setRootView(new CVSDStoreDetailsView(this));
    }
}
