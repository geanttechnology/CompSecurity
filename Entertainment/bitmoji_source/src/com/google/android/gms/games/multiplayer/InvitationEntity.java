// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.fy;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Invitation, Participant, ParticipantEntity, a

public final class InvitationEntity extends fy
    implements Invitation
{
    static final class a extends com.google.android.gms.games.multiplayer.a
    {

        public InvitationEntity an(Parcel parcel)
        {
            if (InvitationEntity.b(InvitationEntity.fk()) || InvitationEntity.at(com/google/android/gms/games/multiplayer/InvitationEntity.getCanonicalName()))
            {
                return super.an(parcel);
            }
            GameEntity gameentity = (GameEntity)GameEntity.CREATOR.createFromParcel(parcel);
            String s = parcel.readString();
            long l = parcel.readLong();
            int j = parcel.readInt();
            ParticipantEntity participantentity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(parcel);
            int k = parcel.readInt();
            ArrayList arraylist = new ArrayList(k);
            for (int i = 0; i < k; i++)
            {
                arraylist.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }

            return new InvitationEntity(2, gameentity, s, l, j, participantentity, arraylist, -1, 0);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return an(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final String GP;
    private final GameEntity Jq;
    private final long Jr;
    private final int Js;
    private final ParticipantEntity Jt;
    private final ArrayList Ju;
    private final int Jv;
    private final int Jw;
    private final int wj;

    InvitationEntity(int i, GameEntity gameentity, String s, long l, int j, ParticipantEntity participantentity, 
            ArrayList arraylist, int k, int i1)
    {
        wj = i;
        Jq = gameentity;
        GP = s;
        Jr = l;
        Js = j;
        Jt = participantentity;
        Ju = arraylist;
        Jv = k;
        Jw = i1;
    }

    InvitationEntity(Invitation invitation)
    {
        wj = 2;
        Jq = new GameEntity(invitation.getGame());
        GP = invitation.getInvitationId();
        Jr = invitation.getCreationTimestamp();
        Js = invitation.getInvitationType();
        Jv = invitation.getVariant();
        Jw = invitation.getAvailableAutoMatchSlots();
        String s = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList arraylist = invitation.getParticipants();
        int j = arraylist.size();
        Ju = new ArrayList(j);
        int i = 0;
        invitation = obj;
        for (; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                invitation = participant;
            }
            Ju.add((ParticipantEntity)participant.freeze());
        }

        er.b(invitation, "Must have a valid inviter!");
        Jt = (ParticipantEntity)invitation.freeze();
    }

    static int a(Invitation invitation)
    {
        return ep.hashCode(new Object[] {
            invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots())
        });
    }

    static boolean a(Invitation invitation, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Invitation) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (invitation == obj) goto _L4; else goto _L3
_L3:
        obj = (Invitation)obj;
        if (!ep.equal(((Invitation) (obj)).getGame(), invitation.getGame()) || !ep.equal(((Invitation) (obj)).getInvitationId(), invitation.getInvitationId()) || !ep.equal(Long.valueOf(((Invitation) (obj)).getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) || !ep.equal(Integer.valueOf(((Invitation) (obj)).getInvitationType()), Integer.valueOf(invitation.getInvitationType())) || !ep.equal(((Invitation) (obj)).getInviter(), invitation.getInviter()) || !ep.equal(((Invitation) (obj)).getParticipants(), invitation.getParticipants()) || !ep.equal(Integer.valueOf(((Invitation) (obj)).getVariant()), Integer.valueOf(invitation.getVariant())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(Integer.valueOf(((Invitation) (obj)).getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean at(String s)
    {
        return ae(s);
    }

    static String b(Invitation invitation)
    {
        return ep.e(invitation).a("Game", invitation.getGame()).a("InvitationId", invitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(invitation.getInvitationType())).a("Inviter", invitation.getInviter()).a("Participants", invitation.getParticipants()).a("Variant", Integer.valueOf(invitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
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

    public Invitation freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public int getAvailableAutoMatchSlots()
    {
        return Jw;
    }

    public long getCreationTimestamp()
    {
        return Jr;
    }

    public Game getGame()
    {
        return Jq;
    }

    public String getInvitationId()
    {
        return GP;
    }

    public int getInvitationType()
    {
        return Js;
    }

    public Participant getInviter()
    {
        return Jt;
    }

    public ArrayList getParticipants()
    {
        return new ArrayList(Ju);
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
            com.google.android.gms.games.multiplayer.a.a(this, parcel, i);
        } else
        {
            Jq.writeToParcel(parcel, i);
            parcel.writeString(GP);
            parcel.writeLong(Jr);
            parcel.writeInt(Js);
            Jt.writeToParcel(parcel, i);
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
