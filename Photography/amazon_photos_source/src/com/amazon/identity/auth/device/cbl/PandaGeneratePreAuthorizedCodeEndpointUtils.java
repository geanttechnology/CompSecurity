// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.utils.MAPLog;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            PandaCreateCodePairEndpointUtils

public class PandaGeneratePreAuthorizedCodeEndpointUtils
{

    private static final String TAG = com/amazon/identity/auth/device/cbl/PandaGeneratePreAuthorizedCodeEndpointUtils.getSimpleName();
    private ServiceWrappingContext mContext;
    private SSODeviceInfo mDeviceInfo;
    private Tracer mTracer;

    public PandaGeneratePreAuthorizedCodeEndpointUtils(ServiceWrappingContext servicewrappingcontext, Tracer tracer)
    {
        mContext = servicewrappingcontext;
        mTracer = tracer;
        mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
    }

    public String getRequestJSON(long l, String s)
        throws JSONException
    {
        PandaCreateCodePairEndpointUtils pandacreatecodepairendpointutils = new PandaCreateCodePairEndpointUtils(mContext, mTracer);
        JSONObject jsonobject = pandacreatecodepairendpointutils.getCodeDataJSON();
        JSONObject jsonobject1 = new JSONObject();
        jsonobject1.put("access_token", s);
        s = new JSONObject();
        s.put("code_data", jsonobject);
        s.put("auth_data", jsonobject1);
        pandacreatecodepairendpointutils.addCodeProperties(s, 0, l);
        DeviceMetadataCollector.applyFraudMetadataIntoReqeustJSON(DeviceMetadataCollector.getFraudMetadata(mContext, mDeviceInfo.getDeviceSerialNumber(), mTracer), s);
        return s.toString();
    }

    public PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult parseSuccessResponse(JSONObject jsonobject)
    {
        try
        {
            jsonobject = new PandaCreateCodePairEndpointUtils.CreateCodePairSuccessResult(null, jsonobject.getString("code"), jsonobject.getString("expires_in"));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            MAPLog.e(TAG, "JSONException while parsing generatePreAuthorizedCode response", jsonobject);
            return null;
        }
        return jsonobject;
    }

}
