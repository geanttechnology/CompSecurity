// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import com.cyberlink.you.database.MessageObj;
import java.util.Comparator;

// Referenced classes of package com.cyberlink.you.chat:
//            ab, XMPPObject

class a
    implements Comparator
{

    final ab a;
    private final int b = 3;
    private final int c = 2;
    private final int d = 1;

    private int a(XMPPObject xmppobject)
    {
        if (b(xmppobject))
        {
            return 1;
        }
        return !xmppobject.b.equals(bject.ContentType.a) ? 2 : 3;
    }

    private boolean b(XMPPObject xmppobject)
    {
        xmppobject = xmppobject.c;
        if (xmppobject != null)
        {
            xmppobject = xmppobject.j();
            if (xmppobject.equals("6") || xmppobject.equals("10"))
            {
                return true;
            }
        }
        return false;
    }

    public int a(XMPPObject xmppobject, XMPPObject xmppobject1)
    {
        int i = a(xmppobject);
        return a(xmppobject1) - i;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((XMPPObject)obj, (XMPPObject)obj1);
    }

    bject(ab ab1)
    {
        a = ab1;
        super();
    }
}
