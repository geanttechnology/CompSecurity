// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.fragment:
//            BusinessTipsFragment

class this._cls0
    implements Function2
{

    final BusinessTipsFragment this$0;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        if (isAdded())
        {
            runnable = BusinessTipsFragment.access$000(BusinessTipsFragment.this).getDialogFragment(Integer.valueOf(0x7f080165));
            runnable.setCancelable(false);
            GrouponDialogFragment.show(getFragmentManager(), runnable, "http_error_dialog");
        }
    }

    ()
    {
        this$0 = BusinessTipsFragment.this;
        super();
    }
}
