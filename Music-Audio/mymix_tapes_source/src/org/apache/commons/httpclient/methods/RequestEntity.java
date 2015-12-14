// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.OutputStream;

public interface RequestEntity
{

    public abstract long getContentLength();

    public abstract String getContentType();

    public abstract boolean isRepeatable();

    public abstract void writeRequest(OutputStream outputstream)
        throws IOException;
}
