// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;

import java.io.IOException;
import java.io.OutputStream;

public interface WriterCallback
{

    public abstract void write(OutputStream outputstream)
        throws IOException;
}
