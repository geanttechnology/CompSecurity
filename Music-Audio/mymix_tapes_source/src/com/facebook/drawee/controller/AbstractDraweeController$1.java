// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;

// Referenced classes of package com.facebook.drawee.controller:
//            AbstractDraweeController

class val.wasImmediate extends BaseDataSubscriber
{

    final AbstractDraweeController this$0;
    final String val$id;
    final boolean val$wasImmediate;

    public void onFailureImpl(DataSource datasource)
    {
        AbstractDraweeController.access$100(AbstractDraweeController.this, val$id, datasource, datasource.getFailureCause(), true);
    }

    public void onNewResultImpl(DataSource datasource)
    {
        boolean flag = datasource.isFinished();
        float f = datasource.getProgress();
        Object obj = datasource.getResult();
        if (obj != null)
        {
            AbstractDraweeController.access$000(AbstractDraweeController.this, val$id, datasource, obj, f, flag, val$wasImmediate);
        } else
        if (flag)
        {
            AbstractDraweeController.access$100(AbstractDraweeController.this, val$id, datasource, new NullPointerException(), true);
            return;
        }
    }

    public void onProgressUpdate(DataSource datasource)
    {
        boolean flag = datasource.isFinished();
        float f = datasource.getProgress();
        AbstractDraweeController.access$200(AbstractDraweeController.this, val$id, datasource, f, flag);
    }

    ()
    {
        this$0 = final_abstractdraweecontroller;
        val$id = s;
        val$wasImmediate = Z.this;
        super();
    }
}
