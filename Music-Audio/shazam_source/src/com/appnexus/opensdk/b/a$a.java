// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.appnexus.opensdk.b:
//            a, j

private static final class <init> extends AsyncTask
{

    private WeakReference a;

    private transient Pair a()
    {
        Object obj;
        Boolean boolean1 = Boolean.valueOf(false);
        Object obj1;
        Object obj2;
        Object obj3;
        Class class1;
        Method method;
        try
        {
            obj3 = (Context)a.get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        if (obj3 == null) goto _L2; else goto _L1
_L1:
        class1 = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
        method = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[] {
            android/content/Context
        });
        obj = class1.getMethod("getId", new Class[0]);
        obj1 = class1.getMethod("isLimitAdTrackingEnabled", new Class[0]);
        obj3 = class1.cast(method.invoke(null, new Object[] {
            obj3
        }));
        obj = (String)((Method) (obj)).invoke(obj3, new Object[0]);
        try
        {
            obj1 = (Boolean)((Method) (obj1)).invoke(obj3, new Object[0]);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean1 = ((Boolean) (obj1));
_L4:
        return new Pair(obj, boolean1);
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Pair)obj;
        super.onPostExecute(obj);
        String s = (String)((Pair) (obj)).first;
        boolean flag = ((Boolean)((Pair) (obj)).second).booleanValue();
        j.a().d = s;
        j.a().e = flag;
    }

    private ion(Context context)
    {
        a = new WeakReference(context);
    }

    (Context context, byte byte0)
    {
        this(context);
    }
}
