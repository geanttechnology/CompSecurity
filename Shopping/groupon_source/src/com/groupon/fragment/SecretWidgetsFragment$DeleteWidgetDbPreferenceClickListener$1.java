// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.db.models.WidgetSummary;
import java.util.concurrent.Callable;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretWidgetsFragment

class this._cls1
    implements Callable
{

    final is._cls0 this$1;

    public Object call()
        throws Exception
    {
        ((GrouponOrmLiteHelper)SecretWidgetsFragment.access$200(_fld0).get()).clearTables(new Class[] {
            com/groupon/db/models/WidgetSummary
        });
        return null;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
