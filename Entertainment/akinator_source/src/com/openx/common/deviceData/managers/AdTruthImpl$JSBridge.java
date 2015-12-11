// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.common.deviceData.managers;

import com.openx.common.deviceData.listeners.PreferenceListener;
import com.openx.core.sdk.OXMManagersResolver;

// Referenced classes of package com.openx.common.deviceData.managers:
//            AdTruthImpl

class this._cls0
{

    final AdTruthImpl this$0;

    public void handleResponse(String s)
    {
        OXMManagersResolver.getInstance().getPreferencesManager().saveAdTruthValue(s, false);
    }

    ()
    {
        this$0 = AdTruthImpl.this;
        super();
    }
}
