// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.mShop.feature.FeatureStateSubscriber;
import java.util.List;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupSequenceMediator

class this._cls0
    implements FeatureStateSubscriber
{

    final StartupSequenceMediator this$0;

    public void onCancel()
    {
        endTask("taskGetFeatureState", "taskResultSucceed");
    }

    public void onError(Exception exception)
    {
        endTask("taskGetFeatureState", "taskResultFail");
    }

    public void onFeatureStateReceived(List list)
    {
        endTask("taskGetFeatureState", "taskResultSucceed");
    }

    _cls9()
    {
        this$0 = StartupSequenceMediator.this;
        super();
    }
}
