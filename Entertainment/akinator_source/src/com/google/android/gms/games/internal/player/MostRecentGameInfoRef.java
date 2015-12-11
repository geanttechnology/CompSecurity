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

    private final PlayerColumnNames zzauo;

    public MostRecentGameInfoRef(DataHolder dataholder, int i, PlayerColumnNames playercolumnnames)
    {
        super(dataholder, i);
        zzauo = playercolumnnames;
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
        return zzvC();
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
        ((MostRecentGameInfoEntity)zzvC()).writeToParcel(parcel, i);
    }

    public Uri zzvA()
    {
        return zzcf(zzauo.zzazM);
    }

    public Uri zzvB()
    {
        return zzcf(zzauo.zzazN);
    }

    public MostRecentGameInfo zzvC()
    {
        return new MostRecentGameInfoEntity(this);
    }

    public String zzvw()
    {
        return getString(zzauo.zzazI);
    }

    public String zzvx()
    {
        return getString(zzauo.zzazJ);
    }

    public long zzvy()
    {
        return getLong(zzauo.zzazK);
    }

    public Uri zzvz()
    {
        return zzcf(zzauo.zzazL);
    }
}
