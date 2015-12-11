// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseCorePlugins, ParseTaskUtils, ParsePushChannelsController, ParseException, 
//            ParseUser, PLog, ParsePushController, ParseQuery, 
//            SendCallback, SaveCallback, ParseInstallation, ParseObject

public class ParsePush
{
    static class State
    {

        private final Set channelSet;
        private final JSONObject data;
        private final Long expirationTime;
        private final Long expirationTimeInterval;
        private final Boolean pushToAndroid;
        private final Boolean pushToIOS;
        private final ParseQuery.State queryState;

        public Set channelSet()
        {
            return channelSet;
        }

        public JSONObject data()
        {
            try
            {
                Object obj = data;
                if (!(obj instanceof JSONObject))
                {
                    obj = ((JSONObject) (obj)).toString();
                } else
                {
                    obj = JSONObjectInstrumentation.toString((JSONObject)obj);
                }
                return JSONObjectInstrumentation.init(((String) (obj)));
            }
            catch (JSONException jsonexception)
            {
                return null;
            }
        }

        public Long expirationTime()
        {
            return expirationTime;
        }

        public Long expirationTimeInterval()
        {
            return expirationTimeInterval;
        }

        public Boolean pushToAndroid()
        {
            return pushToAndroid;
        }

        public Boolean pushToIOS()
        {
            return pushToIOS;
        }

        public ParseQuery.State queryState()
        {
            return queryState;
        }

        private State(Builder builder1)
        {
            Object obj1;
            obj1 = null;
            super();
            Object obj;
            if (builder1.channelSet == null)
            {
                obj = null;
            } else
            {
                obj = Collections.unmodifiableSet(new HashSet(builder1.channelSet));
            }
            channelSet = ((Set) (obj));
            if (builder1.query == null)
            {
                obj = null;
            } else
            {
                obj = builder1.query.getBuilder().build();
            }
            queryState = ((ParseQuery.State) (obj));
            expirationTime = builder1.expirationTime;
            expirationTimeInterval = builder1.expirationTimeInterval;
            pushToIOS = builder1.pushToIOS;
            pushToAndroid = builder1.pushToAndroid;
            builder1 = builder1.data;
            if (builder1 instanceof JSONObject) goto _L2; else goto _L1
_L1:
            builder1 = builder1.toString();
_L3:
            builder1 = JSONObjectInstrumentation.init(builder1);
_L4:
            data = builder1;
            return;
_L2:
            builder1 = JSONObjectInstrumentation.toString((JSONObject)builder1);
              goto _L3
            builder1;
            builder1 = obj1;
              goto _L4
        }

    }

    static class State.Builder
    {

        private Set channelSet;
        private JSONObject data;
        private Long expirationTime;
        private Long expirationTimeInterval;
        private Boolean pushToAndroid;
        private Boolean pushToIOS;
        private ParseQuery query;

        public State build()
        {
            if (data == null)
            {
                throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
            } else
            {
                return new State(this);
            }
        }

        public State.Builder channelSet(Collection collection)
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
            ParsePush.checkArgument(flag, "channels collection cannot be null");
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
                ParsePush.checkArgument(flag, "channel cannot be null");
            }
            channelSet = new HashSet(collection);
            query = null;
            return this;
        }

        public State.Builder data(JSONObject jsonobject)
        {
            data = jsonobject;
            return this;
        }

        public State.Builder expirationTime(Long long1)
        {
            expirationTime = long1;
            expirationTimeInterval = null;
            return this;
        }

        public State.Builder expirationTimeInterval(Long long1)
        {
            expirationTimeInterval = long1;
            expirationTime = null;
            return this;
        }

        public State.Builder pushToAndroid(Boolean boolean1)
        {
            boolean flag;
            if (query == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ParsePush.checkArgument(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
            pushToAndroid = boolean1;
            return this;
        }

        public State.Builder pushToIOS(Boolean boolean1)
        {
            boolean flag;
            if (query == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ParsePush.checkArgument(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
            pushToIOS = boolean1;
            return this;
        }

        public State.Builder query(ParseQuery parsequery)
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
            ParsePush.checkArgument(flag, "Cannot target a null query");
            if (pushToIOS == null && pushToAndroid == null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            ParsePush.checkArgument(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
            ParsePush.checkArgument(parsequery.getClassName().equals(ParseObject.getClassName(com/parse/ParseInstallation)), "Can only push to a query for Installations");
            channelSet = null;
            query = parsequery;
            return this;
        }








        State.Builder()
        {
        }
    }


    static String KEY_DATA_MESSAGE = "alert";
    private static final String TAG = "com.parse.ParsePush";
    final State.Builder builder;

    public ParsePush()
    {
        this(new State.Builder());
    }

    private ParsePush(State.Builder builder1)
    {
        builder = builder1;
    }

    private static void checkArgument(boolean flag, Object obj)
    {
        if (!flag)
        {
            throw new IllegalArgumentException(String.valueOf(obj));
        } else
        {
            return;
        }
    }

    static ParsePushChannelsController getPushChannelsController()
    {
        return ParseCorePlugins.getInstance().getPushChannelsController();
    }

    static ParsePushController getPushController()
    {
        return ParseCorePlugins.getInstance().getPushController();
    }

    public static j sendDataInBackground(JSONObject jsonobject, ParseQuery parsequery)
    {
        ParsePush parsepush = new ParsePush();
        parsepush.setQuery(parsequery);
        parsepush.setData(jsonobject);
        return parsepush.sendInBackground();
    }

    public static void sendDataInBackground(JSONObject jsonobject, ParseQuery parsequery, SendCallback sendcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(sendDataInBackground(jsonobject, parsequery), sendcallback);
    }

    public static j sendMessageInBackground(String s, ParseQuery parsequery)
    {
        ParsePush parsepush = new ParsePush();
        parsepush.setQuery(parsequery);
        parsepush.setMessage(s);
        return parsepush.sendInBackground();
    }

    public static void sendMessageInBackground(String s, ParseQuery parsequery, SendCallback sendcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(sendMessageInBackground(s, parsequery), sendcallback);
    }

    public static j subscribeInBackground(String s)
    {
        return getPushChannelsController().subscribeInBackground(s);
    }

    public static void subscribeInBackground(String s, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(subscribeInBackground(s), savecallback);
    }

    public static j unsubscribeInBackground(String s)
    {
        return getPushChannelsController().unsubscribeInBackground(s);
    }

    public static void unsubscribeInBackground(String s, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unsubscribeInBackground(s), savecallback);
    }

    public void clearExpiration()
    {
        builder.expirationTime(null);
        builder.expirationTimeInterval(null);
    }

    public void send()
        throws ParseException
    {
        ParseTaskUtils.wait(sendInBackground());
    }

    public j sendInBackground()
    {
        final State state = builder.build();
        return ParseUser.getCurrentSessionTokenAsync().d(new i() {

            final ParsePush this$0;
            final State val$state;

            public j then(j j1)
                throws Exception
            {
                j1 = (String)j1.e();
                return ParsePush.getPushController().sendInBackground(state, j1);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParsePush.this;
                state = state1;
                super();
            }
        });
    }

    public void sendInBackground(SendCallback sendcallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(sendInBackground(), sendcallback);
    }

    public void setChannel(String s)
    {
        builder.channelSet(Collections.singletonList(s));
    }

    public void setChannels(Collection collection)
    {
        builder.channelSet(collection);
    }

    public void setData(JSONObject jsonobject)
    {
        builder.data(jsonobject);
    }

    public void setExpirationTime(long l)
    {
        builder.expirationTime(Long.valueOf(l));
    }

    public void setExpirationTimeInterval(long l)
    {
        builder.expirationTimeInterval(Long.valueOf(l));
    }

    public void setMessage(String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put(KEY_DATA_MESSAGE, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            PLog.e("com.parse.ParsePush", "JSONException in setMessage", s);
        }
        setData(jsonobject);
    }

    public void setPushToAndroid(boolean flag)
    {
        builder.pushToAndroid(Boolean.valueOf(flag));
    }

    public void setPushToIOS(boolean flag)
    {
        builder.pushToIOS(Boolean.valueOf(flag));
    }

    public void setQuery(ParseQuery parsequery)
    {
        builder.query(parsequery);
    }


}
