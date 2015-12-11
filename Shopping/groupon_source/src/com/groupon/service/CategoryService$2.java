// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Context;
import com.groupon.http.Http;
import com.groupon.models.category.converter.CategoryConverter;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.service:
//            CategoryService

class val.successCallback extends Http
{

    final CategoryService this$0;
    final Function1 val$successCallback;

    protected void onSuccess(com.groupon.models.category.json.llback llback)
        throws Exception
    {
        super.onSuccess(llback);
        val$successCallback.execute(CategoryService.access$100(CategoryService.this).fromJson(llback));
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((com.groupon.models.category.json.rter.fromJson)obj);
    }

    transient ory.List(Class class1, String s, Object aobj[], Function1 function1)
    {
        this$0 = final_categoryservice;
        val$successCallback = function1;
        super(Context.this, class1, s, aobj);
    }
}
