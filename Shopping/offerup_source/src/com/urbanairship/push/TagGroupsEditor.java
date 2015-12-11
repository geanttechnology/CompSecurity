// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.urbanairship.push:
//            PushService, TagUtils

public class TagGroupsEditor
{

    private final String action;
    protected final Map tagsToAdd = new HashMap();
    protected final Map tagsToRemove = new HashMap();

    TagGroupsEditor(String s)
    {
        action = s;
    }

    public TagGroupsEditor addTag(String s, String s1)
    {
        return addTags(s, new HashSet(Arrays.asList(new String[] {
            s1
        })));
    }

    public TagGroupsEditor addTags(String s, Set set)
    {
        if (!isValid(s, set))
        {
            return this;
        } else
        {
            updateTags(tagsToAdd, tagsToRemove, s, set);
            return this;
        }
    }

    public void apply()
    {
        if (tagsToAdd.isEmpty() && tagsToRemove.isEmpty())
        {
            Logger.info("Skipping tag group update because tags to add and tags to remove are both empty.");
            return;
        } else
        {
            Intent intent = (new Intent(UAirship.getApplicationContext(), com/urbanairship/push/PushService)).setAction(action).putExtra("com.urbanairship.push.EXTRA_ADD_TAG_GROUPS", convertToBundle(tagsToAdd)).putExtra("com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS", convertToBundle(tagsToRemove));
            UAirship.getApplicationContext().startService(intent);
            return;
        }
    }

    Bundle convertToBundle(Map map)
    {
        Bundle bundle = new Bundle();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); bundle.putStringArrayList((String)entry.getKey(), new ArrayList((Collection)entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return bundle;
    }

    boolean isValid(String s, Set set)
    {
        boolean flag = true;
        if (UAStringUtil.isEmpty(s))
        {
            Logger.warn("The tag group ID string cannot be null.");
            flag = false;
        }
        if (TagUtils.normalizeTags(set).isEmpty())
        {
            Logger.warn("The tags cannot be empty");
            return false;
        } else
        {
            return flag;
        }
    }

    public TagGroupsEditor removeTag(String s, String s1)
    {
        return removeTags(s, new HashSet(Arrays.asList(new String[] {
            s1
        })));
    }

    public TagGroupsEditor removeTags(String s, Set set)
    {
        if (!isValid(s, set))
        {
            return this;
        } else
        {
            updateTags(tagsToRemove, tagsToAdd, s, set);
            return this;
        }
    }

    void updateTags(Map map, Map map1, String s, Set set)
    {
        set = TagUtils.normalizeTags(set);
        if (map1.containsKey(s))
        {
            ((Set)map1.get(s)).removeAll(set);
            if (((Set)map1.get(s)).size() == 0)
            {
                map1.remove(s);
            }
        }
        if (map.containsKey(s))
        {
            ((Set)map.get(s)).addAll(set);
            if (((Set)map.get(s)).size() == 0)
            {
                map.remove(s);
            }
            return;
        } else
        {
            map.put(s, new HashSet(set));
            return;
        }
    }
}
