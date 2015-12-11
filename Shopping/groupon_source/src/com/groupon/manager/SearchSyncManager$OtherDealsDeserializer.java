// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.dealsearch.OtherDeals;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;

// Referenced classes of package com.groupon.manager:
//            SearchSyncManager

public class nit> extends StreamingJsonDeserializer
{

    final SearchSyncManager this$0;

    public OtherDeals deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        return (OtherDeals)SearchSyncManager.access$300(SearchSyncManager.this).readValue(jsonparser, com/groupon/models/dealsearch/OtherDeals);
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public ()
    {
        this$0 = SearchSyncManager.this;
        super();
    }
}
