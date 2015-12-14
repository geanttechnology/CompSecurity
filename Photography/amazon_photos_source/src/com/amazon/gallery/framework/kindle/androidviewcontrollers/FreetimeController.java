// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.thor.app.activity.ThorViewActivity;
import java.util.Collections;
import java.util.Map;

public class FreetimeController
    implements AndroidViewController
{

    private final EditMediaItemAction editMediaItemAction;
    private final boolean hasSingleLayout;
    private final NativeGalleryActivity nativeGalleryActivity;

    public FreetimeController(NativeGalleryActivity nativegalleryactivity, EditMediaItemAction editmediaitemaction, boolean flag)
    {
        nativeGalleryActivity = nativegalleryactivity;
        editMediaItemAction = editmediaitemaction;
        hasSingleLayout = flag;
    }

    public boolean onClick(final View mediaItem, int i)
    {
        if (!hasSingleLayout)
        {
            if ((mediaItem = nativeGalleryActivity.getListAdapter()) != null && ((mediaItem = ((View) (mediaItem.getItem(i)))) instanceof MediaItem))
            {
                mediaItem = (MediaItem)mediaItem;
                static class _cls2
                {

                    static final int $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[];

                    static 
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$media$MediaType = new int[MediaType.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.PHOTO.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$gallery$framework$model$media$MediaType[MediaType.VIDEO.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                Intent intent;
                switch (_cls2..SwitchMap.com.amazon.gallery.framework.model.media.MediaType[mediaItem.getType().ordinal()])
                {
                default:
                    return false;

                case 1: // '\001'
                    nativeGalleryActivity.runOnUiThread(new Runnable() {

                        final FreetimeController this$0;
                        final MediaItem val$mediaItem;

                        public void run()
                        {
                            editMediaItemAction.execute(Collections.singletonList(mediaItem));
                        }

            
            {
                this$0 = FreetimeController.this;
                mediaItem = mediaitem;
                super();
            }
                    });
                    return true;

                case 2: // '\002'
                    intent = new Intent(nativeGalleryActivity, com/amazon/gallery/thor/app/activity/ThorViewActivity);
                    break;
                }
                intent.setDataAndType(Uri.parse((String)mediaItem.getMetadata().get("media-store.uri")), mediaItem.getMIMEType());
                nativeGalleryActivity.startActivity(intent);
                return true;
            }
        }
        return false;
    }

    public boolean onLongClick(View view, int i)
    {
        return false;
    }

}
