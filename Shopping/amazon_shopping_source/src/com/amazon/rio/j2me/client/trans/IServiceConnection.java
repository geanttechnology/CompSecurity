// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.trans;

import java.io.IOException;
import java.io.InputStream;

public interface IServiceConnection
{

    public abstract void addCustomHeaders(String s);

    public abstract void cancel();

    public abstract void close();

    public abstract String getUrl();

    public abstract InputStream send(byte abyte0[][])
        throws IOException;
}
