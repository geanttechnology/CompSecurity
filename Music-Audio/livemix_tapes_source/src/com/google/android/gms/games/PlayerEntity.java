// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzln;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerEntityCreator, PlayerLevelInfo

public final class PlayerEntity extends GamesDowngradeableSafeParcel
    implements Player
{
    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdD(parcel);
        }

        public PlayerEntity zzdD(Parcel parcel)
        {
            if (PlayerEntity.zzc(PlayerEntity.zzsP()) || PlayerEntity.zzcW(com/google/android/gms/games/PlayerEntity.getCanonicalName()))
            {
                return super.zzdD(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            Object obj = parcel.readString();
            Object obj1 = parcel.readString();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = Uri.parse(((String) (obj)));
            }
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = Uri.parse(((String) (obj1)));
            }
            return new PlayerEntity(12, s, s1, ((Uri) (obj)), ((Uri) (obj1)), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false);
        }

        PlayerEntityCreatorCompat()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new PlayerEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzWn;
    private final String zzagU;
    private final String zzahh;
    private final Uri zzaqW;
    private final Uri zzaqX;
    private final long zzarC;
    private final int zzarD;
    private final long zzarE;
    private final MostRecentGameInfoEntity zzarF;
    private final PlayerLevelInfo zzarG;
    private final boolean zzarH;
    private final boolean zzarI;
    private final String zzarh;
    private final String zzari;

    PlayerEntity(int i, String s, String s1, Uri uri, Uri uri1, long l, 
            int j, long l1, String s2, String s3, String s4, MostRecentGameInfoEntity mostrecentgameinfoentity, 
            PlayerLevelInfo playerlevelinfo, boolean flag, boolean flag1)
    {
        mVersionCode = i;
        zzWn = s;
        zzahh = s1;
        zzaqW = uri;
        zzarh = s2;
        zzaqX = uri1;
        zzari = s3;
        zzarC = l;
        zzarD = j;
        zzarE = l1;
        zzagU = s4;
        zzarH = flag;
        zzarF = mostrecentgameinfoentity;
        zzarG = playerlevelinfo;
        zzarI = flag1;
    }

    public PlayerEntity(Player player)
    {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean flag)
    {
        Object obj1 = null;
        super();
        mVersionCode = 12;
        Object obj;
        if (flag)
        {
            obj = player.getPlayerId();
        } else
        {
            obj = null;
        }
        zzWn = ((String) (obj));
        zzahh = player.getDisplayName();
        zzaqW = player.getIconImageUri();
        zzarh = player.getIconImageUrl();
        zzaqX = player.getHiResImageUri();
        zzari = player.getHiResImageUrl();
        zzarC = player.getRetrievedTimestamp();
        zzarD = player.zzsS();
        zzarE = player.getLastPlayedWithTimestamp();
        zzagU = player.getTitle();
        zzarH = player.isProfileVisible();
        obj = player.zzsT();
        if (obj == null)
        {
            obj = obj1;
        } else
        {
            obj = new MostRecentGameInfoEntity(((MostRecentGameInfo) (obj)));
        }
        zzarF = ((MostRecentGameInfoEntity) (obj));
        zzarG = player.getLevelInfo();
        zzarI = player.zzsR();
        if (flag)
        {
            com.google.android.gms.common.internal.zzb.zzr(zzWn);
        }
        com.google.android.gms.common.internal.zzb.zzr(zzahh);
        if (zzarC > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzY(flag);
    }

    static boolean zza(Player player, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Player) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (player == obj) goto _L4; else goto _L3
_L3:
        obj = (Player)obj;
        if (!zzw.equal(((Player) (obj)).getPlayerId(), player.getPlayerId()) || !zzw.equal(((Player) (obj)).getDisplayName(), player.getDisplayName()) || !zzw.equal(Boolean.valueOf(((Player) (obj)).zzsR()), Boolean.valueOf(player.zzsR())) || !zzw.equal(((Player) (obj)).getIconImageUri(), player.getIconImageUri()) || !zzw.equal(((Player) (obj)).getHiResImageUri(), player.getHiResImageUri()) || !zzw.equal(Long.valueOf(((Player) (obj)).getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) || !zzw.equal(((Player) (obj)).getTitle(), player.getTitle()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((Player) (obj)).getLevelInfo(), player.getLevelInfo())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static int zzb(Player player)
    {
        return zzw.hashCode(new Object[] {
            player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzsR()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo()
        });
    }

    static String zzc(Player player)
    {
        return zzw.zzu(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzsR())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).toString();
    }

    static boolean zzc(Integer integer)
    {
        return zzd(integer);
    }

    static boolean zzcW(String s)
    {
        return zzcj(s);
    }

    static Integer zzsP()
    {
        return zzor();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Player freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String getDisplayName()
    {
        return zzahh;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzahh, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return zzaqX;
    }

    public String getHiResImageUrl()
    {
        return zzari;
    }

    public Uri getIconImageUri()
    {
        return zzaqW;
    }

    public String getIconImageUrl()
    {
        return zzarh;
    }

    public long getLastPlayedWithTimestamp()
    {
        return zzarE;
    }

    public PlayerLevelInfo getLevelInfo()
    {
        return zzarG;
    }

    public String getPlayerId()
    {
        return zzWn;
    }

    public long getRetrievedTimestamp()
    {
        return zzarC;
    }

    public String getTitle()
    {
        return zzagU;
    }

    public void getTitle(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzagU, chararraybuffer);
    }

    public int getVersionCode()
    {
        return mVersionCode;
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
        return zzb(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isProfileVisible()
    {
        return zzarH;
    }

    public String toString()
    {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Object obj = null;
        if (!zzos())
        {
            PlayerEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(zzWn);
        parcel.writeString(zzahh);
        String s;
        if (zzaqW == null)
        {
            s = null;
        } else
        {
            s = zzaqW.toString();
        }
        parcel.writeString(s);
        if (zzaqX == null)
        {
            s = obj;
        } else
        {
            s = zzaqX.toString();
        }
        parcel.writeString(s);
        parcel.writeLong(zzarC);
    }

    public boolean zzsR()
    {
        return zzarI;
    }

    public int zzsS()
    {
        return zzarD;
    }

    public MostRecentGameInfo zzsT()
    {
        return zzarF;
    }

}
