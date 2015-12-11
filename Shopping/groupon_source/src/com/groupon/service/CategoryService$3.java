// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.models.category.json.FacetsContainer;
import com.groupon.util.Function1;
import com.groupon.util.GoodsCategoriesRequester;

// Referenced classes of package com.groupon.service:
//            CategoryService

class ter extends GoodsCategoriesRequester
{

    final CategoryService this$0;
    final Function1 val$successCallback;

    protected void onSuccess(FacetsContainer facetscontainer)
        throws Exception
    {
        super.onSuccess(facetscontainer);
        if (val$successCallback != null)
        {
            facetscontainer = CategoryService.access$200(CategoryService.this, facetscontainer);
            val$successCallback.execute(facetscontainer);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((FacetsContainer)obj);
    }

    sContainer(Class class1, String s, Function1 function1)
    {
        this$0 = final_categoryservice;
        val$successCallback = function1;
        super(Context.this, class1, s);
    }
}
