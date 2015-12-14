// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.cyberlink.you.ChatListHandler;
import com.cyberlink.you.chat.b;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.r;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.util.p;
import org.json.JSONException;
import org.json.JSONObject;

public class i
{

    public static String a(Context context, MessageObj messageobj)
    {
        if (messageobj == null)
        {
            return a(null, null, null);
        } else
        {
            return a(context, messageobj, b(messageobj.i()));
        }
    }

    public static String a(Context context, MessageObj messageobj, Friend friend)
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        long l1;
        boolean flag;
        try
        {
            jsonobject.put("content", "");
            jsonobject.put("time", 0L);
        }
        catch (JSONException jsonexception) { }
        s = "";
        if (context == null)
        {
            return jsonobject.toString();
        }
        l1 = friend.a;
        flag = a(String.valueOf(g.a().g()), String.valueOf(l1));
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.a))
        {
            s = messageobj.g();
        } else
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.b))
        {
            if (flag)
            {
                s = String.format(context.getResources().getString(r.u_notification_chat_you_send_photo), new Object[0]);
            } else
            {
                s = String.format(context.getResources().getString(r.u_notification_chat_user_send_photo), new Object[] {
                    friend.b()
                });
            }
        } else
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.d) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.c) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.i))
        {
            if (flag)
            {
                s = String.format(context.getResources().getString(r.u_notification_chat_you_send_sticker), new Object[0]);
            } else
            {
                s = String.format(context.getResources().getString(r.u_notification_chat_user_send_sticker), new Object[] {
                    friend.b()
                });
            }
        } else
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.j))
        {
            s = String.format(context.getResources().getString(r.u_unsupported_message), new Object[0]);
        } else
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.m))
        {
            s = messageobj.b("replyText");
        } else
        if (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.n))
        {
            if (flag)
            {
                s = String.format(context.getResources().getString(r.u_notification_chat_you_send_bc_post), new Object[0]);
            } else
            {
                s = String.format(context.getResources().getString(r.u_notification_chat_user_send_bc_post), new Object[] {
                    friend.b()
                });
            }
            context = messageobj.b("postThumbnail");
            try
            {
                jsonobject.put("postThumbnail", context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
        }
        try
        {
            jsonobject.put("content", s);
            jsonobject.put("time", messageobj.d().getTime());
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        return jsonobject.toString();
    }

    public static void a(Group group, b b1)
    {
        if (group != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((b1 = b1.a(String.valueOf(group.b))) == null) goto _L1; else goto _L3
_L3:
        if (group.p == null || group.p.isEmpty())
        {
            break; /* Loop/switch isn't completed */
        }
        long l1 = (new JSONObject(group.p)).getLong("time");
        if (l1 == 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = b1.d().before(new Date(l1));
        if (flag) goto _L1; else goto _L4
_L4:
        group.p = a(g.I(), ((MessageObj) (b1)));
        b1 = new ArrayList();
        b1.add("LastMsg");
        e.f().a(String.valueOf(group.b), group, b1);
        ChatListHandler.d(group.b);
        return;
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static void a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        MessageObj messageobj = e.d().b(s);
        if (messageobj == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        long l1;
        if (messageobj.d() == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        l1 = messageobj.d().getTime();
_L5:
        Group group = new Group();
        if (l1 != 0L)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        group.p = "";
        group.n = 0L;
_L4:
        e.f().a(s, group, "LastMsg");
        ChatListHandler.d(Long.valueOf(s).longValue());
        return;
        group.p = a(g.I(), messageobj);
        group.n = l1;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        Log.e("LastMessageUtils", (new StringBuilder()).append("[updateLastMessage] Error : ").append(s.getMessage()).toString());
_L2:
        return;
        l1 = 0L;
          goto _L5
    }

    public static boolean a(String s, String s1)
    {
        while (s == null || s1 == null || p.a(s) == null || !s1.equals(s)) 
        {
            return false;
        }
        return true;
    }

    private static Friend b(String s)
    {
        Object obj = g.a().M();
        Object obj1;
        if (((Map) (obj)).containsKey(s))
        {
            obj = (Friend)((Map) (obj)).get(s);
        } else
        {
            obj = e.g().a(s);
        }
        obj1 = obj;
        if (obj == null)
        {
            s = (new l()).a(s);
            obj1 = s;
            if (s != null)
            {
                e.g().a(s);
                obj1 = s;
            }
        }
        return ((Friend) (obj1));
    }
}
