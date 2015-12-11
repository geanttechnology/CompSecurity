// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

// Referenced classes of package com.aio.downloader.floatwindow:
//            MyWindowManager

public class FloatWindowBigView extends LinearLayout
{

    public static int viewHeight;
    public static int viewWidth;

    public FloatWindowBigView(final Context context)
    {
        super(context);
        LayoutInflater.from(context).inflate(0x7f030045, this);
        Object obj = findViewById(0x7f0701e9);
        viewWidth = ((View) (obj)).getLayoutParams().width;
        viewHeight = ((View) (obj)).getLayoutParams().height;
        obj = (Button)findViewById(0x7f0701ea);
        Button button = (Button)findViewById(0x7f070077);
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final FloatWindowBigView this$0;
            private final Context val$context;

            public void onClick(View view)
            {
                MyWindowManager.removeBigWindow(context);
                MyWindowManager.removeSmallWindow(context);
            }

            
            {
                this$0 = FloatWindowBigView.this;
                context = context1;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final FloatWindowBigView this$0;
            private final Context val$context;

            public void onClick(View view)
            {
                MyWindowManager.removeBigWindow(context);
                MyWindowManager.createSmallWindow(context);
            }

            
            {
                this$0 = FloatWindowBigView.this;
                context = context1;
                super();
            }
        });
    }
}
