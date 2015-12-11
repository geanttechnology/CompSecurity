// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.internal;


class tion
{

    static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[];
    static final int $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[];

    static 
    {
        $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[com.handmark.pulltorefresh.library.e.Mode.values().length];
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[com.handmark.pulltorefresh.library.e.Mode.PULL_FROM_END.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[com.handmark.pulltorefresh.library.e.Mode.PULL_FROM_START.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation = new int[com.handmark.pulltorefresh.library.e.Orientation.values().length];
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[com.handmark.pulltorefresh.library.e.Orientation.HORIZONTAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[com.handmark.pulltorefresh.library.e.Orientation.VERTICAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
