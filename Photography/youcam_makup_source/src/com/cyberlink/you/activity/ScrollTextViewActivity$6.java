// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import com.cyberlink.you.chat.r;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.utility.ULogUtility;
import org.jivesoftware.smack.packet.IQ;

// Referenced classes of package com.cyberlink.you.activity:
//            ScrollTextViewActivity

class a
    implements r
{

    final IQ a;
    final ScrollTextViewActivity b;

    public void a()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append((new StringBuilder()).append("Ping ").append(l.a("chat", "xmpp.server")).append("\n").toString());
        stringbuffer.append((new StringBuilder()).append("messageId: ").append(a.q()).toString());
        ULogUtility.a(stringbuffer.toString(), "Send", com.cyberlink.you.utility..a);
        ScrollTextViewActivity.a(b, ScrollTextViewActivity.c(b), stringbuffer.toString());
    }

    public void b()
    {
        ULogUtility.a("Ping fail by sendPack eception:\nSend packet error.", "Send", com.cyberlink.you.utility.);
        ScrollTextViewActivity.a(b, ScrollTextViewActivity.c(b), "Ping fail by sendPack eception:\nSend packet error.");
    }

    _cls9(ScrollTextViewActivity scrolltextviewactivity, IQ iq)
    {
        b = scrolltextviewactivity;
        a = iq;
        super();
    }
}
