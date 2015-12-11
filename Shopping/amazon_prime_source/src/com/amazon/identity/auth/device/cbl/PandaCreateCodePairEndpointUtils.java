// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import android.os.Build;
import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class PandaCreateCodePairEndpointUtils
{
    public static class CreateCodePairSuccessResult
    {

        public long mExpiresAt;
        public long mExpiresIn;
        public String mPrivateCode;
        public String mPublicCode;

        CreateCodePairSuccessResult(String s, String s1, String s2)
        {
            mPublicCode = s;
            mPrivateCode = s1;
            mExpiresIn = Long.parseLong(s2) * 1000L;
            mExpiresAt = System.currentTimeMillis() + mExpiresIn;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/cbl/PandaCreateCodePairEndpointUtils.getSimpleName();
    private ServiceWrappingContext mContext;
    private SSODeviceInfo mDeviceInfo;
    private Tracer mTracer;

    public PandaCreateCodePairEndpointUtils(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        mContext = servicewrappingcontext;
        mTracer = tracer;
        mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
    }

    public void addCodeProperties(JSONObject jsonobject, int i, long l)
        throws JSONException
    {
        JSONObject jsonobject1 = new JSONObject();
        if (i > 0)
        {
            jsonobject1.put("code_length", Integer.toString(i));
        }
        if (l > 0L)
        {
            jsonobject1.put("code_duration", Long.toString(l / 1000L));
        }
        if (jsonobject1.length() > 0)
        {
            jsonobject.put("code_properties", jsonobject1);
        }
    }

    public JSONObject getCodeDataJSON()
        throws JSONException
    {
        String s1 = mContext.getPackageName();
        Object obj = PackageUtils.getPackageVersion(mContext, s1);
        String s = "defaultAppVersion";
        if (obj != null)
        {
            s = Integer.toString(((Integer) (obj)).intValue());
        }
        JSONObject jsonobject;
        try
        {
            obj = mDeviceInfo.getDeviceSerialNumber();
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            MAPLog.e(TAG, "Got an unsupported operation exception while trying to get the device serial number", unsupportedoperationexception);
            return null;
        }
        jsonobject = new JSONObject();
        jsonobject.put("domain", "Device");
        if (TextUtils.isEmpty(s1))
        {
            s1 = "defaultAppName";
        }
        jsonobject.put("app_name", s1);
        jsonobject.put("app_version", s);
        jsonobject.put("device_model", Build.MODEL);
        jsonobject.put("os_version", Integer.toString(android.os.Build.VERSION.SDK_INT));
        jsonobject.put("device_type", mDeviceInfo.getDeviceType());
        jsonobject.put("device_serial", obj);
        return jsonobject;
    }

    public String getRequestJSON(int i, long l)
        throws JSONException
    {
        JSONObject jsonobject = getCodeDataJSON();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("code_data", jsonobject);
        addCodeProperties(jsonobject1, i, l);
        DeviceMetadataCollector.applyFraudMetadataIntoReqeustJSON(DeviceMetadataCollector.getFraudMetadata(mContext, mDeviceInfo.getDeviceSerialNumber(), mTracer), jsonobject1);
        return jsonobject1.toString();
    }

    public CreateCodePairSuccessResult parseSuccessResponse(JSONObject jsonobject)
    {
        try
        {
            jsonobject = new CreateCodePairSuccessResult(jsonobject.getString("public_code"), jsonobject.getString("private_code"), jsonobject.getString("expires_in"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            MAPLog.e(TAG, "JSONException while parsing createCodePair response", jsonobject);
            return null;
        }
        return jsonobject;
    }

}
