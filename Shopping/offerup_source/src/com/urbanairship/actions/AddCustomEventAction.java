// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions;

import android.os.Bundle;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.CustomEvent;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.richpush.RichPushInbox;
import com.urbanairship.richpush.RichPushManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.urbanairship.actions:
//            Action, ActionArguments, ActionValue, ActionResult

public class AddCustomEventAction extends Action
{

    public static final String DEFAULT_REGISTRY_NAME = "add_custom_event_action";

    public AddCustomEventAction()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        if (actionarguments.getValue().getMap() != null)
        {
            if (actionarguments.getValue().getMap().get("event_name") == null)
            {
                Logger.debug("CustomEventAction requires an event name in the event data.");
                return false;
            } else
            {
                return true;
            }
        } else
        {
            Logger.debug("CustomEventAction requires a map of event data.");
            return false;
        }
    }

    public ActionResult perform(ActionArguments actionarguments)
    {
        JsonMap jsonmap = actionarguments.getValue().getMap();
        Object obj = jsonmap.opt("event_name").getString();
        String s = jsonmap.opt("event_value").getString();
        double d = jsonmap.opt("event_value").getDouble(0.0D);
        String s3 = jsonmap.opt("transaction_id").getString();
        String s1 = jsonmap.opt("interaction_type").getString();
        String s2 = jsonmap.opt("interaction_id").getString();
        jsonmap = jsonmap.opt("properties").getMap();
        obj = (new com.urbanairship.analytics.CustomEvent.Builder(((String) (obj)))).setTransactionId(s3).setInteraction(s1, s2).setAttribution((PushMessage)actionarguments.getMetadata().getParcelable("com.urbanairship.PUSH_MESSAGE"));
        if (s != null)
        {
            ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).setEventValue(s);
        } else
        {
            ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).setEventValue(d);
        }
        if (s2 == null && s1 == null)
        {
            actionarguments = actionarguments.getMetadata().getString("com.urbanairship.RICH_PUSH_ID_METADATA");
            actionarguments = UAirship.shared().getRichPushManager().getRichPushInbox().getMessage(actionarguments);
            if (actionarguments != null)
            {
                ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).setInteraction(actionarguments);
            }
        }
        if (jsonmap != null)
        {
            actionarguments = jsonmap.iterator();
            do
            {
                if (!actionarguments.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)actionarguments.next();
                if (((JsonValue)entry.getValue()).isBoolean())
                {
                    ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).addProperty((String)entry.getKey(), ((JsonValue)entry.getValue()).getBoolean(false));
                } else
                if (((JsonValue)entry.getValue()).isDouble())
                {
                    ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).addProperty((String)entry.getKey(), ((JsonValue)entry.getValue()).getDouble(0.0D));
                } else
                if (((JsonValue)entry.getValue()).isNumber())
                {
                    ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).addProperty((String)entry.getKey(), ((JsonValue)entry.getValue()).getNumber().longValue());
                } else
                if (((JsonValue)entry.getValue()).isString())
                {
                    ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).addProperty((String)entry.getKey(), ((JsonValue)entry.getValue()).getString());
                } else
                if (((JsonValue)entry.getValue()).isJsonList())
                {
                    ArrayList arraylist = new ArrayList();
                    for (Iterator iterator = ((JsonValue)entry.getValue()).getList().iterator(); iterator.hasNext();)
                    {
                        JsonValue jsonvalue = (JsonValue)iterator.next();
                        if (jsonvalue.isString())
                        {
                            arraylist.add(jsonvalue.getString());
                        } else
                        {
                            arraylist.add(jsonvalue.toString());
                        }
                    }

                    ((com.urbanairship.analytics.CustomEvent.Builder) (obj)).addProperty((String)entry.getKey(), arraylist);
                }
            } while (true);
        }
        if (((com.urbanairship.analytics.CustomEvent.Builder) (obj)).addEvent().isValid())
        {
            return ActionResult.newEmptyResult();
        } else
        {
            return ActionResult.newErrorResult(new IllegalArgumentException("Unable to add custom event. Event is invalid."));
        }
    }
}
