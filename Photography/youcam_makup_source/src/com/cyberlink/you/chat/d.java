// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.l;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.utility.ac;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.r;
import org.jivesoftware.smackx.receipts.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.chat:
//            a, ExtensionProviderUtils, n, r

public class d
{

    private static int a = 0;
    private static int b = 0;
    private static boolean c = false;

    public static MessageObj a(String s, com.cyberlink.you.database.MessageObj.MessageType messagetype, String s1)
    {
        String s3 = UUID.randomUUID().toString();
        Date date = new Date();
        String s4 = String.valueOf(g.a().g());
        String s2 = "0";
        if (a(messagetype))
        {
            s2 = "1";
        }
        com.cyberlink.you.database.MessageObj.MemberStatus memberstatus = com.cyberlink.you.database.MessageObj.MemberStatus.a;
        return new MessageObj(-1L, s3, s, date.getTime(), messagetype, s1, 0, s4, "2", memberstatus, false, "", s2);
    }

    public static String a(long l1, String s, String s1, String s2, String s3, String s4, long l2, String s5, String s6, int i, int j, int k, int i1, 
            int j1, long l3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("postId", Long.valueOf(l1));
        hashmap.put("postThumbnail", s);
        hashmap.put("postSourceUrl", s1);
        hashmap.put("postTitle", s2);
        hashmap.put("postType", s3);
        hashmap.put("authorThumbnail", s4);
        hashmap.put("authorUserId", Long.valueOf(l2));
        hashmap.put("authorName", s5);
        hashmap.put("category", s6);
        hashmap.put("width", Integer.valueOf(i));
        hashmap.put("height", Integer.valueOf(j));
        hashmap.put("likeCount", Integer.valueOf(k));
        hashmap.put("replyCount", Integer.valueOf(i1));
        hashmap.put("circleInCount", Integer.valueOf(j1));
        hashmap.put("postCreateTime", Long.valueOf(l3));
        return (new JSONObject(hashmap)).toString();
    }

    public static String a(String s)
    {
        Object obj;
        Object obj1;
        String s3;
        int i;
        long l1;
        i = 0;
        obj1 = "";
        s3 = "";
        l1 = 0L;
        obj = "";
        JSONObject jsonobject = new JSONObject(s);
        if (!jsonobject.has("postId")) goto _L2; else goto _L1
_L1:
        long l2 = jsonobject.getLong("postId");
_L57:
        if (!jsonobject.has("title")) goto _L4; else goto _L3
_L3:
        String s2 = jsonobject.getString("title");
_L58:
        if (!jsonobject.has("creator")) goto _L6; else goto _L5
_L5:
        obj1 = jsonobject.getJSONObject("creator");
        if (!((JSONObject) (obj1)).has("avatar")) goto _L8; else goto _L7
_L7:
        s = ((JSONObject) (obj1)).getString("avatar");
_L59:
        if (!((JSONObject) (obj1)).has("displayName")) goto _L10; else goto _L9
_L9:
        String s1 = ((JSONObject) (obj1)).getString("displayName");
_L60:
        if (!((JSONObject) (obj1)).has("userId")) goto _L12; else goto _L11
_L11:
        l1 = ((JSONObject) (obj1)).getLong("userId");
          goto _L13
_L6:
        String s4 = ((String) (obj));
        if (!jsonobject.has("circles")) goto _L15; else goto _L14
_L14:
        s = jsonobject.getJSONArray("circles");
        s4 = ((String) (obj));
        if (s.length() <= 0) goto _L15; else goto _L16
_L16:
        s = s.getJSONObject(0);
        if (!s.has("circleName")) goto _L18; else goto _L17
_L17:
        s = s.getString("circleName");
          goto _L19
_L15:
        if (!jsonobject.has("attachments")) goto _L21; else goto _L20
_L20:
        s = jsonobject.getJSONObject("attachments");
        if (!s.has("files")) goto _L21; else goto _L22
_L22:
        JSONArray jsonarray = s.getJSONArray("files");
        if (jsonarray.length() <= 0) goto _L24; else goto _L23
_L23:
        s = jsonarray.getJSONObject(0);
        if (!s.has("metadata")) goto _L24; else goto _L25
_L25:
        obj = new JSONObject(s.getString("metadata"));
        if (!((JSONObject) (obj)).has("originalUrl")) goto _L27; else goto _L26
_L26:
        s = ((JSONObject) (obj)).getString("originalUrl");
_L61:
        if (!((JSONObject) (obj)).has("redirectUrl")) goto _L29; else goto _L28
_L28:
        s1 = ((JSONObject) (obj)).getString("redirectUrl");
_L62:
        if (!((JSONObject) (obj)).has("width")) goto _L31; else goto _L30
_L30:
        int j = ((JSONObject) (obj)).getInt("width");
_L63:
        if (!((JSONObject) (obj)).has("height")) goto _L33; else goto _L32
_L32:
        i = ((JSONObject) (obj)).getInt("height");
          goto _L34
_L56:
        int k;
        if (k >= jsonarray.length()) goto _L36; else goto _L35
_L35:
        JSONObject jsonobject1 = jsonarray.getJSONObject(k);
        Object obj2 = obj;
        if (!jsonobject1.has("metadata")) goto _L38; else goto _L37
_L37:
        obj2 = new JSONObject(jsonobject1.getString("metadata"));
        if (!((JSONObject) (obj2)).has("redirectUrl")) goto _L40; else goto _L39
_L39:
        obj2 = ((JSONObject) (obj2)).getString("redirectUrl");
_L64:
        int i1;
        int j1;
        long l3;
        if (obj2 != null)
        {
            try
            {
                obj = Uri.parse(((String) (obj2)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return (new JSONObject()).toString();
            }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        if (((Uri) (obj)).getScheme() != null)
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj2 = Uri.parse((new StringBuilder()).append("http://").append(((Uri) (obj)).toString()).toString());
        if (obj2 != null)
        {
            obj = obj2;
        }
        obj2 = obj;
        if (!((Uri) (obj)).toString().isEmpty()) goto _L38; else goto _L36
_L36:
        if (!jsonobject.has("extLookUrl"))
        {
            break MISSING_BLOCK_LABEL_816;
        }
        obj2 = jsonobject.getString("extLookUrl");
_L65:
        if (!ac.d(((Uri) (obj)))) goto _L42; else goto _L41
_L41:
        obj = "video";
_L51:
        if (!jsonobject.has("likeCount")) goto _L44; else goto _L43
_L43:
        k = jsonobject.getInt("likeCount");
_L52:
        if (!jsonobject.has("commentCount")) goto _L46; else goto _L45
_L45:
        i1 = jsonobject.getInt("commentCount");
_L53:
        if (!jsonobject.has("circleInCount")) goto _L48; else goto _L47
_L47:
        j1 = jsonobject.getInt("circleInCount");
_L54:
        if (!jsonobject.has("createdTime")) goto _L50; else goto _L49
_L49:
        l3 = jsonobject.getLong("createdTime");
_L55:
        return a(l2, s, s1, s2, ((String) (obj)), ((String) (obj1)), l1, s3, s4, j, i, k, i1, j1, l3);
_L42:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_630;
        }
        if (((String) (obj2)).isEmpty())
        {
            break MISSING_BLOCK_LABEL_630;
        }
        obj = "howto";
          goto _L51
        obj = "image";
          goto _L51
_L44:
        k = 0;
          goto _L52
_L46:
        i1 = 0;
          goto _L53
_L48:
        j1 = 0;
          goto _L54
_L50:
        l3 = 0L;
          goto _L55
_L24:
        s1 = "";
        s = "";
        i = 0;
        j = 0;
          goto _L34
_L21:
        s1 = "";
        s = "";
        j = 0;
        obj = null;
          goto _L36
_L13:
        obj1 = s;
        s3 = s1;
          goto _L6
_L19:
        s4 = s;
          goto _L15
_L34:
        obj = null;
        k = 0;
          goto _L56
_L2:
        l2 = 0L;
          goto _L57
_L4:
        s2 = "";
          goto _L58
_L8:
        s = "";
          goto _L59
_L10:
        s1 = "";
          goto _L60
_L12:
        l1 = 0L;
          goto _L13
_L18:
        s = "";
          goto _L19
_L27:
        s = "";
          goto _L61
_L29:
        s1 = "";
          goto _L62
_L31:
        j = 0;
          goto _L63
_L33:
        i = 0;
          goto _L34
_L40:
        obj2 = "";
          goto _L64
_L38:
        k++;
        obj = obj2;
          goto _L56
        obj2 = "";
          goto _L65
    }

    public static String a(String s, String s1, String s2)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("imageItem", s);
        hashmap.put("imageId", s1);
        hashmap.put("mediaId", s2);
        return (new JSONObject(hashmap)).toString();
    }

    public static String a(String s, String s1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("replyMessageId", s);
        hashmap.put("replySender", s2);
        hashmap.put("replyMessage", s1);
        hashmap.put("replyText", s3);
        return (new JSONObject(hashmap)).toString();
    }

    private static String a(Message message, com.cyberlink.you.database.MessageObj.MessageType messagetype, String s)
    {
        if (!messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.a)) goto _L2; else goto _L1
_L1:
        message.e(s);
_L4:
        return s;
_L2:
        if (messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.b))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.c) && !messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.d) && !messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.i))
        {
            break; /* Loop/switch isn't completed */
        }
        long l1 = Long.valueOf(s).longValue();
        messagetype = com.cyberlink.you.e.h().a(l1);
        if (messagetype != null)
        {
            com.cyberlink.you.chat.a a1 = new com.cyberlink.you.chat.a("sticker", "U");
            a1.a("stickerId", Long.toString(messagetype.b()));
            a1.a("packId", Long.toString(messagetype.c()));
            a1.a("width", String.valueOf(messagetype.j()));
            a1.a("height", String.valueOf(messagetype.k()));
            message.a(a1);
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.m))
        {
            break; /* Loop/switch isn't completed */
        }
        if (s != null)
        {
            try
            {
                Object obj1 = new JSONObject(s);
                Object obj = ((JSONObject) (obj1)).getString("replyMessageId");
                messagetype = ((JSONObject) (obj1)).getString("replyMessage");
                String s2 = ((JSONObject) (obj1)).getString("replySender");
                obj1 = ((JSONObject) (obj1)).getString("replyText");
                com.cyberlink.you.chat.a a2 = new com.cyberlink.you.chat.a("textReply", "urn:xmpp:textreply:0");
                a2.a("sourceId ", ((String) (obj)));
                a2.a("sourceSender", s2);
                obj = new ArrayList();
                ((List) (obj)).add(Pair.create("source", messagetype));
                ((List) (obj)).add(Pair.create("body", obj1));
                a2.b(com.cyberlink.you.chat.ExtensionProviderUtils.a(((List) (obj))));
                message.a(a2);
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                message.printStackTrace();
                return s;
            }
            return s;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.n))
        {
            if (s != null)
            {
                try
                {
                    Object obj2 = new JSONObject(s);
                    long l2 = ((JSONObject) (obj2)).getLong("postId");
                    messagetype = ((JSONObject) (obj2)).getString("postThumbnail");
                    String s1 = ((JSONObject) (obj2)).getString("postSourceUrl");
                    String s3 = ((JSONObject) (obj2)).getString("postTitle");
                    String s4 = ((JSONObject) (obj2)).getString("postType");
                    String s5 = ((JSONObject) (obj2)).getString("authorThumbnail");
                    long l3 = ((JSONObject) (obj2)).getLong("authorUserId");
                    String s6 = ((JSONObject) (obj2)).getString("authorName");
                    String s7 = ((JSONObject) (obj2)).getString("category");
                    String s8 = ((JSONObject) (obj2)).getString("width");
                    String s9 = ((JSONObject) (obj2)).getString("height");
                    String s10 = ((JSONObject) (obj2)).getString("likeCount");
                    String s11 = ((JSONObject) (obj2)).getString("replyCount");
                    String s12 = ((JSONObject) (obj2)).getString("circleInCount");
                    obj2 = ((JSONObject) (obj2)).getString("postCreateTime");
                    com.cyberlink.you.chat.a a3 = new com.cyberlink.you.chat.a("post", "U");
                    a3.a("postId", String.valueOf(l2));
                    a3.a("postThumbnail", messagetype);
                    a3.a("postSourceUrl", s1);
                    a3.a("postTitle", s3);
                    a3.a("postType", s4);
                    a3.a("authorThumbnail", s5);
                    a3.a("authorUserId", String.valueOf(l3));
                    a3.a("authorName", s6);
                    a3.a("category", s7);
                    a3.a("width", s8);
                    a3.a("height", s9);
                    a3.a("likeCount", s10);
                    a3.a("replyCount", s11);
                    a3.a("circleInCount", s12);
                    a3.a("postCreateTime", ((String) (obj2)));
                    message.a(a3);
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    message.printStackTrace();
                    return s;
                }
                return s;
            }
        } else
        {
            message.b(messagetype.toString());
            message.e(s);
            return s;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public static Message a(String s, String s1, MessageObj messageobj)
    {
        if (s.equals("Dual"))
        {
            s1 = new Message(s1, org.jivesoftware.smack.packet.Message.Type.b);
        } else
        {
            s1 = new Message(s1, org.jivesoftware.smack.packet.Message.Type.c);
        }
        if (s.equals("Dual"))
        {
            s1.m(com.cyberlink.you.chat.n.a().b());
        }
        s1.k(messageobj.b());
        a(((Message) (s1)), messageobj.e(), messageobj.g());
        if (!a(messageobj))
        {
            s = messageobj.d();
            if (s != null)
            {
                s1.b(new Date(s.getTime() + com.cyberlink.you.friends.l.e));
            }
        }
        return s1;
    }

    public static void a(Message message, com.cyberlink.you.chat.r r1)
    {
        Log.d("ChatUtility", (new StringBuilder()).append("send msg=").append(message.l().toString()).toString());
        org.jivesoftware.smackx.receipts.a.a(message);
        com.cyberlink.you.chat.n.a().a(message, r1);
    }

    public static void a(org.jivesoftware.smack.packet.e e1, com.cyberlink.you.chat.r r1)
    {
        Log.d("ChatUtility", (new StringBuilder()).append("send packet=").append(e1.g().toString()).toString());
        com.cyberlink.you.chat.n.a().a(e1, r1);
    }

    public static boolean a(com.cyberlink.you.database.MessageObj.MessageType messagetype)
    {
        boolean flag = false;
        if (messagetype.equals(com.cyberlink.you.database.MessageObj.MessageType.b))
        {
            flag = true;
        }
        return flag;
    }

    public static boolean a(MessageObj messageobj)
    {
        return a(messageobj.e());
    }

    public static String b(String s, String s1, String s2, String s3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("stickerId", s1);
        hashmap.put("packId", s);
        hashmap.put("width", s2);
        hashmap.put("height", s3);
        return (new JSONObject(hashmap)).toString();
    }

    public static boolean b(MessageObj messageobj)
    {
        boolean flag1 = false;
        if (!a(messageobj)) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            flag = flag1;
            if (!messageobj.j().equals("0"))
            {
                break label0;
            }
            if (!messageobj.k().equals("3"))
            {
                flag = flag1;
                if (!messageobj.k().equals("5"))
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        flag = flag1;
        if (messageobj.j().equals("0"))
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean c(MessageObj messageobj)
    {
        boolean flag1 = false;
        if (!a(messageobj)) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (!messageobj.k().equals("1") && !messageobj.k().equals("2"))
            {
                flag = flag1;
                if (!messageobj.j().equals("2"))
                {
                    break label0;
                }
                if (!messageobj.k().equals("3"))
                {
                    flag = flag1;
                    if (!messageobj.k().equals("5"))
                    {
                        break label0;
                    }
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        flag = flag1;
        if (messageobj.j().equals("2"))
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean d(MessageObj messageobj)
    {
        return messageobj.j().equals("10");
    }

    public static boolean e(MessageObj messageobj)
    {
        boolean flag = false;
        if (messageobj.j().equals("3") || messageobj.k().equals("4"))
        {
            flag = true;
        }
        return flag;
    }

}
