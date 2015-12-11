// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

// Referenced classes of package com.google.android.gms.games.request:
//            GameRequestEntity

public class GameRequestEntityCreator
    implements android.os.Parcelable.Creator
{

    public static final int CONTENT_DESCRIPTION = 0;

    public GameRequestEntityCreator()
    {
    }

    static void a(GameRequestEntity gamerequestentity, Parcel parcel, int i)
    {
        int j = b.p(parcel);
        b.a(parcel, 1, gamerequestentity.getGame(), i, false);
        b.c(parcel, 1000, gamerequestentity.getVersionCode());
        b.a(parcel, 2, gamerequestentity.getSender(), i, false);
        b.a(parcel, 3, gamerequestentity.getData(), false);
        b.a(parcel, 4, gamerequestentity.getRequestId(), false);
        b.b(parcel, 5, gamerequestentity.fU(), false);
        b.c(parcel, 7, gamerequestentity.getType());
        b.a(parcel, 9, gamerequestentity.getCreationTimestamp());
        b.a(parcel, 10, gamerequestentity.getExpirationTimestamp());
        b.a(parcel, 11, gamerequestentity.gf(), false);
        b.D(parcel, j);
    }

    public GameRequestEntity createFromParcel(Parcel parcel)
    {
        int k = com.google.android.gms.common.internal.safeparcel.a.o(parcel);
        int j = 0;
        GameEntity gameentity = null;
        PlayerEntity playerentity = null;
        byte abyte0[] = null;
        String s = null;
        java.util.ArrayList arraylist = null;
        int i = 0;
        long l2 = 0L;
        long l1 = 0L;
        android.os.Bundle bundle = null;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.S(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, l);
                    break;

                case 1: // '\001'
                    gameentity = (GameEntity)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, GameEntity.CREATOR);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 2: // '\002'
                    playerentity = (PlayerEntity)com.google.android.gms.common.internal.safeparcel.a.a(parcel, l, PlayerEntity.CREATOR);
                    break;

                case 3: // '\003'
                    abyte0 = com.google.android.gms.common.internal.safeparcel.a.p(parcel, l);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.a.m(parcel, l);
                    break;

                case 5: // '\005'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, l, PlayerEntity.CREATOR);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, l);
                    break;

                case 9: // '\t'
                    l2 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, l);
                    break;

                case 10: // '\n'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.h(parcel, l);
                    break;

                case 11: // '\013'
                    bundle = com.google.android.gms.common.internal.safeparcel.a.o(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GameRequestEntity(j, gameentity, playerentity, abyte0, s, arraylist, i, l2, l1, bundle);
            }
        } while (true);
    }

    public volatile Object createFromParcel(Parcel parcel)
    {
        return createFromParcel(parcel);
    }

    public GameRequestEntity[] newArray(int i)
    {
        return new GameRequestEntity[i];
    }

    public volatile Object[] newArray(int i)
    {
        return newArray(i);
    }
}
