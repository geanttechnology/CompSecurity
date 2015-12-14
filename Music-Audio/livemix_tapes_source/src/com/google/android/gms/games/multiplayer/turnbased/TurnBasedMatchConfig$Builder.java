// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchConfig, TurnBasedMatchConfigImpl

public static final class <init>
{

    int zzayC;
    int zzayd;
    ArrayList zzays;
    Bundle zzayt;

    public <init> addInvitedPlayer(String s)
    {
        zzx.zzv(s);
        zzays.add(s);
        return this;
    }

    public zzays addInvitedPlayers(ArrayList arraylist)
    {
        zzx.zzv(arraylist);
        zzays.addAll(arraylist);
        return this;
    }

    public TurnBasedMatchConfig build()
    {
        return new TurnBasedMatchConfigImpl(this);
    }

    public t> setAutoMatchCriteria(Bundle bundle)
    {
        zzayt = bundle;
        return this;
    }

    public zzayt setVariant(int i)
    {
        boolean flag;
        if (i == -1 || i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        zzayd = i;
        return this;
    }

    private ()
    {
        zzayd = -1;
        zzays = new ArrayList();
        zzayt = null;
        zzayC = 2;
    }

    zzayC(zzayC zzayc)
    {
        this();
    }
}
