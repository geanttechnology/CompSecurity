// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.net.Uri;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            VideoFramesParams

public static class rescale
{

    private int framesCount;
    private int max;
    private int maxVideoDuration;
    private int min;
    private int minVideoDuration;
    private boolean rescale;
    private Uri videoUri;

    public VideoFramesParams build()
    {
        return new VideoFramesParams(this, null);
    }

    public rescale withMax(int i)
    {
        max = i;
        return this;
    }

    public max withMaxVideoDuration(int i)
    {
        maxVideoDuration = i;
        return this;
    }

    public maxVideoDuration withMin(int i)
    {
        min = i;
        return this;
    }

    public min withVideoUri(Uri uri)
    {
        videoUri = uri;
        return this;
    }








    public ()
    {
        minVideoDuration = 1000;
        maxVideoDuration = 30000;
        framesCount = 10;
        rescale = true;
    }
}
