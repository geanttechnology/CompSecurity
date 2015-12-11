// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;
import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.api:
//            d

public final class Status
    implements SafeParcelable
{

    public static final d CREATOR = new d();
    public static final Status a = new Status(0);
    public static final Status b = new Status(14);
    public static final Status c = new Status(15);
    final int d;
    final int e;
    final String f;
    final PendingIntent g;

    private Status(int i)
    {
        this(1, i, null, null);
    }

    Status(int i, int j, String s, PendingIntent pendingintent)
    {
        d = i;
        e = j;
        f = s;
        g = pendingintent;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (d == ((Status) (obj = (Status)obj)).d && e == ((Status) (obj)).e && gw.a(f, ((Status) (obj)).f) && gw.a(g, ((Status) (obj)).g))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Integer.valueOf(d), Integer.valueOf(e), f, g
        });
    }

    public final String toString()
    {
        gy gy1 = gw.a(this);
        if (f == null) goto _L2; else goto _L1
_L1:
        String s = f;
_L4:
        return gy1.a("statusCode", s).a("resolution", g).toString();
_L2:
        int i = e;
        switch (i)
        {
        default:
            s = (new StringBuilder("unknown status code: ")).append(i).toString();
            break;

        case -1: 
            s = "SUCCESS_CACHE";
            break;

        case 0: // '\0'
            s = "SUCCESS";
            break;

        case 1: // '\001'
            s = "SERVICE_MISSING";
            break;

        case 2: // '\002'
            s = "SERVICE_VERSION_UPDATE_REQUIRED";
            break;

        case 3: // '\003'
            s = "SERVICE_DISABLED";
            break;

        case 4: // '\004'
            s = "SIGN_IN_REQUIRED";
            break;

        case 5: // '\005'
            s = "INVALID_ACCOUNT";
            break;

        case 6: // '\006'
            s = "RESOLUTION_REQUIRED";
            break;

        case 7: // '\007'
            s = "NETWORK_ERROR";
            break;

        case 8: // '\b'
            s = "INTERNAL_ERROR";
            break;

        case 9: // '\t'
            s = "SERVICE_INVALID";
            break;

        case 10: // '\n'
            s = "DEVELOPER_ERROR";
            break;

        case 11: // '\013'
            s = "LICENSE_CHECK_FAILED";
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.api.d.a(this, parcel, i);
    }

}
