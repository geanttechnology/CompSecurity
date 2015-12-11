// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.NetverifyDocumentData;

public final class gb
    implements android.os.Parcelable.Creator
{

    public gb()
    {
    }

    public final NetverifyDocumentData a(Parcel parcel)
    {
        return new NetverifyDocumentData(parcel, null);
    }

    public final NetverifyDocumentData[] a(int i)
    {
        return new NetverifyDocumentData[i];
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public final Object[] newArray(int i)
    {
        return a(i);
    }
}
