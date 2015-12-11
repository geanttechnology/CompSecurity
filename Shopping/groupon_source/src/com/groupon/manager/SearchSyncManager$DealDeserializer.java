// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.app.Application;
import android.content.Context;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.view.UrlImageView;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.manager:
//            SearchSyncManager

public class s extends StreamingJsonDeserializer
{

    private String channel;
    private ObjectMapperWrapper standardObjectMapperDelegate;
    final SearchSyncManager this$0;

    public Deal deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        try
        {
            jsonparser = (Deal)standardObjectMapperDelegate.readValue(jsonparser, com/groupon/db/models/Deal);
            jsonparser.afterJsonDeserializationPostProcessor(SearchSyncManager.access$100(SearchSyncManager.this));
            daoDealSummary.save(new DealSummary(jsonparser, channel));
            UrlImageView.prefetch((Application)SearchSyncManager.access$200(SearchSyncManager.this).getApplicationContext(), jsonparser.getImageUrl());
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            throw new RuntimeException(jsonparser);
        }
        return null;
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public zer(String s, Context context)
    {
        this$0 = SearchSyncManager.this;
        super();
        channel = s;
        RoboGuice.getInjector(context).injectMembers(this);
    }
}
