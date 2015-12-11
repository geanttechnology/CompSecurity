// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.content.ContentValues;
import android.text.TextUtils;
import com.espn.androidplayersdk.objects.EPAuthError;
import com.espn.androidplayersdk.utilities.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPStream

class StartSessionParser
{

    final String domain = "go.com";

    StartSessionParser()
    {
    }

    EPAuthError generateErrorObject(JSONObject jsonobject)
    {
        EPAuthError epautherror;
        Object obj;
        ContentValues contentvalues;
        obj = null;
        contentvalues = new ContentValues();
        epautherror = obj;
        if (!jsonobject.has("status"))
        {
            break MISSING_BLOCK_LABEL_253;
        }
        epautherror = obj;
        if (!jsonobject.isNull("status"))
        {
            epautherror = obj;
            try
            {
                if (jsonobject.getString("status").equalsIgnoreCase("error"))
                {
                    if (jsonobject.has("timestamp") && !jsonobject.isNull("timestamp"))
                    {
                        contentvalues.put("timestamp", jsonobject.getString("timestamp"));
                    }
                    if (jsonobject.has("message") && !jsonobject.isNull("message"))
                    {
                        contentvalues.put("message", jsonobject.getString("message"));
                    }
                    if (jsonobject.has("abbreviation") && !jsonobject.isNull("abbreviation"))
                    {
                        contentvalues.put("abbreviation", jsonobject.getString("abbreviation"));
                    }
                    if (jsonobject.has("type") && !jsonobject.isNull("type"))
                    {
                        contentvalues.put("type", jsonobject.getString("type"));
                    }
                    if (jsonobject.has("code") && !jsonobject.isNull("code"))
                    {
                        contentvalues.put("code", Integer.valueOf(jsonobject.getInt("code")));
                    }
                    epautherror = new EPAuthError(contentvalues.getAsString("timestamp"), contentvalues.getAsString("message"), contentvalues.getAsString("abbreviation"), contentvalues.getAsString("type"), contentvalues.getAsInteger("code").intValue());
                }
            }
            catch (Exception exception)
            {
                if ((new StringBuilder("StartSessionParser:")).append(exception.getMessage()).toString() != null)
                {
                    jsonobject = exception.getMessage();
                } else
                {
                    jsonobject = "";
                }
                Utils.sdkLog(jsonobject, 5, exception);
                return null;
            }
        }
        return epautherror;
    }

    EPStream getFWToken(EPStream epstream)
    {
        String s = "0";
        if (epstream != null && epstream.isAdInsertionEnabled())
        {
            String s1;
            if (!TextUtils.isEmpty(epstream.getfwSyncTokenUrl()))
            {
                try
                {
                    s = URLEncoder.encode(getRequest(epstream.getfwSyncTokenUrl()), "UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    Utils.sdkLog("Sync token URL Encoding failed", 5, unsupportedencodingexception);
                    unsupportedencodingexception = "0";
                }
            }
            s1 = s;
            if ("0".equals(s))
            {
                s1 = Integer.toString(Math.round((new Random()).nextFloat() * 1E+07F));
            }
            epstream.playbackUrl = (new StringBuilder(String.valueOf(epstream.playbackUrl))).append("&_fw_syncing_token=").append(s1).toString();
        }
        return epstream;
    }

    String getRequest(String s)
    {
        String s1;
        String s2;
        s2 = null;
        s1 = null;
        s = (new URL(s)).openConnection().getInputStream();
        s1 = s;
        s2 = s;
        Object obj = new BufferedReader(new InputStreamReader(s));
        s1 = s;
        s2 = s;
        StringBuilder stringbuilder = new StringBuilder();
_L2:
        s1 = s;
        s2 = s;
        String s3 = ((BufferedReader) (obj)).readLine();
        if (s3 != null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s1 = s;
        s2 = s;
        obj = stringbuilder.toString();
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Sync token error", 5, s);
                return ((String) (obj));
            }
        }
        return ((String) (obj));
        s1 = s;
        s2 = s;
        stringbuilder.append(s3);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        s2 = s1;
        Utils.sdkLog("Sync token error", 5, s);
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Utils.sdkLog("Sync token error", 5, s);
            }
        }
        return "0";
        s;
        if (s2 != null)
        {
            try
            {
                s2.close();
            }
            catch (IOException ioexception)
            {
                Utils.sdkLog("Sync token error", 5, ioexception);
            }
        }
        throw s;
    }

    EPStream parse(JSONObject jsonobject, HashMap hashmap)
    {
        HashMap hashmap1;
        hashmap1 = new HashMap();
        if (!jsonobject.has("status") || jsonobject.isNull("status") || !jsonobject.getString("status").equalsIgnoreCase("success"))
        {
            break MISSING_BLOCK_LABEL_750;
        }
        if (!jsonobject.has("session") || jsonobject.isNull("session")) goto _L2; else goto _L1
_L1:
        jsonobject = jsonobject.getJSONObject("session");
        if (jsonobject.has("channel") && !jsonobject.isNull("channel"))
        {
            hashmap1.put("networkId", jsonobject.getString("channel"));
        }
        if (jsonobject.has("event") && !jsonobject.isNull("event"))
        {
            JSONObject jsonobject1 = jsonobject.getJSONObject("event");
            if (jsonobject1.has("id") && !jsonobject1.isNull("id"))
            {
                hashmap1.put("eventId", jsonobject1.getString("id"));
            }
            if (jsonobject1.has("airingId") && !jsonobject1.isNull("airingId"))
            {
                hashmap1.put("airingId", jsonobject1.getString("airingId"));
            }
        }
        if (jsonobject.has("playbackUrls") && !jsonobject.isNull("playbackUrls"))
        {
            JSONObject jsonobject2 = jsonobject.getJSONObject("playbackUrls");
            if (jsonobject2.has("default") && !jsonobject2.isNull("default"))
            {
                hashmap1.put("playbackUrl", jsonobject2.getString("default"));
            }
            if (jsonobject2.has("alternate") && !jsonobject2.isNull("alternate"))
            {
                hashmap1.put("alternatePlaybackUrl", jsonobject2.getString("alternate"));
            }
        }
        if (jsonobject.has("maintainUrl") && !jsonobject.isNull("maintainUrl"))
        {
            hashmap1.put("maintainUrl", jsonobject.getString("maintainUrl"));
        }
        if (jsonobject.has("programChangeUrl") && !jsonobject.isNull("programChangeUrl"))
        {
            hashmap1.put("programChangeUrl", jsonobject.getString("programChangeUrl"));
        }
        if (jsonobject.has("token") && !jsonobject.isNull("token"))
        {
            hashmap1.put("token", jsonobject.getString("token"));
        }
        if (jsonobject.has("authorizationCookieName") && !jsonobject.isNull("authorizationCookieName"))
        {
            hashmap1.put("authorizationCookieName", jsonobject.getString("authorizationCookieName"));
        }
        if (jsonobject.has("analytics") && !jsonobject.isNull("analytics"))
        {
            JSONObject jsonobject3 = jsonobject.getJSONObject("analytics");
            if (jsonobject3.has("conviva") && !jsonobject3.isNull("conviva"))
            {
                jsonobject3 = jsonobject3.getJSONObject("conviva");
                if (jsonobject3.has("cdn") && !jsonobject3.isNull("cdn"))
                {
                    hashmap1.put("cdn", jsonobject3.getString("cdn"));
                }
                if (jsonobject3.has("resource") && !jsonobject3.isNull("resource"))
                {
                    hashmap1.put("resource", jsonobject3.getString("resource"));
                }
            }
        }
        if (jsonobject.has("fwSyncTokenUrl") && !jsonobject.isNull("fwSyncTokenUrl"))
        {
            hashmap1.put("fwSyncTokenUrl", jsonobject.getString("fwSyncTokenUrl"));
        }
        if (jsonobject.has("adInsertionEnabled") && !jsonobject.isNull("adInsertionEnabled"))
        {
            hashmap1.put("adInsertionEnabled", jsonobject.getString("adInsertionEnabled"));
        }
        if (hashmap == null) goto _L4; else goto _L3
_L3:
        if (!hashmap.containsKey("ttl")) goto _L4; else goto _L5
_L5:
        hashmap1.put("ttl", (String)hashmap.get("ttl"));
_L7:
        hashmap1.put("domain", "go.com");
_L2:
        return new EPStream(hashmap1);
_L4:
        if (jsonobject.has("ttl") && !jsonobject.isNull("ttl"))
        {
            hashmap1.put("ttl", jsonobject.getString("ttl"));
        }
        if (true) goto _L7; else goto _L6
_L6:
        hashmap;
        if ((new StringBuilder("StartSessionParser:")).append(hashmap.getMessage()).toString() != null)
        {
            jsonobject = hashmap.getMessage();
        } else
        {
            jsonobject = "";
        }
        Utils.sdkLog(jsonobject, 5, hashmap);
        return null;
        return null;
    }
}
