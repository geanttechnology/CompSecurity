// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.FlurryFullscreenTakeoverActivity;

// Referenced classes of package com.flurry.sdk:
//            u, r, cv, fp, 
//            hp, i, n, cs

public class cu
{

    private static final String a = com/flurry/sdk/cu.getSimpleName();

    public cu()
    {
    }

    private static boolean a(Context context, Intent intent)
    {
        if (context == null || intent == null)
        {
            return false;
        }
        try
        {
            context.startActivity(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, r r1, String s, boolean flag, boolean flag1)
    {
        if (context == null)
        {
            return false;
        } else
        {
            Intent intent = new Intent(context, com/flurry/android/FlurryFullscreenTakeoverActivity);
            intent.putExtra("ad_object_legacy", r1 instanceof u);
            intent.putExtra("ad_object_id", r1.d());
            intent.putExtra("url", s);
            intent.putExtra("close_ad", flag);
            intent.putExtra("send_y_cookies", flag1);
            return a(context, intent);
        }
    }

    public static boolean a(Context context, r r1, boolean flag, boolean flag1)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return a(context, r1, null, flag, flag1);
        }
    }

    public static boolean a(Context context, String s)
    {
        while (context == null || TextUtils.isEmpty(s) || !cv.d(s)) 
        {
            return false;
        }
        return a(context, (new Intent("android.intent.action.VIEW")).setData(Uri.parse(s)));
    }

    public static boolean a(Context context, String s, r r1, boolean flag)
    {
        Intent intent = fp.a().e().getLaunchIntentForPackage(s);
        if (intent != null && hp.a(intent))
        {
            return a(context, intent);
        } else
        {
            return a(context, (new StringBuilder()).append("https://play.google.com/store/apps/details?id=").append(s).toString(), false, r1, true, flag);
        }
    }

    public static boolean a(Context context, String s, boolean flag)
    {
        if (context == null || TextUtils.isEmpty(s))
        {
            return false;
        }
        s = (new Intent("android.intent.action.VIEW")).setData(Uri.parse(s));
        if (flag)
        {
            Bundle bundle = new Bundle();
            bundle.putString("Cookie", i.a().h().d());
            s.putExtra("com.android.browser.headers", bundle);
        }
        return a(context, ((Intent) (s)));
    }

    public static boolean a(Context context, String s, boolean flag, r r1, boolean flag1, boolean flag2)
    {
label0:
        {
            boolean flag4 = false;
            if (cv.d(s))
            {
                flag4 = a(context, s);
            }
            boolean flag3 = flag4;
            if (!flag4)
            {
                flag3 = flag4;
                if (cv.f(s))
                {
                    flag3 = b(context, s);
                }
            }
            flag4 = flag3;
            if (!flag3)
            {
                if (!flag)
                {
                    break label0;
                }
                flag4 = a(context, s, flag2);
            }
            return flag4;
        }
        return a(context, r1, s, flag1, flag2);
    }

    public static boolean b(Context context, String s)
    {
        s = cs.a(context, s);
        boolean flag = false;
        if (s != null)
        {
            flag = a(context, s);
        }
        return flag;
    }

    public static boolean c(Context context, String s)
    {
        s = cs.a(context, s);
        if (s != null && hp.a(s))
        {
            return a(context, s);
        } else
        {
            return false;
        }
    }

}
