// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.database.more.h.e;
import com.cyberlink.youcammakeup.database.more.i.a;
import com.cyberlink.youcammakeup.database.more.i.d;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bt, au, bh, bg, 
//            bi, bo

public class bj extends bt
{

    bi a;
    bh b;

    public bj(bi bi1, bh bh1)
    {
        super(bi1, bh1);
        a = null;
        b = null;
        a = bi1;
        b = bh1;
    }

    protected com.cyberlink.youcammakeup.database.more.b.a a(String s, int i, Node node, String s1)
    {
        Object obj = (Element)node;
        String s2 = ((Element) (obj)).getAttribute("sku_guid");
        if (s2.equals(""))
        {
            return super.a(s, i, node, s1);
        }
        Object obj1 = ((Element) (obj)).getTextContent().trim();
        s = ((Element) (obj)).getAttribute("guid");
        node = ((Element) (obj)).getAttribute("pattern_guid");
        String s3 = ((Element) (obj)).getAttribute("color_number");
        obj = ((Element) (obj)).getAttribute("intensity");
        if (!((String) (obj)).equals(""))
        {
            i = Integer.parseInt(((String) (obj)));
        }
        if (((String) (obj1)).length() == 12)
        {
            String s4 = ((String) (obj1)).substring(6).toUpperCase(Locale.getDefault());
            obj1 = com.cyberlink.youcammakeup.utility.au.a(Integer.parseInt(((String) (obj1)).substring(0, 2), 16), Integer.parseInt(((String) (obj1)).substring(2, 4), 16), false, 0, "").toString();
            obj = UUID.randomUUID().toString();
            b.a.a.add(new a(s2, s, node, s3, "", a.a.b(), s4, i, ((String) (obj1)), "", ""));
            b.a.b.add(new com.cyberlink.youcammakeup.database.more.b.a(((String) (obj)), s1, s4, String.valueOf(i), a.d.name(), ((String) (obj1)), s, ""));
            obj1 = b.a.c;
            s4 = a.d.name();
            float f = com.cyberlink.youcammakeup.utility.bo.d;
            boolean flag;
            if (a.d == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((List) (obj1)).add(new com.cyberlink.youcammakeup.database.more.g.a(s, ((String) (obj)), 1, "", "", s4, f, 0, flag, s2, "", s1, s3, node, "", ""));
            if (!node.equals("") && !s.equals(""))
            {
                b.a.d.add(new e(node, s, a.d.name(), null, null, 1, Integer.valueOf(i).toString()));
            }
        }
        return null;
    }

    protected com.cyberlink.youcammakeup.database.more.b.a a(String s, Node node, int i, boolean flag, int j, String s1, String s2, 
            String s3, String s4)
    {
        Object obj = (Element)node;
        String s5 = ((Element) (obj)).getAttribute("sku_guid");
        if (s5.equals(""))
        {
            s = super.a(s, node, i, flag, j, s1, s2, s3, s4);
        } else
        {
            s3 = ((Element) (obj)).getAttribute("guid");
            s4 = ((Element) (obj)).getAttribute("pattern_guid");
            String s6 = ((Element) (obj)).getAttribute("color_number");
            node = ((Element) (obj)).getAttribute("intensity");
            float f;
            if (!node.equals(""))
            {
                i = Integer.parseInt(node);
            }
            node = com.cyberlink.youcammakeup.utility.bo.e(((Element) (obj)).getTextContent().trim());
            s2 = com.cyberlink.youcammakeup.utility.au.a("", "", String.valueOf(flag), String.valueOf(j), com.cyberlink.youcammakeup.utility.au.a(s2)).toString();
            b.a.a.add(new a(s5, s3, s4, s6, "", a.a.b(), node, i, s2, "", ""));
            node = new com.cyberlink.youcammakeup.database.more.b.a(s, s1, node, String.valueOf(i), a.d.name(), s2, s3, "");
            b.a.b.add(node);
            s2 = b.a.c;
            obj = a.d.name();
            f = com.cyberlink.youcammakeup.utility.bo.d;
            if (a.d == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            s2.add(new com.cyberlink.youcammakeup.database.more.g.a(s3, s, 1, "", "", ((String) (obj)), f, 0, flag, s5, "", s1, s6, s4, "", ""));
            s = node;
            if (!s4.equals(""))
            {
                s = node;
                if (!s3.equals(""))
                {
                    b.a.d.add(new e(s4, s3, a.d.name(), null, null, 1, Integer.valueOf(i).toString()));
                    return node;
                }
            }
        }
        return s;
    }
}
