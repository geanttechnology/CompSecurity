// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.games:
//            PlayerLevelInfoCreator, PlayerLevel

public final class PlayerLevelInfo
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new PlayerLevelInfoCreator();
    private final int mVersionCode;
    private final long zzauk;
    private final long zzaul;
    private final PlayerLevel zzaum;
    private final PlayerLevel zzaun;

    PlayerLevelInfo(int i, long l, long l1, PlayerLevel playerlevel, PlayerLevel playerlevel1)
    {
        boolean flag;
        if (l != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzx.zzw(playerlevel);
        zzx.zzw(playerlevel1);
        mVersionCode = i;
        zzauk = l;
        zzaul = l1;
        zzaum = playerlevel;
        zzaun = playerlevel1;
    }

    public PlayerLevelInfo(long l, long l1, PlayerLevel playerlevel, PlayerLevel playerlevel1)
    {
        this(1, l, l1, playerlevel, playerlevel1);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof PlayerLevelInfo) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == this) goto _L4; else goto _L3
_L3:
        obj = (PlayerLevelInfo)obj;
        if (!zzw.equal(Long.valueOf(zzauk), Long.valueOf(((PlayerLevelInfo) (obj)).zzauk)) || !zzw.equal(Long.valueOf(zzaul), Long.valueOf(((PlayerLevelInfo) (obj)).zzaul)) || !zzw.equal(zzaum, ((PlayerLevelInfo) (obj)).zzaum))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(zzaun, ((PlayerLevelInfo) (obj)).zzaun)) goto _L4; else goto _L5
_L5:
        return false;
    }

    public PlayerLevel getCurrentLevel()
    {
        return zzaum;
    }

    public long getCurrentXpTotal()
    {
        return zzauk;
    }

    public long getLastLevelUpTimestamp()
    {
        return zzaul;
    }

    public PlayerLevel getNextLevel()
    {
        return zzaun;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzauk), Long.valueOf(zzaul), zzaum, zzaun
        });
    }

    public boolean isMaxLevel()
    {
        return zzaum.equals(zzaun);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        PlayerLevelInfoCreator.zza(this, parcel, i);
    }

}
