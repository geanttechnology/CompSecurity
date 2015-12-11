// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

// Referenced classes of package org.simpleframework.xml.core:
//            Scanner, Support, PrimitiveScanner, ObjectScanner

class ScannerFactory
{

    private final Cache cache = new ConcurrentCache();
    private final Format format;
    private final Support support;

    public ScannerFactory(Support support1, Format format1)
    {
        support = support1;
        format = format1;
    }

    public Scanner getInstance(Class class1)
        throws Exception
    {
        Scanner scanner = (Scanner)cache.fetch(class1);
        Object obj = scanner;
        if (scanner == null)
        {
            if (support.isPrimitive(class1))
            {
                obj = new PrimitiveScanner(class1);
            } else
            {
                obj = new ObjectScanner(class1, format);
            }
            cache.cache(class1, obj);
        }
        return ((Scanner) (obj));
    }
}
