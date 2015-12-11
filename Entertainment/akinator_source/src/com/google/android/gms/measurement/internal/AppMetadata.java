// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzb

public class AppMetadata
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    public final String packageName;
    public final int versionCode;
    public final String zzaDC;
    public final String zzaLP;
    public final String zzaLQ;
    public final long zzaLR;
    public final long zzaLS;

    AppMetadata(int i, String s, String s1, String s2, String s3, long l, 
            long l1)
    {
        versionCode = i;
        packageName = s;
        zzaLP = s1;
        zzaDC = s2;
        zzaLQ = s3;
        zzaLR = l;
        zzaLS = l1;
    }

    AppMetadata(String s, String s1, String s2, String s3, long l, long l1)
    {
        zzx.zzcr(s);
        versionCode = 1;
        packageName = s;
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = null;
        }
        zzaLP = s;
        zzaDC = s2;
        zzaLQ = s3;
        zzaLR = l;
        zzaLS = l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
