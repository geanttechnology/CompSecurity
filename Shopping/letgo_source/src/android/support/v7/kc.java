// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookActivity;
import com.facebook.h;
import com.facebook.k;
import com.facebook.l;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package android.support.v7:
//            kb

public final class kc
{

    private static final String a = android/support/v7/kc.getName();

    public kc()
    {
    }

    public static void a()
    {
        if (!Looper.getMainLooper().equals(Looper.myLooper()))
        {
            throw new h("This method should be called from the UI thread");
        } else
        {
            return;
        }
    }

    public static void a(Context context)
    {
        a(context, true);
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
        if (kb.a(s))
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
        if (!k.a())
        {
            throw new l("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        } else
        {
            return;
        }
    }

    public static void b(Context context)
    {
        b(context, true);
    }

    public static void b(Context context, boolean flag)
    {
        a(context, "context");
        PackageManager packagemanager = context.getPackageManager();
        Object obj = null;
        android.content.pm.ActivityInfo activityinfo = obj;
        if (packagemanager != null)
        {
            context = new ComponentName(context, com/facebook/FacebookActivity);
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

    public static String c()
    {
        String s = k.i();
        if (s == null)
        {
            throw new IllegalStateException("No App ID found, please set the App ID.");
        } else
        {
            return s;
        }
    }

    public static void c(Context context)
    {
        a(context, "context");
        String s = c();
        context = context.getPackageManager();
        if (context != null)
        {
            s = (new StringBuilder()).append("com.facebook.app.FacebookContentProvider").append(s).toString();
            if (context.resolveContentProvider(s, 0) == null)
            {
                throw new IllegalStateException(String.format("A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", new Object[] {
                    s
                }));
            }
        }
    }

    public static void c(Collection collection, String s)
    {
        b(collection, s);
        a(collection, s);
    }

}
