// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.res.Resources;
import android.view.View;
import com.amazon.mShop.util.MShopUiOOMHandler;

// Referenced classes of package com.amazon.mShop:
//            AmazonActivity, DelayedInitView

protected final class fault_duration
    implements Runnable
{

    final AmazonActivity this$0;
    private final DelayedInitView view;

    public void run()
    {
        (new MShopUiOOMHandler(AmazonActivity.this, new com.amazon.mShop.util.>(new Runnable() {

            final AmazonActivity.DelayedInitializer this$1;

            public void run()
            {
                view.onPushViewCompleted();
            }

            
            {
                this$1 = AmazonActivity.DelayedInitializer.this;
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
            ((View)delayedinitview).postDelayed(this, getResources().getInteger(com.amazon.mShop.android.lib.on));
            return;
        } else
        {
            ((View)delayedinitview).post(this);
            return;
        }
    }
}
