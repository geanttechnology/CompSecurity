// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.cyberlink.you.activity:
//            StickerShopAcitvity

class a
    implements android.view.hopAcitvity._cls2
{

    final StickerShopAcitvity a;

    public void onClick(View view)
    {
        if (StickerShopAcitvity.a(a))
        {
            view = new Intent();
            view.putExtra("isChanged", StickerShopAcitvity.a(a));
            a.setResult(-1, view);
        }
        a.finish();
    }

    (StickerShopAcitvity stickershopacitvity)
    {
        a = stickershopacitvity;
        super();
    }
}
