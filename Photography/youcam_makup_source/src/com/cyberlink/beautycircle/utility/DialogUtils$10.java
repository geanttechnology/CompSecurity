// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkContest;
import com.cyberlink.beautycircle.model.network.NetworkPost;
import com.cyberlink.beautycircle.model.network.r;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            DialogUtils

final class f
    implements android.content..OnClickListener
{

    final ortSource a;
    final String b;
    final long c;
    final String d;
    final Activity e;
    final Runnable f;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 70
    //                   1 94
    //                   2 118;
           goto _L1 _L2 _L3 _L4
_L1:
        DialogUtils.a(e, "", e.getResources().getString(m.bc_post_comment_report_confirm), null, null, e.getResources().getString(m.bc_dialog_button_ok), f);
        return;
_L2:
        if (a == ortSource.b)
        {
            r.a(b, c, "Inappropriate");
        } else
        if (a == ortSource.c)
        {
            NetworkPost.a(b, d, c, "Inappropriate");
            NetworkContest.d(Long.valueOf(c));
        } else
        {
            NetworkPost.a(b, d, c, "Inappropriate");
        }
_L3:
        if (a == ortSource.b)
        {
            r.a(b, c, "Copyright");
        } else
        if (a == ortSource.c)
        {
            NetworkPost.a(b, d, c, "Copyright");
            NetworkContest.d(Long.valueOf(c));
        } else
        {
            NetworkPost.a(b, d, c, "Copyright");
        }
_L4:
        if (a == ortSource.b)
        {
            r.a(b, c, "Other");
        } else
        if (a == ortSource.c)
        {
            NetworkPost.a(b, d, c, "Other");
            NetworkContest.d(Long.valueOf(c));
        } else
        {
            NetworkPost.a(b, d, c, "Other");
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    ortSource(ortSource ortsource, String s, long l, String s1, Activity activity, Runnable runnable)
    {
        a = ortsource;
        b = s;
        c = l;
        d = s1;
        e = activity;
        f = runnable;
        super();
    }
}
