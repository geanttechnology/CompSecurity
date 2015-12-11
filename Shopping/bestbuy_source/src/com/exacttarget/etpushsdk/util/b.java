// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;
import android.os.Build;
import com.exacttarget.etpushsdk.ETException;
import java.lang.reflect.Method;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            j, m

public class b
{

    private static Boolean a = Boolean.valueOf(false);

    public static boolean a()
    {
        return Build.MANUFACTURER.equals("Amazon");
    }

    public static boolean a(Context context)
    {
        if (a()) goto _L2; else goto _L1
_L1:
        a = Boolean.valueOf(false);
_L4:
        return a.booleanValue();
_L2:
        try
        {
            Class.forName("com.amazon.device.messaging.ADM");
            b(context);
            a = Boolean.TRUE;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            m.d("~!ub", "Amazon ADM API's not found.");
            a = Boolean.FALSE;
        }
        catch (Exception exception)
        {
            m.d("~!ub", exception.getMessage());
            a = Boolean.FALSE;
        }
        if (!a.booleanValue())
        {
            j.a(context, "Amazon Device Messaging not available.", false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void b(Context context)
    {
        try
        {
            Class.forName("com.amazon.device.messaging.development.ADMManifest").getDeclaredMethod("checkManifestAuthoredProperly", new Class[] {
                android/content/Context
            }).invoke(null, new Object[] {
                context
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!ub", context.getMessage(), context);
            throw new ETException("~!ub unable to find com.amazon.device.messaging.development.ADMManifest");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!ub", context.getMessage(), context);
        }
        throw new ETException(context.getCause().getMessage());
    }

}
