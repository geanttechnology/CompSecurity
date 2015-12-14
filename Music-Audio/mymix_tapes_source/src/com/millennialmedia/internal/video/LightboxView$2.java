// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView, MMVideoView

class this._cls0
    implements android.view.tener
{

    final LightboxView this$0;

    public void onClick(View view)
    {
        LightboxView.access$102(LightboxView.this, false);
        LightboxView.access$200(LightboxView.this).setVisibility(8);
        LightboxView.access$300(LightboxView.this).restart();
        if (LightboxView.access$400(LightboxView.this) == 4)
        {
            LightboxView.access$500(LightboxView.this, 0L, 500L);
        }
    }

    ()
    {
        this$0 = LightboxView.this;
        super();
    }
}
