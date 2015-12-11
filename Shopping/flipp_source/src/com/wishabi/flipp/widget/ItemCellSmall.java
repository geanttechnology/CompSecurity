// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.wishabi.flipp.widget:
//            WebImageView

public class ItemCellSmall extends FrameLayout
{

    private final WebImageView a;

    public ItemCellSmall(Context context)
    {
        this(context, null);
    }

    public ItemCellSmall(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ItemCellSmall(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        View.inflate(context, 0x7f030033, this);
        a = (WebImageView)findViewById(0x7f0b00da);
    }

    public void setImageScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        a.setScaleType(scaletype);
    }

    public void setImageUrl(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            a.setImageUrl(null);
            return;
        } else
        {
            a.setImageUrl(s);
            return;
        }
    }
}
