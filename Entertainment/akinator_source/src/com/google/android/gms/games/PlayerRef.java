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

    private final PlayerLevelInfo zzaud;
    private final PlayerColumnNames zzauo;
    private final MostRecentGameInfoRef zzaup;

    public PlayerRef(DataHolder dataholder, int i)
    {
        this(dataholder, i, null);
    }

    public PlayerRef(DataHolder dataholder, int i, String s)
    {
        super(dataholder, i);
        zzauo = new PlayerColumnNames(s);
        zzaup = new MostRecentGameInfoRef(dataholder, i, zzauo);
        if (zztJ())
        {
            i = getInteger(zzauo.zzazA);
            int j = getInteger(zzauo.zzazD);
            s = new PlayerLevel(i, getLong(zzauo.zzazB), getLong(zzauo.zzazC));
            if (i != j)
            {
                dataholder = new PlayerLevel(j, getLong(zzauo.zzazC), getLong(zzauo.zzazE));
            } else
            {
                dataholder = s;
            }
            zzaud = new PlayerLevelInfo(getLong(zzauo.zzazz), getLong(zzauo.zzazF), s, dataholder);
            return;
        } else
        {
            zzaud = null;
            return;
        }
    }

    private boolean zztJ()
    {
        while (zzcg(zzauo.zzazz) || getLong(zzauo.zzazz) == -1L) 
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
        return getString(zzauo.zzazr);
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zza(zzauo.zzazr, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return zzcf(zzauo.zzazu);
    }

    public String getHiResImageUrl()
    {
        return getString(zzauo.zzazv);
    }

    public Uri getIconImageUri()
    {
        return zzcf(zzauo.zzazs);
    }

    public String getIconImageUrl()
    {
        return getString(zzauo.zzazt);
    }

    public long getLastPlayedWithTimestamp()
    {
        if (!zzce(zzauo.zzazy) || zzcg(zzauo.zzazy))
        {
            return -1L;
        } else
        {
            return getLong(zzauo.zzazy);
        }
    }

    public PlayerLevelInfo getLevelInfo()
    {
        return zzaud;
    }

    public String getName()
    {
        return getString(zzauo.name);
    }

    public String getPlayerId()
    {
        return getString(zzauo.zzazq);
    }

    public long getRetrievedTimestamp()
    {
        return getLong(zzauo.zzazw);
    }

    public String getTitle()
    {
        return getString(zzauo.title);
    }

    public void getTitle(CharArrayBuffer chararraybuffer)
    {
        zza(zzauo.title, chararraybuffer);
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

    public String toString()
    {
        return com.google.android.gms.games.PlayerEntity.zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((PlayerEntity)freeze()).writeToParcel(parcel, i);
    }

    public String zztE()
    {
        return getString(zzauo.zzazP);
    }

    public boolean zztF()
    {
        return getBoolean(zzauo.zzazO);
    }

    public int zztG()
    {
        return getInteger(zzauo.zzazx);
    }

    public boolean zztH()
    {
        return getBoolean(zzauo.zzazH);
    }

    public MostRecentGameInfo zztI()
    {
        if (zzcg(zzauo.zzazI))
        {
            return null;
        } else
        {
            return zzaup;
        }
    }
}
