// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile;

import android.database.DataSetObserver;
import com.ebay.mobile.analytics.AnalyticsUtil;

// Referenced classes of package com.ebay.mobile:
//            MyApp, ServiceStarter

private final class <init> extends DataSetObserver
{

    final MyApp this$0;

    public void onChanged()
    {
        AnalyticsUtil.setEnabledProviders();
        ServiceStarter.instructNotificationManagerService(MyApp.this, 11);
    }

    private ()
    {
        this$0 = MyApp.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
