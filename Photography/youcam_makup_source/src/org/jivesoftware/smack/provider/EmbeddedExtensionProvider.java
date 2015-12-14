// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.packet.f;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.xmlpull.v1.XmlPullParser;

// Referenced classes of package org.jivesoftware.smack.provider:
//            e

public abstract class EmbeddedExtensionProvider
    implements e
{

    public EmbeddedExtensionProvider()
    {
    }

    protected abstract f a(String s, String s1, Map map, List list);

    public final f a(XmlPullParser xmlpullparser)
    {
        String s = xmlpullparser.getNamespace();
        String s1 = xmlpullparser.getName();
        HashMap hashmap = new HashMap();
        for (int i = 0; i < xmlpullparser.getAttributeCount(); i++)
        {
            hashmap.put(xmlpullparser.getAttributeName(i), xmlpullparser.getAttributeValue(i));
        }

        ArrayList arraylist = new ArrayList();
        do
        {
            if (xmlpullparser.next() == 2)
            {
                arraylist.add(PacketParserUtils.a(xmlpullparser.getName(), xmlpullparser.getNamespace(), xmlpullparser));
            }
        } while (!s1.equals(xmlpullparser.getName()));
        return a(s1, s, ((Map) (hashmap)), ((List) (arraylist)));
    }
}
