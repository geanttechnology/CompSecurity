// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.content.res.Resources;
import com.groupon.db.models.DealCollection;
import com.groupon.view.PlaceholderUrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            CollectionCardView

public class FullBleedCollectionCardView extends CollectionCardView
{

    protected PlaceholderUrlImageView callToActionImageView;

    public FullBleedCollectionCardView(Context context)
    {
        super(context, 0x7f0300f3);
    }

    public void updateContent(DealCollection dealcollection)
    {
        super.updateContent(dealcollection);
        backgroundImageView.requestImage(dealcollection.getValue("backgroundImage", null));
        iconImageView.requestImage(dealcollection.getValue("iconImage", null));
        callToActionImageView.requestImage(dealcollection.getValue("callToActionImage", null));
        setupTextFieldColor(titleView, dealcollection.getValue("titleTextColor", null), getResources().getColor(0x7f0e01a9));
        setupTextFieldColor(collectionSizeView, dealcollection.getValue("collectionSizeTextColor", null), getResources().getColor(0x7f0e01a9));
        setupTextFieldColor(discountView, dealcollection.getValue("maxDiscountTextColor", null), getResources().getColor(0x7f0e01a9));
        setupTextFieldColor(callToActionView, dealcollection.getValue("callToActionTextColor", null), getResources().getColor(0x7f0e01a9));
    }
}
