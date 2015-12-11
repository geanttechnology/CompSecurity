// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;
import android.widget.ProgressBar;
import com.squareup.picasso.Callback;

// Referenced classes of package com.offerup.android.g.a:
//            p

final class s
    implements Callback
{

    private p a;

    s(p p1)
    {
        a = p1;
        super();
    }

    public final void onError()
    {
        p.d(a).setVisibility(4);
        p.e(a).setVisibility(0);
    }

    public final void onSuccess()
    {
        p.d(a).setVisibility(4);
        p.e(a).setVisibility(4);
    }
}
