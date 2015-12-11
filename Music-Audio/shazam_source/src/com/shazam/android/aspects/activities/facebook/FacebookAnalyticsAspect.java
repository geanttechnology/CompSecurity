// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.facebook;

import com.facebook.a.a;
import com.shazam.android.aspects.b.a.b;

public class FacebookAnalyticsAspect extends b
{

    public FacebookAnalyticsAspect()
    {
    }

    public void onPause(com.shazam.android.aspects.c.a.a a1)
    {
        super.onPause(a1);
        a.b(a1);
    }

    public void onResume(com.shazam.android.aspects.c.a.a a1)
    {
        super.onResume(a1);
        a.a(a1);
    }
}
