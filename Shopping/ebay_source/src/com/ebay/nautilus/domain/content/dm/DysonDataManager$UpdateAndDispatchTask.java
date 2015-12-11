// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.location.Location;
import android.os.AsyncTask;
import com.ebay.nautilus.domain.dcs.DcsNautilusLong;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.dyson.DysonBeaconRequest;
import com.ebay.nautilus.domain.net.api.dyson.DysonBeaconResponse;
import com.ebay.nautilus.domain.net.api.dyson.DysonLogRiskMetadataRequest;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.util.FwLog;
import com.paypal.android.lib.riskcomponent.Configuration;
import com.paypal.android.lib.riskcomponent.RiskComponent;
import com.paypal.android.lib.riskcomponent.SourceApp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            DysonDataManager

class flushCache extends AsyncTask
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
        if (DysonDataManager.access$100().hTask)
        {
            FwLog.logMethod(DysonDataManager.access$100(), new Object[0]);
        }
        if (flushCache)
        {
            DysonDataManager.access$200().remove("riskProfile");
        } else
        {
            obj = (flushCache)DysonDataManager.access$200().get("riskProfile");
        }
        if (obj != null && !((() (obj))))
        {
            if (DysonDataManager.access$100()._fld300)
            {
                DysonDataManager.access$100()._mth300("cache hit and not stale");
            }
            try
            {
                avoid = new JSONObject((() (obj)).);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                DysonDataManager.access$100().ig("failed parsing cached config", avoid);
                avoid = ((Void []) (obj1));
            }
        } else
        {
            avoid = ((Void []) (obj1));
            if (DysonDataManager.access$100().ig)
            {
                DysonDataManager.access$100().ig("cache miss or stale, updating cache");
                avoid = ((Void []) (obj1));
            }
        }
        if (avoid != null)
        {
            break MISSING_BLOCK_LABEL_589;
        }
        if (DysonDataManager.access$100().ig)
        {
            DysonDataManager.access$100().ig("updating configuration");
        }
        avoid = new HashMap();
        if (obj != null && (() (obj)). != null)
        {
            avoid.put("RISK_MANAGER_PAIRING_ID", (() (obj)).);
        }
        avoid.put("RISK_MANAGER_CONF_URL", riskcomponent.getConfigUrl());
        avoid.put("RISK_MANAGER_LOCATION", location);
        riskcomponent.init(((android.content.Context) (obj2)), EbayIdentity.getDeviceIdString(((android.content.Context) (obj2))), SourceApp.EBAY, getEbayContext().getAppInfo().getAppVersionName(), avoid);
        obj1 = new DysonBeaconRequest(riskcomponent);
        avoid = new ResultStatusOwner();
        obj1 = (DysonBeaconResponse)DysonDataManager.access$400(DysonDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj1)), avoid);
        avoid = avoid.getResultStatus();
        if (avoid != ResultStatus.CANCELED && !avoid.hasError()) goto _L2; else goto _L1
_L1:
        if (DysonDataManager.access$100()._fld0)
        {
            DysonDataManager.access$100()._mth0("beacon request failed, aborted");
        }
        avoid = null;
_L4:
        return avoid;
_L2:
        obj1 = ((DysonBeaconResponse) (obj1)).response;
_L6:
        obj2 = new Configuration(((JSONObject) (obj1)));
        riskcomponent.setConfiguration(((Configuration) (obj2)));
        if (obj == null || ((() (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        avoid = riskcomponent;
        if (!((() (obj)))) goto _L4; else goto _L3
_L3:
        if (DysonDataManager.access$100()._fld500)
        {
            DysonDataManager.access$100()._mth500("updating cache");
        }
        long l1 = Math.max(((Configuration) (obj2)).getConfRefreshTimeInterval(), 0x15180L);
        long l = l1;
        if (obj != null)
        {
            l = l1;
            if (!((() (obj))))
            {
                long l2 = ((() (obj)));
                l = l2;
                if (DysonDataManager.access$100()._fld600)
                {
                    DysonDataManager.access$100()._mth600((new StringBuilder()).append("carrying configuration TTL forward, seconds remaining=").append(l2).toString());
                    l = l2;
                }
            }
        }
        avoid = new (((JSONObject) (obj1)).toString(), l, riskcomponent.getPairingID(), riskcomponent.getRiskPayload(), l3, null);
        DysonDataManager.access$200().put("riskProfile", avoid);
        avoid = new DysonLogRiskMetadataRequest(riskcomponent);
        obj = new ResultStatusOwner();
        DysonDataManager.access$800(DysonDataManager.this, avoid, ((ResultStatusOwner) (obj)));
        obj = ((ResultStatusOwner) (obj)).getResultStatus();
        if (obj == ResultStatus.CANCELED)
        {
            break; /* Loop/switch isn't completed */
        }
        avoid = riskcomponent;
        if (!((ResultStatus) (obj)).hasError()) goto _L4; else goto _L5
_L5:
        if (DysonDataManager.access$100()._fld0)
        {
            DysonDataManager.access$100()._mth0("log risk metadata request failed, aborted");
        }
        return null;
        obj1 = new HashMap();
        if (obj != null && ((this._cls0) (obj))._fld0 != null)
        {
            ((Map) (obj1)).put("RISK_MANAGER_PAIRING_ID", ((this._cls0) (obj))._fld0);
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
        if (DysonDataManager.access$100().hTask)
        {
            FwLog.logMethod(DysonDataManager.access$100(), new Object[0]);
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
        if (DysonDataManager.access$100().hTask)
        {
            FwLog.logMethod(DysonDataManager.access$100(), new Object[0]);
        }
        if (!flushCache)
        {
            onLoadComplete(riskcomponent);
        }
        DysonDataManager.access$902(DysonDataManager.this, null);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RiskComponent)obj);
    }

    (Location location1, boolean flag)
    {
        this$0 = DysonDataManager.this;
        super();
        location = location1;
        flushCache = flag;
    }
}
