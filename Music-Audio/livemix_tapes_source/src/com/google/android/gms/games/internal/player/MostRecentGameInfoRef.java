// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

// Referenced classes of package com.google.android.gms.games.internal.player:
//            MostRecentGameInfo, MostRecentGameInfoEntity, PlayerColumnNames

public final class MostRecentGameInfoRef extends zzc
    implements MostRecentGameInfo
{

    private final PlayerColumnNames zzarQ;

    public MostRecentGameInfoRef(DataHolder dataholder, int i, PlayerColumnNames playercolumnnames)
    {
        super(dataholder, i);
        zzarQ = playercolumnnames;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zzuM();
    }

    public int hashCode()
    {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString()
    {
        return MostRecentGameInfoEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((MostRecentGameInfoEntity)zzuM()).writeToParcel(parcel, i);
    }

    public String zzuG()
    {
        return getString(zzarQ.zzaxj);
    }

    public String zzuH()
    {
        return getString(zzarQ.zzaxk);
    }

    public long zzuI()
    {
        return getLong(zzarQ.zzaxl);
    }

    public Uri zzuJ()
    {
        return zzce(zzarQ.zzaxm);
    }

    public Uri zzuK()
    {
        return zzce(zzarQ.zzaxn);
    }

    public Uri zzuL()
    {
        return zzce(zzarQ.zzaxo);
    }

    public MostRecentGameInfo zzuM()
    {
        return new MostRecentGameInfoEntity(this);
    }
}
