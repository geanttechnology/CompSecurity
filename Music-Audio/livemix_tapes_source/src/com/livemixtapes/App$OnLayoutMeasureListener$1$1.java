// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

// Referenced classes of package com.livemixtapes:
//            App

class val.layout
    implements Runnable
{

    final val.layout this$2;
    private final ViewGroup val$layout;

    public void run()
    {
        val$layout.setVisibility(0);
    }

    l.layout()
    {
        this$2 = final_layout1;
        val$layout = ViewGroup.this;
        super();
    }

    // Unreferenced inner class com/livemixtapes/App$OnLayoutMeasureListener$1

/* anonymous class */
    class App.OnLayoutMeasureListener._cls1
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final App.OnLayoutMeasureListener this$1;
        private final ViewGroup val$layout;

        public void onGlobalLayout()
        {
            layout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            onLayoutMeasure();
            layout.post(layout. new App.OnLayoutMeasureListener._cls1._cls1());
        }

            
            {
                this$1 = final_onlayoutmeasurelistener;
                layout = ViewGroup.this;
                super();
            }
    }

}
