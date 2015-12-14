// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;
import java.net.URI;

// Referenced classes of package com.perfectcorp.utility:
//            e, u

public class g
{

    public static void a(Activity activity, Uri uri)
    {
        if (uri != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!a(Globals.n().getApplicationContext(), "com.cyberlink.youcammakeup"))
        {
            DialogUtils.a(activity);
            return;
        }
        if (activity == null) goto _L1; else goto _L3
_L3:
        Object obj;
        String s;
        String s1;
        String s2;
        try
        {
            s = uri.getScheme();
            s1 = activity.getResources().getString(m.bc_scheme);
            s2 = activity.getResources().getString(m.bc_appscheme);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            DialogUtils.a(activity);
            return;
        }
        obj = uri;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = uri;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = uri;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        obj = uri;
        if (s.equals(s1))
        {
            uri = new URI(s2, uri.getSchemeSpecificPart(), uri.getFragment());
            e.b(new Object[] {
                (new StringBuilder()).append("New DeepLink : ").append(uri.toString()).toString()
            });
            obj = Uri.parse(uri.toString());
        }
        uri = new Intent("android.intent.action.VIEW", ((Uri) (obj)));
        obj = activity.getResources().getString(m.bc_appscheme);
        obj = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append(((String) (obj))).append("://").append(activity.getResources().getString(m.bc_host_resume)).toString()));
        uri.putExtra(activity.getResources().getString(m.BACK_TARGET_INTENT), ((android.os.Parcelable) (obj)));
        activity.startActivity(uri);
        return;
    }

    public static boolean a(Activity activity, String s, String s1, String s2)
    {
        u u1 = new u("market://details");
        u1.a("id", s);
        u1.a("referer", (new StringBuilder()).append("utm_source%3D").append(s1).append("%26utm_medium%3D").append(s2).toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(u1.c()));
        try
        {
            activity.startActivity(intent);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            u u2 = new u("http://play.google.com/store/apps/details");
            u1.a("id", s);
            u1.a("referer", (new StringBuilder()).append("utm_source%3D").append(s1).append("%26utm_medium%3D").append(s2).toString());
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(u2.c())));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String s)
    {
        if (s == null)
        {
            return false;
        }
        String s1 = context.getPackageName();
        if (s1 != null && s1.equals(s))
        {
            return true;
        }
        context = context.getPackageManager();
        try
        {
            context.getPackageInfo(s, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        catch (Exception exception)
        {
            try
            {
                context.getPackageGids(s);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return true;
        }
        return true;
    }
}
