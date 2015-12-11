// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

// Referenced classes of package com.google.android.gms.games.internal.game:
//            GameBadge, GameBadgeEntityCreator

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel
    implements GameBadge
{
    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzea(parcel);
        }

        public GameBadgeEntity zzea(Parcel parcel)
        {
            if (GameBadgeEntity.zzc(GameBadgeEntity.zztC()) || GameBadgeEntity.zzcV(com/google/android/gms/games/internal/game/GameBadgeEntity.getCanonicalName()))
            {
                return super.zzea(parcel);
            }
            int i = parcel.readInt();
            String s = parcel.readString();
            String s1 = parcel.readString();
            parcel = parcel.readString();
            if (parcel == null)
            {
                parcel = null;
            } else
            {
                parcel = Uri.parse(parcel);
            }
            return new GameBadgeEntity(1, i, s, s1, parcel);
        }

        GameBadgeEntityCreatorCompat()
        {
        }
    }


    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int mVersionCode;
    private int zzWJ;
    private String zzajf;
    private String zzaqZ;
    private Uri zzatu;

    GameBadgeEntity(int i, int j, String s, String s1, Uri uri)
    {
        mVersionCode = i;
        zzWJ = j;
        zzajf = s;
        zzaqZ = s1;
        zzatu = uri;
    }

    public GameBadgeEntity(GameBadge gamebadge)
    {
        mVersionCode = 1;
        zzWJ = gamebadge.getType();
        zzajf = gamebadge.getTitle();
        zzaqZ = gamebadge.getDescription();
        zzatu = gamebadge.getIconImageUri();
    }

    static int zza(GameBadge gamebadge)
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(gamebadge.getType()), gamebadge.getTitle(), gamebadge.getDescription(), gamebadge.getIconImageUri()
        });
    }

    static boolean zza(GameBadge gamebadge, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof GameBadge) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (gamebadge == obj) goto _L4; else goto _L3
_L3:
        obj = (GameBadge)obj;
        if (!zzw.equal(Integer.valueOf(((GameBadge) (obj)).getType()), gamebadge.getTitle()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((GameBadge) (obj)).getDescription(), gamebadge.getIconImageUri())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(GameBadge gamebadge)
    {
        return zzw.zzv(gamebadge).zzg("Type", Integer.valueOf(gamebadge.getType())).zzg("Title", gamebadge.getTitle()).zzg("Description", gamebadge.getDescription()).zzg("IconImageUri", gamebadge.getIconImageUri()).toString();
    }

    static boolean zzc(Integer integer)
    {
        return zzd(integer);
    }

    static boolean zzcV(String s)
    {
        return zzck(s);
    }

    static Integer zztC()
    {
        return zzoT();
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

    public String getDescription()
    {
        return zzaqZ;
    }

    public Uri getIconImageUri()
    {
        return zzatu;
    }

    public String getTitle()
    {
        return zzajf;
    }

    public int getType()
    {
        return zzWJ;
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
        if (!zzoU())
        {
            GameBadgeEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeInt(zzWJ);
        parcel.writeString(zzajf);
        parcel.writeString(zzaqZ);
        String s;
        if (zzatu == null)
        {
            s = null;
        } else
        {
            s = zzatu.toString();
        }
        parcel.writeString(s);
    }

    public GameBadge zzvk()
    {
        return this;
    }

}
