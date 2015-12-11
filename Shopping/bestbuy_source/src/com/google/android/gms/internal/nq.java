// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import adv;
import afk;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nq
    implements SafeParcelable
{

    public static final afk CREATOR = new afk();
    public final int a;
    final boolean b;
    public final List c;
    private final Set d;

    public nq(int i, boolean flag, List list)
    {
        a = i;
        b = flag;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        c = list;
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

    public boolean a()
    {
        return b;
    }

    public int describeContents()
    {
        afk afk1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof nq))
            {
                return false;
            }
            obj = (nq)obj;
            if (!d.equals(((nq) (obj)).d) || b != ((nq) (obj)).b)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            d, Boolean.valueOf(b)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        afk afk1 = CREATOR;
        afk.a(this, parcel, i);
    }

}
