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
//            w, af, ai

public final class v
    implements SafeParcelable
{

    public static final w CREATOR = new w();
    public final boolean eA;
    public final boolean eB;
    public final String eC;
    public final ai eD;
    public final Location eE;
    public final long ex;
    public final Bundle extras;
    public final int ey;
    public final List ez;
    public final int tagForChildDirectedTreatment;
    public final int versionCode;

    v(int i, long l, Bundle bundle, int j, List list, boolean flag, 
            int k, boolean flag1, String s, ai ai1, Location location)
    {
        versionCode = i;
        ex = l;
        extras = bundle;
        ey = j;
        ez = list;
        eA = flag;
        tagForChildDirectedTreatment = k;
        eB = flag1;
        eC = s;
        eD = ai1;
        eE = location;
    }

    public v(Context context, af af1)
    {
        Object obj1 = null;
        super();
        versionCode = 2;
        Object obj = af1.getBirthday();
        long l;
        if (obj != null)
        {
            l = ((Date) (obj)).getTime();
        } else
        {
            l = -1L;
        }
        ex = l;
        ey = af1.getGender();
        obj = af1.getKeywords();
        if (!((Set) (obj)).isEmpty())
        {
            obj = Collections.unmodifiableList(new ArrayList(((java.util.Collection) (obj))));
        } else
        {
            obj = null;
        }
        ez = ((List) (obj));
        eA = af1.isTestDevice(context);
        tagForChildDirectedTreatment = af1.S();
        eE = af1.getLocation();
        context = (AdMobExtras)af1.getNetworkExtras(com/google/android/gms/ads/mediation/admob/AdMobExtras);
        if (context != null)
        {
            context = context.getExtras();
        } else
        {
            context = null;
        }
        extras = context;
        eB = af1.getManualImpressionsEnabled();
        eC = af1.getPublisherProvidedId();
        af1 = af1.Q();
        context = obj1;
        if (af1 != null)
        {
            context = new ai(af1);
        }
        eD = context;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        w.a(this, parcel, i);
    }

}
