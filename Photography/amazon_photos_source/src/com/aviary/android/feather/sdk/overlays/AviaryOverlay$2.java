// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.overlays;


// Referenced classes of package com.aviary.android.feather.sdk.overlays:
//            AviaryOverlay

class this._cls0
    implements Runnable
{

    final AviaryOverlay this$0;

    public void run()
    {
        calculatePositions();
        trackTutorialOpened();
        doShow();
    }

    ()
    {
        this$0 = AviaryOverlay.this;
        super();
    }
}
