// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            DisplayImageOptions

final class ImageLoadingInfo
{

    final ImageView imageView;
    final ImageLoadingListener listener;
    final ReentrantLock loadFromUriLock;
    final String memoryCacheKey;
    final DisplayImageOptions options;
    final ImageSize targetSize;
    final String uri;

    public ImageLoadingInfo(String s, ImageView imageview, ImageSize imagesize, String s1, DisplayImageOptions displayimageoptions, ImageLoadingListener imageloadinglistener, ReentrantLock reentrantlock)
    {
        uri = s;
        imageView = imageview;
        targetSize = imagesize;
        options = displayimageoptions;
        listener = imageloadinglistener;
        loadFromUriLock = reentrantlock;
        memoryCacheKey = s1;
    }
}
