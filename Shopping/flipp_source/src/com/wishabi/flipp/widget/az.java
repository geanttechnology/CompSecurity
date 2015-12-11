// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            WebImageView

public final class az extends FrameLayout
{

    private final TextView a;
    private final TextView b;
    private final WebImageView c;
    private final TextView d;
    private boolean e;
    private boolean f;

    public az(Context context)
    {
        this(context, (byte)0);
    }

    private az(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private az(Context context, char c1)
    {
        super(context, null, 0);
        View.inflate(context, 0x7f030028, this);
        a = (TextView)findViewById(0x7f0b0040);
        b = (TextView)findViewById(0x7f0b00af);
        d = (TextView)findViewById(0x7f0b0094);
        c = (WebImageView)findViewById(0x7f0b00ae);
        b.setSingleLine();
        c.setTopLeftCrop(true);
        d.setVisibility(8);
    }

    private void a()
    {
        if (f)
        {
            d.setText(0x7f0e0016);
            d.setBackgroundColor(getResources().getColor(0x7f090006));
            d.setVisibility(0);
            return;
        }
        if (e)
        {
            d.setText(0x7f0e0015);
            d.setBackgroundColor(getResources().getColor(0x7f090005));
            d.setVisibility(0);
            return;
        } else
        {
            d.setVisibility(8);
            return;
        }
    }

    public final void setFlyerDate(String s)
    {
        b.setText(s);
        setContentDescription((new StringBuilder()).append(a.getText()).append(". ").append(b.getText()).toString());
    }

    public final void setFlyerName(String s)
    {
        a.setText(s);
        setContentDescription((new StringBuilder()).append(a.getText()).append(". ").append(b.getText()).toString());
    }

    public final void setThumbnailUrl(String s)
    {
        c.setImageUrl(s);
    }

    public final void setUnread(boolean flag)
    {
        e = flag;
        a();
    }

    public final void setUpcoming(boolean flag)
    {
        f = flag;
        a();
    }
}
