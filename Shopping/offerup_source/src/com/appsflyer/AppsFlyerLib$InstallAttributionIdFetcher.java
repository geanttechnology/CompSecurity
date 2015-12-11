// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.appsflyer:
//            AppsFlyerLib, AppsFlyerConversionListener

class  extends 
{

    protected void callback(Map map)
    {
        AppsFlyerLib.access$800().onInstallConversionDataLoaded(map);
    }

    protected void callbackFailure(String s)
    {
        AppsFlyerLib.access$800().onInstallConversionFailure(s);
    }

    public String getUrl()
    {
        return "https://api.appsflyer.com/install_data/v3/";
    }

    public (Context context, String s, ScheduledExecutorService scheduledexecutorservice)
    {
        super(context, s, scheduledexecutorservice);
    }
}
