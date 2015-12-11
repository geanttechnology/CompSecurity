// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import java.lang.ref.WeakReference;
import java.util.Date;
import net.hockeyapp.android.tasks.CheckUpdateTask;

// Referenced classes of package net.hockeyapp.android:
//            UpdateManagerListener, ExpiryInfoActivity

public class UpdateManager
{

    private static UpdateManagerListener lastListener = null;
    private static CheckUpdateTask updateTask = null;

    public UpdateManager()
    {
    }

    private static boolean checkExpiryDate(WeakReference weakreference, UpdateManagerListener updatemanagerlistener)
    {
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag1 = flag3;
        if (updatemanagerlistener != null)
        {
            Date date = updatemanagerlistener.getExpiryDate();
            boolean flag;
            if (date != null && (new Date()).compareTo(date) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag3;
            flag2 = flag;
            if (flag)
            {
                flag1 = updatemanagerlistener.onBuildExpired();
                flag2 = flag;
            }
        }
        if (flag2 && flag1)
        {
            startExpiryInfoIntent(weakreference);
        }
        return flag2;
    }

    private static boolean dialogShown(WeakReference weakreference)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (weakreference != null)
        {
            weakreference = (Activity)weakreference.get();
            flag = flag1;
            if (weakreference != null)
            {
                flag = flag1;
                if (weakreference.getFragmentManager().findFragmentByTag("hockey_update_dialog") != null)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static Boolean fragmentsSupported()
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 11 && android/app/Fragment != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
        NoClassDefFoundError noclassdeffounderror;
        noclassdeffounderror;
        return Boolean.valueOf(false);
    }

    public static UpdateManagerListener getLastListener()
    {
        return lastListener;
    }

    private static boolean installedFromMarket(WeakReference weakreference)
    {
        boolean flag = false;
        weakreference = (Activity)weakreference.get();
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        try
        {
            weakreference = weakreference.getPackageManager().getInstallerPackageName(weakreference.getPackageName());
        }
        // Misplaced declaration of an exception variable
        catch (WeakReference weakreference)
        {
            return false;
        }
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        flag = weakreference.isEmpty();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        flag = true;
        return flag;
        return false;
    }

    public static void register(Activity activity, String s)
    {
        register(activity, s, null);
    }

    public static void register(Activity activity, String s, String s1, UpdateManagerListener updatemanagerlistener)
    {
        lastListener = updatemanagerlistener;
        for (activity = new WeakReference(activity); fragmentsSupported().booleanValue() && dialogShown(activity) || checkExpiryDate(activity, updatemanagerlistener) || installedFromMarket(activity);)
        {
            return;
        }

        startUpdateTask(activity, s, s1, updatemanagerlistener);
    }

    public static void register(Activity activity, String s, UpdateManagerListener updatemanagerlistener)
    {
        register(activity, "https://sdk.hockeyapp.net/", s, updatemanagerlistener);
    }

    public static Boolean runsOnTablet(WeakReference weakreference)
    {
        boolean flag = false;
        if (weakreference != null)
        {
            weakreference = (Activity)weakreference.get();
            if (weakreference != null)
            {
                weakreference = weakreference.getResources().getConfiguration();
                if ((((Configuration) (weakreference)).screenLayout & 0xf) == 3 || (((Configuration) (weakreference)).screenLayout & 0xf) == 4)
                {
                    flag = true;
                }
                return Boolean.valueOf(flag);
            }
        }
        return Boolean.valueOf(false);
    }

    private static void startExpiryInfoIntent(WeakReference weakreference)
    {
        if (weakreference != null)
        {
            weakreference = (Activity)weakreference.get();
            if (weakreference != null)
            {
                weakreference.finish();
                Intent intent = new Intent(weakreference, net/hockeyapp/android/ExpiryInfoActivity);
                intent.addFlags(0x14000000);
                weakreference.startActivity(intent);
            }
        }
    }

    private static void startUpdateTask(WeakReference weakreference, String s, String s1, UpdateManagerListener updatemanagerlistener)
    {
        if (updateTask == null || updateTask.getStatus() == android.os.AsyncTask.Status.FINISHED)
        {
            updateTask = new CheckUpdateTask(weakreference, s, s1, updatemanagerlistener);
            weakreference = updateTask;
            s = new String[0];
            if (!(weakreference instanceof AsyncTask))
            {
                weakreference.execute(s);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)weakreference, s);
                return;
            }
        } else
        {
            updateTask.attach(weakreference);
            return;
        }
    }

    public static void unregister()
    {
        if (updateTask != null)
        {
            updateTask.cancel(true);
            updateTask.detach();
            updateTask = null;
        }
        lastListener = null;
    }

}
