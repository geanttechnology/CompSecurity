// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import com.amazon.mobile.mash.api.MASHCorePlugin;
import com.amazon.mobile.mash.util.Util;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHHoudiniCorePlugin extends MASHCorePlugin
{

    public MASHHoudiniCorePlugin()
    {
    }

    private void openInExternalBrowser(JSONObject jsonobject, CallbackContext callbackcontext)
        throws JSONException
    {
        runOnUiThread(new Runnable() {

            final MASHHoudiniCorePlugin this$0;
            final CallbackContext val$callback;
            final String val$url;

            public void run()
            {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                cordova.getActivity().startActivity(intent);
                callback.success();
            }

            
            {
                this$0 = MASHHoudiniCorePlugin.this;
                url = s;
                callback = callbackcontext;
                super();
            }
        });
    }

    private void showChooser(final JSONObject destructiveButtonTitle, final CallbackContext callback)
        throws JSONException
    {
        final String title = destructiveButtonTitle.optString("title");
        JSONArray jsonarray = destructiveButtonTitle.optJSONArray("buttonTitles");
        final String cancelButtonTitle = destructiveButtonTitle.optString("cancelButtonTitle");
        destructiveButtonTitle = destructiveButtonTitle.optString("destructiveButtonTitle");
        final int lenOfButtonTitles = jsonarray.length();
        final String buttonTitlesArray[] = new String[lenOfButtonTitles];
        for (int i = 0; i < lenOfButtonTitles; i++)
        {
            buttonTitlesArray[i] = Html.fromHtml(jsonarray.getString(i)).toString();
        }

        runOnUiThread(new Runnable() {

            final MASHHoudiniCorePlugin this$0;
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
            }

            
            {
                this$0 = MASHHoudiniCorePlugin.this;
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

    public boolean execute(String s, String s1, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowChooser".equalsIgnoreCase(s))
        {
            showChooser(new JSONObject(s1), callbackcontext);
            return true;
        }
        if ("OpenInExternalBrowser".equalsIgnoreCase(s))
        {
            openInExternalBrowser(new JSONObject(s1), callbackcontext);
            return true;
        } else
        {
            return super.execute(s, s1, callbackcontext);
        }
    }
}
