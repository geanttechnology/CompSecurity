// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ResourceReference extends PhantomReference
{

    private final File backingFile;

    public ResourceReference(File file, Resource resource, ReferenceQueue referencequeue)
    {
        super(resource, referencequeue);
        backingFile = file;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (ResourceReference)obj;
            return backingFile.equals(((ResourceReference) (obj)).backingFile);
        }
    }

    public File getBackingFile()
    {
        return backingFile;
    }

    public int hashCode()
    {
        return backingFile.hashCode();
    }
}
