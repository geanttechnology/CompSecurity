// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.EditText;
import com.amazon.mShop.SearchBar;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.smile.SmileHelper;

// Referenced classes of package com.amazon.mShop.home:
//            GatewayActivity

public class HomeSearchBar extends SearchBar
    implements com.amazon.mShop.AmazonActivity.OnConfigurationChangedListener, UserListener
{

    private final Context mContext;

    public HomeSearchBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
    }

    private void setHomeSearBarHintPort(Configuration configuration, int i, int j)
    {
        if (configuration.orientation == 1)
        {
            getSearchInputView().setHint(i);
            return;
        } else
        {
            getSearchInputView().setHint(j);
            return;
        }
    }

    private void setHomeSearBarHintPort(User user, Configuration configuration)
    {
        if (SmileHelper.isSmile())
        {
            setHomeSearBarHintPort(configuration, com.amazon.mShop.android.lib.R.string.smile_home_search_bar_hint_portrait, com.amazon.mShop.android.lib.R.string.smile_search);
            return;
        } else
        {
            setHomeSearBarHintPort(configuration, com.amazon.mShop.android.lib.R.string.home_search_bar_hint_portrait, com.amazon.mShop.android.lib.R.string.search);
            return;
        }
    }

    protected void doBarcodeScan()
    {
        Intent intent = getBarcodeScanIntent();
        intent.putExtra("REFMARKER", "hm_sr_scan");
        intent.putExtra("barcodeActivatedFromHome", true);
        mContext.startActivity(intent);
    }

    public void handleConfigurationChanged(Configuration configuration)
    {
        setHomeSearBarHintPort(User.getUser(), configuration);
    }

    protected void initSearchBar()
    {
        super.initSearchBar();
        if (!(mContext instanceof GatewayActivity)) goto _L2; else goto _L1
_L1:
        ((GatewayActivity)mContext).registerConfigChangedListener(this);
_L4:
        User.addUserListener(this);
        handleConfigurationChanged(getResources().getConfiguration());
        return;
_L2:
        if (mContext instanceof MShopWebGatewayActivity)
        {
            ((MShopWebGatewayActivity)mContext).registerConfigChangedListener(this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void logRefMarker()
    {
        RefMarkerObserver.logRefMarker("hm_sr_txt");
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (mContext instanceof GatewayActivity)
        {
            ((GatewayActivity)mContext).unregisterConfigChangedListener(this);
        } else
        if (mContext instanceof MShopWebGatewayActivity)
        {
            ((MShopWebGatewayActivity)mContext).unregisterConfigChangedListener(this);
            return;
        }
    }

    public void userSignedIn(User user)
    {
        setHomeSearBarHintPort(user, getResources().getConfiguration());
    }

    public void userSignedOut()
    {
        setHomeSearBarHintPort(null, getResources().getConfiguration());
    }

    public void userUpdated(User user)
    {
        setHomeSearBarHintPort(user, getResources().getConfiguration());
    }
}
