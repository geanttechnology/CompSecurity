// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.location.places:
//            p

public class AutocompleteFilter
    implements SafeParcelable
{

    public static final p CREATOR = new p();
    final int a;
    final boolean b;
    final List c;
    private final Set d;

    AutocompleteFilter(int i, boolean flag, Collection collection)
    {
        a = i;
        b = flag;
        if (collection == null)
        {
            collection = Collections.emptyList();
        } else
        {
            collection = new ArrayList(collection);
        }
        c = collection;
        if (c.isEmpty())
        {
            d = Collections.emptySet();
            return;
        } else
        {
            d = Collections.unmodifiableSet(new HashSet(c));
            return;
        }
    }

    public static AutocompleteFilter a(Collection collection)
    {
        return a(true, collection);
    }

    public static AutocompleteFilter a(boolean flag, Collection collection)
    {
        return new AutocompleteFilter(0, flag, collection);
    }

    public boolean a()
    {
        return b;
    }

    public int describeContents()
    {
        p p1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AutocompleteFilter))
            {
                return false;
            }
            obj = (AutocompleteFilter)obj;
            if (!d.equals(((AutocompleteFilter) (obj)).d) || b != ((AutocompleteFilter) (obj)).b)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return w.a(new Object[] {
            Boolean.valueOf(b), d
        });
    }

    public String toString()
    {
        com.google.android.gms.common.internal.w.a a1 = w.a(this);
        if (!b)
        {
            a1.a("restrictedToPlaces", Boolean.valueOf(b));
        }
        a1.a("placeTypes", d);
        return a1.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        p p1 = CREATOR;
        p.a(this, parcel, i);
    }

}
