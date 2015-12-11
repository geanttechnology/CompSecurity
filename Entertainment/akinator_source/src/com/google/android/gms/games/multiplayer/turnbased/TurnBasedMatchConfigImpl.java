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

    private final int zzaAD;
    private final Bundle zzaAT;
    private final String zzaAU[];
    private final int zzaBc;

    TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder builder)
    {
        zzaAD = builder.zzaAD;
        zzaBc = builder.zzaBc;
        zzaAT = builder.zzaAT;
        int i = builder.zzaAS.size();
        zzaAU = (String[])builder.zzaAS.toArray(new String[i]);
    }

    public Bundle getAutoMatchCriteria()
    {
        return zzaAT;
    }

    public String[] getInvitedPlayerIds()
    {
        return zzaAU;
    }

    public int getVariant()
    {
        return zzaAD;
    }

    public int zzvN()
    {
        return zzaBc;
    }
}
