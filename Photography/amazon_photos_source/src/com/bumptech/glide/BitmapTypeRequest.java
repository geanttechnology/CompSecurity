// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.FixedLoadProvider;

// Referenced classes of package com.bumptech.glide:
//            BitmapRequestBuilder, GenericRequestBuilder, Glide

public class BitmapTypeRequest extends BitmapRequestBuilder
{

    private final ModelLoader fileDescriptorModelLoader;
    private final Glide glide;
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader streamModelLoader;

    BitmapTypeRequest(GenericRequestBuilder genericrequestbuilder, ModelLoader modelloader, ModelLoader modelloader1, RequestManager.OptionsApplier optionsapplier)
    {
        super(buildProvider(genericrequestbuilder.glide, modelloader, modelloader1, android/graphics/Bitmap, null), android/graphics/Bitmap, genericrequestbuilder);
        streamModelLoader = modelloader;
        fileDescriptorModelLoader = modelloader1;
        glide = genericrequestbuilder.glide;
        optionsApplier = optionsapplier;
    }

    private static FixedLoadProvider buildProvider(Glide glide1, ModelLoader modelloader, ModelLoader modelloader1, Class class1, ResourceTranscoder resourcetranscoder)
    {
        if (modelloader == null && modelloader1 == null)
        {
            return null;
        }
        ResourceTranscoder resourcetranscoder1 = resourcetranscoder;
        if (resourcetranscoder == null)
        {
            resourcetranscoder1 = glide1.buildTranscoder(android/graphics/Bitmap, class1);
        }
        glide1 = glide1.buildDataProvider(com/bumptech/glide/load/model/ImageVideoWrapper, android/graphics/Bitmap);
        return new FixedLoadProvider(new ImageVideoModelLoader(modelloader, modelloader1), resourcetranscoder1, glide1);
    }
}
