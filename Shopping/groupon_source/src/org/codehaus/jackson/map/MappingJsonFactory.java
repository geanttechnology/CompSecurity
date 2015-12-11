// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonFactory;

// Referenced classes of package org.codehaus.jackson.map:
//            ObjectMapper

public class MappingJsonFactory extends JsonFactory
{

    public MappingJsonFactory()
    {
        this(null);
    }

    public MappingJsonFactory(ObjectMapper objectmapper)
    {
        super(objectmapper);
        if (objectmapper == null)
        {
            setCodec(new ObjectMapper(this));
        }
    }
}
