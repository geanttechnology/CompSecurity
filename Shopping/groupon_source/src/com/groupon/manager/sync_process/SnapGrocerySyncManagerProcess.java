// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.activity.IntentFactory;
import com.groupon.db.dao.DaoSnapGroceryDetails;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.http.synchronous.SnapGrocerySyncHttp;
import com.groupon.manager.UniversalInfo;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.ObjectMapperWrapper;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractSyncManagerProcess

public class SnapGrocerySyncManagerProcess extends AbstractSyncManagerProcess
{
    private static class SnapGroceryDetailsContainer
    {

        public List data;

        private SnapGroceryDetailsContainer()
        {
            data = new ArrayList();
        }
    }


    private static final String PARAM_COUNTRY = "country";
    private static final String PRODUCTION_X_SNAP_VALUE = "641148c9306896fbf7c34434d110cf89";
    private static final String SNAP_OFFER_URL = "https:/snap/service/offers";
    private static final String X_SNAP_AUTHORIZATION = "X-Snap-Authorization";
    protected CurrentCountryManager currentCountryManager;
    protected DaoSnapGroceryDetails daoSnapGroceryDetails;
    protected IntentFactory intentFactory;

    public SnapGrocerySyncManagerProcess(Context context, String s)
    {
        super(context, s);
        this.context = context;
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo)
    {
        return (new Object[] {
            "country", currentCountryManager.getCurrentCountry().shortName
        });
    }

    public String getSyncUrl(UniversalInfo universalinfo)
    {
        return "https:/snap/service/offers";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        return daoSnapGroceryDetails.getLastUpdated(dbChannel);
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo)
        throws Exception
    {
        try
        {
            inputstream = (SnapGroceryDetailsContainer)obj;
            daoSnapGroceryDetails.deleteByChannelId(dbChannel);
            for (inputstream = ((SnapGroceryDetailsContainer) (inputstream)).data.iterator(); inputstream.hasNext(); daoSnapGroceryDetails.save(((SnapGroceryDetail) (obj))))
            {
                obj = (SnapGroceryDetail)inputstream.next();
                obj.channel = dbChannel;
            }

        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw inputstream;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            if (isThrowingErrorOnException())
            {
                throw new SQLException(inputstream);
            }
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo)
        throws Exception
    {
        inputstream = (SnapGroceryDetailsContainer)mapper.readValue(inputstream, com/groupon/manager/sync_process/SnapGrocerySyncManagerProcess$SnapGroceryDetailsContainer);
        for (universalinfo = ((SnapGroceryDetailsContainer) (inputstream)).data.iterator(); universalinfo.hasNext(); ((SnapGroceryDetail)universalinfo.next()).afterJsonDeserializationPostProcessor()) { }
        return inputstream;
    }

    public InputStream triggerSync(UniversalInfo universalinfo)
        throws Exception
    {
        universalinfo = new SnapGrocerySyncHttp(context, java/io/InputStream, getSyncUrl(universalinfo), getSyncQueryParams(universalinfo));
        HashMap hashmap = new HashMap();
        hashmap.put("X-Snap-Authorization", "641148c9306896fbf7c34434d110cf89");
        universalinfo.setHeader(hashmap);
        return (InputStream)universalinfo.call();
    }
}
