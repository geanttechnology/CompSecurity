// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.games.stats:
//            PlayerStats, PlayerStatsEntityCreator

public class PlayerStatsEntity
    implements SafeParcelable, PlayerStats
{

    public static final android.os.Parcelable.Creator CREATOR = new PlayerStatsEntityCreator();
    private final int mVersionCode;
    private final float zzaBX;
    private final float zzaBY;
    private final int zzaBZ;
    private final int zzaCa;
    private final int zzaCb;
    private final float zzaCc;
    private final float zzaCd;

    PlayerStatsEntity(int i, float f, float f1, int j, int k, int l, float f2, 
            float f3)
    {
        mVersionCode = i;
        zzaBX = f;
        zzaBY = f1;
        zzaBZ = j;
        zzaCa = k;
        zzaCb = l;
        zzaCc = f2;
        zzaCd = f3;
    }

    public PlayerStatsEntity(PlayerStats playerstats)
    {
        mVersionCode = 1;
        zzaBX = playerstats.getAverageSessionLength();
        zzaBY = playerstats.zzvT();
        zzaBZ = playerstats.getDaysSinceLastPlayed();
        zzaCa = playerstats.getNumberOfPurchases();
        zzaCb = playerstats.getNumberOfSessions();
        zzaCc = playerstats.getSessionPercentile();
        zzaCd = playerstats.getSpendPercentile();
    }

    static int zza(PlayerStats playerstats)
    {
        return zzw.hashCode(new Object[] {
            Float.valueOf(playerstats.getAverageSessionLength()), Float.valueOf(playerstats.zzvT()), Integer.valueOf(playerstats.getDaysSinceLastPlayed()), Integer.valueOf(playerstats.getNumberOfPurchases()), Integer.valueOf(playerstats.getNumberOfSessions()), Float.valueOf(playerstats.getSessionPercentile()), Float.valueOf(playerstats.getSpendPercentile())
        });
    }

    static boolean zza(PlayerStats playerstats, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof PlayerStats) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (playerstats == obj) goto _L4; else goto _L3
_L3:
        obj = (PlayerStats)obj;
        if (!zzw.equal(Float.valueOf(((PlayerStats) (obj)).getAverageSessionLength()), Float.valueOf(playerstats.getAverageSessionLength())) || !zzw.equal(Float.valueOf(((PlayerStats) (obj)).zzvT()), Float.valueOf(playerstats.zzvT())) || !zzw.equal(Integer.valueOf(((PlayerStats) (obj)).getDaysSinceLastPlayed()), Integer.valueOf(playerstats.getDaysSinceLastPlayed())) || !zzw.equal(Integer.valueOf(((PlayerStats) (obj)).getNumberOfPurchases()), Integer.valueOf(playerstats.getNumberOfPurchases())) || !zzw.equal(Integer.valueOf(((PlayerStats) (obj)).getNumberOfSessions()), Integer.valueOf(playerstats.getNumberOfSessions())) || !zzw.equal(Float.valueOf(((PlayerStats) (obj)).getSessionPercentile()), Float.valueOf(playerstats.getSessionPercentile())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Float.valueOf(((PlayerStats) (obj)).getSpendPercentile()), Float.valueOf(playerstats.getSpendPercentile()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(PlayerStats playerstats)
    {
        return zzw.zzv(playerstats).zzg("AverageSessionLength", Float.valueOf(playerstats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(playerstats.zzvT())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerstats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(playerstats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(playerstats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(playerstats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(playerstats.getSpendPercentile())).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzvU();
    }

    public float getAverageSessionLength()
    {
        return zzaBX;
    }

    public int getDaysSinceLastPlayed()
    {
        return zzaBZ;
    }

    public int getNumberOfPurchases()
    {
        return zzaCa;
    }

    public int getNumberOfSessions()
    {
        return zzaCb;
    }

    public float getSessionPercentile()
    {
        return zzaCc;
    }

    public float getSpendPercentile()
    {
        return zzaCd;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        PlayerStatsEntityCreator.zza(this, parcel, i);
    }

    public float zzvT()
    {
        return zzaBY;
    }

    public PlayerStats zzvU()
    {
        return this;
    }

}
