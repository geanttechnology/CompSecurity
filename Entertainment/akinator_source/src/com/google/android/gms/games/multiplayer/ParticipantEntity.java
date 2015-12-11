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
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Participant, ParticipantEntityCreator, ParticipantResult

public final class ParticipantEntity extends GamesDowngradeableSafeParcel
    implements Participant
{
    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzef(parcel);
        }

        public ParticipantEntity zzef(Parcel parcel)
        {
            boolean flag = true;
            if (ParticipantEntity.zzc(ParticipantEntity.zztC()) || ParticipantEntity.zzcV(com/google/android/gms/games/multiplayer/ParticipantEntity.getCanonicalName()))
            {
                return super.zzef(parcel);
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
    private final String zzTa;
    private final int zzVl;
    private final boolean zzaAG;
    private final ParticipantResult zzaAH;
    private final String zzatF;
    private final String zzatG;
    private final Uri zzatu;
    private final Uri zzatv;
    private final PlayerEntity zzaux;
    private final String zzavf;
    private final String zzawg;
    private final int zzys;

    ParticipantEntity(int i, String s, String s1, Uri uri, Uri uri1, int j, String s2, 
            boolean flag, PlayerEntity playerentity, int k, ParticipantResult participantresult, String s3, String s4)
    {
        mVersionCode = i;
        zzawg = s;
        zzTa = s1;
        zzatu = uri;
        zzatv = uri1;
        zzys = j;
        zzavf = s2;
        zzaAG = flag;
        zzaux = playerentity;
        zzVl = k;
        zzaAH = participantresult;
        zzatF = s3;
        zzatG = s4;
    }

    public ParticipantEntity(Participant participant)
    {
        mVersionCode = 3;
        zzawg = participant.getParticipantId();
        zzTa = participant.getDisplayName();
        zzatu = participant.getIconImageUri();
        zzatv = participant.getHiResImageUri();
        zzys = participant.getStatus();
        zzavf = participant.zzut();
        zzaAG = participant.isConnectedToRoom();
        Object obj = participant.getPlayer();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new PlayerEntity(((Player) (obj)));
        }
        zzaux = ((PlayerEntity) (obj));
        zzVl = participant.getCapabilities();
        zzaAH = participant.getResult();
        zzatF = participant.getIconImageUrl();
        zzatG = participant.getHiResImageUrl();
    }

    static int zza(Participant participant)
    {
        return zzw.hashCode(new Object[] {
            participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzut(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId()
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
        if (!zzw.equal(((Participant) (obj)).getPlayer(), participant.getPlayer()) || !zzw.equal(Integer.valueOf(((Participant) (obj)).getStatus()), Integer.valueOf(participant.getStatus())) || !zzw.equal(((Participant) (obj)).zzut(), participant.zzut()) || !zzw.equal(Boolean.valueOf(((Participant) (obj)).isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) || !zzw.equal(((Participant) (obj)).getDisplayName(), participant.getDisplayName()) || !zzw.equal(((Participant) (obj)).getIconImageUri(), participant.getIconImageUri()) || !zzw.equal(((Participant) (obj)).getHiResImageUri(), participant.getHiResImageUri()) || !zzw.equal(Integer.valueOf(((Participant) (obj)).getCapabilities()), Integer.valueOf(participant.getCapabilities())) || !zzw.equal(((Participant) (obj)).getResult(), participant.getResult()))
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
        return zzw.zzv(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzut()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
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
        return zzVl;
    }

    public String getDisplayName()
    {
        if (zzaux == null)
        {
            return zzTa;
        } else
        {
            return zzaux.getDisplayName();
        }
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (zzaux == null)
        {
            zzmo.zzb(zzTa, chararraybuffer);
            return;
        } else
        {
            zzaux.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getHiResImageUri()
    {
        if (zzaux == null)
        {
            return zzatv;
        } else
        {
            return zzaux.getHiResImageUri();
        }
    }

    public String getHiResImageUrl()
    {
        if (zzaux == null)
        {
            return zzatG;
        } else
        {
            return zzaux.getHiResImageUrl();
        }
    }

    public Uri getIconImageUri()
    {
        if (zzaux == null)
        {
            return zzatu;
        } else
        {
            return zzaux.getIconImageUri();
        }
    }

    public String getIconImageUrl()
    {
        if (zzaux == null)
        {
            return zzatF;
        } else
        {
            return zzaux.getIconImageUrl();
        }
    }

    public String getParticipantId()
    {
        return zzawg;
    }

    public Player getPlayer()
    {
        return zzaux;
    }

    public ParticipantResult getResult()
    {
        return zzaAH;
    }

    public int getStatus()
    {
        return zzys;
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
        return zzaAG;
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
        if (!zzoU())
        {
            ParticipantEntityCreator.zza(this, parcel, i);
        } else
        {
            parcel.writeString(zzawg);
            parcel.writeString(zzTa);
            String s;
            int j;
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
            parcel.writeInt(zzys);
            parcel.writeString(zzavf);
            if (zzaAG)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            parcel.writeInt(j);
            if (zzaux == null)
            {
                j = ((flag) ? 1 : 0);
            } else
            {
                j = 1;
            }
            parcel.writeInt(j);
            if (zzaux != null)
            {
                zzaux.writeToParcel(parcel, i);
                return;
            }
        }
    }

    public String zzut()
    {
        return zzavf;
    }

}
