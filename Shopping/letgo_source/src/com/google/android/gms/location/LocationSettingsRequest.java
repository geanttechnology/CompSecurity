// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            u, LocationRequest

public final class LocationSettingsRequest
    implements SafeParcelable
{
    public static final class a
    {

        private final ArrayList a = new ArrayList();
        private boolean b;
        private boolean c;
        private boolean d;

        public a a(LocationRequest locationrequest)
        {
            a.add(locationrequest);
            return this;
        }

        public a a(boolean flag)
        {
            b = flag;
            return this;
        }

        public LocationSettingsRequest a()
        {
            return new LocationSettingsRequest(a, b, c, d);
        }

        public a()
        {
            b = false;
            c = false;
            d = false;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new u();
    private final int a;
    private final List b;
    private final boolean c;
    private final boolean d;
    private final boolean e;

    LocationSettingsRequest(int i, List list, boolean flag, boolean flag1, boolean flag2)
    {
        a = i;
        b = list;
        c = flag;
        d = flag1;
        e = flag2;
    }

    private LocationSettingsRequest(List list, boolean flag, boolean flag1, boolean flag2)
    {
        this(2, list, flag, flag1, flag2);
    }


    public int a()
    {
        return a;
    }

    public List b()
    {
        return Collections.unmodifiableList(b);
    }

    public boolean c()
    {
        return c;
    }

    public boolean d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean e()
    {
        return e;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        u.a(this, parcel, i);
    }

}
