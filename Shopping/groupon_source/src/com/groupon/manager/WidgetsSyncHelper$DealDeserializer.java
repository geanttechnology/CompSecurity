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
import com.groupon.util.BuyUtils;
import com.groupon.view.UrlImageView;
import java.io.IOException;
import java.sql.SQLException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            WidgetsSyncHelper, WidgetSyncManagerContext

public class widgetSyncManagerContext extends StreamingJsonDeserializer
{

    private ObjectMapper internalMapper;
    final WidgetsSyncHelper this$0;
    private WidgetSyncManagerContext widgetSyncManagerContext;

    public Deal deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        jsonparser = (Deal)internalMapper.readValue(jsonparser, com/groupon/db/models/Deal);
        jsonparser.afterJsonDeserializationPostProcessor((BuyUtils)WidgetsSyncHelper.access$300(WidgetsSyncHelper.this).get());
        jsonparser.parentWidgetSummary = widgetSyncManagerContext.getCurrentlyParsedWidgetSummary();
        try
        {
            ((DaoDealSummary)WidgetsSyncHelper.access$400(WidgetsSyncHelper.this).get()).save(new DealSummary(jsonparser, widgetsChannel));
            UrlImageView.prefetch((Application)context.getApplicationContext(), jsonparser.getImageUrl());
            widgetSyncManagerContext.incDealCount();
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

    public zer(WidgetSyncManagerContext widgetsyncmanagercontext)
    {
        this$0 = WidgetsSyncHelper.this;
        super();
        internalMapper = new ObjectMapper();
        widgetSyncManagerContext = widgetsyncmanagercontext;
    }
}
