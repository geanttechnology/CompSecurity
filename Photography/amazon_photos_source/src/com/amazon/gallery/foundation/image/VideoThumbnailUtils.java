// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.amazon.gallery.foundation.gfx.texture.LocalVideoThumbnailResource;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class VideoThumbnailUtils
{

    private static final String TAG = com/amazon/gallery/foundation/image/VideoThumbnailUtils.getName();

    public VideoThumbnailUtils()
    {
    }

    public static File getThumbnailFromCache(Context context, LocalVideoThumbnailResource localvideothumbnailresource, int i)
    {
        Object obj = String.format("%s.%d.jpg", new Object[] {
            localvideothumbnailresource.getTextureKey().toString(), Integer.valueOf(i)
        });
        obj = new File(context.getCacheDir(), ((String) (obj)));
        if (!((File) (obj)).exists())
        {
            saveThumbnailToFile(context, localvideothumbnailresource.getLocalPath(), ((File) (obj)).getAbsolutePath(), i);
        }
        return ((File) (obj));
    }

    public static boolean saveThumbnailToFile(Context context, String s, String s1, int i)
    {
        String s2;
        Context context1;
        String s3;
        String s4;
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        obj = null;
        s2 = null;
        s4 = null;
        s3 = null;
        context1 = obj2;
        s = ThumbnailUtils.createVideoThumbnail(s, i);
        if (s != null) goto _L2; else goto _L1
_L1:
        IOUtils.closeQuietly(null);
        if (s != null)
        {
            s.recycle();
        }
_L4:
        return false;
_L2:
        s3 = s;
        s2 = s;
        context1 = obj2;
        s4 = s;
        File file = File.createTempFile("video", null, context.getCacheDir());
        s3 = s;
        s2 = s;
        context1 = obj2;
        s4 = s;
        context = new BufferedOutputStream(new FileOutputStream(file), 32768);
        boolean flag;
        s.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, context);
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_152;
        }
        flag = file.renameTo(new File(s1));
        IOUtils.closeQuietly(context);
        if (s != null)
        {
            s.recycle();
        }
        return flag;
        IOUtils.closeQuietly(context);
        if (s != null)
        {
            s.recycle();
        }
        return false;
        s1;
        context = obj;
        s = s3;
_L5:
        s2 = s;
        context1 = context;
        GLogger.wx(TAG, "Unable to create video thumbnail", s1);
        IOUtils.closeQuietly(context);
        if (s == null) goto _L4; else goto _L3
_L3:
        s.recycle();
        return false;
        context;
        s = s2;
_L6:
        IOUtils.closeQuietly(context1);
        if (s != null)
        {
            s.recycle();
        }
        throw context;
        s1;
        context = obj1;
        s = s4;
          goto _L5
        s1;
        context1 = context;
        context = s1;
          goto _L6
        s1;
          goto _L5
        s1;
          goto _L5
    }

}
