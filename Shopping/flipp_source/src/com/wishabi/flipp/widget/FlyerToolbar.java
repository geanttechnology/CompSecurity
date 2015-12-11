// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            bd, be, bf, bg, 
//            bh

public class FlyerToolbar extends RelativeLayout
{

    public final TextView a;
    public boolean b;
    private bh c;
    private final SeekBar d;
    private final ImageButton e;
    private final ImageButton f;
    private final ProgressBar g;
    private final Button h;
    private int i;
    private boolean j;

    public FlyerToolbar(Context context)
    {
        this(context, null);
    }

    public FlyerToolbar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FlyerToolbar(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        View.inflate(context, 0x7f03002f, this);
        d = (SeekBar)findViewById(0x7f0b00c9);
        d.setMax(50);
        d.setOnSeekBarChangeListener(new bd(this));
        a = (TextView)findViewById(0x7f0b00c5);
        e = (ImageButton)findViewById(0x7f0b00c7);
        e.setOnClickListener(new be(this));
        f = (ImageButton)findViewById(0x7f0b00c6);
        f.setOnClickListener(new bf(this));
        h = (Button)findViewById(0x7f0b00c3);
        h.setOnClickListener(new bg(this));
        g = (ProgressBar)findViewById(0x7f0b00c8);
        g.setVisibility(8);
        a.setVisibility(0);
        f.setVisibility(8);
        e.setVisibility(8);
    }

    static ProgressBar a(FlyerToolbar flyertoolbar)
    {
        return flyertoolbar.g;
    }

    private void b()
    {
        byte byte1 = 8;
        Object obj;
        byte byte0;
        int k;
        if (d.getProgress() == 0 && (i == 0 || !j))
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        obj = a;
        if (byte0 != 0)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        ((TextView) (obj)).setVisibility(k);
        obj = f;
        if (byte0 != 0)
        {
            k = 8;
        } else
        {
            k = 0;
        }
        ((ImageButton) (obj)).setVisibility(k);
        obj = e;
        if (byte0 != 0)
        {
            byte0 = byte1;
        } else
        {
            byte0 = 0;
        }
        ((ImageButton) (obj)).setVisibility(byte0);
    }

    static void b(FlyerToolbar flyertoolbar)
    {
        flyertoolbar.b();
    }

    static bh c(FlyerToolbar flyertoolbar)
    {
        return flyertoolbar.c;
    }

    static void d(FlyerToolbar flyertoolbar)
    {
        flyertoolbar.a();
    }

    public final void a()
    {
        boolean flag = true;
        if (d.getProgress() <= 0) goto _L2; else goto _L1
_L1:
        SeekBar seekbar = d;
_L4:
        seekbar.setEnabled(flag);
        return;
_L2:
        SeekBar seekbar1 = d;
        seekbar = seekbar1;
        if (b)
        {
            flag = false;
            seekbar = seekbar1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int getDiscount()
    {
        return d.getProgress();
    }

    public boolean getShowCoupon()
    {
        return j;
    }

    public void setBackwardEnabled(boolean flag)
    {
        f.setEnabled(flag);
    }

    public void setCouponCount(int k)
    {
        i = k;
        setShowCoupon(j);
    }

    public void setDiscount(int k)
    {
        k = Math.max(Math.min(k, 50), 0);
        d.setProgress(k);
    }

    public void setFlyerToolbarListener(bh bh)
    {
        c = bh;
    }

    public void setForwardEnabled(boolean flag)
    {
        e.setEnabled(flag);
    }

    public void setProgressVisible(boolean flag)
    {
        if (flag)
        {
            g.setVisibility(0);
            d.setVisibility(8);
            h.setVisibility(8);
            a.setVisibility(8);
            f.setVisibility(8);
            e.setVisibility(8);
            return;
        } else
        {
            g.setVisibility(8);
            d.setVisibility(0);
            h.setVisibility(0);
            b();
            return;
        }
    }

    public void setShowCoupon(boolean flag)
    {
        boolean flag1 = false;
        Button button;
        if (i <= 0)
        {
            h.setText(0x7f0e013b);
        } else
        if (i == 1)
        {
            h.setText(0x7f0e0139);
        } else
        {
            h.setText(getResources().getString(0x7f0e013a, new Object[] {
                Integer.valueOf(i)
            }));
        }
        button = h;
        if (flag || i > 0)
        {
            flag1 = true;
        }
        button.setEnabled(flag1);
        h.setSelected(flag);
        j = flag;
        b();
    }
}
