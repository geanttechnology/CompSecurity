// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractScheduledService

class this._cls1
    implements Supplier
{

    final ate this$1;

    public volatile Object get()
    {
        return get();
    }

    public String get()
    {
        String s = serviceName();
        String s1 = String.valueOf(ate());
        return (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(s1).length())).append(s).append(" ").append(s1).toString();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
