// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.a.c;
import android.util.Log;

public final class q
{
    static interface a
    {

        public abstract Intent a(Activity activity);

        public abstract String a(Context context, ActivityInfo activityinfo);

        public abstract boolean a(Activity activity, Intent intent);

        public abstract void b(Activity activity, Intent intent);
    }

    static class b
        implements a
    {

        public Intent a(Activity activity)
        {
            String s = android.support.v4.app.q.c(activity);
            if (s == null)
            {
                return null;
            }
            ComponentName componentname = new ComponentName(activity, s);
            try
            {
                if (q.b(activity, componentname) == null)
                {
                    return android.support.v4.a.c.a(componentname);
                }
                activity = (new Intent()).setComponent(componentname);
            }
            // Misplaced declaration of an exception variable
            catch (Activity activity)
            {
                Log.e("NavUtils", (new StringBuilder("getParentActivityIntent: bad parentActivityName '")).append(s).append("' in manifest").toString());
                return null;
            }
            return activity;
        }

        public String a(Context context, ActivityInfo activityinfo)
        {
            if (activityinfo.metaData == null)
            {
                activityinfo = null;
            } else
            {
                String s = activityinfo.metaData.getString("android.support.PARENT_ACTIVITY");
                if (s == null)
                {
                    return null;
                }
                activityinfo = s;
                if (s.charAt(0) == '.')
                {
                    return (new StringBuilder()).append(context.getPackageName()).append(s).toString();
                }
            }
            return activityinfo;
        }

        public boolean a(Activity activity, Intent intent)
        {
            activity = activity.getIntent().getAction();
            return activity != null && !activity.equals("android.intent.action.MAIN");
        }

        public void b(Activity activity, Intent intent)
        {
            intent.addFlags(0x4000000);
            activity.startActivity(intent);
            activity.finish();
        }

        b()
        {
        }
    }

    static final class c extends b
    {

        public final Intent a(Activity activity)
        {
            Intent intent1 = activity.getParentActivityIntent();
            Intent intent = intent1;
            if (intent1 == null)
            {
                intent = super.a(activity);
            }
            return intent;
        }

        public final String a(Context context, ActivityInfo activityinfo)
        {
            String s1 = activityinfo.parentActivityName;
            String s = s1;
            if (s1 == null)
            {
                s = super.a(context, activityinfo);
            }
            return s;
        }

        public final boolean a(Activity activity, Intent intent)
        {
            return activity.shouldUpRecreateTask(intent);
        }

        public final void b(Activity activity, Intent intent)
        {
            activity.navigateUpTo(intent);
        }

        c()
        {
        }
    }


    private static final a a;

    public static Intent a(Context context, ComponentName componentname)
    {
        String s = b(context, componentname);
        if (s == null)
        {
            return null;
        }
        componentname = new ComponentName(componentname.getPackageName(), s);
        if (b(context, componentname) == null)
        {
            return android.support.v4.a.c.a(componentname);
        } else
        {
            return (new Intent()).setComponent(componentname);
        }
    }

    public static void a(Activity activity)
    {
        Intent intent = b(activity);
        if (intent == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Activity ")).append(activity.getClass().getSimpleName()).append(" does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)").toString());
        } else
        {
            b(activity, intent);
            return;
        }
    }

    public static boolean a(Activity activity, Intent intent)
    {
        return a.a(activity, intent);
    }

    public static Intent b(Activity activity)
    {
        return a.a(activity);
    }

    public static String b(Context context, ComponentName componentname)
    {
        componentname = context.getPackageManager().getActivityInfo(componentname, 128);
        return a.a(context, componentname);
    }

    public static void b(Activity activity, Intent intent)
    {
        a.b(activity, intent);
    }

    public static String c(Activity activity)
    {
        try
        {
            activity = b(activity, activity.getComponentName());
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new IllegalArgumentException(activity);
        }
        return activity;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
