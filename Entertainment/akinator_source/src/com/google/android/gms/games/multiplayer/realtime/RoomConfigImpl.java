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

    private final int zzaAD;
    private final RoomUpdateListener zzaAO;
    private final RoomStatusUpdateListener zzaAP;
    private final RealTimeMessageReceivedListener zzaAQ;
    private final Bundle zzaAT;
    private final String zzaAU[];
    private final String zzavC;

    RoomConfigImpl(RoomConfig.Builder builder)
    {
        zzaAO = builder.zzaAO;
        zzaAP = builder.zzaAP;
        zzaAQ = builder.zzaAQ;
        zzavC = builder.zzaAR;
        zzaAD = builder.zzaAD;
        zzaAT = builder.zzaAT;
        int i = builder.zzaAS.size();
        zzaAU = (String[])builder.zzaAS.toArray(new String[i]);
        zzx.zzb(zzaAQ, "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria()
    {
        return zzaAT;
    }

    public String getInvitationId()
    {
        return zzavC;
    }

    public String[] getInvitedPlayerIds()
    {
        return zzaAU;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener()
    {
        return zzaAQ;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener()
    {
        return zzaAP;
    }

    public RoomUpdateListener getRoomUpdateListener()
    {
        return zzaAO;
    }

    public int getVariant()
    {
        return zzaAD;
    }
}
