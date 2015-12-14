// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class Zip64ExtendedInfo
{

    private long compressedSize;
    private int diskNumberStart;
    private int header;
    private long offsetLocalHeader;
    private int size;
    private long unCompressedSize;

    public Zip64ExtendedInfo()
    {
        compressedSize = -1L;
        unCompressedSize = -1L;
        offsetLocalHeader = -1L;
        diskNumberStart = -1;
    }

    public long getCompressedSize()
    {
        return compressedSize;
    }

    public int getDiskNumberStart()
    {
        return diskNumberStart;
    }

    public int getHeader()
    {
        return header;
    }

    public long getOffsetLocalHeader()
    {
        return offsetLocalHeader;
    }

    public int getSize()
    {
        return size;
    }

    public long getUnCompressedSize()
    {
        return unCompressedSize;
    }

    public void setCompressedSize(long l)
    {
        compressedSize = l;
    }

    public void setDiskNumberStart(int i)
    {
        diskNumberStart = i;
    }

    public void setHeader(int i)
    {
        header = i;
    }

    public void setOffsetLocalHeader(long l)
    {
        offsetLocalHeader = l;
    }

    public void setSize(int i)
    {
        size = i;
    }

    public void setUnCompressedSize(long l)
    {
        unCompressedSize = l;
    }
}
