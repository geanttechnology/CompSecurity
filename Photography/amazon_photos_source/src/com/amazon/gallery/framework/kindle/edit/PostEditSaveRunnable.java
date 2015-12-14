// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.edit;

import android.content.Intent;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.RevertContentObserverEvent;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.media.EditType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.kindle.edit:
//            ProcessImageEditsUtil

public class PostEditSaveRunnable
    implements Runnable
{

    private static final String TAG = com/amazon/gallery/framework/kindle/edit/PostEditSaveRunnable.getName();
    private final NativeGalleryActivity activity;
    private final ProcessImageEditsUtil aviaryProcessImageEditsUtil;
    private final Tag currentTag;
    private final EditType editType;
    private final Uri editedPhotoUri;

    public PostEditSaveRunnable(NativeGalleryActivity nativegalleryactivity, EditType edittype, ProcessImageEditsUtil processimageeditsutil, Uri uri, Tag tag)
    {
        activity = nativegalleryactivity;
        editType = edittype;
        aviaryProcessImageEditsUtil = processimageeditsutil;
        editedPhotoUri = uri;
        currentTag = tag;
    }

    public void run()
    {
        GlobalMessagingBus.post(new ToggleContentObserverEvent(false, true));
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$EditType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$EditType = new int[EditType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.CLOUD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.LOCAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.UNIFIED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.model.media.EditType[editType.ordinal()];
        JVM INSTR tableswitch 1 3: default 226
    //                   1 69
    //                   2 119
    //                   3 134;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_134;
_L1:
        throw new UnsupportedOperationException();
        Exception exception;
        exception;
        GlobalMessagingBus.post(new RevertContentObserverEvent());
        throw exception;
_L2:
        MediaItem mediaitem = aviaryProcessImageEditsUtil.processCloudEdit(editedPhotoUri, currentTag);
_L5:
        GlobalMessagingBus.post(new RevertContentObserverEvent());
        if (mediaitem == null || activity == null)
        {
            GLogger.i(TAG, "post edit activity or MediaItem is null", new Object[0]);
            return;
        } else
        {
            MediaContentConfiguration mediacontentconfiguration = activity.getMediaContentConfiguration();
            Intent intent = new Intent(activity, com/amazon/gallery/framework/kindle/activity/SingleViewActivity);
            intent.putExtra("aviaryMediaItem", true);
            intent.putExtra("mediaItem", mediaitem.getObjectId());
            intent.putExtra("mediaItemId", mediaitem.getId());
            IntentUtil.setExtrasForDescriptor(mediacontentconfiguration.toViewDescriptor(), intent);
            activity.startActivity(intent);
            return;
        }
_L3:
        mediaitem = aviaryProcessImageEditsUtil.processLocalEdit(editedPhotoUri);
          goto _L5
        mediaitem = aviaryProcessImageEditsUtil.processUnifiedEdit(editedPhotoUri, currentTag);
          goto _L5
    }

}
