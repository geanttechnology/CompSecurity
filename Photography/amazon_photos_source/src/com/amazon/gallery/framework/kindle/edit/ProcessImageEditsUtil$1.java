// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.edit;

import android.media.ExifInterface;
import android.util.Log;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.IOException;

// Referenced classes of package com.amazon.gallery.framework.kindle.edit:
//            ProcessImageEditsUtil

class val.newMediaItem
    implements Runnable
{

    final ProcessImageEditsUtil this$0;
    final MediaItem val$newMediaItem;

    public void run()
    {
        try
        {
            ExifInterface exifinterface = new ExifInterface(val$newMediaItem.getLocalPath());
            exifinterface.setAttribute("DateTime", DateUtils.getDateFormatWithoutTimeZone(val$newMediaItem.getDateCreatedMs()));
            exifinterface.saveAttributes();
            return;
        }
        catch (IOException ioexception)
        {
            Log.w(ProcessImageEditsUtil.access$000(), "Failed to write EXIF Data");
        }
    }

    ()
    {
        this$0 = final_processimageeditsutil;
        val$newMediaItem = MediaItem.this;
        super();
    }
}
