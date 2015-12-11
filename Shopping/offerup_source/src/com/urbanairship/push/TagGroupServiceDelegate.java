// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.http.Response;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.urbanairship.push:
//            TagGroupsAPIClient, PushManager, TagUtils, NamedUser

class TagGroupServiceDelegate extends com.urbanairship.BaseIntentService.Delegate
{

    static final String PENDING_CHANNEL_ADD_TAG_GROUPS_KEY = "com.urbanairship.push.PENDING_ADD_TAG_GROUPS";
    static final String PENDING_CHANNEL_REMOVE_TAG_GROUPS_KEY = "com.urbanairship.push.PENDING_REMOVE_TAG_GROUPS";
    static final String PENDING_NAMED_USER_ADD_TAG_GROUPS_KEY = "com.urbanairship.nameduser.PENDING_ADD_TAG_GROUPS_KEY";
    static final String PENDING_NAMED_USER_REMOVE_TAG_GROUPS_KEY = "com.urbanairship.nameduser.PENDING_REMOVE_TAG_GROUPS_KEY";
    private final TagGroupsAPIClient client;
    private final NamedUser namedUser;
    private final PushManager pushManager;

    public TagGroupServiceDelegate(Context context, PreferenceDataStore preferencedatastore)
    {
        this(context, preferencedatastore, new TagGroupsAPIClient(UAirship.shared().getAirshipConfigOptions()), UAirship.shared().getPushManager(), UAirship.shared().getPushManager().getNamedUser());
    }

    public TagGroupServiceDelegate(Context context, PreferenceDataStore preferencedatastore, TagGroupsAPIClient taggroupsapiclient, PushManager pushmanager, NamedUser nameduser)
    {
        super(context, preferencedatastore);
        client = taggroupsapiclient;
        pushManager = pushmanager;
        namedUser = nameduser;
    }

    private void combineTags(Bundle bundle, Map map, Map map1)
    {
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            java.util.ArrayList arraylist = bundle.getStringArrayList(s);
            if (arraylist != null)
            {
                if (map.containsKey(s))
                {
                    ((Set)map.get(s)).addAll(arraylist);
                } else
                {
                    map.put(s, new HashSet(arraylist));
                }
                if (map1.containsKey(s))
                {
                    ((Set)map1.get(s)).removeAll(arraylist);
                }
            }
        } while (true);
    }

    private Map getPendingTagChanges(String s)
    {
        Object obj = null;
        JsonValue jsonvalue = JsonValue.parseString(getDataStore().getString(s, null));
        s = jsonvalue;
_L2:
        return TagUtils.convertToTagsMap(s);
        JsonException jsonexception;
        jsonexception;
        Logger.error("Unable to parse pending tag groups.", jsonexception);
        getDataStore().remove(s);
        s = obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void logTagGroupResponseIssues(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!(s = JsonValue.parseString(s)).isJsonMap()) goto _L1; else goto _L3
_L3:
        if (s.getMap().containsKey("warnings"))
        {
            JsonValue jsonvalue;
            for (Iterator iterator = s.getMap().get("warnings").getList().iterator(); iterator.hasNext(); Logger.info((new StringBuilder("Tag Groups warnings: ")).append(jsonvalue).toString()))
            {
                jsonvalue = (JsonValue)iterator.next();
            }

        }
        continue; /* Loop/switch isn't completed */
        s;
        Logger.error("Unable to parse tag group response", s);
        return;
        if (!s.getMap().containsKey("error")) goto _L1; else goto _L4
_L4:
        Logger.info((new StringBuilder("Tag Groups error: ")).append(s.getMap().get("error")).toString());
        return;
    }

    private void onClearPendingNamedUserTags()
    {
        getDataStore().remove("com.urbanairship.nameduser.PENDING_ADD_TAG_GROUPS_KEY");
        getDataStore().remove("com.urbanairship.nameduser.PENDING_REMOVE_TAG_GROUPS_KEY");
    }

    private void onUpdateTagGroups(Intent intent)
    {
        boolean flag = intent.getAction().equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS");
        String s;
        String s1;
        Object obj;
        Map map;
        Map map1;
        if (flag)
        {
            s1 = "com.urbanairship.push.PENDING_ADD_TAG_GROUPS";
            s = "com.urbanairship.push.PENDING_REMOVE_TAG_GROUPS";
        } else
        {
            s1 = "com.urbanairship.nameduser.PENDING_ADD_TAG_GROUPS_KEY";
            s = "com.urbanairship.nameduser.PENDING_REMOVE_TAG_GROUPS_KEY";
        }
        map = getPendingTagChanges(s1);
        map1 = getPendingTagChanges(s);
        obj = intent.getBundleExtra("com.urbanairship.push.EXTRA_ADD_TAG_GROUPS");
        if (obj != null)
        {
            combineTags(((Bundle) (obj)), map, map1);
            intent.removeExtra("com.urbanairship.push.EXTRA_ADD_TAG_GROUPS");
        }
        obj = intent.getBundleExtra("com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS");
        if (obj != null)
        {
            combineTags(((Bundle) (obj)), map1, map);
            intent.removeExtra("com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS");
        }
        if (map.isEmpty() && map1.isEmpty())
        {
            getDataStore().remove(s1);
            getDataStore().remove(s);
            return;
        }
        if (flag)
        {
            obj = pushManager.getChannelId();
            if (obj == null)
            {
                Logger.debug("Unable to update tag groups until a channel is created. Saved pending tag groups.");
                storePendingTagChanges(s1, map);
                storePendingTagChanges(s, map1);
                return;
            }
            obj = client.updateChannelTags(((String) (obj)), map, map1);
        } else
        {
            if (namedUser.getId() == null)
            {
                Logger.verbose("Failed to update named user tags due to null named user ID. Saved pending tag groups.");
                storePendingTagChanges(s1, map);
                storePendingTagChanges(s, map1);
                return;
            }
            obj = client.updateNamedUserTags(namedUser.getId(), map, map1);
        }
        if (obj == null || UAHttpStatusUtil.inServerErrorRange(((Response) (obj)).getStatus()))
        {
            Logger.info("Failed to update tag groups, will retry. Saved pending tag groups.");
            storePendingTagChanges(s1, map);
            storePendingTagChanges(s, map1);
            retryIntent(intent);
            return;
        }
        if (UAHttpStatusUtil.inSuccessRange(((Response) (obj)).getStatus()))
        {
            Logger.info((new StringBuilder("Update tag groups succeeded with status: ")).append(((Response) (obj)).getStatus()).toString());
            logTagGroupResponseIssues(((Response) (obj)).getResponseBody());
            getDataStore().remove(s1);
            getDataStore().remove(s);
            return;
        }
        Logger.info((new StringBuilder("Update tag groups failed with status: ")).append(((Response) (obj)).getStatus()).toString());
        logTagGroupResponseIssues(((Response) (obj)).getResponseBody());
        if (((Response) (obj)).getStatus() == 403 || ((Response) (obj)).getStatus() == 400)
        {
            getDataStore().remove(s1);
            getDataStore().remove(s);
            return;
        } else
        {
            storePendingTagChanges(s1, map);
            storePendingTagChanges(s, map1);
            return;
        }
    }

    private void storePendingTagChanges(String s, Map map)
    {
        getDataStore().put(s, JsonValue.wrap(map, null));
    }

    protected void onHandleIntent(Intent intent)
    {
        String s;
        byte byte0;
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 44
    //                   -832939733: 102
    //                   962413331: 87
    //                   1048059625: 73;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_102;
_L5:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
        case 1: // '\001'
            onUpdateTagGroups(intent);
            return;

        case 2: // '\002'
            onClearPendingNamedUserTags();
            break;
        }
        break MISSING_BLOCK_LABEL_127;
_L4:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS"))
        {
            byte0 = 0;
        }
          goto _L5
_L3:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS"))
        {
            byte0 = 2;
        }
          goto _L5
    }
}
