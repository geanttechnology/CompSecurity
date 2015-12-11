// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.OfferWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class atg
    implements android.os.Parcelable.Creator
{

    public atg()
    {
    }

    public static void a(OfferWalletObject offerwalletobject, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, offerwalletobject.a());
        rq.a(parcel, 2, offerwalletobject.a, false);
        rq.a(parcel, 3, offerwalletobject.b, false);
        rq.a(parcel, 4, offerwalletobject.c, i, false);
        rq.a(parcel, j);
    }

    public OfferWalletObject a(Parcel parcel)
    {
        CommonWalletObject commonwalletobject = null;
        int j = ro.b(parcel);
        int i = 0;
        String s1 = null;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = ro.a(parcel);
                switch (ro.a(k))
                {
                default:
                    ro.b(parcel, k);
                    break;

                case 1: // '\001'
                    i = ro.f(parcel, k);
                    break;

                case 2: // '\002'
                    s = ro.k(parcel, k);
                    break;

                case 3: // '\003'
                    s1 = ro.k(parcel, k);
                    break;

                case 4: // '\004'
                    commonwalletobject = (CommonWalletObject)ro.a(parcel, k, CommonWalletObject.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OfferWalletObject(i, s, s1, commonwalletobject);
            }
        } while (true);
    }

    public OfferWalletObject[] a(int i)
    {
        return new OfferWalletObject[i];
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
