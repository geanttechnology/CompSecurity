// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            Room, RoomEntityCreator

public final class RoomEntity extends GamesDowngradeableSafeParcel
    implements Room
{
    static final class RoomEntityCreatorCompat extends RoomEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzei(parcel);
        }

        public RoomEntity zzei(Parcel parcel)
        {
            if (RoomEntity.zzc(RoomEntity.zztC()) || RoomEntity.zzcV(com/google/android/gms/games/multiplayer/realtime/RoomEntity.getCanonicalName()))
            {
                return super.zzei(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            long l1 = parcel.readLong();
            int j = parcel.readInt();
            String s2 = parcel.readString();
            int k = parcel.readInt();
            Bundle bundle = parcel.readBundle();
            int l = parcel.readInt();
            ArrayList arraylist = new ArrayList(l);
            for (int i = 0; i < l; i++)
            {
                arraylist.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }

            return new RoomEntity(2, s, s1, l1, j, s2, k, bundle, arraylist, -1);
        }

        RoomEntityCreatorCompat()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new RoomEntityCreatorCompat();
    private final int mVersionCode;
    private final ArrayList zzaAC;
    private final int zzaAD;
    private final Bundle zzaAT;
    private final String zzaAV;
    private final int zzaAW;
    private final int zzaAX;
    private final long zzaAz;
    private final String zzaqZ;
    private final String zzavE;

    RoomEntity(int i, String s, String s1, long l, int j, String s2, 
            int k, Bundle bundle, ArrayList arraylist, int i1)
    {
        mVersionCode = i;
        zzavE = s;
        zzaAV = s1;
        zzaAz = l;
        zzaAW = j;
        zzaqZ = s2;
        zzaAD = k;
        zzaAT = bundle;
        zzaAC = arraylist;
        zzaAX = i1;
    }

    public RoomEntity(Room room)
    {
        mVersionCode = 2;
        zzavE = room.getRoomId();
        zzaAV = room.getCreatorId();
        zzaAz = room.getCreationTimestamp();
        zzaAW = room.getStatus();
        zzaqZ = room.getDescription();
        zzaAD = room.getVariant();
        zzaAT = room.getAutoMatchCriteria();
        ArrayList arraylist = room.getParticipants();
        int j = arraylist.size();
        zzaAC = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzaAC.add((ParticipantEntity)((Participant)arraylist.get(i)).freeze());
        }

        zzaAX = room.getAutoMatchWaitEstimateSeconds();
    }

    static int zza(Room room)
    {
        return zzw.hashCode(new Object[] {
            room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())
        });
    }

    static int zza(Room room, String s)
    {
        ArrayList arraylist = room.getParticipants();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                return participant.getStatus();
            }
        }

        throw new IllegalStateException((new StringBuilder()).append("Participant ").append(s).append(" is not in room ").append(room.getRoomId()).toString());
    }

    static boolean zza(Room room, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Room) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (room == obj) goto _L4; else goto _L3
_L3:
        obj = (Room)obj;
        if (!zzw.equal(((Room) (obj)).getRoomId(), room.getRoomId()) || !zzw.equal(((Room) (obj)).getCreatorId(), room.getCreatorId()) || !zzw.equal(Long.valueOf(((Room) (obj)).getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) || !zzw.equal(Integer.valueOf(((Room) (obj)).getStatus()), Integer.valueOf(room.getStatus())) || !zzw.equal(((Room) (obj)).getDescription(), room.getDescription()) || !zzw.equal(Integer.valueOf(((Room) (obj)).getVariant()), Integer.valueOf(room.getVariant())) || !zzw.equal(((Room) (obj)).getAutoMatchCriteria(), room.getAutoMatchCriteria()) || !zzw.equal(((Room) (obj)).getParticipants(), room.getParticipants()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Integer.valueOf(((Room) (obj)).getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Room room)
    {
        return zzw.zzv(room).zzg("RoomId", room.getRoomId()).zzg("CreatorId", room.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(room.getStatus())).zzg("Description", room.getDescription()).zzg("Variant", Integer.valueOf(room.getVariant())).zzg("AutoMatchCriteria", room.getAutoMatchCriteria()).zzg("Participants", room.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String zzb(Room room, String s)
    {
        room = room.getParticipants();
        int j = room.size();
        for (int i = 0; i < j; i++)
        {
            Participant participant = (Participant)room.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(s))
            {
                return participant.getParticipantId();
            }
        }

        return null;
    }

    static Participant zzc(Room room, String s)
    {
        ArrayList arraylist = room.getParticipants();
        int j = arraylist.size();
        for (int i = 0; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                return participant;
            }
        }

        throw new IllegalStateException((new StringBuilder()).append("Participant ").append(s).append(" is not in match ").append(room.getRoomId()).toString());
    }

    static ArrayList zzc(Room room)
    {
        room = room.getParticipants();
        int j = room.size();
        ArrayList arraylist = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            arraylist.add(((Participant)room.get(i)).getParticipantId());
        }

        return arraylist;
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

    public Room freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public Bundle getAutoMatchCriteria()
    {
        return zzaAT;
    }

    public int getAutoMatchWaitEstimateSeconds()
    {
        return zzaAX;
    }

    public long getCreationTimestamp()
    {
        return zzaAz;
    }

    public String getCreatorId()
    {
        return zzaAV;
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaqZ, chararraybuffer);
    }

    public Participant getParticipant(String s)
    {
        return zzc(this, s);
    }

    public String getParticipantId(String s)
    {
        return zzb(this, s);
    }

    public ArrayList getParticipantIds()
    {
        return zzc(this);
    }

    public int getParticipantStatus(String s)
    {
        return zza(this, s);
    }

    public ArrayList getParticipants()
    {
        return new ArrayList(zzaAC);
    }

    public String getRoomId()
    {
        return zzavE;
    }

    public int getStatus()
    {
        return zzaAW;
    }

    public int getVariant()
    {
        return zzaAD;
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
            RoomEntityCreator.zza(this, parcel, i);
        } else
        {
            parcel.writeString(zzavE);
            parcel.writeString(zzaAV);
            parcel.writeLong(zzaAz);
            parcel.writeInt(zzaAW);
            parcel.writeString(zzaqZ);
            parcel.writeInt(zzaAD);
            parcel.writeBundle(zzaAT);
            int k = zzaAC.size();
            parcel.writeInt(k);
            int j = 0;
            while (j < k) 
            {
                ((ParticipantEntity)zzaAC.get(j)).writeToParcel(parcel, i);
                j++;
            }
        }
    }

}
