// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoGiftingCategory;
import com.groupon.db.dao.DaoGiftingTheme;
import com.groupon.db.models.GiftingCategory;
import com.groupon.db.models.GiftingTheme;
import com.groupon.db.models.GiftingThemesContainer;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class GiftingThemesSyncManagerProcess extends AbstractSyncManagerProcess
{

    private static final String THEMES_URL = "https:/gifts/themes";
    protected DaoGiftingCategory daoGiftingCategory;
    protected DaoGiftingTheme daoGiftingTheme;

    public GiftingThemesSyncManagerProcess(Context context, String s)
    {
        super(context, s);
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return (new Object[] {
            "context", "mobile", "locale", Locale.US
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/gifts/themes";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoGiftingTheme.getLastUpdatedByChannelId(dbChannel);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (GiftingThemesContainer)obj;
        if (inputstream == null || ((GiftingThemesContainer) (inputstream)).themes == null || ((GiftingThemesContainer) (inputstream)).categories == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Not loaded");
            }
        } else
        {
            daoGiftingTheme.deleteByChannelId(dbChannel);
            daoGiftingCategory.deleteByChannelId(dbChannel);
            for (obj = ((GiftingThemesContainer) (inputstream)).themes.iterator(); ((Iterator) (obj)).hasNext(); daoGiftingTheme.save(universalinfo))
            {
                universalinfo = (GiftingTheme)((Iterator) (obj)).next();
                universalinfo.channel = dbChannel;
                universalinfo.afterJsonDeserializationPostProcessor();
            }

            for (inputstream = ((GiftingThemesContainer) (inputstream)).categories.iterator(); inputstream.hasNext(); daoGiftingCategory.save(((GiftingCategory) (obj))))
            {
                obj = (GiftingCategory)inputstream.next();
                obj.channel = dbChannel;
            }

        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/db/models/GiftingThemesContainer);
    }
}
