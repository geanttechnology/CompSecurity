// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.support.v4.app.ah;

// Referenced classes of package com.localytics.android:
//            MarketingCallable, MarketingHandler, TestModeButton

class nit> extends MarketingCallable
{

    final MarketingHandler this$0;
    final TestModeButton val$button;

    Object call(Object aobj[])
    {
        val$button.show(MarketingHandler.access$300(MarketingHandler.this), "marketing_test_mode_button");
        MarketingHandler.access$300(MarketingHandler.this).b();
        return null;
    }

    ()
    {
        this$0 = final_marketinghandler;
        val$button = TestModeButton.this;
        super();
    }
}
