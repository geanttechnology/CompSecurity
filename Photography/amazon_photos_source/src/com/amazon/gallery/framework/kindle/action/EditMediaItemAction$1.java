// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.content.Context;
import com.amazon.gallery.foundation.utils.async.CancellableBlockingProgressDialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.EditType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            EditMediaItemAction

class ressDialog extends CancellableBlockingProgressDialog
{

    final EditMediaItemAction this$0;
    final MediaItem val$mediaItem;

    protected transient File doInBackground(MediaItem amediaitem[])
    {
        amediaitem = amediaitem[0];
        if (!EditMediaItemAction.access$000(EditMediaItemAction.this).isNetworkConnected())
        {
            GLogger.d(EditMediaItemAction.access$100(), "No network. Falling back to using a 1024 or larger cut, if possible", new Object[0]);
            Asset asset = EditMediaItemAction.access$200(EditMediaItemAction.this).getBestExistingAsset(amediaitem, 2048);
            if (asset != null && asset.getP2Size() >= com.amazon.gallery.framework.data.store.ND_1024.Size())
            {
                return EditMediaItemAction.access$300(EditMediaItemAction.this, amediaitem.getName(), asset.getAsset());
            } else
            {
                return null;
            }
        } else
        {
            EditMediaItemAction.access$400(EditMediaItemAction.this).loadContentSynchronously(amediaitem, true);
            return EditMediaItemAction.access$200(EditMediaItemAction.this).getOriginal(amediaitem);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((MediaItem[])aobj);
    }

    protected void onPostExecute(File file)
    {
        super.onPostExecute(file);
        if (file == null || !file.exists())
        {
            if (!EditMediaItemAction.access$500(EditMediaItemAction.this).promptIfOffline(context))
            {
                GLogger.w(EditMediaItemAction.access$100(), "Failed to retrieve the asset file from the cloud - something went wrong", new Object[0]);
            }
            return;
        } else
        {
            EditMediaItemAction.access$600(EditMediaItemAction.this, file, val$mediaItem, EditType.CLOUD);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((File)obj);
    }

    vity(int i, boolean flag, MediaItem mediaitem)
    {
        this$0 = final_editmediaitemaction;
        val$mediaItem = mediaitem;
        super(Context.this, i, flag);
    }
}
