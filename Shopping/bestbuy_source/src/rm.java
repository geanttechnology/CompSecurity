// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.CursorWindow;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

public class rm
    implements android.os.Parcelable.Creator
{

    public rm()
    {
    }

    public static void a(DataHolder dataholder, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, dataholder.c(), false);
        rq.a(parcel, 1000, dataholder.b());
        rq.a(parcel, 2, dataholder.d(), i, false);
        rq.a(parcel, 3, dataholder.e());
        rq.a(parcel, 4, dataholder.f(), false);
        rq.a(parcel, j);
    }

    public DataHolder a(Parcel parcel)
    {
        int i = 0;
        android.os.Bundle bundle = null;
        int k = ro.b(parcel);
        CursorWindow acursorwindow[] = null;
        String as[] = null;
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
                    as = ro.o(parcel, l);
                    break;

                case 1000: 
                    j = ro.f(parcel, l);
                    break;

                case 2: // '\002'
                    acursorwindow = (CursorWindow[])ro.b(parcel, l, CursorWindow.CREATOR);
                    break;

                case 3: // '\003'
                    i = ro.f(parcel, l);
                    break;

                case 4: // '\004'
                    bundle = ro.m(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new rp((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                parcel = new DataHolder(j, as, acursorwindow, i, bundle);
                parcel.a();
                return parcel;
            }
        } while (true);
    }

    public DataHolder[] a(int i)
    {
        return new DataHolder[i];
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
