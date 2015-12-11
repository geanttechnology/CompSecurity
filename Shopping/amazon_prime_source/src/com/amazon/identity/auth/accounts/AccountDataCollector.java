// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.kcpsdk.auth.CredentialMapSerializer;
import java.util.Map;
import org.json.JSONArray;

public class AccountDataCollector
{

    private Bundle mUserData;

    public AccountDataCollector()
    {
        mUserData = new Bundle();
    }

    public Bundle getCurrentUserData()
    {
        return (Bundle)mUserData.clone();
    }

    public Bundle getUserDataNecessaryForAccountCreation()
    {
        throwIfNotValid();
        return getCurrentUserData();
    }

    public void setAccessToken(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.oauth.amazon.access_token", s);
    }

    public void setAccessTokenExpiresIn(int i)
    {
        mUserData.putString("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at", Integer.toString(i));
    }

    public void setAccountPool(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.device.accountpool", s);
    }

    public void setAdpToken(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.device.adptoken", s);
    }

    public void setCookies(JSONArray jsonarray)
    {
        mUserData.putString("website_cookies_json_array", jsonarray.toString());
    }

    public void setCor(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.account.cor", s);
    }

    public void setCredentialsMap(Map map)
    {
        map = CredentialMapSerializer.toJSONString(map);
        if (map != null)
        {
            mUserData.putString("com.amazon.dcp.sso.token.device.credentialsmap", map);
        }
    }

    public void setCustomerRegion(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.account.customer_region", s);
    }

    public void setDeviceEmail(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.deviceemail", s);
    }

    public void setDeviceName(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.devicename", s);
    }

    public void setDeviceSerialNumber(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.device.deviceserialname", s);
    }

    public void setDeviceType(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.devicedevicetype", s);
    }

    public void setDirectedId(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.account.acctId", s);
    }

    public void setEmail(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.account.useremail", s);
    }

    public void setPfm(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.account.pfm", s);
    }

    public void setPrivateKey(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.device.privatekey", s);
    }

    public void setRefreshToken(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.oauth.amazon.refresh_token", s);
    }

    public void setSourceOfCor(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.account.sourceofcor", s);
    }

    public void setUserName(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.property.username", s);
    }

    public void setXMainAndXAcbCookies(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies", s);
    }

    public void setXMainToken(String s)
    {
        mUserData.putString("com.amazon.dcp.sso.token.cookie.xmain", s);
    }

    public void setXfsnCookie(String s)
    {
        mUserData.putString("com.amazon.identity.cookies.xfsn", s);
    }

    public void throwIfNotValid()
    {
        if (!mUserData.containsKey("com.amazon.dcp.sso.property.username"))
        {
            throw new IllegalArgumentException("UserData is invalid because User Name has not been set");
        }
        if (!mUserData.containsKey("com.amazon.dcp.sso.property.devicename"))
        {
            throw new IllegalArgumentException("UserData is invalid because Device Name has not been set");
        }
        if (!mUserData.containsKey("com.amazon.dcp.sso.token.device.adptoken"))
        {
            throw new IllegalArgumentException("UserData is invalid because ADP Token has not been set");
        }
        if (!mUserData.containsKey("com.amazon.dcp.sso.token.device.privatekey"))
        {
            throw new IllegalArgumentException("UserData is invalid because private key has not been set");
        }
        if (!mUserData.containsKey("com.amazon.dcp.sso.token.device.deviceserialname"))
        {
            throw new IllegalArgumentException("UserData is invalid because the serial number has not been set");
        }
        if (!mUserData.containsKey("com.amazon.dcp.sso.token.devicedevicetype"))
        {
            throw new IllegalArgumentException("UserData is invalid because the device type has not been set");
        } else
        {
            return;
        }
    }
}
