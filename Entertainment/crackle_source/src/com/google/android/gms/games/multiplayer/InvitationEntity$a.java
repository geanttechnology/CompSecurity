// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            a, InvitationEntity, ParticipantEntity

static final class A extends a
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

    A()
    {
    }
}
