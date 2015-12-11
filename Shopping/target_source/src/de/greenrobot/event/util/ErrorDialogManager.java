// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event.util;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.f;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.util.Log;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import de.greenrobot.event.EventBus;

// Referenced classes of package de.greenrobot.event.util:
//            ErrorDialogFragmentFactory, ErrorDialogConfig, ThrowableFailureEvent

public class ErrorDialogManager
{
    public static class HoneycombManagerFragment extends Fragment
        implements TraceFieldInterface
    {

        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;

        public static void attachTo(Activity activity, Object obj, boolean flag, Bundle bundle)
        {
            FragmentManager fragmentmanager = activity.getFragmentManager();
            HoneycombManagerFragment honeycombmanagerfragment = (HoneycombManagerFragment)fragmentmanager.findFragmentByTag("de.greenrobot.eventbus.error_dialog_manager");
            activity = honeycombmanagerfragment;
            if (honeycombmanagerfragment == null)
            {
                activity = new HoneycombManagerFragment();
                fragmentmanager.beginTransaction().add(activity, "de.greenrobot.eventbus.error_dialog_manager").commit();
                fragmentmanager.executePendingTransactions();
            }
            activity.finishAfterDialog = flag;
            activity.argumentsForErrorDialog = bundle;
            activity.executionScope = obj;
        }

        public void onEventMainThread(ThrowableFailureEvent throwablefailureevent)
        {
            if (ErrorDialogManager.isInExecutionScope(executionScope, throwablefailureevent))
            {
                ErrorDialogManager.checkLogException(throwablefailureevent);
                FragmentManager fragmentmanager = getFragmentManager();
                fragmentmanager.executePendingTransactions();
                DialogFragment dialogfragment = (DialogFragment)fragmentmanager.findFragmentByTag("de.greenrobot.eventbus.error_dialog");
                if (dialogfragment != null)
                {
                    dialogfragment.dismiss();
                }
                throwablefailureevent = (DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(throwablefailureevent, finishAfterDialog, argumentsForErrorDialog);
                if (throwablefailureevent != null)
                {
                    throwablefailureevent.show(fragmentmanager, "de.greenrobot.eventbus.error_dialog");
                    return;
                }
            }
        }

        public void onPause()
        {
            eventBus.unregister(this);
            super.onPause();
        }

        public void onResume()
        {
            super.onResume();
            eventBus = ErrorDialogManager.factory.config.getEventBus();
            eventBus.register(this);
        }

        protected void onStart()
        {
            super.onStart();
            ApplicationStateMonitor.getInstance().activityStarted();
        }

        protected void onStop()
        {
            super.onStop();
            ApplicationStateMonitor.getInstance().activityStopped();
        }

        public HoneycombManagerFragment()
        {
        }
    }

    public static class SupportManagerFragment extends android.support.v4.app.Fragment
        implements TraceFieldInterface
    {

        protected Bundle argumentsForErrorDialog;
        private EventBus eventBus;
        private Object executionScope;
        protected boolean finishAfterDialog;
        private boolean skipRegisterOnNextResume;

        public static void attachTo(Activity activity, Object obj, boolean flag, Bundle bundle)
        {
            h h1 = ((f)activity).f();
            SupportManagerFragment supportmanagerfragment = (SupportManagerFragment)h1.a("de.greenrobot.eventbus.error_dialog_manager");
            activity = supportmanagerfragment;
            if (supportmanagerfragment == null)
            {
                activity = new SupportManagerFragment();
                h1.a().a(activity, "de.greenrobot.eventbus.error_dialog_manager").a();
                h1.b();
            }
            activity.finishAfterDialog = flag;
            activity.argumentsForErrorDialog = bundle;
            activity.executionScope = obj;
        }

        public void onCreate(Bundle bundle)
        {
            TraceMachine.startTracing("ErrorDialogManager$SupportManagerFragment");
            TraceMachine.enterMethod(_nr_trace, "ErrorDialogManager$SupportManagerFragment#onCreate", null);
_L1:
            super.onCreate(bundle);
            eventBus = ErrorDialogManager.factory.config.getEventBus();
            eventBus.register(this);
            skipRegisterOnNextResume = true;
            TraceMachine.exitMethod();
            return;
            NoSuchFieldError nosuchfielderror;
            nosuchfielderror;
            TraceMachine.enterMethod(null, "ErrorDialogManager$SupportManagerFragment#onCreate", null);
              goto _L1
        }

        public void onEventMainThread(ThrowableFailureEvent throwablefailureevent)
        {
            if (ErrorDialogManager.isInExecutionScope(executionScope, throwablefailureevent))
            {
                ErrorDialogManager.checkLogException(throwablefailureevent);
                h h1 = getFragmentManager();
                h1.b();
                android.support.v4.app.DialogFragment dialogfragment = (android.support.v4.app.DialogFragment)h1.a("de.greenrobot.eventbus.error_dialog");
                if (dialogfragment != null)
                {
                    dialogfragment.dismiss();
                }
                throwablefailureevent = (android.support.v4.app.DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(throwablefailureevent, finishAfterDialog, argumentsForErrorDialog);
                if (throwablefailureevent != null)
                {
                    throwablefailureevent.show(h1, "de.greenrobot.eventbus.error_dialog");
                    return;
                }
            }
        }

        public void onPause()
        {
            eventBus.unregister(this);
            super.onPause();
        }

        public void onResume()
        {
            super.onResume();
            if (skipRegisterOnNextResume)
            {
                skipRegisterOnNextResume = false;
                return;
            } else
            {
                eventBus = ErrorDialogManager.factory.config.getEventBus();
                eventBus.register(this);
                return;
            }
        }

        protected void onStart()
        {
            super.onStart();
            ApplicationStateMonitor.getInstance().activityStarted();
        }

        protected void onStop()
        {
            super.onStop();
            ApplicationStateMonitor.getInstance().activityStopped();
        }

        public SupportManagerFragment()
        {
        }
    }


    public static final String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
    protected static final String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
    protected static final String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
    public static ErrorDialogFragmentFactory factory;

    public ErrorDialogManager()
    {
    }

    public static void attachTo(Activity activity)
    {
        attachTo(activity, false, null);
    }

    public static void attachTo(Activity activity, Object obj, boolean flag, Bundle bundle)
    {
        if (factory == null)
        {
            throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
        }
        if (isSupportActivity(activity))
        {
            SupportManagerFragment.attachTo(activity, obj, flag, bundle);
            return;
        } else
        {
            HoneycombManagerFragment.attachTo(activity, obj, flag, bundle);
            return;
        }
    }

    public static void attachTo(Activity activity, boolean flag)
    {
        attachTo(activity, flag, null);
    }

    public static void attachTo(Activity activity, boolean flag, Bundle bundle)
    {
        attachTo(activity, activity.getClass(), flag, bundle);
    }

    protected static void checkLogException(ThrowableFailureEvent throwablefailureevent)
    {
        if (factory.config.logExceptions)
        {
            String s1 = factory.config.tagForLoggingExceptions;
            String s = s1;
            if (s1 == null)
            {
                s = EventBus.TAG;
            }
            Log.i(s, "Error dialog manager received exception", throwablefailureevent.throwable);
        }
    }

    private static boolean isInExecutionScope(Object obj, ThrowableFailureEvent throwablefailureevent)
    {
        if (throwablefailureevent != null)
        {
            throwablefailureevent = ((ThrowableFailureEvent) (throwablefailureevent.getExecutionScope()));
            if (throwablefailureevent != null && !throwablefailureevent.equals(obj))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isSupportActivity(Activity activity)
    {
        Class class1;
        boolean flag;
        flag = false;
        class1 = activity.getClass().getSuperclass();
_L6:
        String s;
        if (class1 == null)
        {
            throw new RuntimeException((new StringBuilder()).append("Illegal activity type: ").append(activity.getClass()).toString());
        }
        s = class1.getName();
        if (!s.equals("android.support.v4.app.FragmentActivity")) goto _L2; else goto _L1
_L1:
        flag = true;
_L4:
        return flag;
_L2:
        if (s.startsWith("com.actionbarsherlock.app") && (s.endsWith(".SherlockActivity") || s.endsWith(".SherlockListActivity") || s.endsWith(".SherlockPreferenceActivity")))
        {
            throw new RuntimeException((new StringBuilder()).append("Please use SherlockFragmentActivity. Illegal activity: ").append(s).toString());
        }
        if (!s.equals("android.app.Activity"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
        }
        if (true) goto _L4; else goto _L3
_L3:
        class1 = class1.getSuperclass();
        if (true) goto _L6; else goto _L5
_L5:
    }

}
