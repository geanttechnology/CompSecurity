// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class Zip64EndCentralDirRecord
{

    private byte extensibleDataSector[];
    private int noOfThisDisk;
    private int noOfThisDiskStartOfCentralDir;
    private long offsetStartCenDirWRTStartDiskNo;
    private long signature;
    private long sizeOfCentralDir;
    private long sizeOfZip64EndCentralDirRec;
    private long totNoOfEntriesInCentralDir;
    private long totNoOfEntriesInCentralDirOnThisDisk;
    private int versionMadeBy;
    private int versionNeededToExtract;

    public Zip64EndCentralDirRecord()
    {
    }

    public byte[] getExtensibleDataSector()
    {
        return extensibleDataSector;
    }

    public int getNoOfThisDisk()
    {
        return noOfThisDisk;
    }

    public int getNoOfThisDiskStartOfCentralDir()
    {
        return noOfThisDiskStartOfCentralDir;
    }

    public long getOffsetStartCenDirWRTStartDiskNo()
    {
        return offsetStartCenDirWRTStartDiskNo;
    }

    public long getSignature()
    {
        return signature;
    }

    public long getSizeOfCentralDir()
    {
        return sizeOfCentralDir;
    }

    public long getSizeOfZip64EndCentralDirRec()
    {
        return sizeOfZip64EndCentralDirRec;
    }

    public long getTotNoOfEntriesInCentralDir()
    {
        return totNoOfEntriesInCentralDir;
    }

    public long getTotNoOfEntriesInCentralDirOnThisDisk()
    {
        return totNoOfEntriesInCentralDirOnThisDisk;
    }

    public int getVersionMadeBy()
    {
        return versionMadeBy;
    }

    public int getVersionNeededToExtract()
    {
        return versionNeededToExtract;
    }

    public void setExtensibleDataSector(byte abyte0[])
    {
        extensibleDataSector = abyte0;
    }

    public void setNoOfThisDisk(int i)
    {
        noOfThisDisk = i;
    }

    public void setNoOfThisDiskStartOfCentralDir(int i)
    {
        noOfThisDiskStartOfCentralDir = i;
    }

    public void setOffsetStartCenDirWRTStartDiskNo(long l)
    {
        offsetStartCenDirWRTStartDiskNo = l;
    }

    public void setSignature(long l)
    {
        signature = l;
    }

    public void setSizeOfCentralDir(long l)
    {
        sizeOfCentralDir = l;
    }

    public void setSizeOfZip64EndCentralDirRec(long l)
    {
        sizeOfZip64EndCentralDirRec = l;
    }

    public void setTotNoOfEntriesInCentralDir(long l)
    {
        totNoOfEntriesInCentralDir = l;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(long l)
    {
        totNoOfEntriesInCentralDirOnThisDisk = l;
    }

    public void setVersionMadeBy(int i)
    {
        versionMadeBy = i;
    }

    public void setVersionNeededToExtract(int i)
    {
        versionNeededToExtract = i;
    }
}
