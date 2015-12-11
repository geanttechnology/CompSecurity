// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import android.support.v7.alt;
import android.support.v7.apn;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore

class this._cls0
    implements android.support.v7.icsCore._cls6
{

    final CrashlyticsCore this$0;

    public Boolean usingSettings(apn apn1)
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
                    flag = CrashlyticsCore.access$100(CrashlyticsCore.this, activity, apn1.c);
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object usingSettings(apn apn1)
    {
        return usingSettings(apn1);
    }

    ()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
