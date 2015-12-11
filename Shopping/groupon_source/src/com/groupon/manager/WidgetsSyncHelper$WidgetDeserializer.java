// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.models.Deal;
import com.groupon.db.models.WidgetSummary;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.models.Widget;
import java.io.IOException;
import java.sql.SQLException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            WidgetsSyncHelper, WidgetSyncManagerContext

public class internalMapper extends StreamingJsonDeserializer
{

    private ObjectMapper internalMapper;
    final WidgetsSyncHelper this$0;
    private WidgetSyncManagerContext widgetSyncManagerContext;

    public Widget deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        deserializationcontext = new WidgetSummary();
        deserializationcontext.channel = widgetsChannel;
        widgetSyncManagerContext.setCurrentlyParsedWidgetSummary(deserializationcontext);
        try
        {
            ((DaoWidgetSummary)WidgetsSyncHelper.access$200(WidgetsSyncHelper.this).get()).create(deserializationcontext);
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            throw new RuntimeException(jsonparser);
        }
        jsonparser = (Widget)internalMapper.readValue(jsonparser, com/groupon/models/Widget);
        jsonparser.widgetSummary = deserializationcontext;
        return jsonparser;
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public r(WidgetSyncManagerContext widgetsyncmanagercontext)
    {
        this$0 = WidgetsSyncHelper.this;
        super();
        internalMapper = new ObjectMapper();
        widgetSyncManagerContext = widgetsyncmanagercontext;
        SimpleModule simplemodule = new SimpleModule("DealDeserializerModule", new Version(1, 0, 0, null));
        simplemodule.addDeserializer(com/groupon/db/models/Deal, new nit>(WidgetsSyncHelper.this, widgetsyncmanagercontext));
        internalMapper.registerModule(simplemodule);
    }
}
