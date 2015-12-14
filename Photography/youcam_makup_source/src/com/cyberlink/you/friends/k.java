// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.os.AsyncTask;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.cyberlink.you.friends:
//            d, Friend, l, e, 
//            i, c

public class k
{

    public static c a(l l, long l1, int i, e e, i j)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", g.a().e()));
        arraylist.add(new BasicNameValuePair("groupId", String.valueOf(l1)));
        arraylist.add(new BasicNameValuePair("pageIndex", String.valueOf(i)));
        return (new d("group", "listGroupMembers", arraylist, com/cyberlink/you/friends/Friend)).a(l).a().b().a(e).a(j).a(AsyncTask.THREAD_POOL_EXECUTOR).c();
    }

    public static c a(l l, long l1, e e, i i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", g.a().e()));
        arraylist.add(new BasicNameValuePair("userId", String.valueOf(l1)));
        return (new d("user", "blockUser", arraylist, java/lang/String)).a(l).a(e).a(i).a(AsyncTask.THREAD_POOL_EXECUTOR).c();
    }

    public static c a(l l, long l1, String s, boolean flag, e e, i i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", g.a().e()));
        arraylist.add(new BasicNameValuePair("groupId", String.valueOf(l1)));
        arraylist.add(new BasicNameValuePair("displayName", s));
        arraylist.add(new BasicNameValuePair("isNotificationDisabled", String.valueOf(flag)));
        return (new d("group", "updateGroup", arraylist, com/cyberlink/you/database/Group)).a(l).b().a(e).a(i).a(AsyncTask.THREAD_POOL_EXECUTOR).c();
    }

    public static c a(l l, List list, String s, e e, i i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", g.a().e()));
        arraylist.add(new BasicNameValuePair("groupType", s));
        for (list = list.iterator(); list.hasNext(); arraylist.add(new BasicNameValuePair("userId", String.valueOf((Long)list.next())))) { }
        return (new d("group", "createGroup", arraylist, com/cyberlink/you/database/Group)).a(l).b().a(e).a(i).a(AsyncTask.THREAD_POOL_EXECUTOR).c();
    }

    public static c b(l l, long l1, e e, i i)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", g.a().e()));
        arraylist.add(new BasicNameValuePair("groupId", String.valueOf(l1)));
        return (new d("group", "leaveGroup", arraylist, java/lang/String)).a(l).a(e).a(i).a(AsyncTask.THREAD_POOL_EXECUTOR).c();
    }
}
