// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.provider.e;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package com.cyberlink.you.chat:
//            a

public class 
    implements e
{

    public f a(XmlPullParser xmlpullparser)
    {
        a a1 = new a("sticker", "U");
        a1.a("stickerId", xmlpullparser.getAttributeValue(null, "stickerId"));
        a1.a("packId", xmlpullparser.getAttributeValue(null, "packId"));
        a1.a("width", xmlpullparser.getAttributeValue(null, "width"));
        a1.a("height", xmlpullparser.getAttributeValue(null, "height"));
        return a1;
    }

    public ()
    {
    }
}
