// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smackx.receipts;

import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.packet.f;

public class DeliveryReceiptRequest
    implements f
{

    public DeliveryReceiptRequest()
    {
    }

    public static DeliveryReceiptRequest a(e e1)
    {
        return (DeliveryReceiptRequest)e1.c("request", "urn:xmpp:receipts");
    }

    public String a()
    {
        return "request";
    }

    public String b()
    {
        return "urn:xmpp:receipts";
    }

    public String c()
    {
        return "<request xmlns='urn:xmpp:receipts'/>";
    }

    public CharSequence g()
    {
        return c();
    }
}
