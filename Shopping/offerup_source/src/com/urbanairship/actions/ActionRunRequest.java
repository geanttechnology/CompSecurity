// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.android.internal.util.Predicate;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.urbanairship.actions:
//            ActionArguments, ActionRegistry, ActionResult, Action, 
//            ActionValueException, ActionValue, Situation, ActionCompletionCallback

public class ActionRunRequest
{

    static Executor executor = Executors.newCachedThreadPool();
    private Action action;
    private String actionName;
    private ActionValue actionValue;
    private Bundle metadata;
    private ActionRegistry registry;
    private Situation situation;

    ActionRunRequest(Action action1)
    {
        action = action1;
    }

    ActionRunRequest(String s, ActionRegistry actionregistry)
    {
        actionName = s;
        registry = actionregistry;
    }

    private ActionArguments createActionArguments()
    {
        Bundle bundle;
        if (metadata == null)
        {
            bundle = new Bundle();
        } else
        {
            bundle = new Bundle(metadata);
        }
        if (actionName != null)
        {
            bundle.putString("com.urbanairship.REGISTRY_ACTION_NAME", actionName);
        }
        return new ActionArguments(situation, actionValue, bundle);
    }

    public static ActionRunRequest createRequest(Action action1)
    {
        if (action1 == null)
        {
            throw new IllegalArgumentException("Unable to run null action");
        } else
        {
            return new ActionRunRequest(action1);
        }
    }

    public static ActionRunRequest createRequest(String s)
    {
        return new ActionRunRequest(s, null);
    }

    public static ActionRunRequest createRequest(String s, ActionRegistry actionregistry)
    {
        return new ActionRunRequest(s, actionregistry);
    }

    private ActionRegistry.Entry lookUpAction(String s)
    {
        if (registry != null)
        {
            return registry.getEntry(s);
        } else
        {
            return UAirship.shared().getActionRegistry().getEntry(s);
        }
    }

    private ActionResult runSync(ActionArguments actionarguments)
    {
        if (actionName != null)
        {
            ActionRegistry.Entry entry = lookUpAction(actionName);
            if (entry == null)
            {
                return ActionResult.newEmptyResultWithStatus(ActionResult.Status.ACTION_NOT_FOUND);
            }
            if (entry.getPredicate() != null && !entry.getPredicate().apply(actionarguments))
            {
                Logger.info((new StringBuilder("Action ")).append(actionName).append(" will not be run. Registry predicate rejected the arguments: ").append(actionarguments).toString());
                return ActionResult.newEmptyResultWithStatus(ActionResult.Status.REJECTED_ARGUMENTS);
            } else
            {
                return entry.getActionForSituation(situation).run(actionarguments);
            }
        }
        if (action != null)
        {
            return action.run(actionarguments);
        } else
        {
            return ActionResult.newEmptyResultWithStatus(ActionResult.Status.ACTION_NOT_FOUND);
        }
    }

    public void run()
    {
        run(null, null);
    }

    public void run(ActionCompletionCallback actioncompletioncallback)
    {
        run(actioncompletioncallback, null);
    }

    public void run(final ActionCompletionCallback callback, final Looper handler)
    {
        if (handler == null)
        {
            handler = Looper.myLooper();
            final ActionArguments arguments;
            if (handler == null)
            {
                handler = Looper.getMainLooper();
            }
        }
        arguments = createActionArguments();
        handler = new Handler(handler);
        executor.execute(new _cls1());
    }

    public ActionResult runSync()
    {
        return runSync(createActionArguments());
    }

    public ActionRunRequest setMetadata(Bundle bundle)
    {
        metadata = bundle;
        return this;
    }

    public ActionRunRequest setSituation(Situation situation1)
    {
        situation = situation1;
        return this;
    }

    public ActionRunRequest setValue(ActionValue actionvalue)
    {
        actionValue = actionvalue;
        return this;
    }

    public ActionRunRequest setValue(Object obj)
    {
        try
        {
            actionValue = ActionValue.wrap(obj);
        }
        catch (ActionValueException actionvalueexception)
        {
            throw new IllegalArgumentException((new StringBuilder("Unable to wrap object: ")).append(obj).append(" as an ActionValue.").toString(), actionvalueexception);
        }
        return this;
    }



    private class _cls1
        implements Runnable
    {

        final ActionRunRequest this$0;
        final ActionArguments val$arguments;
        final ActionCompletionCallback val$callback;
        final Handler val$handler;

        public void run()
        {
            final ActionResult result = runSync(arguments);
            if (callback == null)
            {
                return;
            } else
            {
                class _cls1
                    implements Runnable
                {

                    final _cls1 this$1;
                    final ActionResult val$result;

                    public void run()
                    {
                        callback.onFinish(arguments, result);
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    result = actionresult;
                    super();
                }
                }

                handler.post(new _cls1());
                return;
            }
        }

        _cls1()
        {
            this$0 = ActionRunRequest.this;
            arguments = actionarguments;
            callback = actioncompletioncallback;
            handler = handler1;
            super();
        }
    }

}
