// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomUpdateListener, RoomStatusUpdateListener, RealTimeMessageReceivedListener

public final class RoomConfig
{
    public static final class Builder
    {

        final RoomUpdateListener wD;
        RoomStatusUpdateListener wE;
        RealTimeMessageReceivedListener wF;
        Bundle wH;
        boolean wI;
        String wJ;
        ArrayList wK;
        int wo;

        public Builder addPlayersToInvite(ArrayList arraylist)
        {
            eg.f(arraylist);
            wK.addAll(arraylist);
            return this;
        }

        public transient Builder addPlayersToInvite(String as[])
        {
            eg.f(as);
            wK.addAll(Arrays.asList(as));
            return this;
        }

        public RoomConfig build()
        {
            return new RoomConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle)
        {
            wH = bundle;
            return this;
        }

        public Builder setInvitationIdToAccept(String s)
        {
            eg.f(s);
            wJ = s;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener realtimemessagereceivedlistener)
        {
            wF = realtimemessagereceivedlistener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener roomstatusupdatelistener)
        {
            wE = roomstatusupdatelistener;
            return this;
        }

        public Builder setSocketCommunicationEnabled(boolean flag)
        {
            wI = flag;
            return this;
        }

        public Builder setVariant(int i)
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

        private Builder(RoomUpdateListener roomupdatelistener)
        {
            wJ = null;
            wo = -1;
            wK = new ArrayList();
            wI = false;
            wD = (RoomUpdateListener)eg.b(roomupdatelistener, "Must provide a RoomUpdateListener");
        }

    }


    private final String uf;
    private final RoomUpdateListener wD;
    private final RoomStatusUpdateListener wE;
    private final RealTimeMessageReceivedListener wF;
    private final String wG[];
    private final Bundle wH;
    private final boolean wI;
    private final int wo;

    private RoomConfig(Builder builder1)
    {
        wD = builder1.wD;
        wE = builder1.wE;
        wF = builder1.wF;
        uf = builder1.wJ;
        wo = builder1.wo;
        wH = builder1.wH;
        wI = builder1.wI;
        int i = builder1.wK.size();
        wG = (String[])builder1.wK.toArray(new String[i]);
        if (wF == null)
        {
            eg.a(wI, "Must either enable sockets OR specify a message listener");
        }
    }


    public static Builder builder(RoomUpdateListener roomupdatelistener)
    {
        return new Builder(roomupdatelistener);
    }

    public static Bundle createAutoMatchCriteria(int i, int j, long l)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("min_automatch_players", i);
        bundle.putInt("max_automatch_players", j);
        bundle.putLong("exclusive_bit_mask", l);
        return bundle;
    }

    public Bundle getAutoMatchCriteria()
    {
        return wH;
    }

    public String getInvitationId()
    {
        return uf;
    }

    public String[] getInvitedPlayerIds()
    {
        return wG;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener()
    {
        return wF;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener()
    {
        return wE;
    }

    public RoomUpdateListener getRoomUpdateListener()
    {
        return wD;
    }

    public int getVariant()
    {
        return wo;
    }

    public boolean isSocketEnabled()
    {
        return wI;
    }
}
