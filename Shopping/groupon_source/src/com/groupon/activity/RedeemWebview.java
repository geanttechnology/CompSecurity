// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.loader.MyGrouponItemLoaderCallbacks;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.service.LocationService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.ViewUtils;
import com.groupon.util.WebViewHelper;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class RedeemWebview extends GrouponActivity
{

    public static final int REQUEST_CODE = 10115;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    private MyGrouponItem groupon;
    String grouponId;
    private Lazy intentFactory;
    LocationService locationService;
    Logger logger;
    TextView redeemGroupon;
    WebView webview;
    LinearLayout webviewContent;

    public RedeemWebview()
    {
        intentFactory = new Lazy(this) {

            final RedeemWebview this$0;

            
            {
                this$0 = RedeemWebview.this;
                super(context);
            }
        };
    }

    private void logVoucherView()
    {
        Location location = locationService.getLocation();
        if (location != null)
        {
            logger.logLocationTracking("", (float)location.getLatitude(), (float)location.getLongitude(), (int)location.getAccuracy(), System.currentTimeMillis(), Logger.NULL_NST_FIELD);
            return;
        } else
        {
            ArraySharedPreferences arraysharedpreferences = (ArraySharedPreferences)RoboGuice.getInjector(this).getInstance(Key.get(com/groupon/util/ArraySharedPreferences, Names.named("localizedStore")));
            double d = (double)currentDivisionManager.getCurrentDivision().latE6 / 1000000D;
            double d1 = (double)currentDivisionManager.getCurrentDivision().lngE6 / 1000000D;
            logger.logLocationTracking("", (float)d, (float)d1, 0, System.currentTimeMillis(), Logger.NULL_NST_FIELD);
            return;
        }
    }

    public void onBackPressed()
    {
        if (webview.canGoBack())
        {
            webview.goBack();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        requestWindowFeature(2);
        super.onCreate(bundle);
        setContentView(0x7f0301dc);
        getLoaderManager().initLoader(0, null, new MyGrouponItemLoaderCallbacks(this, grouponId) {

            final RedeemWebview this$0;

            public void onDealLoaded(MyGrouponItem mygrouponitem)
            {
                groupon = mygrouponitem;
                if (groupon == null)
                {
                    finish();
                    return;
                } else
                {
                    mygrouponitem = webview.getSettings();
                    mygrouponitem.setJavaScriptEnabled(true);
                    mygrouponitem.setUseWideViewPort(true);
                    mygrouponitem.setLoadWithOverviewMode(true);
                    mygrouponitem.setBuiltInZoomControls(true);
                    mygrouponitem.setSupportZoom(true);
                    WebViewHelper.addInAppUserAgent(webview);
                    webview.setWebViewClient(new WebViewClient() {

                        final _cls2 this$1;

                        public boolean shouldOverrideUrlLoading(WebView webview1, String s)
                        {
                            return false;
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    webview.setWebChromeClient(new WebChromeClient() {

                        final _cls2 this$1;

                        public void onProgressChanged(WebView webview1, int i)
                        {
                            setProgress(i * 100);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    ViewUtils.initWebView(webview);
                    grouponId = Strings.toString(groupon.remoteId);
                    refresh();
                    logVoucherView();
                    return;
                }
            }

            
            {
                this$0 = RedeemWebview.this;
                super(context, s);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        ActionBarUtil.addRedeemWebview(getSupportActionBar()).findViewById(0x7f100508).setOnClickListener(new android.view.View.OnClickListener() {

            final RedeemWebview this$0;

            public void onClick(View view)
            {
                if (currentCountryManager.getCurrentCountry().isEuCompatible() || currentCountryManager.getCurrentCountry().isUSACompatible())
                {
                    startActivity(((IntentFactory)intentFactory.get()).newCustomerServiceIntent());
                    return;
                } else
                {
                    startActivity(((IntentFactory)intentFactory.get()).newGrouponSupportIntent(grouponId));
                    return;
                }
            }

            
            {
                this$0 = RedeemWebview.this;
                super();
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        super.onDestroy();
        webviewContent.removeAllViews();
        webview.destroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            navigateUpTo(((IntentFactory)intentFactory.get()).newMyGrouponsIntent());
            break;
        }
        return true;
    }

    public void refresh()
    {
        String s1 = groupon.grouponNumber;
        TextView textview = redeemGroupon;
        String s;
        int i;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            i = 0x7f08030c;
        } else
        {
            i = 0x7f08045d;
        }
        s = s1;
        if (Strings.isEmpty(s1))
        {
            s = grouponId;
        }
        textview.setText(getString(i, new Object[] {
            s
        }));
        s = groupon.externalVoucherUrl;
        webview.loadUrl(s);
    }



/*
    static MyGrouponItem access$002(RedeemWebview redeemwebview, MyGrouponItem mygrouponitem)
    {
        redeemwebview.groupon = mygrouponitem;
        return mygrouponitem;
    }

*/



}
