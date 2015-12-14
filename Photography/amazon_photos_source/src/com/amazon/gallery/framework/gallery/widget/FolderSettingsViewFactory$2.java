// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.os.AsyncTask;
import android.widget.TextView;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            FolderSettingsViewFactory, FolderSettingsViewHolder

class val.finalHolder extends AsyncTask
{

    final FolderSettingsViewFactory this$0;
    final FolderSettingsViewHolder val$finalHolder;
    final Tag val$tag;

    protected transient gSizeInfo doInBackground(Void avoid[])
    {
        return new gSizeInfo(FolderSettingsViewFactory.access$100(FolderSettingsViewFactory.this).getMediaItemCount(val$tag), FolderSettingsViewFactory.access$100(FolderSettingsViewFactory.this).getMediaItemSizeForTag(val$tag));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(gSizeInfo gsizeinfo)
    {
        if (BuildFlavors.isDebug() && gsizeinfo == null)
        {
            GLogger.ex(FolderSettingsViewFactory.access$200(), "TagSizeInfo is null, expected non-null value", new InvalidParameterException());
            return;
        } else
        {
            val$finalHolder.subtitleText.setText(FolderSettingsViewFactory.access$300(FolderSettingsViewFactory.this, gsizeinfo));
            FolderSettingsViewFactory.access$400(FolderSettingsViewFactory.this).put(val$tag.getObjectId(), gsizeinfo);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((gSizeInfo)obj);
    }

    gSizeInfo()
    {
        this$0 = final_foldersettingsviewfactory;
        val$tag = tag1;
        val$finalHolder = FolderSettingsViewHolder.this;
        super();
    }
}
