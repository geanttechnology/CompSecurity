// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


// Referenced classes of package com.mopub.mraid:
//            MraidController, MraidNativeCommandHandler, MraidBridge

class this._cls0
    implements Runnable
{

    final MraidController this$0;

    public void run()
    {
        MraidController.access$200(MraidController.this).notifySupports(MraidController.access$700(MraidController.this).isSmsAvailable(MraidController.access$600(MraidController.this)), MraidController.access$700(MraidController.this).isTelAvailable(MraidController.access$600(MraidController.this)), MraidNativeCommandHandler.isCalendarAvailable(MraidController.access$600(MraidController.this)), MraidNativeCommandHandler.isStorePictureSupported(MraidController.access$600(MraidController.this)), MraidController.access$800(MraidController.this));
        MraidController.access$200(MraidController.this).notifyPlacementType(MraidController.access$900(MraidController.this));
        MraidController.access$200(MraidController.this).notifyViewability(MraidController.access$200(MraidController.this).isVisible());
        MraidController.access$200(MraidController.this).notifyReady();
    }

    Handler()
    {
        this$0 = MraidController.this;
        super();
    }
}
