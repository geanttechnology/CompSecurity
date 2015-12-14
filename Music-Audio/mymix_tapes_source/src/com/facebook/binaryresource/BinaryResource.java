// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.binaryresource;

import java.io.IOException;
import java.io.InputStream;

public interface BinaryResource
{

    public abstract InputStream openStream()
        throws IOException;

    public abstract byte[] read()
        throws IOException;

    public abstract long size();
}
