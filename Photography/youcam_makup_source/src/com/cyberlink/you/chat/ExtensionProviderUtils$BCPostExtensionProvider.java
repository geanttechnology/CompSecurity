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
        a a1 = new a("post", "U");
        a1.a("postId", xmlpullparser.getAttributeValue(null, "postId"));
        a1.a("postThumbnail", xmlpullparser.getAttributeValue(null, "postThumbnail"));
        a1.a("postSourceUrl", xmlpullparser.getAttributeValue(null, "postSourceUrl"));
        a1.a("postTitle", xmlpullparser.getAttributeValue(null, "postTitle"));
        a1.a("postType", xmlpullparser.getAttributeValue(null, "postType"));
        a1.a("authorThumbnail", xmlpullparser.getAttributeValue(null, "authorThumbnail"));
        a1.a("authorUserId", xmlpullparser.getAttributeValue(null, "authorUserId"));
        a1.a("authorName", xmlpullparser.getAttributeValue(null, "authorName"));
        a1.a("category", xmlpullparser.getAttributeValue(null, "category"));
        a1.a("width", xmlpullparser.getAttributeValue(null, "width"));
        a1.a("height", xmlpullparser.getAttributeValue(null, "height"));
        a1.a("likeCount", xmlpullparser.getAttributeValue(null, "likeCount"));
        a1.a("replyCount", xmlpullparser.getAttributeValue(null, "replyCount"));
        a1.a("circleInCount", xmlpullparser.getAttributeValue(null, "circleInCount"));
        a1.a("postCreateTime", xmlpullparser.getAttributeValue(null, "postCreateTime"));
        return a1;
    }

    public ()
    {
    }
}
