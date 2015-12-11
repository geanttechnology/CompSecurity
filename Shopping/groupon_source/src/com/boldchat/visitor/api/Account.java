// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.RequestUtil;
import com.boldchat.visitor.api.internal.RestAPIRequest;
import com.boldchat.visitor.api.internal.ResultListener;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.boldchat.visitor.api:
//            CreateChatListener, ChatAvailabilityListener, Chat, PreChat, 
//            UnavailableReason, UnavailableForm

public class Account
{

    private static long lastAvailabilityCheck = 0L;
    private static JSONObject lastAvailabilityResponse = null;
    private long accountID;
    private String apiAccessKey;
    private long chatWindowID;
    private long departmentID;
    private Map extraData;
    private String language;
    private String serverSet;
    private boolean skipPreChat;
    private int timeout;
    private long visitorID;
    private long websiteDefinitionID;

    public Account(long l, String s)
    {
        skipPreChat = false;
        timeout = 30000;
        accountID = l;
        apiAccessKey = s;
    }

    private HashMap getParamBase()
    {
        HashMap hashmap = new HashMap();
        if (visitorID > 0L)
        {
            hashmap.put("VisitorID", Long.valueOf(visitorID));
        }
        if (departmentID > 0L)
        {
            hashmap.put("DepartmentID", Long.valueOf(departmentID));
        }
        if (chatWindowID > 0L)
        {
            hashmap.put("ChatWindowID", Long.valueOf(chatWindowID));
        }
        if (websiteDefinitionID > 0L)
        {
            hashmap.put("WebsiteID", Long.valueOf(websiteDefinitionID));
        }
        if (extraData != null)
        {
            hashmap.put("Data", (new JSONObject(extraData)).toString());
        }
        hashmap.put("SkipPreChat", Boolean.valueOf(skipPreChat));
        return hashmap;
    }

    public void createChat(final CreateChatListener createChatListener, boolean flag)
    {
        HashMap hashmap = getParamBase();
        if (language == null)
        {
            Locale locale = Locale.getDefault();
            if (locale.getLanguage() != null && locale.getLanguage().length() > 0)
            {
                if (locale.getCountry() != null && locale.getLanguage().length() > 0)
                {
                    language = (new StringBuilder()).append(locale.getLanguage()).append("-").append(locale.getCountry()).toString();
                } else
                {
                    language = locale.getLanguage();
                }
            }
        }
        if (language != null)
        {
            hashmap.put("Language", language);
        }
        hashmap.put("IncludeBrandingValues", Boolean.valueOf(flag));
        (new Thread(new RestAPIRequest(timeout, accountID, apiAccessKey, serverSet, null, "createChat", hashmap, new ResultListener() {

            final Account this$0;
            final CreateChatListener val$createChatListener;

            public void failure(int i, String s, JSONObject jsonobject)
            {
                createChatListener.onChatCreateFailed(i, s);
            }

            public void failure(IOException ioexception)
            {
                ioexception.printStackTrace();
                CreateChatListener createchatlistener = createChatListener;
                if (ioexception.getLocalizedMessage() != null)
                {
                    ioexception = ioexception.getLocalizedMessage();
                } else
                {
                    ioexception = ioexception.getMessage();
                }
                createchatlistener.onChatCreateFailed(-100, ioexception);
            }

            public void success(JSONObject jsonobject)
            {
                PreChat prechat;
                Map map;
                UnavailableReason unavailablereason;
                Chat chat;
                if (jsonobject.optJSONObject("PreChat") == null)
                {
                    prechat = null;
                } else
                {
                    prechat = new PreChat(jsonobject.optJSONObject("PreChat"));
                }
                if (jsonobject.optJSONObject("Brandings") == null)
                {
                    map = null;
                } else
                {
                    map = RequestUtil.getStringMap(jsonobject.optJSONObject("Brandings"));
                }
                chat = new Chat(Account.this, jsonobject, map);
                if (jsonobject.optString("UnavailableReason", null) == null)
                {
                    unavailablereason = null;
                } else
                {
                    unavailablereason = UnavailableReason.getUnavailableReason(jsonobject.optString("UnavailableReason"));
                }
                if (jsonobject.optJSONObject("UnavailableForm") == null)
                {
                    jsonobject = null;
                } else
                {
                    jsonobject = new UnavailableForm(jsonobject.optJSONObject("UnavailableForm"));
                }
                if (unavailablereason == null)
                {
                    createChatListener.onChatCreated(prechat, chat);
                    return;
                } else
                {
                    createChatListener.onChatUnavailable(chat, unavailablereason, jsonobject, map);
                    return;
                }
            }

            
            {
                this$0 = Account.this;
                createChatListener = createchatlistener;
                super();
            }
        }))).start();
    }

    public long getAccountID()
    {
        return accountID;
    }

    public String getApiAccessKey()
    {
        return apiAccessKey;
    }

    public void getChatAvailability(final ChatAvailabilityListener availabilityListener)
    {
        HashMap hashmap = getParamBase();
        availabilityListener = new ResultListener() {

            final Account this$0;
            final ChatAvailabilityListener val$availabilityListener;

            public void failure(int i, String s, JSONObject jsonobject)
            {
                availabilityListener.onChatAvailabilityFailed(i, s);
            }

            public void failure(IOException ioexception)
            {
                ioexception.printStackTrace();
                ChatAvailabilityListener chatavailabilitylistener = availabilityListener;
                if (ioexception.getLocalizedMessage() != null)
                {
                    ioexception = ioexception.getLocalizedMessage();
                } else
                {
                    ioexception = ioexception.getMessage();
                }
                chatavailabilitylistener.onChatAvailabilityFailed(-100, ioexception);
            }

            public void success(JSONObject jsonobject)
            {
                Account.lastAvailabilityResponse = jsonobject;
                if (jsonobject.optBoolean("Available", false))
                {
                    availabilityListener.onChatAvailable();
                    return;
                } else
                {
                    jsonobject = UnavailableReason.getUnavailableReason(jsonobject.optString("UnavailableReason"));
                    availabilityListener.onChatUnavailable(jsonobject);
                    return;
                }
            }

            
            {
                this$0 = Account.this;
                availabilityListener = chatavailabilitylistener;
                super();
            }
        };
        if (lastAvailabilityResponse == null || System.currentTimeMillis() > lastAvailabilityCheck + 60000L)
        {
            availabilityListener = new RestAPIRequest(timeout, accountID, apiAccessKey, serverSet, null, "getChatAvailability", hashmap, availabilityListener);
            lastAvailabilityCheck = System.currentTimeMillis();
            (new Thread(availabilityListener)).start();
            return;
        } else
        {
            System.out.println((new StringBuilder()).append("Using cached result: ").append(lastAvailabilityResponse.toString()).toString());
            availabilityListener.success(lastAvailabilityResponse);
            return;
        }
    }

    protected String getServerSet()
    {
        return serverSet;
    }

    public int getTimeout()
    {
        return timeout;
    }

    public void setExtraData(Map map)
    {
        extraData = map;
    }

    public void setLanguage(String s)
    {
        language = s;
    }

    public void setServerSet(String s)
    {
        serverSet = s;
    }

    public void setSkipPreChat(boolean flag)
    {
        skipPreChat = flag;
    }

    public void setVisitorID(long l)
    {
        visitorID = l;
    }



/*
    static JSONObject access$002(JSONObject jsonobject)
    {
        lastAvailabilityResponse = jsonobject;
        return jsonobject;
    }

*/
}
