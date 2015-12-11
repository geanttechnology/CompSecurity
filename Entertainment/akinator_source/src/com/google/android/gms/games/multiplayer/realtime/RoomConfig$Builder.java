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

    int zzaAD;
    final RoomUpdateListener zzaAO;
    RoomStatusUpdateListener zzaAP;
    RealTimeMessageReceivedListener zzaAQ;
    String zzaAR;
    ArrayList zzaAS;
    Bundle zzaAT;

    public <init> addPlayersToInvite(ArrayList arraylist)
    {
        zzx.zzw(arraylist);
        zzaAS.addAll(arraylist);
        return this;
    }

    public transient zzaAS addPlayersToInvite(String as[])
    {
        zzx.zzw(as);
        zzaAS.addAll(Arrays.asList(as));
        return this;
    }

    public RoomConfig build()
    {
        return new RoomConfigImpl(this);
    }

    public t> setAutoMatchCriteria(Bundle bundle)
    {
        zzaAT = bundle;
        return this;
    }

    public zzaAT setInvitationIdToAccept(String s)
    {
        zzx.zzw(s);
        zzaAR = s;
        return this;
    }

    public ivedListener setMessageReceivedListener(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
    {
        zzaAQ = realtimemessagereceivedlistener;
        return this;
    }

    public tener setRoomStatusUpdateListener(RoomStatusUpdateListener roomstatusupdatelistener)
    {
        zzaAP = roomstatusupdatelistener;
        return this;
    }

    public zzaAP setVariant(int i)
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
        zzaAD = i;
        return this;
    }

    private tener(RoomUpdateListener roomupdatelistener)
    {
        zzaAR = null;
        zzaAD = -1;
        zzaAS = new ArrayList();
        zzaAO = (RoomUpdateListener)zzx.zzb(roomupdatelistener, "Must provide a RoomUpdateListener");
    }

    zzaAO(RoomUpdateListener roomupdatelistener, zzaAO zzaao)
    {
        this(roomupdatelistener);
    }
}
