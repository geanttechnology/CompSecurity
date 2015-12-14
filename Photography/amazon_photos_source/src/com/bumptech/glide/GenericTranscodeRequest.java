// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.Context;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.FixedLoadProvider;
import com.bumptech.glide.provider.LoadProvider;

// Referenced classes of package com.bumptech.glide:
//            GenericRequestBuilder, Glide

public class GenericTranscodeRequest extends GenericRequestBuilder
{

    private final Class dataClass;
    private final ModelLoader modelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final Class resourceClass;

    GenericTranscodeRequest(Context context, Glide glide, Class class1, ModelLoader modelloader, Class class2, Class class3, RequestTracker requesttracker, 
            Lifecycle lifecycle, RequestManager.OptionsApplier optionsapplier)
    {
        super(context, class1, build(glide, modelloader, class2, class3, UnitTranscoder.get()), class3, glide, requesttracker, lifecycle);
        modelLoader = modelloader;
        dataClass = class2;
        resourceClass = class3;
        optionsApplier = optionsapplier;
    }

    private static LoadProvider build(Glide glide, ModelLoader modelloader, Class class1, Class class2, ResourceTranscoder resourcetranscoder)
    {
        return new FixedLoadProvider(modelloader, resourcetranscoder, glide.buildDataProvider(class1, class2));
    }
}
