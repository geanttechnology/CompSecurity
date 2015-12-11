// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import a;
import android.app.PendingIntent;
import android.os.Parcel;
import awn;
import awp;
import ayd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class Status
    implements awn, SafeParcelable
{

    public static final awp CREATOR = new awp();
    public static final Status a = new Status(0);
    public static final Status b = new Status(15);
    public static final Status c = new Status(16);
    public final int d;
    public final int e;
    public final String f;
    public final PendingIntent g;

    public Status(int i)
    {
        this(i, null);
    }

    public Status(int i, int j, String s, PendingIntent pendingintent)
    {
        d = i;
        e = j;
        f = s;
        g = pendingintent;
    }

    private Status(int i, String s)
    {
        this(1, i, null, null);
    }

    public Status(int i, String s, PendingIntent pendingintent)
    {
        this(1, i, s, null);
    }

    public final boolean a()
    {
        return e <= 0;
    }

    public final Status a_()
    {
        return this;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof Status)
        {
            if (d == ((Status) (obj = (Status)obj)).d && e == ((Status) (obj)).e && a.e(f, ((Status) (obj)).f) && a.e(g, ((Status) (obj)).g))
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
        ayd ayd1 = a.c(this);
        if (f == null) goto _L2; else goto _L1
_L1:
        String s = f;
_L4:
        return ayd1.a("statusCode", s).a("resolution", g).toString();
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

        case 13: // '\r'
            s = "ERROR";
            break;

        case 14: // '\016'
            s = "INTERRUPTED";
            break;

        case 15: // '\017'
            s = "TIMEOUT";
            break;

        case 16: // '\020'
            s = "CANCELED";
            break;

        case 3000: 
            s = "AUTH_API_INVALID_CREDENTIALS";
            break;

        case 3001: 
            s = "AUTH_API_ACCESS_FORBIDDEN";
            break;

        case 3002: 
            s = "AUTH_API_CLIENT_ERROR";
            break;

        case 3003: 
            s = "AUTH_API_SERVER_ERROR";
            break;

        case 3004: 
            s = "AUTH_TOKEN_ERROR";
            break;

        case 3005: 
            s = "AUTH_URL_RESOLUTION";
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        awp.a(this, parcel, i);
    }

    static 
    {
        new Status(14);
        new Status(8);
    }
}
