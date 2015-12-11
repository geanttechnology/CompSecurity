// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;

// Referenced classes of package com.urbanairship.push.iam.view:
//            Banner, BannerContent

public class BannerView extends FrameLayout
    implements Banner
{

    private final BannerContent content;

    public BannerView(Context context)
    {
        this(context, null, com.urbanairship.R.attr.inAppMessageBannerStyle);
    }

    public BannerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, com.urbanairship.R.attr.inAppMessageBannerStyle);
    }

    public BannerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        content = new BannerContent(context, this, attributeset, i);
        if (getBackground() != null)
        {
            getBackground().setColorFilter(content.getPrimaryColor(), android.graphics.PorterDuff.Mode.MULTIPLY);
            return;
        } else
        {
            setBackgroundColor(content.getPrimaryColor());
            return;
        }
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
        if (getBackground() != null)
        {
            getBackground().setColorFilter(i, android.graphics.PorterDuff.Mode.MULTIPLY);
        } else
        {
            setBackgroundColor(i);
        }
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
