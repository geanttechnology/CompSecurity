// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.text.TextUtils;
import android.view.View;
import io.branch.referral.g;
import io.branch.referral.m;
import java.util.List;
import myobfuscated.cy.d;

// Referenced classes of package com.socialin.android.share:
//            a, b

final class e
    implements android.view.OnClickListener
{

    final b a;
    final String b;
    final List c;
    final boolean d;
    final boolean e;
    final a f;

    public final void onClick(View view)
    {
        com.socialin.android.share.a.a(f, new Runnable() {

            final a._cls18 a;

            public final void run()
            {
                String s4 = a.a.c;
                String s3 = a.b;
                String s2 = "photo_share_other";
                String s = s3;
                String s1 = s2;
                if (TextUtils.isEmpty(s3))
                {
                    if ("instagramTag".equals(s4))
                    {
                        s = "instagram";
                        s1 = "photo_share_instagram";
                    } else
                    if ("emailTag".equals(s4))
                    {
                        s = "email";
                        s1 = "photo_share_emaill";
                    } else
                    if ("twitterTag".equals(s4))
                    {
                        s = "twitter";
                        s1 = "photo_share_twitter";
                    } else
                    {
                        s = "other";
                        s1 = s2;
                    }
                }
                myobfuscated.cy.d.a(a.f.getActivity(), s, s1, com.socialin.android.share.a.h(a.f), new g(this, s4) {

                    private String a;
                    private _cls1 b;

                    public final void a(String s, m m)
                    {
                        com.socialin.android.share.a.a(b.a.f, b.a.c, b.a.d, b.a.e, a, s);
                    }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                });
            }

            
            {
                a = a._cls18.this;
                super();
            }
        });
    }

    _cls1.a(a a1, b b1, String s, List list, boolean flag, boolean flag1)
    {
        f = a1;
        a = b1;
        b = s;
        c = list;
        d = flag;
        e = flag1;
        super();
    }
}
