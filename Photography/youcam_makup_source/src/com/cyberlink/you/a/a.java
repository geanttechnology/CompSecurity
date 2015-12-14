// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.a;

import android.util.Log;
import android.util.Pair;
import com.cyberlink.you.chat.UnreadCountManager;
import com.cyberlink.you.chat.b;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.chat.u;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.g;
import com.cyberlink.you.utility.ULogUtility;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.message.BasicNameValuePair;
import org.jivesoftware.smack.packet.Message;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class a
{

    private static final Object a = new Object();
    private static ThreadPoolExecutor b;

    private static int a(List list)
    {
        if (list == null)
        {
            return -1;
        }
        for (int i = list.size() - 1; i >= 0 && !list.isEmpty(); i--)
        {
            if ((new b((Message)list.get(i))).q())
            {
                return i;
            }
        }

        return -1;
    }

    public static Pair a(String s, String s1, List list)
    {
        Object obj = new l();
        String s2 = g.a().e();
        if (s2 == null || s2.isEmpty())
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("token", s2));
        arraylist.add(new BasicNameValuePair("cv", s));
        a(s1, (new StringBuilder()).append("queryMessage api start query ").append(g.c.format(new Date())).toString());
        s = ((l) (obj)).a("chat", "queryMessageV2", arraylist);
        a(s1, (new StringBuilder()).append("queryMessage api end query ").append(g.c.format(new Date())).toString());
        obj = (String)((Pair) (s)).first;
        if (obj != null && ((String) (obj)).equals("200"))
        {
            s = (String)((Pair) (s)).second;
            if (s != null && !s.isEmpty())
            {
                a(s1, (new StringBuilder()).append("queryMessage api result = ").append(s).toString());
                String as[] = b(s);
                s = as[0];
                obj = as[1];
                String s3 = as[2];
                if (s == null || obj == null || s3 == null)
                {
                    return null;
                }
                s1 = u.a(s3, s1);
                if (s1 != null)
                {
                    list.addAll(s1);
                    return Pair.create(s, obj);
                }
            } else
            {
                a(s1, "queryMessage api result is empty");
            }
        } else
        {
            a(s1, (new StringBuilder()).append("queryMessage api result status = ").append(((String) (obj))).toString());
        }
        return null;
    }

    public static final void a()
    {
        Runnable runnable = new Runnable() {

            public void run()
            {
                Thread.currentThread().setName("doGcm");
                com.cyberlink.you.a.a.b();
                UnreadCountManager.a(g.I());
            }

        };
        try
        {
            b.execute(runnable);
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            Log.d("Heartbeat", "task reject.");
        }
    }

    private static void a(String s, String s1)
    {
        Log.d("Heartbeat", (new StringBuilder()).append(s).append(" ").append(s1).toString());
        if (s.equals("(GCM)"))
        {
            ULogUtility.b(s1, s);
            return;
        } else
        {
            ULogUtility.c(s, s1);
            return;
        }
    }

    private static boolean a(String s)
    {
        Object obj;
        Object obj1;
        String s1;
        Object obj2;
        int i;
        s1 = g.a().s();
        obj2 = "0";
        obj1 = null;
        i = 0;
        obj = null;
_L10:
        Object obj3;
        Object obj4;
        obj3 = obj1;
        obj4 = obj;
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        obj3 = obj1;
        obj4 = obj;
        if (((String) (obj2)).equals("1")) goto _L2; else goto _L3
_L3:
        obj3 = obj1;
        obj4 = obj;
        if (i >= 3) goto _L2; else goto _L4
_L4:
        a(s, (new StringBuilder()).append("query cv=").append(s1).toString());
        obj3 = new ArrayList();
        obj4 = a(s1, s, ((List) (obj3)));
        if (obj4 != null)
        {
            s1 = (String)((Pair) (obj4)).first;
            obj4 = (String)((Pair) (obj4)).second;
            boolean flag;
            int j;
            int k;
            int i1;
            if (c(s1) && obj4 != null && obj3 != null)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            a(s, "query fail");
            i++;
            obj2 = obj;
            obj = obj1;
            obj1 = obj2;
        } else
        {
            a(s, "query fail cv and empty is null.");
            i++;
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
        if (((String) (obj4)).equals("1"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj2 = new ArrayList();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            ((List) (obj2)).addAll(((java.util.Collection) (obj)));
        }
        if (!((List) (obj3)).isEmpty())
        {
            ((List) (obj2)).addAll(((java.util.Collection) (obj3)));
        }
        if (!((List) (obj2)).isEmpty() && !flag)
        {
            j = a(((List) (obj2)));
            if (j != -1)
            {
                obj1 = new ArrayList();
                k = j;
                do
                {
                    i1 = j;
                    if (k >= ((List) (obj2)).size())
                    {
                        break;
                    }
                    ((List) (obj1)).add(((List) (obj2)).get(k));
                    k++;
                } while (true);
                for (; i1 < ((List) (obj2)).size(); i1++)
                {
                    ((List) (obj2)).remove(((List) (obj2)).size() - 1);
                }

                obj = String.valueOf(Integer.valueOf(s1).intValue() - ((List) (obj1)).size());
            } else
            {
                obj = s1;
                obj1 = null;
            }
        } else
        {
            obj = s1;
            obj1 = null;
        }
        if (flag)
        {
            obj2 = b(((List) (obj2)));
            n.a().a(((List) (obj2)), s);
        } else
        {
            n.a().a(((List) (obj2)), s, false);
        }
        g.a().d(((String) (obj)));
        if (!flag) goto _L7; else goto _L6
_L6:
        a(s, "query stop");
        obj4 = obj1;
        obj3 = obj;
_L2:
        if (obj4 != null && !((List) (obj4)).isEmpty())
        {
            obj = b(((List) (obj4)));
            n.a().a(((List) (obj)), s);
            g.a().d(((String) (obj3)));
        }
        if (i >= 3)
        {
            return false;
        }
          goto _L8
_L7:
        obj3 = obj1;
        obj2 = obj4;
        obj1 = obj;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
_L5:
        if (true) goto _L7; else goto _L8
_L8:
        return true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static List b(List list)
    {
        if (list == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        int i = list.size() - 1;
        boolean flag = false;
        while (i >= 0 && !list.isEmpty()) 
        {
            if (!flag && (new b((Message)list.get(i))).q())
            {
                arraylist.add(0, Pair.create(list.get(i), Boolean.valueOf(true)));
                flag = true;
            } else
            {
                arraylist.add(0, Pair.create(list.get(i), Boolean.valueOf(false)));
            }
            i--;
        }
        return arraylist;
    }

    public static final void b()
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        a("(GCM)", "gcm thread start.");
        g.a().a(1);
        if (!a("(GCM)"))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        g.a().a(0);
_L2:
        a("(GCM)", "gcm thread end.");
        return;
        g.a().a(1);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static String[] b(String s)
    {
        Object obj1 = null;
        if (s.isEmpty()) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = s.indexOf(">");
        j = s.lastIndexOf("</");
        if (i == -1 || j == -1) goto _L2; else goto _L3
_L3:
        String s1 = s.substring(i + 1, j);
_L12:
        Object obj;
        obj = XmlPullParserFactory.newInstance();
        ((XmlPullParserFactory) (obj)).setNamespaceAware(true);
        obj = ((XmlPullParserFactory) (obj)).newPullParser();
        ((XmlPullParser) (obj)).setInput(new StringReader(s));
        i = ((XmlPullParser) (obj)).getEventType();
_L7:
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (i != 2) goto _L5; else goto _L4
_L4:
        if (!((XmlPullParser) (obj)).getName().equals("messages")) goto _L5; else goto _L6
_L6:
        s = ((XmlPullParser) (obj)).getAttributeValue("", "cv");
        obj = ((XmlPullParser) (obj)).getAttributeValue("", "empty");
_L8:
        return (new String[] {
            s, obj, s1
        });
_L5:
        i = ((XmlPullParser) (obj)).next();
          goto _L7
        obj;
        s = null;
_L10:
        ((XmlPullParserException) (obj)).printStackTrace();
        obj = obj1;
          goto _L8
        obj;
        s = null;
_L9:
        ((IOException) (obj)).printStackTrace();
        obj = obj1;
          goto _L8
        obj;
          goto _L9
        obj;
          goto _L10
        s = null;
        obj = obj1;
          goto _L8
_L2:
        s1 = null;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private static boolean c(String s)
    {
        if (s == null)
        {
            return false;
        }
        try
        {
            Integer.valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    static 
    {
        b = new ThreadPoolExecutor(1, 1, 0x7fffffffffffffffL, TimeUnit.SECONDS, new ArrayBlockingQueue(1));
    }
}
