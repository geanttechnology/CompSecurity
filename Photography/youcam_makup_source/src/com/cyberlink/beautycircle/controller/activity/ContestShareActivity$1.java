// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.ViewGroup;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.controller.adapter.ShareAdapter;
import com.cyberlink.beautycircle.model.CompletePost;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ContestShareActivity

class b extends m
{

    final ViewGroup a;
    final ShareAdapter b;
    final ContestShareActivity c;

    protected void a(int i)
    {
        super.a(i);
        Globals.b("Query post fail, share the event.");
        com.cyberlink.beautycircle.utility.  = com.cyberlink.beautycircle.utility..a(ContestShareActivity.a(c));
        ContestShareActivity.a(c, a, b, );
    }

    protected void a(CompletePost completepost)
    {
        if (completepost == null || completepost.mainPost == null)
        {
            b(0x80000003);
            return;
        } else
        {
            c.n = completepost.mainPost;
            completepost = com.cyberlink.beautycircle.utility..a(c.n);
            completepost.e = "QUERY_CONTEST_POST_DEEPLINK";
            ContestShareActivity.a(c, a, b, completepost);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((CompletePost)obj);
    }

    (ContestShareActivity contestshareactivity, ViewGroup viewgroup, ShareAdapter shareadapter)
    {
        c = contestshareactivity;
        a = viewgroup;
        b = shareadapter;
        super();
    }
}
