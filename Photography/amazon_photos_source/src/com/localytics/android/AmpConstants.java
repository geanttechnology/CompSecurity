// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.localytics.android:
//            Constants

class AmpConstants extends Constants
{

    private static final AtomicBoolean sTestModeEnabled = new AtomicBoolean(false);

    public static boolean isTestModeEnabled()
    {
        return sTestModeEnabled.get();
    }

    public static void setTestModeEnabled(boolean flag)
    {
        sTestModeEnabled.set(flag);
    }

}
