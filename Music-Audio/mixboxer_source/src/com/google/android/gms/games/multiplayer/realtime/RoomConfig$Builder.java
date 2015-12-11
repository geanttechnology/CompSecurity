// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomConfig, RoomUpdateListener, RoomStatusUpdateListener, RealTimeMessageReceivedListener

public static final class <init>
{

    final RoomUpdateListener wD;
    RoomStatusUpdateListener wE;
    RealTimeMessageReceivedListener wF;
    Bundle wH;
    boolean wI;
    String wJ;
    ArrayList wK;
    int wo;

    public <init> addPlayersToInvite(ArrayList arraylist)
    {
        eg.f(arraylist);
        wK.addAll(arraylist);
        return this;
    }

    public transient wK addPlayersToInvite(String as[])
    {
        eg.f(as);
        wK.addAll(Arrays.asList(as));
        return this;
    }

    public RoomConfig build()
    {
        return new RoomConfig(this, null);
    }

    public wK setAutoMatchCriteria(Bundle bundle)
    {
        wH = bundle;
        return this;
    }

    public wH setInvitationIdToAccept(String s)
    {
        eg.f(s);
        wJ = s;
        return this;
    }

    public ivedListener setMessageReceivedListener(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
    {
        wF = realtimemessagereceivedlistener;
        return this;
    }

    public tener setRoomStatusUpdateListener(RoomStatusUpdateListener roomstatusupdatelistener)
    {
        wE = roomstatusupdatelistener;
        return this;
    }

    public wE setSocketCommunicationEnabled(boolean flag)
    {
        wI = flag;
        return this;
    }

    public wI setVariant(int i)
    {
        boolean flag;
        if (i == -1 || i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        wo = i;
        return this;
    }

    private tener(RoomUpdateListener roomupdatelistener)
    {
        wJ = null;
        wo = -1;
        wK = new ArrayList();
        wI = false;
        wD = (RoomUpdateListener)eg.b(roomupdatelistener, "Must provide a RoomUpdateListener");
    }

    wD(RoomUpdateListener roomupdatelistener, wD wd)
    {
        this(roomupdatelistener);
    }
}
