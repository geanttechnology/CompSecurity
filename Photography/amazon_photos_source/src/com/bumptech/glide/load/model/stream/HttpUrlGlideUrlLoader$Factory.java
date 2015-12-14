// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

// Referenced classes of package com.bumptech.glide.load.model.stream:
//            HttpUrlGlideUrlLoader

public static class 
    implements ModelLoaderFactory
{

    private final ModelCache modelCache = new ModelCache(500);

    public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
    {
        return new HttpUrlGlideUrlLoader(modelCache);
    }

    public void teardown()
    {
    }

    public ()
    {
    }
}
