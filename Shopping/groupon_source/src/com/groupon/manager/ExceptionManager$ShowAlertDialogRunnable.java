// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.util.DialogManager;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.manager:
//            ExceptionManager

protected class cancelFunction
    implements Runnable
{

    protected final Function0 cancelFunction;
    protected final String msgCopy;
    protected final Function0 retryFunction;
    final ExceptionManager this$0;

    public void run()
    {
        ExceptionManager.access$000(ExceptionManager.this).showAlertDialog(null, msgCopy, Integer.valueOf(0x7f080336), new ener(retryFunction), Integer.valueOf(0x7f080084), new ener(cancelFunction), false, true);
    }

    public ener(String s, Function0 function0, Function0 function0_1)
    {
        this$0 = ExceptionManager.this;
        super();
        msgCopy = s;
        retryFunction = function0;
        cancelFunction = function0_1;
    }
}
