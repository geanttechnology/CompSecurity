// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import adv;
import aij;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e
    implements SafeParcelable
{

    public static final aij CREATOR = new aij();
    public int a;
    public int b;
    public long c;
    private final int d;

    public e(int i, int j, int k, long l)
    {
        d = i;
        a = j;
        b = k;
        c = l;
    }

    private String a(int i)
    {
        switch (i)
        {
        case 1: // '\001'
        default:
            return "STATUS_UNKNOWN";

        case 0: // '\0'
            return "STATUS_SUCCESSFUL";

        case 2: // '\002'
            return "STATUS_TIMED_OUT_ON_SCAN";

        case 3: // '\003'
            return "STATUS_NO_INFO_IN_DATABASE";

        case 4: // '\004'
            return "STATUS_INVALID_SCAN";

        case 5: // '\005'
            return "STATUS_UNABLE_TO_QUERY_DATABASE";

        case 6: // '\006'
            return "STATUS_SCANS_DISABLED_IN_SETTINGS";

        case 7: // '\007'
            return "STATUS_LOCATION_DISABLED_IN_SETTINGS";

        case 8: // '\b'
            return "STATUS_IN_PROGRESS";
        }
    }

    public int a()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof e)
        {
            if (a == ((e) (obj = (e)obj)).a && b == ((e) (obj)).b && c == ((e) (obj)).c)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return adv.a(new Object[] {
            Integer.valueOf(a), Integer.valueOf(b), Long.valueOf(c)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("LocationStatus[cell status: ").append(a(a));
        stringbuilder.append(", wifi status: ").append(a(b));
        stringbuilder.append(", elapsed realtime ns: ").append(c);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        aij.a(this, parcel, i);
    }

}
