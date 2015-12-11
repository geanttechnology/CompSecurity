// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.c;

import com.liverail.library.b.a;
import com.liverail.library.g.b;
import com.liverail.library.g.c;
import com.liverail.library.g.d;
import com.liverail.library.g.e;
import com.liverail.library.g.f;
import com.liverail.library.g.i;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class k extends DefaultHandler
{

    private static final String a = "setup";
    private static final String b = "ads";
    private static final String c = "adslot";
    private static final String d = "ad";
    private static final String e = "linear";
    private static final String f = "tracker";
    private static final String g = "url";
    private static final String h = "geo";
    private static final String i = "text_title";
    private static final String j = "text_description";
    private static final String k = "timings";
    private static final String l = "text_url";
    private static final String m = "clickthru";
    private static final String n = "content";
    private static final String o = "companions";
    private static final String p = "message";
    private static final String q = "source";
    private e A;
    private com.liverail.library.g.a B;
    private b C;
    private c D;
    private d r;
    private boolean s;
    private boolean t;
    private String u;
    private boolean v;
    private boolean w;
    private boolean x;
    private f y;
    private i z;

    public k()
    {
    }

    public boolean a(String s1, d d1)
    {
        s = false;
        r = d1;
        r.e = 0;
        t = false;
        u = null;
        v = false;
        w = false;
        x = false;
        try
        {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(s1)), this);
            s = true;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.liverail.library.b.a.e((new StringBuilder("LiveRail Parse ParserConfigurationException ")).append(s1.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.liverail.library.b.a.e((new StringBuilder("LiveRail Parse SAXException ")).append(s1.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.liverail.library.b.a.e((new StringBuilder("LiveRail Parse IOException ")).append(s1.getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.liverail.library.b.a.e((new StringBuilder("LiveRail Parse Exception ")).append(s1.getMessage()).toString());
        }
        return s;
    }

    public void characters(char ac[], int i1, int j1)
    {
label0:
        {
            if (t)
            {
                if (u != null)
                {
                    break label0;
                }
                u = new String(ac, i1, j1);
            }
            return;
        }
        u = u.concat(new String(ac, i1, j1));
    }

    public void endElement(String s1, String s2, String s3)
    {
        if (r.e != 2) goto _L2; else goto _L1
_L1:
        if (s3.equalsIgnoreCase("url") && y != null && u != null && u.length() > 1)
        {
            y.e = u;
        }
_L9:
        t = false;
        u = null;
        return;
_L2:
        if (r.e != 3)
        {
            break MISSING_BLOCK_LABEL_878;
        }
        if (s3.equalsIgnoreCase("setup"))
        {
            v = false;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("ads"))
        {
            w = false;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("companions"))
        {
            x = false;
            continue; /* Loop/switch isn't completed */
        }
        if (x)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("url") && z != null)
        {
            z.u.add(u);
            continue; /* Loop/switch isn't completed */
        }
        if (v)
        {
            if (s3.equalsIgnoreCase("tracker") && z != null)
            {
                r.j.put(z.a(), z);
                z = null;
            } else
            if (s3.equalsIgnoreCase("geo"))
            {
                r.k = u;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!w)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("text_title") && B != null)
        {
            B.k = u;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("text_description") && B != null)
        {
            B.l = u;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("text_url") && B != null)
        {
            B.m = u;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("clickthru") && B != null)
        {
            B.n = u;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("url") && D != null)
        {
            D.e = u;
            if (C != null)
            {
                C.e.add(D);
            }
            D = null;
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("linear") && C != null)
        {
            if (B != null)
            {
                B.i = C;
            }
            C = null;
            continue; /* Loop/switch isn't completed */
        }
        if (!s3.equalsIgnoreCase("tracker") || z == null) goto _L4; else goto _L3
_L3:
        if (B == null) goto _L6; else goto _L5
_L5:
        B.o.put(z.a(), z);
_L7:
        z = null;
        continue; /* Loop/switch isn't completed */
_L6:
        if (A != null)
        {
            A.e.put(z.a(), z);
        }
        if (true) goto _L7; else goto _L4
_L4:
        if (s3.equalsIgnoreCase("ad") && B != null)
        {
            if (A != null)
            {
                if (B.b.equalsIgnoreCase("LR") && B.a == 1 && B.i != null && B.i.e != null && B.i.e.size() > 0 && B.j == 0)
                {
                    A.d.add(B);
                } else
                {
                    s2 = new StringBuilder("Discarding unsupported ad ");
                    if (B.i != null)
                    {
                        s1 = "";
                    } else
                    {
                        s1 = "linear=null, ";
                    }
                    s2 = s2.append(s1);
                    if (B.i != null && B.i.e != null && B.i.e.size() > 0)
                    {
                        s1 = "";
                    } else
                    {
                        s1 = "assets=0, ";
                    }
                    s2 = s2.append(s1);
                    if (B.j == 0)
                    {
                        s1 = "";
                    } else
                    {
                        s1 = (new StringBuilder("startTime=")).append(B.j).toString();
                    }
                    com.liverail.library.b.a.d(s2.append(s1).append('\n').append(B).toString());
                }
            }
            B = null;
        } else
        if (s3.equalsIgnoreCase("adslot") && A != null)
        {
            r.l.add(A);
            A = null;
        }
        continue; /* Loop/switch isn't completed */
        if (r.e == 1 && s3.equalsIgnoreCase("message"))
        {
            r.h = u;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void error(SAXParseException saxparseexception)
    {
        com.liverail.library.b.a.e((new StringBuilder("error: ")).append(saxparseexception).toString());
    }

    public void fatalError(SAXParseException saxparseexception)
    {
        com.liverail.library.b.a.e((new StringBuilder("fatalError: ")).append(saxparseexception).toString());
    }

    public void startDocument()
    {
    }

    public void startElement(String s1, String s2, String s3, Attributes attributes)
    {
        int i1 = 2;
        if (!s3.equalsIgnoreCase("liverail")) goto _L2; else goto _L1
_L1:
        s1 = attributes.getValue("content");
        com.liverail.library.b.a.a((new StringBuilder("XML Response content=")).append(s1).toString());
        if (s1.equalsIgnoreCase("sources"))
        {
            r.e = 2;
        } else
        if (s1.equalsIgnoreCase("ads"))
        {
            r.e = 3;
        } else
        if (s1.equalsIgnoreCase("error"))
        {
            r.e = 1;
        } else
        {
            r.e = 0;
        }
        r.f = attributes.getValue("version");
        r.g = attributes.getValue("srv");
_L4:
        return;
_L2:
        if (r.e == 2)
        {
            if (!s3.equalsIgnoreCase("source"))
            {
                continue; /* Loop/switch isn't completed */
            }
            y = new f();
            r.i.add(y);
            i1 = attributes.getLength() - 1;
            do
            {
                if (i1 < 0)
                {
                    s1 = (String)y.d.get("erc");
                    if (s1 == null || s1.length() == 0)
                    {
                        y.b("0");
                        return;
                    }
                    continue; /* Loop/switch isn't completed */
                }
                y.d.put(attributes.getLocalName(i1), attributes.getValue(i1));
                i1--;
            } while (true);
        }
        break MISSING_BLOCK_LABEL_311;
        if (!s3.equalsIgnoreCase("url")) goto _L4; else goto _L3
_L3:
        t = true;
        u = null;
        return;
        if (r.e != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (s3.equalsIgnoreCase("setup"))
        {
            v = true;
            return;
        }
        if (s3.equalsIgnoreCase("ads"))
        {
            w = true;
            return;
        }
        if (s3.equalsIgnoreCase("companions"))
        {
            x = true;
            return;
        }
        if (x)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s3.equalsIgnoreCase("tracker"))
        {
            break; /* Loop/switch isn't completed */
        }
        z = new i(attributes.getValue("type"));
        if (z.s.equals("view"))
        {
            z.t = Integer.parseInt(attributes.getValue("value"));
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (s3.equalsIgnoreCase("adslot"))
        {
            if (!attributes.getValue("type").equalsIgnoreCase("ov"))
            {
                i1 = 1;
            }
            A = new e(i1);
            return;
        }
        if (s3.equalsIgnoreCase("ad") && A != null)
        {
            B = new com.liverail.library.g.a(A.c);
            B.b = attributes.getValue("adapter");
            B.c = attributes.getValue("nid");
            B.g = attributes.getValue("cid");
            B.h = attributes.getValue("oid");
            B.d = attributes.getValue("coid");
            B.e = attributes.getValue("ss");
            B.f = attributes.getValue("nr");
            return;
        }
        if (s3.equalsIgnoreCase("timings") && B != null)
        {
            B.j = Integer.parseInt(attributes.getValue("start"));
            return;
        }
        if (!s3.equalsIgnoreCase("linear") || B == null)
        {
            break; /* Loop/switch isn't completed */
        }
        C = new b();
        C.a = attributes.getValue("type");
        C.b = Integer.parseInt(attributes.getValue("duration"));
        s1 = attributes.getValue("skipoffset");
        if (s1 != null && s1.length() > 0)
        {
            C.c = Integer.parseInt(s1);
            if (s1.contains("%"))
            {
                C.d = true;
                return;
            }
        }
        if (true) goto _L4; else goto _L6
_L6:
        if (s3.equalsIgnoreCase("url") && B != null && C != null)
        {
            D = new c();
            D.b = Integer.parseInt(attributes.getValue("kbps"));
            D.c = Integer.parseInt(attributes.getValue("width"));
            D.d = Integer.parseInt(attributes.getValue("height"));
            D.a = attributes.getValue("mimetype");
            t = true;
            u = null;
            return;
        }
        if (!s3.equalsIgnoreCase("url") && !s3.equalsIgnoreCase("geo") && !s3.equalsIgnoreCase("text_title") && !s3.equalsIgnoreCase("text_description") && !s3.equalsIgnoreCase("text_url") && !s3.equalsIgnoreCase("clickthru") && !s3.equalsIgnoreCase("content")) goto _L4; else goto _L7
_L7:
        t = true;
        u = null;
        return;
        if (r.e != 1 || !s3.equalsIgnoreCase("message")) goto _L4; else goto _L8
_L8:
        t = true;
        u = null;
        return;
    }

    public void warning(SAXParseException saxparseexception)
    {
        com.liverail.library.b.a.d((new StringBuilder("warning: ")).append(saxparseexception).toString());
    }
}
