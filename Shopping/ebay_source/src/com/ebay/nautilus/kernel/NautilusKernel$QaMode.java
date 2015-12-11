// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.util.Log;

// Referenced classes of package com.ebay.nautilus.kernel:
//            NautilusKernel

static final class isQaMode
{

    public final boolean isQaMode;

    public ()
    {
        this(Log.isLoggable("fwUseQaServers", 3));
    }

    public <init>(boolean flag)
    {
        isQaMode = flag;
    }
}
