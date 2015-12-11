// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            HelpActivity

final class ci
    implements android.view.View.OnClickListener
{

    final HelpActivity a;

    ci(HelpActivity helpactivity)
    {
        a = helpactivity;
        super();
    }

    public final void onClick(View view)
    {
        a.finish();
    }
}
