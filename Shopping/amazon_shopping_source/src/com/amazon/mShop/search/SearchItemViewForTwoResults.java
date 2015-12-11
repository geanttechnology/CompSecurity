// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.amazon.mShop.ItemView;
import com.amazon.mShop.ObjectSubscriberAdapter;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

public class SearchItemViewForTwoResults extends ItemView
{

    public SearchItemViewForTwoResults(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void update(ObjectSubscriberAdapter objectsubscriberadapter, Object obj, Drawable drawable, int i)
    {
        super.update(objectsubscriberadapter, obj, drawable, i);
        objectsubscriberadapter = (SearchResult)obj;
        showBadgeImageTogetherWithPrice(objectsubscriberadapter.getBasicOffer(), objectsubscriberadapter.getBasicProduct());
    }
}
