// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.firegnom.rat.util.DialogUtils;
import com.socialin.android.util.s;
import io.branch.referral.g;
import io.branch.referral.m;
import io.branch.referral.p;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class d
{

    private static final String a = myobfuscated/cy/d.getSimpleName();
    private static String b = null;

    private d()
    {
    }

    private static Bundle a(String s1)
    {
        Bundle bundle = new Bundle();
        if (s1 != null)
        {
            s1 = s1.split("&");
            int j = s1.length;
            for (int i = 0; i < j; i++)
            {
                String as[] = s1[i].split("=");
                bundle.putString(as[0], as[1]);
            }

        }
        return bundle;
    }

    public static Bundle a(String s1, String s2)
    {
        s1 = s1.replace(s2, "http");
        try
        {
            s1 = new URL(s1);
            s2 = a(s1.getQuery());
            s2.putAll(a(s1.getRef()));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.socialin.android.d.a("parseUrl", s1);
            return new Bundle();
        }
        return s2;
    }

    public static String a(Context context, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s2 = context.getString(0x7f080952);
        if (b == null)
        {
            b = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808c0)).append("/").append(s2).append("/").toString();
        }
        return stringbuilder.append(b).append(s1).append("_thumb").toString();
    }

    public static void a(Activity activity)
    {
        if (activity != null && !activity.isFinishing())
        {
            activity.runOnUiThread(new Runnable(activity) {

                private Activity a;

                public final void run()
                {
                    DialogUtils.showNoNetworkDialog(a, 0x7f080307, 0x7f080306, 0x7f080308, 0x7f0802a4, 0x108009b);
                }

            
            {
                a = activity;
                super();
            }
            });
        }
    }

    public static void a(Activity activity, String s1, long l, g g1)
    {
        a(((Context) (activity)), s1, activity.getString(0x7f0808b3), l, g1);
    }

    public static void a(Context context)
    {
        try
        {
            CookieSyncManager.createInstance(context);
            CookieManager.getInstance().removeAllCookie();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(a, new Object[] {
                "clearCookies", context
            });
        }
    }

    public static void a(Context context, String s1, String s2, long l, g g1)
    {
        if (context != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JSONObject jsonobject;
        if (!s.a(context) && g1 != null)
        {
            g1.a(s2, null);
            return;
        }
        jsonobject = new JSONObject();
        jsonobject.put("platform", "android");
        jsonobject.put("app_name", context.getString(0x7f0808ad));
        jsonobject.put("from_urls", true);
        if (l <= 0L) goto _L4; else goto _L3
_L3:
        jsonobject.put("hook_action", (new StringBuilder("picsart://photos?id=")).append(l).toString());
_L8:
        jsonobject.put("type", 0);
        jsonobject.put("$og_title", context.getString(0x7f0803aa));
        jsonobject.put("$og_description", context.getString(0x7f0803a8, new Object[] {
            ""
        }));
        if ("fb_messenger".equals(s1) || "facebook".equals(s1))
        {
            jsonobject.put("$og_image_url", context.getString(0x7f08091c));
        }
        if (l <= 0L) goto _L6; else goto _L5
_L5:
        Object obj = (new StringBuilder("http://picsart.com/i/")).append(l).toString();
_L10:
        jsonobject.put("$desktop_url", obj);
        jsonobject.put("version", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
_L11:
        jsonobject.put("$always_deeplink", true);
_L9:
        com.socialin.android.d.a(a, jsonobject.toString());
        try
        {
            (new p(context)).a(jsonobject).a(s1).a(0).b("share").a(new g(g1, s2) {

                private g a;
                private String b;

                public final void a(String s3, m m)
                {
                    if (a != null)
                    {
                        if (TextUtils.isEmpty(s3))
                        {
                            s3 = b;
                        }
                        a.a(s3, m);
                    }
                }

            
            {
                a = g1;
                b = s1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (g1 == null) goto _L1; else goto _L7
_L7:
        g1.a(s2, null);
        return;
_L4:
        jsonobject.put("hook_action", "picsart://");
          goto _L8
        obj;
        com.socialin.android.d.b(a, "generateShareURL", ((Throwable) (obj)));
          goto _L9
_L6:
        obj = "http://picsart.com";
          goto _L10
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(namenotfoundexception.getMessage()).toString()
        });
          goto _L11
    }

}
