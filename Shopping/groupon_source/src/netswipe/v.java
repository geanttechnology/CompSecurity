// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.MenuItem;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, am, c

class v
    implements android.view.MenuItem.OnMenuItemClickListener
{

    final o a;

    v(o o1)
    {
        a = o1;
        super();
    }

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        o.g(a).setVisible(false);
        o.a(a, am.d);
        o.b(a).b(false);
        o.b(a).j();
        o.c(a).showManualEntryView(o.q(a), true, o.o(a), o.r(a), false, o.s(a), o.t(a));
        return false;
    }
}
