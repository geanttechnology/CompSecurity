// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager

private static final class <init> extends y
{

    public ActivityShimManager createShimManager(Activity activity)
    {
        Object obj1 = null;
        ApplicationInfo applicationinfo = obj1;
        if (ActivityShimManager.access$400() != null)
        {
            ActivityShimManager.access$400().nitForUi();
            applicationinfo = obj1;
            if (ActivityShimManager.access$400() instanceof Context)
            {
                applicationinfo = ((Context)ActivityShimManager.access$400()).getApplicationInfo();
            }
        }
        if (applicationinfo != null && (applicationinfo.flags & 2) != 0)
        {
            try
            {
                Field field = com/ebay/nautilus/kernel/util/FwLog$LogInfo.getDeclaredField("isLoggable");
                field.setAccessible(true);
                field.setBoolean(ActivityShimManager.logLifecycle, true);
                field.setBoolean(ActivityShimManager.logCommonCallbacks, true);
                field.setAccessible(false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((NoSuchFieldException) (obj)).printStackTrace();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IllegalAccessException) (obj)).printStackTrace();
            }
        }
        if (ActivityShimManager.logLifecycle.)
        {
            Object obj;
            if (ActivityShimManager.logCommonCallbacks.)
            {
                obj = com/ebay/nautilus/shell/app/ActivityShimManager$VerboseLogShim;
            } else
            {
                obj = com/ebay/nautilus/shell/app/ActivityShimManager$LogShim;
            }
            if (shimClasses == null)
            {
                addActivityShimClass(((Class) (obj)));
            } else
            {
                shimClasses.add(0, obj);
            }
        }
        return super.createShimManager(activity);
    }

    private y()
    {
    }

    y(y y)
    {
        this();
    }
}
