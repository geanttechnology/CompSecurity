// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.auth.firstparty.shared:
//            zzc, FACLData

public class ScopeDetail
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    String description;
    final int version;
    String zzTH;
    String zzTI;
    String zzTJ;
    String zzTK;
    List zzTL;
    public FACLData zzTM;

    ScopeDetail(int i, String s, String s1, String s2, String s3, String s4, List list, 
            FACLData facldata)
    {
        version = i;
        description = s;
        zzTH = s1;
        zzTI = s2;
        zzTJ = s3;
        zzTK = s4;
        zzTL = list;
        zzTM = facldata;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

}
