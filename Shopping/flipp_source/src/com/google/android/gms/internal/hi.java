// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.internal:
//            jn, gw, gy

public class hi
    implements SafeParcelable
{

    public static final jn CREATOR = new jn();
    public final int a;
    public final String b;
    public final String c;

    public hi(int i, String s, String s1)
    {
        a = i;
        b = s;
        c = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof hi))
            {
                return false;
            }
            obj = (hi)obj;
            if (!c.equals(((hi) (obj)).c) || !b.equals(((hi) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            b, c
        });
    }

    public String toString()
    {
        return gw.a(this).a("clientPackageName", b).a("locale", c).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        jn.a(this, parcel);
    }

}
