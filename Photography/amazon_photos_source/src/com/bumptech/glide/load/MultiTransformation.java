// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.bumptech.glide.load:
//            Transformation

public class MultiTransformation
    implements Transformation
{

    private String id;
    private final Collection transformations;

    public transient MultiTransformation(Transformation atransformation[])
    {
        if (atransformation.length < 1)
        {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        } else
        {
            transformations = Arrays.asList(atransformation);
            return;
        }
    }

    public String getId()
    {
        if (id == null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            for (Iterator iterator = transformations.iterator(); iterator.hasNext(); stringbuilder.append(((Transformation)iterator.next()).getId())) { }
            id = stringbuilder.toString();
        }
        return id;
    }

    public Resource transform(Resource resource, int i, int j)
    {
        Resource resource1 = resource;
        for (Iterator iterator = transformations.iterator(); iterator.hasNext();)
        {
            Resource resource2 = ((Transformation)iterator.next()).transform(resource1, i, j);
            if (resource1 != null && !resource1.equals(resource) && !resource1.equals(resource2))
            {
                resource1.recycle();
            }
            resource1 = resource2;
        }

        return resource1;
    }
}
