// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.other;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.fotoable.beautyui.other:
//            ItemView

public class ColorItemView extends ItemView
{

    private int textColor;

    public ColorItemView(Context context)
    {
        super(context);
        item_text.setTextColor(getResources().getColor(0x7f0c009d));
    }

    public ColorItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        item_text.setTextColor(getResources().getColor(0x7f0c009d));
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            icon.setColorFilter(getResources().getColor(0x7f0c009d), android.graphics.PorterDuff.Mode.SRC_IN);
            item_text.setTextColor(getResources().getColor(0x7f0c009d));
            return;
        } else
        {
            icon.setColorFilter(getResources().getColor(0x7f0c00a6), android.graphics.PorterDuff.Mode.SRC_IN);
            item_text.setTextColor(getResources().getColor(0x7f0c00a6));
            return;
        }
    }
}
