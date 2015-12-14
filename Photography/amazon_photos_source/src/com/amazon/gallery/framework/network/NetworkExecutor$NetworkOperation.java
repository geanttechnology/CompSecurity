// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network;

import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;

// Referenced classes of package com.amazon.gallery.framework.network:
//            NetworkExecutor

public static interface 
{

    public abstract Object get()
        throws TerminalException, TransientException;
}
