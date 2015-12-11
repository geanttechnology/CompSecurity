// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.io.InputStream;

public class AmazonWebResourceResponse
{

    private InputStream data;
    private String encoding;
    private String mimeType;

    public InputStream getData()
    {
        return data;
    }

    public String getEncoding()
    {
        return encoding;
    }

    public String getMimeType()
    {
        return mimeType;
    }
}
