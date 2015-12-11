// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.location:
//            p, f

public class GeofencingRequest
    implements SafeParcelable
{
    public static final class a
    {

        private final List a = new ArrayList();
        private int b;

        public static int b(int i)
        {
            return i & 7;
        }

        public a a(int i)
        {
            b = b(i);
            return this;
        }

        public a a(f f1)
        {
            x.a(f1, "geofence can't be null.");
            x.b(f1 instanceof ParcelableGeofence, "Geofence must be created using Geofence.Builder.");
            a.add((ParcelableGeofence)f1);
            return this;
        }

        public a a(List list)
        {
            if (list != null && !list.isEmpty())
            {
                list = list.iterator();
                while (list.hasNext()) 
                {
                    f f1 = (f)list.next();
                    if (f1 != null)
                    {
                        a(f1);
                    }
                }
            }
            return this;
        }

        public GeofencingRequest a()
        {
            boolean flag;
            if (!a.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            x.b(flag, "No geofence has been added to this request.");
            return new GeofencingRequest(a, b);
        }

        public a()
        {
            b = 5;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new p();
    private final int a;
    private final List b;
    private final int c;

    GeofencingRequest(int i, List list, int j)
    {
        a = i;
        b = list;
        c = j;
    }

    private GeofencingRequest(List list, int i)
    {
        this(1, list, i);
    }


    public int a()
    {
        return a;
    }

    public List b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        p.a(this, parcel, i);
    }

}
