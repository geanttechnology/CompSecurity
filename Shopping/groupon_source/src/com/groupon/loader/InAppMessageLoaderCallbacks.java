// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.adapter.InAppMessagesAdapter;
import com.groupon.db.dao.DaoInAppMessage;
import com.groupon.db.events.InAppMessageEvent;
import com.groupon.db.models.InAppMessage;
import commonlib.loader.ListLoaderCallbacks;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class InAppMessageLoaderCallbacks extends ListLoaderCallbacks
{
    private static class InAppMessageListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
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

        public InAppMessageListLoader(Class class1, Class class2, Context context1, DaoInAppMessage daoinappmessage)
        {
            super(class1, class2, context1);
            daoInAppMessage = daoinappmessage;
        }
    }


    private Context context;
    private DaoInAppMessage daoInAppMessage;

    public InAppMessageLoaderCallbacks(Context context1, InAppMessagesAdapter inappmessagesadapter)
    {
        super(inappmessagesadapter);
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
    }

    protected int getUnreadMessages(List list)
    {
        int j = 0;
        int i = 0;
        if (list != null)
        {
            list = list.iterator();
            do
            {
                j = i;
                if (!list.hasNext())
                {
                    break;
                }
                if (!((InAppMessage)list.next()).viewed)
                {
                    i++;
                }
            } while (true);
        }
        return j;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new InAppMessageListLoader(com/groupon/db/models/InAppMessage, com/groupon/db/events/InAppMessageEvent, context, daoInAppMessage);
    }

    public abstract void onInAppMessagesLoaded(List list);

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        onInAppMessagesLoaded(list);
    }
}
