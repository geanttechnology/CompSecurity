// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.Logger;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event, AssociatedIdentifiers

class AssociateIdentifiersEvent extends Event
{

    private static final String TYPE = "associate_identifiers";
    private final Map ids;

    AssociateIdentifiersEvent(AssociatedIdentifiers associatedidentifiers)
    {
        ids = associatedidentifiers.getIds();
    }

    protected JSONObject getEventData()
    {
        return new JSONObject(ids);
    }

    public String getType()
    {
        return "associate_identifiers";
    }

    public boolean isValid()
    {
        boolean flag = true;
        if (ids.size() > 100)
        {
            Logger.error("Associated identifiers exceeds 100");
            flag = false;
        }
        Iterator iterator = ids.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((String)entry.getKey()).length() > 255)
            {
                Logger.error((new StringBuilder("Associated identifiers key ")).append((String)entry.getKey()).append(" exceeds 255").append("  characters.").toString());
                flag = false;
            }
            if (((String)entry.getValue()).length() > 255)
            {
                Logger.error((new StringBuilder("Associated identifiers for key ")).append((String)entry.getKey()).append(" exceeds 255").append(" characters.").toString());
                flag = false;
            }
        } while (true);
        return flag;
    }
}
