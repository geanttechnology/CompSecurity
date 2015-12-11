// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.View;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, au, c

class t
    implements android.view.View.OnClickListener
{

    final o a;

    t(o o1)
    {
        a = o1;
        super();
    }

    public void onClick(View view)
    {
        o.c(a).closeHelpView();
        o.c(a).bottomButtonBar.b();
        o.b(a).h();
        o.b(a).m();
    }
}
