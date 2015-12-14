// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.content.Context;
import android.widget.RelativeLayout;
import com.millennialmedia.internal.adcontrollers.WebController;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InlineAdapter

public class InlineWebAdapter extends InlineAdapter
{

    InlineAdapter.InlineAdapterListener adapterListener;
    com.millennialmedia.internal.adcontrollers.WebController.WebControllerListener controllerListener;
    WebController webController;

    public InlineWebAdapter()
    {
        controllerListener = new com.millennialmedia.internal.adcontrollers.WebController.WebControllerListener() {

            final InlineWebAdapter this$0;

            public void attachFailed()
            {
                adapterListener.displayFailed();
            }

            public void attachSucceeded()
            {
                adapterListener.displaySucceeded();
            }

            public void initFailed()
            {
                adapterListener.initFailed();
            }

            public void initSucceeded()
            {
                adapterListener.initSucceeded();
            }

            public void onAdLeftApplication()
            {
                adapterListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                adapterListener.onClicked();
            }

            public void onCollapsed()
            {
                adapterListener.onCollapsed();
            }

            public void onExpanded()
            {
                adapterListener.onExpanded();
            }

            public void onResize(int i, int j)
            {
                adapterListener.onResize(i, j);
            }

            public void onResized(int i, int j, boolean flag)
            {
                adapterListener.onResized(i, j, flag);
            }

            
            {
                this$0 = InlineWebAdapter.this;
                super();
            }
        };
    }

    public void display(RelativeLayout relativelayout, int i, int j)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i, j);
        layoutparams.addRule(13);
        webController.attach(relativelayout, layoutparams);
    }

    public void init(Context context, InlineAdapter.InlineAdapterListener inlineadapterlistener)
    {
        adapterListener = inlineadapterlistener;
        webController = new WebController(context, false, adContent, adMetadata, controllerListener);
    }
}
