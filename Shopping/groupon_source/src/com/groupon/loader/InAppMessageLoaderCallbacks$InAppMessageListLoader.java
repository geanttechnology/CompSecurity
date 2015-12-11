// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.events.InAppMessageEvent;
import com.groupon.db.models.InAppMessage;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.loader:
//            InAppMessageLoaderCallbacks

private static class daoInAppMessage extends commonlib.loader.r
{

    private DaoInAppMessage daoInAppMessage;

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        List list;
        InAppMessage inappmessage;
        try
        {
            list = daoInAppMessage.getAll();
        }
        catch (SQLException sqlexception)
        {
            return new ArrayList();
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        if (!list.isEmpty())
        {
            inappmessage = (InAppMessage)list.get(0);
            if (!inappmessage.viewed)
            {
                inappmessage.viewed = true;
                daoInAppMessage.replace(inappmessage);
            }
        }
        return list;
    }

    protected boolean shouldReload(InAppMessageEvent inappmessageevent)
    {
        return true;
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((InAppMessageEvent)updateevent);
    }

    public (Class class1, Class class2, Context context, DaoInAppMessage daoinappmessage)
    {
        super(class1, class2, context);
        daoInAppMessage = daoinappmessage;
    }
}
