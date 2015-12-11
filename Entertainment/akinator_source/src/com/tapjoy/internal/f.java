// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package com.tapjoy.internal:
//            bn, de

public final class f extends BroadcastReceiver
{

    public static String a(Intent intent)
    {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction()))
        {
            return intent.getStringExtra("referrer");
        } else
        {
            return null;
        }
    }

    private static boolean a(Context context, String s, String s1)
    {
        String s2 = null;
        try
        {
            s = context.openFileOutput(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            de.a(s2);
            context.deleteFile("install_referrer");
            return false;
        }
        s2 = s;
        bn.a(s, s1);
        s2 = s;
        s.close();
        return true;
    }

    public final void onReceive(Context context, Intent intent)
    {
        intent = a(intent);
        if (intent != null)
        {
            a(context, "install_referrer", intent);
        }
    }
}
