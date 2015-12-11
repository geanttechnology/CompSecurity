// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;

// Referenced classes of package com.wishabi.flipp.app:
//            CouponFragment, FlippApplication, fq, fp

final class y
    implements Runnable
{

    final CouponFragment a;

    y(CouponFragment couponfragment)
    {
        a = couponfragment;
        super();
    }

    public final void run()
    {
        android.app.FragmentManager fragmentmanager = a.getFragmentManager();
        Context context = FlippApplication.b();
        if (context == null)
        {
            int i = fq.c;
            return;
        } else
        {
            fp.a(fragmentmanager, "TutorialHeroDialogTag", "tutorial_showed_hero_cell", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
                new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0151), new com.wishabi.flipp.content.FormattedString.Format[] {
                    new com.wishabi.flipp.content.FormattedString.Format(ab.a)
                }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0152), new com.wishabi.flipp.content.FormattedString.Format[] {
                    new com.wishabi.flipp.content.FormattedString.Format(ab.b)
                })
            }), 0x7f0200f7, 0x7f0200f8, null);
            return;
        }
    }
}
