// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import android.text.TextUtils;
import android.util.Base64;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            AmazonJwtSigner, HmacJwtSigner

public abstract class JwtSigner
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/JwtSigner.getName();

    public JwtSigner()
    {
    }

    static String encodeAsBase64(JSONObject jsonobject)
    {
        try
        {
            jsonobject = Base64.encodeToString(jsonobject.toString().getBytes("UTF-8"), 11);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            throw new RuntimeException(jsonobject);
        }
        return jsonobject;
    }

    public static JwtSigner getSigner(PlatformSettings platformsettings, SSODeviceInfo ssodeviceinfo, Tracer tracer)
    {
        String s = platformsettings.getSettingString("jwt_impl", "tz");
        platformsettings = TAG;
        (new StringBuilder("Found jwt_impl=")).append(s).toString();
        platformsettings = null;
        if ("tz".equals(s))
        {
            AmazonJwtSigner amazonjwtsigner = AmazonJwtSigner.getInstanceIfAvailable(tracer);
            platformsettings = amazonjwtsigner;
            if (amazonjwtsigner != null)
            {
                platformsettings = amazonjwtsigner;
                if (tracer != null)
                {
                    tracer.incrementCounter("JWT:TrustZone");
                    platformsettings = amazonjwtsigner;
                }
            }
        }
        PlatformSettings platformsettings1 = platformsettings;
        if (platformsettings == null)
        {
            platformsettings1 = platformsettings;
            if (!"off".equals(s))
            {
                ssodeviceinfo = ssodeviceinfo.getDeviceSecret();
                platformsettings1 = platformsettings;
                if (!TextUtils.isEmpty(ssodeviceinfo))
                {
                    platformsettings = new HmacJwtSigner(ssodeviceinfo);
                    platformsettings1 = platformsettings;
                    if (tracer != null)
                    {
                        tracer.incrementCounter("JWT:HMAC");
                        platformsettings1 = platformsettings;
                    }
                }
            }
        }
        return platformsettings1;
    }

    abstract void addHeaderFields(JSONObject jsonobject)
        throws JSONException;

    abstract void printJwt(String s);

    abstract byte[] sign(byte abyte0[]);

    public final String signJwt(String s, JSONObject jsonobject)
    {
        JSONObject jsonobject1 = new JSONObject();
        try
        {
            jsonobject1.put("typ", s);
            addHeaderFields(jsonobject1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        s = (new StringBuilder()).append(encodeAsBase64(jsonobject1)).append(".").append(encodeAsBase64(jsonobject)).toString();
        try
        {
            jsonobject = sign(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        s = (new StringBuilder()).append(s).append(".").append(Base64.encodeToString(jsonobject, 11)).toString();
        printJwt(s);
        return s;
    }

}
