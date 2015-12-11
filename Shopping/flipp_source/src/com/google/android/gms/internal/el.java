// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            he, gw

public final class el
    implements SafeParcelable
{

    public static final he CREATOR = new he();
    final int a;
    final int b;
    final int c;
    final String d;
    final String e;
    final String f;
    final String g;
    final Bundle h;

    el(int i, int j, int k, String s, String s1, String s2, String s3, 
            Bundle bundle)
    {
        a = i;
        b = j;
        c = k;
        d = s;
        e = s1;
        f = s2;
        g = s3;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        h = bundle;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof el)
        {
            if (a == ((el) (obj = (el)obj)).a && b == ((el) (obj)).b && c == ((el) (obj)).c && gw.a(d, ((el) (obj)).d) && gw.a(e, ((el) (obj)).e))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(a), Integer.valueOf(b), Integer.valueOf(c), d, e
        });
    }

    public final String toString()
    {
        boolean flag;
        if (b == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return String.format("Person [%s] %s", new Object[] {
                e, f
            });
        }
        if (b == 1 && c == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return String.format("Circle [%s] %s", new Object[] {
                d, f
            });
        } else
        {
            return String.format("Group [%s] %s", new Object[] {
                d, f
            });
        }
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        he.a(this, parcel);
    }

}
