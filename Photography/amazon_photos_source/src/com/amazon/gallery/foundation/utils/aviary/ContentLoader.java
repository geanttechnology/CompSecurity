// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.aviary;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ContentLoader
{

    private static final String TAG = com/amazon/gallery/foundation/utils/aviary/ContentLoader.getName();
    private final CloudFrontConfig CLOUD_FRONT_CONFIG;
    private OkHttpClient mClient;
    private final Context mContext;

    public ContentLoader(Context context, CloudFrontConfig cloudfrontconfig)
    {
        mClient = new OkHttpClient();
        mContext = context;
        CLOUD_FRONT_CONFIG = cloudfrontconfig;
    }

    private JSONObject fetchFromCloud()
    {
        Object obj = (new com.squareup.okhttp.Request.Builder()).url(CLOUD_FRONT_CONFIG.getCloudFrontURI(getPath()).toString()).build();
        obj = mClient.newCall(((com.squareup.okhttp.Request) (obj))).execute();
        if (!((Response) (obj)).isSuccessful()) goto _L2; else goto _L1
_L1:
        obj = new JSONObject(((Response) (obj)).body().string());
        return ((JSONObject) (obj));
        Object obj1;
        obj1;
_L4:
        GLogger.ex(TAG, "Failed to fetch json file, falling back to default local version", ((Throwable) (obj1)));
_L2:
        return null;
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private JSONObject fetchFromDevice()
    {
        Object obj;
        Object obj1;
        java.io.InputStream inputstream;
        Object obj2;
        obj2 = mContext.getAssets();
        obj1 = null;
        inputstream = null;
        obj = null;
        obj2 = ((AssetManager) (obj2)).open(getJsonName());
        obj = obj2;
        obj1 = obj2;
        inputstream = ((java.io.InputStream) (obj2));
        JSONObject jsonobject = new JSONObject(IOUtils.toString(((java.io.InputStream) (obj2))));
        IOUtils.closeQuietly(((java.io.InputStream) (obj2)));
        return jsonobject;
        Object obj3;
        obj3;
_L2:
        obj1 = obj;
        GLogger.ex(TAG, "Encountered an error when reading json file", ((Throwable) (obj3)));
        IOUtils.closeQuietly(((java.io.InputStream) (obj)));
        return null;
        obj;
        IOUtils.closeQuietly(((java.io.InputStream) (obj1)));
        throw obj;
        obj3;
        obj = inputstream;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public JSONObject getContent()
    {
        JSONObject jsonobject1 = fetchFromCloud();
        JSONObject jsonobject = jsonobject1;
        if (jsonobject1 == null)
        {
            jsonobject = jsonobject1;
            if (mContext != null)
            {
                jsonobject = fetchFromDevice();
            }
        }
        return jsonobject;
    }

    public String getDisplayDescription()
    {
        return mContext.getString(getDisplayDescriptionResource());
    }

    protected abstract int getDisplayDescriptionResource();

    public String getDisplayName()
    {
        return mContext.getString(getDisplayNameResource());
    }

    protected abstract int getDisplayNameResource();

    protected abstract String getJsonName();

    public abstract String getPackIdentifier();

    protected abstract String getPath();

}
