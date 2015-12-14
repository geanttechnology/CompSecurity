// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import android.util.Log;
import android.util.Pair;
import java.util.List;

// Referenced classes of package com.cyberlink.you.friends:
//            l, p, r

class m
    implements Runnable
{

    final l a;
    private String b;
    private String c;
    private List d;
    private p e;

    public m(l l1, String s, String s1, List list, p p1)
    {
        a = l1;
        super();
        b = s;
        c = s1;
        d = list;
        e = p1;
    }

    public void run()
    {
        String s = l.a(b, c);
        if (s == null)
        {
            Log.d("FriendsClient", (new StringBuilder()).append("table=").append(b).append(" field=").append(c).append(" command does not exists.").toString());
            if (e != null)
            {
                e.a(b, c, null, null);
            }
        } else
        {
            Object obj = l.a(s, d);
            s = (String)((Pair) (obj)).first;
            obj = (String)((Pair) (obj)).second;
            if (e != null)
            {
                r.a(l.b(a), b, c, d, s, ((String) (obj)));
                e.a(b, c, s, ((String) (obj)));
                return;
            }
        }
    }
}
