// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

// Referenced classes of package com.google.android.gms.games.stats:
//            PlayerStats, PlayerStatsEntity

public class PlayerStatsRef extends zzc
    implements PlayerStats
{

    PlayerStatsRef(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return PlayerStatsEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zzvU();
    }

    public float getAverageSessionLength()
    {
        return getFloat("ave_session_length_minutes");
    }

    public int getDaysSinceLastPlayed()
    {
        return getInteger("days_since_last_played");
    }

    public int getNumberOfPurchases()
    {
        return getInteger("num_purchases");
    }

    public int getNumberOfSessions()
    {
        return getInteger("num_sessions");
    }

    public float getSessionPercentile()
    {
        return getFloat("num_sessions_percentile");
    }

    public float getSpendPercentile()
    {
        return getFloat("spend_percentile");
    }

    public int hashCode()
    {
        return PlayerStatsEntity.zza(this);
    }

    public String toString()
    {
        return PlayerStatsEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((PlayerStatsEntity)zzvU()).writeToParcel(parcel, i);
    }

    public float zzvT()
    {
        return getFloat("churn_probability");
    }

    public PlayerStats zzvU()
    {
        return new PlayerStatsEntity(this);
    }
}
