// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.file;

import android.media.ExifInterface;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class ExifUtils
{

    private static final String TAG = com/amazon/gallery/foundation/utils/file/ExifUtils.getName();

    private ExifUtils()
    {
    }

    public static boolean pullExifFields(MediaItem mediaitem)
    {
        if (!"image/jpeg".equals(mediaitem.getMIMEType())) goto _L2; else goto _L1
_L1:
        Object obj;
        try
        {
            obj = new ExifInterface(mediaitem.getLocalPath());
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem)
        {
            GLogger.ex(TAG, "cannot open exif of local path", mediaitem);
            return false;
        }
        try
        {
            obj = ((ExifInterface) (obj)).getAttribute("UserComment");
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem)
        {
            GLogger.dx(TAG, "cannot get data from user comment", mediaitem);
            return false;
        }
        if (obj != null) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        if (!((JSONObject) (obj = new JSONObject(((String) (obj))))).has("fullMd5")) goto _L3; else goto _L5
_L5:
        mediaitem.setFullMd5(((JSONObject) (obj)).getString("fullMd5"));
_L2:
        return true;
    }

    public static boolean pushMd5ToExif(ExifInterface exifinterface, String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("fullMd5", s);
            exifinterface.setAttribute("UserComment", jsonobject.toString());
        }
        // Misplaced declaration of an exception variable
        catch (ExifInterface exifinterface)
        {
            GLogger.ex(TAG, "cannot create user comment", exifinterface);
            return false;
        }
        return true;
    }

}
