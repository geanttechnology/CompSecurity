// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.passenger;

import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.rx.SimpleSubscriber;

// Referenced classes of package me.lyft.android.ui.passenger:
//            PassengerRequestRideView

class this._cls0 extends SimpleSubscriber
{

    final PassengerRequestRideView this$0;

    public void onError(Throwable throwable)
    {
        super.onError(throwable);
        defaultErrorHandler.handle(throwable);
    }

    ()
    {
        this$0 = PassengerRequestRideView.this;
        super();
    }
}
