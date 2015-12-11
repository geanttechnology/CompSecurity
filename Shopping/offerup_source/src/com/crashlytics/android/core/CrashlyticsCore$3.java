// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import c.a.a.a.e;
import c.a.a.a.q;
import java.io.File;
import java.util.concurrent.Callable;

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
            e.d().a("CrashlyticsCore", (new StringBuilder("Initialization marker file removed: ")).append(flag).toString());
        }
        catch (Exception exception)
        {
            e.d().c("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", exception);
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
