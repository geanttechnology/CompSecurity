// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.models.error.GrouponException;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;

// Referenced classes of package com.groupon.manager:
//            ExceptionManager

protected class cancelFunction
    implements Runnable
{

    protected final Function0 cancelFunction;
    protected final GrouponException grouponException;
    final ExceptionManager this$0;

    public void run()
    {
        ExceptionManager.access$000(ExceptionManager.this).showAlertDialog(grouponException, new (cancelFunction));
    }

    public (GrouponException grouponexception, Function0 function0)
    {
        this$0 = ExceptionManager.this;
        super();
        grouponException = grouponexception;
        cancelFunction = function0;
    }
}
