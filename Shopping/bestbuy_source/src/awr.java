// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.wearable.internal.m;

public class awr
    implements android.os.Parcelable.Creator
{

    public awr()
    {
    }

    public static void a(m m1, Parcel parcel, int i)
    {
        int j = rq.a(parcel);
        rq.a(parcel, 1, m1.a);
        rq.a(parcel, 2, m1.b(), i, false);
        rq.a(parcel, 4, m1.f(), false);
        rq.a(parcel, 5, m1.c(), false);
        rq.a(parcel, j);
    }

    public m a(Parcel parcel)
    {
        byte abyte0[];
        Object obj;
        Object obj1;
        int i;
        int j;
        abyte0 = null;
        j = ro.b(parcel);
        i = 0;
        obj1 = null;
        obj = null;
_L7:
        int k;
        if (parcel.dataPosition() >= j)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        k = ro.a(parcel);
        ro.a(k);
        JVM INSTR tableswitch 1 5: default 72
    //                   1 101
    //                   2 122
    //                   3 72
    //                   4 146
    //                   5 163;
           goto _L1 _L2 _L3 _L1 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_163;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        ro.b(parcel, k);
        Object obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L8:
        Object obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
        i = ro.f(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        Uri uri = (Uri)ro.a(parcel, k, Uri.CREATOR);
        obj = obj1;
        obj1 = uri;
          goto _L8
_L4:
        android.os.Bundle bundle = ro.m(parcel, k);
        obj1 = obj;
        obj = bundle;
          goto _L8
        abyte0 = ro.n(parcel, k);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L8
        if (parcel.dataPosition() != j)
        {
            throw new rp((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
        } else
        {
            return new m(i, ((Uri) (obj)), ((android.os.Bundle) (obj1)), abyte0);
        }
    }

    public m[] a(int i)
    {
        return new m[i];
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
