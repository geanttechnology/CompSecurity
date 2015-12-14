// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ImagePipeline

class val.callerContext
    implements Supplier
{

    final ImagePipeline this$0;
    final boolean val$bitmapCacheOnly;
    final Object val$callerContext;
    final ImageRequest val$imageRequest;

    public DataSource get()
    {
        if (val$bitmapCacheOnly)
        {
            return fetchImageFromBitmapCache(val$imageRequest, val$callerContext);
        } else
        {
            return fetchDecodedImage(val$imageRequest, val$callerContext);
        }
    }

    public volatile Object get()
    {
        return get();
    }

    public String toString()
    {
        return Objects.toStringHelper(this).add("uri", val$imageRequest.getSourceUri()).toString();
    }

    per()
    {
        this$0 = final_imagepipeline;
        val$bitmapCacheOnly = flag;
        val$imageRequest = imagerequest;
        val$callerContext = Object.this;
        super();
    }
}
