// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;


public final class PlayNowTab extends Enum
{

    private static final PlayNowTab $VALUES[];
    public static final PlayNowTab BOOKMARKS;
    public static final PlayNowTab DOWNLOADS;
    public static final PlayNowTab FEATURED;
    public static final PlayNowTab HISTORY;
    public static final PlayNowTab KIDS;
    public static final PlayNowTab LIVE;
    public static final PlayNowTab MOVIES;
    public static final PlayNowTab NETWORKS;
    public static final PlayNowTab SETTINGS;
    public static final PlayNowTab TV_SERIES;

    private PlayNowTab(String s, int i)
    {
        super(s, i);
    }

    public static PlayNowTab valueOf(String s)
    {
        return (PlayNowTab)Enum.valueOf(com/xfinity/playerlib/tracking/PlayNowTab, s);
    }

    public static PlayNowTab[] values()
    {
        return (PlayNowTab[])$VALUES.clone();
    }

    String getTabName()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab = new int[PlayNowTab.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.MOVIES.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.TV_SERIES.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.HISTORY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.FEATURED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.NETWORKS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.SETTINGS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.DOWNLOADS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.BOOKMARKS.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.KIDS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$tracking$PlayNowTab[PlayNowTab.LIVE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.xfinity.playerlib.tracking.PlayNowTab[ordinal()])
        {
        default:
            throw new IllegalStateException();

        case 1: // '\001'
            return "Movies";

        case 2: // '\002'
            return "TV Series";

        case 3: // '\003'
            return "History";

        case 4: // '\004'
            return "Featured";

        case 5: // '\005'
            return "Networks";

        case 6: // '\006'
            return "Settings";

        case 7: // '\007'
            return "Downloads";

        case 8: // '\b'
            return "Bookmarks";

        case 9: // '\t'
            return "Kids";

        case 10: // '\n'
            return "Live";
        }
    }

    static 
    {
        MOVIES = new PlayNowTab("MOVIES", 0);
        TV_SERIES = new PlayNowTab("TV_SERIES", 1);
        HISTORY = new PlayNowTab("HISTORY", 2);
        FEATURED = new PlayNowTab("FEATURED", 3);
        NETWORKS = new PlayNowTab("NETWORKS", 4);
        SETTINGS = new PlayNowTab("SETTINGS", 5);
        DOWNLOADS = new PlayNowTab("DOWNLOADS", 6);
        BOOKMARKS = new PlayNowTab("BOOKMARKS", 7);
        KIDS = new PlayNowTab("KIDS", 8);
        LIVE = new PlayNowTab("LIVE", 9);
        $VALUES = (new PlayNowTab[] {
            MOVIES, TV_SERIES, HISTORY, FEATURED, NETWORKS, SETTINGS, DOWNLOADS, BOOKMARKS, KIDS, LIVE
        });
    }
}
