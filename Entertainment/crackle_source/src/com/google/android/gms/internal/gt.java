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
//            gu, ee

public final class gt
    implements SafeParcelable
{

    public static final gu CREATOR = new gu();
    final int kg;
    private final int yf;
    final List yg;
    private final String yh;
    private final String yi;
    private final boolean yj;
    private final Set yk;

    gt(int i, int j, List list, String s, String s1, boolean flag)
    {
        kg = i;
        yf = j;
        if (list == null)
        {
            list = Collections.emptyList();
        } else
        {
            list = Collections.unmodifiableList(list);
        }
        yg = list;
        list = s;
        if (s == null)
        {
            list = "";
        }
        yh = list;
        list = s1;
        if (s1 == null)
        {
            list = "";
        }
        yi = list;
        yj = flag;
        if (yg.isEmpty())
        {
            yk = Collections.emptySet();
            return;
        } else
        {
            yk = Collections.unmodifiableSet(new HashSet(yg));
            return;
        }
    }

    public int dO()
    {
        return yf;
    }

    public String dP()
    {
        return yh;
    }

    public String dQ()
    {
        return yi;
    }

    public boolean dR()
    {
        return yj;
    }

    public int describeContents()
    {
        gu gu1 = CREATOR;
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof gt))
            {
                return false;
            }
            obj = (gt)obj;
            if (yf != ((gt) (obj)).yf || !yk.equals(((gt) (obj)).yk) || yh != ((gt) (obj)).yh || yi != ((gt) (obj)).yi || yj != ((gt) (obj)).yj)
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(yf), yk, yh, yi, Boolean.valueOf(yj)
        });
    }

    public String toString()
    {
        return ee.e(this).a("maxResults", Integer.valueOf(yf)).a("types", yk).a("nameQuery", yh).a("textQuery", yi).a("isOpenNowRequired", Boolean.valueOf(yj)).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        gu gu1 = CREATOR;
        gu.a(this, parcel, i);
    }

}
