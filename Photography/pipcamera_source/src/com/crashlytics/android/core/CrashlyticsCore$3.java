// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import aag;
import java.io.File;
import java.util.concurrent.Callable;
import zw;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore

class this._cls0
    implements Callable
{

    final CrashlyticsCore this$0;

    public Boolean call()
    {
        boolean flag;
        try
        {
            flag = CrashlyticsCore.access$000(CrashlyticsCore.this).delete();
            zw.h().a("CrashlyticsCore", (new StringBuilder()).append("Initialization marker file removed: ").append(flag).toString());
        }
        catch (Exception exception)
        {
            zw.h().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(flag);
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
