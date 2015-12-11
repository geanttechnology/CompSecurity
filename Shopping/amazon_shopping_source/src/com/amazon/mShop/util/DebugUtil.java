// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.feature.FeatureStateSubscriber;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.net.CookieBridge;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.mShop.util:
//            Util, UIUtils

public class DebugUtil
{
    public static class Log
    {

        public static void d(String s, String s1, Throwable throwable)
        {
            if (DebugSettings.isDebugEnabled())
            {
                android.util.Log.d(s, s1, throwable);
            }
        }

        public static void e(String s, String s1, Throwable throwable)
        {
            if (DebugSettings.isDebugEnabled())
            {
                android.util.Log.e(s, s1, throwable);
            }
        }

        public static void i(String s, String s1)
        {
            i(s, s1, null);
        }

        public static void i(String s, String s1, Throwable throwable)
        {
            if (DebugSettings.isDebugEnabled())
            {
                android.util.Log.i(s, s1, throwable);
            }
        }

        public Log()
        {
        }
    }


    public DebugUtil()
    {
    }

    public static String getWeblabCookie(Context context)
    {
        CookieSyncManager.getInstance().sync();
        context = CookieBridge.getMShopURL(context, false);
        context = CookieManager.getInstance().getCookie(context);
        int i = context.indexOf("experiment");
        if (i != -1)
        {
            int k = context.indexOf("=", i);
            int j = context.indexOf(";", i);
            i = j;
            if (j < 0)
            {
                i = context.length();
            }
            context = context.substring(k + 1, i);
            if (!Util.isEmpty(context))
            {
                return context.trim().replace("\"", "");
            }
        }
        return "";
    }

    public static void handleOnReceivedHTTPAuthenticationRequest(Activity activity, WebView webview, HttpAuthHandler httpauthhandler, String s, String s1)
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = new com.amazon.mShop.AmazonAlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(com.amazon.mShop.android.lib.R.layout.debug_http_sign_in_dialog, null);
        builder.setTitle(activity.getString(com.amazon.mShop.android.lib.R.string.debug_http_auth_dialog_title, new Object[] {
            s
        })).setView(view).setPositiveButton(com.amazon.mShop.android.lib.R.string.ok, new android.content.DialogInterface.OnClickListener(view, webview, s, s1, httpauthhandler) {

            final View val$dialogView;
            final HttpAuthHandler val$handler;
            final String val$host;
            final String val$realm;
            final WebView val$view;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                String s2 = ((EditText)dialogView.findViewById(com.amazon.mShop.android.lib.R.id.http_username)).getText().toString().trim();
                String s3 = ((EditText)dialogView.findViewById(com.amazon.mShop.android.lib.R.id.http_password)).getText().toString().trim();
                if (!Util.isEmpty(s2) && !Util.isEmpty(s3))
                {
                    view.setHttpAuthUsernamePassword(host, realm, s2, s3);
                    handler.proceed(s2, s3);
                }
                dialoginterface.dismiss();
            }

            
            {
                dialogView = view1;
                view = webview;
                host = s;
                realm = s1;
                handler = httpauthhandler;
                super();
            }
        }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

        }).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(httpauthhandler) {

            final HttpAuthHandler val$handler;

            public void onCancel(DialogInterface dialoginterface)
            {
                handler.cancel();
            }

            
            {
                handler = httpauthhandler;
                super();
            }
        });
        builder.create().show();
    }

    public static void overrideWeblabAssignment(Context context)
    {
        com.amazon.mShop.AmazonAlertDialog.Builder builder = new com.amazon.mShop.AmazonAlertDialog.Builder(context);
        builder.setTitle(com.amazon.mShop.android.lib.R.string.menu_more_set_weblab);
        builder.setMessage(com.amazon.mShop.android.lib.R.string.set_web_lab_description);
        EditText edittext = new EditText(context);
        edittext.setInputType(4096);
        edittext.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, 200));
        builder.setView(edittext);
        edittext.setText(getWeblabCookie(context));
        builder.setPositiveButton(com.amazon.mShop.android.lib.R.string.ok, new android.content.DialogInterface.OnClickListener(edittext, context) {

            final Context val$context;
            final EditText val$edit;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = edit.getText().toString();
                boolean flag = Pattern.compile((new StringBuilder()).append("[A-Z_0-9]+:[CT][0-9]*").append("(&").append("[A-Z_0-9]+:[CT][0-9]*").append(")*").toString()).matcher(dialoginterface).find();
                if (!Util.isEmpty(dialoginterface) && !flag)
                {
                    Toast.makeText(context, com.amazon.mShop.android.lib.R.string.set_web_lab_invalid, 1).show();
                    return;
                } else
                {
                    CookieBridge.setCookie(context, false, "experiment", (new StringBuilder()).append("\"").append(dialoginterface).append("\"").toString());
                    CookieBridge.setCookie(context, false, "session-id", "");
                    CookieBridge.setCookie(context, false, "ubid-main", "");
                    DebugUtil.requestNewWeblabAssignment(context);
                    return;
                }
            }

            
            {
                edit = edittext;
                context = context1;
                super();
            }
        });
        builder.create().show();
    }

    private static void requestNewWeblabAssignment(Context context)
    {
        AmazonAlertDialog amazonalertdialog = (new com.amazon.mShop.AmazonAlertDialog.Builder(context)).create();
        amazonalertdialog.setMessage("Request Weblab Assignment...");
        WebViewClient webviewclient = new WebViewClient(new FeatureStateSubscriber(amazonalertdialog, context) {

            final Context val$context;
            final AmazonAlertDialog val$dialog;

            public void onCancel()
            {
                dialog.dismiss();
                Features.getInstance().removeFeatureStateSubscriber(this);
                UIUtils.info(context, "onCancel");
            }

            public void onError(Exception exception)
            {
                dialog.dismiss();
                Features.getInstance().removeFeatureStateSubscriber(this);
                UIUtils.info(context, (new StringBuilder()).append("Error ").append(exception.getMessage()).toString());
            }

            public void onFeatureStateReceived(List list)
            {
                dialog.dismiss();
                Features.getInstance().removeFeatureStateSubscriber(this);
                UIUtils.info(context, "OK: Weblab Assignment Done!");
            }

            
            {
                dialog = amazonalertdialog;
                context = context1;
                super();
            }
        }) {

            final FeatureStateSubscriber val$subscriber;

            public void onPageFinished(WebView webview1, String s)
            {
                Features.getInstance().addFeatureStateSubscriber(subscriber);
                Features.getInstance().fetchFeatureStates(true);
            }

            
            {
                subscriber = featurestatesubscriber;
                super();
            }
        };
        WebView webview = new WebView(context);
        webview.setWebViewClient(webviewclient);
        webview.loadUrl(context.getString(com.amazon.mShop.android.lib.R.string.wishlist_web_page_url));
        amazonalertdialog.show();
    }

}
