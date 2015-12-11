// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.ha;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            d, c

public final class MetadataBundle
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new d();
    final int a;
    public final Bundle b;

    MetadataBundle(int i, Bundle bundle)
    {
        a = i;
        b = (Bundle)ha.a(bundle);
        b.setClassLoader(getClass().getClassLoader());
        bundle = new ArrayList();
        Iterator iterator = b.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (c.a(s1) == null)
            {
                bundle.add(s1);
                Log.w("MetadataBundle", (new StringBuilder("Ignored unknown metadata field in bundle: ")).append(s1).toString());
            }
        } while (true);
        String s;
        for (bundle = bundle.iterator(); bundle.hasNext(); b.remove(s))
        {
            s = (String)bundle.next();
        }

    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof MetadataBundle))
        {
            return false;
        }
        obj = (MetadataBundle)obj;
        Object obj1 = b.keySet();
        if (!obj1.equals(((MetadataBundle) (obj)).b.keySet()))
        {
            return false;
        }
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            String s = (String)((Iterator) (obj1)).next();
            if (!gw.a(b.get(s), ((MetadataBundle) (obj)).b.get(s)))
            {
                return false;
            }
        }

        return true;
    }

    public final int hashCode()
    {
        Iterator iterator = b.keySet().iterator();
        String s;
        int i;
        for (i = 1; iterator.hasNext(); i = b.get(s).hashCode() + i * 31)
        {
            s = (String)iterator.next();
        }

        return i;
    }

    public final String toString()
    {
        return (new StringBuilder("MetadataBundle [values=")).append(b).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        d.a(this, parcel);
    }

}
