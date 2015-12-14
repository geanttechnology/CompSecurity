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
    private final int zzazA;
    private final float zzazB;
    private final float zzazC;
    private final float zzazw;
    private final float zzazx;
    private final int zzazy;
    private final int zzazz;

    PlayerStatsEntity(int i, float f, float f1, int j, int k, int l, float f2, 
            float f3)
    {
        mVersionCode = i;
        zzazw = f;
        zzazx = f1;
        zzazy = j;
        zzazz = k;
        zzazA = l;
        zzazB = f2;
        zzazC = f3;
    }

    public PlayerStatsEntity(PlayerStats playerstats)
    {
        mVersionCode = 1;
        zzazw = playerstats.zzvd();
        zzazx = playerstats.zzve();
        zzazy = playerstats.zzvf();
        zzazz = playerstats.zzvg();
        zzazA = playerstats.zzvh();
        zzazB = playerstats.zzvi();
        zzazC = playerstats.zzvj();
    }

    static int zza(PlayerStats playerstats)
    {
        return zzw.hashCode(new Object[] {
            Float.valueOf(playerstats.zzvd()), Float.valueOf(playerstats.zzve()), Integer.valueOf(playerstats.zzvf()), Integer.valueOf(playerstats.zzvg()), Integer.valueOf(playerstats.zzvh()), Float.valueOf(playerstats.zzvi()), Float.valueOf(playerstats.zzvj())
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
        if (!zzw.equal(Float.valueOf(((PlayerStats) (obj)).zzvd()), Float.valueOf(playerstats.zzvd())) || !zzw.equal(Float.valueOf(((PlayerStats) (obj)).zzve()), Float.valueOf(playerstats.zzve())) || !zzw.equal(Integer.valueOf(((PlayerStats) (obj)).zzvf()), Integer.valueOf(playerstats.zzvf())) || !zzw.equal(Integer.valueOf(((PlayerStats) (obj)).zzvg()), Integer.valueOf(playerstats.zzvg())) || !zzw.equal(Integer.valueOf(((PlayerStats) (obj)).zzvh()), Integer.valueOf(playerstats.zzvh())) || !zzw.equal(Float.valueOf(((PlayerStats) (obj)).zzvi()), Float.valueOf(playerstats.zzvi())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Float.valueOf(((PlayerStats) (obj)).zzvj()), Float.valueOf(playerstats.zzvj()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(PlayerStats playerstats)
    {
        return zzw.zzu(playerstats).zzg("AverageSessionLength", Float.valueOf(playerstats.zzvd())).zzg("ChurnProbability", Float.valueOf(playerstats.zzve())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerstats.zzvf())).zzg("NumberOfPurchases", Integer.valueOf(playerstats.zzvg())).zzg("NumberOfSessions", Integer.valueOf(playerstats.zzvh())).zzg("SessionPercentile", Float.valueOf(playerstats.zzvi())).zzg("SpendPercentile", Float.valueOf(playerstats.zzvj())).toString();
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
        return zzvk();
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

    public float zzvd()
    {
        return zzazw;
    }

    public float zzve()
    {
        return zzazx;
    }

    public int zzvf()
    {
        return zzazy;
    }

    public int zzvg()
    {
        return zzazz;
    }

    public int zzvh()
    {
        return zzazA;
    }

    public float zzvi()
    {
        return zzazB;
    }

    public float zzvj()
    {
        return zzazC;
    }

    public PlayerStats zzvk()
    {
        return this;
    }

}
