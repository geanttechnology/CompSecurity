// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import java.io.IOException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            JodaDeserializers

static abstract class  extends StdScalarDeserializer
{

    static final DateTimeFormatter _localDateTimeFormat = ISODateTimeFormat.localDateOptionalTimeParser();

    protected DateTime parseLocal(JsonParser jsonparser)
        throws IOException, JsonProcessingException
    {
        jsonparser = jsonparser.getText().trim();
        if (jsonparser.length() == 0)
        {
            return null;
        } else
        {
            return _localDateTimeFormat.parseDateTime(jsonparser);
        }
    }


    protected (Class class1)
    {
        super(class1);
    }
}
