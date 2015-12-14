// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.recyclerview;

import com.amazon.gallery.framework.gallery.widget.MediaItemCursorAdapter;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.kindle.recyclerview:
//            AspectRatioLookUp

public class DefaultAspectRatioLookUp
    implements AspectRatioLookUp
{

    private final MediaItemCursorAdapter adapter;

    public DefaultAspectRatioLookUp(MediaItemCursorAdapter mediaitemcursoradapter)
    {
        adapter = mediaitemcursoradapter;
    }

    public float getAspectRatio(int i)
    {
        MediaItem mediaitem = adapter.getItem(i);
        if (mediaitem.getHeight() == 0 || mediaitem.getWidth() == 0)
        {
            return 0.6666667F;
        } else
        {
            return (float)mediaitem.getWidth() / (float)mediaitem.getHeight();
        }
    }

    public int getItemCount()
    {
        return adapter.getCount();
    }
}
