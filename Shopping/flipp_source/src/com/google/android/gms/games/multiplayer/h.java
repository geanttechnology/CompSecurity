// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.PlayerEntity;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            ParticipantEntity, ParticipantResult

public class h
    implements android.os.Parcelable.Creator
{

    public h()
    {
    }

    static void a(ParticipantEntity participantentity, Parcel parcel, int i)
    {
        int j = c.a(parcel, 20293);
        c.a(parcel, 1, participantentity.b, false);
        c.b(parcel, 1000, participantentity.a);
        c.a(parcel, 2, participantentity.f(), false);
        c.a(parcel, 3, participantentity.g(), i, false);
        c.a(parcel, 4, participantentity.h(), i, false);
        c.b(parcel, 5, participantentity.c);
        c.a(parcel, 6, participantentity.d, false);
        c.a(parcel, 7, participantentity.e);
        c.a(parcel, 8, participantentity.f, i, false);
        c.b(parcel, 9, participantentity.g);
        c.a(parcel, 10, participantentity.h, i, false);
        c.b(parcel, j);
    }

    public ParticipantEntity a(Parcel parcel)
    {
        int i = 0;
        ParticipantResult participantresult = null;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        PlayerEntity playerentity = null;
        boolean flag = false;
        String s = null;
        int j = 0;
        Uri uri = null;
        Uri uri1 = null;
        String s1 = null;
        String s2 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = parcel.readInt();
                switch (0xffff & i1)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, i1);
                    break;

                case 1: // '\001'
                    s2 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 1000: 
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 3: // '\003'
                    uri1 = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, Uri.CREATOR);
                    break;

                case 4: // '\004'
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, Uri.CREATOR);
                    break;

                case 5: // '\005'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 6: // '\006'
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.a.c(parcel, i1);
                    break;

                case 8: // '\b'
                    playerentity = (PlayerEntity)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, PlayerEntity.CREATOR);
                    break;

                case 9: // '\t'
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 10: // '\n'
                    participantresult = (ParticipantResult)com.google.android.gms.common.internal.safeparcel.a.a(parcel, i1, ParticipantResult.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new ParticipantEntity(k, s2, s1, uri1, uri, j, s, flag, playerentity, i, participantresult);
            }
        } while (true);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return new ParticipantEntity[i];
    }
}
