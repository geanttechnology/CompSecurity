// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.transform:
//            Matcher, Transform

public class RegistryMatcher
    implements Matcher
{

    private final Cache transforms = new ConcurrentCache();
    private final Cache types = new ConcurrentCache();

    public RegistryMatcher()
    {
    }

    private Transform create(Class class1)
        throws Exception
    {
        Class class2 = (Class)types.fetch(class1);
        if (class2 != null)
        {
            return create(class1, class2);
        } else
        {
            return null;
        }
    }

    private Transform create(Class class1, Class class2)
        throws Exception
    {
        class2 = (Transform)class2.newInstance();
        if (class2 != null)
        {
            transforms.cache(class1, class2);
        }
        return class2;
    }

    public void bind(Class class1, Class class2)
    {
        types.cache(class1, class2);
    }

    public void bind(Class class1, Transform transform)
    {
        transforms.cache(class1, transform);
    }

    public Transform match(Class class1)
        throws Exception
    {
        Transform transform1 = (Transform)transforms.fetch(class1);
        Transform transform = transform1;
        if (transform1 == null)
        {
            transform = create(class1);
        }
        return transform;
    }
}
