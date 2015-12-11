// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.wallet.wobs:
//            zzc

public final class LabelValueRow
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    String zzbeD;
    String zzbeE;
    ArrayList zzbeF;

    LabelValueRow()
    {
        mVersionCode = 1;
        zzbeF = zzmj.zzqs();
    }

    LabelValueRow(int i, String s, String s1, ArrayList arraylist)
    {
        mVersionCode = i;
        zzbeD = s;
        zzbeE = s1;
        zzbeF = arraylist;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final int getVersionCode()
    {
        return mVersionCode;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
