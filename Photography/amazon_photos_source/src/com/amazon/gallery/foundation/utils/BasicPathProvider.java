// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils;

import android.os.Environment;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import java.io.File;

public class BasicPathProvider
{

    public static String getAttachmentsPath()
    {
        return (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()).append("/Attachments").toString();
    }

    public static String getCameraDirPath()
    {
        if (BuildFlavors.isAosp())
        {
            return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
        } else
        {
            return (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString()).append("/KINDLE").toString();
        }
    }

    public static String getDownloadsPath()
    {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
    }

    public static String getScreenshotsPath()
    {
        return (new StringBuilder()).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()).append("/Screenshots").toString();
    }
}
