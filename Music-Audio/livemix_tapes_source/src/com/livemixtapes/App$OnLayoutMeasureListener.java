// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

// Referenced classes of package com.livemixtapes:
//            App

public static abstract class _cls1
{

    private final ViewGroup layout;

    public abstract void onLayoutMeasure();

    public istener(final ViewGroup layout)
    {
        this.layout = layout;
        layout.setVisibility(4);
        layout.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final App.OnLayoutMeasureListener this$1;
            private final ViewGroup val$layout;

            public void onGlobalLayout()
            {
                layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                onLayoutMeasure();
                layout.post(layout. new Runnable() {

                    final _cls1 this$2;
                    private final ViewGroup val$layout;

                    public void run()
                    {
                        layout.setVisibility(0);
                    }

            
            {
                this$2 = final__pcls1;
                layout = ViewGroup.this;
                super();
            }
                });
            }

            
            {
                this$1 = App.OnLayoutMeasureListener.this;
                layout = viewgroup;
                super();
            }
        });
    }
}
