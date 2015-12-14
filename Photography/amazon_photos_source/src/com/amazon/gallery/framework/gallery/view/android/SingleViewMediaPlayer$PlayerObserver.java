// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.view.android:
//            SingleViewMediaPlayer

public static interface 
{

    public abstract void onMediaReady(MediaItem mediaitem);

    public abstract void onVideoCompletion();

    public abstract void onVideoError();
}
