// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;

import java.io.FileOutputStream;
import net.lingala.zip4j.crypto.IDecrypter;
import net.lingala.zip4j.unzip.UnzipEngine;

// Referenced classes of package net.lingala.zip4j.model:
//            FileHeader, LocalFileHeader, ZipModel

public class UnzipEngineParameters
{

    private FileHeader fileHeader;
    private IDecrypter iDecryptor;
    private LocalFileHeader localFileHeader;
    private FileOutputStream outputStream;
    private UnzipEngine unzipEngine;
    private ZipModel zipModel;

    public UnzipEngineParameters()
    {
    }

    public FileHeader getFileHeader()
    {
        return fileHeader;
    }

    public IDecrypter getIDecryptor()
    {
        return iDecryptor;
    }

    public LocalFileHeader getLocalFileHeader()
    {
        return localFileHeader;
    }

    public FileOutputStream getOutputStream()
    {
        return outputStream;
    }

    public UnzipEngine getUnzipEngine()
    {
        return unzipEngine;
    }

    public ZipModel getZipModel()
    {
        return zipModel;
    }

    public void setFileHeader(FileHeader fileheader)
    {
        fileHeader = fileheader;
    }

    public void setIDecryptor(IDecrypter idecrypter)
    {
        iDecryptor = idecrypter;
    }

    public void setLocalFileHeader(LocalFileHeader localfileheader)
    {
        localFileHeader = localfileheader;
    }

    public void setOutputStream(FileOutputStream fileoutputstream)
    {
        outputStream = fileoutputstream;
    }

    public void setUnzipEngine(UnzipEngine unzipengine)
    {
        unzipEngine = unzipengine;
    }

    public void setZipModel(ZipModel zipmodel)
    {
        zipModel = zipmodel;
    }
}
