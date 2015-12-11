// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            CloseContentsRequest

public class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(CloseContentsRequest closecontentsrequest, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.b.o(parcel);
        com.google.android.gms.common.internal.safeparcel.b.c(parcel, 1, closecontentsrequest.kg);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, closecontentsrequest.qX, i, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, closecontentsrequest.qY, false);
        com.google.android.gms.common.internal.safeparcel.b.D(parcel, j);
    }

    public CloseContentsRequest A(Parcel parcel)
    {
        Boolean boolean1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.n(parcel);
        int i = 0;
        Contents contents = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.a.m(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.a.M(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.a.g(parcel, k);
                    break;

                case 2: // '\002'
                    contents = (Contents)com.google.android.gms.common.internal.safeparcel.a.a(parcel, k, Contents.CREATOR);
                    break;

                case 3: // '\003'
                    boolean1 = com.google.android.gms.common.internal.safeparcel.a.d(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.a.a((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new CloseContentsRequest(i, contents, boolean1);
            }
        } while (true);
    }

    public CloseContentsRequest[] aa(int i)
    {
        return new CloseContentsRequest[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return A(parcel);
    }

    public Object[] newArray(int i)
    {
        return aa(i);
    }
}
