// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.wishabi.flipp.app.dn;

// Referenced classes of package com.wishabi.flipp.widget:
//            CouponCell, ItemCellSmall

public final class cd extends FrameLayout
{

    final CouponCell a;
    final View b;
    final ItemCellSmall c;
    dn d;
    private final TextView e;
    private final TextView f;
    private final View g;
    private final TextView h;
    private final TextView i;
    private final View j;
    private final TextView k;
    private final View l;
    private final TextView m;
    private final TextView n;
    private final TextView o;

    public cd(Context context)
    {
        this(context, (byte)0);
    }

    private cd(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private cd(Context context, char c1)
    {
        super(context, null, 0);
        View.inflate(getContext(), 0x7f030032, this);
        a = (CouponCell)findViewById(0x7f0b00d9);
        b = findViewById(0x7f0b00ca);
        c = (ItemCellSmall)findViewById(0x7f0b00cc);
        c.setImageScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        e = (TextView)findViewById(0x7f0b00cd);
        e.setSingleLine();
        f = (TextView)findViewById(0x7f0b00ce);
        g = findViewById(0x7f0b00d0);
        h = (TextView)findViewById(0x7f0b00d1);
        i = (TextView)findViewById(0x7f0b00d2);
        i.setPaintFlags(i.getPaintFlags() | 0x10);
        j = findViewById(0x7f0b00d3);
        k = (TextView)findViewById(0x7f0b00d4);
        l = findViewById(0x7f0b00d5);
        m = (TextView)findViewById(0x7f0b00d6);
        n = (TextView)findViewById(0x7f0b00d7);
        o = (TextView)findViewById(0x7f0b00d8);
    }

    static dn a(cd cd1)
    {
        return cd1.d;
    }

    public final CouponCell getCouponCell()
    {
        return a;
    }

    public final void setBadgeText(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            o.setVisibility(8);
            return;
        } else
        {
            o.setText(s);
            o.setVisibility(0);
            return;
        }
    }

    public final void setItemCouponPrice(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            l.setVisibility(8);
            return;
        } else
        {
            m.setText(s);
            l.setVisibility(0);
            return;
        }
    }

    public final void setItemCurrentPrice(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            g.setVisibility(8);
            return;
        } else
        {
            h.setText(0x7f0e00c5);
            i.setText(s);
            g.setVisibility(0);
            return;
        }
    }

    public final void setItemDiscountPrice(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            j.setVisibility(8);
            return;
        } else
        {
            k.setText(s);
            j.setVisibility(0);
            return;
        }
    }

    public final void setItemFinalPrice(String s)
    {
        n.setText(s);
    }

    public final void setItemMatchupImage(String s)
    {
        c.setImageUrl(s);
    }

    public final void setItemMatchupLabel(String s)
    {
        e.setText(s);
    }

    public final void setItemMatchupMerchant(String s)
    {
        f.setText(s);
    }

    public final void setItemOriginalPrice(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            g.setVisibility(8);
            return;
        } else
        {
            h.setText(0x7f0e00c8);
            i.setText(s);
            g.setVisibility(0);
            return;
        }
    }
}
