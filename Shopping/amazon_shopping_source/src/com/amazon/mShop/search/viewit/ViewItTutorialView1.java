// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import com.amazon.mShop.DelayedInitView;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

public class ViewItTutorialView1 extends ViewItTutorialContentView
    implements DelayedInitView
{

    public ViewItTutorialView1(Context context)
    {
        super(context);
    }

    public void onPushViewCompleted()
    {
        updateContentView();
    }

    public void updateContentView()
    {
        super.updateContentView();
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItTutorialView1 this$0;

            public void run()
            {
                startDeviceFrameTranslateAnimation1();
            }

            
            {
                this$0 = ViewItTutorialView1.this;
                super();
            }
        }, 300L);
    }
}
