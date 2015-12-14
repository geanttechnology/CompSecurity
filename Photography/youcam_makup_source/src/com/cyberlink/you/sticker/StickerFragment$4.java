// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, g

class a
    implements android.view.er
{

    final StickerFragment a;

    public void onClick(View view)
    {
        if (StickerFragment.c(a) != null)
        {
            StickerFragment.c(a).a(StickerFragment.a(a));
        }
        StickerFragment.y(a).dismiss();
    }

    (StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
