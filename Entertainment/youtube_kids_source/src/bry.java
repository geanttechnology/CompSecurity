// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class bry
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new brz();
    public final dmu a;
    public List b;

    public bry(dmu dmu1)
    {
        a = (dmu)b.a(dmu1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        byte abyte0[] = eun.a(a);
        parcel.writeInt(abyte0.length);
        parcel.writeByteArray(abyte0);
    }

}
