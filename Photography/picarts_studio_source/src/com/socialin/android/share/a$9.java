// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.view.View;
import io.branch.referral.g;
import io.branch.referral.m;
import myobfuscated.cy.d;

// Referenced classes of package com.socialin.android.share:
//            a

final class b
    implements android.view..OnClickListener
{

    final String a;
    final String b;
    final a c;

    public final void onClick(View view)
    {
        d.a(c.getActivity(), "instagram", "photo_share_instagram", com.socialin.android.share.a.h(c), new g() {

            private a._cls9 a;

            public final void a(String s, m m)
            {
                com.socialin.android.share.a.a(a.c, a.a, a.b, s);
            }

            
            {
                a = a._cls9.this;
                super();
            }
        });
    }

    _cls1.a(a a1, String s, String s1)
    {
        c = a1;
        a = s;
        b = s1;
        super();
    }
}
