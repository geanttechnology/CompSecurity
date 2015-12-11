// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer.realtime:
//            Room, b

public final class RoomEntity extends fy
    implements Room
{
    static final class a extends b
    {

        public RoomEntity aq(Parcel parcel)
        {
            if (RoomEntity.b(RoomEntity.fk()) || RoomEntity.at(com/google/android/gms/games/multiplayer/realtime/RoomEntity.getCanonicalName()))
            {
                return super.aq(parcel);
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

        public Object createFromParcel(Parcel parcel)
        {
            return aq(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final String FH;
    private final String GU;
    private final Bundle JO;
    private final String JS;
    private final int JT;
    private final int JU;
    private final long Jr;
    private final ArrayList Ju;
    private final int Jv;
    private final int wj;

    RoomEntity(int i, String s, String s1, long l, int j, String s2, 
            int k, Bundle bundle, ArrayList arraylist, int i1)
    {
        wj = i;
        GU = s;
        JS = s1;
        Jr = l;
        JT = j;
        FH = s2;
        Jv = k;
        JO = bundle;
        Ju = arraylist;
        JU = i1;
    }

    public RoomEntity(Room room)
    {
        wj = 2;
        GU = room.getRoomId();
        JS = room.getCreatorId();
        Jr = room.getCreationTimestamp();
        JT = room.getStatus();
        FH = room.getDescription();
        Jv = room.getVariant();
        JO = room.getAutoMatchCriteria();
        ArrayList arraylist = room.getParticipants();
        int j = arraylist.size();
        Ju = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            Ju.add((ParticipantEntity)((Participant)arraylist.get(i)).freeze());
        }

        JU = room.getAutoMatchWaitEstimateSeconds();
    }

    static int a(Room room)
    {
        return ep.hashCode(new Object[] {
            room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())
        });
    }

    static int a(Room room, String s)
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

    static boolean a(Room room, Object obj)
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
        if (!ep.equal(((Room) (obj)).getRoomId(), room.getRoomId()) || !ep.equal(((Room) (obj)).getCreatorId(), room.getCreatorId()) || !ep.equal(Long.valueOf(((Room) (obj)).getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) || !ep.equal(Integer.valueOf(((Room) (obj)).getStatus()), Integer.valueOf(room.getStatus())) || !ep.equal(((Room) (obj)).getDescription(), room.getDescription()) || !ep.equal(Integer.valueOf(((Room) (obj)).getVariant()), Integer.valueOf(room.getVariant())) || !ep.equal(((Room) (obj)).getAutoMatchCriteria(), room.getAutoMatchCriteria()) || !ep.equal(((Room) (obj)).getParticipants(), room.getParticipants()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(Integer.valueOf(((Room) (obj)).getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean at(String s)
    {
        return ae(s);
    }

    static String b(Room room)
    {
        return ep.e(room).a("RoomId", room.getRoomId()).a("CreatorId", room.getCreatorId()).a("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).a("RoomStatus", Integer.valueOf(room.getStatus())).a("Description", room.getDescription()).a("Variant", Integer.valueOf(room.getVariant())).a("AutoMatchCriteria", room.getAutoMatchCriteria()).a("Participants", room.getParticipants()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String b(Room room, String s)
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

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Participant c(Room room, String s)
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

    static ArrayList c(Room room)
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

    static Integer fk()
    {
        return dY();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
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
        return JO;
    }

    public int getAutoMatchWaitEstimateSeconds()
    {
        return JU;
    }

    public long getCreationTimestamp()
    {
        return Jr;
    }

    public String getCreatorId()
    {
        return JS;
    }

    public String getDescription()
    {
        return FH;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        fm.b(FH, chararraybuffer);
    }

    public Participant getParticipant(String s)
    {
        return c(this, s);
    }

    public String getParticipantId(String s)
    {
        return b(this, s);
    }

    public ArrayList getParticipantIds()
    {
        return c(this);
    }

    public int getParticipantStatus(String s)
    {
        return a(this, s);
    }

    public ArrayList getParticipants()
    {
        return new ArrayList(Ju);
    }

    public String getRoomId()
    {
        return GU;
    }

    public int getStatus()
    {
        return JT;
    }

    public int getVariant()
    {
        return Jv;
    }

    public int getVersionCode()
    {
        return wj;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return b(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (!dZ())
        {
            com.google.android.gms.games.multiplayer.realtime.b.a(this, parcel, i);
        } else
        {
            parcel.writeString(GU);
            parcel.writeString(JS);
            parcel.writeLong(Jr);
            parcel.writeInt(JT);
            parcel.writeString(FH);
            parcel.writeInt(Jv);
            parcel.writeBundle(JO);
            int k = Ju.size();
            parcel.writeInt(k);
            int j = 0;
            while (j < k) 
            {
                ((ParticipantEntity)Ju.get(j)).writeToParcel(parcel, i);
                j++;
            }
        }
    }

}
