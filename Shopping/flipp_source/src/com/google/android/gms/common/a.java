// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common;

import android.app.PendingIntent;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gy;

public final class a
{

    public static final a a = new a(0, null);
    private final PendingIntent b;
    private final int c;

    public a(int i, PendingIntent pendingintent)
    {
        c = i;
        b = pendingintent;
    }

    public final String toString()
    {
        gy gy1 = gw.a(this);
        c;
        JVM INSTR tableswitch 0 11: default 72
    //                   0 112
    //                   1 118
    //                   2 124
    //                   3 130
    //                   4 136
    //                   5 142
    //                   6 148
    //                   7 154
    //                   8 160
    //                   9 166
    //                   10 172
    //                   11 178;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        String s = (new StringBuilder("unknown status code ")).append(c).toString();
_L15:
        return gy1.a("statusCode", s).a("resolution", b).toString();
_L2:
        s = "SUCCESS";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "SERVICE_MISSING";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "SERVICE_VERSION_UPDATE_REQUIRED";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "SERVICE_DISABLED";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "SIGN_IN_REQUIRED";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "INVALID_ACCOUNT";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "RESOLUTION_REQUIRED";
        continue; /* Loop/switch isn't completed */
_L9:
        s = "NETWORK_ERROR";
        continue; /* Loop/switch isn't completed */
_L10:
        s = "INTERNAL_ERROR";
        continue; /* Loop/switch isn't completed */
_L11:
        s = "SERVICE_INVALID";
        continue; /* Loop/switch isn't completed */
_L12:
        s = "DEVELOPER_ERROR";
        continue; /* Loop/switch isn't completed */
_L13:
        s = "LICENSE_CHECK_FAILED";
        if (true) goto _L15; else goto _L14
_L14:
    }

}
