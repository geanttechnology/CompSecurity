// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import io.presage.do.e;

// Referenced classes of package io.presage.actions:
//            f, e, n, i, 
//            m, l, o, h, 
//            a

public final class d
{

    private static d a = null;

    public d()
    {
    }

    public static a a(String s, String s1, e e1)
    {
        Object obj = null;
        if (s1.equals("finger_access"))
        {
            s = new f(s, s1, e1);
        } else
        {
            if (s1.equals("create_bookmarks"))
            {
                return new io.presage.actions.e(s, s1, e1);
            }
            if (s1.equals("write_history"))
            {
                return new n(s, s1, e1);
            }
            if (s1.equals("manage_presage"))
            {
                return new i(s, s1, e1);
            }
            if (s1.equals("send_ad_event"))
            {
                return new m(s, s1, e1);
            }
            if (s1.equals("open_browser"))
            {
                return new l(s, s1, e1);
            }
            if (s1.equals("write_search"))
            {
                return new o(s, s1, e1);
            }
            if (s1.equals("intent"))
            {
                return new h(s, s1, e1);
            }
            s = obj;
            if (s1.equals("home"))
            {
                return new h("home", "intent", e1);
            }
        }
        return s;
    }

    public static d a()
    {
        if (a == null)
        {
            a = new d();
        }
        return a;
    }

}
