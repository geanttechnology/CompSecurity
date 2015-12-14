// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;

public interface CacheKeyFactory
{

    public abstract CacheKey getBitmapCacheKey(ImageRequest imagerequest);

    public abstract Uri getCacheKeySourceUri(Uri uri);

    public abstract CacheKey getEncodedCacheKey(ImageRequest imagerequest);

    public abstract CacheKey getPostprocessedBitmapCacheKey(ImageRequest imagerequest);
}
