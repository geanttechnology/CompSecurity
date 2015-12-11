// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.requestor;

import com.pointinside.feeds.ZoneImageEntity;
import com.pointinside.internal.utils.IOUtils;
import com.pointinside.net.url.URLBuilder;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class FileDownloadRequestor
{

    private final File baseDir;
    private final ZoneImageEntity image;

    public FileDownloadRequestor(File file, ZoneImageEntity zoneimageentity, String s)
    {
        baseDir = file;
        image = zoneimageentity;
    }

    public void doDownload()
        throws IOException
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(image.imageUrl);
        stringbuilder.append("?");
        stringbuilder.append(URLBuilder.KEY_API_KEY);
        stringbuilder.append("=");
        stringbuilder.append("&");
        stringbuilder.append(URLBuilder.KEY_DEV_ID);
        stringbuilder.append("=");
        stringbuilder.append(URLBuilder.devId);
        IOUtils.downloadFile(new URL(stringbuilder.toString()), new File(baseDir, image.name), false);
    }

    public String toString()
    {
        return (new StringBuilder()).append("FileDownloadRequestor(").append(baseDir.getAbsolutePath()).append("/").append(image.name).append(")").toString();
    }
}
