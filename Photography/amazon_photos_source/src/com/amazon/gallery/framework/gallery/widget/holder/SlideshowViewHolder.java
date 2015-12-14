// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.view.View;
import android.widget.ImageView;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            ItemViewHolder

public class SlideshowViewHolder extends ItemViewHolder
{

    public SlideshowViewHolder(MediaItem mediaitem, View view)
    {
        super(mediaitem, view);
        setImageView((ImageView)view.findViewById(0x7f0c01e4));
    }
}
