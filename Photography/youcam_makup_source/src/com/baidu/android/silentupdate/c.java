// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.silentupdate;

import android.app.Application;
import java.lang.reflect.Field;

class c
{

    c()
    {
    }

    public static void a(Application application, String s)
    {
        try
        {
            Object obj = Class.forName("android.content.ContextWrapper").getDeclaredField("mBase");
            ((Field) (obj)).setAccessible(true);
            application = ((Application) (((Field) (obj)).get(application)));
            obj = Class.forName("android.app.ContextImpl");
            ((Class) (obj)).getDeclaredField("mMainThread").setAccessible(true);
            obj = ((Class) (obj)).getDeclaredField("mPackageInfo");
            ((Field) (obj)).setAccessible(true);
            application = ((Application) (((Field) (obj)).get(application)));
            obj = Class.forName("android.app.LoadedApk");
            Field field = ((Class) (obj)).getDeclaredField("mResDir");
            field.setAccessible(true);
            field.set(application, s);
            s = ((Class) (obj)).getDeclaredField("mResources");
            s.setAccessible(true);
            s.set(application, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            application.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            application.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            application.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            application.printStackTrace();
        }
    }
}
