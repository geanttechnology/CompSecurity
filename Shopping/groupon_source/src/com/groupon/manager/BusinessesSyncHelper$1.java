// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.models.Business;
import java.util.concurrent.Callable;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            BusinessesSyncHelper

class val.mapper
    implements Callable
{

    final BusinessesSyncHelper this$0;
    final String val$channel;
    final JsonParser val$jp;
    final ObjectMapper val$mapper;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        BusinessesSyncHelper.access$000(BusinessesSyncHelper.this).clearByChannelId(val$channel);
        do
        {
            if (val$jp.nextToken() == null)
            {
                break;
            }
            if (Strings.equals(val$jp.getCurrentName(), "businesses"))
            {
                val$jp.nextToken();
                while (val$jp.nextToken() == JsonToken.START_OBJECT) 
                {
                    Business business = (Business)val$mapper.readValue(val$jp, com/groupon/db/models/Business);
                    business.afterJsonDeserializationPostProcessor(BusinessesSyncHelper.access$100(BusinessesSyncHelper.this));
                    business.channel = val$channel;
                    BusinessesSyncHelper.access$000(BusinessesSyncHelper.this).save(business);
                }
            }
        } while (true);
        return null;
    }

    ()
    {
        this$0 = final_businessessynchelper;
        val$channel = s;
        val$jp = jsonparser;
        val$mapper = ObjectMapper.this;
        super();
    }
}
