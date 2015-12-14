// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.print;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.print.PrintHelper;
import com.amazon.gallery.foundation.gfx.texture.LocalVideoThumbnailResource;
import com.amazon.gallery.foundation.image.VideoThumbnailUtils;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.async.BlockingProgressDialog;
import com.amazon.gallery.foundation.utils.async.CancellableBlockingProgressDialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.framework.gallery.print:
//            GalleryPrintContext

public class AospPrintContext
    implements GalleryPrintContext
{

    public static final String TAG = com/amazon/gallery/framework/gallery/print/AospPrintContext.getName();
    private final int SIZE_TO_PRINT = 2048;
    private Activity context;
    private ShareStore shareStore;

    public AospPrintContext()
    {
    }

    public boolean canExecute(List list)
    {
        return Api.isAtLeastKitkat() && list != null && list.size() == 1;
    }

    public void destroyPrintContext()
    {
        context = null;
    }

    public void prepareItemsToPrint(List list)
    {
        if (list == null || list.size() != 1)
        {
            GLogger.w(TAG, "Android only supports printing one photo at a time", new Object[0]);
            return;
        } else
        {
            String s = context.getString(0x7f0e0128);
            String s1 = context.getString(0x7f0e0127);
            CancellableBlockingProgressDialog cancellableblockingprogressdialog = new CancellableBlockingProgressDialog(context, list.size(), true) {

                final AospPrintContext this$0;

                protected transient Uri doInBackground(MediaItem amediaitem[])
                {
                    amediaitem = amediaitem[0];
                    publishProgress(new Integer[] {
                        Integer.valueOf(0)
                    });
                    if (amediaitem.getType() == MediaType.VIDEO && amediaitem.hasProperty(CommonMediaProperty.LOCAL))
                    {
                        amediaitem = new LocalVideoThumbnailResource(amediaitem.getObjectId(), amediaitem.getLocalPath(), amediaitem.getName());
                        File file = VideoThumbnailUtils.getThumbnailFromCache(context, amediaitem, 2);
                        amediaitem = new File(shareStore.getSharedDirectory(), file.getName());
                        try
                        {
                            FileUtils.copyFile(file, amediaitem);
                        }
                        // Misplaced declaration of an exception variable
                        catch (MediaItem amediaitem[])
                        {
                            amediaitem = null;
                            GLogger.e(AospPrintContext.TAG, "Unable to copy video thumbnail to external storage", new Object[0]);
                        }
                    } else
                    {
                        amediaitem = shareStore.prepareMediaItemForSharing(amediaitem, 2048, 2048, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG);
                    }
                    if (amediaitem == null || !amediaitem.exists())
                    {
                        return null;
                    } else
                    {
                        publishProgress(new Integer[] {
                            Integer.valueOf(1)
                        });
                        GLogger.v(AospPrintContext.TAG, "Prepared print file", new Object[0]);
                        return Uri.fromFile(amediaitem);
                    }
                }

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((MediaItem[])aobj);
                }

                protected void onPostExecute(Uri uri)
                {
                    super.onPostExecute(uri);
                    GlobalMessagingBus.post(new ActionCompleteEvent());
                    if (uri == null)
                    {
                        return;
                    }
                    PrintHelper printhelper = new PrintHelper(context);
                    try
                    {
                        printhelper.printBitmap(uri.getLastPathSegment(), uri);
                        return;
                    }
                    catch (FileNotFoundException filenotfoundexception)
                    {
                        GLogger.w(AospPrintContext.TAG, "Unable to print. %s is an invalid image", new Object[] {
                            uri
                        });
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Uri)obj);
                }

            
            {
                this$0 = AospPrintContext.this;
                super(context1, i, flag);
            }
            };
            cancellableblockingprogressdialog.setDialogTitle(s);
            cancellableblockingprogressdialog.setDialogMessage(s1);
            cancellableblockingprogressdialog.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, list.toArray(new MediaItem[0]));
            return;
        }
    }

    public void setContext(Activity activity)
    {
        context = activity;
    }

    public void setShareStore(ShareStore sharestore)
    {
        shareStore = sharestore;
    }


}
