// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.model;

import java.util.ArrayList;

// Referenced classes of package net.lingala.zip4j.model:
//            DigitalSignature

public class CentralDirectory
{

    private DigitalSignature digitalSignature;
    private ArrayList fileHeaders;

    public CentralDirectory()
    {
    }

    public DigitalSignature getDigitalSignature()
    {
        return digitalSignature;
    }

    public ArrayList getFileHeaders()
    {
        return fileHeaders;
    }

    public void setDigitalSignature(DigitalSignature digitalsignature)
    {
        digitalSignature = digitalsignature;
    }

    public void setFileHeaders(ArrayList arraylist)
    {
        fileHeaders = arraylist;
    }
}
