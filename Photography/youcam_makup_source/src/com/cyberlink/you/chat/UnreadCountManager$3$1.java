// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.AsyncTask;
import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.chat:
//            UnreadCountManager, l

class a extends AsyncTask
{

    final a a;

    protected void a(Object aobj[])
    {
        aobj = (List)aobj[0];
        Log.d("UnreadCountManager", "second init update unread count from database start.");
        if (aobj != null)
        {
            ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), "second init update unread count from database");
            Group group;
            for (aobj = ((List) (aobj)).iterator(); ((Iterator) (aobj)).hasNext(); UnreadCountManager.a(a.a, group.c, group.l))
            {
                group = (Group)((Iterator) (aobj)).next();
                if (group.l != 0)
                {
                    Log.d("UnreadCountManager", (new StringBuilder()).append("second init group jid=").append(group.c).append(" unread=").append(group.l).toString());
                }
            }

            UnreadCountManager.a(a.a, g.I());
        }
        a.a.a(readCountListner.Type.c);
        Log.d("UnreadCountManager", "second init update unread count from database end.");
        UnreadCountManager.a(a.a, true);
        UnreadCountManager.b(a.a, true);
        UnreadCountManager.b(a.a);
    }

    protected transient Object[] a(Void avoid[])
    {
        return (new Object[] {
            e.f().c()
        });
    }

    protected Object doInBackground(Object aobj[])
    {
        return ((Object) (a((Void[])aobj)));
    }

    protected void onPostExecute(Object obj)
    {
        a((Object[])obj);
    }

    readCountListner.Type(readCountListner.Type type)
    {
        a = type;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/chat/UnreadCountManager$3

/* anonymous class */
    class UnreadCountManager._cls3
        implements l
    {

        final UnreadCountManager a;

        public void a()
        {
            if (UnreadCountManager.a(a) == null)
            {
                UnreadCountManager.a(a, new UnreadCountManager._cls3._cls1(this));
                UnreadCountManager.a(a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }

        public void b()
        {
        }

            
            {
                a = unreadcountmanager;
                super();
            }
    }

}
