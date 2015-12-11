// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.internal.multiplayer:
//            InvitationClusterCreator

public final class ZInvitationCluster
    implements SafeParcelable, Invitation
{

    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    private final int mVersionCode;
    private final ArrayList zzazj;

    ZInvitationCluster(int i, ArrayList arraylist)
    {
        mVersionCode = i;
        zzazj = arraylist;
        zzvp();
    }

    private void zzvp()
    {
        Invitation invitation;
        int j;
        boolean flag;
        if (!zzazj.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzb.zzZ(flag);
        invitation = (Invitation)zzazj.get(0);
        j = zzazj.size();
        for (int i = 1; i < j; i++)
        {
            Invitation invitation1 = (Invitation)zzazj.get(i);
            zzb.zza(invitation.getInviter().equals(invitation1.getInviter()), "All the invitations must be from the same inviter");
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof ZInvitationCluster))
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        obj = (ZInvitationCluster)obj;
        if (((ZInvitationCluster) (obj)).zzazj.size() != zzazj.size())
        {
            return false;
        }
        int j = zzazj.size();
        for (int i = 0; i < j; i++)
        {
            if (!((Invitation)zzazj.get(i)).equals((Invitation)((ZInvitationCluster) (obj)).zzazj.get(i)))
            {
                return false;
            }
        }

        return true;
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
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId()
    {
        return ((InvitationEntity)zzazj.get(0)).getInvitationId();
    }

    public int getInvitationType()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter()
    {
        return ((InvitationEntity)zzazj.get(0)).getInviter();
    }

    public ArrayList getParticipants()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant()
    {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(zzazj.toArray());
    }

    public boolean isDataValid()
    {
        return true;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        InvitationClusterCreator.zza(this, parcel, i);
    }

    public ArrayList zzvq()
    {
        return new ArrayList(zzazj);
    }

}
