// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdScalarSerializer

public final class  extends StdScalarSerializer
{

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        serialize((AtomicInteger)obj, jsongenerator, serializerprovider);
    }

    public void serialize(AtomicInteger atomicinteger, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        jsongenerator.writeNumber(atomicinteger.get());
    }

    public ()
    {
        super(java/util/concurrent/atomic/AtomicInteger, false);
    }
}
