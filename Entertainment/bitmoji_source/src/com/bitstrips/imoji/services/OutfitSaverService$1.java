// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.bitstrips.imoji.services:
//            OutfitSaverService

class this._cls0 extends BroadcastReceiver
{

    final OutfitSaverService this$0;

    public void onReceive(Context context, Intent intent)
    {
        int i = intent.getIntExtra("OutfitIDExtra", 0);
        saveOutfit(i);
    }

    ()
    {
        this$0 = OutfitSaverService.this;
        super();
    }
}
