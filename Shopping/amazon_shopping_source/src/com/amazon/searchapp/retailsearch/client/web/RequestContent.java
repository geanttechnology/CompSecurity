// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.OutputStream;

public abstract class RequestContent
{

    private final String encoding;
    private final long length;
    private final boolean repeatable;
    private final String type;

    public String getEncoding()
    {
        return encoding;
    }

    public long getLength()
    {
        return length;
    }

    public String getType()
    {
        return type;
    }

    public boolean isRepeatable()
    {
        return repeatable;
    }

    public abstract void writeTo(OutputStream outputstream);
}
