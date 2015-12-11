// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser.std:
//            ScalarSerializerBase

public abstract class NonTypedScalarSerializerBase extends ScalarSerializerBase
{

    protected NonTypedScalarSerializerBase(Class class1)
    {
        super(class1);
    }

    public final void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        serialize(obj, jsongenerator, serializerprovider);
    }
}
