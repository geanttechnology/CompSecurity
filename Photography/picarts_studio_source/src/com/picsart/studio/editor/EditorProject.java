// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor;

import com.socialin.android.util.FileUtils;
import java.io.File;
import java.io.Serializable;

public class EditorProject
    implements Serializable
{

    private String path;

    public EditorProject(String s)
    {
        path = s;
        (new File(getDirectory())).mkdirs();
        (new File(getTmpDirectory())).mkdirs();
        (new File(getHistoryDirectory())).mkdirs();
        (new File(getHistoryDataDirectory())).mkdirs();
    }

    private String getHistoryDirectory()
    {
        return (new StringBuilder()).append(path).append("/history").toString();
    }

    public void clearTmpDirectory()
    {
        File file = new File(getTmpDirectory());
        if (file.exists())
        {
            File file1 = new File((new StringBuilder()).append(file.getAbsolutePath()).append(System.currentTimeMillis()).toString());
            file.renameTo(file1);
            FileUtils.b(file1);
        }
    }

    public void deleteSelf()
    {
        FileUtils.b(getDirectory());
    }

    public String getCurrentImagePath()
    {
        return (new StringBuilder()).append(path).append("/current.raw").toString();
    }

    public String getDirectory()
    {
        return path;
    }

    public String getHistoryDataDirectory()
    {
        return (new StringBuilder()).append(getHistoryDirectory()).append("/data").toString();
    }

    public String getHistoryFilePath()
    {
        return (new StringBuilder()).append(getHistoryDirectory()).append("/meta.json").toString();
    }

    public String getOriginalImagePath()
    {
        return (new StringBuilder()).append(path).append("/original.raw").toString();
    }

    public long getSizeInBytes()
    {
        return FileUtils.g(new File(path));
    }

    public String getThumbnailPath()
    {
        return (new StringBuilder()).append(path).append("/thumb.png").toString();
    }

    public String getTmpDirectory()
    {
        return (new StringBuilder()).append(path).append("/tmp").toString();
    }

    public String getTrackFilePath()
    {
        return (new StringBuilder()).append(path).append("/track.json").toString();
    }
}
