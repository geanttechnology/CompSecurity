// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemDataManager, ViewItemViewData, ItemViewCommonProgressAndError

public class ItemViewDescriptionActivity extends ItemViewBaseActivity
{
    public static final class What extends Enum
    {

        private static final What $VALUES[];
        public static final What DESCRIPTION;
        public static final What PRODUCT_DETAILS;

        public static What valueOf(String s)
        {
            return (What)Enum.valueOf(com/ebay/mobile/viewitem/ItemViewDescriptionActivity$What, s);
        }

        public static What[] values()
        {
            return (What[])$VALUES.clone();
        }

        static 
        {
            PRODUCT_DETAILS = new What("PRODUCT_DETAILS", 0);
            DESCRIPTION = new What("DESCRIPTION", 1);
            $VALUES = (new What[] {
                PRODUCT_DETAILS, DESCRIPTION
            });
        }

        private What(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String PARAM_WHAT = "what";
    private long itemId;
    private ViewItemDataManager viewItemDataManager;
    private int what;

    public ItemViewDescriptionActivity()
    {
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, What what1)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewDescriptionActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        intent.putExtra("what", what1.ordinal());
        activity.startActivity(intent);
    }

    private boolean callAPI()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (viewItemDataManager != null)
        {
            flag = flag1;
            if (what == What.PRODUCT_DETAILS.ordinal())
            {
                viewItemDataManager.getProductInfo(EbayApiUtil.getShoppingApi(this), itemId, item.productId, true);
                flag = true;
            }
        }
        return flag;
    }

    private void render()
    {
        WebView webview = (WebView)findViewById(0x7f100316);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<html>");
        stringbuilder.append("<head>");
        stringbuilder.append("<meta name=\"viewport\" content=\"width=device-width");
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            stringbuilder.append(", initial-scale=.25");
        }
        stringbuilder.append("\"/></head>");
        stringbuilder.append("<body>");
        if (!TextUtils.isEmpty(item.productDescription) && what == What.PRODUCT_DETAILS.ordinal())
        {
            stringbuilder.append(item.productDescription);
        }
        if (!TextUtils.isEmpty(item.description) && what == What.DESCRIPTION.ordinal())
        {
            stringbuilder.append(item.description);
        }
        stringbuilder.append("</body>");
        stringbuilder.append("</html>");
        webview.loadDataWithBaseURL(null, stringbuilder.toString(), "text/html", "utf-8", null);
    }

    protected void createUI()
    {
        Object obj = getSharedPreferences("WebViewSettings", 0);
        if (((SharedPreferences) (obj)).getInt("double_tap_toast_count", 1) > 0)
        {
            ((SharedPreferences) (obj)).edit().putInt("double_tap_toast_count", 0).commit();
        }
        obj = (WebView)findViewById(0x7f100316);
        WebSettings websettings = ((WebView) (obj)).getSettings();
        websettings.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        websettings.setLoadsImagesAutomatically(true);
        websettings.setJavaScriptEnabled(true);
        websettings.setJavaScriptCanOpenWindowsAutomatically(false);
        websettings.setSupportZoom(true);
        websettings.setBuiltInZoomControls(true);
        websettings.setDisplayZoomControls(false);
        websettings.setLoadWithOverviewMode(true);
        websettings.setUseWideViewPort(true);
        ((WebView) (obj)).setFocusable(true);
        ((WebView) (obj)).setWebChromeClient(new WebChromeClient() {

            final ItemViewDescriptionActivity this$0;

            public void onProgressChanged(WebView webview, int i)
            {
                if (99 < i)
                {
                    ItemViewCommonProgressAndError.showLayouts(ItemViewDescriptionActivity.this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
                }
            }

            
            {
                this$0 = ItemViewDescriptionActivity.this;
                super();
            }
        });
        ((WebView) (obj)).setWebViewClient(new WebViewClient() {

            final ItemViewDescriptionActivity this$0;

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                Toast.makeText(ItemViewDescriptionActivity.this, s, 0).show();
                ItemViewCommonProgressAndError.showLayouts(ItemViewDescriptionActivity.this, ItemViewCommonProgressAndError.LayoutState.SERVICE_ERROR);
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s.startsWith("http://pages.ebay.com/link/?nav="))
                {
                    webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
                    startActivity(webview);
                    return true;
                } else
                {
                    return super.shouldOverrideUrlLoading(webview, s);
                }
            }

            
            {
                this$0 = ItemViewDescriptionActivity.this;
                super();
            }
        });
    }

    public String getTrackingEventName()
    {
        return "ViewItemDescription";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        what = getIntent().getIntExtra("what", 0);
        int i;
        if (what == What.DESCRIPTION.ordinal())
        {
            i = 0x7f07048d;
        } else
        {
            i = 0x7f070b65;
        }
        setTitle(getString(i));
        setContentView(0x7f030139);
        ((Button)findViewById(0x7f10013f)).setOnClickListener(new android.view.View.OnClickListener() {

            final ItemViewDescriptionActivity this$0;

            public void onClick(View view)
            {
                callAPI();
            }

            
            {
                this$0 = ItemViewDescriptionActivity.this;
                super();
            }
        });
        viewData = (ViewItemViewData)getIntent().getParcelableExtra("view_item_view_data");
        itemId = viewData.keyParams.itemId;
        initDataManagers();
        createUI();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.PROGRESS);
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (content.getStatus().hasError())
        {
            break; /* Loop/switch isn't completed */
        }
        static class _cls4
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.PRODUCT_INFO.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.ITEM_DESCRIPTION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls4..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (what == What.DESCRIPTION.ordinal())
            {
                render();
                return;
            }
            if (what == What.PRODUCT_DETAILS.ordinal() && !TextUtils.isEmpty(item.productDescription))
            {
                render();
                return;
            }
            if (!callAPI())
            {
                render();
                return;
            }
            break;

        case 2: // '\002'
        case 3: // '\003'
            render();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
        return;
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (!flag)
        {
            finish();
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

}
