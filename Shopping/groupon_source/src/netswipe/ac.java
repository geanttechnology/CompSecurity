// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.core.ScanCardActivity;
import com.jumio.netswipe.sdk.enums.ErrorCase;

// Referenced classes of package netswipe:
//            o, by, cz, c

class ac
    implements Runnable
{

    final ErrorCase a;
    final o b;

    ac(o o1, ErrorCase errorcase)
    {
        b = o1;
        a = errorcase;
        super();
    }

    public void run()
    {
        if (o.c(b) == null || o.b(b) == null)
        {
            return;
        }
        if (o.c(b).successView != null)
        {
            o.c(b).successView.setVisibility(8);
        }
        ScanCardActivity scancardactivity = o.c(b);
        ErrorCase errorcase = a;
        android.view.View.OnClickListener onclicklistener;
        if (a.retry())
        {
            onclicklistener = o.h(b);
        } else
        {
            onclicklistener = o.i(b);
        }
        scancardactivity.showErrorView(errorcase, onclicklistener);
        o.b(b).c(o.a(b).e());
        o.b(b).b(true);
    }
}
