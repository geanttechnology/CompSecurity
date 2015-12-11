// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;


class ientation
{

    static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[];
    static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[];
    static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[];
    static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[];

    static 
    {
        $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle = new int[imationStyle.values().length];
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[imationStyle.ROTATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[imationStyle.FLIP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[de.values().length];
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[de.PULL_FROM_END.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[de.PULL_FROM_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[de.MANUAL_REFRESH_ONLY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[de.BOTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State = new int[ate.values().length];
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[ate.RESET.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[ate.PULL_TO_REFRESH.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[ate.RELEASE_TO_REFRESH.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[ate.REFRESHING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[ate.MANUAL_REFRESHING.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[ate.OVERSCROLLING.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation = new int[ientation.values().length];
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[ientation.HORIZONTAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[ientation.VERTICAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
