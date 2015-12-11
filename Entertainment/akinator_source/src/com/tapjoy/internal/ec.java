// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            du

public final class ec extends RuntimeException
{

    private final List a = null;

    public ec()
    {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final du a()
    {
        return new du(getMessage());
    }
}
