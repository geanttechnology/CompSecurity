// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;

public final class TurnBasedMatchConfig
{
    public static final class Builder
    {

        Bundle wH;
        ArrayList wK;
        int wT;
        int wo;

        public Builder addInvitedPlayer(String s)
        {
            eg.f(s);
            wK.add(s);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList arraylist)
        {
            eg.f(arraylist);
            wK.addAll(arraylist);
            return this;
        }

        public TurnBasedMatchConfig build()
        {
            return new TurnBasedMatchConfig(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle)
        {
            wH = bundle;
            return this;
        }

        public Builder setMinPlayers(int i)
        {
            wT = i;
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
            eg.b(flag, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            wo = i;
            return this;
        }

        private Builder()
        {
            wo = -1;
            wK = new ArrayList();
            wH = null;
            wT = 2;
        }

    }


    private final String wG[];
    private final Bundle wH;
    private final int wT;
    private final int wo;

    private TurnBasedMatchConfig(Builder builder1)
    {
        wo = builder1.wo;
        wT = builder1.wT;
        wH = builder1.wH;
        int i = builder1.wK.size();
        wG = (String[])builder1.wK.toArray(new String[i]);
    }


    public static Builder builder()
    {
        return new Builder();
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

    public String[] getInvitedPlayerIds()
    {
        return wG;
    }

    public int getMinPlayers()
    {
        return wT;
    }

    public int getVariant()
    {
        return wo;
    }
}
