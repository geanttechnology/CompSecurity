// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wearable.internal.ai;

public class avl
    implements android.os.Parcelable.Creator
{

    public avl()
    {
    }

    public static void a(ai ai1, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, ai1.a);
        rq.a(parcel, 2, ai1.a());
        rq.a(parcel, 3, ai1.b(), false);
        rq.a(parcel, 4, ai1.c(), false);
        rq.a(parcel, 5, ai1.d(), false);
        rq.a(parcel, i);
    }

    public ai a(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = ro.b(parcel);
        byte abyte0[] = null;
        String s1 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = ro.a(parcel);
                switch (ro.a(l))
                {
                default:
                    ro.b(parcel, l);
                    break;

                case 1: // '\001'
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    i = ro.f(parcel, l);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, l);
                    break;

                case 4: // '\004'
                    abyte0 = ro.n(parcel, l);
                    break;

                case 5: // '\005'
                    s = ro.k(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ai(j, i, s1, abyte0, s);
            }
        } while (true);
    }

    public ai[] a(int i)
    {
        return new ai[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
