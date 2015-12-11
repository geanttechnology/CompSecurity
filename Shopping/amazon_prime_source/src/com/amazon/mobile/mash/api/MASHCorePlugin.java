// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import com.amazon.mobile.mash.error.LaunchIntentURLError;
import com.amazon.mobile.mash.util.MASHDebug;
import com.amazon.mobile.mash.util.Util;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCordovaPlugin

public class MASHCorePlugin extends MASHCordovaPlugin
{

    public static final String SERVICE_NAME = "MASHCore";

    public MASHCorePlugin()
    {
    }

    private void canLaunchIntentURL(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        String s = jsonarray.getString(0);
        jsonarray = new Intent("android.intent.action.VIEW");
        jsonarray.setData(Uri.parse(s));
        if (webView.getContext().getPackageManager().queryIntentActivities(jsonarray, 0x10000).size() > 0)
        {
            jsonarray = "true";
        } else
        {
            jsonarray = "false";
        }
        callbackcontext.success(jsonarray);
        if (MASHDebug.isEnabled())
        {
            Log.i(TAG, (new StringBuilder()).append("CanLaunchIntentURL is executed successfully. url=").append(s).toString());
        }
    }

    private void launchIntentURL(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHCorePlugin this$0;
            final CallbackContext val$callback;
            final String val$url;

            public void run()
            {
                try
                {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(url));
                    cordova.getActivity().startActivity(intent);
                    callback.success();
                    if (MASHDebug.isEnabled())
                    {
                        Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("LaunchIntentURL is executed successfully. url=").append(url).toString());
                    }
                    return;
                }
                catch (ActivityNotFoundException activitynotfoundexception)
                {
                    Log.e(MASHCordovaPlugin.TAG, "", activitynotfoundexception);
                }
                callback.error(LaunchIntentURLError.INTENT_NOT_FOUND.toJSONObejct());
            }

            
            {
                this$0 = MASHCorePlugin.this;
                url = s;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void openInExternalBrowser(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHCorePlugin this$0;
            final CallbackContext val$callback;
            final String val$url;

            public void run()
            {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                cordova.getActivity().startActivity(intent);
                callback.success();
                if (MASHDebug.isEnabled())
                {
                    Log.i(MASHCordovaPlugin.TAG, (new StringBuilder()).append("OpenInExternalBrowser is executed successfully. url=").append(url).toString());
                }
            }

            
            {
                this$0 = MASHCorePlugin.this;
                url = s;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void showAlert(JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        final String title = jsonarray.getString(0);
        final String message = jsonarray.getString(1);
        JSONArray jsonarray1 = jsonarray.getJSONArray(2);
        jsonarray = jsonarray.getString(3);
        int i = jsonarray1.length();
        runOnUiThread(new Runnable() {

            final MASHCorePlugin this$0;
            final CallbackContext val$callback;
            final String val$cancelButtonTitle;
            final int val$lenOfButtonTitles;
            final String val$message;
            final String val$neutralButtonTitle;
            final String val$positiveButtonTitle;
            final String val$title;

            public void run()
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(cordova.getActivity());
                if (Util.isDefined(title))
                {
                    builder.setTitle(title);
                }
                if (Util.isDefined(message))
                {
                    builder.setMessage(message);
                }
                if (Util.isDefined(positiveButtonTitle))
                {
                    builder.setPositiveButton(positiveButtonTitle, new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            callback.success(0);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
                if (Util.isDefined(neutralButtonTitle))
                {
                    builder.setNeutralButton(neutralButtonTitle, new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            callback.success(1);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
                if (Util.isDefined(cancelButtonTitle))
                {
                    builder.setNegativeButton(cancelButtonTitle, new android.content.DialogInterface.OnClickListener() {

                        final _cls2 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            callback.success(lenOfButtonTitles);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
                builder.setIcon(0);
                builder.create().show();
                if (MASHDebug.isEnabled())
                {
                    Log.i(MASHCordovaPlugin.TAG, "ShowAlert is executed.");
                }
            }

            
            {
                this$0 = MASHCorePlugin.this;
                title = s;
                message = s1;
                positiveButtonTitle = s2;
                callback = callbackcontext;
                neutralButtonTitle = s3;
                cancelButtonTitle = s4;
                lenOfButtonTitles = i;
                super();
            }
        });
    }

    private void showChooser(final JSONArray destructiveButtonTitle, final CallbackContext callback)
        throws JSONException
    {
        final String title = destructiveButtonTitle.getString(0);
        JSONArray jsonarray = destructiveButtonTitle.getJSONArray(1);
        final String cancelButtonTitle = destructiveButtonTitle.getString(2);
        destructiveButtonTitle = destructiveButtonTitle.getString(3);
        final int lenOfButtonTitles = jsonarray.length();
        final String buttonTitlesArray[] = new String[lenOfButtonTitles];
        for (int i = 0; i < lenOfButtonTitles; i++)
        {
            buttonTitlesArray[i] = Html.fromHtml(jsonarray.getString(i)).toString();
        }

        runOnUiThread(new Runnable() {

            final MASHCorePlugin this$0;
            final String val$buttonTitlesArray[];
            final CallbackContext val$callback;
            final String val$cancelButtonTitle;
            final String val$destructiveButtonTitle;
            final int val$lenOfButtonTitles;
            final String val$title;

            public void run()
            {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(cordova.getActivity());
                if (Util.isDefined(title))
                {
                    builder.setTitle(title);
                }
                builder.setItems(buttonTitlesArray, new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        callback.success(i);
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                if (Util.isDefined(cancelButtonTitle))
                {
                    builder.setNegativeButton(cancelButtonTitle, new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            callback.success(lenOfButtonTitles);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
                if (Util.isDefined(destructiveButtonTitle))
                {
                    builder.setPositiveButton(destructiveButtonTitle, new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            callback.success(lenOfButtonTitles + 1);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
                builder.setIcon(0);
                builder.create().show();
                if (MASHDebug.isEnabled())
                {
                    Log.i(MASHCordovaPlugin.TAG, "ShowChooser is executed.");
                }
            }

            
            {
                this$0 = MASHCorePlugin.this;
                title = s;
                buttonTitlesArray = as;
                callback = callbackcontext;
                cancelButtonTitle = s1;
                lenOfButtonTitles = i;
                destructiveButtonTitle = s2;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowChooser".equals(s))
        {
            showChooser(jsonarray, callbackcontext);
        } else
        if ("ShowAlert".equals(s))
        {
            showAlert(jsonarray, callbackcontext);
        } else
        if ("OpenInExternalBrowser".equals(s))
        {
            openInExternalBrowser(jsonarray, callbackcontext);
        } else
        if ("LaunchIntentURL".equals(s))
        {
            launchIntentURL(jsonarray, callbackcontext);
        } else
        if ("CanLaunchIntentURL".equals(s))
        {
            canLaunchIntentURL(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }
}
