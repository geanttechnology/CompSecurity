// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import android.net.Uri;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.Chooser;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.kindle.androidviewcontrollers:
//            ChooserController

class val.mediaItem
    implements Runnable
{

    final ChooserController this$0;
    final MediaItem val$mediaItem;

    public void run()
    {
        BlockingSpinnerDialog blockingspinnerdialog = new BlockingSpinnerDialog(ChooserController.access$000(ChooserController.this), new Runnable() {

            final ChooserController._cls1 this$1;

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
                obj = ((ShareStore)ChooserController.access$000(this$0).getApplicationBean(Keys.SHARE_STORE)).prepareMediaItemForSharing(mediaItem, 2048, 2048, ((com.amazon.gallery.framework.data.store.Asset.AssetType) (obj)));
                if (obj != null)
                {
                    String s;
                    Chooser chooser;
                    if (BuildFlavors.isGen5())
                    {
                        obj = Uri.fromFile(((java.io.File) (obj)));
                    } else
                    {
                        obj = ChooserController.access$100(this$0, mediaItem, ((java.io.File) (obj)));
                    }
                    chooser = (Chooser)ChooserController.access$000(this$0);
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
                this$1 = ChooserController._cls1.this;
                super();
            }
        });
        blockingspinnerdialog.setDialogTitle(ChooserController.access$000(ChooserController.this).getString(0x7f0e015b));
        blockingspinnerdialog.setDialogMessage(ChooserController.access$000(ChooserController.this).getString(0x7f0e015a));
        blockingspinnerdialog.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    _cls1.this._cls1()
    {
        this$0 = final_choosercontroller;
        val$mediaItem = MediaItem.this;
        super();
    }
}
