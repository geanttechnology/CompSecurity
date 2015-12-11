// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.widget.ProgressBar;
import com.a.b.j;

// Referenced classes of package com.wishabi.flipp.widget:
//            ItemDetailImageView

final class cg
    implements j
{

    final ItemDetailImageView a;

    cg(ItemDetailImageView itemdetailimageview)
    {
        a = itemdetailimageview;
        super();
    }

    public final void a()
    {
        ItemDetailImageView.a(a).setVisibility(8);
        a.requestLayout();
    }

    public final void b()
    {
        ItemDetailImageView.a(a).setVisibility(8);
        a.requestLayout();
    }
}
