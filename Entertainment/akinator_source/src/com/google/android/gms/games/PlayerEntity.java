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
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games:
//            Player, PlayerEntityCreator, PlayerLevelInfo

public final class PlayerEntity extends GamesDowngradeableSafeParcel
    implements Player
{
    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdO(parcel);
        }

        public PlayerEntity zzdO(Parcel parcel)
        {
            if (PlayerEntity.zzc(PlayerEntity.zztC()) || PlayerEntity.zzcV(com/google/android/gms/games/PlayerEntity.getCanonicalName()))
            {
                return super.zzdO(parcel);
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
            return new PlayerEntity(12, s, s1, ((Uri) (obj)), ((Uri) (obj1)), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString());
        }

        PlayerEntityCreatorCompat()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new PlayerEntityCreatorCompat();
    private final String mName;
    private final int mVersionCode;
    private final String zzTa;
    private final String zzYf;
    private final String zzajf;
    private final String zzatF;
    private final String zzatG;
    private final long zzatZ;
    private final Uri zzatu;
    private final Uri zzatv;
    private final int zzaua;
    private final long zzaub;
    private final MostRecentGameInfoEntity zzauc;
    private final PlayerLevelInfo zzaud;
    private final boolean zzaue;
    private final boolean zzauf;
    private final String zzaug;

    PlayerEntity(int i, String s, String s1, Uri uri, Uri uri1, long l, 
            int j, long l1, String s2, String s3, String s4, MostRecentGameInfoEntity mostrecentgameinfoentity, 
            PlayerLevelInfo playerlevelinfo, boolean flag, boolean flag1, String s5, String s6)
    {
        mVersionCode = i;
        zzYf = s;
        zzTa = s1;
        zzatu = uri;
        zzatF = s2;
        zzatv = uri1;
        zzatG = s3;
        zzatZ = l;
        zzaua = j;
        zzaub = l1;
        zzajf = s4;
        zzaue = flag;
        zzauc = mostrecentgameinfoentity;
        zzaud = playerlevelinfo;
        zzauf = flag1;
        zzaug = s5;
        mName = s6;
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
        zzYf = ((String) (obj));
        zzTa = player.getDisplayName();
        zzatu = player.getIconImageUri();
        zzatF = player.getIconImageUrl();
        zzatv = player.getHiResImageUri();
        zzatG = player.getHiResImageUrl();
        zzatZ = player.getRetrievedTimestamp();
        zzaua = player.zztG();
        zzaub = player.getLastPlayedWithTimestamp();
        zzajf = player.getTitle();
        zzaue = player.zztH();
        obj = player.zztI();
        if (obj == null)
        {
            obj = obj1;
        } else
        {
            obj = new MostRecentGameInfoEntity(((MostRecentGameInfo) (obj)));
        }
        zzauc = ((MostRecentGameInfoEntity) (obj));
        zzaud = player.getLevelInfo();
        zzauf = player.zztF();
        zzaug = player.zztE();
        mName = player.getName();
        if (flag)
        {
            com.google.android.gms.common.internal.zzb.zzs(zzYf);
        }
        com.google.android.gms.common.internal.zzb.zzs(zzTa);
        if (zzatZ > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
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
        if (!zzw.equal(((Player) (obj)).getPlayerId(), player.getPlayerId()) || !zzw.equal(((Player) (obj)).getDisplayName(), player.getDisplayName()) || !zzw.equal(Boolean.valueOf(((Player) (obj)).zztF()), Boolean.valueOf(player.zztF())) || !zzw.equal(((Player) (obj)).getIconImageUri(), player.getIconImageUri()) || !zzw.equal(((Player) (obj)).getHiResImageUri(), player.getHiResImageUri()) || !zzw.equal(Long.valueOf(((Player) (obj)).getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) || !zzw.equal(((Player) (obj)).getTitle(), player.getTitle()) || !zzw.equal(((Player) (obj)).getLevelInfo(), player.getLevelInfo()) || !zzw.equal(((Player) (obj)).zztE(), player.zztE()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((Player) (obj)).getName(), player.getName())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static int zzb(Player player)
    {
        return zzw.hashCode(new Object[] {
            player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zztF()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zztE(), player.getName()
        });
    }

    static String zzc(Player player)
    {
        return zzw.zzv(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zztF())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zztE()).zzg("Name", player.getName()).toString();
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
        return zzTa;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzTa, chararraybuffer);
    }

    public Uri getHiResImageUri()
    {
        return zzatv;
    }

    public String getHiResImageUrl()
    {
        return zzatG;
    }

    public Uri getIconImageUri()
    {
        return zzatu;
    }

    public String getIconImageUrl()
    {
        return zzatF;
    }

    public long getLastPlayedWithTimestamp()
    {
        return zzaub;
    }

    public PlayerLevelInfo getLevelInfo()
    {
        return zzaud;
    }

    public String getName()
    {
        return mName;
    }

    public String getPlayerId()
    {
        return zzYf;
    }

    public long getRetrievedTimestamp()
    {
        return zzatZ;
    }

    public String getTitle()
    {
        return zzajf;
    }

    public void getTitle(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzajf, chararraybuffer);
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

    public String toString()
    {
        return zzc(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        Object obj = null;
        if (!zzoU())
        {
            PlayerEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(zzYf);
        parcel.writeString(zzTa);
        String s;
        if (zzatu == null)
        {
            s = null;
        } else
        {
            s = zzatu.toString();
        }
        parcel.writeString(s);
        if (zzatv == null)
        {
            s = obj;
        } else
        {
            s = zzatv.toString();
        }
        parcel.writeString(s);
        parcel.writeLong(zzatZ);
    }

    public String zztE()
    {
        return zzaug;
    }

    public boolean zztF()
    {
        return zzauf;
    }

    public int zztG()
    {
        return zzaua;
    }

    public boolean zztH()
    {
        return zzaue;
    }

    public MostRecentGameInfo zztI()
    {
        return zzauc;
    }

}
