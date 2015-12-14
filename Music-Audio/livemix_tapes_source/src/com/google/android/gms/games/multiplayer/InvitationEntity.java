// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            Invitation, Participant, ParticipantEntity, InvitationEntityCreator

public final class InvitationEntity extends GamesDowngradeableSafeParcel
    implements Invitation
{
    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdT(parcel);
        }

        public InvitationEntity zzdT(Parcel parcel)
        {
            if (InvitationEntity.zzc(InvitationEntity.zzsP()) || InvitationEntity.zzcW(com/google/android/gms/games/multiplayer/InvitationEntity.getCanonicalName()))
            {
                return super.zzdT(parcel);
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

        InvitationEntityCreatorCompat()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new InvitationEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzate;
    private final GameEntity zzaxY;
    private final long zzaxZ;
    private final int zzaya;
    private final ParticipantEntity zzayb;
    private final ArrayList zzayc;
    private final int zzayd;
    private final int zzaye;

    InvitationEntity(int i, GameEntity gameentity, String s, long l, int j, ParticipantEntity participantentity, 
            ArrayList arraylist, int k, int i1)
    {
        mVersionCode = i;
        zzaxY = gameentity;
        zzate = s;
        zzaxZ = l;
        zzaya = j;
        zzayb = participantentity;
        zzayc = arraylist;
        zzayd = k;
        zzaye = i1;
    }

    InvitationEntity(Invitation invitation)
    {
        mVersionCode = 2;
        zzaxY = new GameEntity(invitation.getGame());
        zzate = invitation.getInvitationId();
        zzaxZ = invitation.getCreationTimestamp();
        zzaya = invitation.getInvitationType();
        zzayd = invitation.getVariant();
        zzaye = invitation.getAvailableAutoMatchSlots();
        String s = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList arraylist = invitation.getParticipants();
        int j = arraylist.size();
        zzayc = new ArrayList(j);
        int i = 0;
        invitation = obj;
        for (; i < j; i++)
        {
            Participant participant = (Participant)arraylist.get(i);
            if (participant.getParticipantId().equals(s))
            {
                invitation = participant;
            }
            zzayc.add((ParticipantEntity)participant.freeze());
        }

        zzx.zzb(invitation, "Must have a valid inviter!");
        zzayb = (ParticipantEntity)invitation.freeze();
    }

    static int zza(Invitation invitation)
    {
        return zzw.hashCode(new Object[] {
            invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots())
        });
    }

    static boolean zza(Invitation invitation, Object obj)
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
        if (!zzw.equal(((Invitation) (obj)).getGame(), invitation.getGame()) || !zzw.equal(((Invitation) (obj)).getInvitationId(), invitation.getInvitationId()) || !zzw.equal(Long.valueOf(((Invitation) (obj)).getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) || !zzw.equal(Integer.valueOf(((Invitation) (obj)).getInvitationType()), Integer.valueOf(invitation.getInvitationType())) || !zzw.equal(((Invitation) (obj)).getInviter(), invitation.getInviter()) || !zzw.equal(((Invitation) (obj)).getParticipants(), invitation.getParticipants()) || !zzw.equal(Integer.valueOf(((Invitation) (obj)).getVariant()), Integer.valueOf(invitation.getVariant())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Integer.valueOf(((Invitation) (obj)).getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Invitation invitation)
    {
        return zzw.zzu(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
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
        return zzaye;
    }

    public long getCreationTimestamp()
    {
        return zzaxZ;
    }

    public Game getGame()
    {
        return zzaxY;
    }

    public String getInvitationId()
    {
        return zzate;
    }

    public int getInvitationType()
    {
        return zzaya;
    }

    public Participant getInviter()
    {
        return zzayb;
    }

    public ArrayList getParticipants()
    {
        return new ArrayList(zzayc);
    }

    public int getVariant()
    {
        return zzayd;
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
        if (!zzos())
        {
            InvitationEntityCreator.zza(this, parcel, i);
        } else
        {
            zzaxY.writeToParcel(parcel, i);
            parcel.writeString(zzate);
            parcel.writeLong(zzaxZ);
            parcel.writeInt(zzaya);
            zzayb.writeToParcel(parcel, i);
            int k = zzayc.size();
            parcel.writeInt(k);
            int j = 0;
            while (j < k) 
            {
                ((ParticipantEntity)zzayc.get(j)).writeToParcel(parcel, i);
                j++;
            }
        }
    }

}
