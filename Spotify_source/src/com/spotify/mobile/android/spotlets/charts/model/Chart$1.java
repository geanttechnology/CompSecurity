// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.mobile.android.spotlets.charts.model;

import android.os.Parcel;

// Referenced classes of package com.spotify.mobile.android.spotlets.charts.model:
//            Chart

final class 
    implements android.os.le.Creator
{

    public final Object createFromParcel(Parcel parcel)
    {
        return new Chart(parcel, null);
    }

    public final volatile Object[] newArray(int i)
    {
        return new Chart[i];
    }

    ()
    {
    }
}
