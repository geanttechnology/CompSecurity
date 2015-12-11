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
//            b

public final class AdRequestInfoParcel
    implements SafeParcelable
{

    public static final b CREATOR = new b();
    public final List A;
    public final String B;
    public final NativeAdOptionsParcel C;
    public final List D;
    public final int a;
    public final Bundle b;
    public final AdRequestParcel c;
    public final AdSizeParcel d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final VersionInfoParcel k;
    public final Bundle l;
    public final int m;
    public final List n;
    public final Bundle o;
    public final boolean p;
    public final Messenger q;
    public final int r;
    public final int s;
    public final float t;
    public final String u;
    public final boolean v;
    public final int w;
    public final String x;
    public final long y;
    public final String z;

    AdRequestInfoParcel(int i1, Bundle bundle, AdRequestParcel adrequestparcel, AdSizeParcel adsizeparcel, String s1, ApplicationInfo applicationinfo, PackageInfo packageinfo, 
            String s2, String s3, String s4, VersionInfoParcel versioninfoparcel, Bundle bundle1, int j1, List list, 
            Bundle bundle2, boolean flag, Messenger messenger, int k1, int l1, float f1, String s5, 
            boolean flag1, int i2, String s6, long l2, String s7, List list1, 
            String s8, NativeAdOptionsParcel nativeadoptionsparcel, List list2)
    {
        a = i1;
        b = bundle;
        c = adrequestparcel;
        d = adsizeparcel;
        e = s1;
        f = applicationinfo;
        g = packageinfo;
        h = s2;
        i = s3;
        j = s4;
        k = versioninfoparcel;
        l = bundle1;
        m = j1;
        n = list;
        if (list2 == null)
        {
            bundle = Collections.emptyList();
        } else
        {
            bundle = Collections.unmodifiableList(list2);
        }
        D = bundle;
        o = bundle2;
        p = flag;
        q = messenger;
        r = k1;
        s = l1;
        t = f1;
        u = s5;
        v = flag1;
        w = i2;
        x = s6;
        y = l2;
        z = s7;
        if (list1 == null)
        {
            bundle = Collections.emptyList();
        } else
        {
            bundle = Collections.unmodifiableList(list1);
        }
        A = bundle;
        B = s8;
        C = nativeadoptionsparcel;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        com.google.android.gms.ads.internal.request.b.a(this, parcel, i1);
    }

}
