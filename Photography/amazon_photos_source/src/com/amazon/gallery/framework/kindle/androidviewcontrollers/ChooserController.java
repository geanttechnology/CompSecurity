// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreHelper;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.Chooser;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import java.io.File;
import java.util.Map;
import java.util.Set;

public class ChooserController
    implements AndroidViewController
{

    private final NativeGalleryActivity activity;

    public ChooserController(NativeGalleryActivity nativegalleryactivity)
    {
        activity = nativegalleryactivity;
    }

    private Uri getUriForSharing(MediaItem mediaitem, File file)
    {
        Uri uri = null;
        MediaStoreHelper mediastorehelper = (MediaStoreHelper)activity.getApplicationBean(Keys.MEDIA_STORE_HELPER);
        boolean flag;
        if (MediaType.PHOTO == mediaitem.getType() || MediaType.VIDEO == mediaitem.getType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        DebugAssert.assertTrue(flag);
        if ("vnd.android.cursor.dir/image".equals(((Chooser)activity).getImageMediaType()) || MediaType.PHOTO.equals(mediaitem.getType()))
        {
            uri = mediastorehelper.addImageToMediaStore(activity, file, file.getName(), mediaitem.getWidth(), mediaitem.getHeight(), System.currentTimeMillis(), mediaitem.getMIMEType(), 0);
        } else
        if (MediaType.VIDEO.equals(mediaitem.getType()))
        {
            return mediastorehelper.addVideoToMediaStore(activity, file, file.getName(), mediaitem.getWidth(), mediaitem.getHeight(), System.currentTimeMillis(), mediaitem.getMIMEType(), ((Video)mediaitem).getDuration());
        }
        return uri;
    }

    private void processMediaItemURI(final MediaItem mediaItem)
    {
        activity.runOnUiThread(new Runnable() {

            final ChooserController this$0;
            final MediaItem val$mediaItem;

            public void run()
            {
                BlockingSpinnerDialog blockingspinnerdialog = new BlockingSpinnerDialog(activity, new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        Object obj;
                        if (GroupType.LENTICULAR == mediaItem.getGroupType())
                        {
                            obj = com.amazon.gallery.framework.data.store.Asset.AssetType.GIF;
                        } else
                        {
                            obj = com.amazon.gallery.framework.data.store.Asset.AssetType.getAssetType(mediaItem.getType());
                        }
                        obj = ((ShareStore)activity.getApplicationBean(Keys.SHARE_STORE)).prepareMediaItemForSharing(mediaItem, 2048, 2048, ((com.amazon.gallery.framework.data.store.Asset.AssetType) (obj)));
                        if (obj != null)
                        {
                            String s;
                            Chooser chooser;
                            if (BuildFlavors.isGen5())
                            {
                                obj = Uri.fromFile(((File) (obj)));
                            } else
                            {
                                obj = getUriForSharing(mediaItem, ((File) (obj)));
                            }
                            chooser = (Chooser)activity;
                            if (GroupType.LENTICULAR.equals(mediaItem.getGroupType()))
                            {
                                s = "image/gif";
                            } else
                            {
                                s = mediaItem.getMIMEType();
                            }
                            chooser.finishActivityAndAttachResult(((Uri) (obj)), s);
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                blockingspinnerdialog.setDialogTitle(activity.getString(0x7f0e015b));
                blockingspinnerdialog.setDialogMessage(activity.getString(0x7f0e015a));
                blockingspinnerdialog.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }

            
            {
                this$0 = ChooserController.this;
                mediaItem = mediaitem;
                super();
            }
        });
    }

    public boolean onClick(View view, int i)
    {
        Chooser chooser = (Chooser)activity;
        view = ((View) (chooser.getItemAtPosition(i)));
        if (view instanceof MediaItem)
        {
            MediaItem mediaitem = (MediaItem)view;
            if (GroupType.LENTICULAR.equals(mediaitem.getGroupType()))
            {
                processMediaItemURI(mediaitem);
            } else
            if (mediaitem.getProperties().contains(CommonMediaProperty.LOCAL))
            {
                if (BuildFlavors.isGen5())
                {
                    view = Uri.parse(mediaitem.getLocalPath());
                } else
                {
                    view = Uri.parse((String)mediaitem.getMetadata().get("media-store.uri"));
                }
                chooser.finishActivityAndAttachResult(view, mediaitem.getMIMEType());
            } else
            {
                processMediaItemURI(mediaitem);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onLongClick(View view, int i)
    {
        return false;
    }


}
