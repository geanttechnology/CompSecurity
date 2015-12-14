// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;


// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView, MMVideoView

class this._cls0
    implements com.millennialmedia.internal.utils.bilityListener
{

    final LightboxView this$0;

    public void onViewableChanged(boolean flag)
    {
label0:
        {
            if (!LightboxView.access$100(LightboxView.this))
            {
                if (!flag)
                {
                    break label0;
                }
                LightboxView.access$300(LightboxView.this).start();
            }
            return;
        }
        LightboxView.access$300(LightboxView.this).pause();
    }

    bilityListener()
    {
        this$0 = LightboxView.this;
        super();
    }
}
