// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.widget.ProgressBar;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements Runnable
{

    final a a;

    public final void run()
    {
        if (MraidView.l(a.a) != null)
        {
            MraidView.l(a.a).setVisibility(8);
        }
        (new Thread(new <init>(a))).start();
    }

    ( )
    {
        a = ;
        super();
    }
}
