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
        com.socialin.android.share.a.c(a.a.a, s);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/share/a$11

/* anonymous class */
    final class a._cls11
        implements android.view.View.OnClickListener
    {

        final a a;

        public final void onClick(View view)
        {
            com.socialin.android.share.a.a(a, new a._cls11._cls1(this));
        }

            
            {
                a = a1;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/share/a$11$1

/* anonymous class */
    final class a._cls11._cls1
        implements Runnable
    {

        final a._cls11 a;

        public final void run()
        {
            d.a(a.a.getActivity(), "whatsapp", "photo_share_whatsapp", com.socialin.android.share.a.h(a.a), new a._cls11._cls1._cls1(this));
        }

            
            {
                a = _pcls11;
                super();
            }
    }

}
