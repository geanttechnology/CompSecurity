// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.MenuItem;
import android.view.View;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, cz, c

class u
    implements android.view.View.OnClickListener
{

    final o a;

    u(o o1)
    {
        a = o1;
        super();
    }

    public void onClick(View view)
    {
        o.g(a).setVisible(false);
        if (!o.a(a).b())
        {
            o.c(a).setRequestedOrientation(1);
        }
        o.c(a).showManualEntryView(o.q(a), true, o.o(a), o.r(a), false, o.s(a), o.t(a));
        o.b(a).b(false);
        o.b(a).j();
    }
}
