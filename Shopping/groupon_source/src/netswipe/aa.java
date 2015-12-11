// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.MenuItem;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, ar, cc, cz, 
//            c

class aa
    implements Runnable
{

    final o a;

    aa(o o1)
    {
        a = o1;
        super();
    }

    public void run()
    {
        cc cc1 = o.c(a).topInfoBar;
        ScanCardActivity scancardactivity = o.c(a);
        String s;
        if (o.d(a) || o.e(a))
        {
            s = "top_info_recognition";
        } else
        {
            s = "top_info_validation";
        }
        cc1.setText(ar.a(scancardactivity, s));
        o.c(a).topInfoBar.setShowLoading(true);
        o.c(a).showSuccessView(o.f(a), o.d(a), o.e(a));
        o.g(a).setVisible(false);
        o.b(a).c(o.a(a).e());
        o.b(a).b(true);
    }
}
