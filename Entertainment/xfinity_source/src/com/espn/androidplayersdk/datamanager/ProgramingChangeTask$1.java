// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            ProgramingChangeTask, EPStream, EPSDKPrefs, FeedsManagerAPI

class this._cls0
    implements Runnable
{

    final ProgramingChangeTask this$0;

    public void run()
    {
        try
        {
            feedsManager.getProgramingChangeResponse((new StringBuilder(String.valueOf(epStream.getProgramChangeUrl()))).append("&").append(EPSDKPrefs.getApiKey()).append("&v=2.0.0").toString());
            return;
        }
        catch (Exception exception)
        {
            Utils.sdkLog("URL encoding failed", 5, exception);
        }
    }

    ()
    {
        this$0 = ProgramingChangeTask.this;
        super();
    }
}
