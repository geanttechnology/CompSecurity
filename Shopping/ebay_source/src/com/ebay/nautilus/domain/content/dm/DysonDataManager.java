// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.location.Location;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DcsNautilusLong;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.dyson.DysonBeaconRequest;
import com.ebay.nautilus.domain.net.api.dyson.DysonBeaconResponse;
import com.ebay.nautilus.domain.net.api.dyson.DysonLogRiskMetadataRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.paypal.android.lib.riskcomponent.Configuration;
import com.paypal.android.lib.riskcomponent.RiskComponent;
import com.paypal.android.lib.riskcomponent.SourceApp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager

public final class DysonDataManager extends UserContextObservingDataManager
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return DysonDataManager.KEY;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };

        protected DysonDataManager create(EbayContext ebaycontext)
        {
            return new DysonDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        KeyParams()
        {
        }
    }

    public static interface Observer
    {

        public abstract void onPaired(DysonDataManager dysondatamanager, String s, JSONObject jsonobject);
    }

    private static final class RiskProfile extends BaseDataMapped
    {

        public String config;
        public long configTtl;
        public String pairingId;
        public long refreshTime;
        public JSONObject riskPayload;

        private long getConfigTtlRemaining()
        {
            return Math.max(0L, (configTtl - System.currentTimeMillis()) / 1000L);
        }

        private boolean isConfigStale()
        {
            return System.currentTimeMillis() >= configTtl;
        }

        private boolean needsRefresh()
        {
            return System.currentTimeMillis() >= refreshTime;
        }




        public RiskProfile()
        {
        }

        private RiskProfile(String s, long l, String s1, JSONObject jsonobject, long l1)
        {
            config = s;
            pairingId = s1;
            riskPayload = jsonobject;
            long l2 = System.currentTimeMillis();
            configTtl = l * 1000L + l2;
            refreshTime = l1 * 1000L + l2;
        }

        RiskProfile(String s, long l, String s1, JSONObject jsonobject, long l1, 
                _cls1 _pcls1)
        {
            this(s, l, s1, jsonobject, l1);
        }
    }

    class UpdateAndDispatchTask extends AsyncTask
    {

        final boolean flushCache;
        final Location location;
        final DysonDataManager this$0;

        protected transient RiskComponent doInBackground(Void avoid[])
        {
            Object obj;
            Object obj1;
            RiskComponent riskcomponent;
            Object obj2;
            long l3;
            obj2 = getContext();
            riskcomponent = RiskComponent.getInstance();
            obj = null;
            obj1 = null;
            l3 = DeviceConfiguration.getAsync().get(DcsNautilusLong.PayPalDysonRefreshRate);
            if (DysonDataManager.logger.isLoggable)
            {
                FwLog.logMethod(DysonDataManager.logger, new Object[0]);
            }
            if (flushCache)
            {
                DysonDataManager.cacheManager.remove("riskProfile");
            } else
            {
                obj = (RiskProfile)DysonDataManager.cacheManager.get("riskProfile");
            }
            if (obj != null && !((RiskProfile) (obj)).isConfigStale())
            {
                if (DysonDataManager.logger.isLoggable)
                {
                    DysonDataManager.logger.log("cache hit and not stale");
                }
                try
                {
                    avoid = new JSONObject(((RiskProfile) (obj)).config);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    DysonDataManager.logger.logAsWarning("failed parsing cached config", avoid);
                    avoid = ((Void []) (obj1));
                }
            } else
            {
                avoid = ((Void []) (obj1));
                if (DysonDataManager.logger.isLoggable)
                {
                    DysonDataManager.logger.log("cache miss or stale, updating cache");
                    avoid = ((Void []) (obj1));
                }
            }
            if (avoid != null)
            {
                break MISSING_BLOCK_LABEL_589;
            }
            if (DysonDataManager.logger.isLoggable)
            {
                DysonDataManager.logger.log("updating configuration");
            }
            avoid = new HashMap();
            if (obj != null && ((RiskProfile) (obj)).pairingId != null)
            {
                avoid.put("RISK_MANAGER_PAIRING_ID", ((RiskProfile) (obj)).pairingId);
            }
            avoid.put("RISK_MANAGER_CONF_URL", riskcomponent.getConfigUrl());
            avoid.put("RISK_MANAGER_LOCATION", location);
            riskcomponent.init(((android.content.Context) (obj2)), EbayIdentity.getDeviceIdString(((android.content.Context) (obj2))), SourceApp.EBAY, getEbayContext().getAppInfo().getAppVersionName(), avoid);
            obj1 = new DysonBeaconRequest(riskcomponent);
            avoid = new ResultStatusOwner();
            obj1 = (DysonBeaconResponse)safeSendRequest(((Request) (obj1)), avoid);
            avoid = avoid.getResultStatus();
            if (avoid != ResultStatus.CANCELED && !avoid.hasError()) goto _L2; else goto _L1
_L1:
            if (DysonDataManager.logger.isLoggable)
            {
                DysonDataManager.logger.logAsError("beacon request failed, aborted");
            }
            avoid = null;
_L4:
            return avoid;
_L2:
            obj1 = ((DysonBeaconResponse) (obj1)).response;
_L6:
            obj2 = new Configuration(((JSONObject) (obj1)));
            riskcomponent.setConfiguration(((Configuration) (obj2)));
            if (obj == null || ((RiskProfile) (obj)).isConfigStale())
            {
                break; /* Loop/switch isn't completed */
            }
            avoid = riskcomponent;
            if (!((RiskProfile) (obj)).needsRefresh()) goto _L4; else goto _L3
_L3:
            if (DysonDataManager.logger.isLoggable)
            {
                DysonDataManager.logger.log("updating cache");
            }
            long l1 = Math.max(((Configuration) (obj2)).getConfRefreshTimeInterval(), 0x15180L);
            long l = l1;
            if (obj != null)
            {
                l = l1;
                if (!((RiskProfile) (obj)).isConfigStale())
                {
                    long l2 = ((RiskProfile) (obj)).getConfigTtlRemaining();
                    l = l2;
                    if (DysonDataManager.logger.isLoggable)
                    {
                        DysonDataManager.logger.log((new StringBuilder()).append("carrying configuration TTL forward, seconds remaining=").append(l2).toString());
                        l = l2;
                    }
                }
            }
            avoid = new RiskProfile(((JSONObject) (obj1)).toString(), l, riskcomponent.getPairingID(), riskcomponent.getRiskPayload(), l3);
            DysonDataManager.cacheManager.put("riskProfile", avoid);
            avoid = new DysonLogRiskMetadataRequest(riskcomponent);
            obj = new ResultStatusOwner();
            safeSendRequest(avoid, ((ResultStatusOwner) (obj)));
            obj = ((ResultStatusOwner) (obj)).getResultStatus();
            if (obj == ResultStatus.CANCELED)
            {
                break; /* Loop/switch isn't completed */
            }
            avoid = riskcomponent;
            if (!((ResultStatus) (obj)).hasError()) goto _L4; else goto _L5
_L5:
            if (DysonDataManager.logger.isLoggable)
            {
                DysonDataManager.logger.logAsError("log risk metadata request failed, aborted");
            }
            return null;
            obj1 = new HashMap();
            if (obj != null && ((RiskProfile) (obj)).pairingId != null)
            {
                ((Map) (obj1)).put("RISK_MANAGER_PAIRING_ID", ((RiskProfile) (obj)).pairingId);
            }
            ((Map) (obj1)).put("RISK_MANAGER_CONF_URL", riskcomponent.getConfigUrl());
            riskcomponent.init(((android.content.Context) (obj2)), EbayIdentity.getDeviceIdString(((android.content.Context) (obj2))), SourceApp.EBAY, NautilusKernel.getAppVersionName(((android.content.Context) (obj2))), ((Map) (obj1)));
            obj1 = avoid;
              goto _L6
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled(RiskComponent riskcomponent)
        {
            if (DysonDataManager.logger.isLoggable)
            {
                FwLog.logMethod(DysonDataManager.logger, new Object[0]);
            }
            if (!flushCache)
            {
                onLoadComplete(null);
            }
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((RiskComponent)obj);
        }

        protected void onPostExecute(RiskComponent riskcomponent)
        {
            if (DysonDataManager.logger.isLoggable)
            {
                FwLog.logMethod(DysonDataManager.logger, new Object[0]);
            }
            if (!flushCache)
            {
                onLoadComplete(riskcomponent);
            }
            updateAndDispatchTask = null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RiskComponent)obj);
        }

        UpdateAndDispatchTask(Location location1, boolean flag)
        {
            this$0 = DysonDataManager.this;
            super();
            location = location1;
            flushCache = flag;
        }
    }


    private static final String CACHE_KEY = "riskProfile";
    public static final KeyParams KEY = new KeyParams();
    private static final long MAX_CACHE_TTL = 0x3ffffffffffffffeL;
    private static CacheManager cacheManager;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("DysonDataManager", 3, "Dyson data manager logger");
    private UpdateAndDispatchTask updateAndDispatchTask;

    private DysonDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/DysonDataManager$Observer, keyparams);
        if (cacheManager == null)
        {
            cacheManager = new CacheManager(getContext(), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/nautilus/domain/content/dm/DysonDataManager$RiskProfile, "dysonRiskCache", 1, 1, 1L, 0x3ffffffffffffffeL, true);
        }
    }


    public void clear(Location location)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        NautilusKernel.verifyMain();
        if (updateAndDispatchTask != null)
        {
            if (logger.isLoggable)
            {
                logger.log("update already in progress, canceling");
            }
            updateAndDispatchTask.cancel(true);
        }
        location = new UpdateAndDispatchTask(location, true);
        updateAndDispatchTask = location;
        executeOnThreadPool(location, new Void[0]);
    }

    public void load(Location location)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        NautilusKernel.verifyMain();
        if (updateAndDispatchTask != null)
        {
            if (logger.isLoggable)
            {
                logger.log("update already in progress");
            }
            return;
        } else
        {
            location = new UpdateAndDispatchTask(location, false);
            updateAndDispatchTask = location;
            executeOnThreadPool(location, new Void[0]);
            return;
        }
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    protected void onLoadComplete(RiskComponent riskcomponent)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        String s;
        if (riskcomponent != null)
        {
            s = riskcomponent.getPairingID();
        } else
        {
            s = null;
        }
        if (riskcomponent != null)
        {
            try
            {
                riskcomponent = riskcomponent.getRiskPayload();
            }
            // Misplaced declaration of an exception variable
            catch (RiskComponent riskcomponent)
            {
                riskcomponent = null;
            }
        } else
        {
            riskcomponent = null;
        }
        ((Observer)dispatcher).onPaired(this, s, riskcomponent);
    }







/*
    static UpdateAndDispatchTask access$902(DysonDataManager dysondatamanager, UpdateAndDispatchTask updateanddispatchtask)
    {
        dysondatamanager.updateAndDispatchTask = updateanddispatchtask;
        return updateanddispatchtask;
    }

*/
}
