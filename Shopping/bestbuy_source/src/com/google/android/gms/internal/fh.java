// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import aak;
import aal;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            av, ay, gs

public final class fh
    implements SafeParcelable
{

    public static final aal CREATOR = new aal();
    public final int a;
    public final Bundle b;
    public final av c;
    public final ay d;
    public final String e;
    public final ApplicationInfo f;
    public final PackageInfo g;
    public final String h;
    public final String i;
    public final String j;
    public final gs k;
    public final Bundle l;
    public final int m;
    public final List n;
    public final Bundle o;
    public final boolean p;

    public fh(int i1, Bundle bundle, av av, ay ay, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, 
            String s1, String s2, String s3, gs gs, Bundle bundle1, int j1, List list, 
            Bundle bundle2, boolean flag)
    {
        a = i1;
        b = bundle;
        c = av;
        d = ay;
        e = s;
        f = applicationinfo;
        g = packageinfo;
        h = s1;
        i = s2;
        j = s3;
        k = gs;
        l = bundle1;
        m = j1;
        n = list;
        o = bundle2;
        p = flag;
    }

    public fh(aak aak1, String s)
    {
        this(aak1.a, aak1.b, aak1.c, aak1.d, aak1.e, aak1.f, s, aak1.g, aak1.h, aak1.j, aak1.i, aak1.k, aak1.l, aak1.m, aak1.n);
    }

    public fh(Bundle bundle, av av, ay ay, String s, ApplicationInfo applicationinfo, PackageInfo packageinfo, String s1, 
            String s2, String s3, gs gs, Bundle bundle1, int i1, List list, Bundle bundle2, 
            boolean flag)
    {
        this(4, bundle, av, ay, s, applicationinfo, packageinfo, s1, s2, s3, gs, bundle1, i1, list, bundle2, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        aal.a(this, parcel, i1);
    }

}
