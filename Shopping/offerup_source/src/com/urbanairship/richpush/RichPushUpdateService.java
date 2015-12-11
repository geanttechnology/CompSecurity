// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.richpush;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.BaseIntentService;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.urbanairship.richpush:
//            UserServiceDelegate, InboxServiceDelegate

public class RichPushUpdateService extends BaseIntentService
{

    public static final String ACTION_RICH_PUSH_MESSAGES_UPDATE = "com.urbanairship.richpush.MESSAGES_UPDATE";
    public static final String ACTION_RICH_PUSH_USER_UPDATE = "com.urbanairship.richpush.USER_UPDATE";
    public static final String ACTION_SYNC_MESSAGE_STATE = "com.urbanairship.richpush.SYNC_MESSAGE_STATE";
    public static final String EXTRA_FORCEFULLY = "com.urbanairship.richpush.EXTRA_FORCEFULLY";
    public static final String EXTRA_RICH_PUSH_RESULT_RECEIVER = "com.urbanairship.richpush.RESULT_RECEIVER";
    static final String LAST_MESSAGE_REFRESH_TIME = "com.urbanairship.user.LAST_MESSAGE_REFRESH_TIME";
    public static final int STATUS_RICH_PUSH_UPDATE_ERROR = 1;
    public static final int STATUS_RICH_PUSH_UPDATE_SUCCESS = 0;

    public RichPushUpdateService()
    {
        super("RichPushUpdateService");
    }

    static transient URL getUserURL(String s, Object aobj[])
    {
        String s1 = UAirship.shared().getAirshipConfigOptions().hostURL;
        s = String.format((new StringBuilder()).append(s1).append(s).toString(), aobj);
        try
        {
            s = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error("Invalid userURL", s);
            return null;
        }
        return s;
    }

    static void respond(Intent intent, boolean flag)
    {
label0:
        {
            intent = (ResultReceiver)intent.getParcelableExtra("com.urbanairship.richpush.RESULT_RECEIVER");
            if (intent != null)
            {
                if (!flag)
                {
                    break label0;
                }
                intent.send(0, new Bundle());
            }
            return;
        }
        intent.send(1, new Bundle());
    }

    protected com.urbanairship.BaseIntentService.Delegate getServiceDelegate(String s, PreferenceDataStore preferencedatastore)
    {
        byte byte0;
        Logger.verbose((new StringBuilder("RichPushUpdateService - Service delegate for intent: ")).append(s).toString());
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 60
    //                   -1229158830: 90
    //                   1699160881: 118
    //                   2078637888: 104;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_118;
_L5:
        switch (byte0)
        {
        default:
            return null;

        case 0: // '\0'
            return new UserServiceDelegate(getApplicationContext(), preferencedatastore);

        case 1: // '\001'
        case 2: // '\002'
            return new InboxServiceDelegate(getApplicationContext(), preferencedatastore);
        }
_L2:
        if (s.equals("com.urbanairship.richpush.USER_UPDATE"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("com.urbanairship.richpush.SYNC_MESSAGE_STATE"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("com.urbanairship.richpush.MESSAGES_UPDATE"))
        {
            byte0 = 2;
        }
          goto _L5
    }
}
