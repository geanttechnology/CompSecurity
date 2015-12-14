// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.navigation;

import com.amazon.gallery.framework.gallery.view.NoOpViewStateListener;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.thor.view.PhotosNavigationPane;

public class GalleryPanelViewListener extends NoOpViewStateListener
{

    private final PhotosNavigationPane navPane;

    public GalleryPanelViewListener(PhotosNavigationPane photosnavigationpane)
    {
        navPane = photosnavigationpane;
    }

    public void onViewStateChange(ViewDescriptor viewdescriptor, boolean flag)
    {
        com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType collectiontype;
        int i;
        byte byte0;
        collectiontype = viewdescriptor.getCollectionType();
        byte0 = -1;
        i = byte0;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.CUSTOM_DATA_SET.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_PROPERTY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.MEDIA_TYPE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[collectiontype.ordinal()];
        JVM INSTR tableswitch 1 5: default 56
    //                   1 72
    //                   2 60
    //                   3 79
    //                   4 100
    //                   5 124;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        i = byte0;
_L8:
        navPane.select(i);
        return;
_L2:
        i = 0x7f0c0268;
        continue; /* Loop/switch isn't completed */
_L4:
        i = byte0;
        if (viewdescriptor.getMediaProperty() == CommonMediaProperty.CAMERA)
        {
            i = 0x7f0c026c;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (viewdescriptor.getMediaType() == MediaType.VIDEO)
        {
            i = 0x7f0c026b;
        } else
        {
            i = 0x7f0c0268;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (viewdescriptor.inLocalCollection())
        {
            i = 0x7f0c026d;
        } else
        {
            i = 0x7f0c026a;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }
}
