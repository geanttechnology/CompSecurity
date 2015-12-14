// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

public class SingleLineTextView extends TextView
{

    public SingleLineTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        setSingleLine();
        setEllipsize(android.text.TextUtils.TruncateAt.END);
    }

    protected void onDraw(Canvas canvas)
    {
        Layout layout = getLayout();
        if (layout != null)
        {
            int i = layout.getLineCount();
            if (i > 0 && layout.getEllipsisCount(i - 1) > 0)
            {
                setTextSize(0, getTextSize() - 1.0F);
            }
        }
        super.onDraw(canvas);
    }
}
