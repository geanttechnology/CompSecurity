// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.upload;

import android.text.TextUtils;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.tumblr.b;
import io.branch.referral.g;
import io.branch.referral.m;

// Referenced classes of package com.picsart.upload:
//            a, b

final class a
    implements g
{

    private com.picsart.upload.b a;
    private a b;

    public final void a(String s, m m)
    {
label0:
        {
            if (TextUtils.isEmpty(s))
            {
                m = new StringBuilder("http://picsart.com/i/");
                if (b.a.e() != null)
                {
                    s = b.a.e();
                } else
                {
                    s = "";
                }
                s = m.append(s).toString();
            }
            s = (new b(com.picsart.upload.a.d(b))).a(b.a.f(), b.a.c(), b.a.d(), s, b.a.l, b.a.m);
            if (a != null)
            {
                if (s == null || !s.contains("id"))
                {
                    break label0;
                }
                a.a("tumblr");
            }
            return;
        }
        a.a("tumblr", s);
    }

    blr.b(a a1, com.picsart.upload.b b1)
    {
        b = a1;
        a = b1;
        super();
    }
}
