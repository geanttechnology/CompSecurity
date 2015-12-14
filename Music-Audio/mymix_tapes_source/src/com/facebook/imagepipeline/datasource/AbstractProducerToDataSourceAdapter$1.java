// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.imagepipeline.producers.BaseConsumer;

// Referenced classes of package com.facebook.imagepipeline.datasource:
//            AbstractProducerToDataSourceAdapter

class this._cls0 extends BaseConsumer
{

    final AbstractProducerToDataSourceAdapter this$0;

    protected void onCancellationImpl()
    {
        AbstractProducerToDataSourceAdapter.access$100(AbstractProducerToDataSourceAdapter.this);
    }

    protected void onFailureImpl(Throwable throwable)
    {
        AbstractProducerToDataSourceAdapter.access$000(AbstractProducerToDataSourceAdapter.this, throwable);
    }

    protected void onNewResultImpl(Object obj, boolean flag)
    {
        AbstractProducerToDataSourceAdapter.this.onNewResultImpl(obj, flag);
    }

    protected void onProgressUpdateImpl(float f)
    {
        AbstractProducerToDataSourceAdapter.access$200(AbstractProducerToDataSourceAdapter.this, f);
    }

    Q()
    {
        this$0 = AbstractProducerToDataSourceAdapter.this;
        super();
    }
}
