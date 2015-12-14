// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.b.a;
import com.cyberlink.you.database.EventObj;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.c;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.j;
import com.cyberlink.you.database.k;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import com.cyberlink.you.utility.i;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.h;
import org.jivesoftware.smack.packet.CLResumed;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.StreamMgmt;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.receipts.DeliveryReceipt;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.cyberlink.you.chat:
//            n, b, a, y, 
//            j, x, z, v, 
//            NotificationHelper, aa, w

public class u
    implements h
{

    private Object a;
    private Object b;
    private ArrayList c;
    private Thread d;
    private List e;
    private List f;
    private x g;
    private v h;
    private z i;

    public u()
    {
        a = new Object();
        b = new Object();
        c = new ArrayList();
        d = null;
        e = new ArrayList();
        f = new ArrayList();
        g = null;
        h = null;
        i = null;
    }

    static ArrayList a(u u1)
    {
        return u1.c;
    }

    public static List a(String s, String s1)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[ProcessStringToPacket] is ui thread start");
        }
        n n1 = com.cyberlink.you.chat.n.a();
        n1;
        JVM INSTR monitorenter ;
        Object obj;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[ProcessStringToPacket] is ui thread end");
        }
        obj = new StringReader(s);
        s = new ArrayList();
        XmlPullParser xmlpullparser;
        int i1;
        xmlpullparser = PacketParserUtils.a();
        xmlpullparser.setInput(((java.io.Reader) (obj)));
        xmlpullparser.next();
        i1 = xmlpullparser.getEventType();
_L7:
        if (i1 != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag = xmlpullparser.getName().equals("message");
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = PacketParserUtils.a(xmlpullparser);
        s.add(obj);
        if (!s1.equals("(HB)")) goto _L4; else goto _L3
_L3:
        ULogUtility.c("Parse query Message", (new StringBuilder()).append("parse result=").append(((e) (obj)).toString()).toString());
_L2:
        Exception exception;
        try
        {
            i1 = xmlpullparser.next();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s1.equals("(GCM)")) goto _L2; else goto _L5
_L5:
        ULogUtility.b((new StringBuilder()).append("parse result=").append(((e) (obj)).toString()).toString(), "Parse query Message");
          goto _L2
        exception;
        if (true) goto _L7; else goto _L6
        s1;
        if (s1.getMessage() != null)
        {
            Log.e("XMPPManager", s1.getMessage());
        }
_L6:
        n1;
        JVM INSTR monitorexit ;
        return s;
        s;
        n1;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void a(b b1, String s)
    {
        com.cyberlink.you.chat.a a1 = (com.cyberlink.you.chat.a)b1.a("event", "urn:xmpp:custom:event");
        if (a1 != null)
        {
            obj = b1.i();
            String s1 = b1.o();
            String s2 = b1.l();
            String s3 = b1.j().toString();
            String s4 = a1.d();
            Log.d("XMPPManager", (new StringBuilder()).append(" eventContent = ").append(s4).toString());
            if (com.cyberlink.you.e.e().a(((String) (obj))) == null)
            {
                obj = new EventObj(-1L, ((String) (obj)), s1, s2, s3, s4);
                com.cyberlink.you.e.e().a(((com.cyberlink.you.database.BaseObj) (obj)));
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[handlePacket.mMsgQueue] is ui thread start");
                }
                synchronized (c)
                {
                    if (Looper.getMainLooper().getThread() == Thread.currentThread())
                    {
                        Log.d("LockTesting", "[handlePacket.mMsgQueue] is ui thread end");
                    }
                    c.add(new y(this, b1, a1, s));
                    c.notifyAll();
                }
                if (d == null)
                {
                    c();
                    return;
                }
            } else
            {
                Log.d("XMPPManager", (new StringBuilder()).append(" Event(").append(((String) (obj))).append(") has been in database!").toString());
                return;
            }
        }
        return;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    private void a(b b1, String s, boolean flag)
    {
        boolean flag1 = s.equals("(XMPP)");
        if (flag1 || b1.k().after(com.cyberlink.you.g.a().q()))
        {
            if (e(b1))
            {
                Log.d("XMPPManager", "[handleChatMessage] This is last message for chat, don't handle it");
            } else
            if (b1.a())
            {
                if (!a(b1, flag1, true))
                {
                    a(b1);
                    return;
                }
            } else
            if (!a(b1, false, false))
            {
                boolean flag2 = a(b1);
                boolean flag3 = b(b1);
                if (!flag2 && !flag3 && flag)
                {
                    b(b1, s);
                    return;
                }
                if (!flag)
                {
                    b1 = b1.toString();
                    Log.d("XMPPManager", (new StringBuilder()).append("[").append(s).append("] Not notify (This message is not the last message in HB). Message = ").append(b1).toString());
                    ULogUtility.d("Heartbeat", (new StringBuilder()).append("Not notify (This message is not the last message in HB). Message = ").append(b1).toString());
                    return;
                } else
                {
                    b1 = b1.toString();
                    ULogUtility.d(s, (new StringBuilder()).append("Not notify. isHandled=").append(flag2).append(" isMyselfMessage=").append(flag3).append(". Message = ").append(b1).toString());
                    return;
                }
            } else
            {
                ULogUtility.a((new StringBuilder()).append("Message exist. message id=").append(b1.i()).toString(), (new StringBuilder()).append(s).append("Receive").toString());
                return;
            }
        }
    }

    private void a(IQ iq)
    {
label0:
        {
            if (iq.s() != null)
            {
                Log.d("XMPPManager", (new StringBuilder()).append("ResultIQ: ").append(iq.toString()).toString());
                if (iq.t() != null && iq.t().a() != null)
                {
                    Log.e("XMPPManager", iq.t().a());
                }
                if (com.cyberlink.you.chat.j.a(iq))
                {
                    break label0;
                }
                StringBuffer stringbuffer = new StringBuffer();
                stringbuffer.append((new StringBuilder()).append("Response from ").append(l.a("chat", "xmpp.server")).append("\n").toString());
                stringbuffer.append((new StringBuilder()).append("messageId: ").append(iq.q()).toString());
                if (iq.t() != null)
                {
                    stringbuffer.append("\n").append(iq.t());
                }
                Log.d("XMPPManager", (new StringBuilder()).append("child xml=").append(iq.toString()).toString());
                if (iq.e() != null && iq.d() != null)
                {
                    stringbuffer.append("\n").append((new StringBuilder()).append("cv=").append(iq.e()).append(" empty=").append(iq.d()).toString());
                }
                ULogUtility.a(stringbuffer.toString(), "Receive", com.cyberlink.you.utility.ULogUtility.PingType.b);
                if (g != null)
                {
                    g.a(stringbuffer.toString());
                }
            }
            return;
        }
        b();
    }

    private void a(StreamMgmt streammgmt)
    {
        String s;
        if (streammgmt != null)
        {
            if ((s = streammgmt.q()) != null)
            {
                MessageObj messageobj = com.cyberlink.you.e.d().a(s);
                if (messageobj == null)
                {
                    streammgmt = com.cyberlink.you.e.j().a(s);
                    if (streammgmt != null)
                    {
                        streammgmt = streammgmt.a();
                        messageobj = com.cyberlink.you.e.d().a(streammgmt);
                        if (messageobj != null)
                        {
                            messageobj.c("5");
                            com.cyberlink.you.e.d().a(streammgmt, messageobj, "Status");
                            com.cyberlink.you.e.j().b(streammgmt);
                            return;
                        }
                    }
                    Log.d("XMPPManager", (new StringBuilder()).append("unknown StreamMgmt packet ").append(s).toString());
                    return;
                }
                ArrayList arraylist = new ArrayList();
                String s1 = streammgmt.d();
                if (s1 != null && s1.equals("nack"))
                {
                    messageobj.c("3");
                } else
                {
                    messageobj.c("0");
                }
                arraylist.add("Status");
                if (streammgmt.c() != null)
                {
                    messageobj.a(streammgmt.c());
                    arraylist.add("SendTime");
                }
                com.cyberlink.you.e.d().a(s, messageobj, arraylist);
                return;
            }
        }
    }

    private void a(e e1, String s, boolean flag)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[handlePacket.XMPPManager.getInstance()] is ui thread start");
        }
        n n1 = com.cyberlink.you.chat.n.a();
        n1;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[handlePacket.XMPPManager.getInstance()] is ui thread end");
        }
        ULogUtility.a(e1.toString(), (new StringBuilder()).append(s).append("Receive").toString());
        if (!(e1 instanceof IQ)) goto _L2; else goto _L1
_L1:
        a((IQ)e1);
_L3:
        return;
_L2:
        b b1;
        if (!(e1 instanceof Message))
        {
            break MISSING_BLOCK_LABEL_312;
        }
        b1 = new b((Message)e1);
        if (a((Message)e1, s))
        {
            break MISSING_BLOCK_LABEL_138;
        }
        return;
        e1;
        n1;
        JVM INSTR monitorexit ;
        throw e1;
        if (b1.c() == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        Log.d("XMPPManager", "Got Error Message");
        n1;
        JVM INSTR monitorexit ;
        return;
        boolean flag1;
        if (b1.a())
        {
            com.cyberlink.you.chat.j.a(b1);
        }
        flag1 = s.equals("(XMPP)");
        if (!b1.a() && flag1)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        if (!f(b1))
        {
            break MISSING_BLOCK_LABEL_206;
        }
        n1;
        JVM INSTR monitorexit ;
        return;
label0:
        {
            if (b1.g() != com.cyberlink.you.database.MessageObj.MessageType.h)
            {
                break label0;
            }
            a(b1, s);
        }
          goto _L3
label1:
        {
            if (!b1.q())
            {
                break label1;
            }
            a(b1, s, flag);
        }
          goto _L3
label2:
        {
            if (b1.g() != com.cyberlink.you.database.MessageObj.MessageType.e)
            {
                break label2;
            }
            d(b1);
            c(b1);
            a(b1);
        }
          goto _L3
        Log.d("XMPPManager", (new StringBuilder()).append("Receive packet is\n").append(b1.toString()).toString());
          goto _L3
label3:
        {
            if (!(e1 instanceof Presence))
            {
                break label3;
            }
            if (i != null)
            {
                i.a((Presence)e1);
            }
        }
          goto _L3
label4:
        {
            if (!(e1 instanceof StreamMgmt))
            {
                break label4;
            }
            Log.d("XMPPManager", (new StringBuilder()).append("StreamMgmt packet: id = ").append(e1.q()).toString());
            a((StreamMgmt)e1);
            b((StreamMgmt)e1);
        }
          goto _L3
label5:
        {
            if (!(e1 instanceof CLResumed))
            {
                break label5;
            }
            if (h != null)
            {
                h.a((CLResumed)e1);
            }
        }
          goto _L3
label6:
        {
            if (!(e1 instanceof org.jivesoftware.smack.sasl.SASLMechanism.Success))
            {
                break label6;
            }
            Log.d("Auth", (new StringBuilder()).append("Auth Success. ").append(e1.toString()).toString());
        }
          goto _L3
        Log.d("XMPPManager", (new StringBuilder()).append("Unknown packet ").append(e1.toString()).toString());
          goto _L3
    }

    private boolean a(b b1, boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        Object obj = b1.i();
        MessageObj messageobj = com.cyberlink.you.e.d().a(((String) (obj)));
        if (messageobj == null || messageobj.l())
        {
            String s = b1.p();
            String s1 = b1.l();
            Group group = com.cyberlink.you.e.f().b(s);
            obj = group;
            if (group == null)
            {
                obj = com.cyberlink.you.e.f().b(s1);
            }
            if (obj == null)
            {
                List list = (new l()).a(new String[] {
                    s, s1
                });
                if (list != null && list.size() >= 1)
                {
                    com.cyberlink.you.e.f().b(list);
                    if (list.size() > 1)
                    {
                        Iterator iterator = list.iterator();
                        Group group1;
                        for (obj = "get multiple groups :"; iterator.hasNext(); obj = (new StringBuilder()).append(((String) (obj))).append(group1.toString()).append(",").toString())
                        {
                            group1 = (Group)iterator.next();
                        }

                        ULogUtility.a(((String) (obj)), "HandleMessage");
                    }
                    obj = (Group)list.get(0);
                } else
                {
                    ULogUtility.a("Can not get group info", "HandleMessage");
                }
            }
            if (obj != null && messageobj == null)
            {
                b1.a(((Group) (obj)));
                a(((Group) (obj)), b1, flag, flag1);
                com.cyberlink.you.utility.i.a(((Group) (obj)), b1);
            }
            flag2 = false;
        } else
        if (flag)
        {
            if ((messageobj.j().equals("2") || messageobj.j().equals("3")) && (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.a) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.c) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.d) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.i) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.k)))
            {
                Log.d("XMPPManager", "didn't get server receipt, but found in archive message");
                if (messageobj.i().equals(String.valueOf(com.cyberlink.you.g.a().g())))
                {
                    messageobj.c("0");
                    com.cyberlink.you.e.d().a(((String) (obj)), messageobj, "Status");
                }
            }
            a(messageobj, flag1);
            return true;
        }
        return flag2;
    }

    private boolean a(Message message, String s)
    {
        String s1 = com.cyberlink.you.g.a().f();
        String s2 = com.cyberlink.you.g.a().j();
        message = message.r();
        if (s2 == null || message == null)
        {
            ULogUtility.a("myJid or toJid is null.", (new StringBuilder()).append(s).append("Receive").toString());
        } else
        if (message.startsWith(s1) && !s2.contains(message))
        {
            ULogUtility.a("resource id is wrong.", (new StringBuilder()).append(s).append("Receive").toString());
            return false;
        }
        return true;
    }

    private void b(b b1, String s)
    {
        Object obj = b1.p();
        obj = com.cyberlink.you.e.f().b(((String) (obj)));
        if (obj != null)
        {
            com.cyberlink.you.chat.NotificationHelper.a(((Group) (obj)), b1, s);
            return;
        } else
        {
            Log.d("XMPPManager", (new StringBuilder()).append("[").append(s).append("] Notify fail. group is null.").toString());
            ULogUtility.d(s, "Notify fail. group is null.");
            return;
        }
    }

    private boolean b(b b1)
    {
        String s = String.valueOf(com.cyberlink.you.g.a().g());
        Log.d("XMPPManager", (new StringBuilder()).append("[isMyselfMessage] my id = ").append(s).toString());
        b1 = b1.e();
        Log.d("XMPPManager", (new StringBuilder()).append("[isMyselfMessage] userIdbyFrom = ").append(b1).toString());
        while (b1 == null || s == null || !b1.equals(s)) 
        {
            return false;
        }
        Log.d("XMPPManager", "[isMyselfMessage] is myself message.");
        return true;
    }

    private boolean b(StreamMgmt streammgmt)
    {
        boolean flag;
        flag = false;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[notifyStreamMgmt] is ui thread start");
        }
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[notifyStreamMgmt] is ui thread end");
        }
        iterator = f.iterator();
_L1:
        aa aa1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        aa1 = (aa)iterator.next();
        boolean flag1 = aa1.a(streammgmt);
        flag = flag1;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L1
        obj;
        JVM INSTR monitorexit ;
        return flag;
        streammgmt;
        obj;
        JVM INSTR monitorexit ;
        throw streammgmt;
    }

    private void c()
    {
        a();
        d = new Thread() {

            final u a;

            public void run()
            {
                Log.d("XMPPManager", "[MessageProcessThread] start");
_L4:
                if (!isAlive()) goto _L2; else goto _L1
_L1:
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[startEventProcessThread] is ui thread start");
                }
                Object obj = com.cyberlink.you.chat.u.a(a);
                obj;
                JVM INSTR monitorenter ;
                if (Looper.getMainLooper().getThread() == Thread.currentThread())
                {
                    Log.d("LockTesting", "[startEventProcessThread] is ui thread end");
                }
                for (; com.cyberlink.you.chat.u.a(a).isEmpty(); com.cyberlink.you.chat.u.a(a).wait()) { }
                  goto _L3
                Exception exception;
                exception;
                Log.d("XMPPManager", (new StringBuilder()).append("[EventProcessThread] Failed on waiting message queue: ").append(exception).toString());
                obj;
                JVM INSTR monitorexit ;
_L2:
                Log.d("XMPPManager", "[MessageProcessThread] end");
                return;
_L3:
                Object obj1 = (y)com.cyberlink.you.chat.u.a(a).remove(0);
                if (obj1 != null)
                {
                    break MISSING_BLOCK_LABEL_165;
                }
                Log.d("XMPPManager", "[MessageProcessThread] params == null");
                obj;
                JVM INSTR monitorexit ;
                  goto _L4
                obj1;
                obj;
                JVM INSTR monitorexit ;
                throw obj1;
                obj;
                JVM INSTR monitorexit ;
label0:
                {
                    obj = ((y) (obj1)).a;
                    obj1 = ((y) (obj1)).b;
                    if (obj != null && obj1 != null)
                    {
                        break label0;
                    }
                    Log.d("XMPPManager", "[MessageProcessThread] xmppMessage == null || packetExtendsion == null");
                }
                if (true) goto _L4; else goto _L5
_L5:
                com.cyberlink.you.b.a.a().a(((b) (obj)));
                obj1 = ((com.cyberlink.you.chat.a) (obj1)).f();
                com.cyberlink.you.b.a.a().a(((b) (obj)), ((Map) (obj1)));
                obj = (String)((Map) (obj1)).get("eventType");
                Thread.sleep(10L);
                  goto _L4
                InterruptedException interruptedexception;
                interruptedexception;
                  goto _L2
            }

            
            {
                a = u.this;
                super();
            }
        };
        d.setName("XMPP Message Process Thread");
        d.setDaemon(true);
        d.start();
    }

    private void c(b b1)
    {
label0:
        {
            Object obj = (DeliveryReceipt)b1.a("received", "urn:xmpp:receipts");
            if (obj != null)
            {
                obj = ((DeliveryReceipt) (obj)).c();
                if (b1.e().equals(String.valueOf(com.cyberlink.you.g.a().g())))
                {
                    b1 = com.cyberlink.you.e.d().a(((String) (obj)));
                    if (b1 != null)
                    {
                        break label0;
                    }
                    Log.d("XMPPManager", "handleSendDeliveryReceipt: messageObj is null");
                }
            }
            return;
        }
        Group group = com.cyberlink.you.e.f().a(b1.c());
        if (group != null && group.k < b1.d().getTime())
        {
            group.k = b1.d().getTime();
            com.cyberlink.you.e.f().a(String.valueOf(group.b), group, "LastRead");
            return;
        }
        if (group != null)
        {
            Log.d("XMPPManager", "handleSendDeliveryReceipt: group is null.");
            return;
        } else
        {
            Log.d("XMPPManager", "handleSendDeliveryReceipt: last read is newer than receipt.");
            return;
        }
    }

    private void d(b b1)
    {
        DeliveryReceipt deliveryreceipt = (DeliveryReceipt)b1.a("received", "urn:xmpp:receipts");
        if (deliveryreceipt == null) goto _L2; else goto _L1
_L1:
        String s2;
        MessageObj messageobj;
        s2 = deliveryreceipt.c();
        messageobj = com.cyberlink.you.e.d().a(s2);
        if (messageobj != null) goto _L4; else goto _L3
_L3:
        Log.d("XMPPManager", "handleReceiveDeliveryReceipt: messageObj is null");
_L2:
        return;
_L4:
        int i1;
        Group group = com.cyberlink.you.e.f().a(messageobj.c());
        if (group == null || group.e == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (group.e.equals("Dual"))
        {
            i1 = 1;
        } else
        {
label0:
            {
                i1 = messageobj.h();
                int j1 = com.cyberlink.you.e.k().b(s2);
                if (i1 <= 0 || j1 != 0)
                {
                    break label0;
                }
                i1++;
            }
        }
_L6:
        b1 = new ArrayList();
        messageobj.a(i1);
        b1.add("ReadCount");
        if ((messageobj.j().equals("2") || messageobj.j().equals("3")) && (messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.a) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.c) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.d) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.i) || messageobj.e().equals(com.cyberlink.you.database.MessageObj.MessageType.k)))
        {
            Log.d("XMPPManager", "didn't get server receipt, but get client receipt");
            messageobj.c("0");
            b1.add("Status");
        }
        com.cyberlink.you.e.d().a(s2, messageobj, b1);
        return;
        String s1 = b1.f();
        String s = s1;
        if (s1 == null)
        {
            s = b1.o();
        }
        if (s.equals(String.valueOf(com.cyberlink.you.g.a().g())))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (com.cyberlink.you.e.k().a(s2, s) == null)
        {
            com.cyberlink.you.e.k().a(new com.cyberlink.you.database.i(s2, s));
        }
        i1 = com.cyberlink.you.e.k().b(s2);
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L2; else goto _L7
_L7:
    }

    private boolean e(b b1)
    {
        Object obj;
        obj = b1.p();
        String s = b1.l();
        Group group = com.cyberlink.you.e.f().b(((String) (obj)));
        obj = group;
        if (group == null)
        {
            obj = com.cyberlink.you.e.f().b(s);
        }
        break MISSING_BLOCK_LABEL_34;
        if (obj != null && ((Group) (obj)).m > 0L)
        {
            obj = new Date(((Group) (obj)).m + 500L);
            if (!b1.k().after(((Date) (obj))))
            {
                return true;
            }
        }
        return false;
    }

    private boolean f(b b1)
    {
        for (Iterator iterator = com.cyberlink.you.g.a().K().keys(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (b1.i() != null && b1.i().equals(s))
            {
                Log.d("XMPPManager", String.format("[CheckMessageIsDeleted] Filter message(%s) which has been deleted", new Object[] {
                    s
                }));
                return true;
            }
        }

        return false;
    }

    public void a()
    {
        try
        {
            if (d != null)
            {
                if (d.isAlive())
                {
                    d.interrupt();
                }
                d = null;
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public void a(aa aa1)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[addStreamMgmtListener] is ui thread start");
        }
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[addStreamMgmtListener] is ui thread end");
        }
        if (aa1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        f.add(aa1);
        obj;
        JVM INSTR monitorexit ;
        return;
        aa1;
        obj;
        JVM INSTR monitorexit ;
        throw aa1;
    }

    public void a(v v1)
    {
        h = v1;
    }

    public void a(w w1)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[addCLXMPPListener] is ui thread start");
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[addCLXMPPListener] is ui thread end");
        }
        if (w1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        e.add(w1);
        obj;
        JVM INSTR monitorexit ;
        return;
        w1;
        obj;
        JVM INSTR monitorexit ;
        throw w1;
    }

    public void a(x x1)
    {
        g = x1;
    }

    public void a(z z1)
    {
        i = z1;
    }

    public void a(Group group, b b1, boolean flag, boolean flag1)
    {
        group = b1.a(String.valueOf(group.b));
        if (group != null)
        {
            com.cyberlink.you.e.d().a(group);
            if (flag)
            {
                a(((MessageObj) (group)), flag1);
            }
            return;
        } else
        {
            Log.e("XMPPManager", "messageObj is null");
            return;
        }
    }

    public void a(MessageObj messageobj, boolean flag)
    {
        if (flag && (new Date(com.cyberlink.you.g.a().r())).before(messageobj.d()))
        {
            com.cyberlink.you.g.a().a(messageobj.d().getTime(), false);
        }
    }

    public void a(List list, String s)
    {
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            Pair pair = (Pair)list.get(i1);
            a((e)pair.first, s, ((Boolean)pair.second).booleanValue());
        }

    }

    public void a(List list, String s, boolean flag)
    {
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            a((e)list.get(i1), s, flag);
        }

    }

    public boolean a(b b1)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[passToListener] is ui thread start");
        }
        Object obj1 = a;
        obj1;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[passToListener] is ui thread end");
        }
        iterator = e.iterator();
        boolean flag1 = false;
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj = (w)iterator.next();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((w) (obj)).a(b1);
        boolean flag2;
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag2 = flag | flag1;
        flag1 = flag2;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ULogUtility.d("Notification", (new StringBuilder()).append("Not notify. isHandled is set by ").append(((String) (obj))).toString());
        flag1 = flag2;
          goto _L4
        Exception exception;
        exception;
_L6:
        exception.printStackTrace();
          goto _L4
        b1;
        obj1;
        JVM INSTR monitorexit ;
        throw b1;
_L2:
        obj1;
        JVM INSTR monitorexit ;
        return flag1;
        exception;
        flag1 = flag2;
          goto _L6
    }

    public void b()
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[NotifyArchiveComplete] is ui thread start");
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[NotifyArchiveComplete] is ui thread end");
        }
        iterator = e.iterator();
_L1:
        w w1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_105;
            }
            w1 = (w)iterator.next();
        } while (w1 == null);
        w1.a();
          goto _L1
        Exception exception1;
        exception1;
        exception1.printStackTrace();
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public void b(aa aa1)
    {
        Object obj;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[removeStreamMgmtListener] is ui thread start");
        } else
        {
            Log.d("LockTesting", "[removeStreamMgmtListener] is not ui thread start");
        }
        obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto _L2; else goto _L1
_L1:
        Log.d("LockTesting", "[removeStreamMgmtListener] is ui thread end");
_L4:
        if (aa1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        f.remove(aa1);
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        Log.d("LockTesting", "[removeStreamMgmtListener] is not ui thread end");
        if (true) goto _L4; else goto _L3
_L3:
        aa1;
        obj;
        JVM INSTR monitorexit ;
        throw aa1;
    }

    public void b(w w1)
    {
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[removeCLXMPPListener] is ui thread start");
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (Looper.getMainLooper().getThread() == Thread.currentThread())
        {
            Log.d("LockTesting", "[removeCLXMPPListener] is ui thread end");
        }
        if (w1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        e.remove(w1);
        obj;
        JVM INSTR monitorexit ;
        return;
        w1;
        obj;
        JVM INSTR monitorexit ;
        throw w1;
    }

    public void processPacket(e e1)
    {
        a(e1, "(XMPP)", true);
        if (e1 instanceof Message)
        {
            e1 = new b((Message)e1);
            if (e1.a())
            {
                String s = e1.i();
                if (s != null && !s.isEmpty() && (new Date(com.cyberlink.you.g.a().r())).before(e1.k()))
                {
                    com.cyberlink.you.g.a().a(e1.k().getTime(), false);
                }
            }
        }
    }
}
