// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.db.models.DealCollection;
import com.groupon.util.ColorUtil;
import com.groupon.view.PlaceholderUrlImageView;
import com.groupon.view.dealcards.PicassoCallback;
import com.squareup.picasso.Callback;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class CollectionCardView extends FrameLayout
    implements PicassoCallback
{

    protected PlaceholderUrlImageView backgroundImageView;
    protected TextView callToActionView;
    protected TextView collectionSizeView;
    private ColorUtil colorUtil;
    protected TextView discountView;
    protected PlaceholderUrlImageView iconImageView;
    protected TextView titleView;

    public CollectionCardView(Context context)
    {
        this(context, null, 0);
    }

    public CollectionCardView(Context context, int i)
    {
        this(context, null, 0);
        colorUtil = (ColorUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/ColorUtil);
        inflate(context, i, this);
        onFinishInflate();
    }

    public CollectionCardView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public CollectionCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setCallback(Callback callback)
    {
        backgroundImageView.setCallback(callback);
        iconImageView.setCallback(callback);
    }

    protected void setupTextFieldColor(TextView textview, String s, int i)
    {
        textview.setTextColor(colorUtil.extractColorFromString(s, i));
    }

    public void updateContent(DealCollection dealcollection)
    {
        titleView.setText(dealcollection.getValue("titleText", null));
        collectionSizeView.setText(dealcollection.getValue("collectionSizeText", null));
        discountView.setText(dealcollection.getValue("maxDiscountText", null));
        callToActionView.setText(dealcollection.getValue("callToActionText", null));
    }
}
