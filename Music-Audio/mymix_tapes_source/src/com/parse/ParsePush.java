// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.gdata.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ManifestInfo, Parse, PushRouter, ParseInstallation, 
//            ParseCommand, ParseQuery, PointerEncodingStrategy, ParseException, 
//            ParseUser, ParseObject, SendCallback, SaveCallback, 
//            PushService

public class ParsePush
{

    private static final String TAG = "com.parse.ParsePush";
    static final String V2_PUSH_NOT_CONFIGURED = "In order to use the ParsePush.subscribe or ParsePush.unsubscribe methods you must add the following to your AndroidManifest.xml: \n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"\n  android:exported=\"false\">\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>\n(Replace \"com.parse.ParsePushBroadcastReceiver\" with your own implementation if you choose to extend ParsePushBroadcastReceiver)";
    private Set channelSet;
    private JSONObject data;
    private Long expirationTime;
    private Long expirationTimeInterval;
    private Boolean pushToAndroid;
    private Boolean pushToIOS;
    private ParseQuery query;

    public ParsePush()
    {
        channelSet = null;
        query = null;
        expirationTime = null;
        expirationTimeInterval = null;
        pushToIOS = null;
        pushToAndroid = null;
    }

    private static void checkForManifestAndThrowExceptionIfNeeded()
    {
        if (!ManifestInfo.getPushUsesBroadcastReceivers())
        {
            throw new IllegalStateException("In order to use the ParsePush.subscribe or ParsePush.unsubscribe methods you must add the following to your AndroidManifest.xml: \n<receiver android:name=\"com.parse.ParsePushBroadcastReceiver\"\n  android:exported=\"false\">\n  <intent-filter>\n    <action android:name=\"com.parse.push.intent.RECEIVE\" />\n    <action android:name=\"com.parse.push.intent.OPEN\" />\n    <action android:name=\"com.parse.push.intent.DELETE\" />\n  </intent-filter>\n</receiver>\n(Replace \"com.parse.ParsePushBroadcastReceiver\" with your own implementation if you choose to extend ParsePushBroadcastReceiver)");
        } else
        {
            return;
        }
    }

    public static Task sendDataInBackground(JSONObject jsonobject, ParseQuery parsequery)
    {
        ParsePush parsepush = new ParsePush();
        parsepush.setQuery(parsequery);
        parsepush.setData(jsonobject);
        return parsepush.sendInBackground();
    }

    public static void sendDataInBackground(JSONObject jsonobject, ParseQuery parsequery, SendCallback sendcallback)
    {
        Parse.callbackOnMainThreadAsync(sendDataInBackground(jsonobject, parsequery), sendcallback);
    }

    public static Task sendMessageInBackground(String s, ParseQuery parsequery)
    {
        ParsePush parsepush = new ParsePush();
        parsepush.setQuery(parsequery);
        parsepush.setMessage(s);
        return parsepush.sendInBackground();
    }

    public static void sendMessageInBackground(String s, ParseQuery parsequery, SendCallback sendcallback)
    {
        Parse.callbackOnMainThreadAsync(sendMessageInBackground(s, parsequery), sendcallback);
    }

    static void setEnabled(boolean flag)
    {
        checkForManifestAndThrowExceptionIfNeeded();
        PushRouter.setForceEnabledAsync(Boolean.valueOf(flag)).onSuccess(new Continuation(flag) {

            final boolean val$enabled;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                if (!enabled)
                {
                    PushService.stopPpnsService(Parse.applicationContext);
                } else
                {
                    PushService.startServiceIfRequired(Parse.applicationContext);
                }
                return null;
            }

            
            {
                enabled = flag;
                super();
            }
        });
    }

    public static Task subscribeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Can't subscribe to null channel.");
        }
        checkForManifestAndThrowExceptionIfNeeded();
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        List list = parseinstallation.getList("channels");
        if (list == null || !list.contains(s))
        {
            parseinstallation.addUnique("channels", s);
            return parseinstallation.saveInBackground();
        } else
        {
            return Task.forResult(null);
        }
    }

    public static void subscribeInBackground(String s, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(subscribeInBackground(s), savecallback);
    }

    public static Task unsubscribeInBackground(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Can't unsubscribe from null channel.");
        }
        checkForManifestAndThrowExceptionIfNeeded();
        ParseInstallation parseinstallation = ParseInstallation.getCurrentInstallation();
        List list = parseinstallation.getList("channels");
        if (list != null && list.contains(s))
        {
            parseinstallation.removeAll("channels", Arrays.asList(new String[] {
                s
            }));
            return parseinstallation.saveInBackground();
        } else
        {
            return Task.forResult(null);
        }
    }

    public static void unsubscribeInBackground(String s, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(unsubscribeInBackground(s), savecallback);
    }

    ParseCommand buildCommand(String s)
    {
        boolean flag;
        boolean flag1;
        s = new ParseCommand("client_push", s);
        if (data == null)
        {
            throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
        }
        s.put("data", data);
        if (query != null)
        {
            s.put("where", (JSONObject)Parse.encode(query.getConstraints(), PointerEncodingStrategy.get()));
        } else
        if (channelSet == null)
        {
            s.put("channel", "");
        } else
        {
            s.put("channels", new JSONArray(channelSet));
        }
        if (expirationTime == null) goto _L2; else goto _L1
_L1:
        s.put("expiration_time", expirationTime.longValue());
_L4:
        if (query == null && (pushToAndroid != null || pushToIOS != null))
        {
            if (pushToAndroid == null || pushToAndroid.booleanValue())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (pushToIOS != null && pushToIOS.booleanValue())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (!flag1 || !flag)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        return s;
_L2:
        if (expirationTimeInterval != null)
        {
            s.put("expiration_time_interval", expirationTimeInterval.longValue());
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (flag1)
        {
            s.put("type", "ios");
            return s;
        }
        if (flag)
        {
            s.put("type", "android");
            return s;
        } else
        {
            throw new IllegalArgumentException("Cannot push if both pushToIOS and pushToAndroid are false");
        }
    }

    public void clearExpiration()
    {
        expirationTime = null;
        expirationTimeInterval = null;
    }

    public void send()
        throws ParseException
    {
        Parse.waitForTask(sendInBackground());
    }

    public Task sendInBackground()
    {
        return buildCommand(ParseUser.getCurrentSessionToken()).executeAsync().continueWith(new Continuation() {

            final ParsePush this$0;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                return null;
            }

            
            {
                this$0 = ParsePush.this;
                super();
            }
        });
    }

    public void sendInBackground(SendCallback sendcallback)
    {
        Parse.callbackOnMainThreadAsync(sendInBackground(), sendcallback);
    }

    public void setChannel(String s)
    {
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "channel cannot be null");
        channelSet = new HashSet();
        channelSet.add(s);
        query = null;
    }

    public void setChannels(Collection collection)
    {
        Iterator iterator;
        boolean flag;
        if (collection != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "channels collection cannot be null");
        iterator = collection.iterator();
        while (iterator.hasNext()) 
        {
            if ((String)iterator.next() != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "channel cannot be null");
        }
        channelSet = new HashSet();
        channelSet.addAll(collection);
        query = null;
    }

    public void setData(JSONObject jsonobject)
    {
        data = jsonobject;
    }

    public void setExpirationTime(long l)
    {
        expirationTime = Long.valueOf(l);
        expirationTimeInterval = null;
    }

    public void setExpirationTimeInterval(long l)
    {
        expirationTime = null;
        expirationTimeInterval = Long.valueOf(l);
    }

    public void setMessage(String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("alert", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Parse.logE("com.parse.ParsePush", "JSONException in setMessage", s);
        }
        setData(jsonobject);
    }

    public void setPushToAndroid(boolean flag)
    {
        boolean flag1;
        if (query == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Preconditions.checkArgument(flag1, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        pushToAndroid = Boolean.valueOf(flag);
    }

    public void setPushToIOS(boolean flag)
    {
        boolean flag1;
        if (query == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Preconditions.checkArgument(flag1, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        pushToIOS = Boolean.valueOf(flag);
    }

    public void setQuery(ParseQuery parsequery)
    {
        boolean flag1 = true;
        boolean flag;
        if (parsequery != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot target a null query");
        if (pushToIOS == null && pushToAndroid == null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        Preconditions.checkArgument(parsequery.getClassName().equals(ParseObject.getClassName(com/parse/ParseInstallation)), "Can only push to a query for Installations");
        channelSet = null;
        query = parsequery;
    }
}
