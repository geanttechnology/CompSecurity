// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CMSImageHelper
{

    public static Typeface DEFAULT_TYPEFACE;
    private static final String TAG = com/amazon/gallery/framework/kindle/cms/CMSImageHelper.getName();
    private static boolean typeFaceInited = false;

    public CMSImageHelper()
    {
    }

    public static void writeBitmapToFile(Bitmap bitmap, File file, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            bitmap.compress(compressformat, i, fileoutputstream);
            fileoutputstream.flush();
            fileoutputstream.close();
            file.setReadable(true, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
    }

    static 
    {
        DEFAULT_TYPEFACE = Typeface.DEFAULT;
    }
}
