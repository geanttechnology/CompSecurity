// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            ProducerContextCallbacks, ProducerListener

public interface ProducerContext
{

    public abstract void addCallbacks(ProducerContextCallbacks producercontextcallbacks);

    public abstract Object getCallerContext();

    public abstract String getId();

    public abstract ImageRequest getImageRequest();

    public abstract ProducerListener getListener();

    public abstract com.facebook.imagepipeline.request.ImageRequest.RequestLevel getLowestPermittedRequestLevel();

    public abstract Priority getPriority();

    public abstract boolean isIntermediateResultExpected();

    public abstract boolean isPrefetch();
}
