// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class AESExtraDataRecord
{

    private int aesStrength;
    private int compressionMethod;
    private int dataSize;
    private long signature;
    private String vendorID;
    private int versionNumber;

    public AESExtraDataRecord()
    {
        signature = -1L;
        dataSize = -1;
        versionNumber = -1;
        vendorID = null;
        aesStrength = -1;
        compressionMethod = -1;
    }

    public int getAesStrength()
    {
        return aesStrength;
    }

    public int getCompressionMethod()
    {
        return compressionMethod;
    }

    public int getDataSize()
    {
        return dataSize;
    }

    public long getSignature()
    {
        return signature;
    }

    public String getVendorID()
    {
        return vendorID;
    }

    public int getVersionNumber()
    {
        return versionNumber;
    }

    public void setAesStrength(int i)
    {
        aesStrength = i;
    }

    public void setCompressionMethod(int i)
    {
        compressionMethod = i;
    }

    public void setDataSize(int i)
    {
        dataSize = i;
    }

    public void setSignature(long l)
    {
        signature = l;
    }

    public void setVendorID(String s)
    {
        vendorID = s;
    }

    public void setVersionNumber(int i)
    {
        versionNumber = i;
    }
}
