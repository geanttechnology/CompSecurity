// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            zzf

public final class AdRequestInfoParcel
    implements SafeParcelable
{

    public static final zzf CREATOR = new zzf();
    public final ApplicationInfo applicationInfo;
    public final int versionCode;
    public final boolean zzCA;
    public final int zzCB;
    public final String zzCC;
    public final long zzCD;
    public final String zzCE;
    public final List zzCF;
    public final List zzCG;
    public final Bundle zzCl;
    public final AdRequestParcel zzCm;
    public final PackageInfo zzCn;
    public final String zzCo;
    public final String zzCp;
    public final String zzCq;
    public final Bundle zzCr;
    public final int zzCs;
    public final Bundle zzCt;
    public final boolean zzCu;
    public final Messenger zzCv;
    public final int zzCw;
    public final int zzCx;
    public final float zzCy;
    public final String zzCz;
    public final String zzpF;
    public final String zzpG;
    public final VersionInfoParcel zzpJ;
    public final AdSizeParcel zzpN;
    public final NativeAdOptionsParcel zzqb;
    public final List zzqd;

    AdRequestInfoParcel(int i, Bundle bundle, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, 
            String s1, String s2, String s3, VersionInfoParcel versioninfoparcel, Bundle bundle1, int j, List list, 
            Bundle bundle2, boolean flag, Messenger messenger, int k, int l, float f, String s4, 
            boolean flag1, int i1, String s5, long l1, String s6, List list1, 
            String s7, NativeAdOptionsParcel nativeadoptionsparcel, List list2)
    {
        versionCode = i;
        zzCl = bundle;
        zzCm = adrequestparcel;
        zzpN = adsizeparcel;
        zzpG = s;
        applicationInfo = applicationinfo;
        zzCn = packageinfo;
        zzCo = s1;
        zzCp = s2;
        zzCq = s3;
        zzpJ = versioninfoparcel;
        zzCr = bundle1;
        zzCs = j;
        zzqd = list;
        if (list2 == null)
        {
            bundle = Collections.emptyList();
        } else
        {
            bundle = Collections.unmodifiableList(list2);
        }
        zzCG = bundle;
        zzCt = bundle2;
        zzCu = flag;
        zzCv = messenger;
        zzCw = k;
        zzCx = l;
        zzCy = f;
        zzCz = s4;
        zzCA = flag1;
        zzCB = i1;
        zzCC = s5;
        zzCD = l1;
        zzCE = s6;
        if (list1 == null)
        {
            bundle = Collections.emptyList();
        } else
        {
            bundle = Collections.unmodifiableList(list1);
        }
        zzCF = bundle;
        zzpF = s7;
        zzqb = nativeadoptionsparcel;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

}
