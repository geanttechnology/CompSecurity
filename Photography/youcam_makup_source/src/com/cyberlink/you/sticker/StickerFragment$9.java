// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.view.View;
import com.rockerhieu.emojicon.emoji.Emojicon;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, g

class a
    implements android.view.er
{

    final StickerFragment a;

    public void onClick(View view)
    {
        StickerFragment.a(a, (Emojicon)view.getTag());
        StickerFragment.a(a, null);
        while (StickerFragment.d(a) == null || StickerFragment.c(a) == null) 
        {
            return;
        }
        StickerFragment.c(a).a(StickerFragment.d(a));
    }

    (StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
