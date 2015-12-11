// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            n

public class PlacesParams
    implements SafeParcelable
{

    public static final n CREATOR = new n();
    public static final PlacesParams a = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;

    public PlacesParams(int i, String s, String s1, String s2, String s3, String s4, int j)
    {
        b = i;
        c = s;
        d = s1;
        e = s2;
        f = s3;
        g = s4;
        h = j;
    }

    public PlacesParams(String s, Locale locale, String s1)
    {
        this(1, s, locale.toString(), s1, null, null, b.a);
    }

    public PlacesParams(String s, Locale locale, String s1, String s2, String s3)
    {
        this(1, s, locale.toString(), s1, s2, s3, b.a);
    }

    public int describeContents()
    {
        n n1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof PlacesParams))
            {
                return false;
            }
            obj = (PlacesParams)obj;
            if (!d.equals(((PlacesParams) (obj)).d) || !c.equals(((PlacesParams) (obj)).c) || !w.a(e, ((PlacesParams) (obj)).e) || !w.a(f, ((PlacesParams) (obj)).f) || !w.a(g, ((PlacesParams) (obj)).g))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            c, d, e, f, g
        });
    }

    public String toString()
    {
        return w.a(this).a("clientPackageName", c).a("locale", d).a("accountName", e).a("gCoreClientName", f).a("chargedPackageName", g).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        n n1 = CREATOR;
        n.a(this, parcel, i);
    }

}
