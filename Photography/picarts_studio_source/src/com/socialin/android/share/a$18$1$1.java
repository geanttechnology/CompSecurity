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

final class a
    implements g
{

    private String a;
    private a b;

    public final void a(String s, m m)
    {
        com.socialin.android.share.a.a(b.b.b, b.b.b, b.b.b, b.b.b, a, s);
    }

    ( , String s)
    {
        b = ;
        a = s;
        super();
    }

    // Unreferenced inner class com/socialin/android/share/a$18

/* anonymous class */
    final class a._cls18
        implements android.view.View.OnClickListener
    {

        final b a;
        final String b;
        final List c;
        final boolean d;
        final boolean e;
        final a f;

        public final void onClick(View view)
        {
            com.socialin.android.share.a.a(f, new a._cls18._cls1(this));
        }

            
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


    // Unreferenced inner class com/socialin/android/share/a$18$1

/* anonymous class */
    final class a._cls18._cls1
        implements Runnable
    {

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
            d.a(a.f.getActivity(), s, s1, com.socialin.android.share.a.h(a.f), new a._cls18._cls1._cls1(this, s4));
        }

            
            {
                a = _pcls18;
                super();
            }
    }

}
