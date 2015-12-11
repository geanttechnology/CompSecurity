// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.gdata.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParsePush, ParseQuery, ParseInstallation, ParseObject

static class 
{

    private Set channelSet;
    private JSONObject data;
    private Long expirationTime;
    private Long expirationTimeInterval;
    private Boolean pushToAndroid;
    private Boolean pushToIOS;
    private ParseQuery query;

    public  build()
    {
        if (data == null)
        {
            throw new IllegalArgumentException("Cannot send a push without calling either setMessage or setData");
        } else
        {
            return new (this, null);
        }
    }

    public  channelSet(Collection collection)
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
        channelSet = new HashSet(collection);
        query = null;
        return this;
    }

    public query data(JSONObject jsonobject)
    {
        data = jsonobject;
        return this;
    }

    public data expirationTime(Long long1)
    {
        expirationTime = long1;
        expirationTimeInterval = null;
        return this;
    }

    public expirationTimeInterval expirationTimeInterval(Long long1)
    {
        expirationTimeInterval = long1;
        expirationTime = null;
        return this;
    }

    public expirationTime pushToAndroid(Boolean boolean1)
    {
        boolean flag;
        if (query == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        pushToAndroid = boolean1;
        return this;
    }

    public pushToAndroid pushToIOS(Boolean boolean1)
    {
        boolean flag;
        if (query == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Cannot set push targets (i.e. setPushToAndroid or setPushToIOS) when pushing to a query");
        pushToIOS = boolean1;
        return this;
    }

    public pushToIOS query(ParseQuery parsequery)
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
        return this;
    }








    ()
    {
    }
}
