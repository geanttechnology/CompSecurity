// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ExtractorFactory, Contact

private static class type
{

    private final Class label;
    private final Class type;

    private Constructor getConstructor()
        throws Exception
    {
        return type.getConstructor(new Class[] {
            org/simpleframework/xml/core/Contact, label, org/simpleframework/xml/stream/Format
        });
    }


    public (Class class1, Class class2)
    {
        label = class1;
        type = class2;
    }
}
