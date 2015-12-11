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
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushManager;
import com.urbanairship.util.UAStringUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.urbanairship.richpush:
//            RichPushManager, RichPushUpdateService, RichPushUser

class UserServiceDelegate extends com.urbanairship.BaseIntentService.Delegate
{

    private static final String LAST_UPDATE_TIME = "com.urbanairship.user.LAST_UPDATE_TIME";
    private static final String PAYLOAD_ADD_KEY = "add";
    private static final String PAYLOAD_AMAZON_CHANNELS_KEY = "amazon_channels";
    private static final String PAYLOAD_ANDROID_CHANNELS_KEY = "android_channels";
    private static final String USER_CREATION_PATH = "api/user/";
    static final long USER_UPDATE_INTERVAL_MS = 0x5265c00L;
    private static final String USER_UPDATE_PATH = "api/user/%s/";
    private final UAirship airship;
    private final RequestFactory requestFactory;
    private final RichPushUser user;

    UserServiceDelegate(Context context, PreferenceDataStore preferencedatastore)
    {
        this(context, preferencedatastore, new RequestFactory(), UAirship.shared());
    }

    UserServiceDelegate(Context context, PreferenceDataStore preferencedatastore, RequestFactory requestfactory, UAirship uairship)
    {
        super(context, preferencedatastore);
        requestFactory = requestfactory;
        airship = uairship;
        user = uairship.getRichPushManager().getRichPushUser();
    }

    private String createNewUserPayload(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(getPayloadChannelsKey(), Arrays.asList(new String[] {
            s
        }));
        return JsonValue.wrap(hashmap, JsonValue.NULL).toString();
    }

    private String createUpdateUserPayload(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("add", Arrays.asList(new String[] {
            s
        }));
        s = new HashMap();
        s.put(getPayloadChannelsKey(), hashmap);
        return JsonValue.wrap(s, JsonValue.NULL).toString();
    }

    private boolean createUser()
    {
        Object obj;
        Object obj1;
        obj = null;
        Object obj2 = airship.getPushManager().getChannelId();
        if (UAStringUtil.isEmpty(((String) (obj2))))
        {
            Logger.debug("UserServiceDelegate - No Channel. User will be created after channel registrations finishes.");
            return false;
        }
        obj1 = RichPushUpdateService.getUserURL("api/user/", new Object[0]);
        if (obj1 == null)
        {
            return false;
        }
        obj2 = createNewUserPayload(((String) (obj2)));
        Logger.verbose((new StringBuilder("UserServiceDelegate - Creating Rich Push user with payload: ")).append(((String) (obj2))).toString());
        obj2 = requestFactory.createRequest("POST", ((java.net.URL) (obj1))).setCredentials(airship.getAirshipConfigOptions().getAppKey(), airship.getAirshipConfigOptions().getAppSecret()).setRequestBody(((String) (obj2)), "application/json").setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
        if (obj2 == null || ((Response) (obj2)).getStatus() != 201)
        {
            Logger.verbose((new StringBuilder("UserServiceDelegate - Rich Push user creation failed: ")).append(obj2).toString());
            return false;
        }
        JsonMap jsonmap;
        try
        {
            jsonmap = JsonValue.parseString(((Response) (obj2)).getResponseBody()).getMap();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.error((new StringBuilder("UserServiceDelegate - Unable to parse Rich Push user response: ")).append(obj2).toString());
            return false;
        }
        if (jsonmap == null) goto _L2; else goto _L1
_L1:
        obj1 = jsonmap.get("user_id").getString();
        obj = jsonmap.get("password").getString();
_L4:
        if (UAStringUtil.isEmpty(((String) (obj1))) || UAStringUtil.isEmpty(((String) (obj))))
        {
            Logger.error((new StringBuilder("UserServiceDelegate - Rich Push user creation failed: ")).append(obj2).toString());
            return false;
        } else
        {
            Logger.info((new StringBuilder("Created Rich Push user: ")).append(((String) (obj1))).toString());
            getDataStore().put("com.urbanairship.user.LAST_UPDATE_TIME", System.currentTimeMillis());
            getDataStore().remove("com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME");
            user.setUser(((String) (obj1)), ((String) (obj)));
            return true;
        }
_L2:
        obj1 = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String getPayloadChannelsKey()
    {
        switch (airship.getPlatformType())
        {
        default:
            return "android_channels";

        case 1: // '\001'
            return "amazon_channels";
        }
    }

    private boolean updateUser()
    {
        String s = airship.getPushManager().getChannelId();
        if (UAStringUtil.isEmpty(s))
        {
            Logger.debug("UserServiceDelegate - No Channel. Skipping Rich Push user update.");
        } else
        {
            Object obj = RichPushUpdateService.getUserURL("api/user/%s/", new Object[] {
                user.getId()
            });
            if (obj != null)
            {
                s = createUpdateUserPayload(s);
                Logger.verbose((new StringBuilder("UserServiceDelegate - Updating user with payload: ")).append(s).toString());
                obj = requestFactory.createRequest("POST", ((java.net.URL) (obj))).setCredentials(user.getId(), user.getPassword()).setRequestBody(s, "application/json").setHeader("Accept", "application/vnd.urbanairship+json; version=3;").execute();
                Logger.verbose((new StringBuilder("UserServiceDelegate - Update Rich Push user response: ")).append(obj).toString());
                if (obj != null && ((Response) (obj)).getStatus() == 200)
                {
                    Logger.info("Rich Push user updated.");
                    getDataStore().put("com.urbanairship.user.LAST_UPDATE_TIME", System.currentTimeMillis());
                    return true;
                } else
                {
                    getDataStore().put("com.urbanairship.user.LAST_UPDATE_TIME", 0);
                    return false;
                }
            }
        }
        return false;
    }

    protected void onHandleIntent(Intent intent)
    {
        if ("com.urbanairship.richpush.USER_UPDATE".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        long l;
        long l1;
        if (!intent.getBooleanExtra("com.urbanairship.richpush.EXTRA_FORCEFULLY", false))
        {
            break; /* Loop/switch isn't completed */
        }
        l = getDataStore().getLong("com.urbanairship.user.LAST_UPDATE_TIME", 0L);
        l1 = System.currentTimeMillis();
        if (l <= l1 && l + 0x5265c00L >= l1) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (!RichPushUser.isCreated())
        {
            flag = createUser();
        } else
        {
            flag = updateUser();
        }
        RichPushUpdateService.respond(intent, flag);
        return;
    }
}
