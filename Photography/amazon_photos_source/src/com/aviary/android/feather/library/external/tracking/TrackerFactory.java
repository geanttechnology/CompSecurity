// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.external.tracking;

import android.content.Context;
import com.aviary.android.feather.common.tracking.AbstractTracker;

// Referenced classes of package com.aviary.android.feather.library.external.tracking:
//            LocalyticsTracker

public final class TrackerFactory
{

    private TrackerFactory()
    {
    }

    public static AbstractTracker create(Context context, String s, String s1, String s2)
    {
        return new LocalyticsTracker(context, s, s1, s2);
    }
}
