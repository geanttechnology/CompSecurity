// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.support.v4.view.ViewPager;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, i, f

class a
    implements android.support.v4.view.angeListener
{

    final StickerFragment a;

    public void onPageScrollStateChanged(int j)
    {
    }

    public void onPageScrolled(int j, float f1, int k)
    {
    }

    public void onPageSelected(int j)
    {
        StickerFragment.g(a).a(j);
        f f1 = (f)StickerFragment.e(a).getAdapter();
        if (f1 != null && !f1.a())
        {
            f1.a(j);
        }
    }

    geListener(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
