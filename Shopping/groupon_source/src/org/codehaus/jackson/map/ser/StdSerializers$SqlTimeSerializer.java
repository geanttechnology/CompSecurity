// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.sql.Time;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.ScalarSerializerBase;

// Referenced classes of package org.codehaus.jackson.map.ser:
//            StdSerializers

public static final class  extends ScalarSerializerBase
{

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((Time)obj, jsongenerator, serializerprovider);
    }

    public void serialize(Time time, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeString(time.toString());
    }

    public ()
    {
        super(java/sql/Time);
    }
}
