// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util;

import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Bind;
import org.jivesoftware.smack.packet.CLResumed;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Registration;
import org.jivesoftware.smack.packet.RosterPacket;
import org.jivesoftware.smack.packet.StreamMgmt;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.a;
import org.jivesoftware.smack.packet.b;
import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.packet.g;
import org.jivesoftware.smack.packet.i;
import org.jivesoftware.smack.provider.c;
import org.jivesoftware.smack.provider.h;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

// Referenced classes of package org.jivesoftware.smack.util:
//            r, p

public class PacketParserUtils
{

    static final boolean a;
    private static final Logger b = Logger.getLogger(org/jivesoftware/smack/util/PacketParserUtils.getName());

    public PacketParserUtils()
    {
    }

    private static Object a(Class class1, String s)
    {
        if (class1.getName().equals("java.lang.String"))
        {
            return s;
        }
        if (class1.getName().equals("boolean"))
        {
            return Boolean.valueOf(s);
        }
        if (class1.getName().equals("int"))
        {
            return Integer.valueOf(s);
        }
        if (class1.getName().equals("long"))
        {
            return Long.valueOf(s);
        }
        if (class1.getName().equals("float"))
        {
            return Float.valueOf(s);
        }
        if (class1.getName().equals("double"))
        {
            return Double.valueOf(s);
        }
        if (class1.getName().equals("java.lang.Class"))
        {
            return Class.forName(s);
        } else
        {
            return null;
        }
    }

    public static Object a(String s, Class class1, XmlPullParser xmlpullparser)
    {
        class1 = ((Class) (class1.newInstance()));
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                String s1 = xmlpullparser.getName();
                Object obj = xmlpullparser.nextText();
                Class class2 = class1.getClass().getMethod((new StringBuilder()).append("get").append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).toString(), new Class[0]).getReturnType();
                obj = a(class2, ((String) (obj)));
                class1.getClass().getMethod((new StringBuilder()).append("set").append(Character.toUpperCase(s1.charAt(0))).append(s1.substring(1)).toString(), new Class[] {
                    class2
                }).invoke(class1, new Object[] {
                    obj
                });
            } else
            if (i1 == 3 && xmlpullparser.getName().equals(s))
            {
                flag = true;
            }
        } while (true);
        return class1;
    }

    public static String a(XmlPullParser xmlpullparser, int i1)
    {
        r r1;
        boolean flag;
        int k1;
        r1 = new r();
        k1 = xmlpullparser.getEventType();
        flag = false;
_L2:
        boolean flag1;
        if (k1 != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        r1.a(xmlpullparser.getName());
        String s = xmlpullparser.getNamespace();
        if (org.jivesoftware.smack.util.p.a(s))
        {
            r1.c("xmlns", s);
        }
        for (int j1 = 0; j1 < xmlpullparser.getAttributeCount(); j1++)
        {
            r1.c(xmlpullparser.getAttributeName(j1), xmlpullparser.getAttributeValue(j1));
        }

        if (xmlpullparser.isEmptyElementTag())
        {
            r1.a();
            flag = true;
        } else
        {
            r1.b();
        }
        flag1 = flag;
_L3:
        k1 = xmlpullparser.next();
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 == 3)
        {
            if (flag)
            {
                flag = false;
            } else
            {
                r1.c(xmlpullparser.getName());
            }
            flag1 = flag;
            if (xmlpullparser.getDepth() <= i1)
            {
                return r1.toString();
            }
        } else
        {
            flag1 = flag;
            if (k1 == 4)
            {
                r1.b(xmlpullparser.getText());
                flag1 = flag;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static IQ a(XmlPullParser xmlpullparser, XMPPConnection xmppconnection)
    {
        String s = xmlpullparser.getAttributeValue("", "id");
        String s1 = xmlpullparser.getAttributeValue("", "to");
        String s2 = xmlpullparser.getAttributeValue("", "from");
        String s3 = xmlpullparser.getAttributeValue("", "cv");
        String s4 = xmlpullparser.getAttributeValue("", "empty");
        b b1 = org.jivesoftware.smack.packet.b.a(xmlpullparser.getAttributeValue("", "type"));
        boolean flag = false;
        XMPPError xmpperror = null;
        Object obj = null;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                String s5 = xmlpullparser.getName();
                Object obj1 = xmlpullparser.getNamespace();
                if (s5.equals("error"))
                {
                    xmpperror = j(xmlpullparser);
                } else
                if (s5.equals("query") && ((String) (obj1)).equals("jabber:iq:roster"))
                {
                    obj = m(xmlpullparser);
                } else
                if (s5.equals("query") && ((String) (obj1)).equals("jabber:iq:register"))
                {
                    obj = n(xmlpullparser);
                } else
                if (s5.equals("bind") && ((String) (obj1)).equals("urn:ietf:params:xml:ns:xmpp-bind"))
                {
                    obj = o(xmlpullparser);
                } else
                {
                    obj1 = org.jivesoftware.smack.provider.h.a(s5, ((String) (obj1)));
                    if (obj1 != null)
                    {
                        if (obj1 instanceof c)
                        {
                            obj = ((c)obj1).b(xmlpullparser);
                        } else
                        if (obj1 instanceof Class)
                        {
                            obj = (IQ)a(s5, (Class)obj1, xmlpullparser);
                        }
                    } else
                    if (b.c == b1)
                    {
                        obj = new UnparsedResultIQ(d(xmlpullparser));
                    }
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("iq"))
            {
                flag = true;
            }
        } while (true);
        xmlpullparser = ((XmlPullParser) (obj));
        if (obj == null)
        {
            if (b.a == b1 || b.b == b1)
            {
                xmlpullparser = new _cls1();
                xmlpullparser.k(s);
                xmlpullparser.l(s2);
                xmlpullparser.m(s1);
                xmlpullparser.a(b.d);
                xmlpullparser.a(new XMPPError(i.e));
                xmppconnection.b(xmlpullparser);
                return null;
            }
            xmlpullparser = new _cls2();
        }
        xmlpullparser.k(s);
        xmlpullparser.l(s1);
        xmlpullparser.m(s2);
        xmlpullparser.a(b1);
        xmlpullparser.d(s3);
        xmlpullparser.c(s4);
        xmlpullparser.a(xmpperror);
        return xmlpullparser;
    }

    public static Message a(XmlPullParser xmlpullparser)
    {
        String s = null;
        Message message = new Message();
        xmlpullparser = b(xmlpullparser, xmlpullparser.getDepth());
        message.i(xmlpullparser);
        xmlpullparser = new StringReader(xmlpullparser);
        XmlPullParser xmlpullparser1 = a();
        xmlpullparser1.setInput(xmlpullparser);
        xmlpullparser1.next();
        String s1 = xmlpullparser1.getAttributeValue("", "id");
        xmlpullparser = s1;
        if (s1 == null)
        {
            xmlpullparser = "ID_NOT_AVAILABLE";
        }
        message.k(xmlpullparser);
        message.l(xmlpullparser1.getAttributeValue("", "to"));
        message.m(xmlpullparser1.getAttributeValue("", "from"));
        message.a(org.jivesoftware.smack.packet.Message.Type.a(xmlpullparser1.getAttributeValue("", "type")));
        boolean flag;
        long l1;
        try
        {
            message.a(Integer.valueOf(xmlpullparser1.getAttributeValue("", "mv")).intValue());
        }
        // Misplaced declaration of an exception variable
        catch (XmlPullParser xmlpullparser) { }
        xmlpullparser = xmlpullparser1.getAttributeValue("", "ts");
        if (xmlpullparser != null && !xmlpullparser.isEmpty())
        {
            try
            {
                l1 = Long.parseLong(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                l1 = 0L;
            }
            if (l1 == 0L)
            {
                message.a(null);
            } else
            {
                message.a(new Date(l1));
            }
        }
        xmlpullparser = xmlpullparser1.getAttributeValue("", "st");
        if (xmlpullparser != null && !xmlpullparser.isEmpty())
        {
            try
            {
                l1 = Long.parseLong(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                l1 = 0L;
            }
            if (l1 == 0L)
            {
                message.b(null);
            } else
            {
                message.b(new Date(l1));
            }
        }
        xmlpullparser = p(xmlpullparser1);
        if (xmlpullparser != null && !"".equals(xmlpullparser.trim()))
        {
            message.h(xmlpullparser);
        } else
        {
            xmlpullparser = org.jivesoftware.smack.packet.e.w();
        }
        flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser1.next();
            if (i1 == 2)
            {
                Object obj = xmlpullparser1.getName();
                String s2 = xmlpullparser1.getNamespace();
                if (((String) (obj)).equals("subject"))
                {
                    s2 = p(xmlpullparser1);
                    obj = s2;
                    if (s2 == null)
                    {
                        obj = xmlpullparser;
                    }
                    s2 = b(xmlpullparser1);
                    if (message.a(((String) (obj))) == null)
                    {
                        message.a(((String) (obj)), s2);
                    }
                } else
                if (((String) (obj)).equals("body"))
                {
                    s2 = p(xmlpullparser1);
                    obj = s2;
                    if (s2 == null)
                    {
                        obj = xmlpullparser;
                    }
                    s2 = b(xmlpullparser1);
                    if (message.d(((String) (obj))) == null)
                    {
                        message.b(((String) (obj)), s2);
                    }
                } else
                if (((String) (obj)).equals("thread"))
                {
                    if (s == null)
                    {
                        s = xmlpullparser1.nextText();
                    }
                } else
                if (((String) (obj)).equals("error"))
                {
                    message.a(j(xmlpullparser1));
                } else
                {
                    obj = a(((String) (obj)), s2, xmlpullparser1);
                    if (obj instanceof a)
                    {
                        message.a(true);
                    } else
                    {
                        message.a(((f) (obj)));
                    }
                }
            } else
            if (i1 == 3 && xmlpullparser1.getName().equals("message"))
            {
                flag = true;
            }
        } while (true);
        message.g(s);
        return message;
    }

    public static f a(String s, String s1, XmlPullParser xmlpullparser)
    {
        Object obj = org.jivesoftware.smack.provider.h.b(s, s1);
        if (obj != null)
        {
            if (obj instanceof org.jivesoftware.smack.provider.e)
            {
                return ((org.jivesoftware.smack.provider.e)obj).a(xmlpullparser);
            }
            if (obj instanceof Class)
            {
                return (f)a(s, (Class)obj, xmlpullparser);
            }
        }
        s1 = new a(s, s1);
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                String s2 = xmlpullparser.getName();
                if (xmlpullparser.isEmptyElementTag())
                {
                    s1.a(s2, "");
                } else
                if (xmlpullparser.next() == 4)
                {
                    s1.a(s2, xmlpullparser.getText());
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals(s))
            {
                flag = true;
            }
        } while (true);
        return s1;
    }

    public static XmlPullParser a()
    {
        XmlPullParser xmlpullparser = XmlPullParserFactory.newInstance().newPullParser();
        xmlpullparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        return xmlpullparser;
    }

    public static String b(XmlPullParser xmlpullparser)
    {
        if (!a && xmlpullparser.getEventType() != 2)
        {
            throw new AssertionError();
        }
        String s;
        if (xmlpullparser.isEmptyElementTag())
        {
            s = "";
        } else
        {
            if (xmlpullparser.next() != 4)
            {
                throw new XmlPullParserException("Non-empty element tag not followed by text, while Mixed Content (XML 3.2.2) is disallowed");
            }
            s = xmlpullparser.getText();
            if (xmlpullparser.next() != 3)
            {
                throw new XmlPullParserException("Non-empty element tag contains child-elements, while Mixed Content (XML 3.2.2) is disallowed");
            }
        }
        return s;
    }

    public static String b(XmlPullParser xmlpullparser, int i1)
    {
        r r1;
        boolean flag;
        int k1;
        r1 = new r();
        k1 = xmlpullparser.getEventType();
        flag = false;
_L2:
        boolean flag1;
        if (k1 != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        r1.a(xmlpullparser.getName());
        String s = xmlpullparser.getNamespace();
        if (org.jivesoftware.smack.util.p.a(s))
        {
            r1.c("xmlns", s);
        }
        for (int j1 = 0; j1 < xmlpullparser.getAttributeCount(); j1++)
        {
            r1.c(xmlpullparser.getAttributeName(j1), xmlpullparser.getAttributeValue(j1));
        }

        if (xmlpullparser.isEmptyElementTag())
        {
            r1.a();
            flag = true;
        } else
        {
            r1.b();
        }
        flag1 = flag;
_L3:
        k1 = xmlpullparser.next();
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        if (k1 == 3)
        {
            if (flag)
            {
                flag = false;
            } else
            {
                r1.c(xmlpullparser.getName());
            }
            flag1 = flag;
            if (xmlpullparser.getDepth() <= i1)
            {
                return r1.toString();
            }
        } else
        {
            flag1 = flag;
            if (k1 == 4)
            {
                r1.b(org.jivesoftware.smack.util.p.e(xmlpullparser.getText()));
                flag1 = flag;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static String c(XmlPullParser xmlpullparser)
    {
        if (!a && xmlpullparser.getEventType() != 2)
        {
            throw new AssertionError();
        } else
        {
            return a(xmlpullparser, xmlpullparser.getDepth());
        }
    }

    public static String d(XmlPullParser xmlpullparser)
    {
        if (!a && xmlpullparser.getEventType() != 2)
        {
            throw new AssertionError();
        }
        if (xmlpullparser.isEmptyElementTag())
        {
            return "";
        } else
        {
            xmlpullparser.next();
            return a(xmlpullparser, xmlpullparser.getDepth());
        }
    }

    public static Presence e(XmlPullParser xmlpullparser)
    {
        Object obj1 = org.jivesoftware.smack.packet.Presence.Type.a;
        Object obj2 = xmlpullparser.getAttributeValue("", "type");
        Object obj = obj1;
        boolean flag;
        if (obj2 != null)
        {
            obj = obj1;
            if (!((String) (obj2)).equals(""))
            {
                try
                {
                    obj = org.jivesoftware.smack.packet.Presence.Type.valueOf(((String) (obj2)));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    b.warning((new StringBuilder()).append("Found invalid presence type ").append(((String) (obj2))).toString());
                    obj = obj1;
                }
            }
        }
        obj2 = new Presence(((org.jivesoftware.smack.packet.Presence.Type) (obj)));
        ((Presence) (obj2)).l(xmlpullparser.getAttributeValue("", "to"));
        ((Presence) (obj2)).m(xmlpullparser.getAttributeValue("", "from"));
        obj = xmlpullparser.getAttributeValue("", "id");
        if (obj == null)
        {
            obj1 = "ID_NOT_AVAILABLE";
        } else
        {
            obj1 = obj;
        }
        ((Presence) (obj2)).k(((String) (obj1)));
        obj1 = p(xmlpullparser);
        if (obj1 != null && !"".equals(((String) (obj1)).trim()))
        {
            ((Presence) (obj2)).b(((String) (obj1)));
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = "ID_NOT_AVAILABLE";
        }
        ((Presence) (obj2)).k(((String) (obj1)));
        flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                obj = xmlpullparser.getName();
                obj1 = xmlpullparser.getNamespace();
                if (((String) (obj)).equals("status"))
                {
                    ((Presence) (obj2)).a(xmlpullparser.nextText());
                } else
                if (((String) (obj)).equals("priority"))
                {
                    try
                    {
                        ((Presence) (obj2)).a(Integer.parseInt(xmlpullparser.nextText()));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj) { }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((Presence) (obj2)).a(0);
                    }
                } else
                if (((String) (obj)).equals("show"))
                {
                    obj = xmlpullparser.nextText();
                    try
                    {
                        ((Presence) (obj2)).a(org.jivesoftware.smack.packet.Presence.Mode.valueOf(((String) (obj))));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        b.warning((new StringBuilder()).append("Found invalid presence mode ").append(((String) (obj))).toString());
                    }
                } else
                if (((String) (obj)).equals("error"))
                {
                    ((Presence) (obj2)).a(j(xmlpullparser));
                } else
                {
                    try
                    {
                        ((Presence) (obj2)).a(a(((String) (obj)), ((String) (obj1)), xmlpullparser));
                    }
                    catch (Exception exception)
                    {
                        b.warning("Failed to parse extension packet in Presence packet.");
                    }
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("presence"))
            {
                flag = true;
            }
        } while (true);
        return ((Presence) (obj2));
    }

    public static Collection f(XmlPullParser xmlpullparser)
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                if (xmlpullparser.getName().equals("mechanism"))
                {
                    arraylist.add(xmlpullparser.nextText());
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("mechanisms"))
            {
                flag = true;
            }
        } while (true);
        return arraylist;
    }

    public static Collection g(XmlPullParser xmlpullparser)
    {
        ArrayList arraylist = new ArrayList();
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                if (xmlpullparser.getName().equals("method"))
                {
                    arraylist.add(xmlpullparser.nextText());
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("compression"))
            {
                flag = true;
            }
        } while (true);
        return arraylist;
    }

    public static org.jivesoftware.smack.sasl.SASLMechanism.SASLFailure h(XmlPullParser xmlpullparser)
    {
        String s = null;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                if (!xmlpullparser.getName().equals("failure"))
                {
                    s = xmlpullparser.getName();
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("failure"))
            {
                flag = true;
            }
        } while (true);
        return new org.jivesoftware.smack.sasl.SASLMechanism.SASLFailure(s);
    }

    public static org.jivesoftware.smack.packet.h i(XmlPullParser xmlpullparser)
    {
        String s1 = null;
        int i1 = xmlpullparser.getDepth();
        boolean flag = false;
        String s = null;
        do
        {
            if (flag)
            {
                break;
            }
            int j1 = xmlpullparser.next();
            if (j1 == 2)
            {
                String s2 = s1;
                String s3 = s;
                if ("urn:ietf:params:xml:ns:xmpp-streams".equals(xmlpullparser.getNamespace()))
                {
                    s3 = xmlpullparser.getName();
                    if (s3.equals("text") && !xmlpullparser.isEmptyElementTag())
                    {
                        xmlpullparser.next();
                        s2 = xmlpullparser.getText();
                        s3 = s;
                    } else
                    {
                        s2 = s1;
                    }
                }
                s = s3;
                s1 = s2;
            } else
            if (j1 == 3 && i1 == xmlpullparser.getDepth())
            {
                flag = true;
            }
        } while (true);
        return new org.jivesoftware.smack.packet.h(s, s1);
    }

    public static XMPPError j(XmlPullParser xmlpullparser)
    {
        String s;
        String s1;
        String s2;
        ArrayList arraylist;
        s = null;
        arraylist = new ArrayList();
        int i1 = 0;
        s2 = null;
        for (; i1 < xmlpullparser.getAttributeCount(); i1++)
        {
            if (xmlpullparser.getAttributeName(i1).equals("type"))
            {
                s2 = xmlpullparser.getAttributeValue("", "type");
            }
        }

        boolean flag = false;
        s1 = null;
        do
        {
            if (flag)
            {
                break;
            }
            int j1 = xmlpullparser.next();
            if (j1 == 2)
            {
                if (xmlpullparser.getName().equals("text"))
                {
                    s = xmlpullparser.nextText();
                } else
                {
                    String s3 = xmlpullparser.getName();
                    String s4 = xmlpullparser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(s4))
                    {
                        s1 = s3;
                    } else
                    {
                        arraylist.add(a(s3, s4, xmlpullparser));
                    }
                }
            } else
            if (j1 == 3 && xmlpullparser.getName().equals("error"))
            {
                flag = true;
            }
        } while (true);
        xmlpullparser = org.jivesoftware.smack.packet.XMPPError.Type.b;
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        org.jivesoftware.smack.packet.XMPPError.Type type = org.jivesoftware.smack.packet.XMPPError.Type.valueOf(s2.toUpperCase(Locale.US));
        xmlpullparser = type;
_L2:
        return new XMPPError(xmlpullparser, s1, s, arraylist);
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        b.log(Level.SEVERE, (new StringBuilder()).append("Could not find error type for ").append(s2.toUpperCase(Locale.US)).toString(), illegalargumentexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static StreamMgmt k(XmlPullParser xmlpullparser)
    {
        StreamMgmt streammgmt = new StreamMgmt();
        String s1 = xmlpullparser.getAttributeValue("", "id");
        String s = s1;
        if (s1 == null)
        {
            s = "ID_NOT_AVAILABLE";
        }
        streammgmt.k(s);
        s = xmlpullparser.getAttributeValue("", "ts");
        if (s != null && !s.isEmpty())
        {
            long l1;
            try
            {
                l1 = Long.parseLong(s);
            }
            catch (Exception exception)
            {
                l1 = 0L;
            }
            if (l1 == 0L)
            {
                streammgmt.a(null);
            } else
            {
                streammgmt.a(new Date(l1));
            }
        }
        xmlpullparser = xmlpullparser.getAttributeValue("", "status");
        if (xmlpullparser != null && !xmlpullparser.isEmpty())
        {
            streammgmt.a(xmlpullparser);
        }
        return streammgmt;
    }

    public static CLResumed l(XmlPullParser xmlpullparser)
    {
        CLResumed clresumed = new CLResumed();
        String s1 = xmlpullparser.getAttributeValue("", "status");
        String s = xmlpullparser.getAttributeValue("", "sessionid");
        String s2 = xmlpullparser.getAttributeValue("", "expiration");
        xmlpullparser = s1;
        if (s1 == null)
        {
            xmlpullparser = "";
        }
        clresumed.a(xmlpullparser);
        long l1;
        long l2;
        if (s == null)
        {
            xmlpullparser = "";
        } else
        {
            xmlpullparser = s;
        }
        clresumed.b(xmlpullparser);
        l1 = 0L;
        l2 = Long.parseLong(s2);
        l1 = l2;
_L2:
        clresumed.a(l1);
        return clresumed;
        xmlpullparser;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static RosterPacket m(XmlPullParser xmlpullparser)
    {
        RosterPacket rosterpacket = new RosterPacket();
        boolean flag = false;
        Object obj = null;
        rosterpacket.a(xmlpullparser.getAttributeValue("", "ver"));
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                if (xmlpullparser.getName().equals("item"))
                {
                    g g1 = new g(xmlpullparser.getAttributeValue("", "jid"), xmlpullparser.getAttributeValue("", "name"));
                    g1.a(org.jivesoftware.smack.packet.RosterPacket.ItemStatus.a(xmlpullparser.getAttributeValue("", "ask")));
                    obj = xmlpullparser.getAttributeValue("", "subscription");
                    if (obj == null)
                    {
                        obj = "none";
                    }
                    g1.a(org.jivesoftware.smack.packet.RosterPacket.ItemType.valueOf(((String) (obj))));
                    obj = g1;
                } else
                if (xmlpullparser.getName().equals("group") && obj != null)
                {
                    String s = xmlpullparser.nextText();
                    if (s != null && s.trim().length() > 0)
                    {
                        ((g) (obj)).a(s);
                    }
                }
            } else
            if (i1 == 3)
            {
                if (xmlpullparser.getName().equals("item"))
                {
                    rosterpacket.a(((g) (obj)));
                }
                if (xmlpullparser.getName().equals("query"))
                {
                    flag = true;
                }
            }
        } while (true);
        return rosterpacket;
    }

    private static Registration n(XmlPullParser xmlpullparser)
    {
        Registration registration = new Registration();
        Object obj = null;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                if (xmlpullparser.getNamespace().equals("jabber:iq:register"))
                {
                    String s1 = xmlpullparser.getName();
                    String s = "";
                    Object obj1 = obj;
                    if (obj == null)
                    {
                        obj1 = new HashMap();
                    }
                    obj = s;
                    if (xmlpullparser.next() == 4)
                    {
                        obj = xmlpullparser.getText();
                    }
                    if (!s1.equals("instructions"))
                    {
                        ((Map) (obj1)).put(s1, obj);
                    } else
                    {
                        registration.a(((String) (obj)));
                    }
                    obj = obj1;
                } else
                {
                    registration.a(a(xmlpullparser.getName(), xmlpullparser.getNamespace(), xmlpullparser));
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("query"))
            {
                flag = true;
            }
        } while (true);
        registration.a(((Map) (obj)));
        return registration;
    }

    private static Bind o(XmlPullParser xmlpullparser)
    {
        Bind bind = new Bind();
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            int i1 = xmlpullparser.next();
            if (i1 == 2)
            {
                if (xmlpullparser.getName().equals("resource"))
                {
                    bind.a(xmlpullparser.nextText());
                } else
                if (xmlpullparser.getName().equals("jid"))
                {
                    bind.b(xmlpullparser.nextText());
                }
            } else
            if (i1 == 3 && xmlpullparser.getName().equals("bind"))
            {
                flag = true;
            }
        } while (true);
        return bind;
    }

    private static String p(XmlPullParser xmlpullparser)
    {
        for (int i1 = 0; i1 < xmlpullparser.getAttributeCount(); i1++)
        {
            String s = xmlpullparser.getAttributeName(i1);
            if ("xml:lang".equals(s) || "lang".equals(s) && "xml".equals(xmlpullparser.getAttributePrefix(i1)))
            {
                return xmlpullparser.getAttributeValue(i1);
            }
        }

        return null;
    }

    static 
    {
        boolean flag;
        if (!org/jivesoftware/smack/util/PacketParserUtils.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }

    /* member class not found */
    class UnparsedResultIQ {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
