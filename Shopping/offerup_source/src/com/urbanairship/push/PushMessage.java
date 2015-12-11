// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.Logger;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.iam.InAppMessage;
import com.urbanairship.util.UAMathUtil;
import com.urbanairship.util.UAStringUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PushMessage
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final String EXTRA_ACTIONS = "com.urbanairship.actions";
    public static final String EXTRA_ALERT = "com.urbanairship.push.ALERT";
    public static final String EXTRA_CATEGORY = "com.urbanairship.category";
    public static final String EXTRA_EXPIRATION = "com.urbanairship.push.EXPIRATION";
    public static final String EXTRA_INTERACTIVE_ACTIONS = "com.urbanairship.interactive_actions";
    public static final String EXTRA_INTERACTIVE_TYPE = "com.urbanairship.interactive_type";
    public static final String EXTRA_IN_APP_MESSAGE = "com.urbanairship.in_app";
    public static final String EXTRA_LOCAL_ONLY = "com.urbanairship.local_only";
    static final String EXTRA_PING = "com.urbanairship.push.PING";
    public static final String EXTRA_PRIORITY = "com.urbanairship.priority";
    public static final String EXTRA_PUBLIC_NOTIFICATION = "com.urbanairship.public_notification";
    public static final String EXTRA_PUSH_ID = "com.urbanairship.push.CANONICAL_PUSH_ID";
    public static final String EXTRA_SEND_ID = "com.urbanairship.push.PUSH_ID";
    public static final String EXTRA_STYLE = "com.urbanairship.style";
    public static final String EXTRA_SUMMARY = "com.urbanairship.summary";
    public static final String EXTRA_TITLE = "com.urbanairship.title";
    public static final String EXTRA_VISIBILITY = "com.urbanairship.visibility";
    public static final String EXTRA_WEARABLE = "com.urbanairship.wearable";
    private static final List INBOX_ACTION_NAMES = Arrays.asList(new String[] {
        "open_mc_action", "^mc", "open_mc_overlay_action", "^mco"
    });
    static final int MAX_PRIORITY = 2;
    static final int MAX_VISIBILITY = 1;
    static final int MIN_PRIORITY = -2;
    static final int MIN_VISIBILITY = -1;
    static final int VISIBILITY_PUBLIC = 1;
    private final Bundle pushBundle;

    public PushMessage(Bundle bundle)
    {
        pushBundle = bundle;
    }

    public int describeContents()
    {
        return 0;
    }

    public Map getActions()
    {
        HashMap hashmap;
        String s = pushBundle.getString("com.urbanairship.actions");
        hashmap = new HashMap();
        Object obj;
        java.util.Map.Entry entry;
        try
        {
            obj = JsonValue.parseString(s).getMap();
        }
        catch (JsonException jsonexception)
        {
            Logger.error((new StringBuilder("Unable to parse action payload: ")).append(s).toString());
            return hashmap;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        for (obj = ((JsonMap) (obj)).iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(entry.getKey(), new ActionValue((JsonValue)entry.getValue())))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        if (!UAStringUtil.isEmpty(getRichPushMessageId()) && Collections.disjoint(hashmap.keySet(), INBOX_ACTION_NAMES))
        {
            hashmap.put("^mc", ActionValue.wrap(getRichPushMessageId()));
        }
        return hashmap;
    }

    public String getActionsPayload()
    {
        return pushBundle.getString("com.urbanairship.actions");
    }

    public String getAlert()
    {
        return pushBundle.getString("com.urbanairship.push.ALERT");
    }

    public String getCanonicalPushId()
    {
        return pushBundle.getString("com.urbanairship.push.CANONICAL_PUSH_ID");
    }

    public String getCategory()
    {
        return pushBundle.getString("com.urbanairship.category");
    }

    public InAppMessage getInAppMessage()
    {
        if (!pushBundle.containsKey("com.urbanairship.in_app"))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        Object obj1 = InAppMessage.parseJson(pushBundle.getString("com.urbanairship.in_app"));
        if (obj1 == null)
        {
            return null;
        }
        Object obj;
        obj = (new com.urbanairship.push.iam.InAppMessage.Builder(((InAppMessage) (obj1)))).setId(getSendId());
        if (!UAStringUtil.isEmpty(getRichPushMessageId()) && Collections.disjoint(((InAppMessage) (obj1)).getClickActionValues().keySet(), INBOX_ACTION_NAMES))
        {
            obj1 = new HashMap(((InAppMessage) (obj1)).getClickActionValues());
            ((HashMap) (obj1)).put("^mc", new ActionValue(JsonValue.wrap(getRichPushMessageId(), null)));
            ((com.urbanairship.push.iam.InAppMessage.Builder) (obj)).setClickActionValues(((Map) (obj1)));
        }
        obj = ((com.urbanairship.push.iam.InAppMessage.Builder) (obj)).create();
        return ((InAppMessage) (obj));
        JsonException jsonexception;
        jsonexception;
        Logger.error("PushMessage - unable to create in-app message from push payload", jsonexception);
        return null;
    }

    public String getInteractiveActionsPayload()
    {
        return pushBundle.getString("com.urbanairship.interactive_actions");
    }

    public String getInteractiveNotificationType()
    {
        return pushBundle.getString("com.urbanairship.interactive_type");
    }

    public int getPriority()
    {
        int i;
        try
        {
            i = UAMathUtil.constrain(Integer.parseInt(pushBundle.getString("com.urbanairship.priority")), -2, 2);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 0;
        }
        return i;
    }

    public String getPublicNotificationPayload()
    {
        return pushBundle.getString("com.urbanairship.public_notification");
    }

    public Bundle getPushBundle()
    {
        return new Bundle(pushBundle);
    }

    public String getRichPushMessageId()
    {
        return pushBundle.getString("_uamid");
    }

    public String getSendId()
    {
        return pushBundle.getString("com.urbanairship.push.PUSH_ID");
    }

    public String getStylePayload()
    {
        return pushBundle.getString("com.urbanairship.style");
    }

    public String getSummary()
    {
        return pushBundle.getString("com.urbanairship.summary");
    }

    public String getTitle()
    {
        return pushBundle.getString("com.urbanairship.title");
    }

    public int getVisibility()
    {
        int i;
        try
        {
            i = UAMathUtil.constrain(Integer.parseInt(pushBundle.getString("com.urbanairship.visibility")), -1, 1);
        }
        catch (NumberFormatException numberformatexception)
        {
            return 1;
        }
        return i;
    }

    public String getWearablePayload()
    {
        return pushBundle.getString("com.urbanairship.wearable");
    }

    boolean isExpired()
    {
        String s;
        s = pushBundle.getString("com.urbanairship.push.EXPIRATION");
        if (UAStringUtil.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        Logger.debug((new StringBuilder("Notification expiration time is \"")).append(s).append("\"").toString());
        long l;
        long l1;
        l = Long.parseLong(s);
        l1 = System.currentTimeMillis();
        if (l * 1000L < l1)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_90;
        NumberFormatException numberformatexception;
        numberformatexception;
        Logger.debug((new StringBuilder("Ignoring malformed expiration time: ")).append(numberformatexception.getMessage()).toString());
        return false;
    }

    public boolean isLocalOnly()
    {
        return Boolean.parseBoolean(pushBundle.getString("com.urbanairship.local_only"));
    }

    boolean isPing()
    {
        return pushBundle.get("com.urbanairship.push.PING") != null;
    }

    public String toString()
    {
        return pushBundle.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeBundle(pushBundle);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final PushMessage createFromParcel(Parcel parcel)
        {
            return new PushMessage(parcel.readBundle());
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final PushMessage[] newArray(int i)
        {
            return new PushMessage[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
