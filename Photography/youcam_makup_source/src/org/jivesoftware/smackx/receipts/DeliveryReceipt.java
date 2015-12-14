// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.receipts;

import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.packet.f;

public class DeliveryReceipt
    implements f
{

    private String a;

    public DeliveryReceipt(String s)
    {
        a = s;
    }

    public static DeliveryReceipt a(e e1)
    {
        return (DeliveryReceipt)e1.c("received", "urn:xmpp:receipts");
    }

    public String a()
    {
        return "received";
    }

    public String b()
    {
        return "urn:xmpp:receipts";
    }

    public String c()
    {
        return a;
    }

    public String d()
    {
        return (new StringBuilder()).append("<received xmlns='urn:xmpp:receipts' id='").append(a).append("'/>").toString();
    }

    public CharSequence g()
    {
        return d();
    }
}
