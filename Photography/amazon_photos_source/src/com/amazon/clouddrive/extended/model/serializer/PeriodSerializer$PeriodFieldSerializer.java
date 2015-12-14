// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.Period;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            PeriodSerializer

static class 
{

    public void serializeFields(Period period, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("timeInterval");
        SimpleSerializers.serializeString(period.getTimeInterval(), jsongenerator);
        jsongenerator.writeFieldName("numberOfIntervals");
        SimpleSerializers.serializePrimitiveLong(period.getNumberOfIntervals(), jsongenerator);
    }

    ()
    {
    }
}
