// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoCouponCategory;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponCategoryListContainer;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class CouponCategorySyncManagerProcess extends AbstractSyncManagerProcess
{

    protected final int DEFAULT_CATEGORY_LIMIT = 200;
    protected DaoCouponCategory daoCouponCategory;

    public CouponCategorySyncManagerProcess(Context context, String s)
    {
        super(context, s);
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return (new Object[] {
            "limit", Integer.valueOf(200), "order", "name", "toplevel", "true", "view", "android"
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/freebies/categories";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoCouponCategory.getLastUpdatedByChannelId(dbChannel);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (CouponCategoryListContainer)obj;
        if (inputstream == null || ((CouponCategoryListContainer) (inputstream)).categories == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Categories no loaded");
            }
        } else
        {
            daoCouponCategory.deleteByChannelId(dbChannel);
            for (inputstream = ((CouponCategoryListContainer) (inputstream)).categories.iterator(); inputstream.hasNext(); daoCouponCategory.create(obj))
            {
                obj = (CouponCategory)inputstream.next();
                obj.channel = dbChannel;
            }

        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/db/models/CouponCategoryListContainer);
    }
}
