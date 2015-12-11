// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.http.Response;
import com.urbanairship.util.UAHttpStatusUtil;
import com.urbanairship.util.UAStringUtil;

// Referenced classes of package com.urbanairship.push:
//            NamedUserAPIClient, PushManager, NamedUser

class NamedUserServiceDelegate extends com.urbanairship.BaseIntentService.Delegate
{

    static final String LAST_UPDATED_TOKEN_KEY = "com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY";
    private final NamedUserAPIClient client;
    private final NamedUser namedUser;
    private final PushManager pushManager;

    public NamedUserServiceDelegate(Context context, PreferenceDataStore preferencedatastore)
    {
        this(context, preferencedatastore, new NamedUserAPIClient(), UAirship.shared().getPushManager(), UAirship.shared().getPushManager().getNamedUser());
    }

    public NamedUserServiceDelegate(Context context, PreferenceDataStore preferencedatastore, NamedUserAPIClient nameduserapiclient, PushManager pushmanager, NamedUser nameduser)
    {
        super(context, preferencedatastore);
        client = nameduserapiclient;
        namedUser = nameduser;
        pushManager = pushmanager;
    }

    protected void onHandleIntent(Intent intent)
    {
        if (!intent.getAction().equals("com.urbanairship.push.ACTION_UPDATE_NAMED_USER"))
        {
            return;
        }
        Object obj = namedUser.getId();
        String s = namedUser.getChangeToken();
        String s1 = getDataStore().getString("com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY", null);
        String s2 = pushManager.getChannelId();
        if (s == null && s1 == null)
        {
            Logger.debug("NamedUserServiceDelegate - New or re-install. Skipping.");
            return;
        }
        if (s != null && s.equals(s1))
        {
            Logger.debug("NamedUserServiceDelegate - named user already updated. Skipping.");
            return;
        }
        if (UAStringUtil.isEmpty(s2))
        {
            Logger.info("The channel ID does not exist. Will retry when channel ID is available.");
            return;
        }
        if (obj == null)
        {
            obj = client.disassociate(s2);
        } else
        {
            obj = client.associate(((String) (obj)), s2);
        }
        if (obj == null || UAHttpStatusUtil.inServerErrorRange(((Response) (obj)).getStatus()))
        {
            Logger.info("Update named user failed, will retry.");
            retryIntent(intent);
            return;
        }
        if (UAHttpStatusUtil.inSuccessRange(((Response) (obj)).getStatus()))
        {
            Logger.info((new StringBuilder("Update named user succeeded with status: ")).append(((Response) (obj)).getStatus()).toString());
            getDataStore().put("com.urbanairship.nameduser.LAST_UPDATED_TOKEN_KEY", s);
            namedUser.startUpdateTagsService();
            return;
        }
        if (((Response) (obj)).getStatus() == 403)
        {
            Logger.info((new StringBuilder("Update named user failed with status: ")).append(((Response) (obj)).getStatus()).append(" This action is not allowed when the app is in server-only mode.").toString());
            return;
        } else
        {
            Logger.info((new StringBuilder("Update named user failed with status: ")).append(((Response) (obj)).getStatus()).toString());
            return;
        }
    }
}
