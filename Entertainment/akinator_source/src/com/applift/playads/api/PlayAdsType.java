// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.api;


public final class PlayAdsType extends Enum
{

    private static final PlayAdsType $VALUES[];
    public static final PlayAdsType COVER_FLOW;
    public static final PlayAdsType GAME_LIST;
    public static final PlayAdsType INTERSTITIAL;
    public static final PlayAdsType MEMORY_GAME;
    public static final PlayAdsType SCRATCH_SCREEN;
    public static final PlayAdsType SLOT_MACHINE;
    public static final PlayAdsType VIDEO;

    private PlayAdsType(String s, int i)
    {
        super(s, i);
    }

    public static PlayAdsType valueOf(String s)
    {
        return (PlayAdsType)Enum.valueOf(com/applift/playads/api/PlayAdsType, s);
    }

    public static PlayAdsType[] values()
    {
        return (PlayAdsType[])$VALUES.clone();
    }

    static 
    {
        SCRATCH_SCREEN = new PlayAdsType("SCRATCH_SCREEN", 0);
        GAME_LIST = new PlayAdsType("GAME_LIST", 1);
        SLOT_MACHINE = new PlayAdsType("SLOT_MACHINE", 2);
        MEMORY_GAME = new PlayAdsType("MEMORY_GAME", 3);
        COVER_FLOW = new PlayAdsType("COVER_FLOW", 4);
        INTERSTITIAL = new PlayAdsType("INTERSTITIAL", 5);
        VIDEO = new PlayAdsType("VIDEO", 6);
        $VALUES = (new PlayAdsType[] {
            SCRATCH_SCREEN, GAME_LIST, SLOT_MACHINE, MEMORY_GAME, COVER_FLOW, INTERSTITIAL, VIDEO
        });
    }
}
