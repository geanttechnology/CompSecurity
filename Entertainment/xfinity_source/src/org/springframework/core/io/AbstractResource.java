// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package org.springframework.core.io:
//            Resource

public abstract class AbstractResource
    implements Resource
{

    public AbstractResource()
    {
    }

    public long contentLength()
        throws IOException
    {
        return getFile().length();
    }

    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof Resource) && ((Resource)obj).getDescription().equals(getDescription());
    }

    public File getFile()
        throws IOException
    {
        throw new FileNotFoundException((new StringBuilder()).append(getDescription()).append(" cannot be resolved to absolute file path").toString());
    }

    public String getFilename()
        throws IllegalStateException
    {
        throw new IllegalStateException((new StringBuilder()).append(getDescription()).append(" does not have a filename").toString());
    }

    public int hashCode()
    {
        return getDescription().hashCode();
    }

    public String toString()
    {
        return getDescription();
    }
}
