// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Handler;

// Referenced classes of package com.urbanairship.actions:
//            ActionRunRequest, ActionArguments, ActionCompletionCallback

class val.handler
    implements Runnable
{

    final ActionRunRequest this$0;
    final ActionArguments val$arguments;
    final ActionCompletionCallback val$callback;
    final Handler val$handler;

    public void run()
    {
        final ActionResult result = ActionRunRequest.access$000(ActionRunRequest.this, val$arguments);
        if (val$callback == null)
        {
            return;
        } else
        {
            class _cls1
                implements Runnable
            {

                final ActionRunRequest._cls1 this$1;
                final ActionResult val$result;

                public void run()
                {
                    callback.onFinish(arguments, result);
                }

            _cls1()
            {
                this$1 = ActionRunRequest._cls1.this;
                result = actionresult;
                super();
            }
            }

            val$handler.post(new _cls1());
            return;
        }
    }

    lback()
    {
        this$0 = final_actionrunrequest;
        val$arguments = actionarguments;
        val$callback = actioncompletioncallback;
        val$handler = Handler.this;
        super();
    }
}
