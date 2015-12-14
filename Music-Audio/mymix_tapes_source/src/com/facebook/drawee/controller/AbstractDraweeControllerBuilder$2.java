// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.controller;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;

// Referenced classes of package com.facebook.drawee.controller:
//            AbstractDraweeControllerBuilder

class val.bitmapCacheOnly
    implements Supplier
{

    final AbstractDraweeControllerBuilder this$0;
    final boolean val$bitmapCacheOnly;
    final Object val$callerContext;
    final Object val$imageRequest;

    public DataSource get()
    {
        return getDataSourceForRequest(val$imageRequest, val$callerContext, val$bitmapCacheOnly);
    }

    public volatile Object get()
    {
        return get();
    }

    public String toString()
    {
        return Objects.toStringHelper(this)._mth2("request", val$imageRequest.toString()).imageRequest();
    }

    ()
    {
        this$0 = final_abstractdraweecontrollerbuilder;
        val$imageRequest = obj;
        val$callerContext = obj1;
        val$bitmapCacheOnly = Z.this;
        super();
    }
}
