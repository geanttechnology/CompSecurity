// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.models.category.json.FacetsContainer;
import com.groupon.network.HttpResponseException;
import com.groupon.util.Function1;
import com.groupon.util.GlobalCategoriesRequester;

// Referenced classes of package com.groupon.service:
//            CategoryService

class ster extends GlobalCategoriesRequester
{

    final CategoryService this$0;
    final Function1 val$errorCallback;
    final Function1 val$successCallback;

    protected void onException(Exception exception)
    {
        int i;
        if (exception instanceof HttpResponseException)
        {
            i = ((HttpResponseException)exception).getStatusCode();
        } else
        {
            i = 0;
        }
        switch (i)
        {
        default:
            ignoreHttpErrors();
            if (val$errorCallback != null)
            {
                val$errorCallback.execute(exception);
            }
            return;

        case 401: 
            break;
        }
        if (val$errorCallback != null)
        {
            val$errorCallback.execute(exception);
        }
        super.onException(exception);
    }

    protected void onSuccess(FacetsContainer facetscontainer)
        throws Exception
    {
        super.onSuccess(facetscontainer);
        facetscontainer = CategoryService.access$200(CategoryService.this, facetscontainer);
        val$successCallback.execute(facetscontainer);
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((FacetsContainer)obj);
    }

    sContainer(String s, String s1, String s2, int i, 
            Function1 function1, Function1 function1_1)
    {
        this$0 = final_categoryservice;
        val$successCallback = function1;
        val$errorCallback = function1_1;
        super(final_context, Class.this, s, s1, s2, i);
    }
}
