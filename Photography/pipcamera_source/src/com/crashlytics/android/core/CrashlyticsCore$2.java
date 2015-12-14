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

    public volatile Object call()
    {
        return call();
    }

    public Void call()
    {
        CrashlyticsCore.access$000(CrashlyticsCore.this).createNewFile();
        zw.h().a("CrashlyticsCore", "Initialization marker file created.");
        return null;
    }

    ()
    {
        this$0 = CrashlyticsCore.this;
        super();
    }
}
