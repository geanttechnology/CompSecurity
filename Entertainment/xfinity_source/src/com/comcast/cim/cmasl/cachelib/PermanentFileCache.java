// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.cachelib;

import android.content.Context;
import com.comcast.cim.cmasl.utils.StorageCache;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class PermanentFileCache
    implements StorageCache
{

    private final Context context;

    public PermanentFileCache(Context context1)
    {
        context = context1;
    }

    public void remove(String s)
    {
        context.deleteFile(s);
    }

    public void removeAll()
    {
        File afile[] = context.getFilesDir().listFiles();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            remove(afile[i].getName());
        }

    }

    public InputStream retrieve(String s)
    {
        try
        {
            s = context.openFileInput(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public void store(InputStream inputstream, String s)
    {
        java.io.FileOutputStream fileoutputstream;
        java.io.FileOutputStream fileoutputstream1;
        fileoutputstream1 = null;
        fileoutputstream = null;
        java.io.FileOutputStream fileoutputstream2 = context.openFileOutput(s, 0);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        IOUtils.copy(inputstream, fileoutputstream2);
        IOUtils.closeQuietly(inputstream);
        IOUtils.closeQuietly(fileoutputstream2);
        return;
        IOException ioexception;
        ioexception;
        fileoutputstream1 = fileoutputstream;
        boolean flag = context.deleteFile(s);
        fileoutputstream1 = fileoutputstream;
        StringBuilder stringbuilder = (new StringBuilder()).append("Failed to store stream with key ").append(s).append(", cache file was ");
        if (flag)
        {
            s = "deleted";
        } else
        {
            s = "not deleted";
        }
        fileoutputstream1 = fileoutputstream;
        throw new CimException(stringbuilder.append(s).toString(), ioexception);
        s;
        IOUtils.closeQuietly(inputstream);
        IOUtils.closeQuietly(fileoutputstream1);
        throw s;
    }
}
