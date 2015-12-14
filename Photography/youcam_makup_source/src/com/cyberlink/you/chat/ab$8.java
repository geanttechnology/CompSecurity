// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.database.MessageObj;
import java.util.concurrent.PriorityBlockingQueue;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.StreamMgmt;

// Referenced classes of package com.cyberlink.you.chat:
//            aa, ab, XMPPObject

class a
    implements aa
{

    final ab a;

    public boolean a(StreamMgmt streammgmt)
    {
        if (streammgmt != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((streammgmt = streammgmt.q()) == null) goto _L1; else goto _L3
_L3:
        XMPPObject xmppobject;
        Log.d("XMPPQueue", (new StringBuilder()).append("StreamMgmt: ").append(streammgmt).toString());
        xmppobject = (XMPPObject)ab.b(a).peek();
        if (xmppobject == null || !xmppobject.b.equals(bject.ContentType.a) || !xmppobject.c.b().equals(streammgmt)) goto _L5; else goto _L4
_L4:
        ab.a(a, xmppobject, true);
_L7:
        return true;
_L5:
        if (xmppobject != null && xmppobject.b.equals(bject.ContentType.b) && xmppobject.e.q().equals(streammgmt))
        {
            ab.a(a, xmppobject, true);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    t.StreamMgmt(ab ab1)
    {
        a = ab1;
        super();
    }
}
