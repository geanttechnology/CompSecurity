// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.QueryFilter;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleListSerializers

public class QueryFilterSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new QueryFilterSerializer();

    private QueryFilterSerializer()
    {
    }

    public void serialize(QueryFilter queryfilter, JsonGenerator jsongenerator)
        throws IOException
    {
        if (queryfilter == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeFieldName(queryfilter.getFilterType());
            SimpleListSerializers.STRING_LIST_SERIALIZER.serialize(queryfilter.getValues(), jsongenerator);
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((QueryFilter)obj, jsongenerator);
    }

}
