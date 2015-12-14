// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.e;
import com.cyberlink.you.g;
import java.util.Date;
import org.jivesoftware.smackx.receipts.DeliveryReceipt;

// Referenced classes of package com.cyberlink.you.chat:
//            w, UnreadCountManager, b

class a
    implements w
{

    final UnreadCountManager a;

    public String a(b b1)
    {
        if (!b1.q() || b1.p().equals(g.a().f()) || b1.e().equals(String.valueOf(g.a().g())) || !b1.k().after(g.a().q())) goto _L2; else goto _L1
_L1:
        if (b1.r() != null) goto _L4; else goto _L3
_L3:
        return null;
_L4:
        String s = b1.p();
        Log.d("UnreadCountManager", (new StringBuilder()).append("receive message id=").append(b1.i()).toString());
        a.a(s, true);
        a.a(UnreadCountListner.Type.a);
        UnreadCountManager.a(a, g.I());
        return null;
_L2:
        if (b1.g().equals(com.cyberlink.you.database.e.e))
        {
            Object obj = (DeliveryReceipt)b1.a("received", "urn:xmpp:receipts");
            if (obj != null)
            {
                obj = ((DeliveryReceipt) (obj)).c();
                if (b1.e().equals(String.valueOf(g.a().g())))
                {
                    obj = e.d().a(((String) (obj)));
                    if (obj != null)
                    {
                        b1 = e.f().d(((MessageObj) (obj)).c());
                        if (b1 != null)
                        {
                            UnreadCountManager.a(a, ((Group) (b1)).c, ((Group) (b1)).l);
                            a.a(UnreadCountListner.Type.a);
                            UnreadCountManager.a(a, g.I());
                            return null;
                        } else
                        {
                            Log.d("UnreadCountManager", (new StringBuilder()).append("Unread count update fail. group is null. message=").append(((MessageObj) (obj)).toString()).toString());
                            return null;
                        }
                    } else
                    {
                        Log.d("UnreadCountManager", (new StringBuilder()).append("Unread count update fail. messageObj is null. message=").append(b1.toString()).toString());
                        return null;
                    }
                }
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean a()
    {
        return false;
    }

    eipt(UnreadCountManager unreadcountmanager)
    {
        a = unreadcountmanager;
        super();
    }
}
