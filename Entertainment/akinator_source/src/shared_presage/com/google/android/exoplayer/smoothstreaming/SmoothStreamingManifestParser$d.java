// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.smoothstreaming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import shared_presage.com.google.android.exoplayer.ParserException;

// Referenced classes of package shared_presage.com.google.android.exoplayer.smoothstreaming:
//            SmoothStreamingManifestParser

private static final class a extends a
{

    private final String a;
    private final List b = new LinkedList();
    private int c;
    private String d;
    private long e;
    private String f;
    private int g;
    private String h;
    private int i;
    private int j;
    private int k;
    private int l;
    private String m;
    private ArrayList n;
    private long o;

    public final Object a()
    {
        ment ament[] = new ment[b.size()];
        b.toArray(ament);
        return new ement(a, h, c, d, e, f, g, i, j, k, l, m, ament, n, o);
    }

    public final void a(Object obj)
    {
        if (obj instanceof ment)
        {
            b.add((ment)obj);
        }
    }

    public final void b(XmlPullParser xmlpullparser)
    {
label0:
        {
            boolean flag = true;
            if ("c".equals(xmlpullparser.getName()))
            {
                int i1 = n.size();
                long l2 = a(xmlpullparser, "t", -1L);
                long l1 = l2;
                if (l2 == -1L)
                {
                    if (i1 == 0)
                    {
                        l1 = 0L;
                    } else
                    if (o != -1L)
                    {
                        l1 = ((Long)n.get(i1 - 1)).longValue() + o;
                    } else
                    {
                        throw new ParserException("Unable to infer start time");
                    }
                }
                n.add(Long.valueOf(l1));
                o = a(xmlpullparser, "d", -1L);
                l2 = a(xmlpullparser, "r", 1L);
                i1 = ((flag) ? 1 : 0);
                if (l2 > 1L)
                {
                    i1 = ((flag) ? 1 : 0);
                    if (o == -1L)
                    {
                        throw new ParserException("Repeated chunk with unspecified duration");
                    }
                }
                for (; (long)i1 < l2; i1++)
                {
                    n.add(Long.valueOf(o * (long)i1 + l1));
                }

            } else
            {
                String s = xmlpullparser.getAttributeValue(null, "Type");
                if (s == null)
                {
                    break label0;
                }
                int j1;
                if ("audio".equalsIgnoreCase(s))
                {
                    j1 = 0;
                } else
                if ("video".equalsIgnoreCase(s))
                {
                    j1 = 1;
                } else
                if ("text".equalsIgnoreCase(s))
                {
                    j1 = 2;
                } else
                {
                    throw new ParserException((new StringBuilder("Invalid key value[")).append(s).append("]").toString());
                }
                c = j1;
                a("Type", Integer.valueOf(c));
                if (c == 2)
                {
                    d = a(xmlpullparser, "Subtype");
                } else
                {
                    d = xmlpullparser.getAttributeValue(null, "Subtype");
                }
                f = xmlpullparser.getAttributeValue(null, "Name");
                g = b(xmlpullparser, "QualityLevels");
                h = a(xmlpullparser, "Url");
                i = b(xmlpullparser, "MaxWidth");
                j = b(xmlpullparser, "MaxHeight");
                k = b(xmlpullparser, "DisplayWidth");
                l = b(xmlpullparser, "DisplayHeight");
                m = xmlpullparser.getAttributeValue(null, "Language");
                e = b(xmlpullparser, "TimeScale");
                if (e == -1L)
                {
                    e = ((Long)a("TimeScale")).longValue();
                }
                n = new ArrayList();
            }
            return;
        }
        throw new ssingFieldException("Type");
    }

    public final boolean b(String s)
    {
        return "c".equals(s);
    }

    public ssingFieldException(ssingFieldException ssingfieldexception, String s)
    {
        super(ssingfieldexception, s, "StreamIndex");
        a = s;
    }
}
