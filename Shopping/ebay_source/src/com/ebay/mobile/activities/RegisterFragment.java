// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.RoiTrackingUtil;
import com.ebay.mobile.dcs.DcsHelper;
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
//            BaseFragment, SignInActivity, RegistrationWebViewActivity, ShowWebViewActivity

public class RegisterFragment extends BaseFragment
    implements android.view.View.OnClickListener, com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager.Observer
{
    public static interface OnRegisterListener
    {

        public abstract void onRegister(String s);
    }


    public static final String EXTRA_FROM_HOME = "fromHome";
    private static final int LOADER_ID_INSTANTIATE_GUID = 2;
    private static final int REQUEST_CODE_REGISTER = 1;
    private final DeviceConfiguration config = DeviceConfiguration.getAsync();
    private boolean fromHome;
    protected String id3pp;
    protected String id4pp;
    private View registerButton;
    private String tmxSessionId;

    public RegisterFragment()
    {
        fromHome = false;
    }

    public static Intent getStartingIntent(Context context, boolean flag)
    {
        String s;
        Intent intent;
        if (flag)
        {
            s = SignInActivity.regUrlFromHome();
        } else
        {
            s = MyApp.getDeviceConfiguration().fpaRegistrationUrl();
        }
        intent = new Intent(context, com/ebay/mobile/activities/RegistrationWebViewActivity);
        intent.putExtra("url", s);
        intent.putExtra("android.intent.extra.TITLE", context.getString(0x7f070903));
        intent.putExtra("ok", false);
        intent.putExtra(ShowWebViewActivity.EXTRA_SHOW_MENU, false);
        intent.putExtra("back", true);
        intent.putExtra("impression", "BuyerRegistrationStart");
        intent.putExtra(ShowWebViewActivity.EXTRA_LAST_PAGE_PATTERN, ".*\\b(cmd=REGISTER|VAppEma)\\b.*");
        return intent;
    }

    private void trackRoi(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            RoiTrackingUtil.trackRoi(getActivity(), "Reg-MobileApp", MyApp.getPrefs().getCurrentSite(), s);
        }
    }

    public Intent getRegisterIntent(Context context, boolean flag)
    {
        context = getStartingIntent(context, flag);
        if (config.get(DcsNautilusBoolean.ThreatMatrixRiskModule) && !TextUtils.isEmpty(tmxSessionId))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("x-ebay-mobile-profile-session", EbayRequest.generateTmxProfileSessionValue(tmxSessionId));
            hashmap.put("x-ebay-4pp", id4pp);
            hashmap.put("x-ebay3pp-device-id", id3pp);
            context.putExtra("headers", hashmap);
        }
        return context;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (-1 == j)
        {
            Object obj = null;
            Intent intent1 = null;
            if (intent != null)
            {
                String s = intent.getStringExtra(ShowWebViewActivity.RESULT_VALUE_USERID);
                if (s != null)
                {
                    s.trim();
                }
                trackRoi(s);
                intent = intent.getStringExtra(ShowWebViewActivity.RESULT_VALUE_EMAIL);
                intent1 = intent;
                obj = s;
                if (intent != null)
                {
                    intent.trim();
                    obj = s;
                    intent1 = intent;
                }
            }
            intent = getActivity();
            if (intent instanceof OnRegisterListener)
            {
                intent = (OnRegisterListener)intent;
                if (!TextUtils.isEmpty(intent1))
                {
                    obj = intent1;
                }
                intent.onRegister(((String) (obj)));
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        startActivityForResult(getRegisterIntent(view.getContext(), fromHome), 1);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(false);
        setRetainInstance(true);
        bundle = getArguments();
        if (bundle != null)
        {
            fromHome = bundle.getBoolean("fromHome");
        }
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f0301be, null);
        registerButton = layoutinflater.findViewById(0x7f100549);
        registerButton.setOnClickListener(this);
        if (config.get(DcsNautilusBoolean.ThreatMatrixRiskModule))
        {
            registerButton.setEnabled(false);
            viewgroup = getFwLoaderManager();
            if (viewgroup.getRunningLoader(2) == null)
            {
                viewgroup.start(2, new InstantiateGuidLoader(layoutinflater.getContext()), true);
            }
        }
        return layoutinflater;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (config.get(DcsNautilusBoolean.ThreatMatrixRiskModule))
        {
            datamanagercontainer.initialize(ThreatMatrixDataManager.key(), this);
        }
    }

    public void onInitialized(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
        tmxSessionId = s;
    }

    public void onRegistered(ThreatMatrixDataManager threatmatrixdatamanager, String s)
    {
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
        i;
        JVM INSTR tableswitch 2 2: default 24
    //                   2 25;
           goto _L1 _L2
_L1:
        return;
_L2:
        if ((fwloader = (InstantiateGuidLoader)fwloader) != null)
        {
            id3pp = ((InstantiateGuidLoader) (fwloader)).id3pp;
            id4pp = ((InstantiateGuidLoader) (fwloader)).id4pp;
            registerButton.setEnabled(true);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
