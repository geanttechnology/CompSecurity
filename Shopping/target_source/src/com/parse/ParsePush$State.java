// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePush, ParseQuery, ParseInstallation, ParseObject

static class Builder
{
    static class Builder
    {

        private Set channelSet;
        private JSONObject data;
        private Long expirationTime;
        private Long expirationTimeInterval;
        private Boolean pushToAndroid;
        private Boolean pushToIOS;
        private ParseQuery query;

        public ParsePush.State build()
        {
            if (data == null)
            {
                throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
            } else
            {
                return new ParsePush.State(this, null);
            }
        }

        public Builder channelSet(Collection collection)
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
            ParsePush.access$000(flag, "channels collection cannot be null");
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
                ParsePush.access$000(flag, "channel cannot be null");
            }
            channelSet = new HashSet(collection);
            query = null;
            return this;
        }

        public Builder data(JSONObject jsonobject)
        {
            data = jsonobject;
            return this;
        }

        public Builder expirationTime(Long long1)
        {
            expirationTime = long1;
            expirationTimeInterval = null;
            return this;
        }

        public Builder expirationTimeInterval(Long long1)
        {
            expirationTimeInterval = long1;
            expirationTime = null;
            return this;
        }

        public Builder pushToAndroid(Boolean boolean1)
        {
            boolean flag;
            if (query == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ParsePush.access$000(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
            pushToAndroid = boolean1;
            return this;
        }

        public Builder pushToIOS(Boolean boolean1)
        {
            boolean flag;
            if (query == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ParsePush.access$000(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
            pushToIOS = boolean1;
            return this;
        }

        public Builder query(ParseQuery parsequery)
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
            ParsePush.access$000(flag, "Cannot target a null query");
            if (pushToIOS == null && pushToAndroid == null)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            ParsePush.access$000(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query"