// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa.moalite;

import com.aviary.android.feather.common.utils.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.aviary.android.feather.headless.moa.moalite:
//            MoaLitePack

public static class 
{

    private String displayName;
    private String ref;

    public final String getDisplayName()
    {
        return displayName;
    }

    public final String getRef()
    {
        return ref;
    }

    public boolean loadContent(File file, OutputStream outputstream)
        throws IOException
    {
        return loadContent(((InputStream) (new FileInputStream(file))), outputstream);
    }

    public boolean loadContent(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        IOUtils.copyFile(inputstream, outputstream);
        return true;
    }

    public byte[] loadContent(File file)
        throws IOException
    {
        return loadContent(((InputStream) (new FileInputStream(file))));
    }

    public byte[] loadContent(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        IOUtils.copyFile(inputstream, bytearrayoutputstream);
        return bytearrayoutputstream.toByteArray();
    }

    public boolean loadContentFromZip(File file, OutputStream outputstream)
        throws ZipException, IOException
    {
        return loadContentFromZip(((InputStream) (new FileInputStream(file))), outputstream);
    }

    public boolean loadContentFromZip(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        inputstream = new ZipInputStream(inputstream);
        boolean flag = IOUtils.readFileFromZip(inputstream, getRef(), outputstream);
        inputstream.close();
        return flag;
        outputstream;
        inputstream.close();
        throw outputstream;
    }

    public boolean loadContentFromZip(InputStream inputstream, ByteBuffer bytebuffer)
        throws IOException
    {
        return IOUtils.readFileFromZip(new ZipInputStream(inputstream), getRef(), bytebuffer);
    }

    public byte[] loadContentFromZip(File file)
        throws ZipException, IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        loadContentFromZip(file, ((OutputStream) (bytearrayoutputstream)));
        return bytearrayoutputstream.toByteArray();
    }

    public byte[] loadContentFromZip(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        loadContentFromZip(inputstream, ((OutputStream) (bytearrayoutputstream)));
        return bytearrayoutputstream.toByteArray();
    }

    void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setRef(String s)
    {
        ref = s;
    }

    ()
    {
    }
}
