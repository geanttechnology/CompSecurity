// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdKeyDeserializer

static final class  extends StdKeyDeserializer
{

    private static final long serialVersionUID = 1L;

    public Double _parse(String s, DeserializationContext deserializationcontext)
        throws JsonMappingException
    {
        return Double.valueOf(_parseDouble(s));
    }

    public volatile Object _parse(String s, DeserializationContext deserializationcontext)
        throws Exception
    {
        return _parse(s, deserializationcontext);
    }

    ()
    {
        super(java/lang/Double);
    }
}
