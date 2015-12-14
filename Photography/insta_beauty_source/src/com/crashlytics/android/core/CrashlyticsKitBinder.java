// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import com.crashlytics.android.ndk.CrashlyticsNdk;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsCore

public class CrashlyticsKitBinder
{

    public CrashlyticsKitBinder()
    {
    }

    public void bindCrashEventDataProvider(CrashlyticsCore crashlyticscore, CrashlyticsNdk crashlyticsndk)
    {
        crashlyticscore.setExternalCrashEventDataProvider(crashlyticsndk);
    }
}
