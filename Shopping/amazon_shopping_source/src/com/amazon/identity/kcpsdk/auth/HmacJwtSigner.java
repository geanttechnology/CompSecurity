// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            JwtSigner

final class HmacJwtSigner extends JwtSigner
{

    private final SecretKeySpec mKeySpec;

    HmacJwtSigner(String s)
    {
        try
        {
            mKeySpec = new SecretKeySpec(s.getBytes("UTF-8"), "HmacSHA256");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    void addHeaderFields(JSONObject jsonobject)
        throws JSONException
    {
        jsonobject.put("alg", "HS256");
    }

    byte[] sign(byte abyte0[])
    {
        try
        {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(mKeySpec);
            abyte0 = mac.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new UnsupportedOperationException(abyte0);
        }
        return abyte0;
    }
}
