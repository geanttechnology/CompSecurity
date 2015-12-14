// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.fotoable.fotoproedit.view.ui.scroll:
//            ItemView

public class ColorItemView extends ItemView
{

    private int textColor;

    public ColorItemView(Context context)
    {
        super(context);
    }

    public ColorItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            icon.getBackground().mutate().setColorFilter(Color.parseColor("#FFFFFF"), android.graphics.PorterDuff.Mode.SRC_IN);
            item_text.setTextColor(Color.parseColor("#FFFFFF"));
            itemicon.setBackgroundColor(Color.parseColor("#ee7488"));
            return;
        } else
        {
            icon.getBackground().mutate().setColorFilter(textColor, android.graphics.PorterDuff.Mode.SRC_IN);
            item_text.setTextColor(textColor);
            itemicon.setBackgroundColor(Color.parseColor("#ffffff"));
            return;
        }
    }

    public void setTextColor(int i)
    {
        textColor = i;
        icon.getBackground().mutate().setColorFilter(textColor, android.graphics.PorterDuff.Mode.SRC_IN);
        super.setTextColor(i);
    }
}
