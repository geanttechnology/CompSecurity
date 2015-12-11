// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ee;

// Referenced classes of package com.google.android.gms.location:
//            e

public class d
    implements SafeParcelable
{

    public static final e CREATOR = new e();
    private final int kg;
    int xG;
    int xH;
    long xI;

    d(int i, int j, int k, long l)
    {
        kg = i;
        xG = j;
        xH = k;
        xI = l;
    }

    private String aQ(int i)
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

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof d)
        {
            if (xG == ((d) (obj = (d)obj)).xG && xH == ((d) (obj)).xH && xI == ((d) (obj)).xI)
            {
                return true;
            }
        }
        return false;
    }

    int getVersionCode()
    {
        return kg;
    }

    public int hashCode()
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(xG), Integer.valueOf(xH), Long.valueOf(xI)
        });
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("LocationStatus[cell status: ").append(aQ(xG));
        stringbuilder.append(", wifi status: ").append(aQ(xH));
        stringbuilder.append(", elapsed realtime ns: ").append(xI);
        stringbuilder.append(']');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        e.a(this, parcel, i);
    }

}
