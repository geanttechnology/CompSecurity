// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.view.View;
import com.jumio.netswipe.sdk.core.NetswipeCardInformation;
import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, bm

class w
    implements android.view.View.OnClickListener
{

    final o a;

    w(o o1)
    {
        a = o1;
        super();
    }

    public void onClick(View view)
    {
        if (o.f(a) == null)
        {
            o.a(a, new NetswipeCardInformation());
        }
        o.c(a).manualEntryView.a(o.f(a));
        a.a(false, false);
    }
}
