// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.b;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.chat.UnreadCountManager;
import com.cyberlink.you.chat.af;
import com.cyberlink.you.chat.b;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.util.p;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.b:
//            b, c

public class a
{

    private static l c = new l();
    private final String a = "xmppServer";
    private final String b = "xmppPort";
    private Object d;
    private List e;

    public a()
    {
        d = new Object();
        e = new ArrayList();
    }

    public static a a()
    {
        return com.cyberlink.you.b.b.a();
    }

    private void a(Group group)
    {
        List list;
label0:
        {
            List list1 = com.cyberlink.you.e.g().a(group.b);
            if (a(list1))
            {
                list = list1;
                if (a(group, list1))
                {
                    break label0;
                }
            }
            list = c.a(group.b, true);
        }
        if (list != null)
        {
            String s = com.cyberlink.you.utility.d.a(list);
            if (!group.f.equals(s))
            {
                group.f = com.cyberlink.you.utility.d.a(list);
                com.cyberlink.you.e.f().a(String.valueOf(group.b), group, "DisplayName");
                ChatListHandler.d(group.b);
            }
        }
    }

    public static void a(Group group, String s)
    {
        NotificationManager notificationmanager = (NotificationManager)g.I().getSystemService("notification");
        if (group != null)
        {
            notificationmanager.cancel(group.c, 1);
            UnreadCountManager.b().a(group.c);
            UnreadCountManager.b().a(group.b);
        }
        try
        {
            com.cyberlink.you.e.l().b(Long.valueOf(Long.parseLong(s)));
        }
        // Misplaced declaration of an exception variable
        catch (Group group)
        {
            Log.d("XMPPEventManager", Log.getStackTraceString(group));
        }
        com.cyberlink.you.e.f().f(s);
        com.cyberlink.you.e.d().f(s);
    }

    private boolean a(Group group, List list)
    {
        while (list == null || group == null || group.g != (long)list.size()) 
        {
            return false;
        }
        return true;
    }

    private boolean a(String s, Friend friend)
    {
        if (s.equals("user.user.unblocked"))
        {
            friend.d = false;
            Log.d("Paul", "444 unblock");
        } else
        if (s.equals("user.user.blocked"))
        {
            friend.d = true;
            Log.d("Paul", "444 block");
            return true;
        }
        return true;
    }

    private boolean a(String s, String s1)
    {
        if (s1 != null)
        {
            if ((s1 = c.a(s1)) != null)
            {
                a(s, ((Friend) (s1)));
                if (s.equals("user.user.unblocked") || s.equals("user.user.blocked"))
                {
                    com.cyberlink.you.e.g().a(s1, Friend.f);
                } else
                {
                    com.cyberlink.you.e.g().a(s1, Friend.e);
                }
                return true;
            }
        }
        return false;
    }

    private boolean a(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (!((Friend)list.next()).a())
            {
                return false;
            }
        }

        return true;
    }

    public static Map b(b b1)
    {
        com.cyberlink.you.chat.a a1 = (com.cyberlink.you.chat.a)b1.a("event", "urn:xmpp:custom:event");
        if (a1 == null)
        {
            return null;
        } else
        {
            Log.d("XMPPEventManager", String.format("event packet(%1$s):\n%2$s", new Object[] {
                String.valueOf(g.a().g()), b1.toString()
            }));
            return a1.f();
        }
    }

    private boolean b(b b1, Map map)
    {
        String s;
label0:
        {
            s = b1.o();
            String s1 = b1.i();
            Log.d("XMPPEventManager", "----------- handleMessage in");
            synchronized (a())
            {
                if (com.cyberlink.you.e.d().a(s1) == null)
                {
                    break label0;
                }
                Log.d("XMPPEventManager", "Database(message) already has this record.");
            }
            return false;
        }
        String s2;
        boolean flag;
        s2 = (String)map.get("eventType");
        Log.d("XMPPEventManager", (new StringBuilder()).append("----------- handleMessage in eventType = ").append(s2).toString());
        if (!s2.equals("friend.friend.showed") && !s2.equals("friend.friend.unblocked") && !s2.equals("friend.friend.blocked"))
        {
            break MISSING_BLOCK_LABEL_155;
        }
        flag = a(s2, (String)map.get("userId"));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        b1;
        a1;
        JVM INSTR monitorexit ;
        throw b1;
        if (!s2.equals("user.user.blocked") && !s2.equals("user.user.unblocked"))
        {
            break MISSING_BLOCK_LABEL_200;
        }
        flag = a(s2, (String)map.get("userId"));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("group.group.created") && !s2.equals("group.group.updated") && !s2.equals("group.member.leaved") && !s2.equals("group.member.created") && !s2.equals("group.member.deleted") && !s2.equals("group.group.disabled") && !s2.equals("group.group.hided") && !s2.equals("group.group.enabled") && !s2.equals("group.admin.created") && !s2.equals("group.admin.deleted") && !s2.equals("group.display.name.updated"))
        {
            break MISSING_BLOCK_LABEL_372;
        }
        flag = a(s2, map, (String)map.get("groupId"), (String)map.get("userId"), (String)map.get("actor"), b1);
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("user.display.name.updated") && !s2.equals("user.status.updated"))
        {
            break MISSING_BLOCK_LABEL_410;
        }
        flag = b(p.a(s));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("user.avatar.updated") && !s2.equals("user.coverart.updated"))
        {
            break MISSING_BLOCK_LABEL_448;
        }
        flag = a(p.a(s));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("chat.message.recalled"))
        {
            break MISSING_BLOCK_LABEL_482;
        }
        flag = c((String)map.get("messageId"));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("chat.message.deleted"))
        {
            break MISSING_BLOCK_LABEL_516;
        }
        flag = d((String)map.get("messageId"));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("system.force.reconnect"))
        {
            break MISSING_BLOCK_LABEL_560;
        }
        flag = b((String)map.get("xmppServer"), (String)map.get("xmppPort"));
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("system.force.init"))
        {
            break MISSING_BLOCK_LABEL_582;
        }
        flag = b();
        a1;
        JVM INSTR monitorexit ;
        return flag;
        if (!s2.equals("system.force.logout"))
        {
            break MISSING_BLOCK_LABEL_597;
        }
        a1;
        JVM INSTR monitorexit ;
        return false;
        Log.d("XMPPEventManager", (new StringBuilder()).append("unknown event: ").append(s2).toString());
        a1;
        JVM INSTR monitorexit ;
        return false;
    }

    private boolean b(String s)
    {
        if (s != null && !s.equals(String.valueOf(g.a().g())))
        {
            Friend friend = c.a(s);
            if (friend != null && com.cyberlink.you.e.g().a(String.valueOf(s)) != null)
            {
                com.cyberlink.you.e.g().a(friend);
                s = com.cyberlink.you.e.f().b(friend.c);
                if (s != null)
                {
                    s = c.b(String.valueOf(((Group) (s)).b));
                    if (s != null)
                    {
                        com.cyberlink.you.e.f().a(s, true);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean b(String s, String s1)
    {
        boolean flag = true;
        if (s == null || s1 == null)
        {
            flag = false;
        } else
        {
            c.c(s, s1);
            if (com.cyberlink.you.a.a().a != null)
            {
                s = new Intent();
                s.putExtra("noConnectivity", true);
                s.putExtra("ForceReconnect", true);
                com.cyberlink.you.a.a().a.onReceive(g.I(), s);
                return true;
            }
        }
        return flag;
    }

    private boolean c(String s)
    {
        if (s == null)
        {
            return false;
        }
        MessageObj messageobj = com.cyberlink.you.e.d().a(s);
        com.cyberlink.you.e.d().e(s);
        if (messageobj != null)
        {
            JSONObject jsonobject = g.a().K();
            try
            {
                jsonobject.put(s, messageobj.d().getTime());
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            g.a().a(jsonobject);
        }
        if (messageobj != null)
        {
            i.a(messageobj.c());
        }
        if (messageobj != null)
        {
            s = com.cyberlink.you.e.f().a(messageobj.c());
            if (s != null && messageobj.d().getTime() > ((Group) (s)).k)
            {
                UnreadCountManager.b().a(((Group) (s)).c, false);
            }
        }
        return true;
    }

    private boolean d(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            com.cyberlink.you.e.d().e(s);
            return true;
        }
    }

    public void a(c c1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        e.add(c1);
        obj;
        JVM INSTR monitorexit ;
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public void a(b b1)
    {
        Map map = b(b1);
        if (map == null)
        {
            return;
        }
        try
        {
            b(b1, map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            Log.d("XMPPEventManager", Log.getStackTraceString(b1));
        }
    }

    public void a(b b1, Map map)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = e.iterator(); iterator.hasNext(); ((c)iterator.next()).a(b1, map)) { }
        break MISSING_BLOCK_LABEL_54;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
        obj;
        JVM INSTR monitorexit ;
    }

    public void a(Group group, b b1, String s, String s1)
    {
        Log.d("XMPPEventManager", (new StringBuilder()).append("storeGroupStatusMessageToDB start. eventType : ").append(s).toString());
        String s3 = b1.i();
        long l1 = group.b;
        Date date = b1.k();
        com.cyberlink.you.database.MessageObj.MessageType messagetype = b1.g();
        String s2 = "0";
        if (messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.b))
        {
            s2 = "3";
        }
        group = com.cyberlink.you.database.MessageObj.MemberStatus.a;
        if (s.equals("group.member.leaved"))
        {
            group = com.cyberlink.you.database.MessageObj.MemberStatus.b;
        } else
        if (s.equals("group.member.created"))
        {
            group = com.cyberlink.you.database.MessageObj.MemberStatus.c;
        } else
        if (s.equals("group.member.deleted"))
        {
            group = com.cyberlink.you.database.MessageObj.MemberStatus.d;
        } else
        if (s.equals("group.admin.created"))
        {
            group = com.cyberlink.you.database.MessageObj.MemberStatus.g;
        } else
        if (s.equals("group.admin.deleted"))
        {
            group = com.cyberlink.you.database.MessageObj.MemberStatus.f;
        } else
        {
            if (!s.equals("media.album.deleted"))
            {
                continue;
            }
            group = com.cyberlink.you.database.MessageObj.MemberStatus.j;
        }
        do
        {
            group = new MessageObj(-1L, s3, String.valueOf(l1), date.getTime(), messagetype, s1, 0, b1.e(), "0", group, b1.n(), b1.m(), s2);
            com.cyberlink.you.e.d().a(group);
            do
            {
                return;
            } while (!s.equals("group.display.name.updated"));
            group = com.cyberlink.you.database.MessageObj.MemberStatus.l;
        } while (true);
    }

    public boolean a(String s)
    {
        if (s != null && !s.equals(String.valueOf(g.a().g())))
        {
            Friend friend = c.a(s);
            if (friend == null)
            {
                g.a().g(s);
                return false;
            }
            if (com.cyberlink.you.e.g().a(String.valueOf(s)) != null)
            {
                com.cyberlink.you.e.g().a(friend);
                s = com.cyberlink.you.e.f().b(friend.c);
                if (s != null)
                {
                    s = c.b(String.valueOf(((Group) (s)).b));
                    if (s != null)
                    {
                        com.cyberlink.you.e.f().a(s, true);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean a(String s, Map map, String s1, String s2, String s3, b b1)
    {
        if (s1 == null)
        {
            return false;
        }
        String s4 = b1.o();
        if (s.equals("group.member.leaved") || s.equals("group.member.deleted"))
        {
            if (s2 != null && g.a().b(s2))
            {
                a(com.cyberlink.you.e.f().a(s1), s1);
                return true;
            }
            if (s2 != null && !g.a().b(s2))
            {
                com.cyberlink.you.e.l().b(Long.valueOf(Long.parseLong(s1)), Long.valueOf(Long.parseLong(s2)));
            }
        }
        Group group = c.b(s1);
        if (group == null && b1.a())
        {
            group = com.cyberlink.you.e.f().a(s1);
        }
        if (group == null)
        {
            return false;
        }
        com.cyberlink.you.e.f().a(group, true);
        if (s.equals("group.display.name.updated"))
        {
            String s5 = (String)map.get("displayName");
            String s6 = p.c(s4);
            if (s6 == null)
            {
                return false;
            }
            Friend friend = com.cyberlink.you.e.g().a(s6);
            map = friend;
            if (friend == null)
            {
                Friend friend1 = c.a(s6);
                map = friend1;
                if (friend1 == null)
                {
                    return false;
                }
            }
            group.c(map.b());
            a(group, b1, s, s5);
        }
        if (s.equals("group.member.created"))
        {
            com.cyberlink.you.e.l().c(Long.valueOf(Long.parseLong(s1)), Long.valueOf(Long.parseLong(s2)));
            if (group.e.equals("Dual"))
            {
                return true;
            }
            a(group);
        }
        if (s2 != null && s3 != null && s2.equals(s3) && s.equals("group.member.created"))
        {
            return true;
        }
        if (s.equals("group.member.leaved") || s.equals("group.member.created") || s.equals("group.member.deleted"))
        {
            s1 = com.cyberlink.you.e.g().a(s2);
            map = s1;
            if (s1 == null)
            {
                map = c.a(s2);
                if (map == null)
                {
                    return false;
                }
                com.cyberlink.you.e.g().a(map);
            }
            s2 = map.b();
            s3 = p.c(s4);
            if (s3 == null)
            {
                return false;
            }
            s1 = com.cyberlink.you.e.g().a(s3);
            map = s1;
            if (s1 == null)
            {
                s1 = c.a(s3);
                map = s1;
                if (s1 == null)
                {
                    return false;
                }
            }
            group.c(map.b());
            a(group, b1, s, s2);
        }
        return true;
    }

    public void b(c c1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        if (c1 == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        e.remove(c1);
        obj;
        JVM INSTR monitorexit ;
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public boolean b()
    {
        Log.w("XMPPEventManager", "Force Init");
        l.d();
        n.a().k();
        af.a().c();
        n.b = false;
        n.a().e();
        com.cyberlink.you.a.a().e();
        return true;
    }

}
