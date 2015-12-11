// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.model.followinterest.FollowDescriptor;
import com.ebay.common.model.followinterest.FollowList;
import com.ebay.common.model.followinterest.FollowType;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsNautilusInteger;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Response;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            FollowSvcShared, BaseFollowInterestRequest, BaseFollowInterestResponse

public final class GetFollowsLoadTask extends AsyncTask
{
    public static abstract class CacheConfig
        implements com.ebay.nautilus.kernel.cachemanager.CacheManager.CacheConfig
    {

        public abstract boolean enablePersistence();

        public boolean equals(Object obj)
        {
            if (obj instanceof CacheConfig)
            {
                if (getMemoryLimit() == ((CacheConfig) (obj = (CacheConfig)obj)).getMemoryLimit() && getFlatMemoryLimit() == ((CacheConfig) (obj)).getFlatMemoryLimit() && getDiskLimit() == ((CacheConfig) (obj)).getDiskLimit() && getMaxTtl() == ((CacheConfig) (obj)).getMaxTtl() && enablePersistence() == ((CacheConfig) (obj)).enablePersistence())
                {
                    return true;
                }
            }
            return false;
        }

        public long getDiskLimit()
        {
            return !enablePersistence() ? 0L : 1L;
        }

        public int getFlatMemoryLimit()
        {
            return 1;
        }

        public abstract long getMaxTtl();

        public int getMemoryLimit()
        {
            return 1;
        }

        public int hashCode()
        {
            int j = getMemoryLimit();
            int k = getFlatMemoryLimit();
            int l = (int)getDiskLimit();
            int i1 = (int)getMaxTtl();
            int i;
            if (enablePersistence())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return (((j * 31 + k) * 31 + l) * 31 + i1) * 31 + i;
        }

        public CacheConfig()
        {
        }
    }

    public static class GetFollowsRequest extends BaseFollowInterestRequest
    {

        public static final String OPERATION_NAME = "getUserFollowSummary";
        public static final String SERVICE_NAME = "FollowService";

        public URL getRequestUrl()
        {
            Object obj;
            try
            {
                obj = new StringBuilder(ApiSettings.get(EbaySettings.followBaseUrl));
                ((StringBuilder) (obj)).append("following/user/@self");
                if (DeviceConfiguration.getAsync().get(DcsNautilusBoolean.searchFollowRequestUsernameField))
                {
                    ((StringBuilder) (obj)).append("?fields=username");
                }
                obj = new URL(((StringBuilder) (obj)).toString());
            }
            catch (MalformedURLException malformedurlexception)
            {
                throw new RuntimeException(malformedurlexception);
            }
            return ((URL) (obj));
        }

        public GetFollowsResponse getResponse()
        {
            return new GetFollowsResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected boolean isIdempotent()
        {
            return true;
        }

        public GetFollowsRequest(String s, String s1)
        {
            super("FollowService", "getUserFollowSummary", s, s1);
        }
    }

    public static class GetFollowsResponse extends BaseFollowInterestResponse
    {

        private static final List SUCCESS_CODES = Arrays.asList(new Integer[] {
            Integer.valueOf(200)
        });
        public FollowList follows;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            follows = new FollowList();
            setResult((FollowList)readJsonStream(inputstream, com/ebay/common/model/followinterest/FollowList));
        }

        public void setResult(FollowList followlist)
        {
            if (followlist.interests != null)
            {
                for (Iterator iterator = followlist.interests.iterator(); iterator.hasNext();)
                {
                    FollowDescriptor followdescriptor = (FollowDescriptor)iterator.next();
                    followdescriptor.id = followdescriptor.getInterestId();
                    followdescriptor.type = FollowType.INTEREST;
                }

            } else
            {
                followlist.interests = Collections.emptyList();
            }
            if (followlist.collections != null)
            {
                for (Iterator iterator1 = followlist.collections.iterator(); iterator1.hasNext();)
                {
                    FollowDescriptor followdescriptor1 = (FollowDescriptor)iterator1.next();
                    followdescriptor1.id = followdescriptor1.collectionId;
                    followdescriptor1.type = FollowType.COLLECTION;
                }

            } else
            {
                followlist.collections = Collections.emptyList();
            }
            if (followlist.users != null)
            {
                for (Iterator iterator2 = followlist.users.iterator(); iterator2.hasNext();)
                {
                    FollowDescriptor followdescriptor2 = (FollowDescriptor)iterator2.next();
                    followdescriptor2.id = followdescriptor2.username;
                    followdescriptor2.type = FollowType.USER;
                }

            } else
            {
                followlist.users = Collections.emptyList();
            }
            follows = followlist;
        }


        public GetFollowsResponse()
        {
            super(true);
            setSuccessCodes(SUCCESS_CODES);
        }
    }

    public static interface Observer
    {

        public abstract void handleFollowsLoaded(GetFollowsLoadTask getfollowsloadtask, DatedContent datedcontent);
    }

    public static class Params
    {

        public CacheConfig cacheConfig;
        public boolean forceRefresh;
        public String iafToken;
        public String marketPlaceId;

        public Params()
        {
        }
    }


    public static final CacheConfig DEFAULT_CONFIG = new CacheConfig() {

        public boolean enablePersistence()
        {
            return true;
        }

        public long getMaxTtl()
        {
            return (long)DeviceConfiguration.getAsync().get(DcsNautilusInteger.searchFollowMaxFollowCacheTtlInMinutes) * 60000L;
        }

    };
    private static CacheManager _followCache;
    private static CacheConfig _followCacheConfig;
    private static final Object cacheLock = new Object();
    private final EbayContext ebayContext;
    private final Observer observer;

    public GetFollowsLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    public static CacheManager getFollowCache(Context context, CacheConfig cacheconfig)
    {
        CacheConfig cacheconfig1 = cacheconfig;
        if (cacheconfig == null)
        {
            cacheconfig1 = _followCacheConfig;
        }
        cacheconfig = cacheconfig1;
        if (cacheconfig1 == null)
        {
            cacheconfig = DEFAULT_CONFIG;
        }
        synchronized (cacheLock)
        {
            if (_followCache == null || cacheconfig != DEFAULT_CONFIG && !_followCacheConfig.equals(cacheconfig))
            {
                _followCacheConfig = cacheconfig;
                _followCache = new CacheManager(context.getApplicationContext(), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/common/model/followinterest/FollowList, "followCache", cacheconfig.getMemoryLimit(), cacheconfig.getFlatMemoryLimit(), cacheconfig.getDiskLimit(), cacheconfig.getMaxTtl(), true);
            }
        }
        return _followCache;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static void invalidateCache(Context context)
    {
        if (FollowSvcShared.isMain())
        {
            (new AsyncTask(context) {

                final Context val$context;

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    GetFollowsLoadTask.invalidateCache(context);
                    return null;
                }

            
            {
                context = context1;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        Object obj = cacheLock;
        obj;
        JVM INSTR monitorenter ;
        context = getFollowCache(context, DEFAULT_CONFIG);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        context.clear();
        obj;
        JVM INSTR monitorexit ;
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    protected transient DatedContent doInBackground(Params aparams[])
    {
        Object obj;
        Object obj1;
        DatedContent datedcontent;
        Params params;
        CacheManager cachemanager;
        datedcontent = new DatedContent(ResultStatus.CANCELED);
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return datedcontent;
        }
        params = aparams[0];
        if (TextUtils.isEmpty(params.iafToken) || TextUtils.isEmpty(params.marketPlaceId))
        {
            cancel(false);
            return null;
        }
        cachemanager = getFollowCache((Context)ebayContext.getExtension(android/content/Context), params.cacheConfig);
        if (!params.forceRefresh)
        {
            aparams = (FollowList)cachemanager.get(params.iafToken);
            if (aparams != null)
            {
                return new DatedContent(aparams, ResultStatus.SUCCESS);
            }
        }
        obj = new GetFollowsRequest(params.iafToken, params.marketPlaceId);
        aparams = null;
        obj1 = ResultStatus.CANCELED;
        obj = (GetFollowsResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj)));
        aparams = ((Params []) (obj));
        ResultStatus resultstatus = ((GetFollowsResponse) (obj)).getResultStatus();
        aparams = resultstatus;
_L1:
        obj1 = datedcontent;
        if (obj != null)
        {
            if (aparams.hasError())
            {
                obj1 = datedcontent;
                if (FollowSvcShared.followSvcLogger.isLoggable)
                {
                    obj1 = aparams.getFirstError().getLongMessage(ebayContext);
                    obj = obj1;
                    if (obj1 == null)
                    {
                        obj = aparams.getFirstError().getShortMessage(ebayContext);
                    }
                    FollowSvcShared.followSvcLogger.log((new StringBuilder()).append("GetFollowsRequest failed:").append(((String) (obj))).toString());
                    obj1 = datedcontent;
                }
            } else
            {
                obj1 = datedcontent;
                if (((GetFollowsResponse) (obj)).follows != null)
                {
                    cachemanager.put(params.iafToken, ((GetFollowsResponse) (obj)).follows);
                    obj1 = new DatedContent(((GetFollowsResponse) (obj)).follows, ((GetFollowsResponse) (obj)).getResultStatus());
                }
            }
        }
        return ((DatedContent) (obj1));
        obj;
        ((InterruptedException) (obj)).printStackTrace();
        obj = aparams;
        aparams = ((Params []) (obj1));
          goto _L1
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Params[])aobj);
    }

    protected void onCancelled(DatedContent datedcontent)
    {
        if (FollowSvcShared.followSvcLogger.isLoggable)
        {
            FollowSvcShared.followSvcLogger.log("GetFollowsRequest was cancelled");
        }
        observer.handleFollowsLoaded(this, new DatedContent(ResultStatus.CANCELED));
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((DatedContent)obj);
    }

    protected void onPostExecute(DatedContent datedcontent)
    {
        observer.handleFollowsLoaded(this, datedcontent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((DatedContent)obj);
    }

}
