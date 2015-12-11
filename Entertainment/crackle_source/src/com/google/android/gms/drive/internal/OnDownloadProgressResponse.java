// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.drive.internal:
//            s

public class OnDownloadProgressResponse
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new s();
    final int kg;
    final long rx;
    final long ry;

    OnDownloadProgressResponse(int i, long l, long l1)
    {
        kg = i;
        rx = l;
        ry = l1;
    }

    public long cR()
    {
        return rx;
    }

    public long cS()
    {
        return ry;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        s.a(this, parcel, i);
    }

}
