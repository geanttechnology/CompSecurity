// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.models.BitshopPack;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BitshopActivity

class this._cls0
    implements com.bitstrips.imoji.ui.adapters.ickListener
{

    final BitshopActivity this$0;

    public void onPackClick(BitshopPack bitshoppack)
    {
        purchasePack(bitshoppack);
    }

    er.PackClickListener()
    {
        this$0 = BitshopActivity.this;
        super();
    }
}
