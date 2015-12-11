// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.analytics;

import android.os.Bundle;
import com.shazam.android.analytics.AnalyticsInfoToRootAttacher;
import com.shazam.android.aspects.b.a.b;
import com.shazam.i.b.g.a;

public class AttachAnalyticsInfoToRootActivityAspect extends b
{

    private final AnalyticsInfoToRootAttacher analyticsInfoToRootAttacher = a.a();

    public AttachAnalyticsInfoToRootActivityAspect()
    {
    }

    public void onPostCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        analyticsInfoToRootAttacher.attachToRoot(a1);
    }
}
