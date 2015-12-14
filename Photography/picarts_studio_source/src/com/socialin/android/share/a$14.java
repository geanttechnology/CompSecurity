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

final class a
    implements android.view.OnClickListener
{

    final a a;

    public final void onClick(View view)
    {
        d.a(a.getActivity(), "fb_messenger", "photo_share_facebook_massenger", com.socialin.android.share.a.h(a), new g() {

            private a._cls14 a;

            public final void a(String s, m m)
            {
                com.socialin.android.share.a.d(a.a, s);
            }

            
            {
                a = a._cls14.this;
                super();
            }
        });
    }

    _cls1.a(a a1)
    {
        a = a1;
        super();
    }
}
