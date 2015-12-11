// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.api.threatmatrix.FingerprintPrepareRequest;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixConfigRequest;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixConfigResponse;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixRiskDataRequest;
import com.ebay.nautilus.domain.net.api.threatmatrix.GetThreatMatrixRiskDataResponse;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.threatmetrix.TrustDefenderMobile.riskmodule.RiskModule;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ThreatMatrixDataManager

public class site extends AsyncTask
{

    private final EbaySite site;
    final ThreatMatrixDataManager this$0;

    protected transient RiskModule doInBackground(RiskModule ariskmodule[])
    {
        RiskModule riskmodule = ariskmodule[0];
        Object obj = new GetThreatMatrixConfigRequest(riskmodule);
        ariskmodule = new ResultStatusOwner();
        obj = (GetThreatMatrixConfigResponse)ThreatMatrixDataManager.access$000(ThreatMatrixDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), ariskmodule);
        ariskmodule = ariskmodule.getResultStatus();
        if (ariskmodule == ResultStatus.CANCELED || ariskmodule.hasError())
        {
            if (ThreatMatrixDataManager.access$100()._fld0)
            {
                ThreatMatrixDataManager.access$100()._mth0("get threat matrix config failed, aborted");
            }
            ariskmodule = null;
        } else
        {
            riskmodule.prepareRiskTransaction(getContext());
            riskmodule.setConfigurationData(((GetThreatMatrixConfigResponse) (obj)).response);
            obj = new GetThreatMatrixRiskDataRequest(riskmodule);
            ariskmodule = new ResultStatusOwner();
            obj = (GetThreatMatrixRiskDataResponse)ThreatMatrixDataManager.access$200(ThreatMatrixDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), ariskmodule);
            ariskmodule = ariskmodule.getResultStatus();
            if (ariskmodule == ResultStatus.CANCELED || ariskmodule.hasError())
            {
                if (ThreatMatrixDataManager.access$100()._fld0)
                {
                    ThreatMatrixDataManager.access$100()._mth0("get threat matrix risk data failed, aborted");
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
                ThreatMatrixDataManager.access$100().response("failed setting risk data", ariskmodule);
                return null;
            }
            ariskmodule = (new StringBuilder()).append("guid=").append(EbayIdentity.getDeviceIdString(getContext())).toString();
            ariskmodule = new FingerprintPrepareRequest(site, ariskmodule, riskmodule.getSessionID());
            obj = new ResultStatusOwner();
            ThreatMatrixDataManager.access$300(ThreatMatrixDataManager.this, ariskmodule, ((ResultStatusOwner) (obj)));
            ariskmodule = ((ResultStatusOwner) (obj)).getResultStatus();
            if (ariskmodule == ResultStatus.CANCELED || ariskmodule.hasError())
            {
                if (ThreatMatrixDataManager.access$100()._fld0)
                {
                    ThreatMatrixDataManager.access$100()._mth0("prepare fingerprint failed, aborted");
                }
                return null;
            }
            ariskmodule = riskmodule;
            if (ThreatMatrixDataManager.access$100()._fld0)
            {
                ThreatMatrixDataManager.access$100()._mth0("risk module registration complete");
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
        ThreatMatrixDataManager.access$402(ThreatMatrixDataManager.this, null);
        if (riskmodule == null)
        {
            ThreatMatrixDataManager.access$500(ThreatMatrixDataManager.this);
            riskmodule = obj;
        } else
        {
            riskmodule = riskmodule.getSessionID();
            ThreatMatrixDataManager.access$602(ThreatMatrixDataManager.this, true);
        }
        ((this._cls0)ThreatMatrixDataManager.access$700(ThreatMatrixDataManager.this)).ed(ThreatMatrixDataManager.this, riskmodule);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RiskModule)obj);
    }

    (EbaySite ebaysite)
    {
        this$0 = ThreatMatrixDataManager.this;
        super();
        site = ebaysite;
    }
}
