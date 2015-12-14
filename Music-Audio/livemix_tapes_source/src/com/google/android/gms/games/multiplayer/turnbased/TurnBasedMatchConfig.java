// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatchConfigImpl

public abstract class TurnBasedMatchConfig
{
    public static final class Builder
    {

        int zzayC;
        int zzayd;
        ArrayList zzays;
        Bundle zzayt;

        public Builder addInvitedPlayer(String s)
        {
            zzx.zzv(s);
            zzays.add(s);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList arraylist)
        {
            zzx.zzv(arraylist);
            zzays.addAll(arraylist);
            return this;
        }

        public TurnBasedMatchConfig build()
        {
            return new TurnBasedMatchConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle bundle)
        {
            zzayt = bundle;
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
            zzx.zzb(flag, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            zzayd = i;
            return this;
        }

        private Builder()
        {
            zzayd = -1;
            zzays = new ArrayList();
            zzayt = null;
            zzayC = 2;
        }

    }


    protected TurnBasedMatchConfig()
    {
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

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zzuX();
}
