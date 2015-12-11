// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.app.Application;
import android.content.Context;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.models.MarketRateResult;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.util.ImageUrl;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.view.UrlImageView;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

// Referenced classes of package com.groupon.manager:
//            MarketRateSyncManager

public class init> extends StreamingJsonDeserializer
{

    final MarketRateSyncManager this$0;

    public MarketRateResult deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        deserializationcontext = (MarketRateResult)MarketRateSyncManager.access$300(MarketRateSyncManager.this).readValue(jsonparser, com/groupon/db/models/MarketRateResult);
        deserializationcontext.afterJsonDeserializationPostProcessor();
        if (!MarketRateSyncManager.access$000(MarketRateSyncManager.this))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        jsonparser = MarketRateSyncManager.access$100(MarketRateSyncManager.this);
_L1:
        deserializationcontext.channel = jsonparser;
        MarketRateSyncManager.access$200(MarketRateSyncManager.this).replace(deserializationcontext);
        UrlImageView.prefetch((Application)MarketRateSyncManager.access$400(MarketRateSyncManager.this).getApplicationContext(), new ImageUrl(((MarketRateResult) (deserializationcontext)).derivedImageUrl));
        return null;
        jsonparser = "HOTELS";
          goto _L1
        jsonparser;
        throw new RuntimeException(jsonparser);
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public A()
    {
        this$0 = MarketRateSyncManager.this;
        super();
    }
}
