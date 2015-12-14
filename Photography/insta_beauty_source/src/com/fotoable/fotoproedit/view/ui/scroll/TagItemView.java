// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TagItemView extends LinearLayout
{

    ImageView icon;
    TextView item_text;
    ImageView new_tips;

    public TagItemView(Context context)
    {
        super(context);
    }

    public TagItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030122, this, true);
        icon = (ImageView)findViewById(0x7f0d01cd);
        item_text = (TextView)findViewById(0x7f0d01ce);
        new_tips = (ImageView)findViewById(0x7f0d042b);
    }

    public void setIconColor(int i)
    {
        try
        {
            icon.getBackground().mutate().setColorFilter(i, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void setIconRes(int i)
    {
        icon.setBackgroundResource(i);
    }

    public void setNewTipsVisibily(boolean flag)
    {
        if (flag)
        {
            new_tips.setVisibility(0);
            return;
        } else
        {
            new_tips.setVisibility(4);
            return;
        }
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            Exception exception;
            try
            {
                icon.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
            }
            catch (Exception exception1) { }
            item_text.setTextColor(0xff007aff);
            return;
        }
        try
        {
            icon.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        item_text.setTextColor(-1);
    }

    public void setText(String s)
    {
        item_text.setText(s);
    }

    public void setTextColor(int i)
    {
        item_text.setTextColor(i);
    }
}
