// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.groupon.db.models.Finder;
import com.groupon.view.PlaceholderUrlImageView;
import com.groupon.view.dealcards.PicassoCallback;
import com.squareup.picasso.Callback;

// Referenced classes of package com.groupon.view.widgetcards:
//            FrameViewContainer

public class FinderCardView extends FrameViewContainer
    implements PicassoCallback
{

    protected PlaceholderUrlImageView backgroundImageView;
    protected PlaceholderUrlImageView callToActionImageView;
    protected TextView callToActionView;
    protected TextView discountView;
    protected PlaceholderUrlImageView iconImageView;
    protected TextView titleView;

    public FinderCardView(Context context)
    {
        this(context, null, 0);
    }

    public FinderCardView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FinderCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void init(Context context)
    {
        super.init(context);
        inflate(context, 0x7f0300e7, this);
        onFinishInflate();
    }

    public void setCallback(Callback callback)
    {
        backgroundImageView.setCallback(callback);
        iconImageView.setCallback(callback);
        callToActionImageView.setCallback(callback);
    }

    public void setInfo(Object obj)
    {
        obj = (Finder)obj;
        backgroundImageView.requestImage(((Finder) (obj)).backgroundImage);
        iconImageView.requestImage(((Finder) (obj)).iconImage);
        callToActionImageView.requestImage(((Finder) (obj)).callToActionImage);
        setupTextField(titleView, ((Finder) (obj)).titleText, ((Finder) (obj)).titleTextColor);
        setupTextField(discountView, ((Finder) (obj)).discountText, ((Finder) (obj)).discountTextColor);
        setupTextField(callToActionView, ((Finder) (obj)).callToActionText, ((Finder) (obj)).callToActionTextColor);
    }
}
