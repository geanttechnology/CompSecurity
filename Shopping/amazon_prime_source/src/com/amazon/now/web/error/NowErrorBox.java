// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web.error;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.now.util.AppUtils;

public class NowErrorBox extends RelativeLayout
{

    public NowErrorBox(Context context)
    {
        super(context);
        inflate(context, 0x7f03001b, this);
        TextView textview = (TextView)findViewById(0x7f0e0089);
        if (AppUtils.hasNetworkConnection(context))
        {
            textview.setText(context.getString(0x7f07007c));
            return;
        } else
        {
            textview.setText(context.getString(0x7f07007a));
            return;
        }
    }
}
