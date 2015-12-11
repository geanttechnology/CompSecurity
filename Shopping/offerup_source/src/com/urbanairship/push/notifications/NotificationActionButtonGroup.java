// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.content.Context;
import com.urbanairship.Logger;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.UAStringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.push.notifications:
//            NotificationActionButton

public class NotificationActionButtonGroup
{

    private final List actionButtons;

    private NotificationActionButtonGroup(List list)
    {
        actionButtons = new ArrayList(list);
    }

    NotificationActionButtonGroup(List list, _cls1 _pcls1)
    {
        this(list);
    }

    List createAndroidActions(Context context, PushMessage pushmessage, int i, String s)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        if (UAStringUtil.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_118;
        }
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject;
_L1:
        Iterator iterator = getNotificationActionButtons().iterator();
        while (iterator.hasNext()) 
        {
            NotificationActionButton notificationactionbutton = (NotificationActionButton)iterator.next();
            Object obj;
            if (s == null)
            {
                obj = null;
            } else
            {
                obj = s.optString(notificationactionbutton.getId());
            }
            arraylist.add(notificationactionbutton.createAndroidNotificationAction(context, ((String) (obj)), pushmessage, i));
        }
        break MISSING_BLOCK_LABEL_139;
        obj;
        Logger.error((new StringBuilder("Failed to parse notification actions payload: ")).append(s).toString(), ((Throwable) (obj)));
        s = null;
          goto _L1
        return arraylist;
    }

    public List getNotificationActionButtons()
    {
        return new ArrayList(actionButtons);
    }
}
