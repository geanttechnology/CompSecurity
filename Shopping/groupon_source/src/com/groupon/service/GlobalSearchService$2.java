// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            GlobalSearchService

class val.exceptionListener extends Http
{

    final GlobalSearchService this$0;
    final Function1 val$exceptionListener;
    final Function1 val$successListener;

    protected void onException(Exception exception)
    {
        val$exceptionListener.execute(exception);
    }

    protected void onSuccess(com.groupon.models.t t)
        throws Exception
    {
        val$successListener.execute(t.locationsAutocompleteResults);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models.t)obj);
    }

    protected boolean shouldRetry()
    {
        return false;
    }

    transient (String s, Object aobj[], Function1 function1, Function1 function1_1)
    {
        this$0 = final_globalsearchservice;
        val$successListener = function1;
        val$exceptionListener = function1_1;
        super(final_context, Class.this, s, aobj);
    }
}
