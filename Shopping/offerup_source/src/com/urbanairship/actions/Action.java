// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;

// Referenced classes of package com.urbanairship.actions:
//            ActionResult, ActionActivity, ActionArguments

public abstract class Action
{

    public Action()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        return true;
    }

    public void onFinish(ActionArguments actionarguments, ActionResult actionresult)
    {
    }

    public void onStart(ActionArguments actionarguments)
    {
    }

    public abstract ActionResult perform(ActionArguments actionarguments);

    final ActionResult run(ActionArguments actionarguments)
    {
        ActionResult actionresult;
        ActionResult actionresult1;
        try
        {
            if (!acceptsArguments(actionarguments))
            {
                Logger.debug((new StringBuilder("Action ")).append(this).append(" is unable to accept arguments: ").append(actionarguments).toString());
                return ActionResult.newEmptyResultWithStatus(ActionResult.Status.REJECTED_ARGUMENTS);
            }
            Logger.info((new StringBuilder("Running action: ")).append(this).append(" arguments: ").append(actionarguments).toString());
            onStart(actionarguments);
            actionresult1 = perform(actionarguments);
        }
        // Misplaced declaration of an exception variable
        catch (ActionArguments actionarguments)
        {
            Logger.error((new StringBuilder("Failed to run action ")).append(this).toString(), actionarguments);
            return ActionResult.newErrorResult(actionarguments);
        }
        actionresult = actionresult1;
        if (actionresult1 != null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        actionresult = ActionResult.newEmptyResult();
        onFinish(actionarguments, actionresult);
        return actionresult;
    }

    public final ActivityResult startActivityForResult(Intent intent)
    {
        ActivityResult activityresult;
        Context context;
        _cls1 _lcls1;
        activityresult = new ActivityResult();
        _lcls1 = new _cls1(activityresult);
        context = UAirship.getApplicationContext();
        intent = (new Intent(context, com/urbanairship/actions/ActionActivity)).addFlags(0x10000000).setPackage(UAirship.getPackageName()).putExtra("com.urbanairship.actions.START_ACTIVITY_INTENT_EXTRA", intent).putExtra("com.urbanairship.actions.actionactivity.RESULT_RECEIVER_EXTRA", _lcls1);
        activityresult;
        JVM INSTR monitorenter ;
        context.startActivity(intent);
        activityresult.wait();
        activityresult;
        JVM INSTR monitorexit ;
        return activityresult;
        intent;
        Logger.error("Thread interrupted when waiting for result from activity.", intent);
        intent = new ActivityResult();
        activityresult;
        JVM INSTR monitorexit ;
        return intent;
        intent;
        activityresult;
        JVM INSTR monitorexit ;
        throw intent;
    }

    private class ActivityResult
    {

        private Intent intent;
        private int resultCode;

        private void setResult(int i, Intent intent1)
        {
            resultCode = i;
            intent = intent1;
        }

        public Intent getIntent()
        {
            return intent;
        }

        public int getResultCode()
        {
            return resultCode;
        }


        public ActivityResult()
        {
            resultCode = 0;
        }
    }


    private class _cls1 extends ResultReceiver
    {

        final Action this$0;
        final ActivityResult val$result;

        public void onReceiveResult(int i, Bundle bundle)
        {
            result.setResult(i, (Intent)bundle.getParcelable("com.urbanairship.actions.actionactivity.RESULT_INTENT_EXTRA"));
            synchronized (result)
            {
                result.notify();
            }
            return;
            exception;
            bundle;
            JVM INSTR monitorexit ;
            throw exception;
        }

        _cls1(ActivityResult activityresult)
        {
            this$0 = Action.this;
            result = activityresult;
            super(final_handler);
        }
    }

}
