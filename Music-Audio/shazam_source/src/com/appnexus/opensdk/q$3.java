// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.appnexus.opensdk:
//            q

final class a
    implements android.view..OnClickListener
{

    final q a;

    public final void onClick(View view)
    {
        q.b(a).goForward();
    }

    Listener(q q1)
    {
        a = q1;
        super();
    }
}
