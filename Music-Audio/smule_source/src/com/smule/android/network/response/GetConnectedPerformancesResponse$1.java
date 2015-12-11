// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.response;

import android.os.Parcel;

// Referenced classes of package com.smule.android.network.response:
//            GetConnectedPerformancesResponse

final class 
    implements android.os.dPerformancesResponse._cls1
{

    public GetConnectedPerformancesResponse a(Parcel parcel)
    {
        return new GetConnectedPerformancesResponse(parcel);
    }

    public GetConnectedPerformancesResponse[] a(int i)
    {
        return new GetConnectedPerformancesResponse[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    ()
    {
    }
}
