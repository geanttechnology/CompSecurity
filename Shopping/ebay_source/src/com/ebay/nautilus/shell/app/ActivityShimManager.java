// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwActivity, ActivityShim, BaseActivity

public class ActivityShimManager
{
    private static final class Collection extends ActivityShimManager
    {

        final List shims;

        public ActivityShim getShim(Class class1)
        {
            if (class1 != com/ebay/nautilus/shell/app/ActivityShim) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            ActivityShim activityshim;
            Iterator iterator = shims.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                activityshim = (ActivityShim)iterator.next();
            } while (!class1.isInstance(activityshim));
            break; /* Loop/switch isn't completed */
            if (true) goto _L1; else goto _L3
_L3:
            return (ActivityShim)class1.cast(activityshim);
        }

        public void onActivityResult(int i, int j, Intent intent)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onActivityResult(i, j, intent)) { }
        }

        public void onConfigurationChanged(Configuration configuration)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onConfigurationChanged(configuration)) { }
        }

        public void onContentChanged()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onContentChanged()) { }
        }

        public void onCreate(Bundle bundle)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onCreate(bundle)) { }
        }

        public void onDestroy()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onDestroy()) { }
        }

        public void onPause()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onPause()) { }
        }

        public void onPostCreate(Bundle bundle)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onPostCreate(bundle)) { }
        }

        public void onPostResume()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onPostResume()) { }
        }

        public void onRestart()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onRestart()) { }
        }

        public void onRestoreInstanceState(Bundle bundle)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onRestoreInstanceState(bundle)) { }
        }

        public void onResume()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onResume()) { }
        }

        public void onSaveInstanceState(Bundle bundle)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onSaveInstanceState(bundle)) { }
        }

        public void onStart()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onStart()) { }
        }

        public void onStop()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onStop()) { }
        }

        public void onWindowFocusChanged(boolean flag)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).onWindowFocusChanged(flag)) { }
        }

        public void preOnCreate(Bundle bundle)
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnCreate(bundle)) { }
        }

        public void preOnDestroy()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnDestroy()) { }
        }

        public void preOnPause()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnPause()) { }
        }

        public void preOnRestart()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnRestart()) { }
        }

        public void preOnResume()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnResume()) { }
        }

        public void preOnStart()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnStart()) { }
        }

        public void preOnStop()
        {
            for (Iterator iterator = shims.iterator(); iterator.hasNext(); ((ActivityShim)iterator.next()).preOnStop()) { }
        }

        Collection(Activity activity1, List list)
        {
            super(activity1);
            ArrayList arraylist = new ArrayList(list.size());
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                activity1 = (Class)list.next();
                try
                {
                    ActivityShim activityshim = (ActivityShim)activity1.newInstance();
                    activityshim.setManager(this);
                    arraylist.add(activityshim);
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    activity1 = new IllegalAccessError((new StringBuilder()).append(activity1.getName()).append(" does not have a public constructor!").toString());
                    activity1.initCause(list);
                    throw activity1;
                }
                // Misplaced declaration of an exception variable
                catch (List list)
                {
                    activity1 = new IllegalAccessError((new StringBuilder()).append("Can't construct ").append(activity1.getName()).append('!').toString());
                    activity1.initCause(list);
                    throw activity1;
                }
            } while (true);
            shims = Collections.unmodifiableList(arraylist);
        }
    }

    private static final class DefaultShimFactory extends Factory
    {

        public ActivityShimManager createShimManager(Activity activity1)
        {
            return new ActivityShimManager(activity1);
        }

        public void removeActivityShimClass(Class class1)
        {
            ActivityShimManager.factory = new ReinitShimFactory();
        }

        private DefaultShimFactory()
        {
        }

    }

    private static abstract class Factory
    {

        public void addActivityShimClass(Class class1)
        {
            throw new UnsupportedOperationException("You must add all the shims before any activity is created! Look at ActivityShimManager.addActivityShimClass().");
        }

        public abstract ActivityShimManager createShimManager(Activity activity1);

        public abstract void removeActivityShimClass(Class class1);

        private Factory()
        {
        }

    }

    private static final class InitShimFactory extends ReinitShimFactory
    {

        public ActivityShimManager createShimManager(Activity activity1)
        {
            Object obj1 = null;
            ApplicationInfo applicationinfo = obj1;
            if (ActivityShimManager.initUiCallback != null)
            {
                ActivityShimManager.initUiCallback.initForUi();
                applicationinfo = obj1;
                if (ActivityShimManager.initUiCallback instanceof Context)
                {
                    applicationinfo = ((Context)ActivityShimManager.initUiCallback).getApplicationInfo();
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
            if (ActivityShimManager.logLifecycle.isLoggable)
            {
                Object obj;
                if (ActivityShimManager.logCommonCallbacks.isLoggable)
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
            return super.createShimManager(activity1);
        }

        private InitShimFactory()
        {
        }

    }

    public static interface InitUiCallback
    {

        public abstract void initForUi();
    }

    static class LogShim extends ActivityShim
    {

        protected final transient void logMethod(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, Object aobj[])
        {
            BaseActivity.logMethodInfo(loginfo, getActivity().getClass(), 6, aobj);
        }

        protected void preOnCreate(Bundle bundle)
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[] {
                bundle
            });
        }

        protected void preOnDestroy()
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[0]);
        }

        protected void preOnPause()
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[0]);
        }

        protected void preOnRestart()
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[0]);
        }

        protected void preOnResume()
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[0]);
        }

        protected void preOnStart()
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[0]);
        }

        protected void preOnStop()
        {
            logMethod(ActivityShimManager.logLifecycle, new Object[0]);
        }

        LogShim()
        {
        }
    }

    private static final class MultiShimFactory extends Factory
    {

        private final List shimClasses;

        public ActivityShimManager createShimManager(Activity activity1)
        {
            return new Collection(activity1, shimClasses);
        }

        public void removeActivityShimClass(Class class1)
        {
            ActivityShimManager.factory = new ReinitShimFactory(shimClasses);
            ActivityShimManager.factory.removeActivityShimClass(class1);
        }

        public MultiShimFactory(List list)
        {
            shimClasses = list;
        }
    }

    private static class ReinitShimFactory extends Factory
    {

        protected ArrayList shimClasses;

        public void addActivityShimClass(Class class1)
        {
            if (class1 == null)
            {
                throw new NullPointerException("c");
            }
            if (shimClasses == null)
            {
                shimClasses = new ArrayList();
            }
            shimClasses.add(class1);
        }

        public ActivityShimManager createShimManager(Activity activity1)
        {
            if (shimClasses == null)
            {
                ActivityShimManager.factory = new DefaultShimFactory();
            } else
            {
                ActivityShimManager.factory = new MultiShimFactory(Collections.unmodifiableList(shimClasses));
            }
            return ActivityShimManager.factory.createShimManager(activity1);
        }

        public void removeActivityShimClass(Class class1)
        {
            if (class1 == null)
            {
                throw new NullPointerException("c");
            }
            if (shimClasses == null) goto _L2; else goto _L1
_L1:
            int i = shimClasses.size();
_L5:
            int j = i - 1;
            if (i <= 0) goto _L4; else goto _L3
_L3:
            if (class1.isAssignableFrom((Class)shimClasses.get(j)))
            {
                shimClasses.remove(j);
                i = j;
            } else
            {
                i = j;
            }
            if (true) goto _L5; else goto _L4
_L4:
            if (shimClasses.isEmpty())
            {
                shimClasses = null;
            }
_L2:
        }

        public ReinitShimFactory()
        {
            this(null);
        }

        public ReinitShimFactory(List list)
        {
            Object obj = null;
            super();
            if (list == null)
            {
                list = obj;
            } else
            {
                list = new ArrayList(list);
            }
            shimClasses = list;
        }
    }

    static final class VerboseLogShim extends LogShim
    {

        protected void onActivityResult(int i, int j, Intent intent)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), intent
            });
        }

        protected void onConfigurationChanged(Configuration configuration)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                configuration
            });
        }

        protected void onContentChanged()
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[0]);
        }

        protected void onPostCreate(Bundle bundle)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                bundle
            });
        }

        protected void onPostResume()
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[0]);
        }

        protected void onRestoreInstanceState(Bundle bundle)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                bundle
            });
        }

        protected void onSaveInstanceState(Bundle bundle)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                bundle
            });
        }

        VerboseLogShim()
        {
        }
    }


    private static Factory factory = new InitShimFactory();
    private static InitUiCallback initUiCallback = null;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logCommonCallbacks;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logLifecycle;
    protected final Activity activity;

    ActivityShimManager(Activity activity1)
    {
        activity = activity1;
    }

    public static void addActivityShimClass(Class class1)
    {
        factory.addActivityShimClass(class1);
    }

    public static ActivityShimManager createShimManager(Activity activity1)
    {
        return factory.createShimManager(activity1);
    }

    public static void debugRemoveActivityShimClass(Class class1)
    {
        factory.removeActivityShimClass(class1);
    }

    public static void setInitUiCallback(InitUiCallback inituicallback)
    {
        initUiCallback = inituicallback;
    }

    public final Activity getActivity()
    {
        return activity;
    }

    public final FwActivity getFwActivity()
    {
        return (FwActivity)activity;
    }

    public ActivityShim getShim(Class class1)
    {
        return null;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onContentChanged()
    {
    }

    public void onCreate(Bundle bundle)
    {
    }

    public void onDestroy()
    {
    }

    public void onPause()
    {
    }

    public void onPostCreate(Bundle bundle)
    {
    }

    public void onPostResume()
    {
    }

    public void onRestart()
    {
    }

    public void onRestoreInstanceState(Bundle bundle)
    {
    }

    public void onResume()
    {
    }

    public void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStart()
    {
    }

    public void onStop()
    {
    }

    public void onWindowFocusChanged(boolean flag)
    {
    }

    public void preOnCreate(Bundle bundle)
    {
    }

    public void preOnDestroy()
    {
    }

    public void preOnPause()
    {
    }

    public void preOnRestart()
    {
    }

    public void preOnResume()
    {
    }

    public void preOnStart()
    {
    }

    public void preOnStop()
    {
    }

    static 
    {
        logLifecycle = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("appLifecycle", 3, "Log application lifecycle");
        logCommonCallbacks = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(logLifecycle.tag, 2, "Log verbose application interaction");
    }



/*
    static Factory access$202(Factory factory1)
    {
        factory = factory1;
        return factory1;
    }

*/

}
