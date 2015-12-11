// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager

public class <init> extends StreamingJsonDeserializer
{

    final AnyChannelSyncManager this$0;

    public Deal deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        try
        {
            jsonparser = (Deal)AnyChannelSyncManager.access$100(AnyChannelSyncManager.this).readValue(jsonparser, com/groupon/db/models/Deal);
            jsonparser.afterJsonDeserializationPostProcessor(buyUtil);
            AnyChannelSyncManager.access$200(AnyChannelSyncManager.this).lock();
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            throw new RuntimeException(jsonparser);
        }
        jsonparser = (new DealSummary(jsonparser, channel)).checkIfDerivedDealIsSmuggled(AnyChannelSyncManager.access$300(AnyChannelSyncManager.this));
        AnyChannelSyncManager.access$200(AnyChannelSyncManager.this).unlock();
        dealSummaryDao.save(jsonparser);
        return null;
        jsonparser;
        AnyChannelSyncManager.access$200(AnyChannelSyncManager.this).unlock();
        throw jsonparser;
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public ()
    {
        this$0 = AnyChannelSyncManager.this;
        super();
    }
}
