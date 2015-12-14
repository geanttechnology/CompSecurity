// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.content.Intent;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.model.Stream;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.asyncnet.Request;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            t, r

final class u extends t
{

    private String a;
    private String b;
    private r c;

    public u(r r1, String s, String s1)
    {
        c = r1;
        super(r1, (byte)0);
        a = s;
        b = s1;
    }

    public final void a(Stream stream)
    {
        m.b(r.b(c), r.c(c));
        AnalyticUtils.getInstance(r.b(c)).track(new com.socialin.android.apiv3.events.EventsFactory.MemboxRenameEvent(a));
        stream = new Intent();
        stream.putExtra("memboxName", a);
        stream.putExtra("memboxDesc", b);
        stream.putExtra("renameSuccess", true);
        r.b(c).setResult(-1, stream);
        r.b(c).finish();
    }

    public final void onSuccess(Object obj, Request request)
    {
        a((Stream)obj);
    }
}
