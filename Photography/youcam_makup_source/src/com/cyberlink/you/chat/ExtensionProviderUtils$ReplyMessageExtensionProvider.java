// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.e;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.cyberlink.you.chat:
//            a

public class Q
    implements e
{

    public f a(XmlPullParser xmlpullparser)
    {
        String s;
        a a1;
        JSONObject jsonobject;
        boolean flag;
        boolean flag1;
        int i;
        flag = false;
        a1 = new a("textReply", "urn:xmpp:textreply:0");
        a1.a("sourceId ", xmlpullparser.getAttributeValue(null, "sourceId "));
        a1.a("sourceSender", xmlpullparser.getAttributeValue(null, "sourceSender"));
        String s1;
        try
        {
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (XmlPullParser xmlpullparser)
        {
            xmlpullparser.printStackTrace();
            return a1;
        }
        s = null;
        flag1 = false;
          goto _L1
_L11:
        i = xmlpullparser.next();
        if (i != 2) goto _L3; else goto _L2
_L2:
        s = xmlpullparser.getName();
          goto _L1
_L3:
        if (i != 4) goto _L5; else goto _L4
_L4:
        s1 = xmlpullparser.getText();
        if (s == null) goto _L1; else goto _L6
_L6:
        jsonobject.put(s, s1);
          goto _L1
_L5:
        if (i != 3) goto _L1; else goto _L7
_L7:
        if (!xmlpullparser.getName().equals("source")) goto _L9; else goto _L8
_L8:
        flag1 = true;
          goto _L10
_L9:
        if (xmlpullparser.getName().equals("body"))
        {
            flag = true;
        }
          goto _L10
_L12:
        a1.b(jsonobject.toString());
        return a1;
_L1:
        if (flag && flag1) goto _L12; else goto _L11
_L10:
        s = null;
          goto _L1
    }

    public Q()
    {
    }
}
