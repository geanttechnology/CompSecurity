// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import it.sephiroth.android.library.picasso.Callback;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel

class Holder
    implements Callback
{

    final StickersPanel this$0;
    final Holder val$holder;
    final boolean val$shouldShake;

    public void onError()
    {
    }

    public void onSuccess()
    {
        if (val$shouldShake)
        {
            StickersPanel.access$1300(StickersPanel.this, val$holder);
            StickersPanel.access$1402(StickersPanel.this, -1L);
        }
    }

    Holder()
    {
        this$0 = final_stickerspanel;
        val$shouldShake = flag;
        val$holder = Holder.this;
        super();
    }
}
