// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;

// Referenced classes of package com.bumptech.glide:
//            DrawableRequestBuilder, Glide, BitmapTypeRequest

public class DrawableTypeRequest extends DrawableRequestBuilder
{

    private final ModelLoader fileDescriptorModelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader streamModelLoader;

    DrawableTypeRequest(Class class1, ModelLoader modelloader, ModelLoader modelloader1, Context context, Glide glide, RequestTracker requesttracker, Lifecycle lifecycle, 
            RequestManager.OptionsApplier optionsapplier)
    {
        super(context, class1, buildProvider(glide, modelloader, modelloader1, com/bumptech/glide/load/resource/gifbitmap/GifBitmapWrapper, com/bumptech/glide/load/resource/drawable/GlideDrawable, null), glide, requesttracker, lifecycle);
        streamModelLoader = modelloader;
        fileDescriptorModelLoader = modelloader1;
        optionsApplier = optionsapplier;
    }

    private static FixedLoadProvider buildProvider(Glide glide, ModelLoader modelloader, ModelLoader modelloader1, Class class1, Class class2, ResourceTranscoder resourcetranscoder)
    {
        if (modelloader == null && modelloader1 == null)
        {
            return null;
        }
        ResourceTranscoder resourcetranscoder1 = resourcetranscoder;
        if (resourcetranscoder == null)
        {
            resourcetranscoder1 = glide.buildTranscoder(class1, class2);
        }
        glide = glide.buildDataProvider(com/bumptech/glide/load/model/ImageVideoWrapper, class1);
        return new FixedLoadProvider(new ImageVideoModelLoader(modelloader, modelloader1), resourcetranscoder1, glide);
    }

    public BitmapTypeRequest asBitmap()
    {
        return (BitmapTypeRequest)optionsApplier.apply(new BitmapTypeRequest(this, streamModelLoader, fileDescriptorModelLoader, optionsApplier));
    }
}
