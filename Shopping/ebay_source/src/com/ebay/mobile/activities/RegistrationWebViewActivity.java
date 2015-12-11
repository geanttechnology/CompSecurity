// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.mobile.signin.InstantiateGuidLoader;
import com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.util.HashMap;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public final class RegistrationWebViewActivity extends ShowWebViewActivity
    implements com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager.Observer
{

    private static final int LOADER_ID_INSTANTIATE_GUID = 2;
    private boolean deferLoad;
    private String tmxSessionId;

    public RegistrationWebViewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        deferLoad = DeviceConfiguration.getAsync().get(DcsNautilusBoolean.ThreatMatrixRiskModule);
        super.onCreate(bundle);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (deferLoad)
        {
            datamanagercontainer.initialize(ThreatMatrixDataManager.key(), this);
        }
        if (headers != null && headers.containsKey("x-ebay-mobile-profile-session"))
        {
            deferLoad = false;
        }
    }

    public void onInitialized(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
    }

    protected void onRefresh()
    {
        if (!deferLoad)
        {
            super.onRefresh();
        }
    }

    public void onRegistered(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            tmxSessionId = s;
            getFwLoaderManager().start(2, new InstantiateGuidLoader(this), true);
            return;
        } else
        {
            deferLoad = false;
            onRefresh();
            return;
        }
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        if (i == 2)
        {
            fwloader = (InstantiateGuidLoader)fwloader;
            if (fwloader != null && !TextUtils.isEmpty(((InstantiateGuidLoader) (fwloader)).id3pp) && !TextUtils.isEmpty(((InstantiateGuidLoader) (fwloader)).id4pp))
            {
                if (headers == null)
                {
                    headers = new HashMap();
                }
                headers.put("x-ebay-mobile-profile-session", EbayRequest.generateTmxProfileSessionValue(tmxSessionId));
                headers.put("x-ebay3pp-device-id", ((InstantiateGuidLoader) (fwloader)).id3pp);
                headers.put("x-ebay-4pp", ((InstantiateGuidLoader) (fwloader)).id4pp);
            }
            deferLoad = false;
            onRefresh();
        }
    }
}
