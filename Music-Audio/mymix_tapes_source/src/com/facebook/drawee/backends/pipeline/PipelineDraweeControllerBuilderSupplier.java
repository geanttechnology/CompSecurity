// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import java.util.Set;

// Referenced classes of package com.facebook.drawee.backends.pipeline:
//            PipelineDraweeControllerFactory, PipelineDraweeControllerBuilder

public class PipelineDraweeControllerBuilderSupplier
    implements Supplier
{

    private final Set mBoundControllerListeners;
    private final Context mContext;
    private final ImagePipeline mImagePipeline;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilderSupplier(Context context)
    {
        this(context, ImagePipelineFactory.getInstance());
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagepipelinefactory)
    {
        this(context, imagepipelinefactory, null);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagepipelinefactory, Set set)
    {
        mContext = context;
        mImagePipeline = imagepipelinefactory.getImagePipeline();
        mPipelineDraweeControllerFactory = new PipelineDraweeControllerFactory(context.getResources(), DeferredReleaser.getInstance(), imagepipelinefactory.getAnimatedDrawableFactory(), UiThreadImmediateExecutorService.getInstance());
        mBoundControllerListeners = set;
    }

    public PipelineDraweeControllerBuilder get()
    {
        return new PipelineDraweeControllerBuilder(mContext, mPipelineDraweeControllerFactory, mImagePipeline, mBoundControllerListeners);
    }

    public volatile Object get()
    {
        return get();
    }
}
