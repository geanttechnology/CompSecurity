// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.CheckBox;
import com.groupon.util.ReturningFunction1;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            Purchase

class this._cls0
    implements ReturningFunction1
{

    final Purchase this$0;

    public Boolean execute(Exception exception)
    {
        Ln.d("SUBSCRIPTIONS: exception when getting Email Subscriptions", new Object[0]);
        newsletterOptin.setVisibility(0);
        return Boolean.valueOf(false);
    }

    public volatile Object execute(Object obj)
        throws Exception
    {
        return execute((Exception)obj);
    }

    on1()
    {
        this$0 = Purchase.this;
        super();
    }
}
