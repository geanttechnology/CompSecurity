// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.os.AsyncTask;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.EditType;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            EditMediaItemAction

private class mediaItem extends AsyncTask
{

    private final MediaItem mediaItem;
    final EditMediaItemAction this$0;

    protected transient File doInBackground(Void avoid[])
    {
        GLogger.i(EditMediaItemAction.access$100(), "Editing cloud photo before it's uploaded, making a copy of temporary local version", new Object[0]);
        avoid = new File(mediaItem.getLocalPath());
        Object obj = (new StringBuilder()).append(EditMediaItemAction.access$700(mediaItem.getName())).append(SystemClock.uptimeMillis()).append(com.amazon.gallery.framework.data.store.sk.mediaItem.mediaItem()).toString();
        obj = new File(EditMediaItemAction.getTempEditDir(EditMediaItemAction.access$800(EditMediaItemAction.this)), ((String) (obj)));
        try
        {
            FileUtils.copyFile(avoid, ((File) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.ex(EditMediaItemAction.access$100(), "Failed to make a copy of the edited image", avoid);
            return ((File) (obj));
        }
        return ((File) (obj));
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(File file)
    {
        if (file != null && file.exists())
        {
            EditMediaItemAction.access$600(EditMediaItemAction.this, file, mediaItem, EditType.CLOUD);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((File)obj);
    }

    public (MediaItem mediaitem)
    {
        this$0 = EditMediaItemAction.this;
        super();
        mediaItem = mediaitem;
    }
}
