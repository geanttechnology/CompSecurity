// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.payment;

import android.app.Activity;
import android.view.View;
import com.groupon.activity.IntentFactory;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.models.payment:
//            IsracardPaymentMethod

class this._cls0
    implements android.view.ymentMethod._cls1
{

    final IsracardPaymentMethod this$0;

    public void onClick(View view)
    {
        view = (IntentFactory)RoboGuice.getInjector(context).getInstance(com/groupon/activity/IntentFactory);
        activity.startActivityForResult(view.newEditIsracardIntent(), 10102);
    }

    ()
    {
        this$0 = IsracardPaymentMethod.this;
        super();
    }
}
