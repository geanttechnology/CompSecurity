// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.actions.tags;

import com.urbanairship.UAirship;
import com.urbanairship.actions.Action;
import com.urbanairship.actions.ActionArguments;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseTagsAction extends Action
{

    public BaseTagsAction()
    {
    }

    public boolean acceptsArguments(ActionArguments actionarguments)
    {
        return getTags(actionarguments) != null;
    }

    protected PushManager getPushManager()
    {
        return UAirship.shared().getPushManager();
    }

    protected Set getTags(ActionArguments actionarguments)
    {
        if (!actionarguments.getValue().isNull())
        {
            if (actionarguments.getValue().getString() != null)
            {
                HashSet hashset = new HashSet();
                hashset.add(String.valueOf(actionarguments.getValue().getString()));
                return hashset;
            }
            if (actionarguments.getValue().getList() != null)
            {
                HashSet hashset1 = new HashSet();
                actionarguments = actionarguments.getValue().getList().iterator();
                do
                {
                    if (!actionarguments.hasNext())
                    {
                        break;
                    }
                    JsonValue jsonvalue = (JsonValue)actionarguments.next();
                    if (jsonvalue.getString() != null)
                    {
                        hashset1.add(jsonvalue.getString());
                    }
                } while (true);
                return hashset1;
            }
        }
        return null;
    }
}
