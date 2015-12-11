// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.content.res.Resources;
import android.view.View;
import com.amazon.now.util.UiOOMHandler;
import com.amazon.retailsearch.android.ui.DelayedInitView;

// Referenced classes of package com.amazon.now:
//            AmazonActivity

public final class view
    implements Runnable
{

    final AmazonActivity this$0;
    private final DelayedInitView view;

    public void run()
    {
        (new UiOOMHandler(AmazonActivity.this, new com.amazon.now.util._cls0(new Runnable() {

            final AmazonActivity.RetailSearchDelayedInitializer this$1;

            public void run()
            {
                view.onPushViewCompleted();
            }

            
            {
                this$1 = AmazonActivity.RetailSearchDelayedInitializer.this;
                super();
            }
        }, false))).execute();
    }


    public _cls1.this._cls1(DelayedInitView delayedinitview, boolean flag)
    {
        this$0 = AmazonActivity.this;
        super();
        view = delayedinitview;
        if (flag)
        {
            ((View)delayedinitview).postDelayed(this, getResources().getInteger(0x7f0a0005));
            return;
        } else
        {
            ((View)delayedinitview).post(this);
            return;
        }
    }
}
