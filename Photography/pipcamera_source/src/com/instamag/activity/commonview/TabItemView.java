// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.instamag.activity.commonview:
//            ItemView

public class TabItemView extends ItemView
{

    private int imgResId;
    private int imgSelectedResId;
    private int textColor;
    private int textSelectedColor;

    public TabItemView(Context context)
    {
        super(context);
    }

    public TabItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void setResId(int i)
    {
        imgResId = i;
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            icon.setBackgroundResource(imgSelectedResId);
            item_text.setTextColor(textSelectedColor);
            return;
        } else
        {
            icon.setBackgroundResource(imgResId);
            item_text.setTextColor(textColor);
            return;
        }
    }

    public void setSelectedResId(int i)
    {
        imgSelectedResId = i;
    }

    public void setText(String s)
    {
        item_text.setText(s);
    }

    public void setTextColor(int i)
    {
        textColor = i;
    }

    public void setTextSelectedColor(int i)
    {
        textSelectedColor = i;
    }
}
