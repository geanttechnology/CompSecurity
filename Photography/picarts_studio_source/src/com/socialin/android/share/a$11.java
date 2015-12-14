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
        com.socialin.android.share.a.a(a, new Runnable() {

            final a._cls11 a;

            public final void run()
            {
                d.a(a.a.getActivity(), "whatsapp", "photo_share_whatsapp", com.socialin.android.share.a.h(a.a), new g(this) {

                    private _cls1 a;

                    public final void a(String s, m m)
                    {
                        com.socialin.android.share.a.c(a.a.a, s);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            
            {
                a = a._cls11.this;
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
