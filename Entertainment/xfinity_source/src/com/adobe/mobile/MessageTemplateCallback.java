// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            Message, StaticMethods, ThirdPartyQueue

final class MessageTemplateCallback extends Message
{

    private static final String ADB_TEMPLATE_CALLBACK_BODY = "templatebody";
    private static final String ADB_TEMPLATE_CALLBACK_TIMEOUT = "timeout";
    private static final String ADB_TEMPLATE_CALLBACK_TYPE = "contenttype";
    private static final String ADB_TEMPLATE_CALLBACK_URL = "templateurl";
    private static final int ADB_TEMPLATE_TIMEOUT_DEFAULT = 2;
    private static final char ADB_TEMPLATE_TOKEN_END = 125;
    private static final char ADB_TEMPLATE_TOKEN_START = 123;
    private static final boolean tokenDataMask[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 
        0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 
        0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
        1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0
    };
    private HashMap _combinedVariablesCopy;
    protected String contentType;
    private final SecureRandom randomGen = new SecureRandom();
    protected String templateBody;
    protected String templateUrl;
    protected int timeout;

    MessageTemplateCallback()
    {
    }

    private HashMap buildExpansionsForTokens(ArrayList arraylist)
    {
        HashMap hashmap = new HashMap(arraylist.size());
        Iterator iterator = arraylist.iterator();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            arraylist = s.substring(1, s.length() - 1).toLowerCase();
            arraylist = ((ArrayList) (_combinedVariablesCopy.get(arraylist)));
            if (arraylist == null)
            {
                arraylist = "";
            } else
            {
                arraylist = arraylist.toString();
            }
            hashmap.put(s, StaticMethods.URLEncode(arraylist));
        }
        return hashmap;
    }

    private ArrayList findTokensForExpansion(String s)
    {
        if (s != null && s.length() > 0) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = null;
_L4:
        return arraylist;
_L2:
        ArrayList arraylist1;
        int i;
        int k;
        arraylist1 = new ArrayList(32);
        k = s.length();
        i = 0;
_L6:
        arraylist = arraylist1;
        if (i >= k) goto _L4; else goto _L3
_L3:
        int j = i;
        if (s.charAt(i) != '{')
        {
            break MISSING_BLOCK_LABEL_124;
        }
        for (j = i + 1; j < k && s.charAt(j) != '}'; j++)
        {
            break MISSING_BLOCK_LABEL_133;
        }

        arraylist = arraylist1;
        if (j == k) goto _L4; else goto _L5
_L5:
        String s1 = s.substring(i, j + 1);
        if (!tokenIsValid(s1.substring(1, s1.length() - 1)))
        {
            j = i;
        } else
        {
            arraylist1.add(s1);
        }
        i = j + 1;
          goto _L6
    }

    private HashMap getMapForTemplatedTokens()
    {
        HashMap hashmap = new HashMap(5);
        hashmap.put("%sdkver%", "4.6.0-AN");
        hashmap.put("%cachebust%", String.valueOf(randomGen.nextInt(0x5f5e100)));
        hashmap.put("%timestampu%", String.valueOf(StaticMethods.getTimeSince1970()));
        hashmap.put("%timestampz%", StaticMethods.getIso8601Date());
        hashmap.put("%adid%", StaticMethods.getAdvertisingIdentifier());
        hashmap.put("%pushid%", StaticMethods.getPushIdentifier());
        return hashmap;
    }

    private boolean tokenIsValid(String s)
    {
        int i;
        int j;
        byte byte0;
        boolean flag;
        try
        {
            s = s.getBytes("UTF-8");
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            StaticMethods.logErrorFormat("Data Callback - Unable to validate token (%s)", new Object[] {
                s.getLocalizedMessage()
            });
            return false;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = s[i];
        flag = tokenDataMask[byte0 & 0xff];
        if (!flag)
        {
            return false;
        }
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_12;
_L1:
        return true;
    }

    protected boolean initWithPayloadObject(JSONObject jsonobject)
    {
label0:
        {
            while (jsonobject == null || jsonobject.length() <= 0 || !super.initWithPayloadObject(jsonobject)) 
            {
                return false;
            }
            try
            {
                jsonobject = jsonobject.getJSONObject("payload");
                if (jsonobject.length() > 0)
                {
                    break label0;
                }
                StaticMethods.logDebugFormat("Data Callback - Unable to create data callback \"%s\", \"payload\" is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logDebugFormat("Data Callback - Unable to create create data callback \"%s\", \"payload\" is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
label1:
        {
            try
            {
                templateUrl = jsonobject.getString("templateurl");
                if (templateUrl.length() > 0)
                {
                    break label1;
                }
                StaticMethods.logDebugFormat("Data Callback - Unable to create data callback \"%s\", \"templateurl\" is empty", new Object[] {
                    messageId
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logDebugFormat("Data Callback - Unable to create data callback \"%s\", \"templateurl\" is required", new Object[] {
                    messageId
                });
                return false;
            }
            return false;
        }
        String s;
        byte abyte0[];
        try
        {
            timeout = jsonobject.getInt("timeout");
        }
        catch (JSONException jsonexception)
        {
            StaticMethods.logDebugFormat("Data Callback - Tried to read \"timeout\" for data callback, but found none.  Using default value of two (2) seconds", new Object[0]);
            timeout = 2;
        }
        s = jsonobject.getString("templatebody");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        if (s.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        abyte0 = Base64.decode(s, 0);
        if (abyte0 != null)
        {
            try
            {
                abyte0 = new String(abyte0, "UTF-8");
                if (abyte0.length() > 0)
                {
                    templateBody = abyte0;
                }
            }
            catch (JSONException jsonexception1)
            {
                StaticMethods.logDebugFormat("Data Callback - Tried to read \"templatebody\" for data callback, but found none.  This is not a required field", new Object[0]);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                StaticMethods.logDebugFormat("Data Callback - Failed to decode \"templatebody\" for data callback (%s).  This is not a required field", new Object[] {
                    unsupportedencodingexception.getLocalizedMessage()
                });
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                StaticMethods.logDebugFormat("Data Callback - Failed to decode \"templatebody\" for data callback (%s).  This is not a required field", new Object[] {
                    illegalargumentexception.getLocalizedMessage()
                });
            }
        }
        if (templateBody != null && templateBody.length() > 0)
        {
            try
            {
                contentType = jsonobject.getString("contenttype");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                StaticMethods.logDebugFormat("Data Callback - Tried to read \"contenttype\" for data callback, but found none.  This is not a required field", new Object[0]);
            }
        }
        return true;
    }

    protected boolean shouldShowForVariables(Map map, Map map1, Map map2)
    {
        HashMap hashmap;
        if (map1 != null)
        {
            hashmap = new HashMap(map1);
        } else
        {
            hashmap = new HashMap();
        }
        if (map != null)
        {
            hashmap.putAll(map);
        }
        if (map2 != null)
        {
            hashmap.putAll(map2);
        }
        hashmap.putAll(getMapForTemplatedTokens());
        _combinedVariablesCopy = new HashMap(hashmap);
        return super.shouldShowForVariables(map, map1, map2);
    }

    protected void show()
    {
        Object obj = buildExpansionsForTokens(findTokensForExpansion(templateUrl));
        String s = StaticMethods.expandTokens(templateUrl, ((Map) (obj)));
        Object obj1 = null;
        obj = obj1;
        if (templateBody != null)
        {
            obj = obj1;
            if (templateBody.length() > 0)
            {
                obj = buildExpansionsForTokens(findTokensForExpansion(templateBody));
                obj = StaticMethods.expandTokens(templateBody, ((Map) (obj)));
            }
        }
        StaticMethods.logDebugFormat("Data Callback - Attempting to send request (url:%s body:%s contentType:%s)", new Object[] {
            s, obj, contentType
        });
        ThirdPartyQueue.sharedInstance().queue(s, ((String) (obj)), contentType, StaticMethods.getTimeSince1970(), timeout);
    }

}
