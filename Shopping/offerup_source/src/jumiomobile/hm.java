// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Parcel;
import com.jumio.netverify.sdk.core.vo.DocumentType;

public final class hm
    implements android.os.Parcelable.Creator
{

    public hm()
    {
    }

    public final DocumentType a(Parcel parcel)
    {
        return new DocumentType(parcel);
    }

    public final DocumentType[] a(int i)
    {
        return new DocumentType[i];
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
