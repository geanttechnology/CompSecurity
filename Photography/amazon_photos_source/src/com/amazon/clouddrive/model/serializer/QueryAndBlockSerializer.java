// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.QueryAndBlock;
import com.amazon.clouddrive.model.QueryFilter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, QueryFilterSerializer

public class QueryAndBlockSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new QueryAndBlockSerializer();

    private QueryAndBlockSerializer()
    {
    }

    public final void serialize(QueryAndBlock queryandblock, JsonGenerator jsongenerator)
        throws IOException
    {
        if (queryandblock == null)
        {
            jsongenerator.writeNull();
            return;
        }
        jsongenerator.writeStartObject();
        if (queryandblock.getFilters() == null)
        {
            jsongenerator.writeNull();
        } else
        {
            queryandblock = queryandblock.getFilters().iterator();
            while (queryandblock.hasNext()) 
            {
                QueryFilter queryfilter = (QueryFilter)queryandblock.next();
                QueryFilterSerializer.INSTANCE.serialize(queryfilter, jsongenerator);
            }
        }
        jsongenerator.writeEndObject();
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((QueryAndBlock)obj, jsongenerator);
    }

}
