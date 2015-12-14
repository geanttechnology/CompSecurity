// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;


public class DigitalSignature
{

    private int headerSignature;
    private String signatureData;
    private int sizeOfData;

    public DigitalSignature()
    {
    }

    public int getHeaderSignature()
    {
        return headerSignature;
    }

    public String getSignatureData()
    {
        return signatureData;
    }

    public int getSizeOfData()
    {
        return sizeOfData;
    }

    public void setHeaderSignature(int i)
    {
        headerSignature = i;
    }

    public void setSignatureData(String s)
    {
        signatureData = s;
    }

    public void setSizeOfData(int i)
    {
        sizeOfData = i;
    }
}
