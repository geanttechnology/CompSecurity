// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.google.android.gms.location.places:
//            o

public class AddPlaceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new o();
    final int a;
    private final String b;
    private final LatLng c;
    private final String d;
    private final List e;
    private final String f;
    private final Uri g;

    AddPlaceRequest(int i, String s, LatLng latlng, String s1, List list, String s2, Uri uri)
    {
label0:
        {
            boolean flag1 = false;
            super();
            a = i;
            b = x.a(s);
            c = (LatLng)x.a(latlng);
            d = x.a(s1);
            e = new ArrayList((Collection)x.a(list));
            boolean flag;
            if (!e.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x.b(flag, "At least one place type should be provided.");
            if (TextUtils.isEmpty(s2))
            {
                flag = flag1;
                if (uri == null)
                {
                    break label0;
                }
            }
            flag = true;
        }
        x.b(flag, "One of phone number or URI should be provided.");
        f = s2;
        g = uri;
    }

    public String a()
    {
        return b;
    }

    public LatLng b()
    {
        return c;
    }

    public String c()
    {
        return d;
    }

    public List d()
    {
        return e;
    }

    public int describeContents()
    {
        return 0;
    }

    public String e()
    {
        return f;
    }

    public Uri f()
    {
        return g;
    }

    public String toString()
    {
        return w.a(this).a("name", b).a("latLng", c).a("address", d).a("placeTypes", e).a("phoneNumer", f).a("websiteUri", g).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        o.a(this, parcel, i);
    }

}
