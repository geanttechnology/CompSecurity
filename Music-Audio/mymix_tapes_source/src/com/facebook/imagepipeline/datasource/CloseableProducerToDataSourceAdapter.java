// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;

// Referenced classes of package com.facebook.imagepipeline.datasource:
//            AbstractProducerToDataSourceAdapter

public class CloseableProducerToDataSourceAdapter extends AbstractProducerToDataSourceAdapter
{

    private CloseableProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableproducercontext, RequestListener requestlistener)
    {
        super(producer, settableproducercontext, requestlistener);
    }

    public static DataSource create(Producer producer, SettableProducerContext settableproducercontext, RequestListener requestlistener)
    {
        return new CloseableProducerToDataSourceAdapter(producer, settableproducercontext, requestlistener);
    }

    protected void closeResult(CloseableReference closeablereference)
    {
        CloseableReference.closeSafely(closeablereference);
    }

    protected volatile void closeResult(Object obj)
    {
        closeResult((CloseableReference)obj);
    }

    public CloseableReference getResult()
    {
        return CloseableReference.cloneOrNull((CloseableReference)super.getResult());
    }

    public volatile Object getResult()
    {
        return getResult();
    }

    protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
    {
        super.onNewResultImpl(CloseableReference.cloneOrNull(closeablereference), flag);
    }

    protected volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((CloseableReference)obj, flag);
    }
}
