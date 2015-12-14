// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements g
{

    private PackageManager a;
    private a b;

    public final void a(String s, m m)
    {
        m = new Intent("android.intent.action.SEND");
        m.setType("image/*");
        m.putExtra("android.intent.extra.SUBJECT", b.getResources().getString(0x7f0808af));
        m.putExtra("android.intent.extra.TEXT", com.socialin.android.share.a.b(b, s));
        m.setFlags(0x10000000);
        m.putExtra("android.intent.extra.STREAM", Uri.parse((new StringBuilder("file://")).append(com.socialin.android.share.a.e(b)).toString()));
        m.setType("image/*");
        s = com.socialin.android.share.a.a(a.queryIntentActivities(m, 0x10000), "com.tencent.WBlog");
        if (!TextUtils.isEmpty(s))
        {
            m.setClassName("com.tencent.WBlog", s);
            b.startActivity(m);
        }
    }

    r(a a1, PackageManager packagemanager)
    {
        b = a1;
        a = packagemanager;
        super();
    }
}
