// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.browse;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.net.SocketException;
import java.net.UnknownHostException;

public class BrowseErrorView extends LinearLayout
{

    public BrowseErrorView(Context context)
    {
        this(context, null, null);
    }

    public BrowseErrorView(Context context, Exception exception, final BrowseActivity.BrowseRetry browseRetry)
    {
        super(context);
        inflate(context, 0x7f030040, this);
        TextView textview = (TextView)findViewById(0x7f0e0107);
        if (exception == null)
        {
            context = null;
        } else
        {
            context = exception.getCause();
        }
        if (java/net/UnknownHostException.isInstance(context) || java/net/SocketException.isInstance(context))
        {
            textview.setText(0x7f070044);
        } else
        {
            textview.setText(0x7f070045);
        }
        ((Button)findViewById(0x7f0e0108)).setOnClickListener(new android.view.View.OnClickListener() {

            final BrowseErrorView this$0;
            final BrowseActivity.BrowseRetry val$browseRetry;

            public void onClick(View view)
            {
                if (browseRetry != null)
                {
                    browseRetry.retry();
                }
            }

            
            {
                this$0 = BrowseErrorView.this;
                browseRetry = browseretry;
                super();
            }
        });
    }
}
