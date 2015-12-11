// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.views;

import android.view.View;

// Referenced classes of package com.offerup.android.views:
//            PhotoStripView

final class a
    implements android.view.View.OnClickListener
{

    private PhotoStripView a;

    a(PhotoStripView photostripview)
    {
        a = photostripview;
        super();
    }

    public final void onClick(View view)
    {
        PhotoStripView.a(a, view);
    }
}
