// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.ads.internal.reward.mediation.client:
//            b

public final class RewardItemParcel
    implements SafeParcelable
{

    public static final b CREATOR = new b();
    public final int a;
    public final String b;
    public final int c;

    public RewardItemParcel(int i, String s, int j)
    {
        a = i;
        b = s;
        c = j;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.ads.internal.reward.mediation.client.b.a(this, parcel, i);
    }

}
