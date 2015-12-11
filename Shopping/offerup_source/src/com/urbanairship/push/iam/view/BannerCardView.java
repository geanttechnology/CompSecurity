// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;

// Referenced classes of package com.urbanairship.push.iam.view:
//            Banner, BannerContent

public class BannerCardView extends CardView
    implements Banner
{

    private final BannerContent content;

    public BannerCardView(Context context)
    {
        this(context, null, com.urbanairship.R.attr.inAppMessageBannerStyle);
    }

    public BannerCardView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.urbanairship.R.attr.inAppMessageBannerStyle);
    }

    public BannerCardView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        content = new BannerContent(context, this, attributeset, i);
        if (attributeset != null)
        {
            context = context.getTheme().obtainStyledAttributes(attributeset, com.urbanairship.R.styleable.CardView, i, com.urbanairship.R.style.InAppMessage_Banner);
            if (!context.hasValue(com.urbanairship.R.styleable.CardView_cardBackgroundColor) && context.hasValue(com.urbanairship.R.styleable.CardView_optCardBackgroundColor))
            {
                setCardBackgroundColor(context.getInteger(com.urbanairship.R.styleable.CardView_optCardBackgroundColor, 0));
            }
            if (!context.hasValue(com.urbanairship.R.styleable.CardView_cardElevation) && context.hasValue(com.urbanairship.R.styleable.CardView_optCardElevation))
            {
                float f = context.getDimension(com.urbanairship.R.styleable.CardView_optCardElevation, 0.0F);
                if (f > getMaxCardElevation())
                {
                    setMaxCardElevation(f);
                }
                setCardElevation(f);
            }
            if (!context.hasValue(com.urbanairship.R.styleable.CardView_cardCornerRadius) && context.hasValue(com.urbanairship.R.styleable.CardView_optCardCornerRadius))
            {
                setRadius(context.getDimension(com.urbanairship.R.styleable.CardView_optCardCornerRadius, 0.0F));
            }
            context.recycle();
        }
        setCardBackgroundColor(content.getPrimaryColor());
    }

    public void setNotificationActionButtonGroup(NotificationActionButtonGroup notificationactionbuttongroup)
    {
        content.setNotificationActionButtonGroup(notificationactionbuttongroup);
    }

    public void setOnActionClickListener(Banner.OnActionClickListener onactionclicklistener)
    {
        content.setOnActionClickListener(onactionclicklistener);
    }

    public void setOnDismissClickListener(Banner.OnDismissClickListener ondismissclicklistener)
    {
        content.setOnDismissClickListener(ondismissclicklistener);
    }

    public void setPrimaryColor(int i)
    {
        setCardBackgroundColor(i);
        content.setPrimaryColor(i);
    }

    public void setSecondaryColor(int i)
    {
        content.setSecondaryColor(i);
    }

    public void setText(CharSequence charsequence)
    {
        content.setText(charsequence);
    }
}
