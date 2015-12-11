// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.util.ColorUtil;
import com.groupon.view.PlaceholderUrlImageView;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

public class FrameViewContainer extends FrameLayout
{

    protected Lazy colorUtil;

    public FrameViewContainer(Context context)
    {
        super(context, null, 0);
    }

    public FrameViewContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset, 0);
    }

    public FrameViewContainer(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    protected void init(Context context)
    {
        colorUtil = new Lazy(context) {

            final FrameViewContainer this$0;

            
            {
                this$0 = FrameViewContainer.this;
                super(context);
            }
        };
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void setInfo(Object obj)
    {
    }

    protected void setupImage(PlaceholderUrlImageView placeholderurlimageview, String s)
    {
        if (Strings.notEmpty(s))
        {
            placeholderurlimageview.requestImage(s);
            return;
        } else
        {
            placeholderurlimageview.setImageDrawable(placeholderurlimageview.getPlaceholder());
            return;
        }
    }

    protected void setupTextField(TextView textview, String s, int i, String s1, int j)
    {
        if (!Strings.notEmpty(s))
        {
            s = getResources().getString(i);
        }
        textview.setText(s);
        if (Strings.notEmpty(s1))
        {
            i = ((ColorUtil)colorUtil.get()).extractColorFromString(s1, getResources().getColor(j));
        } else
        {
            i = getResources().getColor(j);
        }
        textview.setTextColor(i);
    }

    protected void setupTextField(TextView textview, String s, String s1)
    {
        textview.setText(s);
        textview.setTextColor(((ColorUtil)colorUtil.get()).extractColorFromString(s1, getResources().getColor(0x7f0e01a9)));
    }
}
