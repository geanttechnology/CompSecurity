// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.text.style.URLSpan;
import android.view.View;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bb

final class cq extends URLSpan
{

    private bb a;

    cq(URLSpan urlspan, bb bb1)
    {
        super(urlspan.getURL());
        a = bb1;
    }

    public final void onClick(View view)
    {
        a.a();
        super.onClick(view);
    }
}
