// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzln;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Participant, ParticipantEntityCreator, ParticipantResult

public final class ParticipantEntity extends GamesDowngradeableSafeParcel
    implements Participant
{
    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdU(parcel);
        }

        public ParticipantEntity zzdU(Parcel parcel)
        {
            boolean flag = true;
            if (ParticipantEntity.zzc(ParticipantEntity.zzsP()) || ParticipantEntity.zzcW(com/google/android/gms/games/multiplayer/ParticipantEntity.getCanonicalName()))
            {
                return super.zzdU(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            Object obj = parcel.readString();
            Object obj1;
            String s2;
            int i;
            boolean flag1;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = Uri.parse(((String) (obj)));
            }
            obj1 = parcel.readString();
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = Uri.parse(((String) (obj1)));
            }
            i = parcel.readInt();
            s2 = parcel.readString();
            if (parcel.readInt() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (parcel.readInt() <= 0)
            {
                flag = false;
            }
            if (flag)
            {
                parcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            return new ParticipantEntity(3, s, s1, ((Uri) (obj)), ((Uri) (obj1)), i, s2, flag1, parcel, 7, null, null, null);
        }

        ParticipantEntityCreatorCompat()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new ParticipantEntityCreatorCompat();
    private final int mVersionCode;
    private final int zzTv;
    private final String zzahh;
    private final Uri zzaqW;
    private final Uri zzaqX;
    private final PlayerEntity zzarZ;
    private final String zzarh;
    private final String zzari;
    private final String zzasH;
    private final String zzatI;
    private final boolean zzayg;
    private final ParticipantResult zzayh;
    private final int zzxJ;

    ParticipantEntity(int i, String s, String s1, Uri uri, Uri uri1, int j, String s2, 
            boolean flag, PlayerEntity playerentity, int k, ParticipantResult participantresult, String s3, String s4)
    {
        mVersionCode = i;
        zzatI = s;
        zzahh = s1;
        zzaqW = uri;
        zzaqX = uri1;
        zzxJ = j;
        zzasH = s2;
        zzayg = flag;
        zzarZ = playerentity;
        zzTv = k;
        zzayh = participantresult;
        zzarh = s3;
        zzari = s4;
    }

    public ParticipantEntity(Participant participant)
    {
        mVersionCode = 3;
        zzatI = participant.getParticipantId();
        zzahh = participant.getDisplayName();
        zzaqW = participant.getIconImageUri();
        zzaqX = participant.getHiResImageUri();
        zzxJ = participant.getStatus();
        zzasH = participant.zztD();
        zzayg = participant.isConnectedToRoom();
        Object obj = participant.getPlayer();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new PlayerEntity(((Player) (obj)));
        }
        zzarZ = ((PlayerEntity) (obj));
        zzTv = participant.getCapabilities();
        zzayh = participant.getResult();
        zzarh = participant.getIconImageUrl();
        zzari = participant.getHiResImageUrl();
    }

    static int zza(Participant participant)
    {
        return zzw.hashCode(new Object[] {
            participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zztD(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId()
        });
    }

    static boolean zza(Participant participant, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Participant) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (participant == obj) goto _L4; else goto _L3
_L3:
        obj = (Participant)obj;
        if (!zzw.equal(((Participant) (obj)).getPlayer(), participant.getPlayer()) || !zzw.equal(Integer.valueOf(((Participant) (obj)).getStatus()), Integer.valueOf(participant.getStatus())) || !zzw.equal(((Participant) (obj)).zztD(), participant.zztD()) || !zzw.equal(Boolean.valueOf(((Participant) (obj)).isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) || !zzw.equal(((Participant) (obj)).getDisplayName(), participant.getDisplayName()) || !zzw.equal(((Participant) (obj)).getIconImageUri(), participant.getIconImageUri()) || !zzw.equal(((Participant) (obj)).getHiResImageUri(), participant.getHiResImageUri()) || !zzw.equal(Integer.valueOf(((Participant) (obj)).getCapabilities()), Integer.valueOf(participant.getCapabilities())) || !zzw.equal(((Participant) (obj)).getResult(), participant.getResult()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((Participant) (obj)).getParticipantId(), participant.getParticipantId())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Participant participant)
    {
        return zzw.zzu(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zztD()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
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

    public Participant freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public int getCapabilities()
    {
        return zzTv;
    }

    public String getDisplayName()
    {
        if (zzarZ == null)
        {
            return zzahh;
        } else
        {
            return zzarZ.getDisplayName();
        }
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (zzarZ == null)
        {
            zzln.zzb(zzahh, chararraybuffer);
            return;
        } else
        {
            zzarZ.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getHiResImageUri()
    {
        if (zzarZ == null)
        {
            return zzaqX;
        } else
        {
            return zzarZ.getHiResImageUri();
        }
    }

    public String getHiResImageUrl()
    {
        if (zzarZ == null)
        {
            return zzari;
        } else
        {
            return zzarZ.getHiResImageUrl();
        }
    }

    public Uri getIconImageUri()
    {
        if (zzarZ == null)
        {
            return zzaqW;
        } else
        {
            return zzarZ.getIconImageUri();
        }
    }

    public String getIconImageUrl()
    {
        if (zzarZ == null)
        {
            return zzarh;
        } else
        {
            return zzarZ.getIconImageUrl();
        }
    }

    public String getParticipantId()
    {
        return zzatI;
    }

    public Player getPlayer()
    {
        return zzarZ;
    }

    public ParticipantResult getResult()
    {
        return zzayh;
    }

    public int getStatus()
    {
        return zzxJ;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isConnectedToRoom()
    {
        return zzayg;
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
        Object obj = null;
        boolean flag = false;
        if (!zzos())
        {
            ParticipantEntityCreator.zza(this, parcel, i);
        } else
        {
            parcel.writeString(zzatI);
            parcel.writeString(zzahh);
            String s;
            int j;
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
            parcel.writeInt(zzxJ);
            parcel.writeString(zzasH);
            if (zzayg)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
            if (zzarZ == null)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 1;
            }
            parcel.writeInt(j);
            if (zzarZ != null)
            {
                zzarZ.writeToParcel(parcel, i);
                return;
            }
        }
    }

    public String zztD()
    {
        return zzasH;
    }

}
