// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.games.multiplayer:
//            ParticipantResult

public final class e
    implements android.os.Parcelable.Creator
{

    public e()
    {
    }

    static void a(ParticipantResult participantresult, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.a(parcel, 1, participantresult.b, false);
        c.b(parcel, 1000, participantresult.a);
        c.b(parcel, 2, participantresult.c);
        c.b(parcel, 3, participantresult.d);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String s = null;
        int i = 0;
        int j = 0;
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
                    s = com.google.android.gms.common.internal.safeparcel.a.k(parcel, i1);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.a.e(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new b((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new ParticipantResult(i, s, j, k);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ParticipantResult[i];
    }
}
