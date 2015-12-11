// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.DefaultHandler;

final class bnv extends DefaultHandler
{

    public Object a;
    private final bnq b;
    private final bmz c = new bmz();
    private final bmz d = new bmz();
    private final bmz e = new bmz();
    private final bmz f = new bmz();

    public bnv(bnq bnq1)
    {
        b = bnq1;
        d.offer("");
    }

    public final void characters(char ac[], int i, int j)
    {
        String s = (String)d.peek();
        if (b.a(s) != null)
        {
            ((StringBuilder)f.peek()).append(ac, i, j);
        }
    }

    public final void endElement(String s, String s1, String s2)
    {
        s = (String)d.poll();
        s1 = b.a(s);
        if (s1 != null)
        {
            s2 = (Attributes)e.poll();
            String s3 = ((StringBuilder)f.poll()).toString();
            s = ((String) (c.peek()));
            if (s == null)
            {
                s = ((String) (a));
            }
            a = s;
            s1.a(c, s2, s3);
        }
    }

    public final void startElement(String s, String s1, String s2, Attributes attributes)
    {
        s = (String)d.peek();
        s = (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(s2).length())).append(s).append("/").append(s2).toString();
        d.offer(s);
        s1 = b.a(s);
        if (s1 != null)
        {
            s2 = e;
            if (attributes != null)
            {
                s = new AttributesImpl(attributes);
            } else
            {
                s = bns.b();
            }
            s2.offer(s);
            f.offer(new StringBuilder());
            s1.a(c, attributes);
        }
    }
}
