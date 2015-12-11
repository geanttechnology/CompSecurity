// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            Deadline

static final class  extends Deadline
{

    public boolean reached()
    {
        return false;
    }

    public Deadline start(long l, TimeUnit timeunit)
    {
        throw new UnsupportedOperationException();
    }

    ()
    {
    }
}
