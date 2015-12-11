// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import java.util.Date;

public class MarkUsedData
{
    public static class Wrapper
    {

        public MarkUsedData groupon;

        public Wrapper()
        {
        }
    }


    public String barcodeImageUrl;
    public String externalVoucherUrl;
    public String id;
    public Date printedAt;
    public String redemptionCode;

    public MarkUsedData()
    {
    }

    public String toString()
    {
        return String.format("id=%s, code=%s, barcodeImageUrl=%s, printedAt=%s", new Object[] {
            id, redemptionCode, barcodeImageUrl, printedAt
        });
    }
}
