// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import com.google.android.gms.wallet.Cart;
import com.google.android.gms.wallet.LineItem;
import java.util.ArrayList;

public class asn
    implements android.os.Parcelable.Creator
{

    public asn()
    {
    }

    public static void a(Cart cart, Parcel parcel, int i)
    {
        i = rq.a(parcel);
        rq.a(parcel, 1, cart.a());
        rq.a(parcel, 2, cart.a, false);
        rq.a(parcel, 3, cart.b, false);
        rq.b(parcel, 4, cart.c, false);
        rq.a(parcel, i);
    }

    public Cart a(Parcel parcel)
    {
        String s1 = null;
        int j = ro.b(parcel);
        int i = 0;
        ArrayList arraylist = new ArrayList();
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
                    arraylist = ro.c(parcel, k, LineItem.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Cart(i, s, s1, arraylist);
            }
        } while (true);
    }

    public Cart[] a(int i)
    {
        return new Cart[i];
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
