// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            aa, aj, am

public final class z
    implements SafeParcelable
{

    public static final aa CREATOR = new aa();
    public final Bundle extras;
    public final long le;
    public final int lf;
    public final List lg;
    public final boolean lh;
    public final boolean li;
    public final String lj;
    public final am lk;
    public final Location ll;
    public final String lm;
    public final int tagForChildDirectedTreatment;
    public final int versionCode;

    z(int i, long l, Bundle bundle, int j, List list, boolean flag, 
            int k, boolean flag1, String s, am am1, Location location, String s1)
    {
        versionCode = i;
        le = l;
        extras = bundle;
        lf = j;
        lg = list;
        lh = flag;
        tagForChildDirectedTreatment = k;
        li = flag1;
        lj = s;
        lk = am1;
        ll = location;
        lm = s1;
    }

    public z(Context context, aj aj1)
    {
        Object obj1 = null;
        super();
        versionCode = 3;
        Object obj = aj1.getBirthday();
        long l;
        if (obj != null)
        {
            l = ((Date) (obj)).getTime();
        } else
        {
            l = -1L;
        }
        le = l;
        lm = aj1.getContentUrl();
        lf = aj1.getGender();
        obj = aj1.getKeywords();
        if (!((Set) (obj)).isEmpty())
        {
            obj = Collections.unmodifiableList(new ArrayList(((java.util.Collection) (obj))));
        } else
        {
            obj = null;
        }
        lg = ((List) (obj));
        lh = aj1.isTestDevice(context);
        tagForChildDirectedTreatment = aj1.al();
        ll = aj1.getLocation();
        context = (AdMobExtras)aj1.getNetworkExtras(com/google/android/gms/ads/mediation/admob/AdMobExtras);
        if (context != null)
        {
            context = context.getExtras();
        } else
        {
            context = null;
        }
        extras = context;
        li = aj1.getManualImpressionsEnabled();
        lj = aj1.getPublisherProvidedId();
        aj1 = aj1.aj();
        context = obj1;
        if (aj1 != null)
        {
            context = new am(aj1);
        }
        lk = context;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aa.a(this, parcel, i);
    }

}
