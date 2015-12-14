// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.util.r;

public class AdvancedMessage extends Message
{

    private String a;
    private String b;

    public String a()
    {
        return a;
    }

    protected void a(r r1)
    {
        super.a(r1);
        r1.d("isScheduled", a());
        r1.d("isTtl", b());
    }

    public String b()
    {
        return b;
    }
}
