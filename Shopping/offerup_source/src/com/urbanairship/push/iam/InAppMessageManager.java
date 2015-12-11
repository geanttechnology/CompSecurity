// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.BaseManager;
import com.urbanairship.Cancelable;
import com.urbanairship.LifeCycleCallbacks;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.json.JsonException;
import com.urbanairship.util.ManifestUtils;
import com.urbanairship.util.UAStringUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessage, ResolutionEvent, DisplayEvent, InAppMessageFragmentFactory, 
//            InAppMessageFragment

public class InAppMessageManager extends BaseManager
{

    private static final String AUTO_DISPLAY_ENABLED_KEY = "com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED";
    private static final long BACKGROUND_DELAY_MS = 500L;
    private static final long DEFAULT_ACTIVITY_RESUME_DELAY_MS = 3000L;
    public static final String EXCLUDE_FROM_AUTO_SHOW = "com.urbanairship.push.iam.EXCLUDE_FROM_AUTO_SHOW";
    private static final String IN_APP_TAG = "com.urbanairship.in_app_fragment";
    private static final String KEY_PREFIX = "com.urbanairship.push.iam.";
    private static final String LAST_DISPLAYED_ID_KEY = "com.urbanairship.push.iam.LAST_DISPLAYED_ID";
    private static final String PENDING_IN_APP_MESSAGE_KEY = "com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE";
    private static int activityCount = 0;
    private static Cancelable activityResumedOperation;
    private static boolean isForeground = false;
    private static LifeCycleCallbacks lifeCycleCallbacks;
    private WeakReference activityReference;
    private long autoDisplayDelayMs;
    private boolean autoDisplayPendingMessage;
    private InAppMessageFragment currentFragment;
    private InAppMessage currentMessage;
    private final PreferenceDataStore dataStore;
    private boolean displayAsap;
    private final Runnable displayRunnable = new _cls1();
    private InAppMessageFragmentFactory fragmentFactory;
    private final InAppMessageFragment.Listener fragmentListener = new _cls4();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final List listeners = new ArrayList();
    private final Object pendingMessageLock = new Object();

    public InAppMessageManager(PreferenceDataStore preferencedatastore)
    {
        dataStore = preferencedatastore;
        autoDisplayDelayMs = 3000L;
        autoDisplayPendingMessage = isDisplayAsapEnabled();
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            fragmentFactory = new _cls2();
        }
    }

    private Activity getCurrentActivity()
    {
        if (activityReference == null)
        {
            return null;
        } else
        {
            return (Activity)activityReference.get();
        }
    }

    public static void registerLifeCycleCallbacks(Application application)
    {
        if (lifeCycleCallbacks == null)
        {
            application = new _cls5(application);
            lifeCycleCallbacks = application;
            application.register();
        }
    }

    public static void unregisterLifeCycleCallbacks()
    {
        if (lifeCycleCallbacks != null)
        {
            lifeCycleCallbacks.unregister();
        }
    }

    public void addListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.add(listener);
        }
        return;
        listener;
        list;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public long getAutoDisplayDelay()
    {
        return autoDisplayDelayMs;
    }

    public InAppMessage getCurrentMessage()
    {
        return currentMessage;
    }

    public InAppMessageFragmentFactory getFragmentFactory()
    {
        return fragmentFactory;
    }

    public InAppMessage getPendingMessage()
    {
        Object obj = pendingMessageLock;
        obj;
        JVM INSTR monitorenter ;
        String s = dataStore.getString("com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE", null);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        InAppMessage inappmessage = InAppMessage.parseJson(s);
        obj;
        JVM INSTR monitorexit ;
        return inappmessage;
        JsonException jsonexception;
        jsonexception;
        Logger.error((new StringBuilder("InAppMessageManager - Failed to read pending in-app message: ")).append(s).toString(), jsonexception);
        setPendingMessage(null);
        obj;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void init()
    {
        Object obj = getPendingMessage();
        if (obj != null && ((InAppMessage) (obj)).isExpired())
        {
            Logger.debug("InAppMessageManager - pending in-app message expired.");
            obj = ResolutionEvent.createExpiredResolutionEvent(((InAppMessage) (obj)));
            UAirship.shared().getAnalytics().addEvent(((com.urbanairship.analytics.Event) (obj)));
            setPendingMessage(null);
        }
    }

    public boolean isAutoDisplayEnabled()
    {
        return dataStore.getBoolean("com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED", true);
    }

    public boolean isDisplayAsapEnabled()
    {
        return displayAsap;
    }

    void onActivityPaused(Activity activity)
    {
        Logger.verbose((new StringBuilder("InAppMessageManager - Activity paused: ")).append(activity).toString());
        activityReference = null;
        handler.removeCallbacks(displayRunnable);
    }

    void onActivityResumed(Activity activity)
    {
        Logger.verbose((new StringBuilder("InAppMessageManager - Activity resumed: ")).append(activity).toString());
        ActivityInfo activityinfo = ManifestUtils.getActivityInfo(activity.getClass());
        if (activityinfo != null && activityinfo.metaData != null && activityinfo.metaData.getBoolean("com.urbanairship.push.iam.EXCLUDE_FROM_AUTO_SHOW", false))
        {
            Logger.verbose("InAppMessageManager - Activity contains metadata to exclude it from auto showing an in-app message");
        } else
        {
            activityReference = new WeakReference(activity);
            handler.removeCallbacks(displayRunnable);
            if (autoDisplayPendingMessage)
            {
                handler.postDelayed(displayRunnable, autoDisplayDelayMs);
                return;
            }
        }
    }

    void onForeground()
    {
        Logger.verbose("InAppMessageManager - App foregrounded.");
        Object obj = getPendingMessage();
        if (currentMessage == null && obj != null || obj != null && !((InAppMessage) (obj)).equals(currentMessage))
        {
            if (currentMessage != null)
            {
                obj = ResolutionEvent.createReplacedResolutionEvent(currentMessage, ((InAppMessage) (obj)));
                UAirship.shared().getAnalytics().addEvent(((com.urbanairship.analytics.Event) (obj)));
            }
            currentMessage = null;
            autoDisplayPendingMessage = true;
            handler.removeCallbacks(displayRunnable);
            handler.postDelayed(displayRunnable, autoDisplayDelayMs);
        }
    }

    public void removeListener(Listener listener)
    {
        synchronized (listeners)
        {
            listeners.remove(listener);
        }
        return;
        listener;
        list;
        JVM INSTR monitorexit ;
        throw listener;
    }

    public void setAutoDisplayDelay(long l)
    {
        autoDisplayDelayMs = l;
    }

    public void setAutoDisplayEnabled(boolean flag)
    {
        dataStore.put("com.urbanairship.push.iam.AUTO_DISPLAY_ENABLED", flag);
    }

    public void setDisplayAsapEnabled(boolean flag)
    {
        displayAsap = flag;
        if (flag)
        {
            autoDisplayPendingMessage = true;
        }
    }

    public void setFragmentFactory(InAppMessageFragmentFactory inappmessagefragmentfactory)
    {
        fragmentFactory = inappmessagefragmentfactory;
    }

    public void setPendingMessage(final InAppMessage message)
    {
        Object obj = pendingMessageLock;
        obj;
        JVM INSTR monitorenter ;
        if (message != null) goto _L2; else goto _L1
_L1:
        dataStore.remove("com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE");
_L3:
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        InAppMessage inappmessage;
        inappmessage = getPendingMessage();
        if (!message.equals(inappmessage))
        {
            break MISSING_BLOCK_LABEL_44;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        message;
        obj;
        JVM INSTR monitorexit ;
        throw message;
        handler.post(new _cls3());
        dataStore.put("com.urbanairship.push.iam.PENDING_IN_APP_MESSAGE", message);
        if (currentMessage != null || inappmessage == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        Logger.debug("InAppMessageManager - pending in-app message replaced.");
        message = ResolutionEvent.createReplacedResolutionEvent(inappmessage, message);
        UAirship.shared().getAnalytics().addEvent(message);
        if (isDisplayAsapEnabled() && getCurrentActivity() != null)
        {
            autoDisplayPendingMessage = true;
            handler.removeCallbacks(displayRunnable);
            handler.post(displayRunnable);
        }
          goto _L3
    }

    public boolean showPendingMessage(Activity activity)
    {
        return showPendingMessage(activity, 0x1020002);
    }

    public boolean showPendingMessage(Activity activity, int i)
    {
        Object obj = pendingMessageLock;
        obj;
        JVM INSTR monitorenter ;
        InAppMessage inappmessage = getPendingMessage();
        if (activity != null && inappmessage != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        int j;
        int k;
        if (inappmessage.getPosition() != 1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        k = com.urbanairship.R.animator.ua_iam_slide_in_top;
        j = com.urbanairship.R.animator.ua_iam_slide_out_top;
_L1:
        boolean flag = showPendingMessage(activity, i, k, j);
        obj;
        JVM INSTR monitorexit ;
        return flag;
        activity;
        obj;
        JVM INSTR monitorexit ;
        throw activity;
        k = com.urbanairship.R.animator.ua_iam_slide_in_bottom;
        j = com.urbanairship.R.animator.ua_iam_slide_out_bottom;
          goto _L1
    }

    public boolean showPendingMessage(Activity activity, int i, int j, int k)
    {
        Object obj = pendingMessageLock;
        obj;
        JVM INSTR monitorenter ;
        InAppMessage inappmessage = getPendingMessage();
        if (inappmessage == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (!inappmessage.isExpired())
        {
            break MISSING_BLOCK_LABEL_60;
        }
        Logger.debug("InAppMessageManager - Unable to display pending in-app message. Message has expired.");
        activity = ResolutionEvent.createExpiredResolutionEvent(inappmessage);
        UAirship.shared().getAnalytics().addEvent(activity);
        setPendingMessage(null);
        obj;
        JVM INSTR monitorexit ;
        return false;
        obj;
        JVM INSTR monitorexit ;
        if (activity == null || inappmessage == null)
        {
            break MISSING_BLOCK_LABEL_486;
        }
        break MISSING_BLOCK_LABEL_81;
        activity;
        obj;
        JVM INSTR monitorexit ;
        throw activity;
        if (android.os.Build.VERSION.SDK_INT < 14)
        {
            Logger.error("InAppMessageManager - Unable to show in-app messages on Android versions older than API 14 (Ice Cream Sandwich).");
            return false;
        }
        if (activity.isFinishing())
        {
            Logger.error("InAppMessageManager - Unable to display in-app messages for an activity that is finishing.");
            return false;
        }
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            Logger.error("InAppMessageManager - Show message must be called on the main thread.");
            return false;
        }
        if (currentFragment != null)
        {
            Logger.debug("InAppMessageManager - An in-app message is already displayed.");
            return false;
        }
        if (!UAStringUtil.equals(inappmessage.getId(), dataStore.getString("com.urbanairship.push.iam.LAST_DISPLAYED_ID", null)))
        {
            Logger.debug((new StringBuilder("InAppMessageManager - Displaying pending message: ")).append(inappmessage).append(" for first time.").toString());
            obj = new DisplayEvent(inappmessage);
            UAirship.shared().getAnalytics().addEvent(((com.urbanairship.analytics.Event) (obj)));
            dataStore.put("com.urbanairship.push.iam.LAST_DISPLAYED_ID", inappmessage.getId());
        }
        if (currentMessage != null && currentMessage.equals(inappmessage))
        {
            obj = ResolutionEvent.createReplacedResolutionEvent(currentMessage, inappmessage);
            UAirship.shared().getAnalytics().addEvent(((com.urbanairship.analytics.Event) (obj)));
        }
        Logger.info("InAppMessageManager - Displaying in-app message.");
        obj = getFragmentFactory();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_294;
        }
        Logger.error("InAppMessageManager - InAppMessageFragmentFactory is null, unable to display an in-app message.");
        return false;
        currentFragment = ((InAppMessageFragmentFactory) (obj)).createFragment(inappmessage);
        if (currentFragment != null)
        {
            break MISSING_BLOCK_LABEL_320;
        }
        Logger.error("InAppMessageManager - InAppMessageFragmentFactory returned a null fragment, unable to display an in-app message.");
        return false;
        obj = InAppMessageFragment.createArgs(inappmessage, k);
        if (currentFragment.getArguments() != null)
        {
            ((Bundle) (obj)).putAll(currentFragment.getArguments());
        }
        currentFragment.setArguments(((Bundle) (obj)));
        currentFragment.addListener(fragmentListener);
        currentFragment.setDismissOnRecreate(true);
        currentMessage = inappmessage;
        obj = listeners;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onDisplay(currentFragment, inappmessage)) { }
        break MISSING_BLOCK_LABEL_455;
        activity;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw activity;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Logger.debug("InAppMessageManager - Failed to display in-app message.", activity);
        }
        return false;
        obj;
        JVM INSTR monitorexit ;
        activity.getFragmentManager().beginTransaction().setCustomAnimations(j, 0).add(i, currentFragment, "com.urbanairship.in_app_fragment").commit();
        return true;
        return false;
    }




/*
    static boolean access$002(InAppMessageManager inappmessagemanager, boolean flag)
    {
        inappmessagemanager.autoDisplayPendingMessage = flag;
        return flag;
    }

*/




/*
    static boolean access$1002(boolean flag)
    {
        isForeground = flag;
        return flag;
    }

*/



/*
    static Cancelable access$1102(Cancelable cancelable)
    {
        activityResumedOperation = cancelable;
        return cancelable;
    }

*/




/*
    static InAppMessageFragment access$302(InAppMessageManager inappmessagemanager, InAppMessageFragment inappmessagefragment)
    {
        inappmessagemanager.currentFragment = inappmessagefragment;
        return inappmessagefragment;
    }

*/



/*
    static InAppMessage access$402(InAppMessageManager inappmessagemanager, InAppMessage inappmessage)
    {
        inappmessagemanager.currentMessage = inappmessage;
        return inappmessage;
    }

*/







/*
    static int access$908()
    {
        int i = activityCount;
        activityCount = i + 1;
        return i;
    }

*/


/*
    static int access$910()
    {
        int i = activityCount;
        activityCount = i - 1;
        return i;
    }

*/

    private class _cls1
        implements Runnable
    {

        final InAppMessageManager this$0;

        public void run()
        {
            Activity activity;
            if ((autoDisplayPendingMessage || isDisplayAsapEnabled()) && isAutoDisplayEnabled())
            {
                if ((activity = getCurrentActivity()) != null && showPendingMessage(activity))
                {
                    autoDisplayPendingMessage = false;
                    return;
                }
            }
        }

        _cls1()
        {
            this$0 = InAppMessageManager.this;
            super();
        }
    }


    private class _cls4
        implements InAppMessageFragment.Listener
    {

        final InAppMessageManager this$0;

        public void onFinish(InAppMessageFragment inappmessagefragment)
        {
            InAppMessage inappmessage;
            Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment finished: ")).append(inappmessagefragment).toString());
            inappmessage = inappmessagefragment.getMessage();
            inappmessagefragment = ((InAppMessageFragment) (pendingMessageLock));
            inappmessagefragment;
            JVM INSTR monitorenter ;
            if (inappmessage == null)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            if (inappmessage.equals(getPendingMessage()))
            {
                setPendingMessage(null);
            }
            inappmessagefragment;
            JVM INSTR monitorexit ;
            if (inappmessage != null && inappmessage.equals(currentMessage))
            {
                currentMessage = null;
                if (isDisplayAsapEnabled() && getCurrentActivity() != null)
                {
                    autoDisplayPendingMessage = true;
                    handler.removeCallbacks(displayRunnable);
                    handler.postDelayed(displayRunnable, autoDisplayDelayMs);
                }
            }
            return;
            Exception exception;
            exception;
            inappmessagefragment;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void onPause(InAppMessageFragment inappmessagefragment)
        {
            Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment paused: ")).append(inappmessagefragment).toString());
            if (inappmessagefragment == currentFragment)
            {
                currentFragment = null;
                if (!inappmessagefragment.isDismissed() && inappmessagefragment.getActivity().isFinishing())
                {
                    Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment's activity is finishing: ")).append(inappmessagefragment).toString());
                    autoDisplayPendingMessage = true;
                    return;
                }
            }
        }

        public void onResume(InAppMessageFragment inappmessagefragment)
        {
            Logger.verbose((new StringBuilder("InAppMessageManager - InAppMessageFragment resumed: ")).append(inappmessagefragment).toString());
            if (currentFragment != null && currentFragment != inappmessagefragment)
            {
                Logger.debug((new StringBuilder("InAppMessageManager - Dismissing ")).append(inappmessagefragment).append(" because it is no longer the current fragment.").toString());
                inappmessagefragment.dismiss(false);
                return;
            }
            if (currentMessage == null || !currentMessage.equals(inappmessagefragment.getMessage()))
            {
                Logger.debug((new StringBuilder("InAppMessageManager - Dismissing ")).append(inappmessagefragment).append(" because its message is no longer current.").toString());
                inappmessagefragment.dismiss(false);
                return;
            } else
            {
                currentFragment = inappmessagefragment;
                return;
            }
        }

        _cls4()
        {
            this$0 = InAppMessageManager.this;
            super();
        }
    }


    private class _cls2 extends InAppMessageFragmentFactory
    {

        final InAppMessageManager this$0;

        public InAppMessageFragment createFragment(InAppMessage inappmessage)
        {
            return new InAppMessageFragment();
        }

        _cls2()
        {
            this$0 = InAppMessageManager.this;
            super();
        }
    }


    private class _cls5 extends LifeCycleCallbacks
    {

        public final void onActivityPaused(Activity activity)
        {
            if (InAppMessageManager.activityResumedOperation != null && !InAppMessageManager.activityResumedOperation.isDone())
            {
                InAppMessageManager.activityResumedOperation.cancel();
                return;
            } else
            {
                UAirship.shared().getInAppMessageManager().onActivityPaused(activity);
                return;
            }
        }

        public final void onActivityResumed(Activity activity)
        {
            class _cls3
                implements com.urbanairship.UAirship.OnReadyCallback
            {

                final _cls5 this$0;
                final WeakReference val$weakReference;

                public void onAirshipReady(UAirship uairship)
                {
                    uairship = (Activity)weakReference.get();
                    if (uairship != null)
                    {
                        UAirship.shared().getInAppMessageManager().onActivityResumed(uairship);
                    }
                }

                _cls3()
                {
                    this$0 = _cls5.this;
                    weakReference = weakreference;
                    super();
                }
            }

            InAppMessageManager.activityResumedOperation = UAirship.shared(new _cls3());
        }

        public final void onActivityStarted(Activity activity)
        {
label0:
            {
                int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        public final void onActivityStopped(Activity activity)
        {
            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

        _cls5(Application application)
        {
            super(application);
        }

        class _cls1
            implements com.urbanairship.UAirship.OnReadyCallback
        {

            final _cls5 this$0;

            public void onAirshipReady(UAirship uairship)
            {
                UAirship.shared().getInAppMessageManager().onForeground();
            }

                _cls1()
                {
                    this$0 = _cls5.this;
                    super();
                }
        }


        class _cls2
            implements Runnable
        {

            final _cls5 this$0;

            public void run()
            {
                if (InAppMessageManager.activityCount == 0)
                {
                    InAppMessageManager.isForeground = false;
                }
            }

                _cls2()
                {
                    this$0 = _cls5.this;
                    Object();
                }
        }

    }


    private class _cls3
        implements Runnable
    {

        final InAppMessageManager this$0;
        final InAppMessage val$message;

        public void run()
        {
            List list = listeners;
            list;
            JVM INSTR monitorenter ;
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((Listener)iterator.next()).onPendingMessageAvailable(message)) { }
            break MISSING_BLOCK_LABEL_58;
            Exception exception;
            exception;
            list;
            JVM INSTR monitorexit ;
            throw exception;
            list;
            JVM INSTR monitorexit ;
        }

        _cls3()
        {
            this$0 = InAppMessageManager.this;
            message = inappmessage;
            super();
        }
    }


    private class Listener
    {

        public abstract void onDisplay(InAppMessageFragment inappmessagefragment, InAppMessage inappmessage);

        public abstract void onPendingMessageAvailable(InAppMessage inappmessage);
    }

}
