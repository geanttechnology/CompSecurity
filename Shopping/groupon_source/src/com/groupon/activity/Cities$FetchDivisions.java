// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.service.countryanddivision.DivisionsService;
import com.groupon.util.AbstractRetryAsyncTask;

// Referenced classes of package com.groupon.activity:
//            Cities

public class it> extends AbstractRetryAsyncTask
{

    final Cities this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Cities.access$300(Cities.this).refresh();
        return null;
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((Void)obj);
    }

    protected void onSuccess(Void void1)
        throws Exception
    {
        Cities.access$400(Cities.this);
    }

    public void onUserCancelRetry()
    {
        finish();
    }

    public sionsService(Context context)
    {
        this$0 = Cities.this;
        super(context);
    }
}
