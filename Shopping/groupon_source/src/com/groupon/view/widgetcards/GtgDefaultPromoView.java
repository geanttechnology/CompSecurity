// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.groupon.db.models.Finder;
import com.groupon.view.PlaceholderUrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            FrameViewContainer

public class GtgDefaultPromoView extends FrameViewContainer
{

    protected PlaceholderUrlImageView backgroundImageView;
    protected PlaceholderUrlImageView callToActionImageView;
    protected TextView callToActionView;
    protected PlaceholderUrlImageView iconImageView;
    protected TextView titleView;

    public GtgDefaultPromoView(Context context)
    {
        super(context, null, 0);
    }

    public GtgDefaultPromoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0);
    }

    public GtgDefaultPromoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setInfo(Object obj)
    {
        obj = (Finder)obj;
        setupImage(backgroundImageView, ((Finder) (obj)).backgroundImage);
        setupImage(iconImageView, ((Finder) (obj)).iconImage);
        setupImage(callToActionImageView, ((Finder) (obj)).callToActionImage);
        setupTextField(titleView, ((Finder) (obj)).titleText, 0x7f08012f, ((Finder) (obj)).titleTextColor, 0x7f0e01a9);
        setupTextField(callToActionView, ((Finder) (obj)).callToActionText, 0x7f0802cf, ((Finder) (obj)).callToActionTextColor, 0x7f0e00fc);
    }
}
