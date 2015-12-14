// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.attribute;

import android.text.TextUtils;
import com.amazon.identity.auth.device.framework.AmazonUrlConnectionHelpers;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.AuthPortalHelper;
import com.amazon.identity.auth.device.utils.CollectionUtils;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.auth.PandaRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PandaUserProfileRequest extends PandaRequest
{

    private static final String TAG = com/amazon/identity/auth/device/attribute/PandaUserProfileRequest.getName();
    private String mAccessToken;
    private HttpURLConnection mConnection;
    private String mDomain;
    private Tracer mTracer;

    public PandaUserProfileRequest(String s, String s1, Tracer tracer)
    {
        mAccessToken = s;
        mDomain = s1;
        mTracer = tracer;
        mConnection = setupConnection();
    }

    private HttpURLConnection setupConnection()
    {
        setCookieDomain(mDomain);
        Object obj = getPandaUserProfileURL((new StringBuilder("https://")).append(getPandaEndPoint("/user/profile")).toString());
        try
        {
            obj = (HttpURLConnection)AmazonUrlConnectionHelpers.openConnection(((URL) (obj)));
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            ((HttpURLConnection) (obj)).setDoInput(true);
            ((HttpURLConnection) (obj)).setRequestProperty("Authorization", (new StringBuilder("Bearer ")).append(mAccessToken).toString());
            ((HttpURLConnection) (obj)).setRequestProperty("User-Agent", AuthPortalHelper.CUSTOM_USER_AGENT);
        }
        catch (IOException ioexception)
        {
            MAPLog.logAndReportError(TAG, mTracer, "IOException happens when trying to open Panda connection", "MAPUserProfileError:IOException", ioexception);
            return null;
        }
        return ((HttpURLConnection) (obj));
    }

    public ArrayList getAccountMissingProfileAttributes(List list)
    {
        return getAccountMissingProfileAttributes(getUserProfileJSON(), list);
    }

    ArrayList getAccountMissingProfileAttributes(JSONObject jsonobject, List list)
    {
        ArrayList arraylist = new ArrayList();
        if (!CollectionUtils.isEmpty(list)) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        if (jsonobject == null || jsonobject.length() == 0)
        {
            MAPLog.e(TAG, "ProfileJSON is null or empty");
            return null;
        }
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                continue;
            }
            String s = (String)list.next();
            if (!jsonobject.has(s))
            {
                arraylist.add(s);
                break;
            }
            try
            {
                if (TextUtils.isEmpty(jsonobject.getString(s)))
                {
                    arraylist.add(s);
                }
            }
            catch (JSONException jsonexception)
            {
                arraylist.add(s);
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    URL getPandaUserProfileURL(String s)
    {
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("MalformedURLException happened. This should never happen.");
        }
        return s;
    }

    JSONObject getUserProfileJSON()
    {
        Object obj = mConnection;
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (mConnection != null)
        {
            mConnection.disconnect();
        }
        obj = null;
_L4:
        return ((JSONObject) (obj));
_L2:
        int i = mConnection.getResponseCode();
        MAPLog.i(TAG, (new StringBuilder("Response received from Panda user profile API. Response Code:")).append(i).toString());
        if (!(new AuthEndpointErrorParser()).isFailure(i))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        MAPLog.e(TAG, "Error happens when calling Panda user profile api");
        if (mConnection != null)
        {
            mConnection.disconnect();
        }
        return null;
        JSONObject jsonobject = JSONHelpers.toJson(mConnection);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = TAG;
        (new StringBuilder("Panda user profile response json:")).append(jsonobject.toString()).toString();
        obj = jsonobject;
        if (mConnection != null)
        {
            mConnection.disconnect();
            return jsonobject;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        MAPLog.logAndReportError(TAG, mTracer, "JSONException happens when trying to call user profile", "MAPUserProfileError:JSONException", ((Throwable) (obj1)));
        if (mConnection != null)
        {
            mConnection.disconnect();
        }
_L6:
        return null;
        obj1;
        MAPLog.logAndReportError(TAG, mTracer, "IOException happens when trying to call user profile", "MAPUserProfileError:IOException", ((Throwable) (obj1)));
        if (mConnection != null)
        {
            mConnection.disconnect();
        }
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (mConnection != null)
        {
            mConnection.disconnect();
        }
        throw obj1;
    }

}
