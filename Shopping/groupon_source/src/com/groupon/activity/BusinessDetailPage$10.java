// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;

// Referenced classes of package com.groupon.activity:
//            BusinessDetailPage

class this._cls0
    implements Function2
{

    final BusinessDetailPage this$0;

    public volatile void execute(Object obj, Object obj1)
        throws Exception
    {
        execute((Runnable)obj, (Exception)obj1);
    }

    public void execute(Runnable runnable, Exception exception)
    {
        if (!BusinessDetailPage.access$900(BusinessDetailPage.this))
        {
            runnable = BusinessDetailPage.access$1000(BusinessDetailPage.this).getDialogFragment(Integer.valueOf(0x7f080165));
            runnable.setCancelable(false);
            GrouponDialogFragment.show(getFragmentManager(), runnable, "http_error_dialog");
        }
    }

    ()
    {
        this$0 = BusinessDetailPage.this;
        super();
    }
}
