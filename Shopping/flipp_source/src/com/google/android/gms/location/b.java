// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;

// Referenced classes of package com.google.android.gms.location:
//            ActivityRecognitionResult, DetectedActivity

public final class b
    implements android.os.Parcelable.Creator
{

    public b()
    {
    }

    static void a(ActivityRecognitionResult activityrecognitionresult, Parcel parcel)
    {
        int i = c.a(parcel, 20293);
        c.b(parcel, 1, activityrecognitionresult.b, false);
        c.b(parcel, 1000, activityrecognitionresult.a);
        c.a(parcel, 2, activityrecognitionresult.c);
        c.a(parcel, 3, activityrecognitionresult.d);
        c.b(parcel, i);
    }

    public final Object createFromParcel(Parcel parcel)
    {
        long l = 0L;
        int i = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        java.util.ArrayList arraylist = null;
        long l1 = 0L;
        do
        {
            if (parcel.dataPosition() < i)
            {
                int j = parcel.readInt();
                switch (0xffff & j)
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(parcel, j);
                    break;

                case 1: // '\001'
                    arraylist = com.google.android.gms.common.internal.safeparcel.a.c(parcel, j, DetectedActivity.CREATOR);
                    break;

                case 1000: 
                    com.google.android.gms.common.internal.safeparcel.a.e(parcel, j);
                    break;

                case 2: // '\002'
                    l1 = com.google.android.gms.common.internal.safeparcel.a.f(parcel, j);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.a.f(parcel, j);
                    break;
                }
            } else
            if (parcel.dataPosition() != i)
            {
                throw new com.google.android.gms.common.internal.safeparcel.b((new StringBuilder("Overread allowed size end=")).append(i).toString(), parcel);
            } else
            {
                return new ActivityRecognitionResult(arraylist, l1, l);
            }
        } while (true);
    }

    public final volatile Object[] newArray(int i)
    {
        return new ActivityRecognitionResult[i];
    }
}
