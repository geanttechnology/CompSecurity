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

public class NativeCollectionCardView extends CollectionCardView
{

    public NativeCollectionCardView(Context context)
    {
        super(context, 0x7f030172);
    }

    public void updateContent(DealCollection dealcollection)
    {
        super.updateContent(dealcollection);
        setupTextFieldColor(titleView, dealcollection.getValue("titleTextColor", null), getResources().getColor(0x7f0e00ee));
        setupTextFieldColor(collectionSizeView, dealcollection.getValue("collectionSizeTextColor", null), getResources().getColor(0x7f0e01a9));
        setupTextFieldColor(discountView, dealcollection.getValue("maxDiscountTextColor", null), getResources().getColor(0x7f0e00d7));
        setupTextFieldColor(callToActionView, dealcollection.getValue("callToActionTextColor", null), getResources().getColor(0x7f0e0004));
        backgroundImageView.requestImage(dealcollection.getValue("backgroundImage", null));
        iconImageView.requestImage(dealcollection.getValue("iconImage", null));
    }
}
