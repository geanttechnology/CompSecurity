// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            ho, ep

public final class hn
    implements SafeParcelable
{

    public static final ho CREATOR = new ho();
    final List LA;
    private final String LB;
    private final boolean LC;
    private final Set LD;
    final int wj;

    hn(int i, List list, String s, boolean flag)
    {
        wj = i;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        LA = list;
        list = s;
        if (s == null)
        {
            list = "";
        }
        LB = list;
        LC = flag;
        if (LA.isEmpty())
        {
            LD = Collections.emptySet();
            return;
        } else
        {
            LD = Collections.unmodifiableSet(new HashSet(LA));
            return;
        }
    }

    public int describeContents()
    {
        ho ho1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hn))
            {
                return false;
            }
            obj = (hn)obj;
            if (!LD.equals(((hn) (obj)).LD) || LB != ((hn) (obj)).LB || LC != ((hn) (obj)).LC)
            {
                return false;
            }
        }
        return true;
    }

    public String gr()
    {
        return LB;
    }

    public boolean gs()
    {
        return LC;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            LD, LB, Boolean.valueOf(LC)
        });
    }

    public String toString()
    {
        return ep.e(this).a("types", LD).a("textQuery", LB).a("isOpenNowRequired", Boolean.valueOf(LC)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ho ho1 = CREATOR;
        ho.a(this, parcel, i);
    }

}
