// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.InputLimit;
import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import com.comcast.cim.httpcomponentsandroid.client.cache.ResourceFactory;
import com.comcast.cim.httpcomponentsandroid.impl.client.cache.HeapResourceFactory;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.cache:
//            CombinedResource, ManagedFileResourceFactory

public class CombinedResourceFactory
    implements ResourceFactory
{

    private final ManagedFileResourceFactory fileResourceFactory;
    private final HeapResourceFactory heapResourceFactory = new HeapResourceFactory();
    private final int perResourceHeapLimitInBytes;

    public CombinedResourceFactory(int i, ManagedFileResourceFactory managedfileresourcefactory)
    {
        perResourceHeapLimitInBytes = i;
        fileResourceFactory = managedfileresourcefactory;
    }

    public Resource copy(String s, Resource resource)
        throws IOException
    {
        resource = resource.getInputStream();
        InputLimit inputlimit = new InputLimit(perResourceHeapLimitInBytes);
        Resource resource1 = heapResourceFactory.generate(s, resource, inputlimit);
        if (!inputlimit.isReached())
        {
            return resource1;
        } else
        {
            return new CombinedResource(new Resource[] {
                resource1, fileResourceFactory.generate(s, resource, null)
            });
        }
    }

    public Resource generate(String s, InputStream inputstream, InputLimit inputlimit)
        throws IOException
    {
        Resource resource;
        if (inputlimit != null && inputlimit.getValue() <= (long)perResourceHeapLimitInBytes)
        {
            resource = heapResourceFactory.generate(s, inputstream, inputlimit);
        } else
        {
            InputLimit inputlimit2 = new InputLimit(perResourceHeapLimitInBytes);
            Resource resource1 = heapResourceFactory.generate(s, inputstream, inputlimit2);
            resource = resource1;
            if (inputlimit2.isReached())
            {
                InputLimit inputlimit1;
                if (inputlimit != null)
                {
                    inputlimit1 = new InputLimit(inputlimit.getValue() - inputlimit2.getValue());
                } else
                {
                    inputlimit1 = null;
                }
                s = fileResourceFactory.generate(s, inputstream, inputlimit1);
                if (inputlimit1 != null && inputlimit1.isReached())
                {
                    inputlimit.reached();
                }
                return new CombinedResource(new Resource[] {
                    resource1, s
                });
            }
        }
        return resource;
    }
}
