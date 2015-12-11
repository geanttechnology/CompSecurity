// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchConfig

public static final class <init>
{

    Bundle wH;
    ArrayList wK;
    int wT;
    int wo;

    public <init> addInvitedPlayer(String s)
    {
        eg.f(s);
        wK.add(s);
        return this;
    }

    public wK addInvitedPlayers(ArrayList arraylist)
    {
        eg.f(arraylist);
        wK.addAll(arraylist);
        return this;
    }

    public TurnBasedMatchConfig build()
    {
        return new TurnBasedMatchConfig(this, null);
    }

    public wK setAutoMatchCriteria(Bundle bundle)
    {
        wH = bundle;
        return this;
    }

    public wH setMinPlayers(int i)
    {
        wT = i;
        return this;
    }

    public wT setVariant(int i)
    {
        boolean flag;
        if (i == -1 || i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        eg.b(flag, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        wo = i;
        return this;
    }

    private ()
    {
        wo = -1;
        wK = new ArrayList();
        wH = null;
        wT = 2;
    }

    wT(wT wt)
    {
        this();
    }
}
