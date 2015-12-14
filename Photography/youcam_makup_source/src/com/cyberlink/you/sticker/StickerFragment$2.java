// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class a
    implements android.content.ShowListener
{

    final StickerFragment a;

    public void onShow(DialogInterface dialoginterface)
    {
        StickerFragment.x(a).setVisibility(0);
    }

    er(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
