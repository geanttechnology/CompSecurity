// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.lib.riskcomponent;

import android.text.TextUtils;
import com.paypal.android.lib.riskcomponent.utils.PPRiskCDS;
import com.paypal.android.lib.riskcomponent.utils.Util;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Configuration
{

    private final JSONObject mConfig;

    public Configuration(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            throw new IllegalArgumentException("config cannot be null");
        } else
        {
            mConfig = jsonobject;
            return;
        }
    }

    public List getAppsToCheck()
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        JSONArray jsonarray = mConfig.optJSONArray("android_apps_to_check");
        for (int i = 0; jsonarray != null && i < jsonarray.length(); i++)
        {
            arraylist.add(jsonarray.getString(i));
        }

        return arraylist;
    }

    public PPRiskCDS getCDS()
    {
        Object obj;
        try
        {
            obj = mConfig.optString("CDS", "");
            if (TextUtils.isEmpty(((CharSequence) (obj))))
            {
                Util.logExternal(3, "PRD", "No CDS is configured, enabling all variables");
                return PPRiskCDS.DEFAULT_BITMAP;
            }
            Util.logExternal(3, "PRD", "CDS field was found");
            obj = new PPRiskCDS(((String) (obj)).trim());
        }
        catch (Exception exception)
        {
            Util.logExternal(6, "PRD", "Failed to decode CDS", exception);
            return PPRiskCDS.DEFAULT_BITMAP;
        }
        return ((PPRiskCDS) (obj));
    }

    public long getConfRefreshTimeInterval()
    {
        return mConfig.optLong("conf_refresh_time_interval", 0L);
    }

    public String getConfVersion()
    {
        return mConfig.optString("conf_version", "");
    }

    public String getEndpointUrl()
    {
        return mConfig.optString("endpoint_url", null);
    }
}
