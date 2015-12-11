// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.discover.qrcode;

import com.google.c.a;

public class QRBarResult
{

    private String mCode;
    private a mFormat;

    public QRBarResult(int i, String s)
    {
        mCode = s;
        mFormat = toBarcodeFormat(i);
    }

    private a toBarcodeFormat(int i)
    {
        a aa[] = a.values();
        int k = aa.length;
        for (int j = 0; j < k; j++)
        {
            a a1 = aa[j];
            if (a1.ordinal() + 1 == i)
            {
                return a1;
            }
        }

        return null;
    }

    public a getBarcodeFormat()
    {
        return mFormat;
    }

    public String getCode()
    {
        return mCode;
    }
}
