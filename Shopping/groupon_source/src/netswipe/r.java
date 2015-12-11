// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.View;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            as, o, c, ai, 
//            au, s, cz

class r
    implements android.view.View.OnClickListener
{

    final o a;

    r(o o1)
    {
        a = o1;
        super();
    }

    public void onClick(View view)
    {
        int i;
        view.setEnabled(false);
        i = Integer.valueOf(view.getId()).intValue();
        if (i != as.j) goto _L2; else goto _L1
_L1:
        o.b(a).f();
        if (o.p(a) != null && o.b(a).c())
        {
            o.p(a).a(false);
            o.c(a).bottomButtonBar.a();
        } else
        {
            o.c(a).bottomButtonBar.b();
        }
_L4:
        view.post(new s(this, view));
        return;
_L2:
        if (i == as.l)
        {
            o.b(a).k();
            o.c(a).bottomButtonBar.setFlashButtonEnabled(o.b(a).a());
        } else
        if (i == as.i)
        {
            o.c(a).showHelpView();
            o.b(a).b(true);
            o.b(a).c(o.a(a).e());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
