// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.b.a;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.b;

// Referenced classes of package com.cyberlink.you.chat:
//            b, k, l, d, 
//            n, m, r

public class j
{

    private static final Object a = new Object();
    private static final Object b = new Object();
    private static boolean c = false;
    private static List d = new ArrayList();
    private static k e;

    static k a(k k1)
    {
        e = k1;
        return k1;
    }

    public static void a()
    {
        synchronized (a)
        {
            e = null;
            ULogUtility.a("clear()", "XMPPArchiveHelper");
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void a(com.cyberlink.you.chat.b b1)
    {
        if (b1.a())
        {
            Log.d("XMPPArchiveHelper", (new StringBuilder()).append("got an archive message ").append(b1.i()).toString());
            if (e.e.equals("v1"))
            {
                if (e != null)
                {
                    if (e.a == 2)
                    {
                        k k1 = e;
                        k1.c = k1.c + 1;
                        if (b1.g() == com.cyberlink.you.database.MessageObj.MessageType.h)
                        {
                            String s = (String)com.cyberlink.you.b.a.b(b1).get("eventType");
                            if (s.equals("group.member.leaved") || s.equals("group.member.created") || s.equals("group.member.deleted"))
                            {
                                com.cyberlink.you.chat.k.a(e).add(b1);
                            }
                        } else
                        if (b1.q() && !a(com.cyberlink.you.chat.k.a(e), b1))
                        {
                            com.cyberlink.you.chat.k.a(e).add(b1);
                        }
                        if (b1.k().before((Date)e.d))
                        {
                            e.d = b1.k();
                            return;
                        }
                    } else
                    {
                        k k2 = e;
                        k2.c = k2.c + 1;
                        Log.d("XMPPArchiveHelper", (new StringBuilder()).append("mIQWrap.count increase. mIQWrap.count=").append(e.c).append(" message id=").append(b1.i()).toString());
                        ULogUtility.a((new StringBuilder()).append("V1 mIQWrap.count=").append(e.c).append(" iq id=").append(e.b.q()).toString(), "XMPPArchiveHelper");
                        if (b1.k().after((Date)e.d))
                        {
                            e.d = b1.k();
                            return;
                        }
                    }
                } else
                {
                    ULogUtility.a("V1 mIQWrap is null", "XMPPArchiveHelper");
                    return;
                }
            } else
            if (e != null)
            {
                ULogUtility.a((new StringBuilder()).append("V2 mIQWrap.count=").append(e.c).append(" iq id=").append(e.b.q()).toString(), "XMPPArchiveHelper");
                return;
            } else
            {
                ULogUtility.a("V2 mIQWrap is null", "XMPPArchiveHelper");
                return;
            }
        }
    }

    public static void a(com.cyberlink.you.chat.l l1)
    {
        synchronized (b)
        {
            if (c)
            {
                l1.a();
            }
            d.add(l1);
        }
        return;
        l1;
        obj;
        JVM INSTR monitorexit ;
        throw l1;
    }

    public static void a(Object obj, String s)
    {
        a(obj, s, false);
    }

    public static void a(Object obj, String s, boolean flag)
    {
        if (s.equals("v1") && (obj instanceof Date))
        {
            s = (Date)obj;
            IQ iq = new XMPPArchiveHelper._cls3(s);
            iq.a(b.a);
            obj = new k();
            obj.b = iq;
            obj.a = 1;
            obj.d = s;
            obj.f = null;
            obj.e = "v1";
        } else
        if (s.equals("v2") && (obj instanceof String))
        {
            s = (String)obj;
            IQ iq1 = new XMPPArchiveHelper._cls4(s);
            iq1.a(b.a);
            obj = new k();
            obj.b = iq1;
            obj.a = 1;
            obj.d = s;
            obj.f = null;
            obj.e = "v2";
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            a(((k) (obj)), flag);
        }
    }

    public static boolean a(k k1, boolean flag)
    {
        if (e != null)
        {
            return false;
        }
        synchronized (a)
        {
            e = k1;
            com.cyberlink.you.chat.d.a(e.b, new r(flag) {

                final boolean a;

                public void a()
                {
                    if (j.f() != null)
                    {
                        if (a)
                        {
                            j.d();
                        }
                        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("Archive query start: ").append(j.f().d).toString());
                        return;
                    } else
                    {
                        Log.e("XMPPArchiveHelper", "mCurrentQuery is null");
                        return;
                    }
                }

                public void b()
                {
                    com.cyberlink.you.chat.j.a(null);
                }

            
            {
                a = flag;
                super();
            }
            });
        }
        return true;
        k1;
        obj;
        JVM INSTR monitorexit ;
        throw k1;
    }

    public static boolean a(String s, int i, Date date, List list, m m1)
    {
        if (s == null)
        {
            return false;
        }
        IQ iq = new XMPPArchiveHelper._cls2(date, s);
        iq.a(b.a);
        k k1 = new k();
        k1.b = iq;
        k1.a = 2;
        if (date != null)
        {
            k1.d = date;
        } else
        {
            k1.d = new Date(l.c());
        }
        k1.f = s;
        com.cyberlink.you.chat.k.a(k1, list);
        k1.g = m1;
        k1.e = "v1";
        return a(k1, false);
    }

    public static boolean a(List list, com.cyberlink.you.chat.b b1)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (((com.cyberlink.you.chat.b)list.next()).i().equals(b1.i()))
            {
                return true;
            }
        }

        return false;
    }

    public static boolean a(IQ iq)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        k k1 = e;
        if (k1 == null)
        {
            break MISSING_BLOCK_LABEL_688;
        }
        if (!iq.q().equals(k1.b.q())) goto _L2; else goto _L1
_L1:
        e = null;
        if (!k1.e.equals("v1"))
        {
            break MISSING_BLOCK_LABEL_443;
        }
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("Archive query end date: ").append((Date)k1.d).toString());
        if (k1.a != 1) goto _L4; else goto _L3
_L3:
        ULogUtility.a((new StringBuilder()).append("V1 result iq id=").append(iq.q()).append(" count=").append(k1.c).append(" last time=").append((Date)k1.d).toString(), "XMPPArchiveHelper");
        iq = ((IQ) (k1.d));
        if (k1.c < 20) goto _L6; else goto _L5
_L5:
        a(iq, "v1");
_L7:
        obj;
        JVM INSTR monitorexit ;
        return true;
_L6:
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("All archive query end: ").append((Date)k1.d).toString());
        c = true;
        e();
        com.cyberlink.you.chat.n.a().a(org.jivesoftware.smack.packet.Presence.Type.a);
          goto _L7
        iq;
        obj;
        JVM INSTR monitorexit ;
        throw iq;
_L4:
        if (k1.a != 2) goto _L7; else goto _L8
_L8:
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("V1 history result iq id=").append(iq.q()).append(" count=").append(k1.c).append(" last time=").append((Date)k1.d).toString());
        if (com.cyberlink.you.chat.k.a(k1).size() >= 10 || k1.c < 20)
        {
            break MISSING_BLOCK_LABEL_388;
        }
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("histroy archive query next: ").append((Date)k1.d).toString());
        a(k1.f, k1.c, new Date(((Date)k1.d).getTime() - 1L), com.cyberlink.you.chat.k.a(k1), k1.g);
          goto _L7
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("All histroy archive query end: ").append((Date)k1.d).toString());
        if (k1.g != null)
        {
            k1.g.a(com.cyberlink.you.chat.k.a(k1));
        }
          goto _L7
        if (!k1.e.equals("v2")) goto _L2; else goto _L9
_L9:
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("Archive query end cv=").append(iq.e()).append(" empty=").append(iq.d()).toString());
        ULogUtility.a((new StringBuilder()).append("V2 result iq id=").append(iq.q()).append(" cv=").append(iq.e()).append(" empty=").append(iq.d()).toString(), "XMPPArchiveHelper");
        if (iq.e() != null && iq.d() != null)
        {
            break MISSING_BLOCK_LABEL_569;
        }
        return false;
        if (k1.a != 1) goto _L2; else goto _L10
_L10:
        g.a().d(iq.e());
        if (!iq.d().equals("0")) goto _L12; else goto _L11
_L11:
        a(iq.e(), "v2");
_L2:
        obj;
        JVM INSTR monitorexit ;
        return false;
_L12:
        if (!iq.d().equals("1")) goto _L2; else goto _L13
_L13:
        Log.i("XMPPArchiveHelper", (new StringBuilder()).append("All archive query end cv=").append(iq.e()).append(" empty=").append(iq.d()).toString());
        c = true;
        e();
        com.cyberlink.you.chat.n.a().a(org.jivesoftware.smack.packet.Presence.Type.a);
          goto _L2
        obj;
        JVM INSTR monitorexit ;
        return false;
    }

    public static void b()
    {
        String s = g.a().N();
        Object obj;
        if (s.equals("v1"))
        {
            long l1 = g.a().r();
            obj = g.a().q();
            if (l1 != 0L)
            {
                Date date = new Date((l1 - 0L) + 1L);
                if (date.after(((Date) (obj))))
                {
                    obj = date;
                }
            } else
            {
                com.cyberlink.you.chat.n.a().a(org.jivesoftware.smack.packet.Presence.Type.a);
            }
        } else
        {
            obj = g.a().s();
        }
        a(obj, s, true);
    }

    public static void b(com.cyberlink.you.chat.l l1)
    {
        synchronized (b)
        {
            d.remove(l1);
        }
        return;
        l1;
        obj;
        JVM INSTR monitorexit ;
        throw l1;
    }

    public static boolean c()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (e != null && e.a == 1)
        {
            return true;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void d()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((com.cyberlink.you.chat.l)iterator.next()).b()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public static void e()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); ((com.cyberlink.you.chat.l)iterator.next()).a()) { }
        break MISSING_BLOCK_LABEL_46;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    static k f()
    {
        return e;
    }


    // Unreferenced inner class com/cyberlink/you/chat/XMPPArchiveHelper$2

/* anonymous class */
    final class XMPPArchiveHelper._cls2 extends IQ
    {

        final Date a;
        final String b;

        public String a()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
            if (a != null)
            {
                return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:tmp'><with>").append(b).append("</with>").append("<end>").append(simpledateformat.format(a)).append("</end><set xmlns='http://jabber.org/protocol/rsm'><max>").append(20).append("</max><before/></set></query>").toString();
            } else
            {
                return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:tmp'><with>").append(b).append("</with>").append("<set xmlns='http://jabber.org/protocol/rsm'><max>").append(20).append("</max><before/></set></query>").toString();
            }
        }

        public CharSequence b()
        {
            return a();
        }

            
            {
                a = date;
                b = s;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/you/chat/XMPPArchiveHelper$3

/* anonymous class */
    final class XMPPArchiveHelper._cls3 extends IQ
    {

        final Date a;

        public String a()
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
            simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:tmp'><start>").append(simpledateformat.format(a)).append("</start><set xmlns='http://jabber.org/protocol/rsm'><max>").append(20).append("</max></set></query>").toString();
        }

        public CharSequence b()
        {
            return a();
        }

            
            {
                a = date;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/you/chat/XMPPArchiveHelper$4

/* anonymous class */
    final class XMPPArchiveHelper._cls4 extends IQ
    {

        final String a;

        public String a()
        {
            return (new StringBuilder()).append("<query xmlns='urn:xmpp:mam:0'><cv>").append(a).append("</cv></query>").toString();
        }

        public CharSequence b()
        {
            return a();
        }

            
            {
                a = s;
                super();
            }
    }

}
