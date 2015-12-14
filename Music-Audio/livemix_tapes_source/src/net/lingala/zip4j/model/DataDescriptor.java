// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class DataDescriptor
{

    private int compressedSize;
    private String crc32;
    private int uncompressedSize;

    public DataDescriptor()
    {
    }

    public int getCompressedSize()
    {
        return compressedSize;
    }

    public String getCrc32()
    {
        return crc32;
    }

    public int getUncompressedSize()
    {
        return uncompressedSize;
    }

    public void setCompressedSize(int i)
    {
        compressedSize = i;
    }

    public void setCrc32(String s)
    {
        crc32 = s;
    }

    public void setUncompressedSize(int i)
    {
        uncompressedSize = i;
    }
}
