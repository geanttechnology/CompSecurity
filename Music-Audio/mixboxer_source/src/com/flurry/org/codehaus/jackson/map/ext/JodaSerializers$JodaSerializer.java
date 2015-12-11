// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase;
import java.io.IOException;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            JodaSerializers

protected static abstract class  extends SerializerBase
{

    static final DateTimeFormatter _localDateFormat = ISODateTimeFormat.date();
    static final DateTimeFormatter _localDateTimeFormat = ISODateTimeFormat.dateTime();

    protected String printLocalDate(ReadableInstant readableinstant)
        throws IOException, JsonProcessingException
    {
        return _localDateFormat.print(readableinstant);
    }

    protected String printLocalDate(ReadablePartial readablepartial)
        throws IOException, JsonProcessingException
    {
        return _localDateFormat.print(readablepartial);
    }

    protected String printLocalDateTime(ReadablePartial readablepartial)
        throws IOException, JsonProcessingException
    {
        return _localDateTimeFormat.print(readablepartial);
    }


    protected (Class class1)
    {
        super(class1);
    }
}
