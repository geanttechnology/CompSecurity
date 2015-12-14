// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.provider;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;

// Referenced classes of package com.bumptech.glide.provider:
//            DataLoadProvider

public interface LoadProvider
    extends DataLoadProvider
{

    public abstract ModelLoader getModelLoader();

    public abstract ResourceTranscoder getTranscoder();
}
