// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fm;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Invitation, Participant, ParticipantEntity, a

public final class InvitationEntity extends fm
    implements Invitation
{
    static final class a extends com.google.android.gms.games.multiplayer.a
    {

        public InvitationEntity aa(Parcel parcel)
        {
            if (InvitationEntity.b(InvitationEntity.da()) || InvitationEntity.ad(com/google/android/gms/games/multiplayer/InvitationEntity.getCanonicalName()))
            {
                return super.aa(parcel);
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
            return aa(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final int kg;
    private final String uf;
    private final GameEntity wj;
    private final long wk;
    private final int wl;
    private final ParticipantEntity wm;
    private final ArrayList wn;
    private final int wo;
    private final int wp;

    InvitationEntity(int i, GameEntity gameentity, String s, long l, int j, ParticipantEntity participantentity, 
            ArrayList arraylist, int k, int i1)
    {
        kg = i;
        wj = gameentity;
        uf = s;
        wk = l;
        wl = j;
        wm = participantentity;
        wn = arraylist;
        wo = k;
        wp = i1;
    }

    InvitationEntity(Invitation invitation)
    {
        kg = 2;
        wj = new GameEntity(invitation.getGame());
        uf = invitation.getInvitationId();
        wk = invitation.getCreationTimestamp();
        wl = invitation.getInvitationType();
        wo = invitation.getVariant();
        wp = invitation.getAvailableAutoMatchSlots();
        String s = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList arraylist = invitation.getParticipants();
        int j = arraylist.size();
        wn = new ArrayList(j);
        int i = 0;
        invitation = obj;
        for (; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                invitation = participant;
            }
            wn.add((ParticipantEntity)participant.freeze());
        }

        eg.b(invitation, "Must have a valid inviter!");
        wm = (ParticipantEntity)invitation.freeze();
    }

    static int a(Invitation invitation)
    {
        return ee.hashCode(new Object[] {
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
        if (!ee.equal(((Invitation) (obj)).getGame(), invitation.getGame()) || !ee.equal(((Invitation) (obj)).getInvitationId(), invitation.getInvitationId()) || !ee.equal(Long.valueOf(((Invitation) (obj)).getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) || !ee.equal(Integer.valueOf(((Invitation) (obj)).getInvitationType()), Integer.valueOf(invitation.getInvitationType())) || !ee.equal(((Invitation) (obj)).getInviter(), invitation.getInviter()) || !ee.equal(((Invitation) (obj)).getParticipants(), invitation.getParticipants()) || !ee.equal(Integer.valueOf(((Invitation) (obj)).getVariant()), Integer.valueOf(invitation.getVariant())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(Integer.valueOf(((Invitation) (obj)).getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean ad(String s)
    {
        return P(s);
    }

    static String b(Invitation invitation)
    {
        return ee.e(invitation).a("Game", invitation.getGame()).a("InvitationId", invitation.getInvitationId()).a("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).a("InvitationType", Integer.valueOf(invitation.getInvitationType())).a("Inviter", invitation.getInviter()).a("Participants", invitation.getParticipants()).a("Variant", Integer.valueOf(invitation.getVariant())).a("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer da()
    {
        return bM();
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
        return wp;
    }

    public long getCreationTimestamp()
    {
        return wk;
    }

    public Game getGame()
    {
        return wj;
    }

    public String getInvitationId()
    {
        return uf;
    }

    public int getInvitationType()
    {
        return wl;
    }

    public Participant getInviter()
    {
        return wm;
    }

    public ArrayList getParticipants()
    {
        return new ArrayList(wn);
    }

    public int getVariant()
    {
        return wo;
    }

    public int getVersionCode()
    {
        return kg;
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
        if (!bN())
        {
            com.google.android.gms.games.multiplayer.a.a(this, parcel, i);
        } else
        {
            wj.writeToParcel(parcel, i);
            parcel.writeString(uf);
            parcel.writeLong(wk);
            parcel.writeInt(wl);
            wm.writeToParcel(parcel, i);
            int k = wn.size();
            parcel.writeInt(k);
            int j = 0;
            while (j < k) 
            {
                ((ParticipantEntity)wn.get(j)).writeToParcel(parcel, i);
                j++;
            }
        }
    }

}
