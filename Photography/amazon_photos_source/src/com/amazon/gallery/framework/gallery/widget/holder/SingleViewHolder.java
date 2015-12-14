// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget.holder;

import android.view.View;
import android.widget.ImageView;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget.holder:
//            MediaItemViewHolder

public class SingleViewHolder extends MediaItemViewHolder
{

    private View videoPlayButton;

    public SingleViewHolder(MediaItem mediaitem, View view, android.view.View.OnClickListener onclicklistener)
    {
        super(mediaitem, view);
        videoPlayButton.setOnClickListener(onclicklistener);
    }

    protected void initViews(View view)
    {
        setImageView((ImageView)view.findViewById(0x7f0c01e4));
        videoPlayOverlay = view.findViewById(0x7f0c0205);
        videoPlayButton = view.findViewById(0x7f0c0206);
    }
}
