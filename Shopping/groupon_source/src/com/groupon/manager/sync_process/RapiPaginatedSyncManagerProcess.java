// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.sync_process;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.db.dao.DaoBand;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoCollection;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoFinder;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.Card;
import com.groupon.db.models.Pagination;
import com.groupon.http.RapiRequestBuilder;
import com.groupon.http.synchronous.RapiSyncHttp;
import com.groupon.manager.UniversalInfo;
import com.groupon.models.RapiSearchResponse;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.RapiResponseListener;
import com.groupon.util.SmuggleDealManager;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.manager.sync_process:
//            AbstractPaginatedSyncManagerProcess

public class RapiPaginatedSyncManagerProcess extends AbstractPaginatedSyncManagerProcess
{

    public static final String RAPI_DEAL_SEARCH_URL = "https:/cards/v1/search";
    protected DaoBand bandDao;
    protected DaoBusiness businessDao;
    protected String channelPrefix;
    protected DaoCollection collectionDao;
    private int currentActualPosition;
    private Object currentSyncParams[];
    private int currentTrackingPosition;
    protected DaoDealSummary dealSummaryDao;
    protected DaoFinder finderDao;
    private boolean includeSmuggledDeals;
    private RapiResponseListener rapiResponseListener;
    private RapiRequestProperties requestProperties;
    private boolean shouldForceUpdateOnSync;
    protected SmuggleDealManager smuggleDealManager;

    public RapiPaginatedSyncManagerProcess(Context context, String s, String s1)
    {
        super(context, s);
        includeSmuggledDeals = false;
        channelPrefix = s1;
        dbChannel = s;
    }

    public void clearAllTables()
    {
        if (channelPrefix != null)
        {
            dealSummaryDao.deleteByChannelPrefix(channelPrefix);
            businessDao.deleteByChannelPrefix(channelPrefix);
            daoPagination.deleteByChannelPrefix(channelPrefix);
            finderDao.deleteByChannelPrefix(channelPrefix);
            bandDao.deleteByChannelPrefix(channelPrefix);
            collectionDao.deleteByChannelPrefix(channelPrefix);
            return;
        }
        try
        {
            dealSummaryDao.deleteByChannelId(dbChannel);
            businessDao.clearByChannelId(dbChannel);
            daoPagination.deleteByChannelId(dbChannel);
            finderDao.deleteByChannelId(dbChannel);
            bandDao.deleteByChannelId(dbChannel);
            collectionDao.deleteByChannelId(dbChannel);
            return;
        }
        catch (SQLException sqlexception)
        {
            sqlexception.printStackTrace();
        }
        return;
    }

    public void forceUpdateOnSync()
    {
        shouldForceUpdateOnSync = true;
    }

    public int getNextOffset()
        throws Exception
    {
        return getNextOffset(dbChannel);
    }

    protected Object[] getSyncQueryParams(UniversalInfo universalinfo, int i, int j)
    {
        requestProperties.offset = i;
        requestProperties.limit = j;
        if (includeSmuggledDeals)
        {
            requestProperties.smuggledDeals.clear();
            requestProperties.smuggledDeals.addAll(smuggleDealManager.getDealIdsToBeSmuggled(Channel.FEATURED.name()));
        }
        return (new RapiRequestBuilder(context, requestProperties)).build();
    }

    public String getSyncUrl(UniversalInfo universalinfo, int i, int j)
    {
        return "https:/cards/v1/search";
    }

    public boolean isThrowingErrorOnException()
    {
        return true;
    }

    public long lastUpdated()
        throws Exception
    {
        if (shouldForceUpdateOnSync)
        {
            shouldForceUpdateOnSync = false;
            return 0L;
        } else
        {
            return dealSummaryDao.getLastUpdated(dbChannel);
        }
    }

    public void setDbChannel(String s)
    {
        dbChannel = s;
    }

    public void setIncludeSmuggledDeals(boolean flag)
    {
        includeSmuggledDeals = flag;
    }

    public void setRapiResponseListener(RapiResponseListener rapiresponselistener)
    {
        rapiResponseListener = rapiresponselistener;
    }

    public void setRequestParams(RapiRequestProperties rapirequestproperties)
    {
        requestProperties = rapirequestproperties;
    }

    public void triggerDatabaseTask(InputStream inputstream, Object obj, UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
        inputstream = (RapiSearchResponse)obj;
        if (((RapiSearchResponse) (inputstream)).cards == null)
        {
            if (isThrowingErrorOnException())
            {
                throw new Exception("Cards not loaded");
            }
        } else
        {
            if (i == 0)
            {
                clearAllTables();
                currentActualPosition = 0;
                currentTrackingPosition = 0;
            }
            daoPagination.deleteByChannelId(dbChannel);
            obj = ((RapiSearchResponse) (inputstream)).cards.iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                universalinfo = (Card)((Iterator) (obj)).next();
                universalinfo.save(dbChannel, context, currentActualPosition, currentTrackingPosition);
                currentActualPosition = currentActualPosition + 1;
                if (!universalinfo.skipWhenCalculatingTrackingPosition())
                {
                    currentTrackingPosition = currentTrackingPosition + 1;
                }
            } while (true);
            savePagination(dbChannel, i, ((RapiSearchResponse) (inputstream)).pagination, ((RapiSearchResponse) (inputstream)).cards.size());
        }
    }

    public Object triggerJsonParsing(InputStream inputstream, UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
        inputstream = ((InputStream) (mapper.readValue(inputstream, com/groupon/models/RapiSearchResponse)));
        ((RapiSearchResponse)inputstream).pagination.setCurrentOffset(i);
        if (rapiResponseListener != null)
        {
            rapiResponseListener.onRapiResponseAvailable((RapiSearchResponse)inputstream);
        }
        return inputstream;
    }

    public InputStream triggerSync(UniversalInfo universalinfo, int i, int j)
        throws Exception
    {
        try
        {
            currentSyncParams = getSyncQueryParams(universalinfo, i, j);
            universalinfo = (InputStream)(new RapiSyncHttp(context, java/io/InputStream, getSyncUrl(universalinfo, i, j), currentSyncParams)).call();
        }
        // Misplaced declaration of an exception variable
        catch (UniversalInfo universalinfo)
        {
            throw universalinfo;
        }
        return universalinfo;
    }
}
