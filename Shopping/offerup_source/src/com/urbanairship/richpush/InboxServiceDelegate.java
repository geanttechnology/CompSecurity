// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestFactory;
import com.urbanairship.http.Response;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushResolver, RichPushManager, RichPushUser, RichPushUpdateService, 
//            RichPushInbox

class InboxServiceDelegate extends com.urbanairship.BaseIntentService.Delegate
{

    private static final String CHANNEL_ID_HEADER = "X-UA-Channel-ID";
    private static final String DELETE_MESSAGES_KEY = "delete";
    private static final String DELETE_MESSAGES_PATH = "api/user/%s/messages/delete/";
    private static final String MARK_READ_MESSAGES_KEY = "mark_as_read";
    private static final String MARK_READ_MESSAGES_PATH = "api/user/%s/messages/unread/";
    private static final String MESSAGES_PATH = "api/user/%s/messages/";
    private static final String MESSAGE_URL = "api/user/%s/messages/message/%s/";
    private final UAirship airship;
    private final String hostUrl;
    private final RequestFactory requestFactory;
    private final RichPushResolver resolver;
    private final RichPushUser user;

    public InboxServiceDelegate(Context context, PreferenceDataStore preferencedatastore)
    {
        this(context, preferencedatastore, new RequestFactory(), new RichPushResolver(context), UAirship.shared());
    }

    public InboxServiceDelegate(Context context, PreferenceDataStore preferencedatastore, RequestFactory requestfactory, RichPushResolver richpushresolver, UAirship uairship)
    {
        super(context, preferencedatastore);
        requestFactory = requestfactory;
        resolver = richpushresolver;
        airship = uairship;
        user = uairship.getRichPushManager().getRichPushUser();
        hostUrl = uairship.getAirshipConfigOptions().hostURL;
    }

    private JSONObject buildMessagesPayload(String s, Set set)
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put(s, new JSONArray());
            String s1 = user.getId();
            String s2;
            for (set = set.iterator(); set.hasNext(); jsonobject.accumulate(s, (new StringBuilder()).append(hostUrl).append(String.format("api/user/%s/messages/message/%s/", new Object[] {
    s1, s2
})).toString()))
            {
                s2 = (String)set.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.info(s.getMessage());
            return null;
        }
        Logger.verbose(jsonobject.toString());
        return jsonobject;
    }

    private void syncDeletedMessageState()
    {
        Set set = resolver.getDeletedMessageIds();
        Object obj;
        if (set.size() != 0)
        {
            if ((obj = RichPushUpdateService.getUserURL("api/user/%s/messages/delete/", new Object[] {
    user.getId()
})) != null)
            {
                Logger.verbose((new StringBuilder("InboxServiceDelegate - Found ")).append(set.size()).append(" messages to delete.").toString());
                JSONObject jsonobject = buildMessagesPayload("delete", set);
                if (jsonobject != null)
                {
                    Logger.verbose((new StringBuilder("InboxServiceDelegate - Deleting inbox messages with payload: ")).append(jsonobject).toString());
                    obj = requestFactory.createRequest("POST", ((java.net.URL) (obj))).setCredentials(user.getId(), user.getPassword()).setRequestBody(jsonobject.toString(), "application/json").setHeader("X-UA-Channel-ID", airship.getPushManager().getChannelId()).setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
                    Logger.verbose((new StringBuilder("InboxServiceDelegate - Delete inbox messages response: ")).append(obj).toString());
                    if (obj != null && ((Response) (obj)).getStatus() == 200)
                    {
                        resolver.deleteMessages(set);
                        return;
                    }
                }
            }
        }
    }

    private void syncReadMessageState()
    {
        Set set = resolver.getReadUpdatedMessageIds();
        Object obj;
        if (set.size() != 0)
        {
            if ((obj = RichPushUpdateService.getUserURL("api/user/%s/messages/unread/", new Object[] {
    user.getId()
})) != null)
            {
                Logger.verbose((new StringBuilder("InboxServiceDelegate - Found ")).append(set.size()).append(" messages to mark read.").toString());
                JSONObject jsonobject = buildMessagesPayload("mark_as_read", set);
                if (jsonobject != null)
                {
                    Logger.verbose((new StringBuilder("InboxServiceDelegate - Marking inbox messages read request with payload: ")).append(jsonobject).toString());
                    obj = requestFactory.createRequest("POST", ((java.net.URL) (obj))).setCredentials(user.getId(), user.getPassword()).setRequestBody(jsonobject.toString(), "application/json").setHeader("X-UA-Channel-ID", airship.getPushManager().getChannelId()).setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
                    Logger.verbose((new StringBuilder("InboxServiceDelegate - Mark inbox messages read response: ")).append(obj).toString());
                    if (obj != null && ((Response) (obj)).getStatus() == 200)
                    {
                        resolver.markMessagesReadOrigin(set);
                        return;
                    }
                }
            }
        }
    }

    private void updateInbox(JsonList jsonlist)
    {
        ArrayList arraylist = new ArrayList();
        HashSet hashset = new HashSet();
        jsonlist = jsonlist.iterator();
        do
        {
            if (!jsonlist.hasNext())
            {
                break;
            }
            JsonValue jsonvalue = (JsonValue)jsonlist.next();
            if (!jsonvalue.isJsonMap())
            {
                Logger.error((new StringBuilder("InboxServiceDelegate - Invalid message payload: ")).append(jsonvalue).toString());
            } else
            {
                String s = jsonvalue.getMap().opt("message_id").getString();
                if (s == null)
                {
                    Logger.error((new StringBuilder("InboxServiceDelegate - Invalid message payload, missing message ID: ")).append(jsonvalue).toString());
                } else
                {
                    hashset.add(s);
                    if (resolver.updateMessage(s, jsonvalue) != 1)
                    {
                        arraylist.add(jsonvalue);
                    }
                }
            }
        } while (true);
        if (arraylist.size() > 0)
        {
            resolver.insertMessages(arraylist);
        }
        jsonlist = resolver.getMessageIds();
        jsonlist.removeAll(hashset);
        resolver.deleteMessages(jsonlist);
        airship.getRichPushManager().getRichPushInbox().refresh();
    }

    private boolean updateMessages()
    {
        Object obj;
        Response response;
        Logger.info("Refreshing inbox messages.");
        obj = RichPushUpdateService.getUserURL("api/user/%s/messages/", new Object[] {
            user.getId()
        });
        if (obj == null)
        {
            return false;
        }
        Logger.verbose("InboxServiceDelegate - Fetching inbox messages.");
        response = requestFactory.createRequest("GET", ((java.net.URL) (obj))).setCredentials(user.getId(), user.getPassword()).setHeader("Accept", "application/vnd.urbanairship+json; version=3;").setHeader("X-UA-Channel-ID", airship.getPushManager().getChannelId()).setIfModifiedSince(getDataStore().getLong("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME", 0L)).execute();
        Logger.verbose((new StringBuilder("InboxServiceDelegate - Fetch inbox messages response: ")).append(response).toString());
        int i;
        if (response == null)
        {
            i = -1;
        } else
        {
            i = response.getStatus();
        }
        if (i == 304)
        {
            Logger.info("Inbox messages already up-to-date. ");
            return true;
        }
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        obj = null;
        JsonMap jsonmap;
        try
        {
            jsonmap = JsonValue.parseString(response.getResponseBody()).getMap();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.error((new StringBuilder("Failed to update inbox. Unable to parse response body: ")).append(response.getResponseBody()).toString());
            return false;
        }
        if (jsonmap == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        obj = jsonmap.get("messages").getList();
        if (obj == null || ((JsonList) (obj)).size() == 0)
        {
            Logger.info("Inbox message list is empty.");
        } else
        {
            Logger.info((new StringBuilder("Received ")).append(((JsonList) (obj)).size()).append(" inbox messages.").toString());
            updateInbox(((JsonList) (obj)));
            getDataStore().put("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME", response.getLastModifiedTime());
        }
        return true;
        Logger.info("Unable to update inbox messages.");
        return false;
    }

    protected void onHandleIntent(Intent intent)
    {
        String s;
        byte byte0;
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 36
    //                   1699160881: 61
    //                   2078637888: 76;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_76;
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            if (!RichPushUser.isCreated())
            {
                Logger.debug("InboxServiceDelegate - User has not been created, canceling messages update");
                RichPushUpdateService.respond(intent, false);
                return;
            }
            RichPushUpdateService.respond(intent, updateMessages());
            // fall through

        case 1: // '\001'
            syncReadMessageState();
            syncDeletedMessageState();
            return;
        }
_L2:
        if (s.equals("com.urbanairship.richpush.MESSAGES_UPDATE"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("com.urbanairship.richpush.SYNC_MESSAGE_STATE"))
        {
            byte0 = 1;
        }
          goto _L4
    }
}
