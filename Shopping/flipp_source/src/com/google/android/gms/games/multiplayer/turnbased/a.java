// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.d;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.turnbased:
//            TurnBasedMatch, TurnBasedMatchEntity

public final class a extends e
    implements TurnBasedMatch
{

    private final Game c;
    private final int d;

    private TurnBasedMatch u()
    {
        return new TurnBasedMatchEntity(this);
    }

    public final Object a()
    {
        return u();
    }

    public final Game b()
    {
        return c;
    }

    public final String c()
    {
        return d("external_match_id");
    }

    public final String d()
    {
        return d("creator_external");
    }

    public final int describeContents()
    {
        return 0;
    }

    public final long e()
    {
        return a("creation_timestamp");
    }

    public final boolean equals(Object obj)
    {
        return TurnBasedMatchEntity.a(this, obj);
    }

    public final int f()
    {
        return b("status");
    }

    public final int g()
    {
        return b("user_match_status");
    }

    public final int h()
    {
        return b("variant");
    }

    public final int hashCode()
    {
        return TurnBasedMatchEntity.a(this);
    }

    public final ArrayList i()
    {
        ArrayList arraylist = new ArrayList(d);
        for (int i1 = 0; i1 < d; i1++)
        {
            arraylist.add(new d(a, b + i1));
        }

        return arraylist;
    }

    public final String j()
    {
        return d("last_updater_external");
    }

    public final long k()
    {
        return a("last_updated_timestamp");
    }

    public final String l()
    {
        return d("pending_participant_external");
    }

    public final byte[] m()
    {
        return e("data");
    }

    public final int n()
    {
        return b("version");
    }

    public final String o()
    {
        return d("rematch_id");
    }

    public final byte[] p()
    {
        return e("previous_match_data");
    }

    public final int q()
    {
        return b("match_number");
    }

    public final Bundle r()
    {
        if (!c("has_automatch_criteria"))
        {
            return null;
        } else
        {
            int i1 = b("automatch_min_players");
            int j1 = b("automatch_max_players");
            long l1 = a("automatch_bit_mask");
            Bundle bundle = new Bundle();
            bundle.putInt("min_automatch_players", i1);
            bundle.putInt("max_automatch_players", j1);
            bundle.putLong("exclusive_bit_mask", l1);
            return bundle;
        }
    }

    public final int s()
    {
        if (!c("has_automatch_criteria"))
        {
            return 0;
        } else
        {
            return b("automatch_max_players");
        }
    }

    public final boolean t()
    {
        return c("upsync_required");
    }

    public final String toString()
    {
        return TurnBasedMatchEntity.b(this);
    }

    public final void writeToParcel(Parcel parcel, int i1)
    {
        ((TurnBasedMatchEntity)u()).writeToParcel(parcel, i1);
    }
}
