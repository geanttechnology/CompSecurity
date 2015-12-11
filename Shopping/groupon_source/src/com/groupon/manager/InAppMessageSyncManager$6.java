// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.SharedPreferences;
import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.models.InAppMessage;
import com.groupon.service.InAppMessageService;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.manager:
//            InAppMessageSyncManager

class val.appMessages
    implements Callable
{

    final InAppMessageSyncManager this$0;
    final List val$appMessages;

    public Object call()
        throws Exception
    {
        if (val$appMessages == null || val$appMessages.isEmpty()) goto _L2; else goto _L1
_L1:
        Object obj = InAppMessageSyncManager.access$000(InAppMessageSyncManager.this).queryForAll();
        int i = val$appMessages.size();
        Iterator iterator = val$appMessages.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            InAppMessage inappmessage = (InAppMessage)iterator.next();
            inappmessage.timestamp = System.currentTimeMillis();
            Iterator iterator1 = ((List) (obj)).iterator();
            int j;
            do
            {
                j = i;
                if (!iterator1.hasNext())
                {
                    break;
                }
                InAppMessage inappmessage1 = (InAppMessage)iterator1.next();
                if (!Strings.equals(inappmessage1.remoteId, inappmessage.remoteId))
                {
                    continue;
                }
                inappmessage.timestamp = inappmessage1.timestamp;
                inappmessage.viewed = inappmessage1.viewed;
                inappmessage.read = inappmessage1.read;
                j = i - 1;
                break;
            } while (true);
            i = j;
            if (inappmessage.viewed)
            {
                i = j;
                if (!inappmessage.read)
                {
                    ((InAppMessageService)RoboGuice.getInjector(InAppMessageSyncManager.access$100(InAppMessageSyncManager.this)).getInstance(com/groupon/service/InAppMessageService)).onStateChanged(inappmessage, com.groupon.service.ame.VIEWED);
                    i = j;
                }
            }
        } while (true);
        InAppMessageSyncManager.access$000(InAppMessageSyncManager.this).clearAll();
        InAppMessageSyncManager.access$000(InAppMessageSyncManager.this).saveList(val$appMessages);
        obj = ((SharedPreferences)InAppMessageSyncManager.access$200(InAppMessageSyncManager.this).get()).edit();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((android.content.r) (obj)).utBoolean("show_message_box", flag).ommit();
_L4:
        return null;
_L2:
        InAppMessageSyncManager.access$000(InAppMessageSyncManager.this).clearAll();
        if (true) goto _L4; else goto _L3
_L3:
    }

    ame()
    {
        this$0 = final_inappmessagesyncmanager;
        val$appMessages = List.this;
        super();
    }
}
