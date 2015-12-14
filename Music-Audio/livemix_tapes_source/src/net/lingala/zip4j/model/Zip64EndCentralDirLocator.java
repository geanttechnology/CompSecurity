// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class Zip64EndCentralDirLocator
{

    private int noOfDiskStartOfZip64EndOfCentralDirRec;
    private long offsetZip64EndOfCentralDirRec;
    private long signature;
    private int totNumberOfDiscs;

    public Zip64EndCentralDirLocator()
    {
    }

    public int getNoOfDiskStartOfZip64EndOfCentralDirRec()
    {
        return noOfDiskStartOfZip64EndOfCentralDirRec;
    }

    public long getOffsetZip64EndOfCentralDirRec()
    {
        return offsetZip64EndOfCentralDirRec;
    }

    public long getSignature()
    {
        return signature;
    }

    public int getTotNumberOfDiscs()
    {
        return totNumberOfDiscs;
    }

    public void setNoOfDiskStartOfZip64EndOfCentralDirRec(int i)
    {
        noOfDiskStartOfZip64EndOfCentralDirRec = i;
    }

    public void setOffsetZip64EndOfCentralDirRec(long l)
    {
        offsetZip64EndOfCentralDirRec = l;
    }

    public void setSignature(long l)
    {
        signature = l;
    }

    public void setTotNumberOfDiscs(int i)
    {
        totNumberOfDiscs = i;
    }
}
