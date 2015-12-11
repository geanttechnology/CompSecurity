// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.cache;

import com.comcast.cim.httpcomponentsandroid.client.cache.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CombinedResource
    implements Resource
{

    private final List resourceList = new ArrayList();

    public transient CombinedResource(Resource aresource[])
    {
        Collections.addAll(resourceList, aresource);
    }

    public void dispose()
    {
        for (Iterator iterator = resourceList.iterator(); iterator.hasNext(); ((Resource)iterator.next()).dispose()) { }
    }

    public InputStream getInputStream()
        throws IOException
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = resourceList.iterator(); iterator.hasNext(); arraylist.add(((Resource)iterator.next()).getInputStream())) { }
        return new SequenceInputStream(Collections.enumeration(arraylist));
    }

    public long length()
    {
        long l = 0L;
        for (Iterator iterator = resourceList.iterator(); iterator.hasNext();)
        {
            l += ((Resource)iterator.next()).length();
        }

        return l;
    }
}
