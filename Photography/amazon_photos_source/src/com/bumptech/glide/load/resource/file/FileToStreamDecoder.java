// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileToStreamDecoder
    implements ResourceDecoder
{
    static class FileOpener
    {

        public InputStream open(File file)
            throws FileNotFoundException
        {
            return new FileInputStream(file);
        }

        FileOpener()
        {
        }
    }


    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private final FileOpener fileOpener;
    private ResourceDecoder streamDecoder;

    public FileToStreamDecoder(ResourceDecoder resourcedecoder)
    {
        this(resourcedecoder, DEFAULT_FILE_OPENER);
    }

    FileToStreamDecoder(ResourceDecoder resourcedecoder, FileOpener fileopener)
    {
        streamDecoder = resourcedecoder;
        fileOpener = fileopener;
    }

    public Resource decode(File file, int i, int j)
        throws IOException
    {
        File file1 = null;
        file = fileOpener.open(file);
        file1 = file;
        Resource resource = streamDecoder.decode(file, i, j);
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                return resource;
            }
        }
        return resource;
        file;
        if (file1 != null)
        {
            try
            {
                file1.close();
            }
            catch (IOException ioexception) { }
        }
        throw file;
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((File)obj, i, j);
    }

    public String getId()
    {
        return "";
    }

}
