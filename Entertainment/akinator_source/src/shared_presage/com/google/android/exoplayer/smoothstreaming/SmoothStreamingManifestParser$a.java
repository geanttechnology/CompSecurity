// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import android.util.Pair;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import shared_presage.com.google.android.exoplayer.ParserException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

private static abstract class b
{

    private final String a;
    private final String b;
    private final d c;
    private final List d = new LinkedList();

    protected static long a(XmlPullParser xmlpullparser, String s, long l)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            try
            {
                l = Long.parseLong(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
        }
        return l;
    }

    protected static String a(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            return xmlpullparser;
        } else
        {
            throw new ssingFieldException(s);
        }
    }

    protected static int b(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            int i;
            try
            {
                i = Integer.parseInt(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return i;
        } else
        {
            return -1;
        }
    }

    protected static int c(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            int i;
            try
            {
                i = Integer.parseInt(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return i;
        } else
        {
            throw new ssingFieldException(s);
        }
    }

    protected static long d(XmlPullParser xmlpullparser, String s)
    {
        xmlpullparser = xmlpullparser.getAttributeValue(null, s);
        if (xmlpullparser != null)
        {
            long l;
            try
            {
                l = Long.parseLong(xmlpullparser);
            }
            // Misplaced declaration of an exception variable
            catch (XmlPullParser xmlpullparser)
            {
                throw new ParserException(xmlpullparser);
            }
            return l;
        } else
        {
            throw new ssingFieldException(s);
        }
    }

    protected abstract Object a();

    protected final Object a(String s)
    {
        ssingFieldException ssingfieldexception = this;
        do
        {
            for (int i = 0; i < ssingfieldexception.d.size(); i++)
            {
                Pair pair = (Pair)ssingfieldexception.d.get(i);
                if (((String)pair.first).equals(s))
                {
                    return pair.second;
                }
            }

            if (ssingfieldexception.c == null)
            {
                return null;
            }
            ssingfieldexception = ssingfieldexception.c;
        } while (true);
    }

    public final Object a(XmlPullParser xmlpullparser)
    {
        boolean flag;
        int j;
        j = 0;
        flag = false;
_L7:
        xmlpullparser.getEventType();
        JVM INSTR tableswitch 1 4: default 44
    //                   1 371
    //                   2 70
    //                   3 307
    //                   4 265;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_371;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        int i;
        boolean flag1;
        flag1 = flag;
        i = j;
_L8:
        xmlpullparser.next();
        j = i;
        flag = flag1;
        if (true) goto _L7; else goto _L6
_L6:
        Object obj = xmlpullparser.getName();
        if (b.equals(obj))
        {
            b(xmlpullparser);
            flag1 = true;
            i = j;
        } else
        {
            i = j;
            flag1 = flag;
            if (flag)
            {
                if (j > 0)
                {
                    i = j + 1;
                    flag1 = flag;
                } else
                if (b(((String) (obj))))
                {
                    b(xmlpullparser);
                    i = j;
                    flag1 = flag;
                } else
                {
                    String s1 = a;
                    if ("QualityLevel".equals(obj))
                    {
                        obj = new <init>(this, s1);
                    } else
                    if ("Protection".equals(obj))
                    {
                        obj = new <init>(this, s1);
                    } else
                    if ("StreamIndex".equals(obj))
                    {
                        obj = new <init>(this, s1);
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        i = 1;
                        flag1 = flag;
                    } else
                    {
                        a(((a) (obj)).a(xmlpullparser));
                        i = j;
                        flag1 = flag;
                    }
                }
            }
        }
          goto _L8
_L5:
        i = j;
        flag1 = flag;
        if (flag)
        {
            i = j;
            flag1 = flag;
            if (j == 0)
            {
                c(xmlpullparser);
                i = j;
                flag1 = flag;
            }
        }
          goto _L8
_L4:
        i = j;
        flag1 = flag;
        if (flag)
        {
label0:
            {
                if (j <= 0)
                {
                    break label0;
                }
                i = j - 1;
                flag1 = flag;
            }
        }
          goto _L8
        String s;
        s = xmlpullparser.getName();
        d(xmlpullparser);
        i = j;
        flag1 = flag;
        if (b(s)) goto _L8; else goto _L9
_L9:
        return a();
        return null;
    }

    protected void a(Object obj)
    {
    }

    protected final void a(String s, Object obj)
    {
        d.add(Pair.create(s, obj));
    }

    protected void b(XmlPullParser xmlpullparser)
    {
    }

    protected boolean b(String s)
    {
        return false;
    }

    protected void c(XmlPullParser xmlpullparser)
    {
    }

    protected void d(XmlPullParser xmlpullparser)
    {
    }

    public ssingFieldException(ssingFieldException ssingfieldexception, String s, String s1)
    {
        c = ssingfieldexception;
        a = s;
        b = s1;
    }
}
