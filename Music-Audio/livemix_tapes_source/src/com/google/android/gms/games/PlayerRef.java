// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerLevel, PlayerLevelInfo, PlayerEntity

public final class PlayerRef extends zzc
    implements Player
{

    private final PlayerLevelInfo zzarG;
    private final PlayerColumnNames zzarQ;
    private final MostRecentGameInfoRef zzarR;

    public PlayerRef(DataHolder dataholder, int i)
    {
        this(dataholder, i, null);
    }

    public PlayerRef(DataHolder dataholder, int i, String s)
    {
        super(dataholder, i);
        zzarQ = new PlayerColumnNames(s);
        zzarR = new MostRecentGameInfoRef(dataholder, i, zzarQ);
        if (zzsU())
        {
            i = getInteger(zzarQ.zzaxb);
            int j = getInteger(zzarQ.zzaxe);
            s = new PlayerLevel(i, getLong(zzarQ.zzaxc), getLong(zzarQ.zzaxd));
            if (i != j)
            {
                dataholder = new PlayerLevel(j, getLong(zzarQ.zzaxd), getLong(zzarQ.zzaxf));
            } else
            {
                dataholder = s;
            }
            zzarG = new PlayerLevelInfo(getLong(zzarQ.zzaxa), getLong(zzarQ.zzaxg), s, dataholder);
            return;
        } else
        {
            zzarG = null;
            return;
        }
    }

    private boolean zzsU()
    {
        while (zzcf(zzarQ.zzaxa) || getLong(zzarQ.zzaxa) == -1L) 
        {
            return false;
        }
        return true;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze()
    {
        return new PlayerEntity(this);
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String getDisplayName()
    {
        return getString(zzarQ.zzawS);
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zza(zzarQ.zzawS, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return zzce(zzarQ.zzawV);
    }

    public String getHiResImageUrl()
    {
        return getString(zzarQ.zzawW);
    }

    public Uri getIconImageUri()
    {
        return zzce(zzarQ.zzawT);
    }

    public String getIconImageUrl()
    {
        return getString(zzarQ.zzawU);
    }

    public long getLastPlayedWithTimestamp()
    {
        if (!zzcd(zzarQ.zzawZ) || zzcf(zzarQ.zzawZ))
        {
            return -1L;
        } else
        {
            return getLong(zzarQ.zzawZ);
        }
    }

    public PlayerLevelInfo getLevelInfo()
    {
        return zzarG;
    }

    public String getPlayerId()
    {
        return getString(zzarQ.zzawR);
    }

    public long getRetrievedTimestamp()
    {
        return getLong(zzarQ.zzawX);
    }

    public String getTitle()
    {
        return getString(zzarQ.title);
    }

    public void getTitle(CharArrayBuffer chararraybuffer)
    {
        zza(zzarQ.title, chararraybuffer);
    }

    public boolean hasHiResImage()
    {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage()
    {
        return getIconImageUri() != null;
    }

    public int hashCode()
    {
        return PlayerEntity.zzb(this);
    }

    public boolean isProfileVisible()
    {
        return getBoolean(zzarQ.zzaxi);
    }

    public String toString()
    {
        return com.google.android.gms.games.PlayerEntity.zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((PlayerEntity)freeze()).writeToParcel(parcel, i);
    }

    public boolean zzsR()
    {
        return getBoolean(zzarQ.zzaxp);
    }

    public int zzsS()
    {
        return getInteger(zzarQ.zzawY);
    }

    public MostRecentGameInfo zzsT()
    {
        if (zzcf(zzarQ.zzaxj))
        {
            return null;
        } else
        {
            return zzarR;
        }
    }
}
