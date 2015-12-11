// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.base;


// Referenced classes of package org.roboguice.shaded.goole.common.base:
//            Ticker, Platform

static final class  extends Ticker
{

    public long read()
    {
        return Platform.systemNanoTime();
    }

    ()
    {
    }
}
