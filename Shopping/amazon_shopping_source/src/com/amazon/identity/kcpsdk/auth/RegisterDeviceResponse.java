// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            Cookie, AuthenticationChallenge, RegisterDeviceError

public class RegisterDeviceResponse
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/RegisterDeviceResponse.getName();
    private String mAccessToken;
    private int mAccessTokenExpiresIn;
    private String mAccountPool;
    private String mAdpToken;
    private AuthenticationChallenge mChallenge;
    private List mCookiesFromFIRS;
    private JSONArray mCookiesFromPanda;
    private String mCor;
    private Map mCredentialsReceived;
    private String mCustomerRegion;
    private String mDeviceEmail;
    private Map mDeviceInfo;
    private String mDeviceName;
    private String mDirectedId;
    private RegisterDeviceError mError;
    private String mPfm;
    private String mPrivateKey;
    private String mRefreshToken;
    private String mServerTime;
    private String mSourceOfCor;
    private String mStoreAuthenticationCookie;
    private String mUserName;

    public RegisterDeviceResponse(AuthenticationChallenge authenticationchallenge, RegisterDeviceError registerdeviceerror)
    {
        this(null, null, null, 0, null, null, null, null, null, null, authenticationchallenge, registerdeviceerror);
    }

    public RegisterDeviceResponse(String s)
    {
        mCookiesFromPanda = new JSONArray();
        mServerTime = s;
    }

    public RegisterDeviceResponse(String s, String s1, String s2, int i, String s3, String s4, RegisterDeviceError registerdeviceerror)
    {
        this(s, s1, s2, i, null, s3, null, null, s4, null, null, registerdeviceerror);
    }

    private RegisterDeviceResponse(String s, String s1, String s2, int i, String s3, String s4, String s5, 
            String s6, String s7, Map map, AuthenticationChallenge authenticationchallenge, RegisterDeviceError registerdeviceerror)
    {
        mCookiesFromPanda = new JSONArray();
        mAdpToken = s;
        mRefreshToken = s1;
        mAccessToken = s2;
        mAccessTokenExpiresIn = i;
        mDeviceName = s3;
        mPrivateKey = s4;
        mUserName = s5;
        mCookiesFromFIRS = new ArrayList();
        mCredentialsReceived = new HashMap();
        mDeviceEmail = s6;
        mDirectedId = s7;
        mDeviceInfo = map;
        mChallenge = authenticationchallenge;
        mError = registerdeviceerror;
    }

    public RegisterDeviceResponse(String s, String s1, String s2, int i, String s3, String s4, String s5, 
            String s6, String s7, Map map, RegisterDeviceError registerdeviceerror)
    {
        this(s, s1, s2, i, s3, s4, s5, s6, s7, map, null, registerdeviceerror);
    }

    public RegisterDeviceResponse(String s, String s1, String s2, String s3, String s4, RegisterDeviceError registerdeviceerror)
    {
        this(s, null, null, 0, s1, s2, s3, s4, null, null, registerdeviceerror);
    }

    public RegisterDeviceResponse(String s, String s1, String s2, String s3, String s4, Map map, RegisterDeviceError registerdeviceerror)
    {
        this(s, null, null, 0, s1, s2, s3, s4, null, map, null, registerdeviceerror);
    }

    public void addAllFIRSCookies(List list)
    {
        mCookiesFromFIRS.addAll(list);
    }

    public void addFIRSCookie(Cookie cookie)
    {
        mCookiesFromFIRS.add(cookie);
    }

    public String getAccessToken()
    {
        return mAccessToken;
    }

    public int getAccessTokenExpiresIn()
    {
        return mAccessTokenExpiresIn;
    }

    public String getAccountPool()
    {
        return mAccountPool;
    }

    public String getAdpToken()
    {
        return mAdpToken;
    }

    public AuthenticationChallenge getChallenge()
    {
        return mChallenge;
    }

    public Cookie getCookieRetrievedFromFIRS(long l)
    {
        if (l >= getNumCookiesRetrievedFromFIRS())
        {
            MAPLog.e(TAG, "RegisterDeviceResponse: getCookie: index out of range.");
            return null;
        } else
        {
            return (Cookie)mCookiesFromFIRS.get((int)l);
        }
    }

    public List getCookiesRetrievedFromFIRS()
    {
        return Collections.unmodifiableList(mCookiesFromFIRS);
    }

    public JSONArray getCookiesRetrievedFromPanda()
    {
        return mCookiesFromPanda;
    }

    public String getCor()
    {
        return mCor;
    }

    public Map getCredentialsReceived()
    {
        HashMap hashmap = new HashMap();
        hashmap.putAll(mCredentialsReceived);
        return hashmap;
    }

    public String getCustomerRegion()
    {
        return mCustomerRegion;
    }

    public Map getDeviceInfo()
    {
        return mDeviceInfo;
    }

    public String getDeviceName()
    {
        return mDeviceName;
    }

    public String getDirectedId()
    {
        return mDirectedId;
    }

    public String getEmail()
    {
        return mDeviceEmail;
    }

    public RegisterDeviceError getError()
    {
        return mError;
    }

    public long getNumCookiesRetrievedFromFIRS()
    {
        return (long)mCookiesFromFIRS.size();
    }

    public String getPfm()
    {
        return mPfm;
    }

    public String getPrivateKey()
    {
        return mPrivateKey;
    }

    public String getRefreshToken()
    {
        return mRefreshToken;
    }

    public String getServerTime()
    {
        return mServerTime;
    }

    public String getSourceOfCor()
    {
        return mSourceOfCor;
    }

    public String getStoreAuthenticationCookie()
    {
        return mStoreAuthenticationCookie;
    }

    public String getUserName()
    {
        return mUserName;
    }

    void setAccessToken(String s)
    {
        mAccessToken = s;
    }

    void setAccessTokenExpiresIn(int i)
    {
        mAccessTokenExpiresIn = i;
    }

    public void setAccountPool(String s)
    {
        mAccountPool = s;
    }

    void setAdpToken(String s)
    {
        mAdpToken = s;
    }

    void setCor(String s)
    {
        mCor = s;
    }

    public void setCredentialsReceived(Map map)
    {
        mCredentialsReceived.clear();
        mCredentialsReceived.putAll(map);
    }

    public void setCustomerRegion(String s)
    {
        mCustomerRegion = s;
    }

    public void setDeviceInfo(Map map)
    {
        mDeviceInfo = map;
    }

    void setDeviceName(String s)
    {
        mDeviceName = s;
    }

    void setDirectedId(String s)
    {
        mDirectedId = s;
    }

    void setEmail(String s)
    {
        mDeviceEmail = s;
    }

    void setError(RegisterDeviceError registerdeviceerror)
    {
        mError = registerdeviceerror;
    }

    public void setPandaCookies(JSONArray jsonarray)
    {
        mCookiesFromPanda = jsonarray;
    }

    void setPfm(String s)
    {
        mPfm = s;
    }

    void setPrivateKey(String s)
    {
        mPrivateKey = s;
    }

    void setRefreshToken(String s)
    {
        mRefreshToken = s;
    }

    void setSourceOfCor(String s)
    {
        mSourceOfCor = s;
    }

    public void setStoreAuthenticationCookie(String s)
    {
        mStoreAuthenticationCookie = s;
    }

    void setUserName(String s)
    {
        mUserName = s;
    }

}
