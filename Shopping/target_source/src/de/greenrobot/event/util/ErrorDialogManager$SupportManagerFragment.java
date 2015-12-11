// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event.util;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.support.v4.app.h;
import android.support.v4.app.l;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.tracing.TraceMachine;
import de.greenrobot.event.EventBus;

// Referenced classes of package de.greenrobot.event.util:
//            ErrorDialogManager, ErrorDialogFragmentFactory, ErrorDialogConfig, ThrowableFailureEvent

public static class  extends Fragment
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
          = ()h1.a("de.greenrobot.eventbus.error_dialog_manager");
        activity = ;
        if ( == null)
        {
            activity = new <init>();
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
        if (ErrorDialogManager.access$000(executionScope, throwablefailureevent))
        {
            ErrorDialogManager.checkLogException(throwablefailureevent);
            h h1 = getFragmentManager();
            h1.b();
            DialogFragment dialogfragment = (DialogFragment)h1.a("de.greenrobot.eventbus.error_dialog");
            if (dialogfragment != null)
            {
                dialogfragment.dismiss();
            }
            throwablefailureevent = (DialogFragment)ErrorDialogManager.factory.prepareErrorFragment(throwablefailureevent, finishAfterDialog, argumentsForErrorDialog);
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

    public ()
    {
    }
}
