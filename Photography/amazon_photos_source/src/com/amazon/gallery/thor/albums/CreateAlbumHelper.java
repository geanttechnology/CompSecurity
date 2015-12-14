// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumHelper, CreateAlbumDialog

public class CreateAlbumHelper extends AlbumHelper
{

    private static final String TAG = com/amazon/gallery/thor/albums/CreateAlbumHelper.getName();
    private final CharSequence albumNameToUse;
    private final List mediaItemsToAdd;
    private final ComponentProfiler profiler;

    public CreateAlbumHelper(BeanAwareActivity beanawareactivity, ComponentProfiler componentprofiler)
    {
        this(beanawareactivity, componentprofiler, null, null);
    }

    public CreateAlbumHelper(BeanAwareActivity beanawareactivity, ComponentProfiler componentprofiler, CharSequence charsequence, List list)
    {
        super(beanawareactivity);
        profiler = componentprofiler;
        albumNameToUse = charsequence;
        mediaItemsToAdd = list;
    }

    public void execute()
    {
        if (promptIfOffline())
        {
            return;
        }
        CreateAlbumDialog createalbumdialog = new CreateAlbumDialog();
        if (albumNameToUse != null)
        {
            createalbumdialog.setAlbumName(albumNameToUse);
        }
        if (mediaItemsToAdd != null)
        {
            createalbumdialog.setMediaItemsList(mediaItemsToAdd);
        }
        createalbumdialog.setProfiler(profiler);
        createalbumdialog.show(((BeanAwareActivity)getActivity()).getSupportFragmentManager(), TAG);
    }

}
