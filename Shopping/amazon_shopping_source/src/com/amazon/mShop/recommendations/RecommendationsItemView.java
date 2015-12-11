// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.content.Context;
import android.util.AttributeSet;
import com.amazon.mShop.ItemView;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;

public class RecommendationsItemView extends ItemView
{

    public RecommendationsItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void dispatchSetPressed(boolean flag)
    {
    }

    public boolean shouldShowItemBadge(BasicOfferListing basicofferlisting)
    {
        return false;
    }
}
