// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.content.Context;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer

public class GalleryVideoViewerFactory
{

    public static GalleryVideoViewer createGalleryVideoViewer(Context context)
    {
        return new GalleryVideoViewer(context);
    }
}
