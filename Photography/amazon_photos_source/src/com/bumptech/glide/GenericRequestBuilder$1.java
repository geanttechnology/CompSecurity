// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import com.bumptech.glide.request.RequestFutureTarget;

// Referenced classes of package com.bumptech.glide:
//            GenericRequestBuilder

class get
    implements Runnable
{

    final GenericRequestBuilder this$0;
    final RequestFutureTarget val$target;

    public void run()
    {
        if (!val$target.isCancelled())
        {
            into(val$target);
        }
    }

    get()
    {
        this$0 = final_genericrequestbuilder;
        val$target = RequestFutureTarget.this;
        super();
    }
}
