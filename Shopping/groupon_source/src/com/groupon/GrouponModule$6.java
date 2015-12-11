// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import com.google.inject.Provider;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

// Referenced classes of package com.groupon:
//            GrouponModule

class this._cls0
    implements Provider
{

    final GrouponModule this$0;

    public Bus get()
    {
        return new Bus(ThreadEnforcer.ANY);
    }

    public volatile Object get()
    {
        return get();
    }

    rcer()
    {
        this$0 = GrouponModule.this;
        super();
    }
}
