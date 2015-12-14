// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you;

import android.util.Log;
import com.cyberlink.you.chat.n;
import com.cyberlink.you.friends.UserInfo;
import com.cyberlink.you.friends.l;
import com.cyberlink.you.friends.q;

// Referenced classes of package com.cyberlink.you:
//            g, u

class v
    implements q
{

    private String a;

    public v(String s)
    {
        a = s;
    }

    public void a()
    {
        Object obj = g.a().h();
        UserInfo userinfo = ((UserInfo) (obj));
        if (obj == null)
        {
            obj = new l();
            userinfo = ((l) (obj)).h();
            g.a().a(userinfo);
            ((l) (obj)).b();
        }
        if (userinfo == null)
        {
            return;
        }
        obj = l.f();
        Log.d(u.a(), "[CommandUrlCallback] start xmpp connection.");
        if (((String) (obj)).equals("afterOpenningMessages"))
        {
            n.a().a(userinfo.f, a, false, null);
            return;
        } else
        {
            n.a().a(userinfo.f, a, false, null);
            return;
        }
    }

    public void b()
    {
    }
}
