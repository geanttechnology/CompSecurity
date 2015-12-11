// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.TextView;

// Referenced classes of package io.branch.referral:
//            ShareLinkManager

private class context_ extends TextView
{

    Context context_;
    final int leftMargin = 100;
    final int padding = 5;
    final ShareLinkManager this$0;

    public void setLabel(String s, Drawable drawable, boolean flag)
    {
        setText((new StringBuilder()).append("\t").append(s).toString());
        setTag(s);
        if (drawable == null)
        {
            setTextAppearance(context_, 0x1030042);
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else
        {
            setTextAppearance(context_, 0x1030044);
            setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            int _tmp = ShareLinkManager.access$802(Math.max(ShareLinkManager.access$800(), drawable.getIntrinsicHeight() + 5));
        }
        setMinHeight(ShareLinkManager.access$800());
        setTextColor(context_.getResources().getColor(0x106000c));
        if (flag)
        {
            setBackgroundColor(ShareLinkManager.access$900(ShareLinkManager.this));
            return;
        } else
        {
            setBackgroundColor(ShareLinkManager.access$1000(ShareLinkManager.this));
            return;
        }
    }

    public (Context context)
    {
        this$0 = ShareLinkManager.this;
        super(context);
        context_ = context;
        setPadding(100, 5, 5, 5);
        setGravity(0x800013);
        setMinWidth(context_.getResources().getDisplayMetrics().widthPixels);
    }
}
