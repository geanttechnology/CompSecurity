// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzc

public class DocumentId
    implements SafeParcelable
{

    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final String zzOZ;
    final String zzPa;
    final String zzPb;

    DocumentId(int i, String s, String s1, String s2)
    {
        mVersionCode = i;
        zzOZ = s;
        zzPa = s1;
        zzPb = s2;
    }

    public DocumentId(String s, String s1, String s2)
    {
        this(1, s, s1, s2);
    }

    public int describeContents()
    {
        zzc zzc1 = CREATOR;
        return 0;
    }

    public String toString()
    {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[] {
            zzOZ, zzPa, zzPb
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc zzc1 = CREATOR;
        zzc.zza(this, parcel, i);
    }

}
