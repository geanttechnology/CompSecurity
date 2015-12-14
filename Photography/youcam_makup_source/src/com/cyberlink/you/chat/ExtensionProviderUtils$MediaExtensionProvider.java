// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import com.cyberlink.you.utility.d;
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
        a a1 = new a("media", "U");
        a1.a("mediaId", xmlpullparser.getAttributeValue(null, "mediaId"));
        a1.a("mediaType", xmlpullparser.getAttributeValue(null, "mediaType"));
        a1.a("albumId", xmlpullparser.getAttributeValue(null, "albumId"));
        a1.a("thumbnail", xmlpullparser.getAttributeValue(null, "thumbnail"));
        a1.a("original", xmlpullparser.getAttributeValue(null, "original"));
        a1.a("width", xmlpullparser.getAttributeValue(null, "width"));
        a1.a("height", xmlpullparser.getAttributeValue(null, "height"));
        a1.a("description", d.g(xmlpullparser.getAttributeValue(null, "description")));
        a1.a("noteMediaType", xmlpullparser.getAttributeValue(null, "noteMediaType"));
        a1.a("noteMediaDescription", xmlpullparser.getAttributeValue(null, "noteMediaDescription"));
        a1.a("commentCount", xmlpullparser.getAttributeValue(null, "commentCount"));
        return a1;
    }

    public ()
    {
    }
}
