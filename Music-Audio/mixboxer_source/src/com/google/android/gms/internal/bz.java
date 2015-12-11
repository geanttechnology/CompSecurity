// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.internal:
//            ca, cu, x, v

public final class bz
    implements SafeParcelable
{
    public static final class a
    {

        public final String adUnitId;
        public final ApplicationInfo applicationInfo;
        public final cu ej;
        public final x em;
        public final Bundle hq;
        public final v hr;
        public final PackageInfo hs;
        public final String hu;
        public final String hv;

        public a(Bundle bundle, v v, x x, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, String s1, 
                String s2, cu cu)
        {
            hq = bundle;
            hr = v;
            em = x;
            adUnitId = s;
            applicationInfo = applicationinfo;
            hs = packageinfo;
            hu = s1;
            hv = s2;
            ej = cu;
        }
    }


    public static final ca CREATOR = new ca();
    public final String adUnitId;
    public final ApplicationInfo applicationInfo;
    public final cu ej;
    public final x em;
    public final Bundle hq;
    public final v hr;
    public final PackageInfo hs;
    public final String ht;
    public final String hu;
    public final String hv;
    public final int versionCode;

    bz(int i, Bundle bundle, v v, x x, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, 
            String s1, String s2, String s3, cu cu)
    {
        versionCode = i;
        hq = bundle;
        hr = v;
        em = x;
        adUnitId = s;
        applicationInfo = applicationinfo;
        hs = packageinfo;
        ht = s1;
        hu = s2;
        hv = s3;
        ej = cu;
    }

    public bz(Bundle bundle, v v, x x, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, String s1, 
            String s2, String s3, cu cu)
    {
        this(1, bundle, v, x, s, applicationinfo, packageinfo, s1, s2, s3, cu);
    }

    public bz(a a1, String s)
    {
        this(a1.hq, a1.hr, a1.em, a1.adUnitId, a1.applicationInfo, a1.hs, s, a1.hu, a1.hv, a1.ej);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ca.a(this, parcel, i);
    }

}
