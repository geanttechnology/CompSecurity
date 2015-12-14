// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.sticker.StickerObj;
import com.cyberlink.you.utility.d;
import com.cyberlink.you.utility.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.util.p;
import org.jivesoftware.smackx.carbons.packet.CarbonExtension;
import org.jivesoftware.smackx.forward.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.chat:
//            a, c, d

public class b
{

    private Message a;
    private com.cyberlink.you.database.MessageObj.MessageType b;
    private String c;
    private c d;
    private Map e;
    private Map f;
    private Group g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private Date q;

    public b(Message message)
    {
        b = com.cyberlink.you.database.MessageObj.MessageType.f;
        c = null;
        d = null;
        e = new HashMap();
        f = new HashMap();
        a = message;
        h = false;
        i = false;
        j = false;
        k = false;
        q = new Date(com.cyberlink.you.friends.l.c());
        s();
        if (a.o() <= 1)
        {
            t();
        } else
        {
            b = com.cyberlink.you.database.MessageObj.MessageType.j;
        }
        if (a.i() != null)
        {
            q = a.i();
        }
    }

    static com.cyberlink.you.database.MessageObj.MessageType a(b b1, com.cyberlink.you.database.MessageObj.MessageType messagetype)
    {
        b1.b = messagetype;
        return messagetype;
    }

    static com.cyberlink.you.database.MessageObj.MessageType a(b b1, String s1)
    {
        return b1.b(s1);
    }

    static Map a(b b1)
    {
        return b1.e;
    }

    private com.cyberlink.you.database.MessageObj.MessageType b(String s1)
    {
        Object obj;
        try
        {
            obj = new JSONObject(s1);
        }
        catch (JSONException jsonexception)
        {
            Log.e("CLXMPPMessage", (new StringBuilder()).append("[sticker.sticker.info] Parse error. JSONstr=").append(s1).toString());
            return com.cyberlink.you.database.MessageObj.MessageType.c;
        }
        try
        {
            obj = ((JSONObject) (obj)).getJSONArray("results");
        }
        catch (JSONException jsonexception1)
        {
            Log.e("CLXMPPMessage", (new StringBuilder()).append("[sticker.pack.info] 'results' missing. JSONstr=").append(s1).toString());
            return com.cyberlink.you.database.MessageObj.MessageType.c;
        }
        s1 = com.cyberlink.you.utility.h.a(((JSONArray) (obj)), false, false);
        if (s1 != null && s1.size() > 0)
        {
            com.cyberlink.you.e.i().a(s1);
            return com.cyberlink.you.utility.d.h(((StickerPackObj)s1.get(0)).d());
        } else
        {
            return com.cyberlink.you.database.MessageObj.MessageType.c;
        }
    }

    static void b(b b1, String s1)
    {
        b1.c(s1);
    }

    private void c(String s1)
    {
        Object obj;
        ArrayList arraylist;
        int i1;
        try
        {
            obj = new JSONObject(s1);
        }
        catch (JSONException jsonexception)
        {
            Log.e("CLXMPPMessage", (new StringBuilder()).append("[sticker.sticker.info] Parse error. JSONstr=").append(s1).toString());
            return;
        }
        try
        {
            obj = ((JSONObject) (obj)).getJSONArray("results");
        }
        catch (JSONException jsonexception1)
        {
            Log.e("CLXMPPMessage", (new StringBuilder()).append("[sticker.sticker.info] 'results' missing. JSONstr=").append(s1).toString());
            return;
        }
        arraylist = new ArrayList();
        i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= ((JSONArray) (obj)).length())
                {
                    break label0;
                }
                Object obj1;
                try
                {
                    obj1 = ((JSONArray) (obj)).getJSONObject(i1);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    Log.e("CLXMPPMessage", (new StringBuilder()).append("[sticker.sticker.info] stickerInfo parse error. JSONstr=").append(s1).toString());
                    break label1;
                }
                try
                {
                    long l1 = ((JSONObject) (obj1)).getLong("stickerId");
                    long l2 = ((JSONObject) (obj1)).getLong("packId");
                    StickerObj stickerobj = new StickerObj(-1L, l1, l2, ((JSONObject) (obj1)).getLong("stickerOrder"), ((JSONObject) (obj1)).getLong("lastModified"), ((JSONObject) (obj1)).getString("originalURL"), ((JSONObject) (obj1)).getString("thumbnailURL"), 0, 0);
                    stickerobj.b((new StringBuilder()).append(com.cyberlink.you.utility.d.a(l2)).append(File.separator).append(String.valueOf(l1)).append("_").append("thumbnail").toString());
                    stickerobj.a((new StringBuilder()).append(com.cyberlink.you.utility.d.a(l2)).append(File.separator).append(String.valueOf(l1)).toString());
                    arraylist.add(stickerobj);
                }
                catch (JSONException jsonexception2)
                {
                    Log.e("CLXMPPMessage", (new StringBuilder()).append("[sticker.sticker.list] Parse item error. JSONstr=").append(((JSONObject) (obj1)).toString()).toString());
                }
            }
            i1++;
        } while (true);
        com.cyberlink.you.e.h().a(arraylist);
    }

    private void s()
    {
        Object obj = (CarbonExtension)a.c("sent", "urn:xmpp:carbons:2");
        if (obj != null)
        {
            obj = (Message)((CarbonExtension) (obj)).c().d();
            if (obj != null)
            {
                i = true;
                a = ((Message) (obj));
            }
        }
        if (a.c("result", "urn:xmpp:mam:tmp") != null)
        {
            Object obj1 = (a)a.c("forwarded", "urn:xmpp:forward:0");
            if (obj1 != null)
            {
                a = (Message)((a) (obj1)).d();
                if (a != null)
                {
                    l = a.r();
                    m = a.s();
                    n = a.c().toString();
                    o = a.q();
                }
                obj1 = ((a) (obj1)).e();
                if (obj1 != null)
                {
                    q = ((org.jivesoftware.smackx.delay.a.a) (obj1)).e();
                }
            }
            h = true;
            return;
        } else
        {
            u();
            return;
        }
    }

    private void t()
    {
        if (a.d() != null && a.f() != null)
        {
            b = com.cyberlink.you.database.MessageObj.MessageType.valueOf(a.d());
            c = a.f();
        } else
        {
            c = a.f();
            if (c != null)
            {
                b = com.cyberlink.you.database.MessageObj.MessageType.a;
                return;
            }
            if (a.c("media", "U") != null)
            {
                v();
                return;
            }
            if (a.c("sticker", "U") != null)
            {
                w();
                return;
            }
            if (a.c("received", "urn:xmpp:receipts") != null)
            {
                b = com.cyberlink.you.database.MessageObj.MessageType.e;
                return;
            }
            if (a.c("event", "urn:xmpp:custom:event") != null)
            {
                x();
                return;
            }
            if (a.c("textReply", "urn:xmpp:textreply:0") != null)
            {
                y();
                return;
            }
            if (a.c("post", "U") != null)
            {
                z();
                return;
            }
            if (a.n())
            {
                b = com.cyberlink.you.database.MessageObj.MessageType.j;
                return;
            }
        }
    }

    private void u()
    {
        try
        {
            if (a.c("delay", "urn:xmpp:delay") != null)
            {
                q = ((org.jivesoftware.smackx.delay.a.a)a.c("delay", "urn:xmpp:delay")).e();
                k = true;
            }
            return;
        }
        catch (Exception exception)
        {
            Log.d("CLXMPPMessage", (new StringBuilder()).append("Error msg=").append(a.toString()).toString());
        }
    }

    private void v()
    {
        com.cyberlink.you.chat.a a1 = (com.cyberlink.you.chat.a)a.c("media", "U");
        d = new c(this);
        d.a = Long.parseLong(a1.a("mediaId"));
        d.b = a1.a("mediaType");
        d.c = a1.a("albumId");
        d.d = StringEscapeUtils.unescapeXml(a1.a("thumbnail"));
        d.e = StringEscapeUtils.unescapeXml(a1.a("original"));
        d.f = Integer.valueOf(a1.a("width")).intValue();
        d.g = Integer.valueOf(a1.a("height")).intValue();
_L3:
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
        Exception exception2;
        exception2;
        a1 = null;
_L5:
        if (d != null)
        {
            d.f = 0;
            d.g = 0;
        }
        exception2.printStackTrace();
          goto _L3
_L2:
        String s1 = StringEscapeUtils.unescapeXml(a1.a("description"));
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        boolean flag = s1.isEmpty();
        if (flag);
_L4:
        s1 = a1.a("noteMediaType");
        if (s1 != null)
        {
            try
            {
                if (!s1.isEmpty())
                {
                    a1.a("noteMediaDescription");
                }
            }
            catch (Exception exception1) { }
        }
        if (d.b != null)
        {
            try
            {
                b = com.cyberlink.you.database.MessageObj.MessageType.valueOf(d.b);
            }
            catch (Exception exception) { }
            if (b.equals(com.cyberlink.you.database.MessageObj.MessageType.b))
            {
                c = com.cyberlink.you.chat.d.a(null, null, String.valueOf(d.a));
                return;
            }
        }
          goto _L1
        s1;
          goto _L4
        s1;
          goto _L5
    }

    private void w()
    {
        Object obj;
        try
        {
            obj = (com.cyberlink.you.chat.a)a.c("sticker", "U");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            obj = null;
        }
        if (obj == null)
        {
            return;
        }
        b = com.cyberlink.you.database.MessageObj.MessageType.c;
        String s1 = ((com.cyberlink.you.chat.a) (obj)).a("stickerId");
        String s2 = ((com.cyberlink.you.chat.a) (obj)).a("packId");
        String s3 = ((com.cyberlink.you.chat.a) (obj)).a("width");
        obj = ((com.cyberlink.you.chat.a) (obj)).a("height");
        e.clear();
        f.clear();
        Object obj1 = com.cyberlink.you.g.a().e();
        ArrayList arraylist = new ArrayList();
        StickerPackObj stickerpackobj = com.cyberlink.you.e.i().a(NumberUtils.toLong(s2, -1L));
        if (stickerpackobj != null)
        {
            b = com.cyberlink.you.utility.d.h(stickerpackobj.d());
        } else
        {
            e.put("GetPackType", Boolean.valueOf(false));
            arraylist.add(new BasicNameValuePair("token", ((String) (obj1))));
            arraylist.add(new BasicNameValuePair("packId", s2));
            (new l()).a("sticker", "pack.info", arraylist, new com.cyberlink.you.friends.p() {

                final b a;

                public void a(String s4, String s5, String s6, String s7)
                {
                    if (s6 == null)
                    {
                        Log.d("CLXMPPMessage", "Response is null");
                        com.cyberlink.you.chat.b.a(a, com.cyberlink.you.database.MessageObj.MessageType.k);
                    } else
                    if (!s6.equals("200"))
                    {
                        Log.d("CLXMPPMessage", (new StringBuilder()).append("statusCode=").append(s6).toString());
                        com.cyberlink.you.chat.b.a(a, com.cyberlink.you.database.MessageObj.MessageType.k);
                    } else
                    {
                        com.cyberlink.you.chat.b.a(a, com.cyberlink.you.chat.b.a(a, s7));
                    }
                    com.cyberlink.you.chat.b.a(a).put("GetPackType", Boolean.valueOf(true));
                }

            
            {
                a = b.this;
                super();
            }
            });
        }
        if (com.cyberlink.you.e.h().a(Long.parseLong(s1)) == null)
        {
            e.put("ParseSticker", Boolean.valueOf(false));
            arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("token", ((String) (obj1))));
            arraylist.add(new BasicNameValuePair("stickerId", s1));
            (new l()).a("sticker", "sticker.info", arraylist, new com.cyberlink.you.friends.p() {

                final b a;

                public void a(String s4, String s5, String s6, String s7)
                {
                    if (s6 == null)
                    {
                        Log.d("CLXMPPMessage", "Response is null");
                    } else
                    if (!s6.equals("200"))
                    {
                        Log.d("CLXMPPMessage", (new StringBuilder()).append("statusCode=").append(s6).toString());
                    } else
                    {
                        b.b(a, s7);
                    }
                    com.cyberlink.you.chat.b.a(a).put("ParseSticker", Boolean.valueOf(true));
                }

            
            {
                a = b.this;
                super();
            }
            });
        }
        while (!d()) 
        {
            try
            {
                Thread.sleep(100L);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                Log.d("CLXMPPMessage", Log.getStackTraceString(((Throwable) (obj1))));
            }
        }
        obj1 = com.cyberlink.you.e.h().a(Long.valueOf(s1).longValue());
        if (obj1 != null)
        {
            try
            {
                ((StickerObj) (obj1)).a(Integer.valueOf(s3).intValue());
                ((StickerObj) (obj1)).b(Integer.valueOf(((String) (obj))).intValue());
                com.cyberlink.you.e.h().a(((StickerObj) (obj1)).b(), ((StickerObj) (obj1)));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if (com.cyberlink.you.database.MessageObj.MessageType.k.equals(b))
        {
            c = com.cyberlink.you.chat.d.b(s2, s1, s3, ((String) (obj)));
            return;
        } else
        {
            c = s1;
            return;
        }
    }

    private void x()
    {
        b = com.cyberlink.you.database.MessageObj.MessageType.h;
        c = "";
    }

    private void y()
    {
        try
        {
            Object obj = (com.cyberlink.you.chat.a)a.c("textReply", "urn:xmpp:textreply:0");
            String s1 = ((com.cyberlink.you.chat.a) (obj)).a("sourceId ");
            String s2 = ((com.cyberlink.you.chat.a) (obj)).a("sourceSender");
            Object obj1 = new JSONObject(((com.cyberlink.you.chat.a) (obj)).c());
            obj = ((JSONObject) (obj1)).getString("source");
            obj1 = ((JSONObject) (obj1)).getString("body");
            HashMap hashmap = new HashMap();
            hashmap.put("replyMessageId", s1);
            hashmap.put("replySender", s2);
            hashmap.put("replyMessage", obj);
            hashmap.put("replyText", obj1);
            c = (new JSONObject(hashmap)).toString();
            b = com.cyberlink.you.database.MessageObj.MessageType.m;
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void z()
    {
        try
        {
            Object obj = (com.cyberlink.you.chat.a)a.c("post", "U");
            String s1 = ((com.cyberlink.you.chat.a) (obj)).a("postId");
            String s2 = ((com.cyberlink.you.chat.a) (obj)).a("postThumbnail");
            String s3 = ((com.cyberlink.you.chat.a) (obj)).a("postSourceUrl");
            String s4 = ((com.cyberlink.you.chat.a) (obj)).a("postTitle");
            String s5 = ((com.cyberlink.you.chat.a) (obj)).a("postType");
            String s6 = ((com.cyberlink.you.chat.a) (obj)).a("authorThumbnail");
            String s7 = ((com.cyberlink.you.chat.a) (obj)).a("authorUserId");
            String s8 = ((com.cyberlink.you.chat.a) (obj)).a("authorName");
            String s9 = ((com.cyberlink.you.chat.a) (obj)).a("category");
            String s10 = ((com.cyberlink.you.chat.a) (obj)).a("width");
            String s11 = ((com.cyberlink.you.chat.a) (obj)).a("height");
            String s12 = ((com.cyberlink.you.chat.a) (obj)).a("likeCount");
            String s13 = ((com.cyberlink.you.chat.a) (obj)).a("replyCount");
            String s14 = ((com.cyberlink.you.chat.a) (obj)).a("circleInCount");
            obj = ((com.cyberlink.you.chat.a) (obj)).a("postCreateTime");
            c = com.cyberlink.you.chat.d.a(Long.valueOf(s1).longValue(), s2, s3, s4, s5, s6, Long.valueOf(s7).longValue(), s8, s9, Integer.valueOf(s10).intValue(), Integer.valueOf(s11).intValue(), Integer.valueOf(s12).intValue(), Integer.valueOf(s13).intValue(), Integer.valueOf(s14).intValue(), Long.valueOf(((String) (obj))).longValue());
            b = com.cyberlink.you.database.MessageObj.MessageType.n;
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public MessageObj a(String s1)
    {
        if (q() || g() == com.cyberlink.you.database.MessageObj.MessageType.h)
        {
            String s3 = i();
            Date date = k();
            com.cyberlink.you.database.MessageObj.MessageType messagetype = g();
            String s4 = h();
            String s5 = e();
            String s2 = "0";
            if (com.cyberlink.you.chat.d.a(messagetype))
            {
                s2 = "3";
            }
            com.cyberlink.you.database.MessageObj.MemberStatus memberstatus = com.cyberlink.you.database.MessageObj.MemberStatus.a;
            return new MessageObj(-1L, s3, s1, date.getTime(), messagetype, s4, 0, s5, "0", memberstatus, n(), m(), s2);
        } else
        {
            return null;
        }
    }

    public f a(String s1, String s2)
    {
        return a.c(s1, s2);
    }

    public void a(Group group)
    {
        g = group;
    }

    public boolean a()
    {
        return h;
    }

    public boolean b()
    {
        return j;
    }

    public XMPPError c()
    {
        return a.t();
    }

    public boolean d()
    {
        Iterator iterator = e.values().iterator();
        boolean flag;
        for (flag = true; iterator.hasNext(); flag = ((Boolean)iterator.next()).booleanValue() & flag) { }
        return flag;
    }

    public String e()
    {
        Object obj = o();
        if (((String) (obj)).contains("@conference.u.cyberlink.com") && !p().equals(com.cyberlink.you.g.a().f()))
        {
            obj = ((String) (obj)).split("/");
            if (obj.length >= 2)
            {
                return obj[1];
            } else
            {
                return null;
            }
        } else
        {
            return ((String) (obj)).split("@")[0];
        }
    }

    public String f()
    {
        String as[] = o().split("/");
        if (as.length >= 2)
        {
            return as[1];
        } else
        {
            return null;
        }
    }

    public com.cyberlink.you.database.MessageObj.MessageType g()
    {
        return b;
    }

    public String h()
    {
        return c;
    }

    public String i()
    {
        if (a())
        {
            return o;
        } else
        {
            return a.q();
        }
    }

    public org.jivesoftware.smack.packet.Message.Type j()
    {
        if (a())
        {
            if (n.equals(org.jivesoftware.smack.packet.Message.Type.b.toString()))
            {
                return org.jivesoftware.smack.packet.Message.Type.b;
            }
            if (n.equals(org.jivesoftware.smack.packet.Message.Type.c.toString()))
            {
                return org.jivesoftware.smack.packet.Message.Type.c;
            }
        }
        return a.c();
    }

    public Date k()
    {
        return q;
    }

    public String l()
    {
        if (a())
        {
            return l;
        } else
        {
            return a.r();
        }
    }

    public String m()
    {
        return a.m();
    }

    public boolean n()
    {
        return a.n();
    }

    public String o()
    {
        if (a())
        {
            return m;
        }
        if (b())
        {
            return p;
        } else
        {
            return a.s();
        }
    }

    public String p()
    {
        if (b == com.cyberlink.you.database.MessageObj.MessageType.h)
        {
            Object obj = (com.cyberlink.you.chat.a)a("event", "urn:xmpp:custom:event");
            if (obj == null)
            {
                return "";
            }
            obj = ((com.cyberlink.you.chat.a) (obj)).f();
            if ((String)((Map) (obj)).get("groupId") != null)
            {
                obj = com.cyberlink.you.e.f().a((String)((Map) (obj)).get("groupId"));
                if (obj != null)
                {
                    return ((Group) (obj)).c;
                }
            }
        } else
        if (j)
        {
            return org.jivesoftware.smack.util.p.d(l());
        }
        return org.jivesoftware.smack.util.p.d(o());
    }

    public boolean q()
    {
        return g() == com.cyberlink.you.database.MessageObj.MessageType.a || g() == com.cyberlink.you.database.MessageObj.MessageType.d || g() == com.cyberlink.you.database.MessageObj.MessageType.i || g() == com.cyberlink.you.database.MessageObj.MessageType.c || g() == com.cyberlink.you.database.MessageObj.MessageType.b || g() == com.cyberlink.you.database.MessageObj.MessageType.j || g() == com.cyberlink.you.database.MessageObj.MessageType.k || g() == com.cyberlink.you.database.MessageObj.MessageType.m || g() == com.cyberlink.you.database.MessageObj.MessageType.n;
    }

    public Group r()
    {
        return g;
    }

    public String toString()
    {
        return a.toString();
    }
}
