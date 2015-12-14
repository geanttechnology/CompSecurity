// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import adz;
import aeb;
import android.app.Activity;
import zw;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore

class this._cls0
    implements adz
{

    final CrashlyticsCore this$0;

    public Boolean usingSettings(aeb aeb1)
    {
        boolean flag1 = true;
        Activity activity = getFabric().b();
        boolean flag = flag1;
        if (activity != null)
        {
            flag = flag1;
            if (!activity.isFinishing())
            {
                flag = flag1;
                if (shouldPromptUserBeforeSendingCrashReports())
                {
                    flag = CrashlyticsCore.access$100(CrashlyticsCore.this, activity, aeb1.c);
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object usingSettings(aeb aeb1)
    {
        return usingSettings(aeb1);
    }

    ()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
