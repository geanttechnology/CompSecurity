// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            iz, ji, hd, ha

public final class hb extends iz
    implements SafeParcelable
{

    public static final ji CREATOR = new ji();
    private static final hb e = new hb(0, new hd[0], new float[0], 0L);
    final int a;
    final hd b[];
    final float c[];
    final long d;

    hb(int i, hd ahd[], float af[], long l)
    {
        boolean flag;
        if (ahd.length == af.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ha.a(flag, "mismatched places to probabilities arrays");
        a = i;
        b = ahd;
        c = af;
        d = l;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof hb))
            {
                return false;
            }
            obj = (hb)obj;
            if (!b.equals(((hb) (obj)).b) || !c.equals(((hb) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, c
        });
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("PlaceEstimate{");
        for (int i = 0; i < b.length; i++)
        {
            stringbuilder.append(String.format("(%f, %s)", new Object[] {
                Float.valueOf(c[i]), b[i].toString()
            }));
            if (i != b.length - 1)
            {
                stringbuilder.append(",");
            }
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        ji.a(this, parcel, i);
    }

}
