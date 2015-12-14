// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.e;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.o;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.b;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.utility.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you:
//            e

public class ChatListHandler
{

    private static final String a = com/cyberlink/you/ChatListHandler.getCanonicalName();
    private static List b = new ArrayList();

    public ChatListHandler()
    {
    }

    public static String a(String s, int i, int j)
    {
        List list;
label0:
        {
            Log.d(a, "[queryGroups] start");
            Log.d(a, "[queryGroups] query groups from database.");
            List list1 = com.cyberlink.you.e.f().a(i, j);
            if (list1 != null)
            {
                list = list1;
                if (!list1.isEmpty())
                {
                    break label0;
                }
            }
            Log.d(a, "[queryGroups] query groups from server.");
            list = b(s, i, j);
        }
        if (list != null)
        {
            a(list);
            Log.d(a, (new StringBuilder()).append("[queryGroups] get groups size = ").append(list.size()).toString());
            s = b(list);
            a(((JSONObject) (s)));
            return s.toString();
        } else
        {
            return null;
        }
    }

    static List a()
    {
        return b;
    }

    private static List a(List list, List list1)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        Long long1;
        boolean flag;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        long1 = (Long)list.next();
        Iterator iterator = list1.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_96;
            }
        } while (!long1.equals(Long.valueOf(((Friend)iterator.next()).a)));
        flag = true;
_L3:
        if (!flag)
        {
            arraylist.add(long1);
        }
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
        flag = false;
          goto _L3
    }

    private static JSONObject a(Group group)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("avatar1", group.d);
            if (group.e.equals("Circle"))
            {
                jsonobject.put("avatar2", group.q);
            }
            jsonobject.put("displayName", group.f);
            jsonobject.put("groupId", group.b);
            jsonobject.put("groupType", group.e);
            jsonobject.put("numberOfMember", group.g);
            jsonobject.put("unread", Integer.valueOf(group.l));
            jsonobject.put("lastMsg", a(group.p));
        }
        // Misplaced declaration of an exception variable
        catch (Group group)
        {
            group.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    private static JSONObject a(String s)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        s = new JSONObject(s);
        return s;
        s;
        s.printStackTrace();
        return new JSONObject();
    }

    public static void a(long l1)
    {
        com.cyberlink.you.e.f().f(String.valueOf(l1));
        com.cyberlink.you.e.d().f(String.valueOf(l1));
        com.cyberlink.you.e.l().b(Long.valueOf(l1));
    }

    private static void a(OnChatListChangedListener.ChangedType changedtype, long l1)
    {
        (new AsyncTask(changedtype, l1) {

            final OnChatListChangedListener.ChangedType a;
            final long b;

            protected transient Void a(Void avoid[])
            {
                avoid = ChatListHandler.a();
                avoid;
                JVM INSTR monitorenter ;
                for (Iterator iterator = ChatListHandler.a().iterator(); iterator.hasNext(); ((OnChatListChangedListener)iterator.next()).a(a, b)) { }
                break MISSING_BLOCK_LABEL_54;
                Exception exception;
                exception;
                avoid;
                JVM INSTR monitorexit ;
                throw exception;
                avoid;
                JVM INSTR monitorexit ;
                return null;
            }

            protected Object doInBackground(Object aobj[])
            {
                return a((Void[])aobj);
            }

            
            {
                a = changedtype;
                b = l1;
                super();
            }

            private class OnChatListChangedListener
            {

                public abstract void a(ChangedType changedtype, long l1);
            }

        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void a(OnChatListChangedListener onchatlistchangedlistener)
    {
        synchronized (b)
        {
            b.add(onchatlistchangedlistener);
        }
        return;
        onchatlistchangedlistener;
        list;
        JVM INSTR monitorexit ;
        throw onchatlistchangedlistener;
    }

    private static void a(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Group group = (Group)list.next();
            if (group.e.equals("Circle"))
            {
                Object obj = com.cyberlink.you.e.l().a(Long.valueOf(group.b));
                List list1 = e.g().a(((List) (obj)));
                if (((List) (obj)).size() != list1.size())
                {
                    List list2 = a(((List) (obj)), list1);
                    obj = new l();
                    list2 = ((l) (obj)).a(list2);
                    ((l) (obj)).b();
                    if (list2 != null)
                    {
                        list1.addAll(list2);
                        Collections.sort(list1, new b());
                    }
                }
                if (list1.size() >= 2)
                {
                    group.d = ((Friend)list1.get(0)).b;
                    group.q = ((Friend)list1.get(1)).b;
                }
            }
        } while (true);
    }

    private static void a(JSONObject jsonobject)
    {
        int i = com.cyberlink.you.e.f().a();
        try
        {
            jsonobject.put("totalSize", i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    private static List b(String s, int i, int j)
    {
        l l1 = new l();
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", s));
        arraylist.add(new BasicNameValuePair("pageIndex", String.valueOf(i)));
        arraylist.add(new BasicNameValuePair("pageSize", String.valueOf(j)));
        s = l1.a("group", "list", arraylist);
        l1.b();
        if (s != null)
        {
            String s1 = (String)((Pair) (s)).first;
            s = (String)((Pair) (s)).second;
            if (s1 != null && s1.equals("200") && s != null)
            {
                s = h.a(h.b(s));
                if (s != null)
                {
                    com.cyberlink.you.e.f().b(s);
                }
                return s;
            } else
            {
                return null;
            }
        } else
        {
            return null;
        }
    }

    private static JSONObject b(List list)
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        for (list = list.iterator(); list.hasNext(); jsonarray.put(a((Group)list.next()))) { }
        try
        {
            jsonobject.put("results", jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public static void b(long l1)
    {
        class OnChatListChangedListener.ChangedType extends Enum
        {

            public static final OnChatListChangedListener.ChangedType a;
            public static final OnChatListChangedListener.ChangedType b;
            public static final OnChatListChangedListener.ChangedType c;
            private static final OnChatListChangedListener.ChangedType d[];

            public static OnChatListChangedListener.ChangedType valueOf(String s)
            {
                return (OnChatListChangedListener.ChangedType)Enum.valueOf(com/cyberlink/you/ChatListHandler$OnChatListChangedListener$ChangedType, s);
            }

            public static OnChatListChangedListener.ChangedType[] values()
            {
                return (OnChatListChangedListener.ChangedType[])d.clone();
            }

            static 
            {
                a = new OnChatListChangedListener.ChangedType("GROUP_CREATE", 0);
                b = new OnChatListChangedListener.ChangedType("GROUP_UPDATE", 1);
                c = new OnChatListChangedListener.ChangedType("GROUP_DELETE", 2);
                d = (new OnChatListChangedListener.ChangedType[] {
                    a, b, c
                });
            }

            private OnChatListChangedListener.ChangedType(String s, int i)
            {
                super(s, i);
            }
        }

        a(OnChatListChangedListener.ChangedType.c, l1);
    }

    public static void c(long l1)
    {
        a(OnChatListChangedListener.ChangedType.a, l1);
    }

    public static void d(long l1)
    {
        a(com.cyberlink.you.OnChatListChangedListener.ChangedType.b, l1);
    }

}
