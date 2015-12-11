// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.category.converter.CategoryConverter;
import com.groupon.models.category.json.FacetsContainer;
import com.groupon.models.country.Country;
import com.groupon.network.HttpResponseException;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.Function1;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            CategoryService

class val.successCallback extends Http
{

    final CategoryService this$0;
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
            return;

        case 401: 
            super.onException(exception);
            break;
        }
    }

    protected void onSuccess(Object obj)
        throws Exception
    {
        if (CategoryService.access$000(CategoryService.this).getCurrentCountry().isRussia())
        {
            obj = CategoryService.access$100(CategoryService.this).fromJson((com.groupon.models.category.json.rter.fromJson)obj);
        } else
        {
            obj = (FacetsContainer)obj;
            obj = CategoryService.access$200(CategoryService.this, ((FacetsContainer) (obj)));
        }
        val$successCallback.execute(obj);
        Ln.d("NearbyDeals:cat:%s", new Object[] {
            Integer.valueOf(((List) (obj)).size())
        });
    }

    transient sContainer(Class class1, String s, Object aobj[], Function1 function1)
    {
        this$0 = final_categoryservice;
        val$successCallback = function1;
        super(Context.this, class1, s, aobj);
    }
}
