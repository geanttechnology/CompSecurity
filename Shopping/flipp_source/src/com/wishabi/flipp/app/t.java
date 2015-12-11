// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;

// Referenced classes of package com.wishabi.flipp.app:
//            n, FlippApplication, fq, fp

final class t
    implements Runnable
{

    final n a;

    t(n n1)
    {
        a = n1;
        super();
    }

    public final void run()
    {
        android.app.FragmentManager fragmentmanager;
        Context context;
label0:
        {
            if (a.isResumed())
            {
                fragmentmanager = a.getFragmentManager();
                context = FlippApplication.b();
                if (context != null)
                {
                    break label0;
                }
                int i = fq.c;
            }
            return;
        }
        fp.a(fragmentmanager, "TutorialPrintCouponDialogTag", "tutorial_showed_print_coupon", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
            new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e014f), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.b)
            }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0150), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.a)
            })
        }), 0x7f0200f9, 0x7f0200f1, null);
    }
}
