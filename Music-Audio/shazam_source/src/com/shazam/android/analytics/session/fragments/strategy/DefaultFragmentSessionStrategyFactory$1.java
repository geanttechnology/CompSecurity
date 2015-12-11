// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.session.fragments.strategy;

import com.shazam.android.analytics.session.SessionStrategyType;

// Referenced classes of package com.shazam.android.analytics.session.fragments.strategy:
//            DefaultFragmentSessionStrategyFactory

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
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[SessionStrategyType.RESUME_PAUSE_FOCUSED_UNFOCUSED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[SessionStrategyType.START_STOP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[SessionStrategyType.START_STOP_FOCUSED_UNFOCUSED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[SessionStrategyType.SELECTED_UNSELECTED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[SessionStrategyType.SELECTED_UNSELECTED_FOCUSED_UNFOCUSED.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[SessionStrategyType.SELECTED_UNSELECTED_START_STOP.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[SessionStrategyType.MANUAL.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
