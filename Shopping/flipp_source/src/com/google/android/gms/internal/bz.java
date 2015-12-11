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
//            dm, dk, v, x, 
//            cu

public final class bz
    implements SafeParcelable
{

    public static final dm CREATOR = new dm();
    public final int a;
    public final Bundle b;
    public final v c;
    public final x d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final cu k;

    bz(int l, Bundle bundle, v v, x x, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, 
            String s1, String s2, String s3, cu cu)
    {
        a = l;
        b = bundle;
        c = v;
        d = x;
        e = s;
        f = applicationinfo;
        g = packageinfo;
        h = s1;
        i = s2;
        j = s3;
        k = cu;
    }

    private bz(Bundle bundle, v v, x x, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, String s1, 
            String s2, String s3, cu cu)
    {
        this(1, bundle, v, x, s, applicationinfo, packageinfo, s1, s2, s3, cu);
    }

    public bz(dk dk1, String s)
    {
        this(dk1.a, dk1.b, dk1.c, dk1.d, dk1.e, dk1.f, s, dk1.g, dk1.h, dk1.i);
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int l)
    {
        dm.a(this, parcel, l);
    }

}
