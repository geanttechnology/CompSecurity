// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.urbanairship.push.notifications.NotificationActionButton;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;
import com.urbanairship.util.UAStringUtil;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.push.iam.view:
//            Banner, BannerView

class BannerContent
    implements Banner
{

    private static final int ACTION_BUTTON_ICON_SIZE_DP = 32;
    private int actionButtonTextAppearance;
    private final ViewGroup actionButtonViewGroup;
    private Banner.OnActionClickListener actionClickListener;
    private final View actionsDividerView;
    private final Context context;
    private final ImageButton dismissButton;
    private Banner.OnDismissClickListener dismissClickListener;
    private final TextView messageTextView;
    private int primaryColor;
    private int secondaryColor;
    private Typeface typeface;

    BannerContent(Context context1, ViewGroup viewgroup, AttributeSet attributeset, int i)
    {
        context = context1;
        viewgroup = BannerView.inflate(context1, com.urbanairship.R.layout.ua_iam_content, viewgroup);
        messageTextView = (TextView)viewgroup.findViewById(com.urbanairship.R.id.alert);
        actionsDividerView = viewgroup.findViewById(com.urbanairship.R.id.action_divider);
        actionButtonViewGroup = (ViewGroup)viewgroup.findViewById(com.urbanairship.R.id.action_buttons);
        dismissButton = (ImageButton)viewgroup.findViewById(com.urbanairship.R.id.close);
        actionButtonViewGroup.setVisibility(8);
        actionsDividerView.setVisibility(8);
        dismissButton.setOnClickListener(new _cls1());
        if (attributeset == null) goto _L2; else goto _L1
_L1:
        viewgroup = context1.getTheme().obtainStyledAttributes(attributeset, com.urbanairship.R.styleable.BannerView, i, com.urbanairship.R.style.InAppMessage_Banner);
        attributeset = viewgroup.getString(com.urbanairship.R.styleable.BannerView_bannerFontPath);
        if (!UAStringUtil.isEmpty(attributeset))
        {
            typeface = Typeface.createFromAsset(context1.getAssets(), attributeset);
        }
        i = context1.getResources().getColor(com.urbanairship.R.color.ua_iam_primary);
        int j = context1.getResources().getColor(com.urbanairship.R.color.ua_iam_secondary);
        setPrimaryColor(viewgroup.getColor(com.urbanairship.R.styleable.BannerView_bannerPrimaryColor, i));
        setSecondaryColor(viewgroup.getColor(com.urbanairship.R.styleable.BannerView_bannerSecondaryColor, j));
        if (!viewgroup.getBoolean(com.urbanairship.R.styleable.BannerView_bannerNoDismissButton, false)) goto _L4; else goto _L3
_L3:
        dismissButton.setVisibility(8);
_L6:
        actionButtonTextAppearance = viewgroup.getResourceId(com.urbanairship.R.styleable.BannerView_bannerActionButtonTextAppearance, -1);
        i = viewgroup.getResourceId(com.urbanairship.R.styleable.BannerView_bannerTextAppearance, -1);
        applyTextStyle(context1, messageTextView, i);
        viewgroup.recycle();
_L2:
        return;
_L4:
        attributeset = viewgroup.getDrawable(com.urbanairship.R.styleable.BannerView_bannerDismissButtonDrawable);
        if (attributeset != null)
        {
            dismissButton.setImageDrawable(attributeset);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void applyTextStyle(Context context1, TextView textview, int i)
    {
        byte byte0 = -1;
        if (i != -1)
        {
            textview.setTextAppearance(context1, i);
        }
        if (typeface != null)
        {
            i = byte0;
            if (textview.getTypeface() != null)
            {
                i = textview.getTypeface().getStyle();
            }
            textview.setPaintFlags(textview.getPaintFlags() | 1 | 0x80);
            if (i >= 0)
            {
                textview.setTypeface(typeface, i);
            } else
            {
                textview.setTypeface(typeface);
            }
        }
        textview.setTextColor(secondaryColor);
    }

    int getPrimaryColor()
    {
        return primaryColor;
    }

    public void setNotificationActionButtonGroup(NotificationActionButtonGroup notificationactionbuttongroup)
    {
        actionButtonViewGroup.removeAllViewsInLayout();
        if (notificationactionbuttongroup == null)
        {
            actionButtonViewGroup.setVisibility(8);
            actionsDividerView.setVisibility(8);
        } else
        {
            actionButtonViewGroup.setVisibility(0);
            actionsDividerView.setVisibility(0);
            LayoutInflater layoutinflater = LayoutInflater.from(context);
            int i = (int)TypedValue.applyDimension(1, 32F, context.getResources().getDisplayMetrics());
            notificationactionbuttongroup = notificationactionbuttongroup.getNotificationActionButtons().iterator();
            while (notificationactionbuttongroup.hasNext()) 
            {
                final NotificationActionButton actionButton = (NotificationActionButton)notificationactionbuttongroup.next();
                Button button = (Button)layoutinflater.inflate(com.urbanairship.R.layout.ua_iam_button, actionButtonViewGroup, false);
                if (actionButton.getLabel() > 0)
                {
                    button.setText(actionButton.getLabel());
                }
                Drawable drawable = a.a(context, actionButton.getIcon());
                drawable.setBounds(0, 0, i, i);
                drawable.setColorFilter(secondaryColor, android.graphics.PorterDuff.Mode.MULTIPLY);
                button.setCompoundDrawables(drawable, null, null, null);
                applyTextStyle(context, button, actionButtonTextAppearance);
                button.setOnClickListener(new _cls2());
                actionButtonViewGroup.addView(button);
            }
        }
    }

    public void setOnActionClickListener(Banner.OnActionClickListener onactionclicklistener)
    {
        actionClickListener = onactionclicklistener;
    }

    public void setOnDismissClickListener(Banner.OnDismissClickListener ondismissclicklistener)
    {
        dismissClickListener = ondismissclicklistener;
    }

    public void setPrimaryColor(int i)
    {
        primaryColor = i;
    }

    public void setSecondaryColor(int i)
    {
        secondaryColor = i;
        actionsDividerView.setBackgroundColor(secondaryColor);
        dismissButton.setColorFilter(secondaryColor, android.graphics.PorterDuff.Mode.MULTIPLY);
        messageTextView.setTextColor(secondaryColor);
        for (i = 0; i < actionButtonViewGroup.getChildCount(); i++)
        {
            Object obj = actionButtonViewGroup.getChildAt(i);
            if (!(obj instanceof Button))
            {
                continue;
            }
            obj = (Button)obj;
            Drawable adrawable[] = ((Button) (obj)).getCompoundDrawables();
            int k = adrawable.length;
            for (int j = 0; j < k; j++)
            {
                Drawable drawable = adrawable[j];
                if (drawable != null)
                {
                    drawable.setColorFilter(secondaryColor, android.graphics.PorterDuff.Mode.MULTIPLY);
                }
            }

            ((Button) (obj)).setTextColor(secondaryColor);
        }

    }

    public void setText(CharSequence charsequence)
    {
        messageTextView.setText(charsequence);
    }



    private class _cls1
        implements android.view.View.OnClickListener
    {

        final BannerContent this$0;

        public void onClick(View view)
        {
            if (dismissClickListener != null)
            {
                dismissClickListener.onDismissClick();
            }
        }

        _cls1()
        {
            this$0 = BannerContent.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final BannerContent this$0;
        final NotificationActionButton val$actionButton;

        public void onClick(View view)
        {
            if (actionClickListener != null)
            {
                actionClickListener.onActionClick(actionButton);
            }
        }

        _cls2()
        {
            this$0 = BannerContent.this;
            actionButton = notificationactionbutton;
            super();
        }
    }

}
