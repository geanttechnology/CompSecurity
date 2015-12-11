// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;
import org.xml.sax.Attributes;

public final class cxr extends bnt
{

    public cxr()
    {
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        bmz1 = (cyh)bmz1.a(cyh);
        int k = a.b(a.a(attributes, new String[] {
            "w", "win"
        }), 0);
        int j = Integer.valueOf(a.a(attributes, new String[] {
            "t", "start"
        })).intValue();
        int i = a.b(a.a(attributes, new String[] {
            "d", "dur"
        }), 0);
        s = s.replaceAll("\n", "<br/>");
        if (a.a(attributes, new String[] {
    "append"
}) == null)
        {
            bmz1.a(k, s, j, i + j);
            return;
        }
        i += j;
        attributes = bmz1.a(k).a;
        bmz1 = s;
        if (!((cyf) (attributes)).b.isEmpty())
        {
            bmz1 = String.valueOf((String)((cyf) (attributes)).b.get(((cyf) (attributes)).b.size() - 1));
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                bmz1 = bmz1.concat(s);
            } else
            {
                bmz1 = new String(bmz1);
            }
        }
        if (i == j && !((cyf) (attributes)).a.isEmpty())
        {
            i = ((Integer)((cyf) (attributes)).a.get(((cyf) (attributes)).a.size() - 1)).intValue();
        }
        attributes.a(bmz1, j, i);
    }
}
