// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.database;

import android.content.ContentValues;
import android.util.Log;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageObj
{

    protected long a;
    public int b;
    public boolean c;
    public boolean d;
    private String e;
    private String f;
    private Date g;
    private MessageType h;
    private String i;
    private int j;
    private String k;
    private String l;
    private String m;
    private MemberStatus n;
    private boolean o;
    private String p;
    private Date q;

    public MessageObj(long l1, String s, String s1, long l2, MessageType messagetype, 
            String s2, int i1, String s3, String s4, MemberStatus memberstatus, boolean flag, String s5, 
            String s6)
    {
        q = null;
        a = l1;
        e = s;
        f = s1;
        g = new Date(l2);
        h = messagetype;
        i = s2;
        j = i1;
        k = s3;
        l = s4;
        n = memberstatus;
        o = flag;
        p = s5;
        b = 0;
        c = false;
        d = false;
        m = s6;
    }

    public static MessageObj c(Date date)
    {
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).setTime(date);
        ((Calendar) (obj)).set(10, 0);
        ((Calendar) (obj)).set(12, 0);
        ((Calendar) (obj)).set(13, 0);
        ((Calendar) (obj)).set(14, 0);
        date = ((Calendar) (obj)).getTime();
        obj = MessageType.g;
        return new MessageObj(-1L, "-1", "", date.getTime(), ((MessageType) (obj)), "", 0, "", "", MemberStatus.a, false, "", "0");
    }

    public static MessageObj d(Date date)
    {
        MessageType messagetype = MessageType.l;
        return new MessageObj(-1L, "-1", "", date.getTime() - 1L, messagetype, "", 0, "", "", MemberStatus.a, false, "", "0");
    }

    public long a()
    {
        return a;
    }

    public ContentValues a(List list)
    {
        if (list == null)
        {
            return new ContentValues();
        }
        ContentValues contentvalues = new ContentValues();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s = (String)list.next();
            if (s != null && !s.isEmpty())
            {
                if (s.equals("MessageId"))
                {
                    contentvalues.put("MessageId", b());
                } else
                if (s.equals("GroupId"))
                {
                    contentvalues.put("GroupId", c());
                } else
                if (s.equals("SendTime"))
                {
                    contentvalues.put("SendTime", Long.valueOf(d().getTime()));
                } else
                if (s.equals("MessageType"))
                {
                    contentvalues.put("MessageType", e().toString());
                } else
                if (s.equals("MessageContent"))
                {
                    contentvalues.put("MessageContent", g());
                } else
                if (s.equals("ReadCount"))
                {
                    contentvalues.put("ReadCount", Integer.valueOf(h()));
                } else
                if (s.equals("UserId"))
                {
                    contentvalues.put("UserId", i());
                } else
                if (s.equals("Status"))
                {
                    contentvalues.put("Status", j());
                } else
                if (s.equals("MemberStatus"))
                {
                    contentvalues.put("MemberStatus", f().toString());
                } else
                if (s.equals("IsNewVersion"))
                {
                    int i1;
                    if (l())
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 0;
                    }
                    contentvalues.put("IsNewVersion", Integer.valueOf(i1));
                } else
                if (s.equals("SrcXml"))
                {
                    contentvalues.put("SrcXml", m());
                } else
                if (s.equals("UploadStatus"))
                {
                    contentvalues.put("UploadStatus", k());
                }
            }
        } while (true);
        return contentvalues;
    }

    public void a(int i1)
    {
        j = i1;
    }

    public void a(String s)
    {
        e = s;
    }

    public void a(Date date)
    {
        g = date;
    }

    public String b()
    {
        return e;
    }

    public String b(String s)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        JSONObject jsonobject;
        if (i == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        jsonobject = new JSONObject(i);
        obj = obj1;
        if (jsonobject.has(s))
        {
            obj = obj1;
            try
            {
                if (!jsonobject.isNull(s))
                {
                    obj = jsonobject.getString(s);
                }
            }
            catch (JSONException jsonexception)
            {
                Log.d("MessageObj", (new StringBuilder()).append("[getValueFromMessageContent] Fail by key=").append(s).toString());
                jsonexception = obj1;
                if (s.equals("mediaId"))
                {
                    return g();
                }
            }
        }
        return ((String) (obj));
    }

    public void b(Date date)
    {
        q = date;
    }

    public String c()
    {
        return f;
    }

    public void c(String s)
    {
        l = s;
    }

    public ContentValues d(String s)
    {
        if (s == null || s.isEmpty())
        {
            return new ContentValues();
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(s);
            return a(arraylist);
        }
    }

    public Date d()
    {
        return g;
    }

    public MessageType e()
    {
        return h;
    }

    public MemberStatus f()
    {
        return n;
    }

    public String g()
    {
        return i;
    }

    public int h()
    {
        return j;
    }

    public String i()
    {
        return k;
    }

    public String j()
    {
        return l;
    }

    public String k()
    {
        return m;
    }

    public boolean l()
    {
        return o;
    }

    public String m()
    {
        return p;
    }

    public Date n()
    {
        return q;
    }

    public ContentValues o()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_id", Long.valueOf(a()));
        contentvalues.put("MessageId", b());
        contentvalues.put("GroupId", c());
        contentvalues.put("SendTime", Long.valueOf(d().getTime()));
        contentvalues.put("MessageType", e().toString());
        contentvalues.put("MessageContent", g());
        contentvalues.put("ReadCount", Integer.valueOf(h()));
        contentvalues.put("UserId", i());
        contentvalues.put("Status", j());
        contentvalues.put("MemberStatus", f().toString());
        int i1;
        if (l())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        contentvalues.put("IsNewVersion", Integer.valueOf(i1));
        contentvalues.put("SrcXml", m());
        contentvalues.put("UploadStatus", k());
        return contentvalues;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("{").append("\n");
        stringbuffer.append((new StringBuilder()).append("  _id: ").append(a).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  MessageId: ").append(e).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  GroupId: ").append(f).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  SendingTime: ").append(g).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  MessageContent: ").append(i).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  ReadCount: ").append(j).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  UserId: ").append(k).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  Status: ").append(l).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  MemberStatus: ").append(n).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  IsNewVersion: ").append(o).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  SrcXml: ").append(p).toString()).append("\n");
        stringbuffer.append((new StringBuilder()).append("  UploadStatus: ").append(m).toString()).append("\n");
        stringbuffer.append("}");
        return stringbuffer.toString();
    }

    private class MessageType extends Enum
    {

        public static final MessageType a;
        public static final MessageType b;
        public static final MessageType c;
        public static final MessageType d;
        public static final MessageType e;
        public static final MessageType f;
        public static final MessageType g;
        public static final MessageType h;
        public static final MessageType i;
        public static final MessageType j;
        public static final MessageType k;
        public static final MessageType l;
        public static final MessageType m;
        public static final MessageType n;
        private static final MessageType o[];

        public static MessageType valueOf(String s)
        {
            return (MessageType)Enum.valueOf(com/cyberlink/you/database/MessageObj$MessageType, s);
        }

        public static MessageType[] values()
        {
            return (MessageType[])o.clone();
        }

        static 
        {
            a = new MessageType("Text", 0);
            b = new MessageType("Photo", 1);
            c = new MessageType("Sticker", 2);
            d = new MessageType("AnimSticker", 3);
            e = new MessageType("DeliveryReceipt", 4);
            f = new MessageType("None", 5);
            g = new MessageType("Date", 6);
            h = new MessageType("Event", 7);
            i = new MessageType("AnimPngSticker", 8);
            j = new MessageType("NewVersion", 9);
            k = new MessageType("StickerTypeUnknown", 10);
            l = new MessageType("UnreadLine", 11);
            m = new MessageType("ReplyText", 12);
            n = new MessageType("BCPost", 13);
            o = (new MessageType[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l, m, n
            });
        }

        private MessageType(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class MemberStatus extends Enum
    {

        public static final MemberStatus a;
        public static final MemberStatus b;
        public static final MemberStatus c;
        public static final MemberStatus d;
        public static final MemberStatus e;
        public static final MemberStatus f;
        public static final MemberStatus g;
        public static final MemberStatus h;
        public static final MemberStatus i;
        public static final MemberStatus j;
        public static final MemberStatus k;
        public static final MemberStatus l;
        private static final MemberStatus m[];

        public static MemberStatus valueOf(String s)
        {
            return (MemberStatus)Enum.valueOf(com/cyberlink/you/database/MessageObj$MemberStatus, s);
        }

        public static MemberStatus[] values()
        {
            return (MemberStatus[])m.clone();
        }

        static 
        {
            a = new MemberStatus("NO_MemberStatus", 0);
            b = new MemberStatus("MemberLeave", 1);
            c = new MemberStatus("MemberCreate", 2);
            d = new MemberStatus("MemberDeleted", 3);
            e = new MemberStatus("MediaCreate", 4);
            f = new MemberStatus("AdminDeleted", 5);
            g = new MemberStatus("AdminCreate", 6);
            h = new MemberStatus("MediaDelete", 7);
            i = new MemberStatus("AlbumCreate", 8);
            j = new MemberStatus("AlbumDelete", 9);
            k = new MemberStatus("PhotoComment", 10);
            l = new MemberStatus("DisplayNameUpdated", 11);
            m = (new MemberStatus[] {
                a, b, c, d, e, f, g, h, i, j, 
                k, l
            });
        }

        private MemberStatus(String s, int i1)
        {
            super(s, i1);
        }
    }

}
