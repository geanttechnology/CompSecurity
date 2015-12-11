// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            FollowSvcShared, InterestDescriptor, SaasSearchRequest, BaseFollowInterestResponse, 
//            BaseFollowInterestRequest

public final class GetInterestsLoadTask extends AsyncTask
{
    public static abstract class CacheConfig
        implements com.ebay.nautilus.kernel.cachemanager.CacheManager.CacheConfig
    {

        public boolean enablePersistence()
        {
            return true;
        }

        public long getDiskLimit()
        {
            if (enablePersistence())
            {
                return (long)getMemoryLimit();
            } else
            {
                return 0L;
            }
        }

        public int getFlatMemoryLimit()
        {
            return 0;
        }

        public long getMaxTtl()
        {
            return 0x9a7ec800L;
        }

        public int getMemoryLimit()
        {
            return 200;
        }

        public CacheConfig()
        {
        }
    }

    public static class GetInterestResponse extends BaseFollowInterestResponse
    {

        private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
            8, 128, 64
        }).setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapter(com/ebay/common/net/api/followinterest/SaasSearchRequest$Location, new SaasSearchRequest.Location.Deserializer()).enableComplexMapKeySerialization().create();
        public HashMap interests;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            try
            {
                java.lang.reflect.Type type = (new TypeToken() {

                    final GetInterestResponse this$0;

            
            {
                this$0 = GetInterestResponse.this;
                super();
            }
                }).getType();
                setResult((HashMap)MAPPER.fromJson(new InputStreamReader(inputstream, "UTF-8"), type));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException(inputstream);
            }
        }

        public void setResult(HashMap hashmap)
        {
            interests = hashmap;
        }


        public GetInterestResponse()
        {
            super(true);
        }
    }

    public static class GetInterestsRequest extends BaseFollowInterestRequest
    {

        public static final String OPERATION_NAME = "getInterests";
        public static final String SERVICE_NAME = "InterestService";
        private final List interestIds;

        public URL getRequestUrl()
        {
            Object obj;
            try
            {
                obj = new StringBuilder(ApiSettings.get(EbaySettings.interestBaseUrl));
                ((StringBuilder) (obj)).append("metadata?interestIds=");
                if (!interestIds.isEmpty())
                {
                    ((StringBuilder) (obj)).append(TextUtils.join(",", interestIds));
                }
                obj = new URL(((StringBuilder) (obj)).toString());
            }
            catch (MalformedURLException malformedurlexception)
            {
                malformedurlexception.printStackTrace();
                return null;
            }
            return ((URL) (obj));
        }

        public GetInterestResponse getResponse()
        {
            return new GetInterestResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        protected boolean isIdempotent()
        {
            return true;
        }

        public GetInterestsRequest(List list, String s, String s1)
        {
            super("InterestService", "getInterests", s, s1);
            interestIds = list;
        }
    }

    public static interface Observer
    {

        public abstract void handleInterestsLoaded(GetInterestsLoadTask getinterestsloadtask, DatedContent datedcontent);
    }

    public static class Params
    {

        public CacheConfig cacheConfig;
        public String iafToken;
        public List interestIds;
        public String marketPlaceId;
        public int maxInterestsPerRequest;

        public Params()
        {
        }
    }


    private static final Object cacheLock = new Object();
    private static CacheManager interestCache;
    private final EbayContext ebayContext;
    private final Observer observer;

    public GetInterestsLoadTask(EbayContext ebaycontext, Observer observer1)
    {
        ebayContext = ebaycontext;
        observer = observer1;
    }

    public static void invalidateCache()
    {
        if (FollowSvcShared.isMain())
        {
            (new AsyncTask() {

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    GetInterestsLoadTask.invalidateCache();
                    return null;
                }

            }).execute(new Void[0]);
            return;
        }
        synchronized (cacheLock)
        {
            if (interestCache != null)
            {
                interestCache.clear();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected transient DatedContent doInBackground(Params aparams[])
    {
        ResultStatus resultstatus;
        Object obj3;
        Object obj4;
        int i;
        if (aparams == null || aparams.length != 1)
        {
            cancel(false);
            return new DatedContent(ResultStatus.CANCELED);
        }
        resultstatus = ResultStatus.SUCCESS;
        obj3 = aparams[0];
        if (((Params) (obj3)).interestIds == null || ((Params) (obj3)).interestIds.isEmpty())
        {
            return new DatedContent(ResultStatus.SUCCESS);
        }
        int j = ((Params) (obj3)).maxInterestsPerRequest;
        i = j;
        if (j <= 0)
        {
            i = 20;
        }
        aparams = interestCache;
        obj = aparams;
        if (aparams == null)
        {
            synchronized (cacheLock)
            {
                if (interestCache == null)
                {
                    interestCache = new CacheManager((Context)ebayContext.getExtension(android/content/Context), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/common/net/api/followinterest/InterestDescriptor, "interestCache", ((Params) (obj3)).cacheConfig.getMemoryLimit(), ((Params) (obj3)).cacheConfig.getFlatMemoryLimit(), ((Params) (obj3)).cacheConfig.getDiskLimit(), ((Params) (obj3)).cacheConfig.getMaxTtl(), true);
                }
                obj = interestCache;
            }
        }
        obj4 = new ArrayList();
        aparams = ((Params) (obj3)).interestIds.iterator();
        do
        {
            if (!aparams.hasNext())
            {
                break;
            }
            String s = (String)aparams.next();
            if (s != null && ((CacheManager) (obj)).get(s) == null)
            {
                ((List) (obj4)).add(s);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_253;
        obj;
        aparams;
        JVM INSTR monitorexit ;
        throw obj;
        int k = 0;
_L3:
        if (k >= ((List) (obj4)).size()) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = new GetInterestsRequest(((List) (obj4)).subList(k, Math.min(((List) (obj4)).size(), k + i)), ((Params) (obj3)).iafToken, ((Params) (obj3)).marketPlaceId);
        aparams = null;
        obj1 = (GetInterestResponse)ebayContext.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj1)));
        aparams = ((Params []) (obj1));
        Object obj2 = ((GetInterestResponse) (obj1)).getResultStatus();
        resultstatus = ((ResultStatus) (obj2));
        aparams = ((Params []) (obj1));
_L6:
        if (aparams == null || resultstatus.hasError() || ((GetInterestResponse) (aparams)).interests == null)
        {
            break MISSING_BLOCK_LABEL_456;
        }
        obj1 = ((GetInterestResponse) (aparams)).interests;
        aparams = ((Params []) (cacheLock));
        aparams;
        JVM INSTR monitorenter ;
        for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((CacheManager) (obj)).put((String)((java.util.Map.Entry) (obj2)).getKey(), ((java.util.Map.Entry) (obj2)).getValue()))
        {
            obj2 = (java.util.Map.Entry)((Iterator) (obj1)).next();
        }

        break MISSING_BLOCK_LABEL_444;
        obj;
        aparams;
        JVM INSTR monitorexit ;
        throw obj;
        aparams;
        JVM INSTR monitorexit ;
        k += i;
          goto _L3
        return new DatedContent(resultstatus);
_L2:
        aparams = new LinkedHashMap();
        obj1 = cacheLock;
        obj1;
        JVM INSTR monitorenter ;
        obj2 = ((Params) (obj3)).interestIds.iterator();
_L5:
        do
        {
            if (!((Iterator) (obj2)).hasNext())
            {
                break MISSING_BLOCK_LABEL_551;
            }
            obj3 = (String)((Iterator) (obj2)).next();
            obj4 = (InterestDescriptor)((CacheManager) (obj)).get(((String) (obj3)));
        } while (obj4 == null);
        aparams.put(obj3, obj4);
        if (true) goto _L5; else goto _L4
_L4:
        aparams;
        obj1;
        JVM INSTR monitorexit ;
        throw aparams;
        obj1;
        JVM INSTR monitorexit ;
        InterestDescriptor interestdescriptor;
        for (Iterator iterator = aparams.entrySet().iterator(); iterator.hasNext(); interestdescriptor.searchRequest.populateTransientValues(ebayContext, EbaySite.getInstanceFromId(interestdescriptor.marketplaceId)))
        {
            interestdescriptor = (InterestDescriptor)((java.util.Map.Entry)iterator.next()).getValue();
        }

        return new DatedContent(aparams, resultstatus);
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L6
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Params[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        observer.handleInterestsLoaded(this, new DatedContent(ResultStatus.CANCELED));
    }

    protected void onPostExecute(DatedContent datedcontent)
    {
        super.onPostExecute(datedcontent);
        observer.handleInterestsLoaded(this, datedcontent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((DatedContent)obj);
    }

}
