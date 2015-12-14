// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class ArchiveExtraDataRecord
{

    private String extraFieldData;
    private int extraFieldLength;
    private int signature;

    public ArchiveExtraDataRecord()
    {
    }

    public String getExtraFieldData()
    {
        return extraFieldData;
    }

    public int getExtraFieldLength()
    {
        return extraFieldLength;
    }

    public int getSignature()
    {
        return signature;
    }

    public void setExtraFieldData(String s)
    {
        extraFieldData = s;
    }

    public void setExtraFieldLength(int i)
    {
        extraFieldLength = i;
    }

    public void setSignature(int i)
    {
        signature = i;
    }
}
