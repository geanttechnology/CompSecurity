// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http;

import com.poshmark.http.httpUtils.PMHttpUtils;

public class PMMultipartItem
{

    public byte data[];
    public String fileName;
    public String mimeType;

    public PMMultipartItem(byte abyte0[], String s, String s1)
    {
        data = abyte0;
        fileName = s1;
        mimeType = s;
    }

    public static PMMultipartItem getMultipartJPGItem(String s)
    {
        return new PMMultipartItem(PMHttpUtils.getJPGContents(s), "image/jpeg", "file.jpg");
    }
}
