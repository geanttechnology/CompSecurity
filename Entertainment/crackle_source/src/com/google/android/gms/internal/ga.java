// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            fl

public final class ga
    implements RealTimeMultiplayer
{

    public ga()
    {
    }

    public void create(GoogleApiClient googleapiclient, RoomConfig roomconfig)
    {
        Games.j(googleapiclient).createRoom(roomconfig);
    }

    public void declineInvitation(GoogleApiClient googleapiclient, String s)
    {
        Games.j(googleapiclient).j(s, 0);
    }

    public void dismissInvitation(GoogleApiClient googleapiclient, String s)
    {
        Games.j(googleapiclient).i(s, 0);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j)
    {
        return Games.j(googleapiclient).getRealTimeSelectOpponentsIntent(i, j, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleapiclient, int i, int j, boolean flag)
    {
        return Games.j(googleapiclient).getRealTimeSelectOpponentsIntent(i, j, flag);
    }

    public RealTimeSocket getSocketForParticipant(GoogleApiClient googleapiclient, String s, String s1)
    {
        return Games.j(googleapiclient).getRealTimeSocketForParticipant(s, s1);
    }

    public Intent getWaitingRoomIntent(GoogleApiClient googleapiclient, Room room, int i)
    {
        return Games.j(googleapiclient).getRealTimeWaitingRoomIntent(room, i);
    }

    public void join(GoogleApiClient googleapiclient, RoomConfig roomconfig)
    {
        Games.j(googleapiclient).joinRoom(roomconfig);
    }

    public void leave(GoogleApiClient googleapiclient, RoomUpdateListener roomupdatelistener, String s)
    {
        Games.j(googleapiclient).leaveRoom(roomupdatelistener, s);
    }

    public int sendReliableMessage(GoogleApiClient googleapiclient, com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback reliablemessagesentcallback, byte abyte0[], String s, String s1)
    {
        return Games.j(googleapiclient).a(reliablemessagesentcallback, abyte0, s, s1);
    }

    public int sendUnreliableMessage(GoogleApiClient googleapiclient, byte abyte0[], String s, String s1)
    {
        return Games.j(googleapiclient).a(abyte0, s, new String[] {
            s1
        });
    }

    public int sendUnreliableMessage(GoogleApiClient googleapiclient, byte abyte0[], String s, List list)
    {
        list = (String[])list.toArray(new String[list.size()]);
        return Games.j(googleapiclient).a(abyte0, s, list);
    }

    public int sendUnreliableMessageToAll(GoogleApiClient googleapiclient, byte abyte0[], String s)
    {
        return Games.j(googleapiclient).sendUnreliableRealTimeMessageToAll(abyte0, s);
    }
}
