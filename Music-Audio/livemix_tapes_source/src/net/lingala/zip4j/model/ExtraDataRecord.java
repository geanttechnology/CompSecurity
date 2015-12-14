// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class ExtraDataRecord
{

    private byte data[];
    private long header;
    private int sizeOfData;

    public ExtraDataRecord()
    {
    }

    public byte[] getData()
    {
        return data;
    }

    public long getHeader()
    {
        return header;
    }

    public int getSizeOfData()
    {
        return sizeOfData;
    }

    public void setData(byte abyte0[])
    {
        data = abyte0;
    }

    public void setHeader(long l)
    {
        header = l;
    }

    public void setSizeOfData(int i)
    {
        sizeOfData = i;
    }
}
