// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.ImageView;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class this._cls0
    implements Runnable
{

    final LightboxView this$0;

    public void run()
    {
        if (LightboxView.access$400(LightboxView.this) == 4)
        {
            LightboxView.access$700(LightboxView.this).setVisibility(0);
            LightboxView.access$700(LightboxView.this).setAlpha(1.0F);
        }
        LightboxView.access$200(LightboxView.this).setVisibility(0);
    }

    ()
    {
        this$0 = LightboxView.this;
        super();
    }
}
