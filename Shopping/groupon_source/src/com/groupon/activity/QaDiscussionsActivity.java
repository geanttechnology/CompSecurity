// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.groupon.service.core.AbTestService;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.WebViewHelper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class QaDiscussionsActivity extends GrouponActivity
    implements GrouponDialogListener
{
    class PageHealthJavascriptInterface
    {

        final QaDiscussionsActivity this$0;

        public void isPageHealthy(boolean flag)
        {
            pageHealthChecked = true;
            if (!flag)
            {
                handleReceivedError();
            }
        }

        PageHealthJavascriptInterface()
        {
            this$0 = QaDiscussionsActivity.this;
            super();
        }
    }


    private static final String PAGE_VALIDATION_SCRIPT = "document.getElementById('questions-list') != undefined ? true : false";
    private static final String SCRIPT_METHOD = "isPageHealthy";
    private static final String SCRIPT_NAME = com/groupon/activity/QaDiscussionsActivity$PageHealthJavascriptInterface.getSimpleName();
    private String IPForQandA;
    private AbTestService abTestService;
    String dealId;
    private DialogManager dialogManager;
    ProgressBar loading;
    private boolean pageHealthChecked;
    WebView qaDiscussionsView;
    private boolean useLocalForQuestions;
    private boolean useUATForQuestions;

    public QaDiscussionsActivity()
    {
        pageHealthChecked = false;
    }

    private String getDiscussionsPageUrl(String s)
    {
        String s1 = "www.groupon.com";
        if (!useUATForQuestions) goto _L2; else goto _L1
_L1:
        s1 = "uat.groupondev.com";
_L4:
        if (Strings.notEmpty(IPForQandA))
        {
            s1 = IPForQandA;
        }
        return String.format("https://%s/deals/%s/questions?native_client=android", new Object[] {
            s1, s
        });
_L2:
        if (useLocalForQuestions)
        {
            s1 = "www.groupon-local.com:3000";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void handleReceivedError()
    {
        qaDiscussionsView.loadUrl("about:blank");
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f080165)), "http_error_dialog");
    }

    private void setupAbTests()
    {
        useUATForQuestions = abTestService.isVariantEnabled("useUATForQuestions", "on");
        useLocalForQuestions = abTestService.isVariantEnabled("useLocalForQuestions", "on");
        IPForQandA = abTestService.getVariant("IPForQuestions");
    }

    private void setupViews()
    {
        WebViewClient webviewclient = new WebViewClient() {

            final QaDiscussionsActivity this$0;

            public void onPageFinished(WebView webview, String s)
            {
                loading.setVisibility(8);
                super.onPageFinished(webview, s);
                if (!pageHealthChecked)
                {
                    qaDiscussionsView.loadUrl((new StringBuilder()).append("javascript:window.").append(QaDiscussionsActivity.SCRIPT_NAME).append(".").append("isPageHealthy").append("(").append("document.getElementById('questions-list') != undefined ? true : false").append(");").toString());
                }
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                loading.setVisibility(0);
                super.onPageStarted(webview, s, bitmap);
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                loading.setVisibility(8);
                handleReceivedError();
            }

            
            {
                this$0 = QaDiscussionsActivity.this;
                super();
            }
        };
        qaDiscussionsView.addJavascriptInterface(new PageHealthJavascriptInterface(), SCRIPT_NAME);
        qaDiscussionsView.setWebViewClient(webviewclient);
        qaDiscussionsView.getSettings().setJavaScriptEnabled(true);
        WebViewHelper.addInAppUserAgent(qaDiscussionsView);
        qaDiscussionsView.loadUrl(getDiscussionsPageUrl(dealId));
        pageHealthChecked = false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301b8);
        setupAbTests();
        setupViews();
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
        if (Strings.equals(s, "http_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "http_error_dialog"))
        {
            qaDiscussionsView.loadUrl(getDiscussionsPageUrl(dealId));
            pageHealthChecked = false;
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }




/*
    static boolean access$002(QaDiscussionsActivity qadiscussionsactivity, boolean flag)
    {
        qadiscussionsactivity.pageHealthChecked = flag;
        return flag;
    }

*/


}
