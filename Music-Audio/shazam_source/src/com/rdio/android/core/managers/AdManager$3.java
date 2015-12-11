// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.google.a.g.a.h;
import com.rdio.android.core.util.Logging;

// Referenced classes of package com.rdio.android.core.managers:
//            AdManager

class this._cls0
    implements h
{

    final AdManager this$0;

    public void onFailure(Throwable throwable)
    {
        AdManager.access$300(AdManager.this).log(6, "AdManager", "Failed to make GET request!");
    }

    public void onSuccess(Object obj)
    {
        AdManager.access$300(AdManager.this).log(3, "AdManager", "Completed GET request.");
    }

    ()
    {
        this$0 = AdManager.this;
        super();
    }
}
