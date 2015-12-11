// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.drive.metadata.internal:
//            d, c

public final class MetadataBundle
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new d();
    final int kg;
    final Bundle rF;

    MetadataBundle(int i, Bundle bundle)
    {
        kg = i;
        rF = (Bundle)eg.f(bundle);
        rF.setClassLoader(getClass().getClassLoader());
        bundle = new ArrayList();
        Iterator iterator = rF.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (c.ac(s1) == null)
            {
                bundle.add(s1);
                Log.w("MetadataBundle", (new StringBuilder()).append("Ignored unknown metadata field in bundle: ").append(s1).toString());
            }
        } while (true);
        String s;
        for (bundle = bundle.iterator(); bundle.hasNext(); rF.remove(s))
        {
            s = (String)bundle.next();
        }

    }

    private MetadataBundle(Bundle bundle)
    {
        this(1, bundle);
    }

    public static MetadataBundle a(MetadataField metadatafield, Object obj)
    {
        MetadataBundle metadatabundle = cX();
        metadatabundle.b(metadatafield, obj);
        return metadatabundle;
    }

    public static MetadataBundle a(MetadataBundle metadatabundle)
    {
        return new MetadataBundle(new Bundle(metadatabundle.rF));
    }

    public static MetadataBundle cX()
    {
        return new MetadataBundle(new Bundle());
    }

    public Object a(MetadataField metadatafield)
    {
        return metadatafield.d(rF);
    }

    public void b(MetadataField metadatafield, Object obj)
    {
        if (c.ac(metadatafield.getName()) == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unregistered field: ").append(metadatafield.getName()).toString());
        } else
        {
            metadatafield.a(obj, rF);
            return;
        }
    }

    public Set cY()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = rF.keySet().iterator(); iterator.hasNext(); hashset.add(c.ac((String)iterator.next()))) { }
        return hashset;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
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
        Object obj1 = rF.keySet();
        if (!obj1.equals(((MetadataBundle) (obj)).rF.keySet()))
        {
            return false;
        }
        for (obj1 = ((Set) (obj1)).iterator(); ((Iterator) (obj1)).hasNext();)
        {
            String s = (String)((Iterator) (obj1)).next();
            if (!ee.equal(rF.get(s), ((MetadataBundle) (obj)).rF.get(s)))
            {
                return false;
            }
        }

        return true;
    }

    public int hashCode()
    {
        Iterator iterator = rF.keySet().iterator();
        String s;
        int i;
        for (i = 1; iterator.hasNext(); i = rF.get(s).hashCode() + i * 31)
        {
            s = (String)iterator.next();
        }

        return i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("MetadataBundle [values=").append(rF).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        d.a(this, parcel, i);
    }

}
