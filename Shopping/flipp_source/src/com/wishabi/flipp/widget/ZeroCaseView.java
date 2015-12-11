// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            ActionButton

public class ZeroCaseView extends FrameLayout
{

    private static final String e = com/wishabi/flipp/widget/ZeroCaseView.getSimpleName();
    protected final ImageView a;
    protected final TextView b;
    protected final TextView c;
    protected final ActionButton d;

    public ZeroCaseView(Context context)
    {
        this(context, null);
    }

    public ZeroCaseView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ZeroCaseView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        View.inflate(getContext(), 0x7f030058, this);
        a = (ImageView)findViewById(0x7f0b014d);
        b = (TextView)findViewById(0x7f0b014e);
        c = (TextView)findViewById(0x7f0b014f);
        d = (ActionButton)findViewById(0x7f0b0150);
        d.setAllCaps(false);
        a.setVisibility(8);
        b.setVisibility(8);
        c.setVisibility(8);
        d.setVisibility(8);
    }

    public final void a()
    {
        d.setVisibility(8);
    }

    public final void a(String s, android.view.View.OnClickListener onclicklistener)
    {
        d.setLabel(s);
        d.setOnClickListener(onclicklistener);
        if (TextUtils.isEmpty(s))
        {
            d.setVisibility(8);
            return;
        } else
        {
            d.setVisibility(0);
            return;
        }
    }

    public final boolean b()
    {
        return d.isShown();
    }

    public void setIcon(int i)
    {
        if (i == 0)
        {
            a.setImageDrawable(null);
            a.setVisibility(8);
            return;
        } else
        {
            a.setImageResource(i);
            a.setVisibility(0);
            return;
        }
    }

    public void setSubTitle(int i)
    {
        setSubTitle(getResources().getString(i));
    }

    public void setSubTitle(String s)
    {
        c.setText(s);
        if (TextUtils.isEmpty(s))
        {
            c.setVisibility(8);
            return;
        } else
        {
            c.setVisibility(0);
            return;
        }
    }

    public void setTitle(int i)
    {
        setTitle(getResources().getString(i));
    }

    public void setTitle(String s)
    {
        b.setText(s);
        if (TextUtils.isEmpty(s))
        {
            b.setVisibility(8);
            return;
        } else
        {
            b.setVisibility(0);
            return;
        }
    }

}
