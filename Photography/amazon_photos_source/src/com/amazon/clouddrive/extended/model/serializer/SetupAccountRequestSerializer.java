// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.SetupAccountRequest;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

public class SetupAccountRequestSerializer
    implements JsonSerializer
{
    static class SetupAccountRequestFieldSerializer
    {

        public void serializeFields(SetupAccountRequest setupaccountrequest, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("termsOfUse");
            SimpleSerializers.serializeString(setupaccountrequest.getTermsOfUse(), jsongenerator);
        }

        SetupAccountRequestFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new SetupAccountRequestSerializer();
    private final SetupAccountRequestFieldSerializer mFieldSerializer = new SetupAccountRequestFieldSerializer();

    private SetupAccountRequestSerializer()
    {
    }

    public final void serialize(SetupAccountRequest setupaccountrequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (setupaccountrequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(setupaccountrequest, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((SetupAccountRequest)obj, jsongenerator);
    }

}
