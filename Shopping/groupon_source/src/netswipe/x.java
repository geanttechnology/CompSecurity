// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.MenuItem;
import android.view.View;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, am, c, ce, 
//            bu, ar, cc, au, 
//            cl

class x
    implements android.view.View.OnClickListener
{

    final o a;

    x(o o1)
    {
        a = o1;
        super();
    }

    public void onClick(View view)
    {
        o.a(a, null);
        o.a(a, am.a);
        o.a(a, "");
        o.a(a, false);
        o.b(a, false);
        o.c(a).restoreScanView();
        o.b(a).h();
        o.b(a).m();
        o.j(a).b();
        o.c(a).scanOverlayView.a();
        o.c(a).topInfoBar.setText(ar.a(o.c(a), "top_info_align_card"));
        o.c(a).topInfoBar.setShowLoading(false);
        o.c(a).bottomButtonBar.b();
        o.g(a).setVisible(o.u(a));
        o.l(a).a(o.v(a));
        o.a(a, System.currentTimeMillis());
    }
}
