// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.View;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, StickerObj, g, f

class a
    implements android.view.er
{

    final StickerFragment a;

    public void onClick(View view)
    {
        StickerFragment.a(a, (StickerObj)view.getTag());
        StickerFragment.a(a, null);
        if (StickerFragment.a(a) != null)
        {
            if (StickerFragment.b(a).equals(de.a))
            {
                int ai[] = new int[2];
                view.getLocationInWindow(ai);
                StickerFragment.a(a, ai, Pair.create(Integer.valueOf(view.getWidth()), Integer.valueOf(view.getHeight())), StickerFragment.a(a));
                return;
            }
            if (StickerFragment.c(a) != null)
            {
                StickerFragment.c(a).a(StickerFragment.d(a));
            }
            view = (f)StickerFragment.e(a).getAdapter();
            if (view != null)
            {
                view.a(StickerFragment.e(a).getCurrentItem(), StickerFragment.a(a));
            }
            if (StickerFragment.c(a) != null)
            {
                StickerFragment.c(a).a(StickerFragment.a(a));
                return;
            }
        }
    }

    de(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
