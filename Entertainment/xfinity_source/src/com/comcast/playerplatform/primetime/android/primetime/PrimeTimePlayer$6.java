// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.primetime;

import com.adobe.ave.drm.DRMOperationErrorCallback;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;

// Referenced classes of package com.comcast.playerplatform.primetime.android.primetime:
//            PrimeTimePlayer

class this._cls0
    implements DRMOperationErrorCallback
{

    final PrimeTimePlayer this$0;

    public void OperationError(long l, long l1, Exception exception)
    {
        PrimeTimePlayer.access$200(PrimeTimePlayer.this).e("DRM Operation Error", exception.getMessage());
    }

    ()
    {
        this$0 = PrimeTimePlayer.this;
        super();
    }
}
