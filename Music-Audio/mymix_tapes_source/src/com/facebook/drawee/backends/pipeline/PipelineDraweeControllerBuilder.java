// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.net.Uri;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Set;

// Referenced classes of package com.facebook.drawee.backends.pipeline:
//            PipelineDraweeController, PipelineDraweeControllerFactory

public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder
{

    private final ImagePipeline mImagePipeline;
    private final PipelineDraweeControllerFactory mPipelineDraweeControllerFactory;

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelinedraweecontrollerfactory, ImagePipeline imagepipeline, Set set)
    {
        super(context, set);
        mImagePipeline = imagepipeline;
        mPipelineDraweeControllerFactory = pipelinedraweecontrollerfactory;
    }

    protected DataSource getDataSourceForRequest(ImageRequest imagerequest, Object obj, boolean flag)
    {
        if (flag)
        {
            return mImagePipeline.fetchImageFromBitmapCache(imagerequest, obj);
        } else
        {
            return mImagePipeline.fetchDecodedImage(imagerequest, obj);
        }
    }

    protected volatile DataSource getDataSourceForRequest(Object obj, Object obj1, boolean flag)
    {
        return getDataSourceForRequest((ImageRequest)obj, obj1, flag);
    }

    protected PipelineDraweeControllerBuilder getThis()
    {
        return this;
    }

    protected volatile AbstractDraweeControllerBuilder getThis()
    {
        return getThis();
    }

    protected PipelineDraweeController obtainController()
    {
        Object obj = getOldController();
        if (obj instanceof PipelineDraweeController)
        {
            obj = (PipelineDraweeController)obj;
            ((PipelineDraweeController) (obj)).initialize(obtainDataSourceSupplier(), generateUniqueControllerId(), getCallerContext());
            return ((PipelineDraweeController) (obj));
        } else
        {
            return mPipelineDraweeControllerFactory.newController(obtainDataSourceSupplier(), generateUniqueControllerId(), getCallerContext());
        }
    }

    protected volatile AbstractDraweeController obtainController()
    {
        return obtainController();
    }

    public PipelineDraweeControllerBuilder setUri(Uri uri)
    {
        return (PipelineDraweeControllerBuilder)super.setImageRequest(ImageRequest.fromUri(uri));
    }

    public volatile SimpleDraweeControllerBuilder setUri(Uri uri)
    {
        return setUri(uri);
    }
}
