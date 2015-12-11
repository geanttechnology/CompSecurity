// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.adapter.GenericRecyclerViewDivider;
import com.groupon.adapter.GiftThemeSelectorAdapter;
import com.groupon.db.events.UniversalUpdateEvent;
import com.groupon.db.models.DerivedGiftTheme;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.manager.sync_process.GiftingThemesSyncManagerProcess;
import com.groupon.models.gift.DerivedGiftCategory;
import com.groupon.models.gift.GiftingRecord;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.GiftingNSTField;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.loader.IUniversalCallback;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.loader.UniversalLoaderCallbacks;
import com.groupon.v3.processor.BackgroundDataProcessor;
import com.groupon.v3.processor.GiftingThemeLoader;
import com.groupon.view.GiftThemeImageView;
import java.util.ArrayList;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class GiftingThemeSelection extends GrouponActivity
    implements GrouponDialogListener, IUniversalCallback, commonlib.manager.SyncManager.SyncUiCallbacks
{
    private class MyWebViewClient extends WebViewClient
    {

        final GiftingThemeSelection this$0;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            webviewProgressBar.setVisibility(8);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            webviewProgressBar.setVisibility(0);
            setActionBarTitle(getString(0x7f08011e));
            super.onPageStarted(webview, s, bitmap);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            webviewProgressBar.setVisibility(8);
            webview.loadUrl("about:blank");
            displayWebViewErrorDialog();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            return false;
        }

        private MyWebViewClient()
        {
            this$0 = GiftingThemeSelection.this;
            super();
        }

    }

    private class OnClickThemeListener
        implements android.view.View.OnClickListener
    {

        final GiftingThemeSelection this$0;

        public void onClick(View view)
        {
            selectedTheme.selected = false;
            view = ((GiftThemeImageView)view).getTheme();
            view.selected = true;
            selectedTheme = view;
            categoryIndex = ((DerivedGiftTheme) (view)).categoryIndex;
            subIndex = ((DerivedGiftTheme) (view)).subIndex;
            themeId = ((DerivedGiftTheme) (view)).id;
            selectorAdapter.notifyDataSetChanged();
            themeWebView.loadUrl(getWebviewUrl());
        }

        private OnClickThemeListener()
        {
            this$0 = GiftingThemeSelection.this;
            super();
        }

    }

    private class SubmitButtonOnClickListener
        implements android.view.View.OnClickListener
    {

        final GiftingThemeSelection this$0;

        public void onClick(View view)
        {
            giftingRecord.themeId = themeId;
            giftingRecord.themeCategoryIndex = categoryIndex;
            giftingRecord.themeSubIndex = subIndex;
            setResult(-1, (new Intent()).putExtra("giftingRecord", giftingRecord));
            view = new ClickExtraInfo();
            GiftingNSTField giftingnstfield = new GiftingNSTField();
            giftingnstfield.deliveryMethod = giftingRecord.deliveryMethod;
            view.gifting = giftingnstfield;
            view.pageId = "gift_theme_selection";
            loggingUtils.logClick("", "gifting_details_done_click", "", null, view);
            if (next != null)
            {
                next.setExtrasClassLoader(getClassLoader());
                next.putExtra("giftingRecord", giftingRecord);
                startActivity(next);
            }
            finish();
        }

        private SubmitButtonOnClickListener()
        {
            this$0 = GiftingThemeSelection.this;
            super();
        }

    }


    private static final String ABOUT_BLANK = "about:blank";
    private static final String CATEGORY_INDEX = "categoryIndex";
    private static final String DB_CHANNEL = "GiftingThemeSelection";
    private static final String FROM = "from";
    private static final String GIFT_THEME_SELECTION = "gift_theme_selection";
    private static final String MESSAGE = "message";
    public static final int REQUEST_CODE = 10153;
    private static final String SUB_INDEX = "subIndex";
    private static final String THEME = "theme";
    private static final String THEME_ID = "themeId";
    private static final String THEME_PREVIEW_URL = "https://www.groupon.com/gifts/touch-preview?";
    private static final String TO = "to";
    private static final String WEBVIEW_ERROR_DIALOG = "webview_error_dialog";
    private int categoryIndex;
    protected DialogManager dialogManager;
    private boolean firstTimeLoaded;
    private List giftCategories;
    GiftingRecord giftingRecord;
    private LoggingUtils loggingUtils;
    Intent next;
    protected SharedPreferences prefs;
    RecyclerView scrollThemeSelector;
    private DerivedGiftTheme selectedTheme;
    private GiftThemeSelectorAdapter selectorAdapter;
    private android.support.v7.widget.RecyclerView.LayoutManager selectorLayoutManager;
    private int subIndex;
    Button submitButton;
    private String themeId;
    private WebView themeWebView;
    FrameLayout themeWebViewPlaceholder;
    ProgressBar themesProgressBar;
    private UniversalLoaderCallbacks universalLoaderCallbacks;
    protected UniversalSyncManager universalSyncManager;
    ProgressBar webviewProgressBar;

    public GiftingThemeSelection()
    {
        firstTimeLoaded = true;
    }

    private void displayWebViewErrorDialog()
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f0801a5), Integer.valueOf(0x104000a), false);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "webview_error_dialog");
    }

    private String getWebviewUrl()
    {
        com.groupon.http.Uris.Builder builder = new com.groupon.http.Uris.Builder("https://www.groupon.com/gifts/touch-preview?");
        builder.appendQueryParameter("from", giftingRecord.fromName);
        builder.appendQueryParameter("to", giftingRecord.recipientName);
        builder.appendQueryParameter("message", giftingRecord.message);
        builder.appendQueryParameter("theme", themeId);
        return builder.build().toString();
    }

    private void setupWebView()
    {
        if (themeWebView == null)
        {
            themeWebView = new WebView(this);
            WebSettings websettings = themeWebView.getSettings();
            websettings.setJavaScriptEnabled(true);
            websettings.setDomStorageEnabled(true);
            websettings.setDefaultTextEncodingName("UTF-8");
            themeWebView.setWebViewClient(new MyWebViewClient());
            themeWebView.loadUrl(getWebviewUrl());
        }
        themeWebViewPlaceholder.addView(themeWebView);
    }

    protected void configureSyncManagerAndLoader()
    {
        Object obj = new ArrayList();
        ((List) (obj)).add(new GiftingThemesSyncManagerProcess(this, "GiftingThemeSelection"));
        universalSyncManager.configurePaginatedSyncManager(null, ((List) (obj)), new UniversalUpdateEvent("GiftingThemeSelection"));
        universalLoaderCallbacks = new UniversalLoaderCallbacks(null, this, "GiftingThemeSelection", this);
        obj = new GiftingThemeLoader(this, "GiftingThemeSelection");
        universalLoaderCallbacks.setBackgroundDataProcessors(new BackgroundDataProcessor[] {
            obj
        });
        getLoaderManager().initLoader(0, null, universalLoaderCallbacks);
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        byte byte0 = 8;
        Object obj = themesProgressBar;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        obj = scrollThemeSelector;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((RecyclerView) (obj)).setVisibility(i);
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        Ln.w(exception);
        runnable = dialogManager.getDialogFragment(null, Integer.valueOf(0x7f080165));
        runnable.setCancelable(false);
        GrouponDialogFragment.show(getFragmentManager(), runnable, "http_error_dialog");
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (themeWebView != null)
        {
            themeWebViewPlaceholder.removeView(themeWebView);
        }
        super.onConfigurationChanged(configuration);
        setupWebView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030102);
        ButterKnife.bind(this);
        Dart.inject(this);
        setActionBarTitle(getString(0x7f08011e));
        selectorLayoutManager = new LinearLayoutManager(this, 0, false);
        scrollThemeSelector.setLayoutManager(selectorLayoutManager);
        if (bundle == null)
        {
            themeId = giftingRecord.themeId;
            categoryIndex = giftingRecord.themeCategoryIndex;
            subIndex = giftingRecord.themeSubIndex;
        } else
        {
            categoryIndex = bundle.getInt("categoryIndex");
            subIndex = bundle.getInt("subIndex");
            themeId = bundle.getString("themeId");
        }
        scrollThemeSelector.setAdapter(selectorAdapter);
        selectorAdapter.setListener(new OnClickThemeListener());
        scrollThemeSelector.addItemDecoration(new GenericRecyclerViewDivider(this, 0));
        configureSyncManagerAndLoader();
        setupWebView();
        submitButton.setOnClickListener(new SubmitButtonOnClickListener());
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "webview_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        if (universallistloadresultdata.getListData().size() > 0)
        {
            giftCategories = universallistloadresultdata.getListData();
            selectorAdapter.setList(giftCategories);
            selectorAdapter.notifyDataSetChanged();
            universallistloadresultdata = ((DerivedGiftCategory)giftCategories.get(categoryIndex)).themeList;
            if (universallistloadresultdata.size() > 0)
            {
                selectedTheme = (DerivedGiftTheme)universallistloadresultdata.get(subIndex);
                selectedTheme.selected = true;
            }
            if (firstTimeLoaded)
            {
                scrollThemeSelector.scrollToPosition(categoryIndex);
                firstTimeLoaded = false;
            }
        }
    }

    protected void onPause()
    {
        super.onPause();
        universalSyncManager.stopAutomaticSyncs();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        themeWebView.restoreState(bundle);
    }

    protected void onResume()
    {
        super.onResume();
        loggingUtils.logPageView("", "gift_theme_selection", null);
        universalSyncManager.startAutomaticSyncs(this, null);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("categoryIndex", categoryIndex);
        bundle.putInt("subIndex", subIndex);
        bundle.putString("themeId", themeId);
    }

    protected void setActionBarTitle(String s)
    {
        getSupportActionBar().setTitle(s);
    }




/*
    static DerivedGiftTheme access$202(GiftingThemeSelection giftingthemeselection, DerivedGiftTheme derivedgifttheme)
    {
        giftingthemeselection.selectedTheme = derivedgifttheme;
        return derivedgifttheme;
    }

*/



/*
    static int access$302(GiftingThemeSelection giftingthemeselection, int i)
    {
        giftingthemeselection.categoryIndex = i;
        return i;
    }

*/



/*
    static int access$402(GiftingThemeSelection giftingthemeselection, int i)
    {
        giftingthemeselection.subIndex = i;
        return i;
    }

*/



/*
    static String access$502(GiftingThemeSelection giftingthemeselection, String s)
    {
        giftingthemeselection.themeId = s;
        return s;
    }

*/




}
