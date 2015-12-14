// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Hashtable;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class fq extends DefaultHandler
    implements fk
{

    private static final bm a = d.a(fq);
    private Stack b;
    private StringBuffer c;
    private StringBuffer d;
    private String e;
    private String f;
    private double g;
    private Vector h;
    private Hashtable i;

    public fq()
    {
        b = new Stack();
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0.0D;
        h = new Vector();
        i = new Hashtable();
    }

    private void a(fg fg1)
    {
        if (!h.isEmpty())
        {
            for (int j = 0; j < h.size(); j++)
            {
                if (((fg)h.elementAt(j)).b() < fg1.b())
                {
                    h.insertElementAt(fg1, j);
                    return;
                }
            }

        }
        h.addElement(fg1);
    }

    private void b()
        throws SAXException
    {
        if (b.isEmpty() || b.peek() != "input")
        {
            throw new SAXException("End Element> The top of the stack does not contain the token interpretation");
        }
        if (e == null)
        {
            throw new SAXException("Did not get any timings from input");
        }
        if (c == null)
        {
            throw new SAXException("Did not get any character from input");
        }
        StringTokenizer stringtokenizer1 = new StringTokenizer(c.toString(), " ");
        StringTokenizer stringtokenizer2 = new StringTokenizer(e, ",");
        StringTokenizer stringtokenizer;
        fg fg1;
        if (f != null)
        {
            stringtokenizer = new StringTokenizer(f, ",");
        } else
        {
            stringtokenizer = null;
        }
        c = null;
        e = null;
        f = null;
        if (stringtokenizer1.countTokens() != stringtokenizer2.countTokens())
        {
            throw new SAXException((new StringBuilder("timing(")).append(stringtokenizer2.countTokens()).append(") and inputs(").append(stringtokenizer1.countTokens()).append(") information does not have the same number of items").toString());
        }
        fg1 = new fg();
        fg1.a(g);
        double d1;
        String s;
        String s1;
        for (; stringtokenizer1.hasMoreTokens(); fg1.a(new fh(s, Long.parseLong(s1.substring(0, s1.indexOf("-"))), Long.parseLong(s1.substring(s1.indexOf("-") + 1)), d1, true, (byte)0)))
        {
            s = stringtokenizer1.nextToken();
            s1 = stringtokenizer2.nextToken();
            d1 = 0.0D;
            if (stringtokenizer != null)
            {
                d1 = Double.parseDouble(stringtokenizer.nextToken());
            }
        }

        a(fg1);
    }

    public final fa a()
    {
        Vector vector = h;
        Hashtable hashtable = i;
        return new ff(vector);
    }

    public void characters(char ac[], int j, int k)
        throws SAXException
    {
        if (a.a())
        {
            a.a((new StringBuilder("Received characters: ")).append(new String(ac, j, k)).toString());
        }
        if (!b.isEmpty() && b.peek() == "input")
        {
            if (c == null)
            {
                c = new StringBuffer(k);
            }
            c.append(ac, j, k);
        } else
        if (!b.isEmpty() && b.peek() == "NSS_Audio_Statistics")
        {
            if (d == null)
            {
                d = new StringBuffer(k);
            }
            d.append(ac, j, k);
            return;
        }
    }

    public void endElement(String s, String s1, String s2)
        throws SAXException
    {
        if (a.a())
        {
            a.a((new StringBuilder("Received endElement ")).append(s1).toString());
        }
        if (s1.equals("result"))
        {
            if (b.isEmpty() || b.peek() != "result")
            {
                throw new SAXException("End Element> The top of the stack does not contain the token result");
            }
            b.pop();
        } else
        {
            if (s1.equals("interpretation"))
            {
                if (b.isEmpty() || b.peek() != "interpretation")
                {
                    throw new SAXException("End Element> The top of the stack does not contain the token interpretation");
                } else
                {
                    b.pop();
                    return;
                }
            }
            if (s1.equals("input"))
            {
                b();
                b.pop();
                return;
            }
            if (s1.equals("NSS_Audio_Statistics"))
            {
                if (b.isEmpty() || b.peek() != "NSS_Audio_Statistics")
                {
                    throw new SAXException("End Element> The top of the stack does not contain the token NSS_Audio_Statistics");
                } else
                {
                    b.pop();
                    return;
                }
            }
            if (!b.isEmpty() && b.peek() == "NSS_Audio_Statistics")
            {
                if (d == null)
                {
                    s = "";
                } else
                {
                    s = d.toString().trim();
                }
                if (s1.equals("InputAudioLength"))
                {
                    i.put("IAL", s);
                }
                i.put(s1, s);
                d = null;
                return;
            }
        }
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (a.a())
        {
            a.a((new StringBuilder("Received startElement ")).append(s1).toString());
        }
        if (s1.equals("result"))
        {
            if (b.size() != 0)
            {
                throw new SAXException("StartElement> Found result but it is not the first token.");
            }
            b.push("result");
        } else
        {
            if (s1.equals("interpretation"))
            {
                if (b.isEmpty() || b.peek() != "result")
                {
                    throw new SAXException("StartElement> The interpretation token was found without a result being opened before.");
                }
                b.push("interpretation");
                s1 = attributes.getValue("timing");
                s = attributes.getValue("confidence");
                s2 = attributes.getValue("word_confidence");
                if (s1 == null)
                {
                    throw new SAXException("StartElement> There are no timings associated with this interpretation.");
                }
                if (s == null)
                {
                    throw new SAXException("StartElement> There is no confidence associated with this interpretation.");
                }
                e = s1;
                f = s2;
                try
                {
                    g = Double.parseDouble(s);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    throw new SAXException((new StringBuilder("StartElement> Could not parse the confidence: ")).append(s).toString(), s1);
                }
            }
            if (s1.equals("input"))
            {
                if (b.isEmpty() || b.peek() != "interpretation")
                {
                    throw new SAXException("StartElement> The input token was found without a interpretation being opened before.");
                } else
                {
                    b.push("input");
                    return;
                }
            }
            if (s1.equals("NSS_Audio_Statistics"))
            {
                if (b.isEmpty() || b.peek() != "result")
                {
                    throw new SAXException("StartElement> The NSS_Audio_Statistics token was found without a result being opened before.");
                } else
                {
                    b.push("NSS_Audio_Statistics");
                    return;
                }
            }
        }
    }

}
