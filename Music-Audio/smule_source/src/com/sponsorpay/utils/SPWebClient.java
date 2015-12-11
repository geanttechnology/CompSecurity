// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.webkit.CookieSyncManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sponsorpay.publisher.SponsorPayPublisher;
import java.lang.ref.WeakReference;

// Referenced classes of package com.sponsorpay.utils:
//            IntentHelper, SponsorPayLogger

public abstract class SPWebClient extends WebViewClient
{

    private static final String EXIT_URL_RESULT_CODE_PARAM_KEY = "status";
    private static final String EXIT_URL_TARGET_URL_PARAM_KEY = "url";
    public static final String LOG_TAG = "SPWebClient";
    public static final int RESULT_CODE_NO_STATUS_CODE = -10;
    private static final String SPONSORPAY_EXIT_SCHEMA = "exit";
    private static final String SPONSORPAY_SCHEMA = "sponsorpay://";
    private WeakReference mHostActivityRef;

    public SPWebClient(Activity activity)
    {
        mHostActivityRef = new WeakReference(activity);
    }

    protected Activity getHostActivity()
    {
        return (Activity)mHostActivityRef.get();
    }

    protected boolean launchActivityWithUrl(String s)
    {
        Activity activity;
        activity = getHostActivity();
        break MISSING_BLOCK_LABEL_5;
_L2:
        Uri uri;
        Intent intent;
        do
        {
            return false;
        } while (activity == null || s == null);
        intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        uri = Uri.parse(s);
        intent.setData(uri);
        activity.startActivity(intent);
        onTargetActivityStart(s);
        return true;
        s;
        if (uri.getScheme().equalsIgnoreCase("market") && !IntentHelper.isIntentAvailable(getHostActivity(), "android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.google")))
        {
            SponsorPayLogger.e("SPWebClient", "Play Store is not installed on this device...");
            onPlayStoreNotFound();
            return false;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void onPlayStoreNotFound()
    {
        showDialog(SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.ERROR_PLAY_STORE_UNAVAILABLE));
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (sslerror.getCertificate().getIssuedBy().getOName().matches(".*StartCom Ltd.*"))
        {
            sslerrorhandler.proceed();
        }
    }

    protected abstract void onSponsorPayExitScheme(int i, String s);

    protected abstract void onTargetActivityStart(String s);

    protected int parseSponsorPayExitUrlForResultCode(String s)
    {
        s = Uri.parse(s).getQueryParameter("status");
        if (s != null)
        {
            return Integer.parseInt(s);
        } else
        {
            return -10;
        }
    }

    protected String parseSponsorPayExitUrlForTargetUrl(String s)
    {
        return Uri.parse(s).getQueryParameter("url");
    }

    protected abstract void processSponsorPayScheme(String s, Uri uri);

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        SponsorPayLogger.i("SPWebClient", (new StringBuilder("shouldOverrideUrlLoading called with url: ")).append(s).toString());
        if (s.startsWith("sponsorpay://"))
        {
            webview = Uri.parse(s);
            String s1 = webview.getHost();
            if (s1.equals("exit"))
            {
                CookieSyncManager.getInstance().sync();
                int i = parseSponsorPayExitUrlForResultCode(s);
                webview = parseSponsorPayExitUrlForTargetUrl(s);
                SponsorPayLogger.i("SPWebClient", (new StringBuilder("Overriding. Target Url: ")).append(webview).toString());
                onSponsorPayExitScheme(i, webview);
            } else
            {
                processSponsorPayScheme(s1, webview);
            }
            return true;
        } else
        {
            SponsorPayLogger.i("SPWebClient", "Not overriding");
            return false;
        }
    }

    public void showDialog(String s)
    {
        Object obj = SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.ERROR_DIALOG_TITLE);
        String s1 = SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.DISMISS_ERROR_DIALOG);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getHostActivity());
        builder.setTitle(((CharSequence) (obj)));
        builder.setMessage(s);
        builder.setNegativeButton(s1, new android.content.DialogInterface.OnClickListener() {

            final SPWebClient this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                if (getHostActivity() != null)
                {
                    getHostActivity().finish();
                }
            }

            
            {
                this$0 = SPWebClient.this;
                super();
            }
        });
        obj = builder.create();
        ((AlertDialog) (obj)).setOwnerActivity(getHostActivity());
        try
        {
            ((AlertDialog) (obj)).show();
            return;
        }
        catch (android.view.WindowManager.BadTokenException badtokenexception)
        {
            SponsorPayLogger.e(getClass().getSimpleName(), (new StringBuilder("Couldn't show error dialog. Not displayed error message is: ")).append(s).toString(), badtokenexception);
        }
    }
}
