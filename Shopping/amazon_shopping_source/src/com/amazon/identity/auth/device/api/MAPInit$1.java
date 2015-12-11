// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.CommonInfoGetter;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.metrics.WebserviceCallMetrics;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.setting.PlatformSettings;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit

class this._cls0
    implements Runnable
{

    final MAPInit this$0;

    public void run()
    {
        MAPInit.access$000(MAPInit.this);
        PlatformSettings.getInstance(MAPInit.access$100(MAPInit.this));
        if (CommonInfoGetter.needToGenerateCommonInfoOnThisPlatform(MAPInit.access$100(MAPInit.this)))
        {
            CommonInfoGetter.getInstance(MAPInit.access$100(MAPInit.this)).init();
        }
        WebserviceCallMetrics.init(MAPInit.access$100(MAPInit.this));
        SSOMetrics.init(MAPInit.access$100(MAPInit.this));
        MetricsHelper.init(MAPInit.access$100(MAPInit.this));
        MAPInit.access$200(MAPInit.this);
        MAPInit.access$300(MAPInit.this);
    }

    per()
    {
        this$0 = MAPInit.this;
        super();
    }
}
