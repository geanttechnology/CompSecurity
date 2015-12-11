// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface InputStreamSource
{

    public abstract InputStream getInputStream()
        throws IOException;
}
