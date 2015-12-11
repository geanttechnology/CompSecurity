// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.text.SimpleDateFormat;

// Referenced classes of package com.tapjoy.internal:
//            ab

static final class t extends ThreadLocal
{

    protected final Object initialValue()
    {
        return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
    }

    t()
    {
    }
}
