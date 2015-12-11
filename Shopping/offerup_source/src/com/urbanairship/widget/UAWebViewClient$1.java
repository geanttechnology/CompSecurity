// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.widget;

import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionCompletionCallback;
import com.urbanairship.actions.ActionResult;

// Referenced classes of package com.urbanairship.widget:
//            UAWebViewClient

class this._cls0
    implements ActionCompletionCallback
{

    final UAWebViewClient this$0;

    public void onFinish(ActionArguments actionarguments, ActionResult actionresult)
    {
        this;
        JVM INSTR monitorenter ;
        if (UAWebViewClient.access$000(UAWebViewClient.this) != null)
        {
            UAWebViewClient.access$000(UAWebViewClient.this).onFinish(actionarguments, actionresult);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        actionarguments;
        this;
        JVM INSTR monitorexit ;
        throw actionarguments;
    }

    allback()
    {
        this$0 = UAWebViewClient.this;
        super();
    }
}
