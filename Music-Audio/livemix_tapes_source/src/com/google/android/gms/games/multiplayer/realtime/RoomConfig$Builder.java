// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomConfig, RoomUpdateListener, RoomConfigImpl, RoomStatusUpdateListener, 
//            RealTimeMessageReceivedListener

public static final class <init>
{

    int zzayd;
    final RoomUpdateListener zzayo;
    RoomStatusUpdateListener zzayp;
    RealTimeMessageReceivedListener zzayq;
    String zzayr;
    ArrayList zzays;
    Bundle zzayt;

    public <init> addPlayersToInvite(ArrayList arraylist)
    {
        zzx.zzv(arraylist);
        zzays.addAll(arraylist);
        return this;
    }

    public transient zzays addPlayersToInvite(String as[])
    {
        zzx.zzv(as);
        zzays.addAll(Arrays.asList(as));
        return this;
    }

    public RoomConfig build()
    {
        return new RoomConfigImpl(this);
    }

    public t> setAutoMatchCriteria(Bundle bundle)
    {
        zzayt = bundle;
        return this;
    }

    public zzayt setInvitationIdToAccept(String s)
    {
        zzx.zzv(s);
        zzayr = s;
        return this;
    }

    public ivedListener setMessageReceivedListener(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
    {
        zzayq = realtimemessagereceivedlistener;
        return this;
    }

    public tener setRoomStatusUpdateListener(RoomStatusUpdateListener roomstatusupdatelistener)
    {
        zzayp = roomstatusupdatelistener;
        return this;
    }

    public zzayp setVariant(int i)
    {
        boolean flag;
        if (i == -1 || i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        zzayd = i;
        return this;
    }

    private tener(RoomUpdateListener roomupdatelistener)
    {
        zzayr = null;
        zzayd = -1;
        zzays = new ArrayList();
        zzayo = (RoomUpdateListener)zzx.zzb(roomupdatelistener, "Must provide a RoomUpdateListener");
    }

    zzayo(RoomUpdateListener roomupdatelistener, zzayo zzayo1)
    {
        this(roomupdatelistener);
    }
}
