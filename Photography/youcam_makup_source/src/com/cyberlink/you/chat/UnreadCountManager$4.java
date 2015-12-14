// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.AsyncTask;
import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.e;
import com.cyberlink.you.utility.ULogUtility;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.chat:
//            UnreadCountManager

class a extends AsyncTask
{

    final UnreadCountManager a;

    protected void a(Object aobj[])
    {
        ULogUtility.f(com/cyberlink/you/chat/UnreadCountManager.getName(), "first init unread count from database");
        aobj = (List)aobj[0];
        Log.d("UnreadCountManager", "first init unread count from database start");
        if (aobj != null)
        {
            Group group;
            for (aobj = ((List) (aobj)).iterator(); ((Iterator) (aobj)).hasNext(); UnreadCountManager.b(a, group.c, group.l))
            {
                group = (Group)((Iterator) (aobj)).next();
            }

        }
        Log.d("UnreadCountManager", "first init unread count from database end");
        UnreadCountManager.b(a, true);
        UnreadCountManager.b(a);
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

    (UnreadCountManager unreadcountmanager)
    {
        a = unreadcountmanager;
        super();
    }
}
