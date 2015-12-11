// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.activity.strategy;

import com.shazam.android.analytics.session.SessionStrategyType;

// Referenced classes of package com.shazam.android.analytics.session.activity.strategy:
//            DefaultActivitySessionStrategyFactory

static class 
{

    static final int a[];

    static 
    {
        a = new int[SessionStrategyType.values().length];
        try
        {
            a[SessionStrategyType.RESUME_PAUSE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[SessionStrategyType.RESUME_PAUSE_FOCUSED_UNFOCUSED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[SessionStrategyType.START_STOP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[SessionStrategyType.START_STOP_FOCUSED_UNFOCUSED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
