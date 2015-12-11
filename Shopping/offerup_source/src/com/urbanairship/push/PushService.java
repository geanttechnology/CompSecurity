// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.BaseIntentService;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;

// Referenced classes of package com.urbanairship.push:
//            TagGroupServiceDelegate, NamedUserServiceDelegate, ChannelServiceDelegate, IncomingPushServiceDelegate

public class PushService extends BaseIntentService
{

    static final String ACTION_ADM_REGISTRATION_FINISHED = "com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED";
    static final String ACTION_CLEAR_PENDING_NAMED_USER_TAGS = "com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS";
    static final String ACTION_RECEIVE_ADM_MESSAGE = "com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE";
    static final String ACTION_RECEIVE_GCM_MESSAGE = "com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE";
    static final String ACTION_START_REGISTRATION = "com.urbanairship.push.ACTION_START_REGISTRATION";
    static final String ACTION_UPDATE_CHANNEL_REGISTRATION = "com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION";
    static final String ACTION_UPDATE_CHANNEL_TAG_GROUPS = "com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS";
    static final String ACTION_UPDATE_NAMED_USER = "com.urbanairship.push.ACTION_UPDATE_NAMED_USER";
    static final String ACTION_UPDATE_NAMED_USER_TAGS = "com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS";
    static final String ACTION_UPDATE_PUSH_REGISTRATION = "com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION";
    static final String EXTRA_ADD_TAG_GROUPS = "com.urbanairship.push.EXTRA_ADD_TAG_GROUPS";
    static final String EXTRA_GCM_TOKEN_REFRESH = "com.urbanairship.push.EXTRA_GCM_TOKEN_REFRESH";
    static final String EXTRA_INTENT = "com.urbanairship.push.EXTRA_INTENT";
    static final String EXTRA_REMOVE_TAG_GROUPS = "com.urbanairship.push.EXTRA_REMOVE_TAG_GROUPS";

    public PushService()
    {
        super("PushService");
    }

    protected com.urbanairship.BaseIntentService.Delegate getServiceDelegate(String s, PreferenceDataStore preferencedatastore)
    {
        byte byte0;
        Logger.verbose((new StringBuilder("PushService - Service delegate for intent: ")).append(s).toString());
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 10: default 116
    //                   -1411187451: 216
    //                   -1138418629: 303
    //                   -1003583816: 244
    //                   -901120150: 273
    //                   -832939733: 202
    //                   720921569: 230
    //                   856841428: 288
    //                   962413331: 174
    //                   1048059625: 188
    //                   1402665321: 258;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_303;
_L12:
        switch (byte0)
        {
        default:
            return null;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            return new TagGroupServiceDelegate(getApplicationContext(), preferencedatastore);

        case 3: // '\003'
            return new NamedUserServiceDelegate(getApplicationContext(), preferencedatastore);

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return new ChannelServiceDelegate(getApplicationContext(), preferencedatastore);

        case 8: // '\b'
        case 9: // '\t'
            return new IncomingPushServiceDelegate(getApplicationContext(), preferencedatastore);
        }
_L9:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS"))
        {
            byte0 = 0;
        }
          goto _L12
_L10:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS"))
        {
            byte0 = 1;
        }
          goto _L12
_L6:
        if (s.equals("com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS"))
        {
            byte0 = 2;
        }
          goto _L12
_L2:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER"))
        {
            byte0 = 3;
        }
          goto _L12
_L7:
        if (s.equals("com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED"))
        {
            byte0 = 4;
        }
          goto _L12
_L4:
        if (s.equals("com.urbanairship.push.ACTION_START_REGISTRATION"))
        {
            byte0 = 5;
        }
          goto _L12
_L11:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"))
        {
            byte0 = 6;
        }
          goto _L12
_L5:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION"))
        {
            byte0 = 7;
        }
          goto _L12
_L8:
        if (s.equals("com.urbanairship.push.ACTION_RECEIVE_ADM_MESSAGE"))
        {
            byte0 = 8;
        }
          goto _L12
        if (s.equals("com.urbanairship.push.ACTION_RECEIVE_GCM_MESSAGE"))
        {
            byte0 = 9;
        }
          goto _L12
    }
}
