// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.wishabi.flipp.content.h;

// Referenced classes of package com.wishabi.flipp.widget:
//            WebImageView, FeaturedItemCell, bb, bc

public final class ba extends FrameLayout
{

    final FeaturedItemCell a;
    private final TextView b;
    private final TextView c;
    private final WebImageView d;
    private final TextView e;
    private boolean f;
    private boolean g;
    private final Rect h;

    public ba(Context context)
    {
        this(context, (byte)0);
    }

    private ba(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private ba(Context context, char c1)
    {
        super(context, null, 0);
        View.inflate(context, 0x7f030029, this);
        b = (TextView)findViewById(0x7f0b0040);
        c = (TextView)findViewById(0x7f0b00af);
        e = (TextView)findViewById(0x7f0b0094);
        d = (WebImageView)findViewById(0x7f0b00ae);
        a = (FeaturedItemCell)findViewById(0x7f0b00b1);
        c.setSingleLine();
        d.setTopLeftCrop(true);
        e.setVisibility(8);
        a.a();
        h = new Rect();
    }

    private void b()
    {
        if (g)
        {
            e.setText(0x7f0e0016);
            e.setBackgroundColor(getResources().getColor(0x7f090006));
            e.setVisibility(0);
            return;
        }
        if (f)
        {
            e.setText(0x7f0e0015);
            e.setBackgroundColor(getResources().getColor(0x7f090005));
            e.setVisibility(0);
            return;
        } else
        {
            e.setVisibility(8);
            return;
        }
    }

    final void a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(b.getText());
        stringbuilder.append(". ");
        stringbuilder.append(c.getText());
        h h1 = a.getData();
        if (h1 != null)
        {
            stringbuilder.append(". ");
            stringbuilder.append(getResources().getString(0x7f0e00b5));
            if (!TextUtils.isEmpty(h1.g))
            {
                stringbuilder.append(". ");
                stringbuilder.append(h1.g);
            }
            if (!TextUtils.isEmpty(h1.e))
            {
                stringbuilder.append(". ");
                stringbuilder.append(h1.e);
            }
            if (!TextUtils.isEmpty(h1.d))
            {
                stringbuilder.append(". ");
                stringbuilder.append(h1.d);
            }
        }
        setContentDescription(stringbuilder.toString());
    }

    public final h getFeaturedItem()
    {
        return a.getData();
    }

    public final float getPercentVisibility()
    {
        int i = getWidth() * getHeight();
        if (i <= 0)
        {
            return 0.0F;
        } else
        {
            getGlobalVisibleRect(h);
            return ((float)(h.width() * h.height()) * 100F) / (float)i;
        }
    }

    public final void setFeaturedItemClickListener(bc bc)
    {
        if (bc == null)
        {
            a.setOnClickListener(null);
            return;
        } else
        {
            a.setOnClickListener(new bb(this, bc));
            return;
        }
    }

    public final void setFlyerDate(String s)
    {
        c.setText(s);
        a();
    }

    public final void setFlyerName(String s)
    {
        b.setText(s);
        a();
    }

    public final void setThumbnailUrl(String s)
    {
        d.setImageUrl(s);
    }

    public final void setUnread(boolean flag)
    {
        f = flag;
        b();
    }

    public final void setUpcoming(boolean flag)
    {
        g = flag;
        b();
    }
}
