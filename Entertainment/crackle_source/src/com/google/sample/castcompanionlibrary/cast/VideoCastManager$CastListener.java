// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;


// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            VideoCastManager

class this._cls0 extends com.google.android.gms.cast.er.CastListener
{

    final VideoCastManager this$0;

    public void onApplicationDisconnected(int i)
    {
        VideoCastManager.access$500(VideoCastManager.this, i);
    }

    public void onApplicationStatusChanged()
    {
        VideoCastManager.access$600(VideoCastManager.this);
    }

    public void onVolumeChanged()
    {
        VideoCastManager.access$700(VideoCastManager.this);
    }

    ()
    {
        this$0 = VideoCastManager.this;
        super();
    }
}
