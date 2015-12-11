// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import com.gotv.crackle.Application;
import com.gotv.crackle.base.BaseActivity;
import java.lang.ref.WeakReference;

// Referenced classes of package com.gotv.crackle.data:
//            Localization, DataRequest

class this._cls0
    implements Runnable
{

    final Localization this$0;

    public void run()
    {
        Localization.access$102(Localization.this, estState.FAILED);
        Localization.access$002(Localization.this, "UNREACHABLE");
        ((BaseActivity)Application.getInstance().getCurrentActivity().get()).onDataFailed("GetLocation", DataRequest.getURIExceptionString(1200));
    }

    estState()
    {
        this$0 = Localization.this;
        super();
    }
}
