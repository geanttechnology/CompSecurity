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

public class GtgDefaultJumpOffView extends FrameViewContainer
{

    protected PlaceholderUrlImageView callToActionImageView;
    protected TextView callToActionView;
    protected PlaceholderUrlImageView iconImageView;
    protected TextView titleView;

    public GtgDefaultJumpOffView(Context context)
    {
        super(context, null, 0);
    }

    public GtgDefaultJumpOffView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0);
    }

    public GtgDefaultJumpOffView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void setInfo(Object obj)
    {
        obj = (Finder)obj;
        setupImage(iconImageView, ((Finder) (obj)).iconImage);
        setupImage(callToActionImageView, ((Finder) (obj)).callToActionImage);
        setupTextField(titleView, ((Finder) (obj)).titleText, 0x7f08012f, ((Finder) (obj)).titleTextColor, 0x7f0e00ee);
        setupTextField(callToActionView, ((Finder) (obj)).callToActionText, 0x7f0802db, ((Finder) (obj)).callToActionTextColor, 0x7f0e00d7);
    }
}
