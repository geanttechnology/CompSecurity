// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;


// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, j

class a
    implements Runnable
{

    final StickerFragment a;

    public void run()
    {
        StickerFragment.k(a).notifyDataSetChanged();
    }

    (StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
