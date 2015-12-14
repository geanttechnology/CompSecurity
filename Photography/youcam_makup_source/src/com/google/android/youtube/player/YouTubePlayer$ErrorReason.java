// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player;


public final class A extends Enum
{

    public static final UNKNOWN AUTOPLAY_DISABLED;
    public static final UNKNOWN BLOCKED_FOR_APP;
    public static final UNKNOWN EMBEDDING_DISABLED;
    public static final UNKNOWN EMPTY_PLAYLIST;
    public static final UNKNOWN INTERNAL_ERROR;
    public static final UNKNOWN NETWORK_ERROR;
    public static final UNKNOWN NOT_PLAYABLE;
    public static final UNKNOWN PLAYER_VIEW_TOO_SMALL;
    public static final UNKNOWN UNAUTHORIZED_OVERLAY;
    public static final UNKNOWN UNEXPECTED_SERVICE_DISCONNECTION;
    public static final UNKNOWN UNKNOWN;
    public static final UNKNOWN USER_DECLINED_HIGH_BANDWIDTH;
    public static final UNKNOWN USER_DECLINED_RESTRICTED_CONTENT;
    private static final UNKNOWN a[];

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/google/android/youtube/player/YouTubePlayer$ErrorReason, s);
    }

    public static A[] values()
    {
        return (A[])a.clone();
    }

    static 
    {
        EMBEDDING_DISABLED = new <init>("EMBEDDING_DISABLED", 0);
        BLOCKED_FOR_APP = new <init>("BLOCKED_FOR_APP", 1);
        NOT_PLAYABLE = new <init>("NOT_PLAYABLE", 2);
        NETWORK_ERROR = new <init>("NETWORK_ERROR", 3);
        UNAUTHORIZED_OVERLAY = new <init>("UNAUTHORIZED_OVERLAY", 4);
        PLAYER_VIEW_TOO_SMALL = new <init>("PLAYER_VIEW_TOO_SMALL", 5);
        EMPTY_PLAYLIST = new <init>("EMPTY_PLAYLIST", 6);
        AUTOPLAY_DISABLED = new <init>("AUTOPLAY_DISABLED", 7);
        USER_DECLINED_RESTRICTED_CONTENT = new <init>("USER_DECLINED_RESTRICTED_CONTENT", 8);
        USER_DECLINED_HIGH_BANDWIDTH = new <init>("USER_DECLINED_HIGH_BANDWIDTH", 9);
        UNEXPECTED_SERVICE_DISCONNECTION = new <init>("UNEXPECTED_SERVICE_DISCONNECTION", 10);
        INTERNAL_ERROR = new <init>("INTERNAL_ERROR", 11);
        UNKNOWN = new <init>("UNKNOWN", 12);
        a = (new a[] {
            EMBEDDING_DISABLED, BLOCKED_FOR_APP, NOT_PLAYABLE, NETWORK_ERROR, UNAUTHORIZED_OVERLAY, PLAYER_VIEW_TOO_SMALL, EMPTY_PLAYLIST, AUTOPLAY_DISABLED, USER_DECLINED_RESTRICTED_CONTENT, USER_DECLINED_HIGH_BANDWIDTH, 
            UNEXPECTED_SERVICE_DISCONNECTION, INTERNAL_ERROR, UNKNOWN
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
