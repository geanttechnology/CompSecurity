// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.LineItem;

public class atc
    implements android.os.Parcelable.Creator
{

    public atc()
    {
    }

    public static void a(LineItem lineitem, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, lineitem.a());
        rq.a(parcel, 2, lineitem.a, false);
        rq.a(parcel, 3, lineitem.b, false);
        rq.a(parcel, 4, lineitem.c, false);
        rq.a(parcel, 5, lineitem.d, false);
        rq.a(parcel, 6, lineitem.e);
        rq.a(parcel, 7, lineitem.f, false);
        rq.a(parcel, i);
    }

    public LineItem a(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = ro.b(parcel);
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
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
                    s4 = ro.k(parcel, l);
                    break;

                case 3: // '\003'
                    s3 = ro.k(parcel, l);
                    break;

                case 4: // '\004'
                    s2 = ro.k(parcel, l);
                    break;

                case 5: // '\005'
                    s1 = ro.k(parcel, l);
                    break;

                case 6: // '\006'
                    i = ro.f(parcel, l);
                    break;

                case 7: // '\007'
                    s = ro.k(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new LineItem(j, s4, s3, s2, s1, i, s);
            }
        } while (true);
    }

    public LineItem[] a(int i)
    {
        return new LineItem[i];
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
