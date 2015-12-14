// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.model.stream:
//            StreamFileLoader

public static class 
    implements ModelLoaderFactory
{

    public ModelLoader build(Context context, GenericLoaderFactory genericloaderfactory)
    {
        return new StreamFileLoader(genericloaderfactory.buildModelLoader(android/net/Uri, java/io/InputStream));
    }

    public void teardown()
    {
    }

    public ()
    {
    }
}
