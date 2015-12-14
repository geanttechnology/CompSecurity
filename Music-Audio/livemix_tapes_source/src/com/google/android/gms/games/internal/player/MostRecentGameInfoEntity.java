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
    private final String zzawL;
    private final String zzawM;
    private final long zzawN;
    private final Uri zzawO;
    private final Uri zzawP;
    private final Uri zzawQ;

    MostRecentGameInfoEntity(int i, String s, String s1, long l, Uri uri, Uri uri1, 
            Uri uri2)
    {
        mVersionCode = i;
        zzawL = s;
        zzawM = s1;
        zzawN = l;
        zzawO = uri;
        zzawP = uri1;
        zzawQ = uri2;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo mostrecentgameinfo)
    {
        mVersionCode = 2;
        zzawL = mostrecentgameinfo.zzuG();
        zzawM = mostrecentgameinfo.zzuH();
        zzawN = mostrecentgameinfo.zzuI();
        zzawO = mostrecentgameinfo.zzuJ();
        zzawP = mostrecentgameinfo.zzuK();
        zzawQ = mostrecentgameinfo.zzuL();
    }

    static int zza(MostRecentGameInfo mostrecentgameinfo)
    {
        return zzw.hashCode(new Object[] {
            mostrecentgameinfo.zzuG(), mostrecentgameinfo.zzuH(), Long.valueOf(mostrecentgameinfo.zzuI()), mostrecentgameinfo.zzuJ(), mostrecentgameinfo.zzuK(), mostrecentgameinfo.zzuL()
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
        if (!zzw.equal(((MostRecentGameInfo) (obj)).zzuG(), mostrecentgameinfo.zzuG()) || !zzw.equal(((MostRecentGameInfo) (obj)).zzuH(), mostrecentgameinfo.zzuH()) || !zzw.equal(Long.valueOf(((MostRecentGameInfo) (obj)).zzuI()), Long.valueOf(mostrecentgameinfo.zzuI())) || !zzw.equal(((MostRecentGameInfo) (obj)).zzuJ(), mostrecentgameinfo.zzuJ()) || !zzw.equal(((MostRecentGameInfo) (obj)).zzuK(), mostrecentgameinfo.zzuK()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((MostRecentGameInfo) (obj)).zzuL(), mostrecentgameinfo.zzuL())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(MostRecentGameInfo mostrecentgameinfo)
    {
        return zzw.zzu(mostrecentgameinfo).zzg("GameId", mostrecentgameinfo.zzuG()).zzg("GameName", mostrecentgameinfo.zzuH()).zzg("ActivityTimestampMillis", Long.valueOf(mostrecentgameinfo.zzuI())).zzg("GameIconUri", mostrecentgameinfo.zzuJ()).zzg("GameHiResUri", mostrecentgameinfo.zzuK()).zzg("GameFeaturedUri", mostrecentgameinfo.zzuL()).toString();
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
        return zzuM();
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

    public String zzuG()
    {
        return zzawL;
    }

    public String zzuH()
    {
        return zzawM;
    }

    public long zzuI()
    {
        return zzawN;
    }

    public Uri zzuJ()
    {
        return zzawO;
    }

    public Uri zzuK()
    {
        return zzawP;
    }

    public Uri zzuL()
    {
        return zzawQ;
    }

    public MostRecentGameInfo zzuM()
    {
        return this;
    }

}
