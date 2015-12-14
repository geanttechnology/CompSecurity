// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.content.Context;
import android.widget.RelativeLayout;
import com.millennialmedia.internal.adcontrollers.LightboxController;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InlineAdapter

public class InlineLightboxAdapter extends InlineAdapter
{

    private InlineAdapter.InlineAdapterListener inlineAdapterListener;
    private LightboxController lightboxController;
    private com.millennialmedia.internal.adcontrollers.LightboxController.LightboxControllerListener lightboxControllerListener;

    public InlineLightboxAdapter()
    {
        lightboxControllerListener = new com.millennialmedia.internal.adcontrollers.LightboxController.LightboxControllerListener() {

            final InlineLightboxAdapter this$0;

            public void attachFailed()
            {
                inlineAdapterListener.displayFailed();
            }

            public void attachSucceeded()
            {
                inlineAdapterListener.displaySucceeded();
            }

            public void initFailed()
            {
                inlineAdapterListener.initFailed();
            }

            public void initSucceeded()
            {
                inlineAdapterListener.initSucceeded();
            }

            public void onAdLeftApplication()
            {
                inlineAdapterListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                inlineAdapterListener.onClicked();
            }

            public void onCollapsed()
            {
                inlineAdapterListener.onCollapsed();
            }

            public void onExpanded()
            {
                inlineAdapterListener.onExpanded();
            }

            
            {
                this$0 = InlineLightboxAdapter.this;
                super();
            }
        };
    }

    public void display(RelativeLayout relativelayout, int i, int j)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i, j);
        layoutparams.addRule(13);
        lightboxController.attach(relativelayout, layoutparams);
    }

    public void init(Context context, InlineAdapter.InlineAdapterListener inlineadapterlistener)
    {
        inlineAdapterListener = inlineadapterlistener;
        lightboxController = new LightboxController(context, adContent, lightboxControllerListener);
    }

}
