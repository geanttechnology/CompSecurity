// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.facebook.d;
import com.facebook.f;
import com.facebook.i;
import com.facebook.j;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.facebook.internal:
//            o

public final class p
{

    private static final String a = com/facebook/internal/p.getName();

    public p()
    {
    }

    public static void a()
    {
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new f("This method should be called from the UI thread");
        } else
        {
            return;
        }
    }

    public static void a(Context context, boolean flag)
    {
        a(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1)
        {
            if (flag)
            {
                throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
            }
            Log.w(a, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
    }

    public static void a(Object obj, String s)
    {
        if (obj == null)
        {
            throw new NullPointerException((new StringBuilder()).append("Argument '").append(s).append("' cannot be null").toString());
        } else
        {
            return;
        }
    }

    public static void a(String s, String s1)
    {
        if (o.a(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Argument '").append(s1).append("' cannot be null or empty").toString());
        } else
        {
            return;
        }
    }

    public static void a(Collection collection, String s)
    {
        if (collection.isEmpty())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Container '").append(s).append("' cannot be empty").toString());
        } else
        {
            return;
        }
    }

    public static void b()
    {
        if (!i.a())
        {
            throw new j("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        } else
        {
            return;
        }
    }

    public static void b(Context context, boolean flag)
    {
        a(context, "context");
        PackageManager packagemanager = context.getPackageManager();
        Object obj = null;
        android.content.pm.ActivityInfo activityinfo = obj;
        if (packagemanager != null)
        {
            context = new ComponentName(context, com/facebook/d);
            try
            {
                activityinfo = packagemanager.getActivityInfo(context, 1);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                activityinfo = obj;
            }
        }
        if (activityinfo == null)
        {
            if (flag)
            {
                throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
            }
            Log.w(a, "FacebookActivity is not declared in the AndroidManifest.xml, please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
    }

    public static void b(Collection collection, String s)
    {
        a(collection, s);
        for (collection = collection.iterator(); collection.hasNext();)
        {
            if (collection.next() == null)
            {
                throw new NullPointerException((new StringBuilder()).append("Container '").append(s).append("' cannot contain null values").toString());
            }
        }

    }

    public static void c(Collection collection, String s)
    {
        b(collection, s);
        a(collection, s);
    }

}
