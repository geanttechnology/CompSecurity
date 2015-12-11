// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.io.IOException;

public final class atz
{

    private static String a = "androidPackageName";
    private static final ComponentName b;
    private static final ComponentName c;
    private static final Intent d;

    public static String a(Context context, String s, String s1)
    {
        return a(context, s, s1, new Bundle());
    }

    private static String a(Context context, String s, String s1, Bundle bundle)
    {
        Context context1;
        context1 = context.getApplicationContext();
        a.i("Calling this from your main thread can lead to deadlock");
        boolean flag1;
        try
        {
            avw.b(context1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aua(((avv) (context)).a, context.getMessage(), new Intent(((avy) (context)).b));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new aty(context.getMessage());
        }
        bundle = new Bundle(bundle);
        context = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", context);
        if (!bundle.containsKey(a))
        {
            bundle.putString(a, context);
        }
        context = new avz();
        if (!context1.bindService(d, context, 1))
        {
            break MISSING_BLOCK_LABEL_434;
        }
        s = bbj.a(context.a()).a(s, s1, bundle);
        s1 = s.getString("authtoken");
        flag1 = TextUtils.isEmpty(s1);
        if (!flag1)
        {
            context1.unbindService(context);
            return s1;
        }
        s1 = s.getString("Error");
        s = (Intent)s.getParcelable("userRecoveryIntent");
        boolean flag;
        if (!"BadAuthentication".equals(s1) && !"CaptchaRequired".equals(s1) && !"DeviceManagementRequiredOrSyncDisabled".equals(s1) && !"NeedPermission".equals(s1) && !"NeedsBrowser".equals(s1) && !"UserCancel".equals(s1) && !"AppDownloadRequired".equals(s1) && !auc.a.g.equals(s1) && !auc.b.g.equals(s1) && !auc.c.g.equals(s1) && !auc.d.g.equals(s1) && !auc.e.g.equals(s1) && !auc.f.g.equals(s1))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        throw new aub(s1, s);
        s;
        throw new IOException("remote exception");
        s;
        context1.unbindService(context);
        throw s;
        if (!"NetworkError".equals(s1) && !"ServiceUnavailable".equals(s1) && !"Timeout".equals(s1))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        throw new IOException(s1);
        s;
        throw new aty("Interrupted");
        throw new aty(s1);
        throw new IOException("Could not bind to service with the given context.");
    }

    public static void a(Context context, String s)
    {
        AccountManager.get(context).invalidateAuthToken("com.google", s);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        i = android.os.Build.VERSION.SDK_INT;
        b = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        c = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        d = (new Intent()).setPackage("com.google.android.gms").setComponent(b);
        (new Intent()).setPackage("com.google.android.gms").setComponent(c);
    }
}
