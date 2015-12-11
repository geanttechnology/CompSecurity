// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import egf;

// Referenced classes of package com.google.android.speech.params:
//            RequestIdGenerator

class this._cls0
    implements egf
{

    final questId this$0;

    public volatile Object get()
    {
        return get();
    }

    public String get()
    {
        return RequestIdGenerator.INSTANCE.newRequestId();
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
