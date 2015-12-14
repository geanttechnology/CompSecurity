// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import android.content.Context;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.view.android:
//            SingleViewMediaPlayer

public interface SingleViewMediaPlayerFactory
{

    public abstract SingleViewMediaPlayer getPlayerForMediaItem(MediaItem mediaitem, Context context);
}
