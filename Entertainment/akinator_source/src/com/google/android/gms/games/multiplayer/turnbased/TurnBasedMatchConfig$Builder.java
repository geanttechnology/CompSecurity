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

    int zzaAD;
    ArrayList zzaAS;
    Bundle zzaAT;
    int zzaBc;

    public <init> addInvitedPlayer(String s)
    {
        zzx.zzw(s);
        zzaAS.add(s);
        return this;
    }

    public zzaAS addInvitedPlayers(ArrayList arraylist)
    {
        zzx.zzw(arraylist);
        zzaAS.addAll(arraylist);
        return this;
    }

    public TurnBasedMatchConfig build()
    {
        return new TurnBasedMatchConfigImpl(this);
    }

    public t> setAutoMatchCriteria(Bundle bundle)
    {
        zzaAT = bundle;
        return this;
    }

    public zzaAT setVariant(int i)
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
        zzaAD = i;
        return this;
    }

    private ()
    {
        zzaAD = -1;
        zzaAS = new ArrayList();
        zzaAT = null;
        zzaBc = 2;
    }

    zzaBc(zzaBc zzabc)
    {
        this();
    }
}
