// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import com.cyberlink.you.database.MessageObj;
import org.jivesoftware.smack.packet.Message;

public class XMPPObject
{

    public String a;
    public ContentType b;
    public MessageObj c;
    public String d;
    public Message e;

    public XMPPObject()
    {
    }

    public XMPPObject(String s, MessageObj messageobj)
    {
        a = s;
        c = messageobj;
        b = ContentType.a;
    }

    public XMPPObject(String s, String s1, Message message)
    {
        a = s;
        d = s1;
        e = message;
        b = ContentType.b;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            obj = (XMPPObject)obj;
            return d.equals(((XMPPObject) (obj)).d);
        }
    }

    public int hashCode()
    {
        return d.hashCode();
    }

    private class ContentType extends Enum
    {

        public static final ContentType a;
        public static final ContentType b;
        private static final ContentType c[];

        public static ContentType valueOf(String s)
        {
            return (ContentType)Enum.valueOf(com/cyberlink/you/chat/XMPPObject$ContentType, s);
        }

        public static ContentType[] values()
        {
            return (ContentType[])c.clone();
        }

        static 
        {
            a = new ContentType("MESSAGEOBJ", 0);
            b = new ContentType("RECEIPT", 1);
            c = (new ContentType[] {
                a, b
            });
        }

        private ContentType(String s, int i)
        {
            super(s, i);
        }
    }

}
