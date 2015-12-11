// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.au;
import com.wishabi.flipp.b.t;
import com.wishabi.flipp.widget.ZeroCaseView;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment

final class eb
    implements android.view.View.OnClickListener
{

    final String a;
    final SearchFragment b;

    eb(SearchFragment searchfragment, String s)
    {
        b = searchfragment;
        a = s;
        super();
    }

    public final void onClick(View view)
    {
        SearchFragment.o(b).setIcon(0x7f0200c4);
        SearchFragment.o(b).setTitle(0x7f0e00f5);
        SearchFragment.o(b).setSubTitle(null);
        SearchFragment.o(b).a();
        (new au(a)).execute(new Void[0]);
        a.a.a(SearchFragment.f(b), t.b);
    }
}
