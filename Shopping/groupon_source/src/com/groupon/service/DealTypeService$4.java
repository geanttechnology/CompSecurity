// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            DealTypeService

class val.r extends Http
{

    final DealTypeService this$0;
    final Runnable val$r;

    protected void onException(Exception exception)
    {
    }

    protected void onSuccess(com.groupon.models.dealtype.per per)
        throws Exception
    {
        if (per != null)
        {
            per = DealTypeService.access$300(DealTypeService.this, per.dealTypes);
        } else
        {
            per = null;
        }
        java.util.HashMap _tmp = DealTypeService.access$202(per);
        Ln.d("DEALTYPES: cache response: %s", new Object[] {
            DealTypeService.access$200()
        });
        val$r.run();
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models.dealtype.per)obj);
    }

    ListWrapper(Class class1, String s, Runnable runnable)
    {
        this$0 = final_dealtypeservice;
        val$r = runnable;
        super(Context.this, class1, s);
    }
}
