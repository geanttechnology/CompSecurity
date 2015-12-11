// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestContent
{

    public abstract String getEncoding();

    public abstract long getLength();

    public abstract String getType();

    public abstract boolean isRepeatable();

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;
}
