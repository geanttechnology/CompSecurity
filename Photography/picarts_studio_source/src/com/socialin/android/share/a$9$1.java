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
    implements g
{

    private a a;

    public final void a(String s, m m)
    {
        com.socialin.android.share.a.a(a.a, a.a, a.a, s);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/share/a$9

/* anonymous class */
    final class a._cls9
        implements android.view.View.OnClickListener
    {

        final String a;
        final String b;
        final a c;

        public final void onClick(View view)
        {
            d.a(c.getActivity(), "instagram", "photo_share_instagram", com.socialin.android.share.a.h(c), new a._cls9._cls1(this));
        }

            
            {
                c = a1;
                a = s;
                b = s1;
                super();
            }
    }

}
