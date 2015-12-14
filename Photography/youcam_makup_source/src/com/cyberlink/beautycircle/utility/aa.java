// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser

public class aa
{

    final ShareInXmlParser a;
    private final Date b = new Date();
    private Date c;
    private Date d;
    private Date e;

    public aa(ShareInXmlParser shareinxmlparser)
    {
        a = shareinxmlparser;
        super();
        c = null;
        d = null;
        e = null;
    }

    public String a(Date date)
    {
        if (date == null)
        {
            return "N/A";
        } else
        {
            return (new StringBuilder()).append((float)(date.getTime() - b.getTime()) / 1000F).append("s").toString();
        }
    }

    public void a()
    {
        if (c == null)
        {
            c = new Date();
        }
    }

    public void b()
    {
        if (d == null)
        {
            d = new Date();
        }
    }

    public void c()
    {
        if (e == null)
        {
            e = new Date();
        }
    }

    public String d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("First Add Image: ");
        stringbuilder.append(a(c));
        stringbuilder.append("\nFirst Callback Image: ");
        stringbuilder.append(a(d));
        stringbuilder.append("\nPage Finished: ");
        stringbuilder.append(a(e));
        return stringbuilder.toString();
    }

    public String e()
    {
        return a(new Date());
    }
}
