// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

// Referenced classes of package com.livemixtapes:
//            App

class val.layout
    implements android.view.tListener
{

    final _cls1.val.layout this$1;
    private final ViewGroup val$layout;

    public void onGlobalLayout()
    {
        val$layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        LayoutMeasure();
        val$layout.post(new Runnable() {

            final App.OnLayoutMeasureListener._cls1 this$2;
            private final ViewGroup val$layout;

            public void run()
            {
                layout.setVisibility(0);
            }

            
            {
                this$2 = App.OnLayoutMeasureListener._cls1.this;
                layout = viewgroup;
                super();
            }
        });
    }

    _cls1.val.layout()
    {
        this$1 = final_layout1;
        val$layout = ViewGroup.this;
        super();
    }
}
