// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import org.jivesoftware.smack.c.b;
import org.jivesoftware.smack.compression.XMPPInputOutputStream;
import org.jivesoftware.smack.compression.a;
import org.jivesoftware.smack.util.k;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class j
{

    public static boolean a;
    private static final String b;
    private static final Logger c;
    private static int d;
    private static int e;
    private static List f;
    private static Set g;
    private static final List h;
    private static b i;
    private static HostnameVerifier j;

    public j()
    {
    }

    public static String a()
    {
        return b;
    }

    public static void a(int l)
    {
        if (l <= 0)
        {
            throw new IllegalArgumentException();
        } else
        {
            d = l;
            return;
        }
    }

    public static void a(InputStream inputstream, Collection collection)
    {
        a(inputstream, collection, org/jivesoftware/smack/j.getClassLoader());
    }

    public static void a(InputStream inputstream, Collection collection, ClassLoader classloader)
    {
        XmlPullParser xmlpullparser = XmlPullParserFactory.newInstance().newPullParser();
        xmlpullparser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        xmlpullparser.setInput(inputstream, "UTF-8");
        int l = xmlpullparser.getEventType();
        do
        {
            int i1;
            if (l == 2)
            {
                if (xmlpullparser.getName().equals("startupClasses"))
                {
                    a(xmlpullparser, false, collection, classloader);
                } else
                if (xmlpullparser.getName().equals("optionalStartupClasses"))
                {
                    a(xmlpullparser, true, collection, classloader);
                }
            }
            i1 = xmlpullparser.next();
            l = i1;
        } while (i1 != 1);
        try
        {
            inputstream.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            c.log(Level.SEVERE, "Error while closing config file input stream", inputstream);
        }
    }

    private static void a(String s, boolean flag, ClassLoader classloader)
    {
label0:
        {
            try
            {
                classloader = Class.forName(s, true, classloader);
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                if (flag)
                {
                    classloader = Level.FINE;
                } else
                {
                    classloader = Level.WARNING;
                }
                c.log(classloader, (new StringBuilder()).append("A startup class '").append(s).append("' could not be loaded.").toString());
                if (!flag)
                {
                    throw classnotfoundexception;
                } else
                {
                    break label0;
                }
            }
            if (!org/jivesoftware/smack/initializer/a.isAssignableFrom(classloader))
            {
                break MISSING_BLOCK_LABEL_165;
            }
            classloader = ((org.jivesoftware.smack.initializer.a)classloader.newInstance()).a();
            if (classloader.size() == 0)
            {
                c.log(Level.FINE, (new StringBuilder()).append("Loaded SmackInitializer ").append(s).toString());
            } else
            {
                s = classloader.iterator();
                while (s.hasNext()) 
                {
                    classloader = (Exception)s.next();
                    c.log(Level.SEVERE, "Exception in loadSmackClass", classloader);
                }
            }
        }
        return;
        c.log(Level.FINE, (new StringBuilder()).append("Loaded ").append(s).toString());
        return;
    }

    private static void a(XmlPullParser xmlpullparser, boolean flag, Collection collection, ClassLoader classloader)
    {
        String s = xmlpullparser.getName();
        do
        {
            int l = xmlpullparser.next();
            String s1 = xmlpullparser.getName();
            if (l == 2 && "className".equals(s1))
            {
                String s2 = xmlpullparser.nextText();
                if (g.contains(s2))
                {
                    c.info((new StringBuilder()).append("Not loading disabled Smack class ").append(s2).toString());
                } else
                {
                    try
                    {
                        a(s2, flag, classloader);
                    }
                    catch (Exception exception)
                    {
                        if (collection != null)
                        {
                            collection.add(exception);
                        } else
                        {
                            throw exception;
                        }
                    }
                }
            }
        } while (l != 3 || !s.equals(s1));
    }

    public static int b()
    {
        if (d <= 0)
        {
            d = 5000;
        }
        return d;
    }

    public static int c()
    {
        return e;
    }

    public static b d()
    {
        return i;
    }

    public static List e()
    {
        ArrayList arraylist = new ArrayList(h.size());
        Iterator iterator = h.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            XMPPInputOutputStream xmppinputoutputstream = (XMPPInputOutputStream)iterator.next();
            if (xmppinputoutputstream.a())
            {
                arraylist.add(xmppinputoutputstream);
            }
        } while (true);
        return arraylist;
    }

    static HostnameVerifier f()
    {
        return j;
    }

    static 
    {
        boolean flag = false;
        c = Logger.getLogger(org/jivesoftware/smack/j.getName());
        d = 5000;
        e = 5000;
        f = new ArrayList();
        g = new HashSet();
        h = new ArrayList(2);
        a = false;
        b = "aSmack 4.0.3 [CL]";
        String s = System.getProperty("smack.disabledClasses");
        if (s != null)
        {
            String as[] = s.split(",");
            int j1 = as.length;
            for (int l = 0; l < j1; l++)
            {
                String s1 = as[l];
                g.add(s1);
            }

        }
        String as1[];
        String s2;
        int i1;
        int k1;
        try
        {
            k.a("classpath:org.jivesoftware.smack/disabledClasses", g);
        }
        catch (Exception exception)
        {
            throw new IllegalStateException(exception);
        }
        as1 = (String[])(String[])Class.forName("org.jivesoftware.smack.CustomSmackConfiguration").getField("DISABLED_SMACK_CLASSES").get(null);
        if (as1 == null) goto _L2; else goto _L1
_L1:
        k1 = as1.length;
        i1 = ((flag) ? 1 : 0);
_L3:
        if (i1 >= k1)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = as1[i1];
        g.add(s2);
        i1++;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        break; /* Loop/switch isn't completed */
        if (true) goto _L3; else goto _L2
_L2:
        ByteArrayInputStream bytearrayinputstream;
        try
        {
            bytearrayinputstream = new ByteArrayInputStream("<?xml version=\"1.0\"?><smack><startupClasses><className>org.jivesoftware.smack.initializer.VmArgInitializer</className><className>org.jivesoftware.smack.ReconnectionManager</className></startupClasses><optionalStartupClasses><className>org.jivesoftware.smack.util.dns.javax.JavaxResolver</className><className>org.jivesoftware.smack.initializer.extensions.ExtensionsInitializer</className><className>org.jivesoftware.smack.initializer.experimental.ExperimentalInitializer</className><className>org.jivesoftware.smack.initializer.legacy.LegacyInitializer</className></optionalStartupClasses></smack>".getBytes());
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayInputStream bytearrayinputstream)
        {
            throw new IllegalStateException(bytearrayinputstream);
        }
        try
        {
            a(bytearrayinputstream, null);
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayInputStream bytearrayinputstream)
        {
            throw new IllegalStateException(bytearrayinputstream);
        }
        h.add(new a());
        try
        {
            a = Boolean.getBoolean("smack.debugEnabled");
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayInputStream bytearrayinputstream) { }
        org.jivesoftware.smack.util.j.a();
        i = new org.jivesoftware.smack.c.a();
        return;
        bytearrayinputstream;
          goto _L2
        bytearrayinputstream;
          goto _L2
        bytearrayinputstream;
          goto _L2
        bytearrayinputstream;
          goto _L2
    }
}
