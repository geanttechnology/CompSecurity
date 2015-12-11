// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import com.groupon.util.SortableCard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            CollectionCardAttribute

public class DealCollection
    implements SortableCard
{

    public static final String UUID = "uuid";
    private static final String UUID_COMPONENTS_SEPARATOR = ":";
    public Map cardAttributes;
    protected Collection cardDetails;
    public String channel;
    public int derivedActualPosition;
    public int derivedTrackingPosition;
    public Long primaryKey;
    public String rapiFilter;
    public String templateId;
    public String templateVersion;
    public String templateView;
    public String uuid;

    public DealCollection()
    {
        uuid = "";
        templateId = "";
        templateView = "";
        templateVersion = "";
        rapiFilter = "";
        cardAttributes = Collections.emptyMap();
        cardDetails = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor()
    {
        String s = getParentUUID();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = cardAttributes.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            obj = CollectionCardAttribute.create(s, (String)((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue());
            if (obj != null)
            {
                arraylist.add(obj);
            }
        } while (true);
        updateCardDetails(arraylist);
    }

    public int cardPosition()
    {
        return derivedActualPosition;
    }

    public Collection getCardDetails()
    {
        return cardDetails;
    }

    public String getParentUUID()
    {
        return Strings.join(":", new String[] {
            channel, uuid
        });
    }

    public String getValue(String s, String s1)
    {
        Iterator iterator = cardDetails.iterator();
        Object obj;
        do
        {
            obj = s1;
            if (!iterator.hasNext())
            {
                break;
            }
            obj = (CollectionCardAttribute)iterator.next();
            if (!((CollectionCardAttribute) (obj)).name.equals(s))
            {
                continue;
            }
            obj = ((CollectionCardAttribute) (obj)).value;
            break;
        } while (true);
        return ((String) (obj));
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(getClass().getSimpleName());
        stringbuilder.append("{").append(Strings.join(",", Arrays.asList(new String[] {
            templateView, templateVersion, templateId, rapiFilter
        }))).append("}");
        return stringbuilder.toString();
    }

    public void updateCardDetails(Collection collection)
    {
        if (collection == null)
        {
            cardDetails = Collections.emptyList();
            return;
        }
        for (Iterator iterator = collection.iterator(); iterator.hasNext();)
        {
            ((CollectionCardAttribute)iterator.next()).parentCollection = this;
        }

        cardDetails = collection;
    }
}
