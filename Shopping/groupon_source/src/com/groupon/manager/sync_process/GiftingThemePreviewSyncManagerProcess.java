// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.db.dao.DaoGiftingTheme;
import com.groupon.db.models.GiftingDefaultThemeContainer;
import com.groupon.db.models.GiftingTheme;
import com.groupon.manager.UniversalInfo;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.util.Locale;
import org.codehaus.jackson.JsonFactory;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class GiftingThemePreviewSyncManagerProcess extends AbstractSyncManagerProcess
{

    public static final String DEFAULT = "default";
    private static final String DEFAULT_THEME_URL = "https:/gifts/themes/default";
    protected DaoGiftingTheme daoGiftingTheme;

    public GiftingThemePreviewSyncManagerProcess(Context context, String s)
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
        return "https:/gifts/themes/default";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoGiftingTheme.getLastUpdatedByThemeId("default");
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (GiftingDefaultThemeContainer)obj;
        if (inputstream == null || ((GiftingDefaultThemeContainer) (inputstream)).theme == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Not loaded");
            }
        } else
        {
            daoGiftingTheme.deleteByThemeId("default");
            inputstream = ((GiftingDefaultThemeContainer) (inputstream)).theme;
            inputstream.channel = dbChannel;
            inputstream.afterJsonDeserializationPostProcessor();
            daoGiftingTheme.save(inputstream);
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = jsonFactory.createJsonParser(inputstream);
        return mapper.readValue(inputstream, com/groupon/db/models/GiftingDefaultThemeContainer);
    }
}
