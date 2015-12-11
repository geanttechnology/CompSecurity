// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.Context;
import com.wishabi.flipp.content.FormattedString;
import com.wishabi.flipp.content.ab;
import java.util.HashMap;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment, FlippApplication, fq, fp

final class ed
    implements Runnable
{

    final SearchFragment a;

    ed(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final void run()
    {
        android.app.FragmentManager fragmentmanager;
        Context context;
label0:
        {
            if (SearchFragment.r(a) && a.isResumed() && SearchFragment.e(a) != null && !SearchFragment.e(a).isEmpty())
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
        fp.a(fragmentmanager, null, "tutorial_showed_coupon_matchup", new FormattedString(new com.wishabi.flipp.content.FormattedString.Part[] {
            new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e0149), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.a)
            }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e014a), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.b)
            }), new com.wishabi.flipp.content.FormattedString.Part(context.getString(0x7f0e014b), new com.wishabi.flipp.content.FormattedString.Format[] {
                new com.wishabi.flipp.content.FormattedString.Format(ab.a)
            })
        }), 0x7f0200f5, 0x7f0200f8, null);
    }
}
