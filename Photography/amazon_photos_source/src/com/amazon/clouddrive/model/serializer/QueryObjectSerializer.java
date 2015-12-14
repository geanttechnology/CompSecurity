// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.QueryObject;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, ObjectIdListSerializer, QueryAndBlockListSerializer

public class QueryObjectSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new QueryObjectSerializer();

    private QueryObjectSerializer()
    {
    }

    public final void serialize(QueryObject queryobject, JsonGenerator jsongenerator)
        throws IOException
    {
        if (queryobject == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("excludedIds");
            ObjectIdListSerializer.INSTANCE.serialize(queryobject.getExcludedIds(), jsongenerator);
            jsongenerator.writeFieldName("include");
            QueryAndBlockListSerializer.INSTANCE.serialize(queryobject.getInclude(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((QueryObject)obj, jsongenerator);
    }

}
