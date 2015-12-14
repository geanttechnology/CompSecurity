// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            RoomConfig, RoomUpdateListener, RoomStatusUpdateListener, RealTimeMessageReceivedListener

public final class RoomConfigImpl extends RoomConfig
{

    private final String zzate;
    private final int zzayd;
    private final RoomUpdateListener zzayo;
    private final RoomStatusUpdateListener zzayp;
    private final RealTimeMessageReceivedListener zzayq;
    private final Bundle zzayt;
    private final String zzayu[];

    RoomConfigImpl(RoomConfig.Builder builder)
    {
        zzayo = builder.zzayo;
        zzayp = builder.zzayp;
        zzayq = builder.zzayq;
        zzate = builder.zzayr;
        zzayd = builder.zzayd;
        zzayt = builder.zzayt;
        int i = builder.zzays.size();
        zzayu = (String[])builder.zzays.toArray(new String[i]);
        zzx.zzb(zzayq, "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria()
    {
        return zzayt;
    }

    public String getInvitationId()
    {
        return zzate;
    }

    public String[] getInvitedPlayerIds()
    {
        return zzayu;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener()
    {
        return zzayq;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener()
    {
        return zzayp;
    }

    public RoomUpdateListener getRoomUpdateListener()
    {
        return zzayo;
    }

    public int getVariant()
    {
        return zzayd;
    }
}
