// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.player;


// Referenced classes of package com.spotify.sdk.android.player:
//            PlayerState

interface NativePlayerNotificationCallback
{

    public abstract void onPlaybackError(int i, String s);

    public abstract void onPlaybackEvent(int i, PlayerState playerstate);
}
