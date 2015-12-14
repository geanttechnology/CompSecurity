// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchConfig

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig
{

    private final int zzayC;
    private final int zzayd;
    private final Bundle zzayt;
    private final String zzayu[];

    TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder builder)
    {
        zzayd = builder.zzayd;
        zzayC = builder.zzayC;
        zzayt = builder.zzayt;
        int i = builder.zzays.size();
        zzayu = (String[])builder.zzays.toArray(new String[i]);
    }

    public Bundle getAutoMatchCriteria()
    {
        return zzayt;
    }

    public String[] getInvitedPlayerIds()
    {
        return zzayu;
    }

    public int getVariant()
    {
        return zzayd;
    }

    public int zzuX()
    {
        return zzayC;
    }
}
