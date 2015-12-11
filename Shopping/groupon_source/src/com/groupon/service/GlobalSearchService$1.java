// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            GlobalSearchService

class val.listener extends Http
{

    final GlobalSearchService this$0;
    final Function1 val$listener;

    protected void onException(Exception exception)
    {
    }

    protected void onSuccess(com.groupon.models. )
        throws Exception
    {
        val$listener.execute(.dealsAutocompleteResults);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models..onSuccess)obj);
    }

    transient (Class class1, String s, Object aobj[], Function1 function1)
    {
        this$0 = final_globalsearchservice;
        val$listener = function1;
        super(Context.this, class1, s, aobj);
    }
}
