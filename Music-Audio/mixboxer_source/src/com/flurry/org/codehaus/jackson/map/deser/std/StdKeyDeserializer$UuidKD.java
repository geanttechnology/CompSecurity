// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import java.util.UUID;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            StdKeyDeserializer

static final class  extends StdKeyDeserializer
{

    public volatile Object _parse(String s, DeserializationContext deserializationcontext)
        throws Exception
    {
        return _parse(s, deserializationcontext);
    }

    public UUID _parse(String s, DeserializationContext deserializationcontext)
        throws IllegalArgumentException, JsonMappingException
    {
        return UUID.fromString(s);
    }

    protected ()
    {
        super(java/util/UUID);
    }
}
