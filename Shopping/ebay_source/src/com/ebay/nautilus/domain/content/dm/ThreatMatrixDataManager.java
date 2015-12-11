// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.api.threatmatrix.FingerprintPrepareRequest;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixConfigRequest;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixConfigResponse;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixRiskDataRequest;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixRiskDataResponse;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.LocationUtil;
import com.threatmetrix.TrustDefenderMobile.TrustDefenderMobileRiskModule;
import com.threatmetrix.TrustDefenderMobile.riskmodule.RiskModule;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager

public final class ThreatMatrixDataManager extends UserContextObservingDataManager
{
    public class InitRiskModuleTask extends AsyncTask
    {

        private final EbaySite site;
        final ThreatMatrixDataManager this$0;

        protected transient RiskModule doInBackground(RiskModule ariskmodule[])
        {
            RiskModule riskmodule = ariskmodule[0];
            Object obj = new GetThreatMatrixConfigRequest(riskmodule);
            ariskmodule = new ResultStatusOwner();
            obj = (GetThreatMatrixConfigResponse)safeSendRequest(((Request) (obj)), ariskmodule);
            ariskmodule = ariskmodule.getResultStatus();
            if (ariskmodule == ResultStatus.CANCELED || ariskmodule.hasError())
            {
                if (ThreatMatrixDataManager.logger.isLoggable)
                {
                    ThreatMatrixDataManager.logger.logAsError("get threat matrix config failed, aborted");
                }
                ariskmodule = null;
            } else
            {
                riskmodule.prepareRiskTransaction(getContext());
                riskmodule.setConfigurationData(((GetThreatMatrixConfigResponse) (obj)).response);
                obj = new GetThreatMatrixRiskDataRequest(riskmodule);
                ariskmodule = new ResultStatusOwner();
                obj = (GetThreatMatrixRiskDataResponse)safeSendRequest(((Request) (obj)), ariskmodule);
                ariskmodule = ariskmodule.getResultStatus();
                if (ariskmodule == ResultStatus.CANCELED || ariskmodule.hasError())
                {
                    if (ThreatMatrixDataManager.logger.isLoggable)
                    {
                        ThreatMatrixDataManager.logger.logAsError("get threat matrix risk data failed, aborted");
                    }
                    return null;
                }
                try
                {
                    riskmodule.setRiskDataResponse(((GetThreatMatrixRiskDataResponse) (obj)).response);
                }
                // Misplaced declaration of an exception variable
                catch (RiskModule ariskmodule[])
                {
                    ThreatMatrixDataManager.logger.logAsError("failed setting risk data", ariskmodule);
                    return null;
                }
                ariskmodule = (new StringBuilder()).append("guid=").append(EbayIdentity.getDeviceIdString(getContext())).toString();
                ariskmodule = new FingerprintPrepareRequest(site, ariskmodule, riskmodule.getSessionID());
                obj = new ResultStatusOwner();
                safeSendRequest(ariskmodule, ((ResultStatusOwner) (obj)));
                ariskmodule = ((ResultStatusOwner) (obj)).getResultStatus();
                if (ariskmodule == ResultStatus.CANCELED || ariskmodule.hasError())
                {
                    if (ThreatMatrixDataManager.logger.isLoggable)
                    {
                        ThreatMatrixDataManager.logger.logAsError("prepare fingerprint failed, aborted");
                    }
                    return null;
                }
                ariskmodule = riskmodule;
                if (ThreatMatrixDataManager.logger.isLoggable)
                {
                    ThreatMatrixDataManager.logger.log("risk module registration complete");
                    return riskmodule;
                }
            }
            return ariskmodule;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((RiskModule[])aobj);
        }

        protected void onPostExecute(RiskModule riskmodule)
        {
            Object obj = null;
            super.onPostExecute(riskmodule);
            initRiskModuleTask = null;
            if (riskmodule == null)
            {
                initRiskModule();
                riskmodule = obj;
            } else
            {
                riskmodule = riskmodule.getSessionID();
                registered = true;
            }
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((RiskModule)obj);
        }

        InitRiskModuleTask(EbaySite ebaysite)
        {
            this$0 = ThreatMatrixDataManager.this;
            super();
            site = ebaysite;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return ThreatMatrixDataManager.KEY;
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

        protected ThreatMatrixDataManager create(EbayContext ebaycontext)
        {
            return new ThreatMatrixDataManager(ebaycontext, this);
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

        public abstract void onInitialized(ThreatMatrixDataManager threatmatrixdatamanager, String s);

        public abstract void onRegistered(ThreatMatrixDataManager threatmatrixdatamanager, String s);
    }


    protected static final KeyParams KEY = new KeyParams();
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new LogInfo("ThreatMatrixDataManager", 3, "Threat matrix data manager logger");
    private InitRiskModuleTask initRiskModuleTask;
    private boolean registered;
    private RiskModule riskModule;

    ThreatMatrixDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/ThreatMatrixDataManager$Observer, keyparams);
        initRiskModule();
    }

    private void initRiskModule()
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        registered = false;
        riskModule = new TrustDefenderMobileRiskModule();
        riskModule.initWithoutTransport("usllpic0", null);
    }

    public static KeyParams key()
    {
        return KEY;
    }

    public void loadData(Observer observer)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        NautilusKernel.verifyMain();
        String s = riskModule.getSessionID();
        if (registered)
        {
            observer = (Observer)getSafeCallback(observer);
            if (observer != null)
            {
                observer.onInitialized(this, s);
                if (logger.isLoggable)
                {
                    logger.log("registration complete, synthesizing registration callback");
                }
                observer.onRegistered(this, s);
            }
        } else
        {
            if (initRiskModuleTask == null)
            {
                if (logger.isLoggable)
                {
                    logger.log("starting registration");
                }
                riskModule.setLocation(LocationUtil.getLastKnownLocation(getContext()));
                observer = new InitRiskModuleTask(getCurrentCountry().getSite());
                initRiskModuleTask = observer;
                executeOnThreadPool(observer, new RiskModule[] {
                    riskModule
                });
                return;
            }
            if (logger.isLoggable)
            {
                logger.log("registration already in progress");
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logger.isLoggable)
        {
            FwLog.logMethod(logger, new Object[0]);
        }
        if (!TextUtils.isEmpty(s1) && riskModule != null)
        {
            if (logger.isLoggable)
            {
                logger.log("user signed in, clearing session");
            }
            initRiskModule();
        }
    }







/*
    static InitRiskModuleTask access$402(ThreatMatrixDataManager threatmatrixdatamanager, InitRiskModuleTask initriskmoduletask)
    {
        threatmatrixdatamanager.initRiskModuleTask = initriskmoduletask;
        return initriskmoduletask;
    }

*/



/*
    static boolean access$602(ThreatMatrixDataManager threatmatrixdatamanager, boolean flag)
    {
        threatmatrixdatamanager.registered = flag;
        return flag;
    }

*/

}
