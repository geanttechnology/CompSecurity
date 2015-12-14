// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.cyberlink.you.database.StickerPackObj;

// Referenced classes of package com.cyberlink.you.activity:
//            StickerShopDetailActivity

class a
    implements android.view.ailActivity._cls2
{

    final StickerShopDetailActivity a;

    public void onClick(View view)
    {
        if (StickerShopDetailActivity.b(a) != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((view = StickerShopDetailActivity.b(a).o()) == null) goto _L1; else goto _L3
_L3:
        if (view.isEmpty()) goto _L1; else goto _L4
_L4:
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(view));
        a.startActivity(intent);
        return;
        view;
        Log.d("StickerShopDetailACT", Log.getStackTraceString(view));
        return;
    }

    (StickerShopDetailActivity stickershopdetailactivity)
    {
        a = stickershopdetailactivity;
        super();
    }
}
