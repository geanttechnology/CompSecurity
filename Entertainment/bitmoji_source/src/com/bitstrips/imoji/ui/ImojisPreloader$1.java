// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.models.Imoji;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojisPreloader

class val.imoji
    implements Callback
{

    final ImojisPreloader this$0;
    final Imoji val$imoji;
    final Picasso val$picasso;

    public void onError()
    {
        ImojisPreloader.access$000(ImojisPreloader.this, val$picasso, val$imoji);
    }

    public void onSuccess()
    {
        ImojisPreloader.access$000(ImojisPreloader.this, val$picasso, val$imoji);
    }

    ()
    {
        this$0 = final_imojispreloader;
        val$picasso = picasso1;
        val$imoji = Imoji.this;
        super();
    }
}
