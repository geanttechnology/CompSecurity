// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class EndCentralDirRecord
{

    private String comment;
    private byte commentBytes[];
    private int commentLength;
    private int noOfThisDisk;
    private int noOfThisDiskStartOfCentralDir;
    private long offsetOfStartOfCentralDir;
    private long signature;
    private int sizeOfCentralDir;
    private int totNoOfEntriesInCentralDir;
    private int totNoOfEntriesInCentralDirOnThisDisk;

    public EndCentralDirRecord()
    {
    }

    public String getComment()
    {
        return comment;
    }

    public byte[] getCommentBytes()
    {
        return commentBytes;
    }

    public int getCommentLength()
    {
        return commentLength;
    }

    public int getNoOfThisDisk()
    {
        return noOfThisDisk;
    }

    public int getNoOfThisDiskStartOfCentralDir()
    {
        return noOfThisDiskStartOfCentralDir;
    }

    public long getOffsetOfStartOfCentralDir()
    {
        return offsetOfStartOfCentralDir;
    }

    public long getSignature()
    {
        return signature;
    }

    public int getSizeOfCentralDir()
    {
        return sizeOfCentralDir;
    }

    public int getTotNoOfEntriesInCentralDir()
    {
        return totNoOfEntriesInCentralDir;
    }

    public int getTotNoOfEntriesInCentralDirOnThisDisk()
    {
        return totNoOfEntriesInCentralDirOnThisDisk;
    }

    public void setComment(String s)
    {
        comment = s;
    }

    public void setCommentBytes(byte abyte0[])
    {
        commentBytes = abyte0;
    }

    public void setCommentLength(int i)
    {
        commentLength = i;
    }

    public void setNoOfThisDisk(int i)
    {
        noOfThisDisk = i;
    }

    public void setNoOfThisDiskStartOfCentralDir(int i)
    {
        noOfThisDiskStartOfCentralDir = i;
    }

    public void setOffsetOfStartOfCentralDir(long l)
    {
        offsetOfStartOfCentralDir = l;
    }

    public void setSignature(long l)
    {
        signature = l;
    }

    public void setSizeOfCentralDir(int i)
    {
        sizeOfCentralDir = i;
    }

    public void setTotNoOfEntriesInCentralDir(int i)
    {
        totNoOfEntriesInCentralDir = i;
    }

    public void setTotNoOfEntriesInCentralDirOnThisDisk(int i)
    {
        totNoOfEntriesInCentralDirOnThisDisk = i;
    }
}
