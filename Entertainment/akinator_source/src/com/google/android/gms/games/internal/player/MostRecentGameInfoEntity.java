// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.games.internal.player:
//            MostRecentGameInfo, MostRecentGameInfoEntityCreator

public final class MostRecentGameInfoEntity
    implements SafeParcelable, MostRecentGameInfo
{

    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int mVersionCode;
    private final String zzazk;
    private final String zzazl;
    private final long zzazm;
    private final Uri zzazn;
    private final Uri zzazo;
    private final Uri zzazp;

    MostRecentGameInfoEntity(int i, String s, String s1, long l, Uri uri, Uri uri1, 
            Uri uri2)
    {
        mVersionCode = i;
        zzazk = s;
        zzazl = s1;
        zzazm = l;
        zzazn = uri;
        zzazo = uri1;
        zzazp = uri2;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostrecentgameinfo)
    {
        mVersionCode = 2;
        zzazk = mostrecentgameinfo.zzvw();
        zzazl = mostrecentgameinfo.zzvx();
        zzazm = mostrecentgameinfo.zzvy();
        zzazn = mostrecentgameinfo.zzvz();
        zzazo = mostrecentgameinfo.zzvA();
        zzazp = mostrecentgameinfo.zzvB();
    }

    static int zza(MostRecentGameInfo mostrecentgameinfo)
    {
        return zzw.hashCode(new Object[] {
            mostrecentgameinfo.zzvw(), mostrecentgameinfo.zzvx(), Long.valueOf(mostrecentgameinfo.zzvy()), mostrecentgameinfo.zzvz(), mostrecentgameinfo.zzvA(), mostrecentgameinfo.zzvB()
        });
    }

    static boolean zza(MostRecentGameInfo mostrecentgameinfo, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof MostRecentGameInfo) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (mostrecentgameinfo == obj) goto _L4; else goto _L3
_L3:
        obj = (MostRecentGameInfo)obj;
        if (!zzw.equal(((MostRecentGameInfo) (obj)).zzvw(), mostrecentgameinfo.zzvw()) || !zzw.equal(((MostRecentGameInfo) (obj)).zzvx(), mostrecentgameinfo.zzvx()) || !zzw.equal(Long.valueOf(((MostRecentGameInfo) (obj)).zzvy()), Long.valueOf(mostrecentgameinfo.zzvy())) || !zzw.equal(((MostRecentGameInfo) (obj)).zzvz(), mostrecentgameinfo.zzvz()) || !zzw.equal(((MostRecentGameInfo) (obj)).zzvA(), mostrecentgameinfo.zzvA()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((MostRecentGameInfo) (obj)).zzvB(), mostrecentgameinfo.zzvB())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(MostRecentGameInfo mostrecentgameinfo)
    {
        return zzw.zzv(mostrecentgameinfo).zzg("GameId", mostrecentgameinfo.zzvw()).zzg("GameName", mostrecentgameinfo.zzvx()).zzg("ActivityTimestampMillis", Long.valueOf(mostrecentgameinfo.zzvy())).zzg("GameIconUri", mostrecentgameinfo.zzvz()).zzg("GameHiResUri", mostrecentgameinfo.zzvA()).zzg("GameFeaturedUri", mostrecentgameinfo.zzvB()).toString();
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
        return zzvC();
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
        MostRecentGameInfoEntityCreator.zza(this, parcel, i);
    }

    public Uri zzvA()
    {
        return zzazo;
    }

    public Uri zzvB()
    {
        return zzazp;
    }

    public MostRecentGameInfo zzvC()
    {
        return this;
    }

    public String zzvw()
    {
        return zzazk;
    }

    public String zzvx()
    {
        return zzazl;
    }

    public long zzvy()
    {
        return zzazm;
    }

    public Uri zzvz()
    {
        return zzazn;
    }

}
