// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.Period;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

public class PeriodSerializer
    implements JsonSerializer
{
    static class PeriodFieldSerializer
    {

        public void serializeFields(Period period, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("timeInterval");
            SimpleSerializers.serializeString(period.getTimeInterval(), jsongenerator);
            jsongenerator.writeFieldName("numberOfIntervals");
            SimpleSerializers.serializePrimitiveLong(period.getNumberOfIntervals(), jsongenerator);
        }

        PeriodFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new PeriodSerializer();
    private final PeriodFieldSerializer mFieldSerializer = new PeriodFieldSerializer();

    private PeriodSerializer()
    {
    }

    public final void serialize(Period period, JsonGenerator jsongenerator)
        throws IOException
    {
        if (period == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(period, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((Period)obj, jsongenerator);
    }

}
