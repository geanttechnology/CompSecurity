// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import android.app.Activity;
import android.content.res.Resources;
import com.amazon.mobile.mash.api.MASHCordovaPlugin;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.ChromeStyle;
import com.amazon.now.media.FullScreenGalleryActivity;
import com.amazon.now.restaurants.RestaurantsActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MASHImageGalleryPlugin extends MASHCordovaPlugin
{

    public static final String SERVICE_NAME = "MASHImageGallery";

    public MASHImageGalleryPlugin()
    {
    }

    private void showImageGallery(JSONObject jsonobject, CallbackContext callbackcontext)
    {
        final int startIndex = jsonobject.optInt("startIndex", 0);
        jsonobject = jsonobject.optJSONArray("imageUrls");
        if (jsonobject == null)
        {
            callbackcontext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        }
        final String imageArray[] = new String[jsonobject.length()];
        for (int i = 0; i < jsonobject.length(); i++)
        {
            imageArray[i] = jsonobject.optString(i);
        }

        runOnUiThread(new Runnable() {

            final MASHImageGalleryPlugin this$0;
            final String val$imageArray[];
            final int val$startIndex;

            public void run()
            {
                ChromeStyle chromestyle = null;
                if (cordova.getActivity() instanceof RestaurantsActivity)
                {
                    int j = cordova.getActivity().getResources().getColor(0x7f0d0025);
                    chromestyle = new ChromeStyle(com.amazon.now.ChromeStyle.ChromeLayout.NORMAL, j, true);
                }
                FullScreenGalleryActivity.startFullScreenGalleryActivity(cordova.getActivity(), imageArray, startIndex, chromestyle);
            }

            
            {
                this$0 = MASHImageGalleryPlugin.this;
                imageArray = as;
                startIndex = i;
                super();
            }
        });
        callbackcontext.success();
    }

    public boolean execute(String s, String s1, CallbackContext callbackcontext)
        throws JSONException
    {
        if ("ShowImageGallery".equalsIgnoreCase(s))
        {
            showImageGallery(new JSONObject(s1), callbackcontext);
            return true;
        } else
        {
            return false;
        }
    }
}
