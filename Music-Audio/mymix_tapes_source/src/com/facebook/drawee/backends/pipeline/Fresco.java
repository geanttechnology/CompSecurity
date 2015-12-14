// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineFactory;

// Referenced classes of package com.facebook.drawee.backends.pipeline:
//            PipelineDraweeControllerBuilderSupplier, PipelineDraweeControllerBuilder

public class Fresco
{

    private static PipelineDraweeControllerBuilderSupplier sDraweeControllerBuilderSupplier;

    private Fresco()
    {
    }

    public static PipelineDraweeControllerBuilderSupplier getDraweeControllerBuilderSupplier()
    {
        return sDraweeControllerBuilderSupplier;
    }

    public static ImagePipeline getImagePipeline()
    {
        return getImagePipelineFactory().getImagePipeline();
    }

    public static ImagePipelineFactory getImagePipelineFactory()
    {
        return ImagePipelineFactory.getInstance();
    }

    public static void initialize(Context context)
    {
        ImagePipelineFactory.initialize(context);
        initializeDrawee(context);
    }

    public static void initialize(Context context, ImagePipelineConfig imagepipelineconfig)
    {
        ImagePipelineFactory.initialize(imagepipelineconfig);
        initializeDrawee(context);
    }

    private static void initializeDrawee(Context context)
    {
        sDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(context);
        SimpleDraweeView.initialize(sDraweeControllerBuilderSupplier);
    }

    public static PipelineDraweeControllerBuilder newDraweeControllerBuilder()
    {
        return sDraweeControllerBuilderSupplier.get();
    }

    public static void shutDown()
    {
        sDraweeControllerBuilderSupplier = null;
        SimpleDraweeView.shutDown();
        ImagePipelineFactory.shutDown();
    }
}
