// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.os.AsyncTask;
import com.cyberlink.beautycircle.controller.a.ak;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a extends AsyncTask
{

    final com.cyberlink.beautycircle.model.bItem.MeListMode a;
    final p b;

    protected transient Void a(Void avoid[])
    {
        Long long1;
        Long long2;
        long l;
        if (a == com.cyberlink.beautycircle.model.bItem.MeListMode.b)
        {
            avoid = "circles";
            s.a = "bc_me_circle";
        } else
        if (a == com.cyberlink.beautycircle.model.bItem.MeListMode.c)
        {
            avoid = "posts";
            s.a = "bc_me_post";
        } else
        if (a == com.cyberlink.beautycircle.model.bItem.MeListMode.d)
        {
            avoid = "likes";
            s.a = "bc_me_like";
        } else
        if (a == com.cyberlink.beautycircle.model.bItem.MeListMode.e)
        {
            avoid = "follower";
        } else
        if (a == com.cyberlink.beautycircle.model.bItem.MeListMode.f)
        {
            avoid = "following";
        } else
        if (a == com.cyberlink.beautycircle.model.bItem.MeListMode.g)
        {
            avoid = "products";
        } else
        {
            avoid = "circles";
        }
        long2 = AccountManager.c();
        long1 = long2;
        if (long2 == null)
        {
            long1 = Long.valueOf(0L);
        }
        if (p.a(b) == -1L)
        {
            l = long1.longValue();
        } else
        {
            l = p.a(b);
        }
        long2 = Long.valueOf(l);
        if (long2.longValue() > 0L)
        {
            com.perfectcorp.a.b.a(new ak(avoid, long1, long2));
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    de(p p1, com.cyberlink.beautycircle.model.bItem.MeListMode melistmode)
    {
        b = p1;
        a = melistmode;
        super();
    }
}
