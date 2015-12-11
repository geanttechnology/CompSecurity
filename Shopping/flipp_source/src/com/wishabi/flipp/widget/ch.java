// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            ItemCellSmall

public final class ch extends FrameLayout
{

    final ItemCellSmall a;
    private final TextView b;
    private final TextView c;

    public ch(Context context)
    {
        this(context, (byte)0);
    }

    private ch(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private ch(Context context, char c1)
    {
        super(context, null, 0);
        View.inflate(getContext(), 0x7f03003c, this);
        a = (ItemCellSmall)findViewById(0x7f0b00f5);
        b = (TextView)findViewById(0x7f0b00f6);
        b.setSingleLine();
        c = (TextView)findViewById(0x7f0b00f7);
        c.setSingleLine();
    }

    public final void setItemMatchupImage(String s)
    {
        a.setImageUrl(s);
    }

    public final void setItemMatchupLabel(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            b.setText(null);
            b.setVisibility(8);
            return;
        } else
        {
            b.setText(s);
            b.setVisibility(0);
            return;
        }
    }

    public final void setItemMatchupMerchant(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            c.setText(null);
            c.setVisibility(8);
            return;
        } else
        {
            c.setText(s);
            c.setVisibility(0);
            return;
        }
    }
}
