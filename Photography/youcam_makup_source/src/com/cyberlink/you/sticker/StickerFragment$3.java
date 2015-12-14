// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment

class a
    implements android.content.DismissListener
{

    final StickerFragment a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        StickerFragment.x(a).setVisibility(8);
    }

    tener(StickerFragment stickerfragment)
    {
        a = stickerfragment;
        super();
    }
}
