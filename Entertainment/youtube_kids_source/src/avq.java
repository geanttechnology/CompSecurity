// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.PendingIntent;

public final class avq
{

    public static final avq a = new avq(0, null);
    public final PendingIntent b;
    public final int c;

    public avq(int i, PendingIntent pendingintent)
    {
        c = i;
        b = pendingintent;
    }

    public final boolean a()
    {
        return c != 0 && b != null;
    }

    public final String toString()
    {
        ayd ayd1 = a.c(this);
        c;
        JVM INSTR lookupswitch 17: default 156
    //                   0: 196
    //                   1: 202
    //                   2: 208
    //                   3: 214
    //                   4: 220
    //                   5: 226
    //                   6: 232
    //                   7: 238
    //                   8: 244
    //                   9: 250
    //                   10: 256
    //                   11: 262
    //                   13: 268
    //                   14: 274
    //                   15: 280
    //                   16: 286
    //                   42: 292;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L1:
        String s = (new StringBuilder("unknown status code ")).append(c).toString();
_L20:
        return ayd1.a("statusCode", s).a("resolution", b).toString();
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
        continue; /* Loop/switch isn't completed */
_L14:
        s = "CANCELED";
        continue; /* Loop/switch isn't completed */
_L15:
        s = "TIMEOUT";
        continue; /* Loop/switch isn't completed */
_L16:
        s = "INTERRUPTED";
        continue; /* Loop/switch isn't completed */
_L17:
        s = "API_UNAVAILABLE";
        continue; /* Loop/switch isn't completed */
_L18:
        s = "UPDATE_ANDROID_WEAR";
        if (true) goto _L20; else goto _L19
_L19:
    }

}
