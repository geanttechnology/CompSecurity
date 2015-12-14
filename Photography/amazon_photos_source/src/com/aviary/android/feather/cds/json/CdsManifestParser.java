// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds.json;

import com.aviary.android.feather.common.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds.json:
//            CdsJsonParser

public class CdsManifestParser extends CdsJsonParser
{
    public static class ManifestPackItem
    {

        final String identifier;
        final String versionKey;

        public String getIdentifier()
        {
            return identifier;
        }

        public String getVersionKey()
        {
            return versionKey;
        }

        public String toString()
        {
            return (new StringBuilder()).append("ManifestPackItem{ identifier: ").append(identifier).append(", versionKey: ").append(versionKey).append("}").toString();
        }

        public ManifestPackItem(JSONObject jsonobject, boolean flag)
            throws JSONException
        {
            identifier = jsonobject.getString("identifier");
            if (flag)
            {
                versionKey = jsonobject.getString("versionKey");
                return;
            } else
            {
                versionKey = jsonobject.optString("versionKey");
                return;
            }
        }
    }


    private String assetsBaseURL;
    HashMap availableSubscriptions;
    HashMap deletedPacks;
    HashMap enabledMessages;
    HashMap enabledMessagesNames;
    HashMap enabledPacks;
    HashMap enabledPacksNames;
    private String formatListId;
    private boolean mHasContent;
    List permissions;
    private String versionKey;

    public CdsManifestParser()
    {
        enabledPacks = new HashMap();
        deletedPacks = new HashMap();
        enabledPacksNames = new HashMap();
        enabledMessages = new HashMap();
        enabledMessagesNames = new HashMap();
        permissions = new ArrayList();
        availableSubscriptions = new HashMap();
    }

    private void parsePackArray(JSONObject jsonobject, String s, List list, HashMap hashmap, boolean flag)
        throws JSONException
    {
        jsonobject = jsonobject.getJSONArray(s);
        for (int i = 0; i < jsonobject.length(); i++)
        {
            s = new ManifestPackItem(jsonobject.getJSONObject(i), flag);
            list.add(s);
            if (hashmap != null)
            {
                hashmap.put(s.getIdentifier(), Boolean.valueOf(true));
            }
        }

    }

    private void parseSubscriptionArray(JSONArray jsonarray, List list, HashMap hashmap, boolean flag)
        throws JSONException
    {
        for (int i = 0; i < jsonarray.length(); i++)
        {
            ManifestPackItem manifestpackitem = new ManifestPackItem(jsonarray.getJSONObject(i), flag);
            list.add(manifestpackitem);
            if (hashmap != null)
            {
                hashmap.put(manifestpackitem.getIdentifier(), Boolean.valueOf(true));
            }
        }

    }

    public boolean containsEnabledPack(String s)
    {
        return enabledPacksNames.containsKey(s);
    }

    public boolean containsMessage(String s)
    {
        return enabledMessagesNames.containsKey(s);
    }

    public String getAssetsBaseURL()
    {
        return assetsBaseURL;
    }

    public HashMap getAvailableSubscriptions()
    {
        return availableSubscriptions;
    }

    public List getDeletedPacks()
    {
        ArrayList arraylist = new ArrayList();
        List list = getDeletedPacks("effects");
        if (list != null)
        {
            arraylist.addAll(list);
        }
        list = getDeletedPacks("frames");
        if (list != null)
        {
            arraylist.addAll(list);
        }
        list = getDeletedPacks("stickers");
        if (list != null)
        {
            arraylist.addAll(list);
        }
        list = getDeletedPacks("overlays");
        if (list != null)
        {
            arraylist.addAll(list);
        }
        return arraylist;
    }

    public List getDeletedPacks(String s)
    {
        return (List)deletedPacks.get(s);
    }

    public HashMap getEnabledPacks()
    {
        return enabledPacks;
    }

    public List getEnabledPacks(String s)
    {
        return (List)enabledPacks.get(s);
    }

    public String getFormatListId()
    {
        return formatListId;
    }

    public HashMap getMessages()
    {
        return enabledMessages;
    }

    public List getMessages(String s)
    {
        return (List)enabledMessages.get(s);
    }

    public List getPermissions()
    {
        Collections.sort(permissions);
        return permissions;
    }

    public String getPermissionsKey()
    {
        return StringUtils.hashCode(permissions);
    }

    public String getVersionKey()
    {
        return versionKey;
    }

    public boolean hasAvailableSubscriptions()
    {
        return availableSubscriptions.size() > 0;
    }

    public boolean hasContent()
    {
        return mHasContent;
    }

    public boolean hasDeletedPacks()
    {
        return deletedPacks.size() > 0;
    }

    public boolean hasEnabledPacks()
    {
        return enabledPacks.size() > 0;
    }

    public boolean hasMessages()
    {
        return enabledMessages.size() > 0;
    }

    protected void onParseJson(JSONObject jsonobject)
        throws JSONException
    {
        assetsBaseURL = jsonobject.getString("assetsBaseURL");
        versionKey = jsonobject.getString("versionKey");
        formatListId = jsonobject.getString("formatListId");
        Object obj = jsonobject.optJSONObject("packs");
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mHasContent = flag;
        if (obj != null)
        {
            onParsePackEntry(((JSONObject) (obj)).getJSONObject("effects"), "effects");
            onParsePackEntry(((JSONObject) (obj)).getJSONObject("frames"), "frames");
            onParsePackEntry(((JSONObject) (obj)).getJSONObject("stickers"), "stickers");
            onParsePackEntry(((JSONObject) (obj)).getJSONObject("overlays"), "overlays");
        }
        obj = jsonobject.optJSONObject("messages");
        if (obj != null)
        {
            onParseMessageEntry(((JSONObject) (obj)).getJSONObject("launch"), "launch");
        }
        obj = jsonobject.optJSONArray("subscriptions");
        if (obj != null)
        {
            onParseSubscriptionEntry(((JSONArray) (obj)));
        }
        jsonobject = jsonobject.optJSONArray("permissions");
        if (jsonobject != null)
        {
            onParsePermissions(jsonobject);
        }
    }

    protected void onParseMessageEntry(JSONObject jsonobject, String s)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        parsePackArray(jsonobject, "enabled", arraylist, enabledMessagesNames, true);
        if (arraylist.size() > 0)
        {
            enabledMessages.put(s, arraylist);
        }
    }

    protected void onParsePackEntry(JSONObject jsonobject, String s)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        parsePackArray(jsonobject, "enabled", arraylist, enabledPacksNames, true);
        if (arraylist.size() > 0)
        {
            enabledPacks.put(s, arraylist);
        }
        arraylist = new ArrayList();
        parsePackArray(jsonobject, "deleted", arraylist, null, false);
        if (arraylist.size() > 0)
        {
            deletedPacks.put(s, arraylist);
        }
    }

    protected void onParsePermissions(JSONArray jsonarray)
    {
        int i = 0;
        while (i < jsonarray.length()) 
        {
            try
            {
                permissions.add(jsonarray.getString(i));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            i++;
        }
    }

    protected void onParseSubscriptionEntry(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        parseSubscriptionArray(jsonarray, arraylist, enabledPacksNames, true);
        if (arraylist.size() > 0)
        {
            availableSubscriptions.put("enabled", arraylist);
        }
    }
}
