// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

public class PopupWindowAboveView extends PopupWindow
{

    private Context context;
    private int height;
    private int width;

    public PopupWindowAboveView(Context context1, final Runnable onDismiss, int i, int j)
    {
        super(i, j);
        context = context1;
        width = i;
        height = j;
        setFocusable(false);
        setOutsideTouchable(true);
        setTouchInterceptor(new android.view.View.OnTouchListener() {

            final PopupWindowAboveView this$0;
            final Runnable val$onDismiss;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 4)
                {
                    dismiss();
                    onDismiss.run();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = PopupWindowAboveView.this;
                onDismiss = runnable;
                super();
            }
        });
    }

    public void showAboveView(View view, View view1, int i)
    {
        setBackgroundDrawable(context.getResources().getDrawable(0x7f0e0196));
        int j = android.view.View.MeasureSpec.makeMeasureSpec(-2, 0);
        int k = android.view.View.MeasureSpec.makeMeasureSpec(view.getWidth(), 0x40000000);
        view1.setLayoutParams(new android.view.ViewGroup.LayoutParams(width, height));
        setContentView(view1);
        view1.measure(k, j);
        int ai[] = new int[2];
        view.getLocationInWindow(ai);
        showAtLocation(view, 0, ai[0], ai[1] - view1.getMeasuredHeight() - i);
    }
}
