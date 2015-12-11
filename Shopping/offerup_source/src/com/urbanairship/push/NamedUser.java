// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;
import java.util.UUID;

// Referenced classes of package com.urbanairship.push:
//            TagGroupsEditor, PushService

public class NamedUser
{

    private static final String CHANGE_TOKEN_KEY = "com.urbanairship.nameduser.CHANGE_TOKEN_KEY";
    private static final int MAX_NAMED_USER_ID_LENGTH = 128;
    private static final String NAMED_USER_ID_KEY = "com.urbanairship.nameduser.NAMED_USER_ID_KEY";
    private final PreferenceDataStore preferenceDataStore;

    NamedUser(PreferenceDataStore preferencedatastore)
    {
        preferenceDataStore = preferencedatastore;
    }

    private void updateChangeToken()
    {
        preferenceDataStore.put("com.urbanairship.nameduser.CHANGE_TOKEN_KEY", UUID.randomUUID().toString());
    }

    void disassociateNamedUserIfNull()
    {
        this;
        JVM INSTR monitorenter ;
        if (UAStringUtil.equals(getId(), null))
        {
            setId(null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public TagGroupsEditor editTagGroups()
    {
        return new TagGroupsEditor("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS");
    }

    public void forceUpdate()
    {
        Logger.debug("NamedUser - force named user update.");
        updateChangeToken();
        startUpdateService();
    }

    String getChangeToken()
    {
        return preferenceDataStore.getString("com.urbanairship.nameduser.CHANGE_TOKEN_KEY", null);
    }

    public String getId()
    {
        return preferenceDataStore.getString("com.urbanairship.nameduser.NAMED_USER_ID_KEY", null);
    }

    public void setId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        s = s.trim();
        if (!UAStringUtil.isEmpty(s) && s.length() <= 128) goto _L2; else goto _L1
_L1:
        Logger.error("Failed to set named user ID. The named user ID must be greater than 0 and less than 129 characters.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (getId() != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        boolean flag;
        if (s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        if (getId() != null || getChangeToken() != null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        preferenceDataStore.put("com.urbanairship.nameduser.NAMED_USER_ID_KEY", s);
        updateChangeToken();
        Logger.debug("NamedUser - Clear pending named user tags.");
        startClearPendingTagsService();
        Logger.debug("NamedUser - Start service to update named user.");
        startUpdateService();
          goto _L3
        s;
        throw s;
        flag = getId().equals(s);
          goto _L4
        Logger.debug((new StringBuilder("NamedUser - Skipping update. Named user ID trimmed already matches existing named user: ")).append(getId()).toString());
          goto _L3
        s = null;
          goto _L2
    }

    void startClearPendingTagsService()
    {
        Context context = UAirship.getApplicationContext();
        Intent intent = new Intent(context, com/urbanairship/push/PushService);
        intent.setAction("com.urbanairship.push.ACTION_CLEAR_PENDING_NAMED_USER_TAGS");
        context.startService(intent);
    }

    void startUpdateService()
    {
        Context context = UAirship.getApplicationContext();
        Intent intent = new Intent(context, com/urbanairship/push/PushService);
        intent.setAction("com.urbanairship.push.ACTION_UPDATE_NAMED_USER");
        context.startService(intent);
    }

    void startUpdateTagsService()
    {
        Context context = UAirship.getApplicationContext();
        Intent intent = new Intent(context, com/urbanairship/push/PushService);
        intent.setAction("com.urbanairship.push.ACTION_UPDATE_NAMED_USER_TAGS");
        context.startService(intent);
    }
}
