// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.app.Activity;
import c.a.a.a.a.g.p;
import c.a.a.a.a.g.s;
import c.a.a.a.e;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore

class this._cls0
    implements p
{

    final CrashlyticsCore this$0;

    public Boolean usingSettings(s s1)
    {
        boolean flag1 = true;
        Activity activity = getFabric().a();
        boolean flag = flag1;
        if (activity != null)
        {
            flag = flag1;
            if (!activity.isFinishing())
            {
                flag = flag1;
                if (shouldPromptUserBeforeSendingCrashReports())
                {
                    flag = CrashlyticsCore.access$100(CrashlyticsCore.this, activity, s1.c);
                }
            }
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object usingSettings(s s1)
    {
        return usingSettings(s1);
    }

    ()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
