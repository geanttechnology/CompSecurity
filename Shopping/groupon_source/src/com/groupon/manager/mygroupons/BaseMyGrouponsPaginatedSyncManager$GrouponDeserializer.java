// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.mygroupons;

import android.app.Application;
import android.content.Context;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.manager.deserializer.StreamingJsonDeserializer;
import com.groupon.util.ImageUrl;
import com.groupon.util.MutableInteger;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.view.UrlImageView;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager.mygroupons:
//            BaseMyGrouponsPaginatedSyncManager

public class grouponsCount extends StreamingJsonDeserializer
{

    private MutableInteger grouponsCount;
    final BaseMyGrouponsPaginatedSyncManager this$0;

    public MyGrouponItem deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        deserializationcontext = (MyGrouponItem)BaseMyGrouponsPaginatedSyncManager.access$000(BaseMyGrouponsPaginatedSyncManager.this).readValue(jsonparser, com/groupon/db/models/mygroupons/MyGrouponItem);
        deserializationcontext.afterJsonDeserializationPostProcessor();
        deserializationcontext.category = grouponCategory;
        if (!Strings.isEmpty(((MyGrouponItem) (deserializationcontext)).remoteId)) goto _L2; else goto _L1
_L1:
        deserializationcontext.remoteId = String.format("%s_%d", new Object[] {
            "groupon_item_internal_id", Integer.valueOf(grouponsCount.get())
        });
        if (Strings.equals(((MyGrouponItem) (deserializationcontext)).status, "failed"))
        {
            grouponItemDao.save(deserializationcontext);
        }
_L3:
        jsonparser = new MyGrouponItemSummary(deserializationcontext);
        grouponItemSummaryDao.save(jsonparser);
        jsonparser = ((MyGrouponItem) (deserializationcontext)).sidebarImageUrl;
        if (!Strings.notEmpty(jsonparser))
        {
            break MISSING_BLOCK_LABEL_185;
        }
_L4:
        UrlImageView.prefetch((Application)BaseMyGrouponsPaginatedSyncManager.access$100(BaseMyGrouponsPaginatedSyncManager.this).getApplicationContext(), new ImageUrl(jsonparser));
        grouponsCount.increment();
        return null;
_L2:
        try
        {
            grouponItemDao.save(deserializationcontext);
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            throw new RuntimeException(jsonparser);
        }
          goto _L3
        jsonparser = ((MyGrouponItem) (deserializationcontext)).url;
          goto _L4
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public (MutableInteger mutableinteger)
    {
        this$0 = BaseMyGrouponsPaginatedSyncManager.this;
        super();
        grouponsCount = mutableinteger;
    }
}
