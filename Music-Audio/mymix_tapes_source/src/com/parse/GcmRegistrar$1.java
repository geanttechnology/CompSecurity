// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            GcmRegistrar

static final class able
    implements Callable
{

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
    {
        GcmRegistrar.getInstance().update();
        return null;
    }

    able()
    {
    }
}
