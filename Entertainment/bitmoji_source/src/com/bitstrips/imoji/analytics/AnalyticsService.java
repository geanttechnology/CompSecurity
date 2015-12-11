// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.analytics;

import android.app.Activity;
import com.bitstrips.imoji.util.PreferenceUtils;

// Referenced classes of package com.bitstrips.imoji.analytics:
//            EventAnalyticsService, Category, Variable

public interface AnalyticsService
    extends EventAnalyticsService
{

    public abstract void incrementTotalShareCount(PreferenceUtils preferenceutils);

    public abstract void reportStart(Activity activity);

    public abstract void reportStop(Activity activity);

    public abstract void sendTiming(Category category, Variable variable, long l, String s);
}
