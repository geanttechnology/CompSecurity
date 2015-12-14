// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

// Referenced classes of package com.facebook.imagepipeline.datasource:
//            AbstractProducerToDataSourceAdapter

public class ProducerToDataSourceAdapter extends AbstractProducerToDataSourceAdapter
{

    private ProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableproducercontext, RequestListener requestlistener)
    {
        super(producer, settableproducercontext, requestlistener);
    }

    public static DataSource create(Producer producer, SettableProducerContext settableproducercontext, RequestListener requestlistener)
    {
        return new ProducerToDataSourceAdapter(producer, settableproducercontext, requestlistener);
    }
}
