// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.error.GrouponException;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.ReturningFunction1;

// Referenced classes of package com.groupon.activity:
//            EditCreditCard

class this._cls0
    implements ReturningFunction1
{

    final EditCreditCard this$0;

    public Boolean execute(Exception exception)
    {
        if (exception instanceof GrouponException)
        {
            exception = EditCreditCard.access$700(EditCreditCard.this).getDialogFragment(exception.getMessage().replaceFirst("^(\\w+)\\W+([A-Z].*)$", "$2"));
            GrouponDialogFragment.show(getFragmentManager(), exception, "generic_error_dialog");
            return Boolean.valueOf(false);
        } else
        {
            return Boolean.valueOf(true);
        }
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    ()
    {
        this$0 = EditCreditCard.this;
        super();
    }
}
