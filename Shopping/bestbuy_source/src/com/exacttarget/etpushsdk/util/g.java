// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            n

public class g
{

    private static final String TAG = "~!ue";
    private static String hashedId = null;

    public g()
    {
    }

    public static String uniqueDeviceIdentifier(Context context)
    {
        if (hashedId == null)
        {
            hashedId = "";
            hashedId = n.b((new StringBuilder()).append(android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id")).append("-").append(context.getPackageName()).toString());
        }
        return hashedId;
    }

}
